package br.com.projeto.controller.web;

import br.com.projeto.model.usuario.dto.EnderecoUsuarioDTO;
import br.com.projeto.model.usuario.dto.UsuarioDTO;
import br.com.projeto.model.usuario.entity.TipoUsuarioEntity;
import br.com.projeto.model.usuario.entity.UsuarioEntity;
import br.com.projeto.repository.tipousuario.TipoUsuarioRepository;
import br.com.projeto.repository.usuario.LogradouroEnum;
import br.com.projeto.repository.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/usuario")
    public String crudUsuario(Model model) {

        List<UsuarioEntity> Usuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuariosModel", Usuarios);

        List<TipoUsuarioEntity> tiposUsuario = tipoUsuarioRepository.findAll();
        model.addAttribute("tiposUsuarioModel", tiposUsuario);

        //Prepara Modelo do usuario para o formulario
        UsuarioDTO usuarioModel = new UsuarioDTO();
        usuarioModel.setEndereco(new EnderecoUsuarioDTO());
        model.addAttribute("usuarioModel", usuarioModel);

        //Prepara uma lista de tipos de logradouro
        model.addAttribute("tiposLogradouros", LogradouroEnum.values());

        return "usuario/usuarioCrud";
    }

    /**
     * @param usuarioModel Dados recebidos(JSON) e já convertidos/MAPeados para a classe UsuarioDTO
     * @return retorna para a pagina principal
     */
    @PostMapping("/inserirUsuario")
    @Transactional
    public String inserirUsuario(@Valid final UsuarioDTO usuarioModel, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            //return "usuario/usuarioCrud"; //Perde os Objetos (carrega a pagina literalmente, sem tratamento)
            return "redirect:/usuario"; //Limpa Radio Button
        }

        usuarioRepository.save(new UsuarioEntity(usuarioModel));
        return "redirect:/usuario";
    }
}
