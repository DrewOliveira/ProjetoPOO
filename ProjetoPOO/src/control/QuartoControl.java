package control;



import DAL.QuartoDAO;
import model.Quarto;
import util.Util;
import repository.Repositorio;

public class QuartoControl {
	public boolean cadastrarQuarto(String numero, String tamanho, String andar, String tipo) {
		try {
			Quarto quarto = new Quarto(numero,tamanho,andar,tipo);
			QuartoDAO dao = new QuartoDAO();
			dao.IncluirQuarto(quarto);
			return true;
		}catch(Exception e){
			Util.geraLog(e.getMessage());
		}finally {
			
		}
		return false;
	}
	
	public Quarto consultaQuarto(int id) {
		try {
			QuartoDAO dao = new QuartoDAO();
			return dao.BuscarQuarto(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean editarQuarto(int id,String numero, String tamanho, String andar, String tipo) {
		try {
			Quarto quarto = new Quarto(id, numero, tamanho, andar, tipo);
			QuartoDAO dao = Repositorio.getQuartoDao();
			dao.EditarQuarto(quarto);
			return true;
		} catch (Exception e) {
			Util.geraLog(e.getMessage());
		}
		return false;
	}
	public boolean excluirQuarto(int id) {
		try {
			QuartoDAO dao = Repositorio.getQuartoDao();
			dao.ExcluirQuarto(id);
			return true;
		} catch (Exception e) {
			Util.geraLog(e.getMessage());
		}
		return false;
	}
}
