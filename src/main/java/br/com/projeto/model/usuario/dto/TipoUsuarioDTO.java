package br.com.projeto.model.usuario.dto;

import br.com.projeto.model.usuario.entity.TipoUsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoUsuarioDTO{

    Long id;

    @NotBlank(message = "Campo em Branco")
    String nome;

    TipoUsuarioDTO (TipoUsuarioEntity tipoUsuarioEntity){
        this(tipoUsuarioEntity.getId(),tipoUsuarioEntity.getNome());
    }

}