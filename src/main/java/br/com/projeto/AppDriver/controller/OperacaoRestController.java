package br.com.projeto.AppDriver.controller;

import br.com.projeto.AppDriver.model.OperacaoEnvioDTO;
import br.com.projeto.model.usuario.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class OperacaoRestController {

    @PostMapping
    @RequestMapping("/api/negocios")
    public OperacaoEnvioDTO enviar(@RequestHeader Map<String, String> headers) {
        headers.put("Content-Type","application/json");
        return new OperacaoEnvioDTO();
    }
}
