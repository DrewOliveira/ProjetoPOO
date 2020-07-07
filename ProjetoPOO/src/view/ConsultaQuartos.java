package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import repository.Repositorio;
import control.QuartoControl;
import model.Quarto;

public class ConsultaQuartos extends JFrame implements ActionListener {
	Panel painelBusca,painelDados;
	Label lblNumero,lblAndar,lblTamanho,lblTipo,lblIdBusca,lblDadosQuarto;
	TextField txtIdBusca,txtNumero,txtAndar,txtTamanho,txtTipo;
	Button btnBusca,btnEditar,btnExcluir,btnLimpar,btnSalvar;
	
	MenuBar menuBar;
	Menu menuHome;
	Menu menuFuncoes;
	MenuItem cadCli,cadQua,ConsuCli,ConsuQua, ReservaTela;
	
	public static Quarto quarto;
	
	public ConsultaQuartos() {
		
		setTitle("Consulta Quartos");
		setSize(400, 200);
		setLocation(50,50);
		setLayout(new GridLayout(6, 3));
		
		menuBar = new MenuBar();
		menuHome = new Menu("Home");
		menuFuncoes = new Menu("Funções");
		cadCli = new MenuItem("Cadastrar Cliente");
		cadCli.addActionListener(this);
		cadQua = new MenuItem("Cadastrar Quarto");
		cadQua.addActionListener(this);
		ConsuCli = new MenuItem("Consultar Cliente");
		ConsuCli.addActionListener(this);
		ConsuQua = new MenuItem("Consultar Quarto");
		ConsuQua.addActionListener(this);
		ReservaTela = new MenuItem("Tela de reservas");
		ReservaTela.addActionListener(this);
		menuFuncoes.add(cadCli);
		menuFuncoes.add(cadQua);
		menuFuncoes.add(ConsuCli);
		menuFuncoes.add(ConsuQua);
		menuFuncoes.add(ReservaTela);
		menuBar.add(menuHome);
		menuBar.add(menuFuncoes);
		setMenuBar(menuBar);
		
		
		lblIdBusca = new Label();
		lblIdBusca.setText("Informe o ID do quarto:");
		txtIdBusca = new TextField();
		btnBusca = new Button("Buscar");
		btnBusca.addActionListener(this);
		btnEditar = new Button("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setVisible(false);
		btnExcluir = new Button("Excluir");
		btnExcluir.addActionListener(this);
		btnExcluir.setVisible(false);
		btnLimpar = new Button("Limpar");
		btnLimpar.addActionListener(this);
		btnSalvar = new Button("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setVisible(false);
		
		lblNumero = new Label();
		lblNumero.setText("Numero");
		txtNumero = new TextField();
		lblTamanho = new Label();
		lblTamanho.setText("Tamanho(m²)");
		txtTamanho = new TextField();
		lblAndar = new Label();
		lblAndar.setText("Andar");
		txtAndar = new TextField();
		lblTipo = new Label();
		lblTipo.setText("Tipo");
		txtTipo = new TextField();
		lblDadosQuarto = new Label();
		lblDadosQuarto.setText("Dados do Quarto:");
		lblDadosQuarto.setAlignment(Label.CENTER);
		
		add(lblIdBusca);
		add(txtIdBusca);
		add(btnBusca);
		
		add(new Label());
		add(lblDadosQuarto);
		add(new Label());
		
		add(lblNumero);
		add(txtNumero);
		add(btnLimpar);
			
		
		add(lblTamanho);
		add(txtTamanho);
		add(btnEditar);	
		
		
		add(lblAndar);
		add(txtAndar);
		add(btnExcluir);
		
		
		add(lblTipo);
		add(txtTipo);	
		add(btnSalvar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource().equals(cadCli)) {
				CadastroCliente cadCli = new CadastroCliente();
				cadCli.setVisible(true);
				this.dispose();
			 }
			 if(e.getSource().equals(cadQua)) {
				CadastroQuarto cadQuarto = new CadastroQuarto(); 
				cadQuarto.setVisible(true);
				this.dispose();
			 }
			 if(e.getSource().equals(ConsuCli)) {
				 ConsultaClientes consultaClientes = new ConsultaClientes();
				consultaClientes.setVisible(true);	
				this.dispose();
			}
			if(e.getSource().equals(ConsuQua)) {
				 ConsultaQuartos consultaQuartos = new ConsultaQuartos();
				consultaQuartos.setVisible(true);
				this.dispose();
			}
			
			if(e.getSource().equals(ReservaTela)) {
				Reserva reservaTela = new Reserva();
				reservaTela.getFrame().setVisible(true);
				this.dispose();
			 }
			
			if(e.getSource().equals(btnBusca)) {
				int id = Integer.parseInt(txtIdBusca.getText());
				QuartoControl quaControl = Repositorio.getQuartoControl();
				quarto = quaControl.consultaQuarto(id);
				if(quarto != null) {
					txtAndar.setText(quarto.getAndar());
					txtNumero.setText(quarto.getNumero());
					txtTipo.setText(quarto.getTipo());
					txtTamanho.setText(quarto.getTamanho());
					btnEditar.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Quarto!");
				}
			}
			if(e.getSource().equals(btnLimpar)) {
				limpar();
			}
			if(e.getSource().equals(btnEditar)) {
				int id = Integer.parseInt(txtIdBusca.getText());
				habilitaComponentesEditar();
				QuartoControl quaControl = Repositorio.getQuartoControl();
				quarto = quaControl.consultaQuarto(id);
				if(quarto != null) {
					txtAndar.setText(quarto.getAndar());
					txtNumero.setText(quarto.getNumero());
					txtTipo.setText(quarto.getTipo());
					txtTamanho.setText(quarto.getTamanho());
					btnEditar.setVisible(true);
				}
			}
			if(e.getSource().equals(btnSalvar)) {
				if(verificaEdicao()) {
					int id = Integer.parseInt(txtIdBusca.getText());
					String numero = txtNumero.getText(),
						   tamanho = txtTamanho.getText(),
						   andar = txtAndar.getText(),
						   tipo = txtTipo.getText();							
					QuartoControl quaControl = Repositorio.getQuartoControl();
					if(quaControl.editarQuarto(id, numero, tamanho, andar, tipo)) {
						JOptionPane.showMessageDialog(null, "Edição salva!");
					}else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a edição!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Não foram feitas edições no quarto!");
				}
				desabilitaComponentesEditar();
			}
			if(e.getSource().equals(btnExcluir)) {
				int id = Integer.parseInt(txtIdBusca.getText());
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir o quarto?" ,"Excluir",JOptionPane.YES_NO_OPTION)) {
					QuartoControl quaControl = Repositorio.getQuartoControl();
					if(quaControl.excluirQuarto(id))
						JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					else
						JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a exclusão!");
				}
				desabilitaComponentesEditar();
				limpar();
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public boolean verificaEdicao() {
		if(!txtAndar.getText().equals(quarto.getAndar()))
			return true;
		if(!txtNumero.getText().equals(quarto.getNumero()))
			return true;
		if(!txtTamanho.getText().equals(quarto.getTamanho()))
			return true;
		if(!txtTipo.getText().equals(quarto.getTipo()))
			return true;
		return false;
	}
	
	public void habilitaComponentesEditar() {
		btnExcluir.setVisible(true);
		btnSalvar.setVisible(true);
		btnBusca.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnEditar.setEnabled(false);
		txtIdBusca.setEditable(false);
		
	}
	public void desabilitaComponentesEditar() {
		btnExcluir.setVisible(false);
		btnSalvar.setVisible(false);
		btnBusca.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnEditar.setEnabled(true);
		txtIdBusca.setEditable(true);
		
	}
	
	public void limpar() {
		txtIdBusca.setText("");
		txtAndar.setText("");
		txtNumero.setText("");
		txtTipo.setText("");
		txtTamanho.setText("");
	}
	
	public static void main(String[] args) {
		try {
	
			ConsultaQuartos consultaQuartos = new ConsultaQuartos();
			consultaQuartos.setVisible(true);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}

}
