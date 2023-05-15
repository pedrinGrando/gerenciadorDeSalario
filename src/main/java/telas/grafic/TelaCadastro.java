package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.controller.UserCONTROLLER;
import model.dao.UserDAO;
import model.vo.UserVO;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaCadastro extends JFrame {

	//USUARIO E VARIAVEIS
	UserVO userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	UserCONTROLLER userContrller = new UserCONTROLLER();
	DateTimeFormatter fin = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private JPanel contentPane;
	private JTextField name_camp;
	private JTextField email_camp;
	private JTextField bruto_camp;
	private JTextField liquido_camp;
	private JTextField login_camp;
	private final JLabel lblASenhaSera = new JLabel("A senha sera os últimos 4 dígitos do seu CPF.");
	private final JLabel lblNewLabel_1 = new JLabel("GS - Gerenciador de salário");
	private JTextField dataNasci_camp;
	private JTextField campo_cpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 390);
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
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserVO userLogado = new UserVO();
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
		
		JLabel lblNewLabel = new JLabel(" Registrar novo usuário ");
		lblNewLabel.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(102, 32, 208, 14);
		contentPane.add(lblNewLabel);
		
		
		
		campo_cpf = new JTextField();
		campo_cpf.setBounds(9, 112, 156, 20);
		contentPane.add(campo_cpf);
		campo_cpf.setColumns(10);
		
		dataNasci_camp = new JTextField();
		dataNasci_camp.setBounds(9, 154, 156, 20);
		contentPane.add(dataNasci_camp);
		dataNasci_camp.setColumns(10);
		
		name_camp = new JTextField();
		name_camp.setBounds(9, 68, 156, 20);
		contentPane.add(name_camp);
		name_camp.setColumns(10);
		
		email_camp = new JTextField();
		email_camp.setBounds(9, 202, 156, 20);
		contentPane.add(email_camp);
		email_camp.setColumns(10);
		
		bruto_camp = new JTextField();
		bruto_camp.setBounds(231, 68, 103, 20);
		contentPane.add(bruto_camp);
		bruto_camp.setColumns(10);
		
		liquido_camp = new JTextField();
		liquido_camp.setBounds(231, 112, 103, 20);
		contentPane.add(liquido_camp);
		liquido_camp.setColumns(10);
		
		login_camp = new JTextField();
		login_camp.setBounds(231, 154, 103, 20);
		contentPane.add(login_camp);
		login_camp.setColumns(10);
		
		JButton btn_registrar = new JButton(" Registrar ");
		btn_registrar.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\saveIcon.png"));
		btn_registrar.setBackground(new Color(192, 192, 192));
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userVO.setTipoUsuario(2);
				userVO.setNome(name_camp.getText());
				//INSERIR CPF
				userVO.setCpf(campo_cpf.getText());
				userVO.setDataNasci(LocalDate.parse(dataNasci_camp.getText(), fin));
				userVO.setEmail(email_camp.getText());
				userVO.setBruto(Double.parseDouble(bruto_camp.getText()));
				userVO.setLiquido(Double.parseDouble(liquido_camp.getText()));	
				
				//EXTRACAO DE SENHA 
				String senha = campo_cpf.getText().substring(7);
				userVO.setSenha(senha);
				userVO.setLogin(login_camp.getText());
				
				//VALIDANDO CAMPOS DIGITADOS
				if (campo_cpf.getText().length() != 11) {
					JOptionPane.showMessageDialog(null, "INVALID CPF!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if(userDAO.verificarExistenciaRegistroPorCpfDAO(userVO)) {
					JOptionPane.showMessageDialog(null, "CPF ALREADY REGISTERED!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
		
				} else if (userVO.getDataNasci().getYear() > 2004) {
					JOptionPane.showMessageDialog(null, "INVALID AGE,\nYOU NEED TO HAVE AT LEAST \n18 YEARS TO REGISTER!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if(!email_camp.getText().contains("@")) {
					JOptionPane.showMessageDialog(null, "INVALID E-MAIL!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if (validarCamposCadastro(userVO)) {
					userVO = userContrller.cadastrarUsuarioController(userVO);
					dispose();
					TelaLogin tela = new TelaLogin();
					tela.setVisible(true);
			}  
		{
			//VERIFICACAO DE REGISTRO
			
			if (userVO.getIdUsuario() != 0) {
				JOptionPane.showMessageDialog(null, "SUCCESSFUL REGISTRATION!", "GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "IT WAS NOT POSSIBLE, PLEASE\nTRY AGAIN!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
			}
		       }
			    
			}
		});
		
		
		btn_registrar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_registrar.setBounds(231, 201, 121, 23);
		contentPane.add(btn_registrar);
		lblASenhaSera.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblASenhaSera.setBounds(104, 253, 232, 19);
		contentPane.add(lblASenhaSera);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel_1.setBounds(402, 299, 138, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(9, 56, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(9, 99, 156, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4.setBounds(9, 143, 156, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(9, 190, 156, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salário Bruto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_6.setBounds(231, 56, 103, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Salário Líquido");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_7.setBounds(231, 99, 103, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nome de Usuário");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_8.setBounds(231, 143, 103, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("R$");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_9.setBounds(216, 70, 13, 17);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("R$");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_10.setBounds(216, 115, 13, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btn_voltar = new JButton("");
		btn_voltar.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		btn_voltar.setBackground(new Color(64, 128, 128));
		btn_voltar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_voltar.setBounds(0, 298, 37, 23);
		contentPane.add(btn_voltar);
		
	}
	
	// METODOS 
	
        private boolean validarCamposCadastro(UserVO userVO) {
		
		boolean resultado = true;
		System.out.println();
		if (userVO.getNome() == null || userVO.getNome().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O nome é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
		}
		
		if (userVO.getCpf() == null || userVO.getCpf().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O CPF é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
		}
		
		if (userVO.getDataNasci() == null) {
			JOptionPane.showMessageDialog(null, "A data de nascimento é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
		
		}
		
		if (userVO.getEmail() == null || userVO.getEmail().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O E-mail é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
			
		} 
		
		if (!userVO.getEmail().contains("@") && !userVO.getEmail().contains(".com")) {
			JOptionPane.showMessageDialog(null, "Digite um E-mail válido!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
		}
		
		if (userVO.getLogin() == null || userVO.getLogin().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O Login é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
			resultado = false;
			
		}
		
		
		if (userVO.getBruto() == 0) {
			JOptionPane.showMessageDialog(null, "O Salário Bruto é obrigatório!", "GS - Gerenciador de Salário", JOptionPane.WARNING_MESSAGE);
		resultado = false;
		}
		
		return resultado;
	}
}
