package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TridaController {
    private final TridaService tridaService;

    public TridaController(TridaService tridaService) {
        this.tridaService = tridaService;
    }

    @GetMapping("/")
    public ModelAndView zakladniZobrazeni() {
        return new ModelAndView("index")
                .addObject("trida", tridaService.list());
    }

    @GetMapping("/{id}")
    public ModelAndView detailTridy(@PathVariable int id){
        return new ModelAndView("detailTridy")
                .addObject("trida",tridaService.dejJednu(id));
    }
    //@GetMapping ("/student/{id}" )
}
