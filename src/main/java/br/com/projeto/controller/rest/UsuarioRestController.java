package br.com.projeto.controller.rest;

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

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Rest/Usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping
    public List<UsuarioDTO> consultar(Long id) {
        List<UsuarioEntity> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(UsuarioDTO::new).toList();
    }

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioRepository.save(new UsuarioEntity(usuarioDTO));
    }



}
