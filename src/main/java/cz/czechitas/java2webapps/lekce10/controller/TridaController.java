package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.StudentService;
import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TridaController {
    private final TridaService tridaService;
    private final StudentService studentService;

    public TridaController(TridaService tridaService, StudentService studentService) {
        this.tridaService = tridaService;
        this.studentService = studentService;
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
    @GetMapping ("/student/{id}" )
    public ModelAndView detailStudenta (@PathVariable int id){
        return new ModelAndView("detailStudenta")
                .addObject("student", studentService.dejJednoho(id));
    }
}
