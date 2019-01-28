package models;

import java.util.List;
import java.util.ArrayList;
import models.Turma;

public class Aluno{
	private String nome;
	private int moeda;
	private double media;
	private double moda;
	private double rendimento;
	private int questoesRespondidas;

	List<Turma> turmas = new ArrayList();

	public String getNome(){
		return this.nome;
	}

	public double getMedia(){
		return this.media;
	}

	public void setMedia(double media){
		this.media = media;
	}

	public void setModa(double moda){
		this.moda = moda;
	}

	public double getModa(){
		return this.moda;
	}

	public void setRendimento(double rend){
		this.rendimento = rend;
	}

	public double getRendimento(){
		return this.rendimento;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setMoeda(int moeda){
		this.moeda = moeda;
	}

	public int getMoeda(){
		return this.moeda;
	}

	public void addTurma(Turma turma){
		this.turmas.add(turma);
	}

	public List<Turma> getTurmas(){
		return this.turmas;
	}

	public void setQuestoesRespondidas(int q){
		this.questoesRespondidas = q;
	}

	public int getQuestoesRespondidas(){
		return this.questoesRespondidas;
	}

}