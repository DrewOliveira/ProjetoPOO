package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class Login {

	private JFrame frame;
	private JTextField textFieldLoginLogin;
	private JPasswordField passwordFieldSenhaLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 578, 605);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.BLACK);
		panel.setBounds(31, 54, 497, 451);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Acesse sua conta");
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setBackground(SystemColor.text);
		lblTitle.setBounds(105, 63, 270, 29);
		panel.add(lblTitle);
		
		textFieldLoginLogin = new JTextField();
		textFieldLoginLogin.setBounds(147, 147, 270, 37);
		panel.add(textFieldLoginLogin);
		textFieldLoginLogin.setColumns(10);
		
		passwordFieldSenhaLogin = new JPasswordField();
		passwordFieldSenhaLogin.setBounds(147, 253, 270, 37);
		panel.add(passwordFieldSenhaLogin);
		
		JLabel lblLoginLogin = new JLabel("Login");
		lblLoginLogin.setFont(new Font("Verdana", Font.BOLD, 16));
		lblLoginLogin.setBounds(83, 147, 58, 40);
		panel.add(lblLoginLogin);
		
		JLabel lblSenhaLogin = new JLabel("Senha");
		lblSenhaLogin.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSenhaLogin.setBounds(83, 256, 58, 34);
		panel.add(lblSenhaLogin);
		
		JButton btnEntrarLogin = new JButton("Entrar");
		btnEntrarLogin.setBounds(313, 332, 104, 37);
		panel.add(btnEntrarLogin);
		
		JButton btnLimparLogin = new JButton("Limpar");
		btnLimparLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimparLogin.setBounds(199, 332, 104, 37);
		panel.add(btnLimparLogin);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
