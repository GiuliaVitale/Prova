package com.azienda.catalogoProdotti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfilo;
	private String nome;
	
	@OneToMany (mappedBy = "profilo")
	private List <Utente> utenti=new ArrayList<Utente>();
	
	public Profilo () {
		
	}
	public Profilo(String nome) {
		this.nome=nome;
		
	}
	public Integer getIdProfilo() {
		return idProfilo;
	}
	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
	@Override
	public String toString() {
		return "Profilo [idProfilo=" + idProfilo + ", nome=" + nome + ", utenti=" + utenti + "]";
	}

}
