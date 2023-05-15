package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.DespesaDAO;
import model.dao.UserDAO;
import model.vo.UserVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class TelaMenu extends JFrame {

	TelaLogin teste = new TelaLogin();
	String cpf = "";
	double valorAumento = 0;
	double valorDesconto = 0;
	UserVO userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	DespesaDAO despt = new DespesaDAO();
	int idUser = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu(null);
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
	public TelaMenu(final UserVO userLogado) {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(64, 128, 128));
		menuBar.setBackground(new Color(64, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
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
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver conta");
		mntmNewMenuItem_3.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\verConta.png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaVerConta tela =  new TelaVerConta(userLogado);
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Excluir conta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("- GS - Opções -");
		lblNewLabel.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(246, 36, 200, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				dispose();
				tela.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setBounds(0, 306, 32, 29);
		contentPane.add(btnNewButton);
		
		JButton btn_calculoDeSaldo = new JButton(" Calculo de Saldo ");
		btn_calculoDeSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCalculoSaldo tela = new TelaCalculoSaldo(userLogado);
				tela.setVisible(true);
				
			}
		});
		btn_calculoDeSaldo.setBackground(new Color(192, 192, 192));
		btn_calculoDeSaldo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_calculoDeSaldo.setBounds(99, 78, 194, 23);
		contentPane.add(btn_calculoDeSaldo);
		
		JButton btn_inserirDespesa = new JButton("  Inserir Despesa ");
		btn_inserirDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaInserirDespesa tela = new TelaInserirDespesa(userLogado);
			dispose();
				tela.setVisible(true);
			}
		});
		btn_inserirDespesa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_inserirDespesa.setBackground(new Color(192, 192, 192));
		btn_inserirDespesa.setBounds(99, 125, 194, 23);
		contentPane.add(btn_inserirDespesa);
		
		JButton btn_removerDespesa = new JButton(" Remover Despesa ");
		btn_removerDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverDespesa tela = new TelaRemoverDespesa(userLogado);
				dispose();
				tela.setVisible(true);
			}
		});
		btn_removerDespesa.setBackground(new Color(192, 192, 192));
		btn_removerDespesa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_removerDespesa.setBounds(99, 171, 194, 23);
		contentPane.add(btn_removerDespesa);
		
		JButton btnNewButton_4 = new JButton(" Atualizar Dados ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlteracaoDeDados tela = new TelaAlteracaoDeDados(userLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.setBounds(324, 78, 200, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btn_consultarDespesa = new JButton("Consultar Despesa ");
		btn_consultarDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaConsultarDespesa tela =  new TelaConsultarDespesa(userLogado);
				tela.setVisible(true);
			}
		});
		btn_consultarDespesa.setBackground(new Color(192, 192, 192));
		btn_consultarDespesa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_consultarDespesa.setBounds(216, 217, 194, 23);
		contentPane.add(btn_consultarDespesa);
		
		JButton btn_consultadeUsuario = new JButton(" Consulta de Usuário ");
		btn_consultadeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				 if (userLogado.getTipoUsuario() == 2) {
					JOptionPane.showMessageDialog(null, "É necessário ser administrador para acessar esta função!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				}  else if(userLogado.getCpf() == null) {
					JOptionPane.showMessageDialog(null, "Erro para encontrar o CPF! ", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if (userLogado.getTipoUsuario() == 1) {
					dispose();
					TelaConsultaDeUsuario tela = new TelaConsultaDeUsuario(userLogado);
					tela.setVisible(true);
				}else {
					dispose();
					TelaMenu tela = new TelaMenu(userLogado);
				    tela.setVisible(true);
				}
			}
		});
		btn_consultadeUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btn_consultadeUsuario.setBackground(new Color(192, 192, 192));
		btn_consultadeUsuario.setBounds(324, 125, 200, 23);
		contentPane.add(btn_consultadeUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("GS - Gerenciador de Salário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel_1.setBounds(480, 315, 144, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Consulta de mês");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			    TelaConsultaMes tela = new TelaConsultaMes(userLogado);
				tela.setVisible(true);
			
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setBounds(324, 171, 200, 23);
		contentPane.add(btnNewButton_2);
	}
}
