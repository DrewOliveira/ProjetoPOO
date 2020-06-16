package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import model.Cliente;
import model.Quarto;
import util.Util;

public class QuartoDAO extends ConexaoDB{
	public void IncluirQuarto(Quarto quarto) {
		try 
		{
			openConnection();
			String sql = "INSERT INTO Quarto (numero,tamanho,andar,tipo) VALUES (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, quarto.getNumero());
			st.setString(2, quarto.getTamanho());
			st.setString(3, quarto.getAndar());
			st.setString(4, quarto.getTipo());
			Util.geraLog(sql);
			st.executeUpdate();
			con.commit();
		}
		catch (Exception e) 
		{
			Util.geraLog(e.getMessage());
			if (con != null) {
	            try {
	            	Util.geraLog("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
		}
		finally 
		{
			closeConnection();
		}
	}
	public void ExcluirQuarto(int id) {
		try {
			openConnection();
			String sql = "DELETE Quarto WHERE id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			Util.geraLog(sql);
			st.executeUpdate();
			con.commit();
		}catch(SQLException e){
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
	public Quarto BuscarQuarto(int id) {
		Quarto quarto;
		try {
			openConnection();
			String sql = "SELECT * FROM Quarto q WHERE q.id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			Util.geraLog(sql);
			ResultSet rst = st.executeQuery();
			if(rst.next()) {
				quarto = new Quarto(rst.getInt("id"),
								rst.getString("numero"),
								rst.getString("tamanho"),
								rst.getString("andar").toString(),
								rst.getString("tipo"));
				return quarto;
			}
		}catch(SQLException e){
			e.printStackTrace();
			Util.geraLog(e.getMessage());
		}finally {
			closeConnection();
		}
		return null;
	}
	public void EditarQuarto(Quarto quarto) {
		try {
			openConnection();
			String sql = "UPDATE Quarto SET numero = ?, tamanho = ?,andar = ?,tipo = ? WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, quarto.getNumero());
			st.setString(2, quarto.getTamanho());
			st.setString(3, quarto.getAndar());
			st.setString(4, quarto.getTipo());
			st.setInt(5, quarto.getId());
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
