package br.com.projeto.AppDriver.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JacksonXmlRootElement(localName = "Receber")
public class OperacaoReceberDTO {

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String operacao = "4052";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String id;

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String numeroNegocio;

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String dataMovimento;

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String status;
}