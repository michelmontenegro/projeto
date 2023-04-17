package br.com.projeto.soap;

import localhost._8080.negocio.PostNegocioRequestPayload;
import localhost._8080.negocio.PostNegocioResponsePayload;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public interface NegocioAPI {

    PostNegocioResponsePayload lancarNegocios(@RequestBody PostNegocioRequestPayload request);
}
