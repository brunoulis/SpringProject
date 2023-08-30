package bruno.luis.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bruno.luis.springproject.model.Product;
import bruno.luis.springproject.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService produtoService;

    @GetMapping("")
    public String home(Model model) {

        List<Product> products = produtoService.findAll();
        model.addAttribute("products", products);
        
        return "admin/home";
    }

}
