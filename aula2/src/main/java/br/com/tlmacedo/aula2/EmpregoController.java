package br.com.tlmacedo.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class EmpregoController {

    @Autowired
    EmpregoRepository _empregoRepository;

    @RequestMapping("/empregos")
    public String listaEmpregos(Model model) {
        model.addAttribute("empregos", _empregoRepository.findAll());
        return "lista-empregos";
    }

    @GetMapping("/add-emprego")
    public String empregoForm(Model model) {
        model.addAttribute("emprego", new Emprego());
        return "empregoForm";
    }

    @PostMapping("/emprego-process")
    public String processForm(@Valid Emprego emprego, BindingResult result) {
        if (result.hasErrors())
            return "empregoForm";
        _empregoRepository.save(emprego);
        return "redirect:/";
    }
}
