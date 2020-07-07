package control;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import DAL.ReservaDAO;
import model.Reserva;
import util.Util;

public class ReservaControl {
	public boolean cadastrarReserva ( int Quarto_id, int Cliente_id, int Diaria, Double custo, boolean RefeicaoManha, boolean RefeicaoTarde, boolean RefeicaoNoite, boolean ServicoQuarto, boolean AcessoPiscina) {
		try {
			ReservaDAO dao = new ReservaDAO();
			Reserva reserva = new Reserva(Quarto_id, Cliente_id, Diaria, custo, RefeicaoManha, RefeicaoTarde, RefeicaoNoite, ServicoQuarto, AcessoPiscina);
			dao.IncluirReserva(reserva);
			return true;
		}catch (Exception e) {
			Util.geraLog(e.getMessage());
		}
		return false;
	}

	public Reserva consultarReserva(int id) {
		try {
			ReservaDAO daoReserva = new ReservaDAO();
			Reserva reserva = daoReserva.BuscarReserva(id);
			
			if (reserva == null) {
				return null;
			} else {
				return reserva;
			}
			
		}catch(Exception e){
			throw e;
		}
	}

	public void excluirReserva(int id) {
		try {
			ReservaDAO daoReserva = new ReservaDAO();
			
			daoReserva.ExcluirReserva(id);
		}catch(Exception e){
			throw e;
		}
	}
	
	public void editarReserva(int QuartoId, int Diaria, Double Custo, boolean refeicaoManha, boolean refeicaoTarde, boolean refeicaoNoite, boolean servicoQuarto, boolean acessoPiscina,int reservaId ) {
		try {
			ReservaDAO daoReserva = new ReservaDAO();
			
			Custo = Custo * Diaria;
			
			Math.floor(Custo);

			JOptionPane.showMessageDialog(null, Custo);

			Reserva reserva = new Reserva(QuartoId, Diaria, Custo, refeicaoManha, refeicaoTarde, refeicaoNoite, servicoQuarto, acessoPiscina, reservaId);
			
			daoReserva.EditarReserva(reserva);
		}catch(Exception e){
			throw e;
		}
	}
	
}
