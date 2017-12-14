package com.example.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		String isbn = recursoCriadoEvent.getIsbn();
		
		adicionarHeaderLocation(response, isbn);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, String isbn) {
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{isbn}")
				.buildAndExpand(isbn).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}
