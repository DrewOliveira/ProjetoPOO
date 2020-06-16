package repository;

import DAL.ClienteDAO;
import DAL.QuartoDAO;
import control.ClienteControl;
import control.QuartoControl;

public class Repositorio {
	private static QuartoControl quartoControl;
	private static QuartoDAO quartoDao;
	private static ClienteControl clienteControl;
	private static ClienteDAO clienteDao;
	
	public static QuartoControl getQuartoControl() {
		if(quartoControl == null)
			quartoControl = new QuartoControl();
		return quartoControl;
	}
	public static QuartoDAO getQuartoDao() {
		if(quartoDao == null)
			quartoDao = new QuartoDAO();
		return quartoDao;
	}
	public static ClienteControl getClienteControl() {
		if(clienteControl == null)
			clienteControl = new ClienteControl();
		return clienteControl;
	}
	public static ClienteDAO getClienteDao() {
		if(clienteDao == null)
			clienteDao = new ClienteDAO();
		return clienteDao;
	}
	
	
}
