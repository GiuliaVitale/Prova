package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Utente;


public class UtenteDaoImpl implements DaoInterface<Utente>{
	
private EntityManager entityManager;
	
	public UtenteDaoImpl(EntityManager entityManager) throws Exception{
		if(entityManager==null) {
			throw new Exception("L'entity manager non puo' essere null");
		}
		this.entityManager=entityManager;
	}

	@Override
	public void create(Utente object) {
		List<Utente> utenti =read();
		for (Utente u:utenti) {
			if(object.getUsername().equals(u.getUsername())
				&& object.getPassword().equals(u.getPassword())){
				System.out.println("Utente gia' registrato");
				return;
			}
		}
		entityManager.persist(object);
		
	}

	@Override
	public List<Utente> read() {
		return entityManager.createQuery("from Utente", Utente.class).getResultList();
	}

	@Override
	public void update(Utente object) {
		entityManager.persist(object);
		
	}

	@Override
	public void delete(Utente object) {
		entityManager.remove(object);
		
	}
	
	public List<Utente> findByUsernameAndPassword(String user, String pwd){
		return entityManager.createQuery("select x from Utente x where x.username=:parUser and x.password=:parPwd", Utente.class)
				.setParameter("parUser", user).setParameter("parPwd", pwd).getResultList();	
	}

}
