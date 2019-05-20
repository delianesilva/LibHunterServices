package com.deliane.tcc.resources;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deliane.tcc.model.Documento;
import com.deliane.tcc.searcher.Search;
import com.deliane.tcc.service.DocumentoService;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentoResource {

	@Autowired
	private DocumentoService service;
	
	
	@RequestMapping(value = "/titulo/{titulo}",method = RequestMethod.GET)
	public List<Documento> listarPorTitulo(@PathVariable String titulo) {
		return service.buscarPorTitulo(titulo);
		
	}
	
	@RequestMapping(value = "/autor/{autor}",method = RequestMethod.GET)
	public List<Documento> listarPorAutor(@PathVariable String autor) {
		return service.buscarPorAutor(autor);
		
	}
	
	@RequestMapping(value = "/assunto/{assunto}",method = RequestMethod.GET)
	public List<Documento> listarPorAssunto(@PathVariable String assunto) {
		return service.buscarPorAssunto(assunto);
		
	}
	
	@RequestMapping(value = "/todos/{busca}" ,method = RequestMethod.GET)
	public List<Documento> listarTodos(@PathVariable String busca) {
		return service.buscarTodos(busca);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Integer listarTotal() {
		return service.buscarPorTitulo("linguagem").size();
		
	}
}
