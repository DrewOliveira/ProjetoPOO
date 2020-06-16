package model;

public class Quarto {
	private int id;
	private String numero;
	private String tamanho;
	private String andar;
	private String tipo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Quarto(int id, String numero, String tamanho, String andar, String tipo) {
		super();
		this.id = id;
		this.numero = numero;
		this.tamanho = tamanho;
		this.andar = andar;
		this.tipo = tipo;
	}
	
	public Quarto (String numero, String tamanho, String andar, String tipo) {
		super();
		this.numero = numero;
		this.tamanho = tamanho;
		this.andar = andar;
		this.tipo = tipo;
	}
	
}
