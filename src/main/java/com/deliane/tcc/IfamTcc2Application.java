package com.deliane.tcc;

import java.io.FileWriter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deliane.tcc.indexer.Indexer;
import com.deliane.tcc.model.Biblioteca;
import com.deliane.tcc.model.CategoriaEnum;
import com.deliane.tcc.model.Documento;
import com.deliane.tcc.model.DocumentoList;
import com.deliane.tcc.searcher.Search;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
public class IfamTcc2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IfamTcc2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Search search = new Search();
		search.textInfoSearch("index", "titulo", "java");
		//Indexer indexer = new Indexer();
		//indexer.indexar();
		
	}

}





























