package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.vo.UserVO;
import model.vo.TabelaVO;
import model.dao.TabelaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaConsultaMes extends JFrame {
	
	//VARIAVEIS CRIADAS
	String mesConsultado = "";
	String mesAnterior = "";
	TabelaVO tabelaVO = new TabelaVO();
	TabelaVO tab = new TabelaVO();
	TabelaDAO tabelaDAO = new TabelaDAO();
	double crescimento = 0;
	String porcent = "";
	
	private JPanel contentPane;
	private JTextField camp_mes;
	private JTextField camp_saldoAnterior;
	private JTextField anoConsulatdo;
	private JTextField saldoMes;
	private JTextField textField;
	private JTextField crescimento_camp;
	private JTextField meta_camp;
	private JTextField camp_mesAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaMes frame = new TelaConsultaMes(null);
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
	public TelaConsultaMes(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setTitle("GS - Gerenciador de salário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 488);
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
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 11));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Encerrar");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\encerrar.png"));
		mntmNewMenuItem_2.setBackground(new Color(192, 192, 192));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FecharPrograma tela = new FecharPrograma(userLogado);
				tela.setVisible(true);
			}
		});
		
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
		
		JLabel lblNewLabel = new JLabel("GS - Gerenciador de salário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel.setBounds(454, 408, 163, 14);
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
		btnNewButton.setBounds(0, 403, 32, 19);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Consulta de mês regular");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(170, 42, 236, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Realizar Consulta Mensal ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesConsultado = JOptionPane.showInputDialog("Informe o mês a ser consultado: ");
				if (mesConsultado.isEmpty() || mesConsultado.isEmpty()) {
					dispose();
					TelaConsultaMes tela = new TelaConsultaMes(userLogado);
					tela.setVisible(true);
				}
				
				tabelaVO.setData(mesConsultado);
				tabelaVO.setIdUsuario(userLogado.getIdUsuario());
				
				//CONSULTANDO MES
				tabelaVO = tabelaDAO.consultarMesTabelaDAO(tabelaVO);
				//VERIFICACOES
			    if (tabelaVO.getIdTabela() == 0) {
			    	JOptionPane.showMessageDialog(null, "Dados do mês  " + mesConsultado 
			    			+"\n não encontrados! ", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
			    	
			    } else {
			    	
			    	saldoMes = new JTextField("R$ "+tabelaVO.getTotalRest());
					saldoMes.setBackground(new Color(64, 128, 128));
					saldoMes.setEditable(false);
					saldoMes.setBounds(235, 197, 86, 20);
					contentPane.add(saldoMes);
					saldoMes.setColumns(10);
					
					camp_mes = new JTextField(tabelaVO.getData());
					camp_mes.setBackground(new Color(64, 128, 128));
					camp_mes.setEditable(false);
					camp_mes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
					camp_mes.setBounds(37, 132, 86, 20);
					contentPane.add(camp_mes);
					camp_mes.setColumns(10);
					
					camp_saldoAnterior = new JTextField("R$ "+tabelaVO.getSaldo());
					camp_saldoAnterior.setBackground(new Color(64, 128, 128));
					camp_saldoAnterior.setEditable(false);
					camp_saldoAnterior.setBounds(92, 196, 104, 20);
					contentPane.add(camp_saldoAnterior);
					camp_saldoAnterior.setColumns(10);
					
					anoConsulatdo = new JTextField(""+tabelaVO.getAno());
					anoConsulatdo.setBackground(new Color(64, 128, 128));
					anoConsulatdo.setEditable(false);
					anoConsulatdo.setBounds(160, 132, 86, 20);
					contentPane.add(anoConsulatdo);
					anoConsulatdo.setColumns(10);
			    	
			    }
				
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(180, 83, 191, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo do mês");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(191, 182, 133, 14);
		contentPane.add(lblNewLabel_3);
		
		camp_mes = new JTextField();
		camp_mes.setBackground(new Color(64, 128, 128));
		camp_mes.setEditable(false);
		camp_mes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		camp_mes.setBounds(18, 142, 86, 20);
		contentPane.add(camp_mes);
		camp_mes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mês");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(8, 117, 98, 14);
		contentPane.add(lblNewLabel_2);
		
		camp_saldoAnterior = new JTextField();
		camp_saldoAnterior.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		camp_saldoAnterior.setBackground(new Color(64, 128, 128));
		camp_saldoAnterior.setEditable(false);
		camp_saldoAnterior.setBounds(73, 206, 104, 20);
		contentPane.add(camp_saldoAnterior);
		camp_saldoAnterior.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Saldo guardado do mês anterior");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(8, 181, 173, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_5.setBounds(10, 295, 859, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Gerar dados de crescimento");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IDENTIFICAR MES ANTERIOR AO DIGITADO
				mesAnterior = identificarMesAnteior(mesConsultado);
				tab.setData(mesAnterior);
				tab.setIdUsuario(userLogado.getIdUsuario());
				tab = tabelaDAO.consultarMesTabelaDAO(tab);
				
				if (tab.getIdTabela() != 0) {
					
					crescimento = tabelaVO.getSaldo() - tab.getSaldo();
					porcent = calcularPorcentMeta(crescimento);
					
					crescimento_camp = new JTextField("R$ "+crescimento);
					crescimento_camp.setBackground(new Color(64, 128, 128));
					crescimento_camp.setBounds(173, 345, 104, 20);
					contentPane.add(crescimento_camp);
					crescimento_camp.setColumns(10);
					
					meta_camp = new JTextField(""+porcent);
					meta_camp.setBackground(new Color(64, 128, 128));
					meta_camp.setBounds(383, 345, 86, 20);
					contentPane.add(meta_camp);
					meta_camp.setColumns(10);
					
					camp_mesAnterior = new JTextField(""+tab.getData());
					camp_mesAnterior.setEditable(false);
					camp_mesAnterior.setBackground(new Color(64, 128, 128));
					camp_mesAnterior.setBounds(30, 345, 86, 20);
					contentPane.add(camp_mesAnterior);
					camp_mesAnterior.setColumns(10);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Os dados do mês anterior não foram encontrados!", "GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				}
			
			}

			private String calcularPorcentMeta(double crescimento) {
				String meta = "";
				
				if (crescimento >= 100) {
					meta = "20%";
				} else if(crescimento >= 250) {
					meta = "30%";
				} else if(crescimento >= 350) {
					meta = "40%";
				} else if (crescimento >= 550) {
					meta = "50%";
				}else if(crescimento >=700) {
					meta = "65%";
				} else if(crescimento >=1000) {
					meta = "85%";
				} else {
					meta = "50%";
				}
				
				return meta;
			}

			private String identificarMesAnteior(String mesConsultado) {
				String mesAnterior = "";
				
				if (mesConsultado.equalsIgnoreCase("janeiro")) {
					mesAnterior = "dezembro";
				}else if(mesConsultado.equalsIgnoreCase("fevereiro")) {
					mesAnterior = "janeiro";
				}else if(mesConsultado.equalsIgnoreCase("março")) {
					mesAnterior = "fevereiro";
				}else if(mesConsultado.equalsIgnoreCase("abril")) {
					mesAnterior = "março";
				}else if(mesConsultado.equalsIgnoreCase("maio")) {
					mesAnterior = "abril";
				}else if(mesConsultado.equalsIgnoreCase("junho")) {
					mesAnterior = "maio";
				}else if(mesConsultado.equalsIgnoreCase("julho")) {
					mesAnterior = "junho";
				}else if(mesConsultado.equalsIgnoreCase("agosto")) {
					mesAnterior = "julho";
				}else if(mesConsultado.equalsIgnoreCase("setembro")) {
					mesAnterior = "agosto";
				}else if(mesConsultado.equalsIgnoreCase("outubro")) {
					mesAnterior = "setembro";
				}else if(mesConsultado.equalsIgnoreCase("novembro")) {
					mesAnterior = "outubro";
				}else if(mesConsultado.equalsIgnoreCase("dezembro")) {
					mesAnterior = "novembro";
				}
				
				return mesAnterior;
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_2.setBounds(133, 263, 191, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Ano");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_6.setBounds(131, 117, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		anoConsulatdo = new JTextField();
		anoConsulatdo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		anoConsulatdo.setBackground(new Color(64, 128, 128));
		anoConsulatdo.setEditable(false);
		anoConsulatdo.setBounds(141, 142, 86, 20);
		contentPane.add(anoConsulatdo);
		anoConsulatdo.setColumns(10);
		
		saldoMes = new JTextField();
		saldoMes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		saldoMes.setBackground(new Color(64, 128, 128));
		saldoMes.setEditable(false);
		saldoMes.setBounds(216, 207, 86, 20);
		contentPane.add(saldoMes);
		saldoMes.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Crescimento em relação ao mês anterior");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_7.setBounds(120, 320, 284, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Meta para próximo mês");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_8.setBounds(373, 320, 214, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Mês");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_9.setBounds(36, 320, 46, 14);
		contentPane.add(lblNewLabel_9);
	
		crescimento_camp = new JTextField();
		crescimento_camp.setBackground(new Color(64, 128, 128));
		crescimento_camp.setBounds(173, 345, 104, 20);
		contentPane.add(crescimento_camp);
		crescimento_camp.setColumns(10);
		
		meta_camp = new JTextField();
		meta_camp.setBackground(new Color(64, 128, 128));
		meta_camp.setBounds(383, 345, 86, 20);
		contentPane.add(meta_camp);
		meta_camp.setColumns(10);
		
		camp_mesAnterior = new JTextField();
		camp_mesAnterior.setEditable(false);
		camp_mesAnterior.setBackground(new Color(64, 128, 128));
		camp_mesAnterior.setBounds(30, 345, 86, 20);
		contentPane.add(camp_mesAnterior);
		camp_mesAnterior.setColumns(10);
		
		
	}
}
