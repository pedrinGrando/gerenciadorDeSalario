package telas.grafic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import model.dao.DespesaDAO;
import model.dao.UserDAO;
import model.vo.DespesaVO;
import model.vo.UserVO;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaConsultarDespesa extends JFrame {

	String cpf = "";
	String divnome = "";
	UserVO userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	DespesaVO despesaVO = new DespesaVO();
	DespesaDAO despesaDAO = new DespesaDAO();
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarDespesa frame = new TelaConsultarDespesa(null);
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
	public TelaConsultarDespesa(final UserVO userLogado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\moneyIconTeste.png"));
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 396);
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
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
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
		
		JLabel lblNewLabel = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(0, 141, 613, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Despesa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_1.setBounds(115, 164, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBackground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(115, 208, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pagamento");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(244, 183, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Consultar Despesa");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel lblPag;
			private JLabel lblValor;
			private JLabel lblNomeDesp;

			public void actionPerformed(ActionEvent e) {
				
				if (userLogado.getIdUsuario() == 0) {
					JOptionPane.showMessageDialog(null, "Usuário inexistente!","GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if (userLogado.getIdUsuario() != 0) {
					divnome = JOptionPane.showInputDialog("Digite o nome da despesa a ser consultada:");
					despesaVO.setDivnome(divnome);
					
					despesaVO = despesaDAO.consultarDespesaPorNomeInterfaceDAO(despesaVO, userLogado.getIdUsuario());
				}
				
			    if (despesaVO.getIdDespesa() == 0) {
					JOptionPane.showMessageDialog(null, "Despesa não encontrada!","GS - Gerenciador de salário", JOptionPane.WARNING_MESSAGE);
				} else if (despesaVO.getIdDespesa() != 0) {
					
				
				//DATA FORMATADA
				DateTimeFormatter fin = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = despesaVO.getUltimoPagamento();
				
				String valorF = ""+despesaVO.getValor();
				
				lblNomeDesp = new JLabel("");
				lblNomeDesp.setBounds(125, 183, 90, 14);
				contentPane.add(lblNomeDesp);
				lblNomeDesp.setText(despesaVO.getDivnome());
				
				lblValor = new JLabel("");
				lblValor.setBounds(125, 240, 108, 14);
				contentPane.add(lblValor);
				lblValor.setText("R$ "+despesaVO.getValor());
				
				lblPag = new JLabel("");
				lblPag.setBounds(267, 208, 90, 14);
				contentPane.add(lblPag);
				lblPag.setText(""+despesaVO.getUltimoPagamento());
				
				}
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(207, 84, 170, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("GS - Gerenciador de salário");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel_5.setBounds(443, 314, 165, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" Consulta de despesa ");
		lblNewLabel_6.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(207, 59, 205, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\newBackIcon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenu tela = new TelaMenu(userLogado);
				tela.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton_1.setBounds(0, 305, 33, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
