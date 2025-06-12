package controllers;

import java.util.List;

import models.Pessoa;
import models.Status;
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
	public static void listar(String termo) {
		List<Pessoa> lista = null;
		if(termo == null) {
			lista = Pessoa.find("status <> ?1", Status.INATIVO).fetch();
			
		}else {
			lista = Pessoa.find("(lower(nome) like ?1 "
					+ "or lower(email) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%",
					Status.INATIVO).fetch();
		}
				
		render(lista, termo);
	}
	public static void remover(long id) {
		Pessoa pe = Pessoa.findById(id);
		pe.status = Status.INATIVO;
		pe.save();
		listar(null);
	}
	public static void editar(long id) {
		Pessoa pe = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", pe);
	}
}
