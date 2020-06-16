package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.ClienteControl;
import control.QuartoControl;
import model.Cliente;
import repository.Repositorio;

public class ConsultaClientes extends JFrame implements ActionListener {
	
	Label lblNome,lblSexo,lblDataNasc,lblCpf,lblIdBusca,lblDadosCliente;
	JComboBox<String> cbSexo;
	Button btnCadastrar,btnBusca,btnEditar,btnExcluir,btnLimpar,btnSalvar;
	TextField txtNome,txtDataNasc,txtCpf,txtIdBusca;
	MenuBar menuBar;
	Menu menuHome;
	Menu menuFuncoes;
	MenuItem cadCli,cadQua,ConsuCli,ConsuQua;
	static Cliente cliente;
	public ConsultaClientes() {
		setTitle("Consulta Clientes");
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
		menuFuncoes.add(cadCli);
		menuFuncoes.add(cadQua);
		menuFuncoes.add(ConsuCli);
		menuFuncoes.add(ConsuQua);
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
		
		lblNome = new Label();
		lblNome.setText("Nome");	
		txtNome = new TextField();
		lblSexo = new Label();
		lblSexo.setText("Sexo");
		String[] items = {"M","F"};
		cbSexo = new JComboBox<String>(items);
		lblDataNasc = new Label();
		lblDataNasc.setText("Data de Nascimento");
		txtDataNasc = new TextField();
		lblCpf = new Label();
		lblCpf.setText("CPF");
		txtCpf = new TextField();
		
		lblDadosCliente = new Label();
		lblDadosCliente.setText("Dados do Quarto:");
		lblDadosCliente.setAlignment(Label.CENTER);
		
		
		add(lblIdBusca);
		add(txtIdBusca);
		add(btnBusca);
		
		add(new Label());
		add(lblDadosCliente);
		add(new Label());
		
		add(lblNome);
		add(txtNome);
		add(btnLimpar);
		
		add(lblCpf);
		add(txtCpf);
		add(btnEditar);
		
		
		
		add(lblSexo);
		add(cbSexo);
		add(btnExcluir);
		
		add(lblDataNasc);
		add(txtDataNasc);
		add(btnSalvar);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
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
		}if(e.getSource().equals(btnBusca)) {
			int id = Integer.parseInt(txtIdBusca.getText());
			ClienteControl cliControl = Repositorio.getClienteControl();
			cliente = cliControl.consultarCliente();
			if(cliente != null) {
				
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
			
		}
		if(e.getSource().equals(btnSalvar)) {
			if(verificaEdicao()) {
				int id = Integer.parseInt(txtIdBusca.getText());
									
				
				if(true) {
					JOptionPane.showMessageDialog(null, "Edição salva!");
				}else {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a edição!");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foram feitas edições no quarto!");
			}
		}

	}

	private boolean verificaEdicao() {
		// TODO Auto-generated method stub
		return false;
	}
	private void habilitaComponentesEditar() {
		// TODO Auto-generated method stub
		
	}
	private void limpar() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		try {
			ConsultaClientes consultaClientes = new ConsultaClientes();
			consultaClientes.setVisible(true);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}

}
