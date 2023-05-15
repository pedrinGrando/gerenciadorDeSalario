package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import model.vo.UserVO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;

public class TelaInserirDespesa extends JFrame {

	//VARIAVEIS/OBJETOS;
	DespesaVO despesaNova = new DespesaVO();
	DespesaDAO despesaDAO = new DespesaDAO();
	
	
	private JPanel contentPane;
	private JTextField nomeDespesa_camp;
	private JTextField valorDespesaCamp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserirDespesa frame = new TelaInserirDespesa(null);
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
	public TelaInserirDespesa(final UserVO userLogado) {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setResizable(false);
		setTitle("GS - Gerenciador de Salário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 333);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trocar usuário");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\changeUserIcon.png"));
		mntmNewMenuItem_1.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Encerrar");
		mntmNewMenuItem.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GS - Gerenciador de Salário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel.setBounds(325, 249, 162, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Inserira os dados da despesa nova  ");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(98, 188, 253, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu tela = new TelaMenu(userLogado);
				dispose();
				tela.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setBounds(0, 245, 37, 23);
		contentPane.add(btnNewButton);
		
		nomeDespesa_camp = new JTextField();
		nomeDespesa_camp.setBounds(30, 71, 131, 20);
		contentPane.add(nomeDespesa_camp);
		nomeDespesa_camp.setColumns(10);
		
		valorDespesaCamp = new JTextField();
		valorDespesaCamp.setBounds(30, 120, 131, 20);
		contentPane.add(valorDespesaCamp);
		valorDespesaCamp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome da Despesa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(20, 56, 141, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valor da despesa");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_4.setBounds(20, 109, 106, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("R$");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(10, 123, 13, 14);
		contentPane.add(lblNewLabel_5);
		
		
		JButton btn_inserir_camp = new JButton(" Inserir ");
		btn_inserir_camp.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\inserirIcon.png"));
		btn_inserir_camp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idUserDesp = userLogado.getIdUsuario();
			
				LocalDate dataAtual = LocalDate.now();
			
				despesaNova.setIdUsuario(idUserDesp);
				despesaNova.setDivnome(nomeDespesa_camp.getText());
				despesaNova.setValor(Double.parseDouble(valorDespesaCamp.getText()));
				despesaNova.setUltimoPagamento(dataAtual);
				
				despesaNova = despesaDAO.inserirDespesaNovaInterfaceDAO(despesaNova);
				
				if (despesaNova.getIdDespesa() != 0) {
					JOptionPane.showMessageDialog(null, "Despesa nova inserida com sucesso! ", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível inserir! ", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btn_inserir_camp.setBackground(new Color(192, 192, 192));
		btn_inserir_camp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_inserir_camp.setBounds(201, 92, 121, 23);
		contentPane.add(btn_inserir_camp);
		
	}
}
