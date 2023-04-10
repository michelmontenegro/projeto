package br.com.projeto.model.usuario.entity;

import br.com.projeto.model.usuario.dto.TipoUsuarioDTO;
import br.com.projeto.model.usuario.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "tipousuario")
@Entity(name = "TipoUsuarioEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoUsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;

    public TipoUsuarioEntity(TipoUsuarioDTO tipoUsuarioDTO) {
    	this.nome = tipoUsuarioDTO.getNome();
    	this.id = tipoUsuarioDTO.getId();
	}
    
}
