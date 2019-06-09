package com.deliane.tcc.model;

public class Biblioteca {
	
	private String nome;// nome da biblioteca ex:"BIBLIOTECA PAULO SARMENTO"
    private String instituicao;//instituição da biblioteca "IFAM", "UFAM"
    private String endereco; //endereço físico da biblioteca
    private double lat;
    private double lng;
    private String url; 
    
	public Biblioteca() {		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	   
}
