package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity //reflete a class no bd
public class Pessoa extends Model{
	
	public String nome;
	public String email;

}
