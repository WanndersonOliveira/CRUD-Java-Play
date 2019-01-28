package controllers;

import play.mvc.*;
import models.*;
import views.html.*;
import java.util.*;

public class InitioController extends Controller{
	Professor professor;
	Aluno aluno;
	String imagemAdd;


	public Result index(){
		return ok(login.render(""));
	}

	public Result login(){
		SQLite sql = new SQLite();

		Map<String, String[]> r = request().body().asFormUrlEncoded();

		String email = r.get("email")[0];
		String senha = r.get("senha")[0];
		String usuario = r.get("usuario")[0];

		session("email", email);

		if(usuario.equals("aluno")){
			aluno = new Aluno();

			aluno = sql.confirmarLoginAluno(email, senha);
			imagemAdd = sql.selectImagem(email, senha, usuario);

			List<Questionario> quests = new ArrayList();


			int count = 0;
			for(Turma turma : aluno.getTurmas()){
				quests = sql.selectQuestionarios(aluno.getTurmas().get(count).getNome());

				for(Questionario q : quests){
					aluno.getTurmas().get(count).setQuestionario(q);
				}
				count++;
			}


			if(aluno.getNome().equals(null)){
				return ok(login.render("Email ou senha não conferem!"));
			} else {
				return ok(aln.render(aluno, imagemAdd));
			}
		} else if(usuario.equals("professor")){
			professor = new Professor();
			professor = sql.confirmarLoginProfessor(email, senha);

			String imagemAdd = sql.selectImagem(email, senha, usuario);

			List<Questionario> quests = new ArrayList();
			List<Aluno> alunos = new ArrayList();

			int count = 0;
			for(Turma turma : professor.getTurmas()){
				quests = sql.selectQuestionarios(professor.getTurmas().get(count).getNome());
				alunos = sql.selectAlunos(turma.getNome());

				for(Questionario q : quests){
					professor.getTurmas().get(count).setQuestionario(q);
				}

				for(Aluno aln : alunos){
					professor.getTurmas().get(count).setAluno(aln);
				}

				count++;
			}

			count = 0;

			if(professor.getNome().equals(null)){
				return ok(login.render("Email ou senha não conferem!"));
			} else {
				return ok(prof.render(professor, imagemAdd));
			}
		}

		return ok(login.render("Email ou senha não conferem!"));
	}

	public Result mostrarMinhasTurmasAln(){
		return ok(alunoTurmas.render(aluno, imagemAdd));
	}

	public Result mostrarMinhasTurmasPr(){
		return ok(profTurmas.render(professor, imagemAdd));
	}

	public Result mostrarEstatisticas(){
		return ok(aln.render(aluno, imagemAdd));
	}

	public Result mostrarEstatisticasProfessor(){
		return ok(prof.render(professor, imagemAdd));
	}	
}