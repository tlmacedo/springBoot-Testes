package br.com.tlmacedo.aula1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homeApp(Model model) {
        model.addAttribute("menssagem", "está mensagem foi injetada atraves do model");
        return "index";
    }
}
