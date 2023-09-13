package bruno.luis.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bruno.luis.springproject.model.Product;
import bruno.luis.springproject.service.IOrderService;
import bruno.luis.springproject.service.IUserService;
import bruno.luis.springproject.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService produtoService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public String home(Model model) {

        List<Product> products = produtoService.findAll();
        model.addAttribute("products", products);

        return "admin/home";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "admin/orders";
    }

}
