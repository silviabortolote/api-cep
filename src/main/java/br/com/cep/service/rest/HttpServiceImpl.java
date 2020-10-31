package br.com.cep.service.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

import br.com.cep.dto.ViaCepDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HttpServiceImpl implements HttpService  {
	
	private final HttpProvider provider;
	
	@Autowired
    public HttpServiceImpl(HttpProvider provider) {
    	this.provider = provider;
    }

	@Override
	public ViaCepDTO buscarCep(String cep) {
		final Map<String, String> headers = ImmutableMap.<String, String>builder()
                .put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        
        final Map<String, String> queryParams = ImmutableMap.<String, String>builder()
                .put("cid", "9999").build();
        
        log.info("buscarCep: {}",cep);
        
        return provider.get("http://viacep.com.br/ws/"+cep+"/json/", queryParams, headers, ViaCepDTO.class); 
	}

}
