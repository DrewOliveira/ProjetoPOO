package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.ClienteControl;


public class CadastroCliente extends JFrame implements ActionListener {
	
	Label lblNome,lblSexo,lblDataNasc,lblCpf;
	JComboBox<String> cbSexo;
	Button btnCadastrar,btnLimpar;
	JTextField txtNome,txtDataNasc,txtCpf;
	MenuBar menuBar;
	Menu menuHome;
	Menu menuFuncoes;
	MenuItem cadCli,cadQua,ConsuCli,ConsuQua;
	
	
	public CadastroCliente() {
		setTitle("Cadastro de Clientes");
		setSize(100, 300);
		setLocation(50,50);
		setLayout(new GridLayout(5,1));
		
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
		
		lblNome = new Label();
		lblNome.setText("Nome");
		
		txtNome = new JTextField();
		
		lblSexo = new Label();
		lblSexo.setText("Sexo");
		
		String[] items = {"M","F"};
		cbSexo = new JComboBox<String>(items);
		
		
		lblDataNasc = new Label();
		lblDataNasc.setText("Data de Nascimento");
		
		txtDataNasc = new JTextField();
		
		lblCpf = new Label();
		lblCpf.setText("CPF");
		
		txtCpf = new JTextField();
		
		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.addActionListener(this);
		
		btnLimpar = new Button("Limpar");
		btnLimpar.addActionListener(this);
		
		
		add(lblNome);
		add(txtNome);
		add(lblSexo);
		add(cbSexo);
		add(lblDataNasc);
		add(txtDataNasc);
		add(lblCpf);
		add(txtCpf);
		add(btnCadastrar);
		add(btnLimpar);
		
		
		
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
			if(e.getSource().equals(btnCadastrar)) {
				System.out.println("btnCadastrar");
				String nome, cpf, dataNasc, sexo;
				nome = txtNome.getText();
				cpf = txtCpf.getText();
				dataNasc = txtDataNasc.getText();
				sexo = cbSexo.getSelectedItem().toString();
				ClienteControl cliControl = new ClienteControl();
				System.out.println("Cadastrar");
				if(cliControl.cadastrarCliente(nome, cpf, dataNasc, sexo)) {
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o cliente, verifique as informações!");
				}
			}else {
				limpar();
			}
		}catch(Exception ex) 
		{
			System.out.print(ex.getMessage());
		}finally {
			limpar();
		}
	}
	public void limpar() {
		txtCpf.setText("");
		txtNome.setText("");
		txtDataNasc.setText("");
		cbSexo.setSelectedIndex(0);
	}
	public static void main(String[] args) {
		try {
			CadastroCliente cadClientes = new CadastroCliente();
			
			cadClientes.setVisible(true);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
}
