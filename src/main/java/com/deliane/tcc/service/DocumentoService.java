package com.deliane.tcc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.stereotype.Service;

import com.deliane.tcc.model.Documento;
import com.deliane.tcc.searcher.Search;

@Service
public class DocumentoService {

	public List<Documento> buscarPorTitulo(String titulo){
		Search search = new Search();
		try {
			
			List<Documento> documentos = search.textInfoSearchStopWords("index","titulo", titulo);
			return documentos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Documento> buscarPorAutor(String autor){
		Search search = new Search();
		try {
			
			List<Documento> documentos = search.textInfoSearchStopWords("index","autor", autor);
			return documentos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Documento> buscarPorAssunto(String assunto){
		Search search = new Search();
		try {
			
			List<Documento> documentos = search.textInfoSearchStopWords("index","assunto", assunto);
			return documentos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Documento> buscarTodos(String busca){
		Search search = new Search();
		List<Documento> todos = new ArrayList<>();
		List<Documento> assuntos = null;
		List<Documento> autores = null;
		List<Documento> titulos = null;
		
		try {
			
			assuntos = search.textInfoSearchStopWords("index","assunto", busca);
			autores = search.textInfoSearchStopWords("index","autor", busca);
			titulos = search.textInfoSearchStopWords("index","titulo", busca);
			
			//return documentos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Documento documento : titulos) {
			todos.add(documento);
		}
		for (Documento documento : autores) {
			todos.add(documento);
		}
		for (Documento documento : assuntos) {
			todos.add(documento);
		} 
		return todos;
	}
	
}
