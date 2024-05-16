package yg.spring.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf/ex1")
    public String ex1(Model model){

        Point p = new Point(10,20);
        model.addAttribute("data", p);
        return "thymeleaf/ex1";
    }
}
