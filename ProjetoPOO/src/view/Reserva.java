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
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
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
	
	private Double Total;
	private JTextField textBusca;
	private JTextField textTotal;
	private JTextField textQuantidade;
	private JTextField textQuarto;
	private JTextField textCliente;
	
	
	private int idBusca;
	private int idDelete;
	private int idAlterar;
	private JTextField textReserva;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva window = new Reserva();
					window.getFrame().setVisible(true);
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

		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 1133, 668);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setName("btnCadastrar");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 1108, 615);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(537, 283, 465, 187);
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
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setName("btnLimpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textReserva.setText("");
				textBusca.setText("");
				textQuarto.setText("");
				textCliente.setText("");
				textQuantidade.setText("");
				textTotal.setText("0");
				checkboxManha.setSelected(false);
				checkboxTarde.setSelected(false);
				checkboxNoite.setSelected(false);
				checkboxServicoQuarto.setSelected(false);
				checkboxAcessoPiscina.setSelected(false);
				textCliente.setEnabled(true);
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.setBounds(716, 503, 138, 42);
		panel.add(btnLimpar);
		
		Label labelTitulo = new Label("Realizar reserva");
		labelTitulo.setName("labelTitulo");
		labelTitulo.setAlignment(Label.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		labelTitulo.setBounds(217, 21, 465, 42);
		panel.add(labelTitulo);
		
		JButton btnDelete = new JButton("Excluir");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textReserva.getText().equalsIgnoreCase(null) || textReserva.getText().equals("") || textReserva.getText().equals("0") || Integer.parseInt(textReserva.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "Necessario consultar uma reserva valida para excluir!!!");
				} else {
					idDelete = Integer.parseInt(textReserva.getText().trim());
					ReservaControl reservaController =  new ReservaControl();
					
					reservaController.excluirReserva(idDelete);
					btnLimpar.doClick();
					textCliente.setEnabled(true);
				}				
			}
		});
		btnDelete.setName("btnLimpar");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 18));
		btnDelete.setBounds(563, 503, 138, 42);
		panel.add(btnDelete);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textBusca.getText().equalsIgnoreCase(null) || textBusca.getText().equals("") || textBusca.getText().equals("0") || Integer.parseInt(textBusca.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "Favor um id valido no campo de busca!!!");
				} else {
					idBusca = Integer.parseInt(textBusca.getText());
										
					ReservaControl reservaController = new ReservaControl();
					if (reservaController.consultarReserva(idBusca) == null) {
						JOptionPane.showMessageDialog(null, "Nenhuma reserva encontrada");
						btnLimpar.doClick();
					} else {
						textBusca.setText("");
						textReserva.setText(String.valueOf(idBusca));
						textQuarto.setText(String.valueOf(reservaController.consultarReserva(idBusca).getQuarto_id()));
						textCliente.setText(String.valueOf(reservaController.consultarReserva(idBusca).getCliente_id()));
						textQuantidade.setText(String.valueOf(reservaController.consultarReserva(idBusca).getDiaria()));
						textTotal.setText(String.valueOf(reservaController.consultarReserva(idBusca).getCusto()));

						checkboxManha.setSelected(reservaController.consultarReserva(idBusca).isRefeicaoManha());
						checkboxTarde.setSelected(reservaController.consultarReserva(idBusca).isRefeicaoTarde());
						checkboxNoite.setSelected(reservaController.consultarReserva(idBusca).isRefeicaoNoite());
						checkboxServicoQuarto.setSelected(reservaController.consultarReserva(idBusca).isServicoQuarto());
						checkboxAcessoPiscina.setSelected(reservaController.consultarReserva(idBusca).isAcessoPiscina());

						btnDelete.setEnabled(true);
						textCliente.setEnabled(false);
					}
				}
			}
		});
		btnConsultar.setName("btnConsultar");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConsultar.setBounds(864, 87, 138, 42);
		panel.add(btnConsultar);
		
		Label labelBuscar = new Label("Buscar");
		labelBuscar.setName("labelBuscar");
		labelBuscar.setFont(new Font("Arial", Font.BOLD, 22));
		labelBuscar.setAlignment(Label.CENTER);
		labelBuscar.setBounds(10, 87, 215, 42);
		panel.add(labelBuscar);
		
		Label labelQuarto = new Label("Quarto");
		labelQuarto.setName("labelQuarto");
		labelQuarto.setFont(new Font("Arial", Font.BOLD, 22));
		labelQuarto.setAlignment(Label.CENTER);
		labelQuarto.setBounds(10, 283, 215, 42);
		panel.add(labelQuarto);
		
		Label labelCliente = new Label("Cliente");
		labelCliente.setName("labelCliente");
		labelCliente.setFont(new Font("Arial", Font.BOLD, 22));
		labelCliente.setAlignment(Label.CENTER);
		labelCliente.setBounds(10, 351, 215, 42);
		panel.add(labelCliente);
		
		Label labelDiaria = new Label("Di\u00E1rias");
		labelDiaria.setName("labelDiaria");
		labelDiaria.setFont(new Font("Arial", Font.BOLD, 22));
		labelDiaria.setAlignment(Label.CENTER);
		labelDiaria.setBounds(12, 428, 215, 42);
		panel.add(labelDiaria);
		
		textBusca = new JTextField();
		textBusca.setFont(new Font("Arial", Font.BOLD, 16));
		textBusca.setHorizontalAlignment(SwingConstants.LEFT);
		textBusca.setBounds(233, 87, 607, 42);
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
		textQuantidade.setBounds(233, 428, 285, 42);
		panel.add(textQuantidade);
		
		textQuarto = new JTextField();
		textQuarto.setFont(new Font("Arial", Font.BOLD, 16));
		textQuarto.setHorizontalAlignment(SwingConstants.CENTER);
		textQuarto.setColumns(10);
		textQuarto.setBounds(233, 283, 285, 42);
		panel.add(textQuarto);
		
		textCliente = new JTextField();
		textCliente.setFont(new Font("Arial", Font.BOLD, 16));
		textCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textCliente.setColumns(10);
		textCliente.setBounds(233, 351, 285, 42);
		panel.add(textCliente);
		
		Label labelTotal = new Label("Total");
		labelTotal.setName("labelDiaria");
		labelTotal.setFont(new Font("Arial", Font.BOLD, 22));
		labelTotal.setAlignment(Label.CENTER);
		labelTotal.setBounds(10, 500, 215, 42);
		panel.add(labelTotal);
		
		Label labelReserva = new Label("Reserva");
		labelReserva.setAlignment(Label.CENTER);
		labelReserva.setName("labelQuarto");
		labelReserva.setFont(new Font("Arial", Font.BOLD, 22));
		labelReserva.setBounds(10, 214, 215, 42);
		panel.add(labelReserva);
		
		textReserva = new JTextField();
		textReserva.setEditable(false);
		textReserva.setHorizontalAlignment(SwingConstants.CENTER);
		textReserva.setFont(new Font("Arial", Font.BOLD, 16));
		textReserva.setColumns(10);
		textReserva.setBounds(233, 214, 285, 42);
		panel.add(textReserva);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				if (textReserva.getText().equalsIgnoreCase(null) || textReserva.getText().equals("") || textReserva.getText().equals("0") || Integer.parseInt(textReserva.getText()) <= 0) {
					Quarto_id =  Integer.parseInt(textQuarto.getText());
					Cliente_id =  Integer.parseInt(textCliente.getText());
					Quantidade =  Integer.parseInt(textQuantidade.getText());
					
					Total = Total * Quantidade;
					
					Math.floor(Total);
					
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
							+ "\n Cliente :"
							+ "\n Quantidade de Diárias :"
							+ "\n----------- CUSTO POR SERVIÇOS -----------"
							+ "\n Custo de refeição Manhã :" + custoRefeicaoManha
							+ "\n Custo de refeição Tarde :" + custoRefeicaoTarde
							+ "\n Custo de refeição Noite :" + custoRefeicaoNoite
							+ "\n Custo de serviço de Quarto :" + custoServicoQuarto
							+ "\n Custo de acesso à Piscina :" + custoAcessoPiscina
							+ "\n CUSTO TOTAL -------- :" + Total);
				} else {
					idAlterar = Integer.parseInt(textReserva.getText());
					
					ReservaControl reservaController = new ReservaControl();
					
					reservaController.editarReserva(
							Integer.parseInt(textQuarto.getText())
							,Integer.parseInt(textQuantidade.getText())
							,Total
							,refeicaoManha
							,refeicaoTarde
							,refeicaoNoite
							,servicoQuarto
							,acessoPiscina
							,idAlterar
					);
					
					textBusca.setText(String.valueOf(idAlterar));
					btnConsultar.doClick();
				}
			}
		});
		btnSalvar.setName("btnSalvar");
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 18));
		btnSalvar.setBounds(864, 503, 138, 42);
		panel.add(btnSalvar);
		
		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItemCadQuarto = new JMenuItem("Cadastrar Quarto");
		mntmNewMenuItemCadQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroQuarto cadQuarto = new CadastroQuarto(); 
				cadQuarto.setVisible(true);
				getFrame().dispose();
			}
			
		});
		
		
		JMenuItem mntmNewMenuItemHome = new JMenuItem("Home");
		mntmNewMenuItemHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				getFrame().dispose();
			}
			
		});
		menuBar.add(mntmNewMenuItemHome);
		
		
		JMenuItem mntmNewMenuItemCadCliente = new JMenuItem("Cadastrar Cliente");
		mntmNewMenuItemCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadCliente = new CadastroCliente();
				cadCliente.setVisible(true);
				getFrame().dispose();
			}
			
		});
		menuBar.add(mntmNewMenuItemCadCliente);
		menuBar.add(mntmNewMenuItemCadQuarto);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
