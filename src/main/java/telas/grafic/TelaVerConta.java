package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.DespesaDAO;
import model.dao.UserDAO;
import model.vo.UserVO;
import telas.grafic.FecharPrograma;
import telas.grafic.TelaLogin;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVerConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVerConta frame = new TelaVerConta(null);
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
	public TelaVerConta(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 438);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
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
		lblNewLabel.setBounds(460, 358, 163, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenu tela = new TelaMenu(userLogado);
				tela.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton.setBounds(0, 349, 37, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 72, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelPrincipal_nome = new JLabel("Seus dados");
		labelPrincipal_nome.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 18));
		labelPrincipal_nome.setBounds(236, 11, 205, 25);
		contentPane.add(labelPrincipal_nome);
		
		JLabel lblNewLabel_2 = new JLabel("CPF :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(10, 97, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(10, 122, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salário Bruto : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setBounds(10, 147, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Despesas Totais : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_5.setBounds(10, 172, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel nome_label = new JLabel("");
		nome_label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		nome_label.setBounds(123, 72, 340, 14);
		contentPane.add(nome_label);
		
		nome_label.setText(userLogado.getNome());
		
		JLabel cpf_label = new JLabel("");
		cpf_label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		cpf_label.setBounds(55, 97, 163, 14);
		contentPane.add(cpf_label);
		
		cpf_label.setText(userLogado.getCpf());
		
		JLabel email_label = new JLabel("");
		email_label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		email_label.setBounds(55, 122, 179, 14);
		contentPane.add(email_label);
		
		email_label.setText(userLogado.getEmail());
		
		JLabel salario_label = new JLabel("");
		salario_label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		salario_label.setBounds(104, 147, 383, 14);
		contentPane.add(salario_label);
		
		salario_label.setText("R$ "+userLogado.getBruto());
		
		JLabel despesas_label = new JLabel("");
		despesas_label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		despesas_label.setBounds(123, 172, 416, 14);
		contentPane.add(despesas_label);
		
		double desc = calcularDescontoTotal(userLogado, userLogado.getBruto());
		despesas_label.setText("R$ "+desc);
		
		JButton btnNewButton_1 = new JButton("Alterar dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\atualizarIcon.png"));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_1.setBounds(65, 212, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir conta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean retorn = false;
				String resp = JOptionPane.showInputDialog("Tem certeza que deseja excluir seu usuário?\n"
						+userLogado.getNome() + " Digite:"
								+ "\n1-Confirmar"
								+ "\n2-Cancelar");
				if (resp.equals("1")) {
				UserDAO user = new UserDAO();
				retorn = user.excluirContaUsuarioInterface(userLogado);
				JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!", "GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
				} else if (resp.equals("2")) {
				   dispose();
				   TelaMenu tela = new TelaMenu(userLogado);
				   tela.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\excluir.png"));
		btnNewButton_2.setBounds(242, 212, 142, 23);
		contentPane.add(btnNewButton_2);
		
	}
	
	//Calculo de despesas total
	private double calcularDescontoTotal(UserVO userVO, double bruto) {
		double total = 0;
		DespesaDAO despesaDAO = new DespesaDAO();
		total = despesaDAO.calcularDescontoTotalDAO(userVO, bruto);
		
		return total;
	}
}
