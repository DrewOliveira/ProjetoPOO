package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public Reserva BuscarReserva(int id) {
		Reserva reserva;
		try {
			openConnection();
			String sql = "SELECT * FROM Reserva r WHERE r.id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			Util.geraLog(sql);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next()) {
				reserva = new Reserva(
							resultSet.getInt("id"),
							resultSet.getInt("quarto_id"),
							resultSet.getInt("cliente_id"),
							resultSet.getInt("diaria"),
							resultSet.getDouble("custo"),
							resultSet.getBoolean("refeicaoManha"),
							resultSet.getBoolean("refeicaoTarde"),
							resultSet.getBoolean("refeicaoNoite"),
							resultSet.getBoolean("servicoQuarto"),
							resultSet.getBoolean("acessoPiscina")
						);
				return reserva;
			}
		}catch(SQLException e){
			e.printStackTrace();
			Util.geraLog(e.getMessage());
		}finally {
			closeConnection();
		}
		return null;
	}
	
	public void ExcluirReserva(int id) {
		try {
			openConnection();
			
			String sql = "DELETE Reserva WHERE id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			Util.geraLog(sql);
			
			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
	            try {
	            	Util.geraLog("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }

			e.printStackTrace();
			Util.geraLog(e.getMessage());
		}finally {
			closeConnection();
		}
	}
	
	public void EditarReserva(Reserva reserva) {
		try {
			openConnection();
			String sql = "UPDATE Reserva SET quarto_id = ?, diaria = ?,custo = ?, refeicaoManha = ?, refeicaoTarde = ?,refeicaoNoite = ?,servicoQuarto = ?, acessoPiscina = ? WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reserva.getQuarto_id());
			st.setInt(2, reserva.getDiaria());
			st.setDouble(3, reserva.getCusto());
			st.setBoolean(4, reserva.isRefeicaoManha());
			st.setBoolean(5, reserva.isRefeicaoTarde());
			st.setBoolean(6, reserva.isRefeicaoNoite());
			st.setBoolean(7, reserva.isServicoQuarto());
			st.setBoolean(8, reserva.isAcessoPiscina());
			st.setInt(9, reserva.getId());
			st.executeUpdate();
			con.commit();
		} catch (Exception e) {
			if (con != null) {
	            try {
	            	Util.geraLog("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
			e.printStackTrace();
			Util.geraLog(e.getMessage());
		}finally {
			closeConnection();
		}
	}
}