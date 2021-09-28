package com.azienda.catalogoProdotti.businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.Util.Costanti;
import com.azienda.catalogoProdotti.model.Prodotto;
import com.azienda.catalogoProdotti.model.Utente;

public class BusinessLogic {

	private EntityManager entityManager;
	private ProdottoDaoImpl prodottoDao;
	private ProfiloDaoImpl profiloDao;
	private UtenteDaoImpl utenteDao;
	
	public BusinessLogic(EntityManager entityManager, ProdottoDaoImpl prodottoDao, ProfiloDaoImpl profiloDao,
			UtenteDaoImpl utenteDao) {
		super();
		this.entityManager = entityManager;
		this.prodottoDao = prodottoDao;
		this.profiloDao = profiloDao;
		this.utenteDao = utenteDao;
	}
	
	public Utente login(String user, String passw) throws Exception {
		try {
			entityManager.getTransaction().begin();
			
			List<Utente> utenti=utenteDao.findByUsernameAndPassword(user, passw);
				if(utenti!=null) {
					for(Utente u:utenti) {
						if(u.getUsername().equals(user)&&u.getPassword().equals(passw))	
							entityManager.getTransaction().commit();
						return u;
					}
			}
				entityManager.getTransaction().commit();
				return null;
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}	
		
	}
	public boolean isAdmin(String user, String passw) throws Exception {
		try {
			
			Utente u1=login(user, passw);
			if(u1.getProfilo().getNome().equals(Costanti.CHIAVE_admin)){
				
				return true;
			}
			
		} catch (Exception e) {
			throw e;
		
		}
		return false;

	}
	public void creaProdotto(String nome, Float prezzo) throws Exception{
		try {
			entityManager.getTransaction().begin();
			
			if (nome!=null&&!nome.isEmpty()&&prezzo!=null) {
				Prodotto prodotto = new Prodotto(nome, prezzo);
				prodottoDao.create(prodotto);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			throw e;  
		}
	}
	public List<Prodotto> getProdotti(String nome, Float prezzo) throws Exception{
		try {
			entityManager.getTransaction().begin();
			List <Prodotto> prodotti=new ArrayList<Prodotto>();
			if(nome!=null&&!nome.isEmpty()&&prezzo!=null) {
				prodotti= prodottoDao.findByNomeAndPrezzoMinoreDi(nome, prezzo);
			}else if(nome!=null&&!nome.isEmpty()&&prezzo==null) {
				prodotti=prodottoDao.findByNome(nome);
			}else if(nome.isEmpty()&&prezzo!=null) { 
				prodotti= prodottoDao.findByPrezzoMinoreDi(prezzo);
			} 
			else {
				prodotti= prodottoDao.read();
			}
			entityManager.getTransaction().commit();	
			return prodotti;
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			throw e;  
			}
	}

}
