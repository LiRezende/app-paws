package br.edu.infnet.apppaws.controllers;

import br.edu.infnet.apppaws.models.services.FarmacyService;
import br.edu.infnet.apppaws.models.services.ProductService;
import br.edu.infnet.apppaws.models.services.SalesmanService;
import br.edu.infnet.apppaws.models.services.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ToyService toyService;
    @Autowired
    private FarmacyService farmacyService;

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("qtdSalesman", salesmanService.getQuantity());
        model.addAttribute("qtdProduct", productService.getQuantity());
        model.addAttribute("qtdToy", toyService.getQuantity());
        model.addAttribute("qtdFarmacy", farmacyService.getQuantity());

        return "home";
    }

    @GetMapping(value = "/produto/lista")
    public String obterListaProduto(Model model) {

        model.addAttribute("title", "Produtos:");
        model.addAttribute("list", productService.getAllList());

        return showHome(model);
    }

    @GetMapping(value = "/brinquedo/lista")
    public String obterListaAlimenticio(Model model) {

        model.addAttribute("title", "Produtos Alimentícios:");
        model.addAttribute("list", toyService.getAllList());

        return showHome(model);
    }

    @GetMapping(value = "/farmaceutico/lista")
    public String obterListaEletronico(Model model) {

        model.addAttribute("title", "Produtos Eletrônicos:");
        model.addAttribute("list", farmacyService.getAllList());

        return showHome(model);
    }
}
