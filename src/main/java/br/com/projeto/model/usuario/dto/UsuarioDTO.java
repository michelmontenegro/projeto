package br.com.projeto.model.usuario.dto;

import br.com.projeto.model.usuario.entity.EnderecoEntity;
import br.com.projeto.model.usuario.entity.TipoUsuarioEntity;
import br.com.projeto.model.usuario.entity.UsuarioEntity;
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
public class UsuarioDTO{

        private Long id;

		@NotBlank
        private String nome;

        @Email
        private String email;

        @NotBlank
        private String senha;

        @NotNull
        private TipoUsuarioDTO tipo;

        @NotNull
        @JsonFormat(pattern="dd-MM-yyyy")
        private LocalDate data;

        @NotNull @Valid EnderecoUsuarioDTO endereco;

        @NotNull
        private Boolean ativo;

        public UsuarioDTO(UsuarioEntity usuarioEntity) {
                this.id = usuarioEntity.getId();
                this.nome = usuarioEntity.getNome();
                this.email = usuarioEntity.getEmail();
                this.senha = usuarioEntity.getSenha();
                this.tipo = new TipoUsuarioDTO(usuarioEntity.getTipo());
                this.data = usuarioEntity.getData();
                this.ativo = usuarioEntity.getAtivo();
                this.endereco = new EnderecoUsuarioDTO(usuarioEntity.getEndereco());
        }
}
