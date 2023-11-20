package br.edu.infnet.apppaws.controllers;

import br.edu.infnet.apppaws.models.domains.Information;
import br.edu.infnet.apppaws.models.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformationController {

    @Autowired
    private InformationService informationService;

    @PostMapping(value = "/informacao/incluir")
    public String incluir(Information information) {

        Information result = informationService.save(information);
        System.out.println("RESULT: " + result);
        return "redirect:/";
    }
}
