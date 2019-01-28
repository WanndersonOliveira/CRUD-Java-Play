package models;

import java.util.List;
import java.util.ArrayList;

public class Questionario{
	private String nomeQuest;
	private int qtdeQuest;
	private int pontMax;

	public Questionario(){
	   this.pontMax = this.qtdeQuest;
	}

	public void setNomeQuest(String nome){
		this.nomeQuest = nome;
	}

	public void setQtdeQuest(int qtde){
		this.qtdeQuest = qtde;
		this.pontMax = qtdeQuest;
	}

	public String getNomeQuest(){
		return this.nomeQuest;
	}

	public int getQtdeQuest(){
		return this.qtdeQuest;
	}

}