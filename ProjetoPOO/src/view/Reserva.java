package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

import java.awt.List;
import java.awt.TextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.ComponentOrientation;
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
		frame.setBounds(100, 100, 937, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(20, 20, 901, 530);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		TextField textField = new TextField();
		textField.setName("textfieldQuarto");
		textField.setBackground(SystemColor.info);
		textField.setText("Quarto");
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setBounds(56, 146, 285, 42);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setText("Cliente");
		textField_1.setName("textfieldQuarto");
		textField_1.setFont(new Font("Arial", Font.BOLD, 16));
		textField_1.setBackground(SystemColor.info);
		textField_1.setBounds(56, 214, 285, 42);
		panel.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setText("Quantidade de diarias");
		textField_2.setName("textfieldQuarto");
		textField_2.setFont(new Font("Arial", Font.BOLD, 16));
		textField_2.setBackground(SystemColor.info);
		textField_2.setBounds(56, 291, 285, 42);
		panel.add(textField_2);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(360, 146, 465, 187);
		panel.add(panel_1_1);
		
		Checkbox checkbox = new Checkbox("Servi\u00E7o de quarto");
		checkbox.setBounds(264, 29, 260, 34);
		panel_1_1.add(checkbox);
		checkbox.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkbox_3 = new Checkbox("Acesso a Piscina");
		checkbox_3.setBounds(264, 81, 260, 34);
		panel_1_1.add(checkbox_3);
		checkbox_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkbox_4 = new Checkbox("Caf\u00E9 da manh\u00E3");
		checkbox_4.setBounds(32, 29, 226, 33);
		panel_1_1.add(checkbox_4);
		checkbox_4.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkbox_1 = new Checkbox("Almo\u00E7o");
		checkbox_1.setBounds(32, 68, 126, 33);
		panel_1_1.add(checkbox_1);
		checkbox_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		Checkbox checkbox_2 = new Checkbox("Jantar");
		checkbox_2.setBounds(32, 113, 107, 33);
		panel_1_1.add(checkbox_2);
		checkbox_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(687, 425, 138, 42);
		panel.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.setBounds(511, 425, 138, 42);
		panel.add(btnLimpar);
		
		JMenu mnNewMenu = new JMenu("Consultar");
		mnNewMenu.setFont(new Font("Arial", Font.ITALIC, 14));
		mnNewMenu.setBounds(10, 0, 111, 24);
		panel.add(mnNewMenu);
		mnNewMenu.setBackground(SystemColor.menu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quarto");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.ITALIC, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.setFont(new Font("Arial", Font.ITALIC, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		Label label = new Label("Realizar reserva");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 22));
		label.setBounds(107, 44, 465, 42);
		panel.add(label);
		
		TextField textField_3 = new TextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_3.setFont(new Font("Arial", Font.ITALIC, 18));
		textField_3.setText("Valor");
		textField_3.setBounds(56, 425, 285, 42);
		panel.add(textField_3);
	}
}
