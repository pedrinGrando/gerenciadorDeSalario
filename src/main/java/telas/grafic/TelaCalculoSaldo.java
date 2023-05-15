package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calculosINSSeIR.Calculos;
import model.dao.DespesaDAO;
import model.dao.TabelaDAO;
import model.dao.UserDAO;
import model.vo.TabelaVO;
import model.vo.UserVO;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaCalculoSaldo extends JFrame {
	private JTextField test2;
	private JTextField test1; 
	//OBJETOS
	Calculos calculos = new Calculos();
	UserVO userVO = new UserVO();
	TabelaVO tabela = new TabelaVO();
	TabelaDAO tabelaDAO = new TabelaDAO();
	UserDAO userDAO = new UserDAO();
	
	//VARIAVEIS
	String cpf = "" ;
	String nome = "" ;
	double saldo = 0;
	double VR = 0;
	
	// CONVERSAO DE MES 
	   LocalDate dataAtual = LocalDate.now(); //MES ATUAL
	   Locale brasil = new Locale("pt", "BR");
	   DateTimeFormatter fout1 = DateTimeFormatter.ofPattern("EEEE", brasil);
	   String mes = (dataAtual.getMonth().getDisplayName(TextStyle.FULL, brasil));
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCalculoSaldo frame = new TelaCalculoSaldo(null);
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
	public TelaCalculoSaldo(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(64, 128, 128));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 393);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setBounds(0, 300, 33, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnGerarCalculo = new JButton("Gerar cálculo mensal");
		btnGerarCalculo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnGerarCalculo.setBackground(new Color(192, 192, 192));
		btnGerarCalculo.addActionListener(new ActionListener() {
			private JLabel lbl_mes;
			private JLabel lbl_saldo;
			private JLabel lbl_saldoFInal;

			public void actionPerformed(ActionEvent e) {
				//OBJETOS 
				DespesaDAO despt = new DespesaDAO();
				
				saldo = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o saldo do mês: " +mes.toUpperCase())
				);
				double rest = userLogado.getBruto() + saldo;
				double saldoP = saldo;
				
				
				if (userLogado.getIdUsuario() == 0) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				}
				
				double inss = calculos.calcularINSS(userLogado.getBruto());
				
				double Desc = this.calcularDescontoTotal(userLogado, userLogado.getBruto());
				
				double liquidoFinal = rest - Desc; 
				
				double saldoFinal = liquidoFinal;
				
				String saldoF = " " +saldoFinal;
				String saldoM = ""+saldoP;
				
				//EXIBICAO FINAL
				lbl_mes = new JLabel("");
				lbl_mes.setBounds(116, 196, 84, 14);
				getContentPane().add(lbl_mes);
				lbl_mes.setText(mes.toUpperCase());
				
				lbl_saldo = new JLabel("");
				lbl_saldo.setBounds(259, 196, 90, 14);
				getContentPane().add(lbl_saldo);
				lbl_saldo.setText("R$ "+saldoM);
				
				lbl_saldoFInal = new JLabel("");
				lbl_saldoFInal.setBounds(154, 238, 118, 14);
				getContentPane().add(lbl_saldoFInal);
				lbl_saldoFInal.setText("R$ "+saldoFinal);
				
				
			    //INSERCAO NO OBJETO TABELA
				tabela.setAno(dataAtual.getYear());
				tabela.setIdUsuario(userLogado.getIdUsuario());
				tabela.setTotalRest(saldoFinal);
			    tabela.setSaldo(saldoP);
			    tabela.setData(mes);
				
			}

			//Calculo de despesas total
			private double calcularDescontoTotal(UserVO userVO, double bruto) {
				double total = 0;
				DespesaDAO despesaDAO = new DespesaDAO();
				total = despesaDAO.calcularDescontoTotalDAO(userVO, bruto);
				
				return total;
			}
		});
		btnGerarCalculo.setBounds(193, 78, 156, 23);
		getContentPane().add(btnGerarCalculo);
		
		JButton btn_salvarDados = new JButton("");
		btn_salvarDados.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\saveIcon.png"));
		btn_salvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabela = tabelaDAO.salvarDadosTabelaDAO(userLogado, tabela);
				
				if (tabela.getIdTabela() != 0) {
					JOptionPane.showMessageDialog(null, "Dados do mês: "+mes.toUpperCase() +
							"\nSalvos com sucesso!", "GS - Gerenciador de salário", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_salvarDados.setBackground(new Color(64, 128, 128));
		btn_salvarDados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btn_salvarDados.setBounds(391, 238, 41, 23);
		getContentPane().add(btn_salvarDados);
		
		JLabel lblNewLabel = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(0, 139, 604, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Calculo de saldo mensal ");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(193, 53, 208, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GS - Gerenciador de salário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel_2.setBounds(441, 304, 188, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mês :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(73, 196, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Saldo final :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(73, 238, 67, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Saldo :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(210, 196, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		
		
		
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Encerrar");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem_1.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FecharPrograma tela = new FecharPrograma(userLogado);
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
	
    }
}
