package com.deliane.tcc.service;

import java.io.IOException;
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
			
			List<Documento> documentos = search.textInfoSearch("index","titulo", titulo);
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
			
			List<Documento> documentos = search.textInfoSearch("index","autor", autor);
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
			
			List<Documento> documentos = search.textInfoSearch("index","assunto", assunto);
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
}
