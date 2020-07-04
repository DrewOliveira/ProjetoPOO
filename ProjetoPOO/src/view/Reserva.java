package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

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

import control.ReservaControl;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Reserva {

	private JFrame frame;
	private int Quarto_id;
	private int Cliente_id;
	private int Quantidade;
	private boolean refeicaoManha;
	private boolean refeicaoTarde;
	private boolean refeicaoNoite;
	private boolean acessoPiscina;
	private boolean servicoQuarto;
	private double custoRefeicaoManha;
	private double custoRefeicaoTarde;
	private double custoRefeicaoNoite;
	private double custoAcessoPiscina;
	private double custoServicoQuarto;
	
	private double Total;
	private JTextField textBusca;
	private JTextField textTotal;
	private JTextField textQuantidade;
	private JTextField textQuarto;
	private JTextField textCliente;
	
	
	
	
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
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(537, 221, 465, 187);
		panel.add(panel_1_1);
		
		JCheckBox checkboxManha = new JCheckBox("Caf\u00E9 da manh\u00E3");
		checkboxManha.setFont(new Font("Arial", Font.BOLD, 14));
		checkboxManha.setBackground(SystemColor.activeCaption);
		checkboxManha.setBounds(32, 29, 147, 21);
		panel_1_1.add(checkboxManha);
		
		JCheckBox checkboxTarde = new JCheckBox("Almo\u00E7o");
		checkboxTarde.setFont(new Font("Arial", Font.BOLD, 14));
		checkboxTarde.setBackground(SystemColor.activeCaption);
		checkboxTarde.setBounds(32, 71, 147, 21);
		panel_1_1.add(checkboxTarde);
		
		JCheckBox checkboxNoite = new JCheckBox("Jantar");
		checkboxNoite.setFont(new Font("Arial", Font.BOLD, 14));
		checkboxNoite.setBackground(SystemColor.activeCaption);
		checkboxNoite.setBounds(32, 105, 147, 21);
		panel_1_1.add(checkboxNoite);
		
		JCheckBox checkboxAcessoPiscina = new JCheckBox("Acesso \u00E0 Piscina");
		checkboxAcessoPiscina.setFont(new Font("Arial", Font.BOLD, 14));
		checkboxAcessoPiscina.setBackground(SystemColor.activeCaption);
		checkboxAcessoPiscina.setBounds(242, 30, 147, 21);
		panel_1_1.add(checkboxAcessoPiscina);
		
		JCheckBox checkboxServicoQuarto = new JCheckBox("Servi\u00E7o de quarto");
		checkboxServicoQuarto.setFont(new Font("Arial", Font.BOLD, 14));
		checkboxServicoQuarto.setBackground(SystemColor.activeCaption);
		checkboxServicoQuarto.setBounds(242, 82, 147, 21);
		panel_1_1.add(checkboxServicoQuarto);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quarto_id =  Integer.parseInt(textQuarto.getText());
				Cliente_id =  Integer.parseInt(textCliente.getText());
				Quantidade =  Integer.parseInt(textQuantidade.getText());
				
				Total = 70.0;
				
				if(checkboxManha.isSelected()) {
					refeicaoManha = true;
					custoRefeicaoManha =  (Total/100) * 10 ;
				} else {
					refeicaoManha = false;
					custoRefeicaoManha = 0;
				}
				
				if(checkboxTarde.isSelected()) {
					refeicaoTarde = true;
					custoRefeicaoTarde =  (Total/100) * 15 ;
				} else {
					refeicaoTarde = false;
					custoRefeicaoTarde = 0;
				}
				
				if(checkboxNoite.isSelected()) {
					refeicaoNoite = true;
					custoRefeicaoNoite =  (Total/100) * 25 ;
					
				} else {
					refeicaoNoite = false;
					custoRefeicaoNoite = 0;
				}
				
				if(checkboxAcessoPiscina.isSelected()) {
					acessoPiscina = true;
					custoAcessoPiscina =  (Total/100) * 50 ;
				} else {
					acessoPiscina = false;
					custoAcessoPiscina = 0;
				}
				
				if(checkboxServicoQuarto.isSelected()) {
					servicoQuarto = true;
					custoServicoQuarto =  Total + (Total/100) * 50 ;
					
				} else {
					servicoQuarto = false;
					custoServicoQuarto = 0;
				}
				
				Total = Total + (custoRefeicaoManha + custoRefeicaoTarde + custoRefeicaoNoite + custoServicoQuarto + custoAcessoPiscina);
				
				ReservaControl reservaController = new ReservaControl();
				reservaController.cadastrarReserva(
						Quarto_id,
						Cliente_id,
						Quantidade,
						Total,
						refeicaoManha,
						refeicaoTarde,
						refeicaoNoite,
						servicoQuarto,
						acessoPiscina
				);

				JOptionPane.showMessageDialog(null, "Reserva Registrada "
						+ "\n INFORMAÇÕES - RESERVA REALIZADA"
						+ "\n Quarto :"
						+ "\\n Cliente :"
						+ "\n Quantidade de Diárias :"
						+ "\n----------- CUSTO POR SERVIÇOS -----------"
						+ "\n Custo de refeição Manhã :" + custoRefeicaoManha
						+ "\n Custo de refeição Tarde :" + custoRefeicaoTarde
						+ "\n Custo de refeição Noite :" + custoRefeicaoNoite
						+ "\n Custo de serviço de Quarto :" + custoServicoQuarto
						+ "\n Custo de acesso à Piscina :" + custoAcessoPiscina
						+ "\n CUSTO TOTAL -------- :" + Total);
			}
		});
		btnSalvar.setName("btnSalvar");
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 18));
		btnSalvar.setBounds(864, 503, 138, 42);
		panel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setName("btnLimpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.setBounds(716, 503, 138, 42);
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
		labelQuarto.setBounds(10, 221, 215, 42);
		panel.add(labelQuarto);
		
		Label labelCliente = new Label("Cliente");
		labelCliente.setName("labelCliente");
		labelCliente.setFont(new Font("Arial", Font.BOLD, 22));
		labelCliente.setAlignment(Label.CENTER);
		labelCliente.setBounds(10, 289, 215, 42);
		panel.add(labelCliente);
		
		Label labelDiaria = new Label("Di\u00E1rias");
		labelDiaria.setName("labelDiaria");
		labelDiaria.setFont(new Font("Arial", Font.BOLD, 22));
		labelDiaria.setAlignment(Label.CENTER);
		labelDiaria.setBounds(12, 366, 215, 42);
		panel.add(labelDiaria);
		
		textBusca = new JTextField();
		textBusca.setFont(new Font("Arial", Font.BOLD, 16));
		textBusca.setHorizontalAlignment(SwingConstants.LEFT);
		textBusca.setBounds(233, 128, 607, 42);
		panel.add(textBusca);
		textBusca.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Arial", Font.BOLD, 16));
		textTotal.setEditable(false);
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setColumns(10);
		textTotal.setBounds(233, 503, 285, 42);
		panel.add(textTotal);
		
		textQuantidade = new JTextField();
		textQuantidade.setFont(new Font("Arial", Font.BOLD, 16));
		textQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(233, 366, 285, 42);
		panel.add(textQuantidade);
		
		textQuarto = new JTextField();
		textQuarto.setFont(new Font("Arial", Font.BOLD, 16));
		textQuarto.setHorizontalAlignment(SwingConstants.CENTER);
		textQuarto.setColumns(10);
		textQuarto.setBounds(233, 221, 285, 42);
		panel.add(textQuarto);
		
		textCliente = new JTextField();
		textCliente.setFont(new Font("Arial", Font.BOLD, 16));
		textCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textCliente.setColumns(10);
		textCliente.setBounds(233, 289, 285, 42);
		panel.add(textCliente);
		
		Label labelTotal = new Label("Total");
		labelTotal.setName("labelDiaria");
		labelTotal.setFont(new Font("Arial", Font.BOLD, 22));
		labelTotal.setAlignment(Label.CENTER);
		labelTotal.setBounds(10, 500, 215, 42);
		panel.add(labelTotal);
		
		JButton btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setName("btnLimpar");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 18));
		btnDelete.setBounds(563, 503, 138, 42);
		panel.add(btnDelete);
		
	}
}
