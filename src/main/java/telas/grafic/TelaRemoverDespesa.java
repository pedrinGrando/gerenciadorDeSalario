package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.DespesaDAO;
import model.dao.UserDAO;
import model.vo.DespesaVO;
import model.vo.UserVO;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaRemoverDespesa extends JFrame {
	
	DespesaVO despesaNova = new DespesaVO();
	DespesaDAO despesaDAO = new DespesaDAO();

	private JPanel contentPane;
	private JTextField nomeDespesa_camp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverDespesa frame = new TelaRemoverDespesa(null);
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
	public TelaRemoverDespesa(final UserVO userLogado) {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newMenuIcon.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trocar usuário");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\changeUserIcon.png"));
		mntmNewMenuItem_1.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Excluir conta");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\removerIcon.png"));
		mntmNewMenuItem.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Encerrar");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem_2.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FecharPrograma tela = new FecharPrograma(userLogado);
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Encerrar");
		mntmNewMenuItem_3.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nomeDespesa_camp = new JTextField();
		nomeDespesa_camp.setBounds(49, 134, 115, 20);
		contentPane.add(nomeDespesa_camp);
		nomeDespesa_camp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da despesa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(39, 117, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_removerDespesa = new JButton(" Remover ");
		btn_removerDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VERIFICACAO DE EXIXTENCIA DE USUARIO
				UserDAO userDAO = new UserDAO();
				
				int idUser = userLogado.getIdUsuario();
				if (!userDAO.verificarExistenciaRegistroPorCpfDAO(userLogado)) {
					JOptionPane.showMessageDialog(null, "Usuário inexistente!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
					
				}else if (despesaDAO.removerDespesaInterfaceDAO(idUser, nomeDespesa_camp.getText())) {
					JOptionPane.showMessageDialog(null, "Despesa removida com sucesso!", "GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					TelaRemoverDespesa tela = new TelaRemoverDespesa(userLogado);
					tela.setVisible(true);
				}
			}
		});
		btn_removerDespesa.setBackground(new Color(192, 192, 192));
		btn_removerDespesa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_removerDespesa.setBounds(189, 133, 101, 23);
		contentPane.add(btn_removerDespesa);
		
		JLabel lblNewLabel_2 = new JLabel(" Remover despesa cadastrada ");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(95, 74, 279, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GS -Gerenciador de salário ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(292, 232, 190, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btn_voltar = new JButton("");
		btn_voltar.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu tela = new TelaMenu(userLogado);
				dispose();
				tela.setVisible(true);
			}
		});
		btn_voltar.setBackground(new Color(192, 192, 192));
		btn_voltar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn_voltar.setBounds(0, 223, 32, 23);
		contentPane.add(btn_voltar);
	}
}
