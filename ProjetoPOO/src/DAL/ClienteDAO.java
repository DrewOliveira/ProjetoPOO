package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import model.Cliente;
import util.Util;

public class ClienteDAO extends ConexaoDB  {
	public void IncluirCliente(Cliente cliente)  {
		try {
			openConnection();
			String sql = "INSERT INTO Cliente (nome,cpf,datanasc,sexo) VALUES (?,?,convert(datetime,?,103),?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getCPF());
			st.setString(3, cliente.getDataNasc());
			st.setString(4, cliente.getSexo());
			Util.geraLog(sql);
			insertID = st.executeUpdate();
			cliente.setId(insertID);
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
	public void ExcluirCliente(String id) {
		throw new UnsupportedOperationException("Metodo não implementado");
	}
	public Cliente BuscarCliente(String cpf) {
		Cliente cliente = null;
		try {
			openConnection();
			String sql = "SELECT * FROM Cliente c WHERE c.cpf like ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cpf);
			Util.geraLog(sql);
			ResultSet rst = st.executeQuery();
			if(rst.next()) {
				cliente = new Cliente(rst.getString("nome"),
								rst.getString("cpf"),
								rst.getDate("datanasc").toString(),
								rst.getString("sexo"));
				cliente.setId(rst.getInt("id"));
				return cliente;
			}
		}catch(SQLException e){
			e.printStackTrace();
			Util.geraLog(e.getMessage());
		}finally {
			closeConnection();
		}
		return null;
	}
	public void EditarCliente(Cliente cliente) {
		throw new UnsupportedOperationException("Metodo não implementado");
	}
}
