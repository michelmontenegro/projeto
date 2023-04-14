package br.com.projeto.controller.rest.xml;

import br.com.projeto.model.usuario.dto.UsuarioDTO;
import br.com.projeto.model.usuario.entity.UsuarioEntity;
import br.com.projeto.repository.tipousuario.TipoUsuarioRepository;
import br.com.projeto.repository.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Rest/Usuario/XML")
public class UsuarioRestXMLController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(produces= {MediaType.APPLICATION_XML_VALUE})
    public List<UsuarioDTO> consultar() {
        List<UsuarioEntity> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(UsuarioDTO::new).toList();
    }
}
