package br.com.projeto.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexWebController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/apresentacao")
    public String apresentacao(@RequestParam(name="nome", required=false, defaultValue="Usuario Padrao") String pName, Model model) {
        model.addAttribute("nome", pName);
        model.addAttribute("msg", "Bem vindo!");
        return "apresentacao/apresentacao";
    }
}
