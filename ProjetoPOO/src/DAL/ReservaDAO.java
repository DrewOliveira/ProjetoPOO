package DAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import model.Reserva;
import util.Util;

public class ReservaDAO extends ConexaoDB{
	public void IncluirReserva(Reserva reserva)  {
		try {
			openConnection();			
			String sql = 
				"INSERT INTO Reserva(quarto_id, cliente_id, diaria, custo, refeicaoManha, refeicaoTarde, refeicaoNoite, servicoQuarto, acessoPiscina)"
			  + "VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, reserva.getQuarto_id());
			st.setInt(2, reserva.getCliente_id());
			st.setInt(3, reserva.getDiaria());
			st.setDouble(4, reserva.getCusto());
			st.setBoolean(5, reserva.isRefeicaoManha());
			st.setBoolean(6, reserva.isRefeicaoTarde());
			st.setBoolean(7, reserva.isRefeicaoNoite());
			st.setBoolean(8, reserva.isServicoQuarto());
			st.setBoolean(9, reserva.isAcessoPiscina());
			
			Util.geraLog(sql);
			reserva.setId(st.executeUpdate());
			con.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
	            try {
	                System.err.print("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
		}finally {
			closeConnection();
		}	
	}
	public void ExcluirReserva(String id) {
		throw new UnsupportedOperationException("Metodo não implementado");
	}
	
	public void EditarCliente(Reserva reserva) {
		throw new UnsupportedOperationException("Metodo não implementado");
	}
}