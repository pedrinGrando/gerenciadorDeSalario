package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import model.controller.UserCONTROLLER;
import model.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaConsultaDeUsuario extends JFrame {

	String nome = "";
	UserVO usuario = new UserVO();
	UserVO userVO = new UserVO();
	UserCONTROLLER userController = new UserCONTROLLER();
	
	
	private JPanel contentPane;
	private JTextField txtTeste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaDeUsuario frame = new TelaConsultaDeUsuario(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaDeUsuario(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 465);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Trocar usuário");
		mntmNewMenuItem_2.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\changeUserIcon.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Encerrar");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    FecharPrograma tela = new FecharPrograma(userLogado);
			    tela.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GS - Gerenciador de salário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel.setBounds(397, 386, 163, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenu tela = new TelaMenu(userLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton.setBounds(0, 377, 34, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel(" Consulta de Usuario ");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(178, 54, 262, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome completo: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(10, 205, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Consulta via Nome");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = JOptionPane.showInputDialog("Digite o nome do usuário: ");
				userVO.setNome(nome);
				
				usuario = userController.consultarUsuarioController(userVO);
				
				if(usuario.getIdUsuario() != 0) {
					JOptionPane.showMessageDialog(null, "Usuário consultado com sucesso!", "GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
					
					JLabel nome_label = new JLabel("");
					nome_label.setBounds(106, 205, 285, 14);
					contentPane.add(nome_label);
					nome_label.setText(usuario.getNome());
					
					JLabel cpf_label = new JLabel("");
					cpf_label.setBounds(64, 230, 292, 14);
					contentPane.add(cpf_label);
					cpf_label.setText(usuario.getCpf());
					
					JLabel datanasci_label = new JLabel("");
					datanasci_label.setBounds(130, 255, 285, 14);
					contentPane.add(datanasci_label);
					datanasci_label.setText(""+usuario.getDataNasci());
					
					JLabel email_label = new JLabel("");
					email_label.setBounds(64, 284, 292, 14);
					contentPane.add(email_label);
					email_label.setText(usuario.getEmail());
					
					JLabel salarioB_label = new JLabel("");
					salarioB_label.setBounds(106, 309, 297, 14);
					contentPane.add(salarioB_label);
					salarioB_label.setText("R$ " + usuario.getBruto());
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
					dispose();
					TelaConsultaDeUsuario tela = new TelaConsultaDeUsuario(userLogado);
					tela.setVisible(true);
					
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.setBounds(203, 79, 153, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("CPF: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(10, 230, 44, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nasciemento: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4.setBounds(10, 255, 121, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(10, 284, 44, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_7.setBounds(0, 136, 560, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Salario Base: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_6.setBounds(10, 309, 89, 14);
		contentPane.add(lblNewLabel_6);
	}
}
