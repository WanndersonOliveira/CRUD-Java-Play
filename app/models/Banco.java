package models;

import java.sql.*;
import models.*;
import java.util.List;
import java.util.ArrayList;

public class Banco{

	public Connection conectar(){
		Connection c = null;

		try{
			c = DriverManager.getConnection("jdbc:sqlite:prova");
		} catch (SQLException e){
			System.out.println(e.getClass().getName()+": "+e.getMessage());
		} 

		return c;
	}

	public Usuario confirmarLogin(String nome, String senha){
			Usuario user = new Usuario("");

			String sql = "select nome from Usuario"+
			" where nome = '"+nome+"' and senha='"+senha+"';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					user = new Usuario(rs.getString("nome"));
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		return user;
	}


	public List<Carro> selectCarros(String usuario){
		List<Carro> carros = new ArrayList();


		Carro carro;

			String sql = "select modelo, marca from Carrinho"+
			" JOIN Usuario on (Carrinho.idUsuario = Usuario.idUser)"+
			" where nome = '"+usuario+"';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					carro = new Carro(rs.getString("modelo"), rs.getString("marca"));

					carros.add(carro);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		return carros;
	}

	public int selectMaxIdCarro(){
		int id = 0;

		String sql = "select max(idCar) as maximo from Carrinho;";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					id = rs.getInt("maximo");
					System.out.println(id);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		return id;
	}

	public int selectIdCarro(String modelo, String marca){
		int id = 0;

		String sql = "select idCar from Carrinho where modelo = '"+modelo+"' and marca='"+marca+"';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					id = rs.getInt("idCar");
					System.out.println(id);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		return id;
	}

	public List<Carro> buscarCarros(String filtro){
		List<Carro> carros = new ArrayList();


		Carro carro;

			String sql = "select marca, modelo from Carrinho where modelo like '"+filtro+"%';";

			System.out.println(sql);

			try(Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					carro = new Carro(rs.getString("modelo"), rs.getString("marca"));

					carros.add(carro);
				}

			} catch (SQLException e){
				System.out.println(e.getMessage());
			}

		return carros;
	}

	public boolean deleteCarro(String model, String marc){
		boolean check = false;
		String sql = "DELETE FROM Carrinho where modelo = '"+model+"' and marca = '"+marc+"';";
		System.out.println(sql);

		try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement()){
			stmt.executeUpdate(sql);
			check = true;
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}

		return check;
	}

	public boolean editeCarro(String model, String marc){
		int id = selectIdCarro(model, marc);

		boolean check=false;

		String sql = "Update Carrinho set modelo = '"+model+"', marca = '"+marc+"' where idCar="+id+";";

		System.out.println(sql);

		try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement()){
			stmt.executeUpdate(sql);
			check = true;

		} catch (SQLException e){
			System.out.println(e.getMessage());
		}

		return check;
	}

	public boolean adicioneCarro(String model, String marc){
		int id = selectMaxIdCarro();
		id++;

		boolean check=false;

		String sql = "INSERT INTO CARRINHO VALUES("+id+", '"+model+"', '"+marc+"', 1)";

		System.out.println(sql);

		try(Connection conn = this.conectar();
			Statement stmt = conn.createStatement()){
			stmt.executeUpdate(sql);
			check = true;

		} catch (SQLException e){
			System.out.println(e.getMessage());
		}

		return check;
	}

}
