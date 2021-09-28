package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Prodotto;



public class ProdottoDaoImpl implements DaoInterface<Prodotto>{

private EntityManager entityManager;
	
	public ProdottoDaoImpl(EntityManager entityManager) throws Exception{
		if(entityManager==null) {
			throw new Exception("L'entity manager non puo' essere null");
		}
		this.entityManager=entityManager;
	}

	@Override
	public void create(Prodotto object) {
		entityManager.persist(object);
		
	}

	@Override
	public List<Prodotto> read() {
		return entityManager.createQuery("from Prodotto", Prodotto.class).getResultList();
	}

	@Override
	public void update(Prodotto object) {
		entityManager.persist(object);
		
	}

	@Override
	public void delete(Prodotto object) {
		entityManager.remove(object);
		
	}
	public List<Prodotto> findByNome (String nome){
		return entityManager.createQuery("select x from Prodotto x where x.nome =:parN", Prodotto.class)
				.setParameter("parN", nome).getResultList();	
	}
	public List<Prodotto> findByPrezzoMinoreDi(Float prezzo){
		return entityManager.createQuery("select x from Prodotto x where x.prezzo<=:parM", Prodotto.class)
				.setParameter("parM", prezzo).getResultList();	
	}
	
	public List<Prodotto> findByNomeAndPrezzoMinoreDi(String nome,Float prezzo){
		return entityManager.createQuery("select x from Prodotto x where x.nome=:parN and x.prezzo<=:parM", Prodotto.class)
				.setParameter("parN", nome).setParameter("parM", prezzo).getResultList();	
	}

	public Prodotto findById (Integer id) {
		return entityManager.createQuery("select x from Prodotto x where x.idProdotto=:parId",Prodotto.class).
				setParameter("parId", id).getSingleResult();
	}
}
