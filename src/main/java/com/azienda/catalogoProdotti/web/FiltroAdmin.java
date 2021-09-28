package com.azienda.catalogoProdotti.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.azienda.catalogoProdotti.Util.Costanti;
import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.model.Utente;

@WebFilter("/jsp/privata/admin/*")
public class FiltroAdmin implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
			try {
				HttpServletRequest request=(HttpServletRequest)arg0;
				BusinessLogic businessLogic=(BusinessLogic)request.getServletContext().getAttribute(Costanti.CHIAVE_CONTEXT);
				Utente ad=(Utente)request.getSession().getAttribute(Costanti.CHIAVE_UTENTE);
				if(ad!=null&&businessLogic.isAdmin(ad.getUsername(), ad.getPassword())) 
					{
					arg2.doFilter(arg0, arg1);
				}
				else {
					arg0.getRequestDispatcher("/jsp/privata/menu.jsp").forward(arg0, arg1);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}

}
