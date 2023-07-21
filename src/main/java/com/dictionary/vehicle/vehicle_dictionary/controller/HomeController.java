package com.dictionary.vehicle.vehicle_dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер, отвечающий за адрес 127.0.0.1:8080/
 * При переходе на этот сайт появится главная страница
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

}
