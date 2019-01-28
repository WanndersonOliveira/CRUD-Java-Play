package models;

import java.sql.*;
import models.*;
import java.util.List;
import java.util.ArrayList;

public class SQLite{

	public Connection conectar(){
		Connection c = null;

		try{
			c = DriverManager.getConnection("jdbc:sqlite:schoolsystemdb");
		} catch (SQLException e){
			System.out.println(e.getClass().getName()+": "+e.getMessage());
		} 

		return c;
	}


	public List<Questionario> selectQuestionarios(String turma){
		List<Questionario> quests = new ArrayList();


		Questionario quest;

			String sql = "select nomeQuest, qtdeQuest from Questionario"+
			" JOIN Turma on (Questionario.codTurma = Turma.idTurma) "+ 
			"where nomeTurma = '"+turma+"';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					quest = new Questionario();
					quest.setNomeQuest(rs.getString("nomeQuest"));
					quest.setQtdeQuest(rs.getInt("qtdeQuest"));

					quests.add(quest);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		

		return quests;
	}

	public List<Aluno> selectAlunos(String turma){
		List<Aluno> alunos = new ArrayList();


		Aluno aluno;

			String sql = "select nomeAluno, mediaAluno, modaAluno,rendAluno"+
			" from Turma JOIN AlunoTurma on (Turma.idTurma = AlunoTurma.codTurma)"+
			" JOIN Aluno on (Aluno.idAluno = AlunoTurma.codAluno) where nomeTurma = '"+turma+
			"' group by codTurma, codAluno;";


			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					aluno = new Aluno();
					aluno.setNome(rs.getString("nomeAluno"));
					aluno.setMedia(rs.getDouble("mediaAluno"));
					aluno.setModa(rs.getDouble("modaAluno"));
					aluno.setRendimento(rs.getDouble("rendAluno"));

					alunos.add(aluno);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		

		return alunos;
	}

	public Aluno confirmarLoginAluno(String email, String senha){
		Aluno aluno = new Aluno();
		Turma turma;

		if(email.equals("nelson@gmail.com") & senha.equals("nelsontades2018")){
			String sql = "select email,nomeAluno, mediaAluno, modaAluno,rendAluno from "+
        	"Aluno where email = '"+email+"' and senha='"+senha+"';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					if(!(rs.getString("email").equals(email))){
						aluno = null;
						System.out.println("Deu zebra!");
					} else {
						aluno.setNome(rs.getString("nomeAluno"));
						aluno.setMoeda(0);
						aluno.setMedia(rs.getDouble("mediaAluno"));
						aluno.setModa(rs.getDouble("modaAluno"));
						aluno.setRendimento(rs.getDouble("rendAluno"));
						aluno.setQuestoesRespondidas(rs.getInt("questResp"));

						System.out.println("Aluno: "+aluno.getNome());
					}
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}
		} else {
			String sql = "select email,nomeAluno, sum(pontuacao) as pontuacao, sum(questResp) as questResp,mediaAluno, modaAluno, rendAluno, nomeTurma, mediaTurma, modaTurma, rendTurma  from "+
        	"QuestAluno INNER JOIN Aluno on (QuestAluno.codAluno = Aluno.idAluno) INNER JOIN "+
        	"AlunoTurma on (Aluno.idAluno = AlunoTurma.codAluno) INNER JOIN Turma on (AlunoTurma.codTurma = Turma.idTurma) "+
			"where Aluno.email = '"+email+"' and Aluno.senha = '"+senha+"' group by idTurma;";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					if(!(rs.getString("email").equals(email))){
						aluno = null;
					} else {
						aluno.setNome(rs.getString("nomeAluno"));
						aluno.setMoeda(rs.getInt("pontuacao"));
						aluno.setMedia(rs.getDouble("mediaAluno"));
						aluno.setModa(rs.getDouble("modaAluno"));
						aluno.setRendimento(rs.getDouble("rendAluno"));
						aluno.setQuestoesRespondidas(rs.getInt("questResp"));

						System.out.println(aluno.getNome()+"\n");

						System.out.println("Aluno: "+aluno.getNome());

						turma = new Turma();
					
						turma.setNome(rs.getString("nomeTurma"));
						turma.setMedia(rs.getDouble("mediaTurma"));
						turma.setModa(rs.getDouble("modaTurma"));
						turma.setRendimento(rs.getDouble("rendTurma"));


						aluno.addTurma(turma);
					}
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}

		

		return aluno;
	}

	public Professor confirmarLoginProfessor(String email, String senha){
		Professor professor = new Professor();
		Turma turma;

		if(email.equals("jorge@hotmail.com") && senha.equals("sqlcplusplus")){
			
			String sql = "select email,nomeProf from Professor "+
		"where Professor.email = '"+email+"' and Professor.senha = '"+senha+"';";
			

			try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					if(!(rs.getString("email").equals(email))){
						professor = null;
					} else {
						professor.setNome(rs.getString("nomeProf"));
						professor.setEmail(rs.getString("email"));
					}
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		} else {
			String sql = "select email, nomeProf, nomeTurma, mediaTurma, modaTurma, rendTurma from Professor INNER JOIN "+
        	"Turma on (Professor.idProf = Turma.codProf) "+
			"where Professor.email = '"+email+"' and Professor.senha = '"+senha+"' group by idTurma;";

			System.out.println(sql);

			try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					if(!(rs.getString("email").equals(email))){
						professor = null;
					} else {
						professor.setNome(rs.getString("nomeProf"));
						professor.setEmail(rs.getString("email"));

						System.out.println("Professor: "+professor.getNome());

						turma = new Turma();
						turma.setNome(rs.getString("nomeTurma"));
						turma.setMedia(rs.getDouble("mediaTurma"));
						turma.setModa(rs.getDouble("modaTurma"));
						turma.setRendimento(rs.getDouble("rendTurma"));

						System.out.println("Turma: "+turma.getNome());

						professor.addTurma(turma);
					}
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}

		return professor;
	}

	public String selectImagem(String email, String senha, String usuario){
		String imagemAdd = "";

		String sql = "select imagem from "+usuario+" where email = '"+email+"' and senha = '"+senha+"';";

		System.out.println(sql);

		try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){

			while(rs.next()){
				imagemAdd = rs.getString("imagem");
			}

		} catch (SQLException e){
			System.out.println(e.getMessage());
		}	

		return imagemAdd;
	}

}