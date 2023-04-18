package br.com.projeto.controller.rest.xml;

import br.com.projeto.model.usuario.dto.UsuarioDTO;
import br.com.projeto.model.usuario.entity.UsuarioEntity;
import br.com.projeto.repository.tipousuario.TipoUsuarioRepository;
import br.com.projeto.repository.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/Rest/Usuario/XML")
public class UsuarioRestXMLController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(produces= {MediaType.APPLICATION_XML_VALUE})
    public List<UsuarioDTO> consultar(@RequestHeader HttpHeaders headers) {
        headers.add("Content-Type","application/json");
        List<UsuarioEntity> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(UsuarioDTO::new).toList();
    }

    @GetMapping(produces= {MediaType.APPLICATION_XML_VALUE})
    @RequestMapping("idUsuario")
    public UsuarioDTO consultarById(@RequestParam Long id) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        return new UsuarioDTO(usuarioEntity.get());
    }

    @PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE})
    @Transactional
    public String inserir(@RequestBody @Valid UsuarioDTO usuarioDTO, @RequestHeader Map<String, String> headers) {
        headers.put("Content-Type","application/xml");
        usuarioRepository.save(new UsuarioEntity(usuarioDTO));
        return "Sucesso";
    }

}
