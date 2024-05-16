package com.ElasTechProjetoFinal.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerenciamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Gerenciamento")
public class GerencimanetoController {

    @Autowired
    private GerencimanetoController gerenciamentoController;

}
