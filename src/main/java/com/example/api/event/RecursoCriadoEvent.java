package com.example.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long isbn;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long isbn) {
		super(source);
		this.response = response;
		this.isbn = isbn;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getIsbn() {
		return isbn;
	}

}
