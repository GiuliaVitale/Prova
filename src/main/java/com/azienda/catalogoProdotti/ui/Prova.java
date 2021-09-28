package com.azienda.catalogoProdotti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.businessLogic.ProdottoDaoImpl;
import com.azienda.catalogoProdotti.businessLogic.ProfiloDaoImpl;
import com.azienda.catalogoProdotti.businessLogic.UtenteDaoImpl;


public class Prova {

	public static void main(String[] args) {
		EntityManager entityManager=null;
		
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Catalogo");

			entityManager = entityManagerFactory.createEntityManager();
			
			
			UtenteDaoImpl utDao= new UtenteDaoImpl(entityManager);
			ProfiloDaoImpl profiloDao=new ProfiloDaoImpl(entityManager);
			ProdottoDaoImpl prodottoDao=new ProdottoDaoImpl(entityManager);
			
			BusinessLogic businessLogic=new BusinessLogic(entityManager, prodottoDao, profiloDao, utDao);

			System.out.println(businessLogic.login("Vladimir", "passwPutin"));
			System.out.println(businessLogic.isAdmin("Trump", "Obama33"));

//			businessLogic.creaProdotto("sedia ergonomica", 5000f);
//			businessLogic.creaProdotto("computer di carmine", 500f);
//			businessLogic.creaProdotto("quattro bianchi", 500f);
//			businessLogic.creaProdotto("collare per carmine", 100f);
//			businessLogic.creaProdotto("catene", 100f);
//			
			System.out.println(businessLogic.getProdotti("sedia ergonomica", 5000f));
			System.out.println(businessLogic.getProdotti("sedia ergonomica",null));
			System.out.println(businessLogic.getProdotti(null, 500f));
			System.out.println(businessLogic.getProdotti(null, null));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(entityManager!=null) {
				entityManager.close();
				System.exit(0); 
			}


		}


	}

}
