package com.deliane.tcc.indexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.deliane.tcc.model.Documento;
import com.deliane.tcc.tester.LerDocumentos;

public class Indexer {

	public void indexar() throws FileNotFoundException {
		
		File f = new File("arquivosLib");
		String[] arquivos = f.list();
		
		LerDocumentos ler = new LerDocumentos();
		
		for (String arq : arquivos) {
			
			List<Documento> documentos = ler.getDocuments("arquivosLib\\"+arq);
			
			for (Documento documento : documentos) {
				try {
					indexarDocumento(documento);
					System.out.println("Indexando");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(arq);
		}
		//List<Documento> documentos = ler.getDocuments();
		

		System.out.println("Fim da indexacao");
	}

	public void indexarDocumento(Documento documento) throws IOException {
		String indexPath = "index";
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = (Directory) FSDirectory.open(Paths.get(indexPath));		
		IndexWriterConfig config = new IndexWriterConfig(analyzer);		
		IndexWriter writer = new IndexWriter(directory, config);
		
		Document document = new Document();
		document.add(new Field("autor", documento.getAutor(), TextField.TYPE_STORED));
		document.add(new Field("titulo", documento.getTitulo(), TextField.TYPE_STORED));
		document.add(new Field("assunto", documento.getAssunto(),TextField.TYPE_STORED));
		document.add(new Field("ano", "" + documento.getAno(), TextField.TYPE_STORED));
		document.add(new Field("biblioteca", documento.getBiblioteca().getNome(), TextField.TYPE_STORED));
		document.add(new Field("instituicao", documento.getBiblioteca().getInstituicao(), TextField.TYPE_STORED));
		document.add(new Field("endereco", documento.getBiblioteca().getEndereco(), TextField.TYPE_STORED));
		document.add(new Field("url", documento.getBiblioteca().getUrl(), TextField.TYPE_STORED));
		document.add(new Field("categoria", documento.getCategoria().name(), TextField.TYPE_STORED));
		
		
		writer.addDocument(document);
		writer.commit();
		writer.close();

	}

}
