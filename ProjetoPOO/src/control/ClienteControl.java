package control;



import DAL.ClienteDAO;
import model.Cliente;
import util.Util;

public class ClienteControl {
	public boolean cadastrarCliente(String nome, String cpf, String dataNasc, String sexo) {
		try {
			if(validaCpf(cpf)) {
				if(validarExistenciaCliente(cpf)) {
					ClienteDAO dao = new ClienteDAO();
					Cliente cliente = new Cliente(nome,cpf,dataNasc,sexo);
					dao.IncluirCliente(cliente);
					return true;
				}else {
					throw new Exception("Cliente já cadastrado");
				}
			}else {
				throw new Exception("CPF inválido");
			}	
		}catch (Exception e) {
			Util.geraLog(e.getMessage());
		}
		return false;
	}
	public boolean validarExistenciaCliente(String cpf) {
		try {
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.BuscarCliente(cpf);
			return cliente == null;
		}catch(Exception e){
			throw e;
		}
	}
	public boolean validaCpf(String cpf) {
		if(cpf.length()==11)
			return true;
		return false;
	}
	public Cliente consultarCliente() {
		// TODO Auto-generated method stub
		return null;
	}
}
