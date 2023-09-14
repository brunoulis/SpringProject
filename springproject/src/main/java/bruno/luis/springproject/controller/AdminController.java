package bruno.luis.springproject.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bruno.luis.springproject.model.Order;
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

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

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

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        log.info("Id de la orden {}", id);
        Order order = orderService.findById(id).get();
        model.addAttribute("details", order.getDetail());
        return "admin/detailorder";
    }

}
