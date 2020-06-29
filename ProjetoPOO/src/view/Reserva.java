package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Reserva {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva window = new Reserva();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reserva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1147, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setName("btnCadastrar");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(20, 21, 1084, 624);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		TextField textfieldQuarto = new TextField();
		textfieldQuarto.setName("textfieldQuarto");
		textfieldQuarto.setBackground(SystemColor.info);
		textfieldQuarto.setFont(new Font("Arial", Font.BOLD, 16));
		textfieldQuarto.setBounds(233, 221, 285, 42);
		panel.add(textfieldQuarto);
		
		TextField textfieldCliente = new TextField();
		textfieldCliente.setName("textfieldCliente");
		textfieldCliente.setFont(new Font("Arial", Font.BOLD, 16));
		textfieldCliente.setBackground(SystemColor.info);
		textfieldCliente.setBounds(233, 289, 285, 42);
		panel.add(textfieldCliente);
		
		TextField textfieldQuantidade = new TextField();
		textfieldQuantidade.setName("textfieldQuantidade");
		textfieldQuantidade.setFont(new Font("Arial", Font.BOLD, 16));
		textfieldQuantidade.setBackground(SystemColor.info);
		textfieldQuantidade.setBounds(233, 366, 285, 42);
		panel.add(textfieldQuantidade);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(537, 221, 465, 187);
		panel.add(panel_1_1);
		
		Checkbox checkboxServicoQuarto = new Checkbox("Servi\u00E7o de quarto");
		checkboxServicoQuarto.setName("checkboxServicoQuarto");
		checkboxServicoQuarto.setBounds(264, 29, 260, 34);
		panel_1_1.add(checkboxServicoQuarto);
		checkboxServicoQuarto.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkboxAcessoPiscina = new Checkbox("Acesso a Piscina");
		checkboxAcessoPiscina.setName("checkboxAcessoPiscina");
		checkboxAcessoPiscina.setBounds(264, 81, 260, 34);
		panel_1_1.add(checkboxAcessoPiscina);
		checkboxAcessoPiscina.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkboxRefeicaoManha = new Checkbox("Caf\u00E9 da manh\u00E3");
		checkboxRefeicaoManha.setName("checkboxRefeicaoManha");
		checkboxRefeicaoManha.setBounds(32, 29, 226, 33);
		panel_1_1.add(checkboxRefeicaoManha);
		checkboxRefeicaoManha.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkboxRefeicaoTarde = new Checkbox("Almo\u00E7o");
		checkboxRefeicaoTarde.setName("checkboxRefeicaoTarde");
		checkboxRefeicaoTarde.setBounds(32, 68, 126, 33);
		panel_1_1.add(checkboxRefeicaoTarde);
		checkboxRefeicaoTarde.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkboxRefeicaoNoite = new Checkbox("Jantar");
		checkboxRefeicaoNoite.setName("checkboxRefeicaoNoite");
		checkboxRefeicaoNoite.setBounds(32, 113, 107, 33);
		panel_1_1.add(checkboxRefeicaoNoite);
		checkboxRefeicaoNoite.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//log salvar
				JOptionPane.showMessageDialog(null, "Salvar");
			}
		});
		btnSalvar.setName("btnSalvar");
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 18));
		btnSalvar.setBounds(864, 500, 138, 42);
		panel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setName("btnLimpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.setBounds(688, 500, 138, 42);
		panel.add(btnLimpar);
		
		JMenu mnNewMenu = new JMenu("Consultar");
		mnNewMenu.setName("mnuConsultar");
		mnNewMenu.setFont(new Font("Arial", Font.ITALIC, 14));
		mnNewMenu.setBounds(10, 0, 111, 24);
		panel.add(mnNewMenu);
		mnNewMenu.setBackground(SystemColor.menu);
		
		JMenuItem mnuItemQuarto = new JMenuItem("Quarto");
		mnuItemQuarto.setName("mnuItemQuarto");
		mnuItemQuarto.setFont(new Font("Arial", Font.ITALIC, 13));
		mnNewMenu.add(mnuItemQuarto);
		
		JMenuItem mnuItemCliente = new JMenuItem("Cliente");
		mnuItemCliente.setName("mnuItemCliente");
		mnuItemCliente.setFont(new Font("Arial", Font.ITALIC, 13));
		mnNewMenu.add(mnuItemCliente);
		
		Label labelTitulo = new Label("Realizar reserva");
		labelTitulo.setName("labelTitulo");
		labelTitulo.setAlignment(Label.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		labelTitulo.setBounds(217, 21, 465, 42);
		panel.add(labelTitulo);
		
		TextField textfieldValor = new TextField();
		textfieldValor.setName("textfieldValor");
		textfieldValor.setEnabled(false);
		textfieldValor.setEditable(false);
		textfieldValor.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textfieldValor.setFont(new Font("Arial", Font.ITALIC, 18));
		textfieldValor.setText("Valor");
		textfieldValor.setBounds(101, 500, 417, 42);
		panel.add(textfieldValor);
		
		TextField textfieldBusca = new TextField();
		textfieldBusca.setName("textfieldBusca");
		textfieldBusca.setFont(new Font("Arial", Font.BOLD, 16));
		textfieldBusca.setBackground(SystemColor.info);
		textfieldBusca.setBounds(233, 128, 607, 42);
		panel.add(textfieldBusca);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setName("btnConsultar");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConsultar.setBounds(864, 128, 138, 42);
		panel.add(btnConsultar);
		
		Label labelBuscar = new Label("Buscar");
		labelBuscar.setName("labelBuscar");
		labelBuscar.setFont(new Font("Arial", Font.BOLD, 22));
		labelBuscar.setAlignment(Label.CENTER);
		labelBuscar.setBounds(10, 128, 215, 42);
		panel.add(labelBuscar);
		
		Label labelQuarto = new Label("Quarto");
		labelQuarto.setName("labelQuarto");
		labelQuarto.setFont(new Font("Arial", Font.BOLD, 22));
		labelQuarto.setAlignment(Label.CENTER);
		labelQuarto.setBounds(12, 221, 215, 42);
		panel.add(labelQuarto);
		
		Label labelCliente = new Label("Cliente");
		labelCliente.setName("labelCliente");
		labelCliente.setFont(new Font("Arial", Font.BOLD, 22));
		labelCliente.setAlignment(Label.CENTER);
		labelCliente.setBounds(12, 289, 215, 42);
		panel.add(labelCliente);
		
		Label labelDiaria = new Label("Di\u00E1rias");
		labelDiaria.setName("labelDiaria");
		labelDiaria.setFont(new Font("Arial", Font.BOLD, 22));
		labelDiaria.setAlignment(Label.CENTER);
		labelDiaria.setBounds(12, 366, 215, 42);
		panel.add(labelDiaria);
	}
}
