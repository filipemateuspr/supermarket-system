package supermarket.iu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import supermarket.core.*;

public class ViewAdicionarProduto extends JFrame {
	
	private static final long serialVersionUID = 5306957481342113129L;
	public ViewMain vMain = new ViewMain();
	public Produto prod = new Produto();
	public static ViewGerenteProdutos vGeProd = new ViewGerenteProdutos();
	private JPanel cpPainelGeral;
	private JTextField tfNomeProduto;
	private JTextField tfPrecoProduto;
	private JTextField tfQuantEstoqueProduto;
	
	@SuppressWarnings("static-access")
	public ViewAdicionarProduto() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle(vMain.COMPARTILHADO_TITULO + "Adicionar Produto");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 400);
		cpPainelGeral = new JPanel();
		cpPainelGeral.setBackground(new Color(54, 57, 62));
		cpPainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpPainelGeral);
		cpPainelGeral.setLayout(null);
		
		JPanel pFundoAdicionarNovoProduto = new JPanel();
		pFundoAdicionarNovoProduto.setFocusable(false);
		pFundoAdicionarNovoProduto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pFundoAdicionarNovoProduto.setBackground(new Color(40, 43, 48));
		pFundoAdicionarNovoProduto.setBounds(10, 11, 394, 339);
		cpPainelGeral.add(pFundoAdicionarNovoProduto);
		pFundoAdicionarNovoProduto.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Adicionar Produto");
		lblTitulo.setBounds(99, 14, 196, 36);
		pFundoAdicionarNovoProduto.add(lblTitulo);
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblTitulo.setForeground(new Color(255, 255, 255));
		
		JLabel lblNomeProdutoTitulo = new JLabel("Informe o nome do produto");
		lblNomeProdutoTitulo.setBounds(65, 68, 200, 14);
		pFundoAdicionarNovoProduto.add(lblNomeProdutoTitulo);
		lblNomeProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNomeProdutoTitulo.setForeground(new Color(255, 255, 255));
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setCaretColor(new Color(255, 255, 255));
		tfNomeProduto.setForeground(new Color(255, 255, 255));
		tfNomeProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tfNomeProduto.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		tfNomeProduto.setBackground(new Color(30, 33, 36));
		tfNomeProduto.setBounds(65, 86, 260, 20);
		pFundoAdicionarNovoProduto.add(tfNomeProduto);
		tfNomeProduto.setColumns(10);
		
		JLabel lblPrecoProdutoTitulo = new JLabel("Informe o preço do produto");
		lblPrecoProdutoTitulo.setForeground(Color.WHITE);
		lblPrecoProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPrecoProdutoTitulo.setBounds(65, 127, 200, 14);
		pFundoAdicionarNovoProduto.add(lblPrecoProdutoTitulo);
		
		tfPrecoProduto = new JTextField();
		tfPrecoProduto.setCaretColor(new Color(255, 255, 255));
		tfPrecoProduto.setForeground(new Color(255, 255, 255));
		tfPrecoProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tfPrecoProduto.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		tfPrecoProduto.setBackground(new Color(30, 33, 36));
		tfPrecoProduto.setColumns(10);
		tfPrecoProduto.setBounds(65, 145, 260, 20);
		pFundoAdicionarNovoProduto.add(tfPrecoProduto);
		
		JLabel lblQuantEstoqueProdutoTitulo = new JLabel("Informe a quantidade em estoque");
		lblQuantEstoqueProdutoTitulo.setForeground(Color.WHITE);
		lblQuantEstoqueProdutoTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblQuantEstoqueProdutoTitulo.setBounds(65, 187, 243, 14);
		pFundoAdicionarNovoProduto.add(lblQuantEstoqueProdutoTitulo);
		
		tfQuantEstoqueProduto = new JTextField();
		tfQuantEstoqueProduto.setCaretColor(new Color(255, 255, 255));
		tfQuantEstoqueProduto.setForeground(new Color(255, 255, 255));
		tfQuantEstoqueProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		tfQuantEstoqueProduto.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		tfQuantEstoqueProduto.setBackground(new Color(30, 33, 36));
		tfQuantEstoqueProduto.setColumns(10);
		tfQuantEstoqueProduto.setBounds(65, 205, 260, 20);
		pFundoAdicionarNovoProduto.add(tfQuantEstoqueProduto);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBackground(new Color(63, 69, 73));
		btnAdicionar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnAdicionar.setBounds(75, 253, 100, 36);
		pFundoAdicionarNovoProduto.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idProduto = vGeProd.prodID() + 1;
					String nomeProduto = tfNomeProduto.getText();
					double precoProduto = Double.parseDouble(tfPrecoProduto.getText());
					int quantEstoqueProduto = Integer.parseInt(tfQuantEstoqueProduto.getText());
					vGeProd.adicionarNovoProduto(idProduto, nomeProduto, precoProduto, quantEstoqueProduto);
					JOptionPane.showMessageDialog(null, "Novo produto adicionado!", "Operação concluída!", JOptionPane.INFORMATION_MESSAGE);
					tfNomeProduto.setText(null);
					tfPrecoProduto.setText(null);
					tfQuantEstoqueProduto.setText(null);
					dispose();
				} catch(NumberFormatException erro) {
					JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente.", "Valores inválidos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(63, 69, 73));
		btnCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnCancelar.setBounds(215, 253, 100, 36);
		pFundoAdicionarNovoProduto.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNomeProduto.setText(null);
				tfPrecoProduto.setText(null);
				tfQuantEstoqueProduto.setText(null);
				dispose();
			}
		});
	}
}
