package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Profilo;

public class ProfiloDaoImpl implements DaoInterface<Profilo>{
	
	private EntityManager entityManager;
	
	public ProfiloDaoImpl(EntityManager entityManager) throws Exception{
		if(entityManager==null) {
			throw new Exception("L'entity manager non puo' essere null");
		}
		this.entityManager=entityManager;
	}

	@Override
	public void create(Profilo object) {
		entityManager.persist(object);
		
	}

	@Override
	public List<Profilo> read() {
		return entityManager.createQuery("from Profilo", Profilo.class).getResultList();
	}

	@Override
	public void update(Profilo object) {
		entityManager.persist(object);
		
	}

	@Override
	public void delete(Profilo object) {
		entityManager.remove(object);
		
	}

}
