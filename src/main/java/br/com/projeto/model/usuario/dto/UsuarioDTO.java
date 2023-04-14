package br.com.projeto.model.usuario.dto;

import br.com.projeto.model.usuario.entity.EnderecoEntity;
import br.com.projeto.model.usuario.entity.TipoUsuarioEntity;
import br.com.projeto.model.usuario.entity.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Embedded;
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
@JacksonXmlRootElement(localName = "Usuario")
public class UsuarioDTO{

        @JacksonXmlProperty(isAttribute = false,localName = "id")
        private Long id;

		@NotBlank
        @JacksonXmlProperty(isAttribute = false,localName = "nome")
        private String nome;

        @Email
        @JacksonXmlProperty(isAttribute = false,localName = "email")
        private String email;

        @NotBlank
        @JacksonXmlProperty(isAttribute = false,localName = "senha")
        private String senha;

        @NotNull
        @JacksonXmlProperty(isAttribute = true,localName = "ativo")
        private Boolean ativo;

        @NotNull
        @JsonFormat(pattern="dd-MM-yyyy")
        @JacksonXmlProperty(isAttribute = true,localName = "data")
        private LocalDate data;

        @NotNull
        @JacksonXmlProperty(isAttribute = true,localName = "tipo")
        private TipoUsuarioDTO tipo;

        @NotNull
        @Valid
        @JacksonXmlProperty(isAttribute = true,localName = "endereco")
        private EnderecoUsuarioDTO endereco;

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
