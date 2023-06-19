package supermarket.iu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import supermarket.core.*;

public class ViewAdicionarProduto extends JFrame {
	
	private static final long serialVersionUID = 5306957481342113129L;
	private JPanel cpPainelGeral;
	public Produto prod = new Produto();
	ViewGerenteProdutos viewGerenteProdutos = new ViewGerenteProdutos();
	
	public ViewAdicionarProduto() {
		setResizable(false);
		setTitle("Supermarket Manager : Adicionar Produto");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 400);
		cpPainelGeral = new JPanel();
		cpPainelGeral.setBackground(new Color(0, 0, 0));
		cpPainelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpPainelGeral);
		cpPainelGeral.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Adicionar Novo Produto");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(118, 37, 208, 36);
		cpPainelGeral.add(lblTitulo);
		
		JLabel lblNomeProduto = new JLabel("Informe o Nome do Produto");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProduto.setForeground(new Color(255, 255, 255));
		lblNomeProduto.setBounds(130, 84, 184, 14);
		cpPainelGeral.add(lblNomeProduto);
		
		JTextArea tfNomeProduto = new JTextArea();
		tfNomeProduto.setBounds(100, 109, 244, 22);
		cpPainelGeral.add(tfNomeProduto);
		
		JLabel lblPrecoProduto = new JLabel("Informe o Preço do Produto");
		lblPrecoProduto.setForeground(Color.WHITE);
		lblPrecoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecoProduto.setBounds(130, 142, 184, 14);
		cpPainelGeral.add(lblPrecoProduto);
		
		JTextArea tfPrecoProduto = new JTextArea();
		tfPrecoProduto.setBounds(100, 167, 244, 22);
		cpPainelGeral.add(tfPrecoProduto);
		
		JLabel lblQuantEstoque = new JLabel("Informe a Quantidade Inicial do Estoque");
		lblQuantEstoque.setForeground(Color.WHITE);
		lblQuantEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantEstoque.setBounds(100, 200, 244, 14);
		cpPainelGeral.add(lblQuantEstoque);
		
		JTextArea tfQuantEstoque = new JTextArea();
		tfQuantEstoque.setBounds(100, 225, 244, 22);
		cpPainelGeral.add(tfQuantEstoque);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(100, 277, 100, 36);
		cpPainelGeral.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idProduto = viewGerenteProdutos.prodID() + 1;
					String nomeProduto = tfNomeProduto.getText();
					double precoProduto = Double.parseDouble(tfPrecoProduto.getText());
					int quantEstoqueProduto = Integer.parseInt(tfQuantEstoque.getText());
					viewGerenteProdutos.adicionarNovoProduto(idProduto, nomeProduto, precoProduto, quantEstoqueProduto);
					JOptionPane.showMessageDialog(null, "Novo produto adicionado!", "Operação concluída!", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch(NumberFormatException erro) {
					JOptionPane.showMessageDialog(null, "Verifique os campos acima e tente novamente", "Erro : Valores Inválidos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(244, 277, 100, 36);
		cpPainelGeral.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
