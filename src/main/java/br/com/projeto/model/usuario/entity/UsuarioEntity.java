package br.com.projeto.model.usuario.entity;

import br.com.projeto.model.usuario.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "usuario")
@Entity(name = "UsuarioEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String nome;
    private String email;
    private String senha;
	private Boolean ativo;
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "tipousuario_id")
    private TipoUsuarioEntity tipo;

    @Embedded
    private EnderecoEntity endereco;
    
    public UsuarioEntity(UsuarioDTO usuarioDTO) {
		this.id = usuarioDTO.getId();
		this.nome = usuarioDTO.getNome();
    	this.email = usuarioDTO.getEmail();
    	this.senha = usuarioDTO.getSenha();
    	this.tipo = new TipoUsuarioEntity(usuarioDTO.getTipo());
		this.data = usuarioDTO.getData();
		this.ativo = usuarioDTO.getAtivo();
    	this.endereco = new EnderecoEntity(usuarioDTO.getEndereco());
	}
    
}
