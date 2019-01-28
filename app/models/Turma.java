package models;

import java.util.List;
import java.util.ArrayList;
import models.*;

public class Turma{
	private String nome;
	private double media;
	private double moda;
	private double rendimento;

	private List<Aluno> alunos = new ArrayList();
	private List<Questionario> quests = new ArrayList();

	public String getNome(){
		return this.nome;
	}

	public double getMedia(){
		return this.media;
	}

    public double getModa(){
		return this.moda;
	}

	public double getRendimento(){
		return this.rendimento;
	}

	public List<Aluno> getAlunos(){
		return this.alunos;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setRendimento(double rend){
		this.rendimento = rend;
	}

	public void setModa(double moda){
		this.moda = moda;
	}

	public void setMedia(double media){
		this.media = media;
	}

	public void setAluno(Aluno aluno){
		this.alunos.add(aluno);
	}

	public void setQuestionario(Questionario quest){
		this.quests.add(quest);
	}

	public List<Questionario> getQuestionarios(){
		return this.quests;
	}
}
