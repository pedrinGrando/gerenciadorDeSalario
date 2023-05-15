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
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaAtualizarDadosTodos extends JFrame {

	UserVO userAtualizado = new UserVO();
	UserVO userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	String cpf = "";
	DespesaDAO depst = new DespesaDAO();
	
	private JPanel contentPane;
	private JTextField novoNome_camp;
	private JTextField novoEmail_camp;
	private JTextField novoUser_camp;
	private JTextField novoBruto_camp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarDadosTodos frame = new TelaAtualizarDadosTodos(null);
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
	public TelaAtualizarDadosTodos(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 399);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
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
		lblNewLabel.setBounds(395, 320, 163, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton.setBounds(0, 311, 41, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("- Atualizar Dados Completos -");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(0, 63, 218, 14);
		contentPane.add(lblNewLabel_1);
		
		novoNome_camp = new JTextField();
		novoNome_camp.setBounds(10, 112, 163, 20);
		contentPane.add(novoNome_camp);
		novoNome_camp.setColumns(10);
		
		novoEmail_camp = new JTextField();
		novoEmail_camp.setBounds(10, 167, 163, 20);
		contentPane.add(novoEmail_camp);
		novoEmail_camp.setColumns(10);
		
		novoUser_camp = new JTextField();
		novoUser_camp.setBounds(10, 226, 117, 20);
		contentPane.add(novoUser_camp);
		novoUser_camp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(10, 98, 163, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Novo E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_3.setBounds(10, 153, 163, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Novo Username");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_4.setBounds(10, 213, 163, 14);
		contentPane.add(lblNewLabel_4);
		
		novoBruto_camp = new JTextField();
		novoBruto_camp.setBounds(235, 112, 86, 20);
		contentPane.add(novoBruto_camp);
		novoBruto_camp.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Novo Salário Bruto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(235, 98, 96, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("R$");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(219, 115, 13, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton(" Salvar ");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\saveIcon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//INSERINDO NOVOS DADOS
				userAtualizado.setBruto(Double.parseDouble(novoBruto_camp.getText()));
				userAtualizado.setEmail(novoEmail_camp.getText());
				userAtualizado.setNome(novoNome_camp.getText());
				userAtualizado.setLogin(novoUser_camp.getText());
				userAtualizado.setIdUsuario(userLogado.getIdUsuario());
				
				boolean result = userDAO.atualizarUsuarioInterfaceDAO(userAtualizado);
				
				if (result) {
					JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "GS - Gerenciador de Salário", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_1.setBounds(232, 166, 105, 23);
		contentPane.add(btnNewButton_1);
	}
}
