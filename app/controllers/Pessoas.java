package controllers;

import java.util.List;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
    
	public static void form() {
		render();
	}
	
	public static void detalhar(Pessoa pessoa) {
		render(pessoa);
	}
	
	public static void salvar(Pessoa pessoa) {
		if (pessoa.nome != null) {
			pessoa.nome = pessoa.nome.toUpperCase();		
		}
		if (pessoa.email != null) {
			pessoa.email = pessoa.email.toLowerCase();
		}
		pessoa.save();
		detalhar(pessoa);
	}
	public static void listar() {
		List<Pessoa> lista = Pessoa.findAll();
		render(lista);
	}
	public static void remover(long id) {
		Pessoa pe = Pessoa.findById(id);
		pe.delete();
		
		listar();
	}
	public static void editar(long id) {
		Pessoa pe = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", pe);
	}
}
