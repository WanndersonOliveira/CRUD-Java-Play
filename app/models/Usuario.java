package models;

import java.util.*;

public class Usuario{
	private String nome;
	private List<Carro> carros = new ArrayList();

	public Usuario(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public List<Carro> getCarros(){
		return this.carros;
	}

	public void setCarro(Carro carro){
		this.carros.add(carro);
	}
}