package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Home extends JFrame implements ActionListener {

	Label lblTitulo;
	Button btnCadCliente,btnCadQuartos,btnConsultClientes,btnConsultQuartos;
	MenuBar menuBar;
	Menu menu;
	public Home() {
		setTitle("Navegação");
		setSize(100, 300);
		setLocation(50,50);
		setLayout(new GridLayout(5,1));
		
		menuBar = new MenuBar();
		menu = new Menu("Home");
		menuBar.add(menu);
		setMenuBar(menuBar);
		
		lblTitulo = new Label();
		lblTitulo.setText("Menu");
		lblTitulo.setAlignment(Label.CENTER);
		
		btnCadCliente = new Button("Cadastro de Clientes");
		btnCadCliente.addActionListener(this);
		
		btnCadQuartos = new Button("Cadastro de Quartos");
		btnCadQuartos.addActionListener(this);
		
		btnConsultClientes = new Button("Consulta de Clientes");
		btnConsultClientes.addActionListener(this);
		
		btnConsultQuartos = new Button("Consulta de Quartos");
		btnConsultQuartos.addActionListener(this);
		
		
		add(lblTitulo);
		add(btnCadCliente);
		add(btnCadQuartos);
		add(btnConsultClientes);
		add(btnConsultQuartos);

		
	}
	
	public static void main(String[] args) {
		try {
			Home home = new Home();
			home.setVisible(true);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e)
	 {
		 try {
		 if(e.getSource().equals(btnCadCliente)) {
			CadastroCliente cadCli = new CadastroCliente();
			cadCli.setVisible(true);
			this.dispose();
		 }
		 if(e.getSource().equals(btnCadQuartos)) {
			CadastroQuarto cadQuarto = new CadastroQuarto(); 
			cadQuarto.setVisible(true);
			this.dispose();
		 }
		 if(e.getSource().equals(btnConsultClientes)) {
			 ConsultaClientes consultaClientes = new ConsultaClientes();
			consultaClientes.setVisible(true);	
			this.dispose();
		}
		 if(e.getSource().equals(btnConsultQuartos)) {
			 ConsultaQuartos consultaQuartos = new ConsultaQuartos();
			consultaQuartos.setVisible(true);
			this.dispose();
		}
		}catch (Exception ex) {
			lblTitulo.setText("ERRO "+ex.getMessage());
		}
	 }
	 
	
}
