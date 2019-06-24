package com.deliane.tcc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deliane.tcc.indexer.Indexer;
import com.deliane.tcc.searcher.Search;

@SpringBootApplication
public class IfamTcc2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IfamTcc2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Search search = new Search();
		search.textInfoSearchStopWords("index", "titulo", "java");
		//Indexer indexer = new Indexer();
		//indexer.indexar();
		
	}

}





























