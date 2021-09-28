package br.com.tlmacedo.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    PersonRepository _personRepository;

    @RequestMapping("/pessoas")
    public String listaPessoas(Model model) {
        model.addAttribute("pessoas", _personRepository.findAll());
        return "lista-pessoas";
    }

    @GetMapping("/add-pessoa")
    public String pessoaForm(Model model) {
        model.addAttribute("person", new Person());
        return "pessoaForm";
    }

    @PostMapping("/pessoa-process")
    public String processForm(@Valid Person person, BindingResult result) {
        if (result.hasErrors())
            return "pessoaForm";

        _personRepository.save(person);
        return "redirect:/";
    }
}
