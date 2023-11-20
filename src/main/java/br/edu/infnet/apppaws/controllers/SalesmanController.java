package br.edu.infnet.apppaws.controllers;

import br.edu.infnet.apppaws.models.domains.Salesman;
import br.edu.infnet.apppaws.models.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SalesmanController {

    @Autowired
    private AppController appController;

    @Autowired
    private SalesmanService salesmanService;

    @GetMapping(value = "/vendedor/pesquisar")
    public String search(Model model, String campoBusca) {

        Salesman salesman = salesmanService.search(campoBusca);

        if(salesman != null) {
            model.addAttribute("obj", salesman);
            return appController.showHome(model);
        }
        return "redirect:/vendedor/lista";
    }


    @GetMapping(value = "/vendedor/{codId}/excluir")
    public String exclude(@PathVariable Integer codId) {

        salesmanService.exclude(codId);

        return "redirect:/vendedor/list";
    }

    @GetMapping(value = "/vendedor/list")
    public String getList(Model model) {

        model.addAttribute("route", "vendedor");
        model.addAttribute("title", "Vendedores:");
        model.addAttribute("list", salesmanService.getAllList());

        return appController.showHome(model);
    }
}
