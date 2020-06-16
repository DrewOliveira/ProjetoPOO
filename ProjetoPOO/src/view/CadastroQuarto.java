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

import control.QuartoControl;
import repository.Repositorio;
import util.Util;

public class CadastroQuarto extends JFrame implements ActionListener {

	Label lblNumero,lblTamanho,lblAndar,lblTipo;
	JTextField txtNumero, txtTamanho, txtAndar, txtTipo; 
	Button btnCadastrar,btnLimpar;
	MenuBar menuBar;
	Menu menuHome;
	Menu menuFuncoes;
	MenuItem cadCli,cadQua,ConsuCli,ConsuQua;
	
	public CadastroQuarto() {
	setTitle("Cadastro de Quartos");
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
	
	
	lblNumero = new Label();
	lblNumero.setText("Numero");
	
	txtNumero = new JTextField();
	
	lblTamanho = new Label();
	lblTamanho.setText("Tamanho(m²)");
	
	txtTamanho = new JTextField();
	
	lblAndar = new Label();
	lblAndar.setText("Andar");
	
	txtAndar = new JTextField();
	
	lblTipo = new Label();
	lblTipo.setText("Tipo");
	
	txtTipo = new JTextField();
	
	btnCadastrar = new Button("Cadastrar");
	btnCadastrar.addActionListener(this);
	
	btnLimpar = new Button("Limpar");
	btnLimpar.addActionListener(this);
	
	add(lblNumero);
	add(txtNumero);
	add(lblTamanho);
	add(txtTamanho);
	add(lblAndar);
	add(txtAndar);
	add(lblTipo);
	add(txtTipo);
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
				String numero = txtNumero.getText(),
					   andar = txtAndar.getText(),
					   tamanho = txtTamanho.getText(),
					   tipo = txtTipo.getText();
				QuartoControl quaControl  = Repositorio.getQuartoControl();
				if(quaControl.cadastrarQuarto(numero, tamanho, andar, tipo)) {
					JOptionPane.showMessageDialog(null, "Quarto Cadastrado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Quarto!");
				}
			}else {
				limpar();
			}
		}catch (Exception ex) {
			Util.geraLog(ex.getMessage());
		}finally {
			limpar();
		}

	}
	public void limpar() {
		txtAndar.setText("");
		txtTamanho.setText("");
		txtNumero.setText("");
		txtTipo.setText("");
	}
	public static void main(String[] args) {
		try {
			CadastroQuarto cadQuartos = new CadastroQuarto();
			cadQuartos.setVisible(true);
		}catch(Exception ex){
			Util.geraLog(ex.getMessage());
		}
	}

}
