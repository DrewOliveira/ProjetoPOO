package model;

public class Reserva {
	private int id;
	private int quarto_id;
	private int cliente_id;
	private int diaria;
	private double custo;
	private boolean refeicaoManha;
	private boolean refeicaoTarde;
	private boolean refeicaoNoite;
	private boolean servicoQuarto;
	private boolean acessoPiscina;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuarto_id() {
		return quarto_id;
	}
	public void setQuarto_id(int quarto_id) {
		this.quarto_id = quarto_id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getDiaria() {
		return diaria;
	}
	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public boolean isRefeicaoManha() {
		return refeicaoManha;
	}
	public void setRefeicaoManha(boolean refeicaoManha) {
		this.refeicaoManha = refeicaoManha;
	}
	public boolean isRefeicaoTarde() {
		return refeicaoTarde;
	}
	public void setRefeicaoTarde(boolean refeicaoTarde) {
		this.refeicaoTarde = refeicaoTarde;
	}
	public boolean isRefeicaoNoite() {
		return refeicaoNoite;
	}
	public void setRefeicaoNoite(boolean refeicaoNoite) {
		this.refeicaoNoite = refeicaoNoite;
	}
	public boolean isServicoQuarto() {
		return servicoQuarto;
	}
	public void setServicoQuarto(boolean servicoQuarto) {
		this.servicoQuarto = servicoQuarto;
	}
	public boolean isAcessoPiscina() {
		return acessoPiscina;
	}
	public void setAcessoPiscina(boolean acessoPiscina) {
		this.acessoPiscina = acessoPiscina;
	}
	
	public Reserva(int quarto_id, int cliente_id, int diaria, double custo, boolean refeicaoManha,
			boolean refeicaoTarde, boolean refeicaoNoite, boolean servicoQuarto, boolean acessoPiscina) {
		super();
		this.quarto_id = quarto_id;
		this.cliente_id = cliente_id;
		this.diaria = diaria;
		this.custo = custo;
		this.refeicaoManha = refeicaoManha;
		this.refeicaoTarde = refeicaoTarde;
		this.refeicaoNoite = refeicaoNoite;
		this.servicoQuarto = servicoQuarto;
		this.acessoPiscina = acessoPiscina;
	}
	
}
