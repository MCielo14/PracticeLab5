package com.example.practice.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/reportes")
    public String reportes(){
        return "reportes";
    }
    @GetMapping("/historial")
    public String historial(){
        return "historial";
    }
    @GetMapping("/empleados")
    public String empleados(){
        return "empleados";
    }

}
