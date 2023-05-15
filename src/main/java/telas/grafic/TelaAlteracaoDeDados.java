package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.DespesaDAO;
import model.dao.UserDAO;
import model.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaAlteracaoDeDados extends JFrame {
	
	String nome = "";
	String cpf = "";
	String email = "";
	String usrName = "";
	double brut = 0;
	String resp = "";
	
	UserVO userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	DespesaDAO depst = new DespesaDAO();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteracaoDeDados frame = new TelaAlteracaoDeDados(null);
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
	public TelaAlteracaoDeDados(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 375);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Trocar usuário");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\changeUserIcon.png"));
		mntmNewMenuItem_2.setBackground(new Color(192, 192, 192));
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
		mntmNewMenuItem.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
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
		lblNewLabel.setBounds(398, 295, 163, 14);
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
		btnNewButton.setBounds(0, 286, 39, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("- Atualize seus dados -");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(73, 36, 197, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Alterar Nome");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = JOptionPane.showInputDialog(null, "Informe o novo nome completo: ");
						
				int idUser = userLogado.getIdUsuario();
				userVO = userDAO.consultarUsuarioPorIdInterfaceDAO(idUser);	
						
				boolean result = userDAO.atualizarEmailInterfaceDAO(userLogado, email);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Nome atualizado com sucesso!"
							+ "\nNome anterior: " +userLogado.getNome()
							+ "\nNovo nome: " + nome, "GS - Gerenciador de Salário", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
					dispose();
				    TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				    tela.setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_1.setBounds(10, 75, 120, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar email");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//VERIFICAR SE EMAIL É VÁLIDO
				do {
				
				email = JOptionPane.showInputDialog(null, "Informe o novo E-mail: ");
				if (!email.contains("@") && !email.contains(".com")) {
					JOptionPane.showMessageDialog(null, "Digite um E-mail válido!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				}
						
				} while (!email.contains("@") && !email.contains(".com"));
				
				boolean result = userDAO.atualizarEmailInterfaceDAO(userLogado, email);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Email atualizado com sucesso!"
							+ "\nEmail anterior: " + userLogado.getEmail()
							+ "\nEmail novo: " + email, "GS - Gerenciador de Salário", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
					dispose();
				    TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				    tela.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_2.setBounds(10, 133, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar Login");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usrName = JOptionPane.showInputDialog(null, "Informe o novo Username: ");
					
				boolean result = userDAO.atualizarUsernameInterfaceDAO(userLogado, usrName);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Username atualizado com sucesso!"
							+ "\nNome anterior: " +userLogado.getLogin()
							+ "\nNovo nome: " + usrName, "GS - Gerenciador de Salário", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
					dispose();
				    TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				    tela.setVisible(true);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setBounds(10, 194, 120, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Alterar Salario Bruto");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				brut = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Informe o novo salário bruto: ")
						);
						
				boolean result = userDAO.atualizarBrutoInterfaceDAO(userLogado, brut);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Salário bruto atualizado com sucesso!"
							+ "\nBruto anterior: " +userLogado.getBruto()
							+ "\nNovo valor: " + brut, "GS - Gerenciador de Salário", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
					dispose();
				    TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				    tela.setVisible(true);
				}
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.setBounds(155, 75, 139, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Alterar Tipo de Usuário");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICACAO SE USUARIO É ADMINISTRADOR
				if (userLogado.getTipoUsuario() != 1) {
					JOptionPane.showMessageDialog(null, "Você não tem permissão!","GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if(userLogado.getTipoUsuario() == 1) {
				 resp = JOptionPane.showInputDialog("Deseja alterar seu tipo de usuário? "
				 		+ "\nAdministrator -> Cliente ");
				} else if(resp.equalsIgnoreCase("sim")) {
					userDAO.atualizarTipoDeUsuario(userLogado);
				} else if (userDAO.atualizarTipoDeUsuario(userLogado)) {
					JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!","GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_5.setBackground(new Color(192, 192, 192));
		btnNewButton_5.setBounds(155, 133, 139, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Alterar Todos os Dados");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAtualizarDadosTodos tela = new TelaAtualizarDadosTodos(userLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton_6.setBackground(new Color(192, 192, 192));
		btnNewButton_6.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_6.setBounds(155, 194, 139, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("* Não será possível alterar o CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 7));
		lblNewLabel_2.setBounds(332, 110, 181, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*Não será possível alterar a Data de nascimento ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 7));
		lblNewLabel_3.setBounds(318, 122, 256, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*Não será possível alterar Tipo de úsuario sendo cliente");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 7));
		lblNewLabel_4.setBounds(318, 138, 195, 14);
		contentPane.add(lblNewLabel_4);
	}

}

