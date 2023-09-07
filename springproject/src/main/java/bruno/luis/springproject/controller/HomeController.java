package bruno.luis.springproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

import bruno.luis.springproject.model.DetailOrder;
import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.model.Product;
import bruno.luis.springproject.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;

    // Para almacenar los productos que se agregan al carrito
    List<DetailOrder> details = new ArrayList<DetailOrder>();
    // Para almacenar el pedido
    Order order = new Order();

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "user/home";
    }

    @GetMapping("producthome/{id}")
    public String productHome(@PathVariable Integer id, Model model) {
        log.info("Id producto enviado como parametro", id);
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        product = optionalProduct.get();
        model.addAttribute("product", product);
        return "user/producthome";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer quantity, Model model) {
        DetailOrder detail = new DetailOrder();
        Product product = new Product();
        double total = 0;
        Optional<Product> optionalProduct = productService.get(id);
        log.info("Producto añadido: {}", optionalProduct.get());
        log.info("Cantidad: {}", quantity);
        product = optionalProduct.get();
        detail.setQuantity(quantity);
        detail.setPrice(product.getPrice());
        detail.setName(product.getName());
        detail.setTotal(product.getPrice() * quantity);
        detail.setProduct(product);

        // Validar que el producto no se añade dos veces
        Integer idProduct = product.getId();
        boolean exist = details.stream().anyMatch(o -> o.getProduct().getId().equals(idProduct));
        if (!exist) {
            details.add(detail);
        }

        // Calcular el total
        total = details.stream().mapToDouble(o -> o.getTotal()).sum();

        order.setTotal(total);
        model.addAttribute("cart", details);
        model.addAttribute("order", order);
        return "user/carrito";
    }

    // Quitar un producto del carrito
    @GetMapping("/delete/cart/{id}")
    public String deleteProductCart(@PathVariable Integer id, Model model) {
        // Lista nueva de productos
        List<DetailOrder> newOrders = new ArrayList<DetailOrder>();
        for (DetailOrder detail : details) {
            if (!Objects.equals(detail.getProduct().getId(), id)) {
                newOrders.add(detail);
            }
        }
        // Poner la lista nueva con los productos que quedan
        details = newOrders;

        double sumaTotal = 0;
        sumaTotal = details.stream().mapToDouble(o -> o.getTotal()).sum();

        order.setTotal(sumaTotal);
        model.addAttribute("cart", details);
        model.addAttribute("order", order);

        return "user/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model model) {
        model.addAttribute("cart", details);
        model.addAttribute("order", order);
        return "user/carrito";
    }

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("cart", details);
        model.addAttribute("order", order);
        return "user/overvieworder";

    }

}
