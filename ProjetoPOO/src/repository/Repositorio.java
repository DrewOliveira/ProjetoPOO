package repository;

import DAL.ClienteDAO;
import DAL.QuartoDAO;
import DAL.ReservaDAO;
import control.ClienteControl;
import control.QuartoControl;
import control.ReservaControl;


public class Repositorio {
	private static QuartoControl quartoControl;
	private static QuartoDAO quartoDao;
	private static ClienteControl clienteControl;
	private static ClienteDAO clienteDao;
	private static ReservaControl reservaControl;
	private static ReservaDAO reservaDAO;
	
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
	
	public static ReservaControl getReservaControl() {
		if(reservaControl == null)
			reservaControl = new ReservaControl();
		return reservaControl;
	}
	
	public static ReservaDAO getReservaDAO() {
		if(reservaDAO == null)
			reservaDAO = new ReservaDAO();
		return reservaDAO;
	}
}

