package br.com.projeto.model.usuario.entity;

import br.com.projeto.model.usuario.dto.EnderecoUsuarioDTO;
import br.com.projeto.repository.usuario.LogradouroEnum;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    private Integer numero;
    private String cep;

    @Enumerated(EnumType.STRING)
    private LogradouroEnum logradouro;

    public EnderecoEntity(EnderecoUsuarioDTO enderecoUsuarioDTO) {
		this.cep = enderecoUsuarioDTO.getCep();
        this.numero = enderecoUsuarioDTO.getNumero();
        this.logradouro = enderecoUsuarioDTO.getLogradouro();
	}
}
