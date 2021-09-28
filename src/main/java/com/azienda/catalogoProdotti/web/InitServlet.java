package com.azienda.catalogoProdotti.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.azienda.catalogoProdotti.Util.Costanti;
import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.businessLogic.ProdottoDaoImpl;
import com.azienda.catalogoProdotti.businessLogic.ProfiloDaoImpl;
import com.azienda.catalogoProdotti.businessLogic.UtenteDaoImpl;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager=null;
	
	@Override
	public void init() throws ServletException {
	try {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Catalogo");

		entityManager = entityManagerFactory.createEntityManager();
		
		
		UtenteDaoImpl utDao= new UtenteDaoImpl(entityManager);
		ProfiloDaoImpl profiloDao=new ProfiloDaoImpl(entityManager);
		ProdottoDaoImpl prodottoDao=new ProdottoDaoImpl(entityManager);
		
		BusinessLogic businessLogic=new BusinessLogic(entityManager, prodottoDao, profiloDao, utDao);
		
		getServletContext().setAttribute(Costanti.CHIAVE_CONTEXT, businessLogic);
		
	
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
