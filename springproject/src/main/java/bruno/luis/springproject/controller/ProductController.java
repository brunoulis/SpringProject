package bruno.luis.springproject.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bruno.luis.springproject.model.Product;
import bruno.luis.springproject.model.User;
import bruno.luis.springproject.service.IUserService;
import bruno.luis.springproject.service.ProductService;
import bruno.luis.springproject.service.UploadFileService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadFileService upload;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product, @RequestParam("img") MultipartFile file , HttpSession session) throws IOException {
        LOGGER.info("Este es el objeto product: {}", product);
        User u = userService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        product.setUser(u);
        // Imagen
        if (product.getId() == null) {
            String imageName = upload.saveImage(file);
            product.setImage(imageName);
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        product = optionalProduct.get();
        LOGGER.info("Este es el objeto product: {}", product);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product, @RequestParam("img") MultipartFile file) throws IOException {
        Product p = productService.get(product.getId()).orElseThrow(); // Usando orElseThrow para evitar null
        if (file.isEmpty()) { // Editamos el producto pero no se sube una imagen
            // No es necesario hacer ninguna acción aquí
        } else { // Cuando se edita también la imagen
            // Eliminamos la imagen anterior si no es la imagen por defecto
            if (!p.getImage().equals("default.jpg")) {
				upload.deleteImage(p.getImage());
			}
            // Guardamos la nueva imagen
            String imageName = upload.saveImage(file);
            product.setImage(imageName);
        }

        LOGGER.info("Este es el objeto product: {}", product);
        product.setUser(p.getUser());
        productService.update(product);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Product p = new Product();
        p = productService.get(id).get();
        // Eliminamos cuando no sea la imagen por defecto
        if (!p.getImage().equals("default.jpg")) {
            // Si se cumple la condicion
            upload.deleteImage(p.getImage());
        }
        productService.delete(id);
        return "redirect:/products";
    }

}
