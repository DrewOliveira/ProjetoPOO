package control;

import DAL.ReservaDAO;
import model.Cliente;
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
	public Cliente consultarCliente() {
		// TODO Auto-generated method stub
		return null;
	}
}
