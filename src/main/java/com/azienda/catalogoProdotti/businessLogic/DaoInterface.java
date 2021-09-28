package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

public interface DaoInterface<T> {
	
	public void create(T object);
	public List<T> read();
	public void update(T object);
	public void delete(T object);
	//public T retrieveById(T object);
	

}
