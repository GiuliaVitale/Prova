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
import com.azienda.catalogoProdotti.model.Utente;

@WebFilter("/jsp/privata/*")
public class Filtro implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
			try {
				HttpServletRequest request=(HttpServletRequest)arg0;
				Utente u=(Utente)request.getSession().getAttribute(Costanti.CHIAVE_UTENTE);
				if(u!=null) {
					arg2.doFilter(arg0, arg1);
				}
				else {
					arg0.getRequestDispatcher("/jsp/login.jsp").forward(arg0, arg1);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}

}
