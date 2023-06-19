package supermarket.iu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ViewMain extends JFrame {
	
	private static final long serialVersionUID = 5306957481342113129L;
	private static ViewGerenteProdutos gerenteProdutos = new ViewGerenteProdutos();
	public static final String VERSAO = "v1.5.0", BUILD = " - DevTesting";
	private static final String NOME_USUARIO = "Admin", SENHA_USUARIO = "Admin";
	private JPanel cpPainelGeral;
	private JTextField tfNomeUsuario;
	private JPasswordField pwdSenha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain frame = new ViewMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewMain() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setTitle("Supermarket Manager : Iniciar Sessão");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		cpPainelGeral = new JPanel();
		cpPainelGeral.setFocusable(false);
		cpPainelGeral.setBackground(new Color(54, 57, 62));
		cpPainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cpPainelGeral);
		cpPainelGeral.setLayout(null);
		
		JPanel pFundoLogin = new JPanel();
		pFundoLogin.setFocusable(false);
		pFundoLogin.setBackground(new Color(40, 43, 48));
		pFundoLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pFundoLogin.setBounds(10, 11, 564, 339);
		cpPainelGeral.add(pFundoLogin);
		pFundoLogin.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Iniciar Sessão");
		lblTitulo.setFocusable(false);
		lblTitulo.setBounds(162, 23, 240, 37);
		pFundoLogin.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblTitulo.setForeground(new Color(220, 223, 226));
		
		JLabel lblNomeUsuario = new JLabel("Nome de usuário");
		lblNomeUsuario.setFocusable(false);
		lblNomeUsuario.setBounds(109, 93, 346, 19);
		pFundoLogin.add(lblNomeUsuario);
		lblNomeUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblNomeUsuario.setForeground(new Color(255, 255, 255));
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setCaretColor(new Color(255, 255, 255));
		tfNomeUsuario.setForeground(new Color(255, 255, 255));
		tfNomeUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tfNomeUsuario.setBackground(new Color(30, 33, 36));
		tfNomeUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNomeUsuario.setBounds(109, 117, 346, 26);
		pFundoLogin.add(tfNomeUsuario);
		tfNomeUsuario.setColumns(10);
		
		JLabel lblSenhaUsuario = new JLabel("Senha");
		lblSenhaUsuario.setForeground(Color.WHITE);
		lblSenhaUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblSenhaUsuario.setFocusable(false);
		lblSenhaUsuario.setBounds(109, 154, 346, 19);
		pFundoLogin.add(lblSenhaUsuario);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setCaretColor(new Color(255, 255, 255));
		pwdSenha.setForeground(new Color(255, 255, 255));
		pwdSenha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		pwdSenha.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pwdSenha.setBackground(new Color(30, 33, 36));
		pwdSenha.setBounds(109, 178, 346, 26);
		pFundoLogin.add(pwdSenha);
		
		JButton btnLogar = new JButton("Iniciar sessão");
		btnLogar.setForeground(new Color(255, 255, 255));
		btnLogar.setBackground(new Color(30, 33, 36));
		btnLogar.setToolTipText("Clique para iniciar sessão com o usuário e senha fornecidos acima.");
		btnLogar.setFocusable(false);
		btnLogar.setBounds(124, 223, 140, 36);
		pFundoLogin.add(btnLogar);
		btnLogar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senhaInsirida = String.valueOf(pwdSenha.getPassword());
				if(tfNomeUsuario.getText().equals(NOME_USUARIO) && senhaInsirida.equals(SENHA_USUARIO)) {
					gerenteProdutos.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Verifique seus dados e tente novamente.", "Nome de usuário ou senha incorreto", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(30, 33, 36));
		btnCadastrar.setToolTipText("Atualmente não é possível cadastrar novos usuários no sistema.");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setFocusable(false);
		btnCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnCadastrar.setBounds(300, 223, 140, 36);
		pFundoLogin.add(btnCadastrar);
		
		JLabel lblCopyright = new JLabel("Supermarket Manager © - Todos os direitos reservados");
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		lblCopyright.setFocusable(false);
		lblCopyright.setBounds(145, 320, 274, 19);
		pFundoLogin.add(lblCopyright);
		
		JLabel lblVersao = new JLabel(VERSAO + BUILD + " (18/06/23)");
		lblVersao.setForeground(Color.WHITE);
		lblVersao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 8));
		lblVersao.setFocusable(false);
		lblVersao.setBounds(443, 321, 121, 19);
		pFundoLogin.add(lblVersao);
	}
}
