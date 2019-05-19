package com.deliane.tcc.tester;

import java.io.FileNotFoundException;

import com.deliane.tcc.indexer.Indexer;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Indexer indexer = new Indexer();
		indexer.indexar();

	}
}
