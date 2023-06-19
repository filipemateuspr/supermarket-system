package supermarket.iu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import supermarket.core.*;

public class ViewGerenteProdutos extends JFrame {
	
	private static final long serialVersionUID = 5306957481342113129L;
	public JPanel cpPainelGeral;
	public static Main p = new Main();
	public static Venda venda = new Venda();
	public static Produto prod = new Produto();
	public static ViewAdicionarProduto view = new ViewAdicionarProduto();
	
	public ViewGerenteProdutos() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setTitle("Supermarket Manager : Gerenciador de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		cpPainelGeral = new JPanel();
		cpPainelGeral.setBackground(new Color(54, 57, 62));
		cpPainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpPainelGeral);
		cpPainelGeral.setLayout(null);
		
		JPanel pFundoListaProdutos = new JPanel();
		pFundoListaProdutos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pFundoListaProdutos.setBackground(new Color(40, 43, 48));
		pFundoListaProdutos.setBounds(10, 10, 663, 590);
		cpPainelGeral.add(pFundoListaProdutos);
		pFundoListaProdutos.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Lista de Produtos");
		lblTitulo.setBounds(203, 6, 257, 28);
		pFundoListaProdutos.add(lblTitulo);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JTextPane tpIdProduto = new JTextPane();
		tpIdProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpIdProduto.setForeground(new Color(255, 255, 255));
		tpIdProduto.setBackground(new Color(30, 33, 36));
		tpIdProduto.setBounds(42, 61, 36, 424);
		pFundoListaProdutos.add(tpIdProduto);
		tpIdProduto.setEditable(false);
		tpIdProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JTextPane tpNomeProduto = new JTextPane();
		tpNomeProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpNomeProduto.setForeground(new Color(255, 255, 255));
		tpNomeProduto.setBackground(new Color(30, 33, 36));
		tpNomeProduto.setBounds(79, 61, 266, 424);
		pFundoListaProdutos.add(tpNomeProduto);
		tpNomeProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpNomeProduto.setEditable(false);
		
		JTextPane tpPrecoProduto = new JTextPane();
		tpPrecoProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpPrecoProduto.setForeground(new Color(255, 255, 255));
		tpPrecoProduto.setBackground(new Color(30, 33, 36));
		tpPrecoProduto.setBounds(345, 61, 90, 424);
		pFundoListaProdutos.add(tpPrecoProduto);
		tpPrecoProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpPrecoProduto.setEditable(false);
		
		JTextPane tpQuantEstoqueProduto = new JTextPane();
		tpQuantEstoqueProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpQuantEstoqueProduto.setForeground(new Color(255, 255, 255));
		tpQuantEstoqueProduto.setBackground(new Color(30, 33, 36));
		tpQuantEstoqueProduto.setBounds(434, 61, 77, 424);
		pFundoListaProdutos.add(tpQuantEstoqueProduto);
		tpQuantEstoqueProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpQuantEstoqueProduto.setEditable(false);
		
		JTextPane tpDisponibilidadeProduto = new JTextPane();
		tpDisponibilidadeProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpDisponibilidadeProduto.setForeground(new Color(255, 255, 255));
		tpDisponibilidadeProduto.setBackground(new Color(30, 33, 36));
		tpDisponibilidadeProduto.setBounds(510, 61, 96, 424);
		pFundoListaProdutos.add(tpDisponibilidadeProduto);
		tpDisponibilidadeProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpDisponibilidadeProduto.setEditable(false);
		
		JLabel lblAcoesProdutos = new JLabel("Ações da Lista de Produtos");
		lblAcoesProdutos.setBounds(42, 484, 199, 19);
		pFundoListaProdutos.add(lblAcoesProdutos);
		lblAcoesProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcoesProdutos.setForeground(Color.WHITE);
		lblAcoesProdutos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JTextPane tpIdProdutoTitulo = new JTextPane();
		tpIdProdutoTitulo.setText("ID");
		tpIdProdutoTitulo.setForeground(Color.WHITE);
		tpIdProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpIdProdutoTitulo.setEditable(false);
		tpIdProdutoTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpIdProdutoTitulo.setBackground(new Color(30, 33, 36));
		tpIdProdutoTitulo.setBounds(42, 35, 36, 28);
		pFundoListaProdutos.add(tpIdProdutoTitulo);
		
		JTextPane tpNomeProdutoTitulo = new JTextPane();
		tpNomeProdutoTitulo.setText("NOME DO PRODUTO");
		tpNomeProdutoTitulo.setForeground(Color.WHITE);
		tpNomeProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpNomeProdutoTitulo.setEditable(false);
		tpNomeProdutoTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpNomeProdutoTitulo.setBackground(new Color(30, 33, 36));
		tpNomeProdutoTitulo.setBounds(79, 35, 266, 28);
		pFundoListaProdutos.add(tpNomeProdutoTitulo);
		
		JTextPane tpPrecoProdutoTitulo = new JTextPane();
		tpPrecoProdutoTitulo.setText("PREÇO");
		tpPrecoProdutoTitulo.setForeground(Color.WHITE);
		tpPrecoProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpPrecoProdutoTitulo.setEditable(false);
		tpPrecoProdutoTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpPrecoProdutoTitulo.setBackground(new Color(30, 33, 36));
		tpPrecoProdutoTitulo.setBounds(345, 35, 90, 28);
		pFundoListaProdutos.add(tpPrecoProdutoTitulo);
		
		JTextPane tpQuantEstoqueProdutoTitulo = new JTextPane();
		tpQuantEstoqueProdutoTitulo.setText("QTD");
		tpQuantEstoqueProdutoTitulo.setForeground(Color.WHITE);
		tpQuantEstoqueProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpQuantEstoqueProdutoTitulo.setEditable(false);
		tpQuantEstoqueProdutoTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpQuantEstoqueProdutoTitulo.setBackground(new Color(30, 33, 36));
		tpQuantEstoqueProdutoTitulo.setBounds(434, 35, 77, 28);
		pFundoListaProdutos.add(tpQuantEstoqueProdutoTitulo);
		
		JTextPane tpDisponibilidadeProdutoTitulo = new JTextPane();
		tpDisponibilidadeProdutoTitulo.setText("ESTOQUE");
		tpDisponibilidadeProdutoTitulo.setForeground(Color.WHITE);
		tpDisponibilidadeProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tpDisponibilidadeProdutoTitulo.setEditable(false);
		tpDisponibilidadeProdutoTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpDisponibilidadeProdutoTitulo.setBackground(new Color(30, 33, 36));
		tpDisponibilidadeProdutoTitulo.setBounds(510, 35, 96, 28);
		pFundoListaProdutos.add(tpDisponibilidadeProdutoTitulo);
		
		JTextPane tpQuantProdutosSistema = new JTextPane();
		tpQuantProdutosSistema.setText("Produtos cadastrados: " + prod.getIdProduto() + "/20");
		tpQuantProdutosSistema.setForeground(Color.WHITE);
		tpQuantProdutosSistema.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		tpQuantProdutosSistema.setEditable(false);
		tpQuantProdutosSistema.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpQuantProdutosSistema.setBackground(new Color(30, 33, 36));
		tpQuantProdutosSistema.setBounds(397, 482, 209, 21);
		pFundoListaProdutos.add(tpQuantProdutosSistema);
		
		JPanel pPainelAcoesListaProdutos = new JPanel();
		pPainelAcoesListaProdutos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pPainelAcoesListaProdutos.setBackground(new Color(30, 33, 36));
		pPainelAcoesListaProdutos.setBounds(42, 504, 564, 56);
		pFundoListaProdutos.add(pPainelAcoesListaProdutos);
		pPainelAcoesListaProdutos.setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Novo Produto");
		btnAdicionarProduto.setFocusable(false);
		btnAdicionarProduto.setForeground(new Color(255, 255, 255));
		btnAdicionarProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnAdicionarProduto.setBackground(new Color(66, 69, 73));
		btnAdicionarProduto.setBounds(6, 4, 210, 47);
		pPainelAcoesListaProdutos.add(btnAdicionarProduto);
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
			}
		});
		
		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.setFocusable(false);
		btnListarProdutos.setForeground(new Color(255, 255, 255));
		btnListarProdutos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnListarProdutos.setBackground(new Color(66, 69, 73));
		btnListarProdutos.setBounds(223, 4, 152, 47);
		pPainelAcoesListaProdutos.add(btnListarProdutos);
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(prod.haProdutos() == true && prod.exibiuProdutos() == false) {
					tpIdProduto.setText(null);
					tpNomeProduto.setText(null);
					tpPrecoProduto.setText(null);
					tpQuantEstoqueProduto.setText(null);
					tpDisponibilidadeProduto.setText(null);
					tpQuantProdutosSistema.setText("Produtos cadastrados: " + prod.getIdProduto() + "/20");
					for (Produto produto : prod.getListaProdutos()) {
						tpIdProduto.setText(tpIdProduto.getText() + produto.getIdProduto() + "\n");
						tpNomeProduto.setText(tpNomeProduto.getText() + produto.getNomeProduto() + "\n");
						tpPrecoProduto.setText(tpPrecoProduto.getText() + produto.getPrecoProduto() + "\n");
						tpQuantEstoqueProduto.setText(tpQuantEstoqueProduto.getText() + produto.getQuantEstoque() + "\n");
						tpDisponibilidadeProduto.setText(tpDisponibilidadeProduto.getText() + produto.verificarEstoque(produto) + "\n");
					}
					prod.setExibiuProdutos(true);
				} else {
					JOptionPane.showMessageDialog(null, "Produtos já foram mostrados ou não há o que mostrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnCarregarPreset = new JButton("Carregar Presets");
		btnCarregarPreset.setFocusable(false);
		btnCarregarPreset.setForeground(new Color(255, 255, 255));
		btnCarregarPreset.setBounds(382, 4, 174, 47);
		pPainelAcoesListaProdutos.add(btnCarregarPreset);
		btnCarregarPreset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnCarregarPreset.setBackground(new Color(66, 69, 73));
		btnCarregarPreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarPredef();
			}
		});
		
		JButton btnLimparListaProdutos = new JButton("Limpar");
		btnLimparListaProdutos.setFocusable(false);
		btnLimparListaProdutos.setForeground(new Color(255, 255, 255));
		btnLimparListaProdutos.setBackground(new Color(66, 69, 73));
		btnLimparListaProdutos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnLimparListaProdutos.setBounds(314, 486, 84, 17);
		pFundoListaProdutos.add(btnLimparListaProdutos);
		btnLimparListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpIdProduto.setText(null);
				tpNomeProduto.setText(null);
				tpPrecoProduto.setText(null);
				tpQuantEstoqueProduto.setText(null);
				tpDisponibilidadeProduto.setText(null);
				prod.setExibiuProdutos(false);
			}
		});
		
		JLabel lblCopyright = new JLabel("Supermarket Manager © - Todos os direitos reservados");
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		lblCopyright.setBounds(195, 571, 272, 19);
		pFundoListaProdutos.add(lblCopyright);
		
		JLabel lblVersao = new JLabel(ViewMain.VERSAO + ViewMain.BUILD + " (18/06/23)");
		lblVersao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVersao.setForeground(Color.WHITE);
		lblVersao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 8));
		lblVersao.setBounds(477, 573, 185, 19);
		pFundoListaProdutos.add(lblVersao);
	}
	
	public void carregarPredef() {
		if(prod.isPredefCarregado() == false) {
			
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset01 = new Produto(prod.getIdProduto(), "Arroz", 6.50, 15);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset02 = new Produto(prod.getIdProduto(), "Feijão", 7.50, 15);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset03 = new Produto(prod.getIdProduto(), "Macarrão", 5.60, 15);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset04 = new Produto(prod.getIdProduto(), "Leite", 4.20, 15);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset05 = new Produto(prod.getIdProduto(), "Batata", 5.30, 25);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset06 = new Produto(prod.getIdProduto(), "Banana", 4.99, 25);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset07 = new Produto(prod.getIdProduto(), "Suco de Uva", 8.99, 15);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset08 = new Produto(prod.getIdProduto(), "Beterraba", 4.96, 25);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset09 = new Produto(prod.getIdProduto(), "Peito de Frango", 13.99, 5);
			prod.setIdProduto(prod.getIdProduto() + 1);
			Produto preset10 = new Produto(prod.getIdProduto(), "Costela Bovina", 27.49, 5);
			
			prod.adicionarProduto(preset01);
			prod.adicionarProduto(preset02);
			prod.adicionarProduto(preset03);
			prod.adicionarProduto(preset04);
			prod.adicionarProduto(preset05);
			prod.adicionarProduto(preset06);
			prod.adicionarProduto(preset07);
			prod.adicionarProduto(preset08);
			prod.adicionarProduto(preset09);
			prod.adicionarProduto(preset10);
			
			prod.setExibiuProdutos(false);
			prod.setHaProdutos(true);
			prod.setPredefCarregado(true);
			
			JOptionPane.showMessageDialog(null, "Pré-definição de produtos carregada com sucesso!", "Êxito", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Pré-definição de produtos já carregada!", "Impossível prosseguir", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int prodID() {int idProd = prod.getIdProduto(); return idProd;}
	public void adicionarNovoProduto(int id, String nomeProduto, double precoProduto, int quantEstoque) {
		Produto novoProduto = new Produto();
		novoProduto.setIdProduto(id);
		novoProduto.setNomeProduto(nomeProduto);
		novoProduto.setPrecoProduto(precoProduto);
		novoProduto.setQuantEstoque(quantEstoque);
		prod.setIdProduto(prod.getIdProduto() + 1);
		prod.adicionarProduto(novoProduto);
		prod.setExibiuProdutos(false);
		prod.setHaProdutos(true);
	}
}
