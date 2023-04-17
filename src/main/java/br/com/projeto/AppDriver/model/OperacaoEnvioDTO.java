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
@JacksonXmlRootElement(localName = "Envio")
public class OperacaoEnvioDTO {

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String operacao = "4052";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String iselicCedente = "85858585";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String iselicCessionario = "95959595";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String codigoTitulo = "760100";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String dataVencimento = "2023-03-15";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String precoUnitario = "96301.745203";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String quantidadeTitulos = "700";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String parte = "CESSIONARIO";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String dataLiquidacao = "2021-06-27";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String dataMovimento = "2021-06-25";

        @NotBlank
        @JacksonXmlProperty(isAttribute = false)
        private String departamento = "001";
}
