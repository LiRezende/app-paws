package br.edu.infnet.apppaws.controllers;

import br.edu.infnet.apppaws.models.services.*;
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

    @Autowired
    private InformationService informationService;

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("information", informationService.getList());

        model.addAttribute("qtdSalesman", salesmanService.getQuantity());
        model.addAttribute("qtdProduct", productService.getQuantity());
        model.addAttribute("qtdToy", toyService.getQuantity());
        model.addAttribute("qtdFarmacy", farmacyService.getQuantity());

        return "home";
    }

    @GetMapping(value = "/produto/list")
    public String getProductList(Model model) {

        model.addAttribute("title", "Produtos:");
        model.addAttribute("list", productService.getAllList());

        return showHome(model);
    }

    @GetMapping(value = "/brinquedo/list")
    public String getToyList(Model model) {

        model.addAttribute("title", "Produtos Alimentícios:");
        model.addAttribute("list", toyService.getAllList());

        return showHome(model);
    }

    @GetMapping(value = "/farmaceutico/list")
    public String getFarmacyList(Model model) {

        model.addAttribute("title", "Produtos Eletrônicos:");
        model.addAttribute("list", farmacyService.getAllList());

        return showHome(model);
    }
}
