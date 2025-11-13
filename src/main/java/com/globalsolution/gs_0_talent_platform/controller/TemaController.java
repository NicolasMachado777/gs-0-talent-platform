package com.globalsolution.gs_0_talent_platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class TemaController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        return ResponseEntity.ok(
            Map.of(
                "tema", "Plataformas que conectam talentos a projetos com propósito",
                "membro1", "Nicolas Machado (RM 552493)",
                "membro2", "José Roberto Claudino (RM 552407)",
                "descricao", "API de integração que expõe informações do tema conforme requisitos da Global Solution."
            )
        );
    }
}