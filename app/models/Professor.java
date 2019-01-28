package models;

import java.util.List;
import java.util.ArrayList;
import models.Turma;

public class Professor{
	private String nome;
	private String email;

	private List<Turma> turmas = new ArrayList();

	public void setNome(String nome){
		this.nome = nome;
	} 

	public void setEmail(String email){
		this.email = email;
	}

	public String getNome(){
		return this.nome;
	}

	public String getEmail(){
		return this.email;
	}

	public void addTurma(Turma turma){
		this.turmas.add(turma);
	}

	public List<Turma> getTurmas(){
		return this.turmas;
	}
}