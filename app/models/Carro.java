package models;

public class Carro{
	private String modelo;
	private String marca;

	public Carro(String modelo, String marca){
		this.modelo = modelo;
		this.marca = marca;
	}

	public String getModelo(){
		return this.modelo;
	}

	public String getMarca(){
		return this.marca;
	}
}