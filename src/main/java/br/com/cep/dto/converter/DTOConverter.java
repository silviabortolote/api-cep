package br.com.cep.dto.converter;

public interface DTOConverter<I, O> {
	
	public O convert(I input);

}
