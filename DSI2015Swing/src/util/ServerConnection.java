package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.ProdutoBeanRemote;

public class ServerConnection {
	//Singleton
	private static ServerConnection instance;
	private InitialContext ic;
	private ProdutoBeanRemote produtoBean;

	private ServerConnection() {
		try {
			ic = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public ProdutoBeanRemote getProdutoBeanRemote(){
		if(produtoBean == null){
			try {
				produtoBean = (ProdutoBeanRemote) 
						ic.lookup("java:global/DSI2015Server/DSI2015EJB/ProdutoBean!ejb.ProdutoBeanRemote");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return produtoBean;
	}
	
	public static ServerConnection getInstance(){
		if(instance == null)
			instance = new ServerConnection();
		return instance;
	}
}

