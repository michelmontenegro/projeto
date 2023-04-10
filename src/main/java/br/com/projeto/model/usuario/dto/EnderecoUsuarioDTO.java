package br.com.projeto.model.usuario.dto;

import br.com.projeto.model.usuario.entity.EnderecoEntity;
import br.com.projeto.repository.usuario.LogradouroEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnderecoUsuarioDTO {

    private Integer numero;
    private LogradouroEnum logradouro;
    //@Pattern(regexp = "\\d{8}")
    private String cep;

    public EnderecoUsuarioDTO(EnderecoEntity enderecoEntity){
        this(enderecoEntity.getNumero(),enderecoEntity.getLogradouro(), enderecoEntity.getCep());
    }

}
