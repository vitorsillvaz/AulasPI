package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity //reflete a class no bd
public class Pessoa extends Model{
	
	public String nome;
	public String email;
 
	@Enumerated(EnumType.STRING)
	public Status status;
}
