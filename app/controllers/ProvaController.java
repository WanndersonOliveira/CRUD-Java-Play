package controllers;

import play.mvc.*;
import models.*;
import views.html.*;
import java.util.*;

public class ProvaController extends Controller{


	public Result index(){
		return ok(loginProva.render(""));
	}

	public Result login(){
		Banco banco = new Banco();
		List<Carro> carros = new ArrayList();
		Usuario user;

		Map<String, String[]> r = request().body().asFormUrlEncoded();

		String nome = r.get("nome")[0];
		String senha = r.get("senha")[0];

		user = banco.confirmarLogin(nome, senha);

		carros = banco.selectCarros(nome);

		for(Carro carro : carros){
			user.setCarro(carro);
		}


		session("nome", nome);
		session("senha", senha);

		if(!session("nome").equals(nome)){
			return ok(loginProva.render("Usuário inexistente!"));
		} 
		return ok(inicial.render(user));

	}

	public Result buscar(){
		Banco banco = new Banco();
		Usuario user;
		String carro = request().getQueryString("texto");

		List<Carro> cars = new ArrayList();


		user = banco.confirmarLogin(session("nome"), session("senha"));

		cars= banco.selectCarros(carro);

		for(Carro c : cars){
			user.setCarro(c);
		}

		cars = banco.buscarCarros(carro);



		return ok(carros.render(user, cars));
	}	

	public Result deletar(String nome, String marca){
		boolean delecao = false;
		Banco banco = new Banco();
		

		delecao = banco.deleteCarro(nome, marca);

		if(delecao == false){
			return ok("Carrinho não deletado");
		}

		return ok("Carrinho deletado com sucesso!");
	}

	public Result edicao(String modelo, String marca){
		Banco banco = new Banco();
		Usuario user;
		String carro = request().getQueryString("texto");

		List<Carro> cars = new ArrayList();

		user = banco.confirmarLogin(session("nome"), session("senha"));

		cars= banco.selectCarros(carro);

		for(Carro c : cars){
			user.setCarro(c);
		}

		return ok(editar.render(user, marca, modelo));
	}

	public Result editar(){
		Banco banco = new Banco();
		Usuario user;
		List<Carro> carros = new ArrayList();
		String modelo = request().getQueryString("modelo");
		String marca = request().getQueryString("marca");

		banco.editeCarro(modelo, marca);

		user = banco.confirmarLogin(session("nome"), session("senha"));

		carros = banco.selectCarros(session("nome"));

		for(Carro carro : carros){
			user.setCarro(carro);
		}

		return ok(inicial.render(user));

	}

	public Result adicao(){
		Banco banco = new Banco();
		Usuario user;
		List<Carro> carros = new ArrayList();

		user = banco.confirmarLogin(session("nome"), session("senha"));

		carros = banco.selectCarros(session("nome"));

		for(Carro carro : carros){
			user.setCarro(carro);
		}

		return ok(adicionar.render(user));
	}

	public Result adicionar(){
		Banco banco = new Banco();
		Usuario user;
		List<Carro> carros = new ArrayList();

		String modelo = request().getQueryString("modelo");
		String marca = request().getQueryString("marca");

		banco.adicioneCarro(modelo, marca);

		user = banco.confirmarLogin(session("nome"), session("senha"));

		carros = banco.selectCarros(session("nome"));

		for(Carro carro : carros){
			user.setCarro(carro);
		}

		return ok(inicial.render(user));
	}

}