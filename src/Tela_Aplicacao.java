import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Aplicacao extends JFrame {

	private static final long serialVersionUID = -1864335403553553587L;
	
	private JPanel contentPane;
	private JTable tabelaItens;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Aplicacao frame = new Tela_Aplicacao();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println("Criação da tela de Menu Inicial falhou!");
					e.printStackTrace();
				}
			}
		});
	}

	
	// CONSTRUÇÃO DA INTERFACE GRÁFICA
	
	/**
	 * Definição da estrutura do Frame Pagina Principal.
	 */
	public Tela_Aplicacao() {
		// definição do JFrame
		setTitle("Página Principal");
		setResizable(false);
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Times New Roman", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1042, 709);
		setLocationRelativeTo(null); // permite centralizar o Frame na tela do usuário
		
		
		// definição de um JPanel para inserir os elementos
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// definição de um JLabel como título da tela
		JLabel tituloMenu = new JLabel("Controle de Estoque");
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMenu.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tituloMenu.setBounds(0, 38, 1028, 67);
		contentPane.add(tituloMenu);
		
		// definição do botão de cadastro de um novo item
		JButton buttonCadastrarItem = new JButton("Cadastrar Item");
		buttonCadastrarItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose(); // fecha a tela principal
				Tela_Cadastro telaCadastro = new Tela_Cadastro();
				telaCadastro.setVisible(true); // torna a tela de cadastro visível
			}
		});
		buttonCadastrarItem.setForeground(Color.WHITE);
		buttonCadastrarItem.setBackground(Color.GRAY);
		buttonCadastrarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonCadastrarItem.setBounds(34, 140, 129, 70);
		contentPane.add(buttonCadastrarItem);
		
		// definição do botão de edição de um determinado item
		JButton buttonEditarItem = new JButton("Editar Item");
		buttonEditarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha a tela principal
				Tela_EditarItem telaEdicao = new Tela_EditarItem();
				telaEdicao.setVisible(true); // torna a tela de edicao visível
			}
		});
		buttonEditarItem.setForeground(Color.WHITE);
		buttonEditarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonEditarItem.setBackground(Color.GRAY);
		buttonEditarItem.setBounds(34, 260, 129, 70);
		contentPane.add(buttonEditarItem);	
		
		// definição do botão para excluir um determinado item
		JButton buttonExcluirItem = new JButton("Excluir Item");
		buttonExcluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // fecha a tela principal
				Tela_ExcluirItem telaExcluir = new Tela_ExcluirItem();
				telaExcluir.setVisible(true); // torna a tela de excluir visível
			}
		});
		buttonExcluirItem.setForeground(Color.WHITE);
		buttonExcluirItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonExcluirItem.setBackground(Color.GRAY);
		buttonExcluirItem.setBounds(34, 380, 129, 70);
		contentPane.add(buttonExcluirItem);
		
		// chamada do método que define a estrutura de visualização dos itens
		visualizaçãoItensEstoque();
	}
	
	// ESTRUTURA DE VISUALIZAÇÃO DOS ITENS
	public void visualizaçãoItensEstoque() {
		JScrollPane scrollPane_VisualizarItens = new JScrollPane();
		scrollPane_VisualizarItens.setBounds(190, 140, 830, 430);
		contentPane.add(scrollPane_VisualizarItens);
		
		tabelaItens = new JTable();
		tabelaItens.setEnabled(false);
		
		refreshTabela(); // construção da tabela com dados já existentes
		
		// centralizando dados das colunas
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabelaItens.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane_VisualizarItens.setViewportView(tabelaItens);
	}
	
	
	public void refreshTabela() {
		tabelaItens.setModel(new DefaultTableModel(
				mostrarItensEstoque(), // chamada do método para retorno dos dados
				new String[] {
					"C\u00F3digo", "Descri\u00E7\u00E3o", "Quantidade", "Pre\u00E7o (unid)", "Comprimento (cm)", "Largura (cm)", "Espessura (cm)", "Cor"
				}
		));
		tabelaItens.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		// definição da largura do nome das colunas da tabela
		tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(8);
		tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabelaItens.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaItens.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaItens.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabelaItens.getColumnModel().getColumn(5).setPreferredWidth(50);
		tabelaItens.getColumnModel().getColumn(6).setPreferredWidth(60);
		tabelaItens.getTableHeader().setResizingAllowed(false);
	}
	
	// IMPLEMENTAÇÃO DOS MÉTODOS A SEREM UTILIZADOS NA APLICAÇÃO
	
	public static String[][] mostrarItensEstoque(){
		
		ArrayList<Item> listaItens = lerArquivoTemporario();
		int quantidadeItens = listaItens.size();
		
		String[][] itensEstoque = new String[quantidadeItens][8]; // 8 colunas de dados para cada item
		
		for(int indice=0; indice<quantidadeItens; indice++) {
			itensEstoque[indice][0] = String.valueOf(listaItens.get(indice).getCodigo());
			itensEstoque[indice][1] = listaItens.get(indice).getDescricao();
			itensEstoque[indice][2] = String.valueOf(listaItens.get(indice).getQuantidade());
			itensEstoque[indice][3] = String.valueOf(listaItens.get(indice).getPreco());
			
			if(listaItens.get(indice) instanceof ItemEspecifico) {
				ItemEspecifico item = (ItemEspecifico) listaItens.get(indice);
				itensEstoque[indice][4] = String.valueOf(item.getComprimento());
				itensEstoque[indice][5] = String.valueOf(item.getLargura());
				itensEstoque[indice][6] = String.valueOf(item.getEspessura());
				itensEstoque[indice][7] = String.valueOf(item.getCor());
			} else {
				itensEstoque[indice][4] = "-";
				itensEstoque[indice][5] = "-";
				itensEstoque[indice][6] = "-";
				itensEstoque[indice][7] = "-";
			}
		}
		
		return itensEstoque;
	}
	
	
	public static ArrayList<Item> lerArquivoTemporario(){
        try{
            FileInputStream fileInput = new FileInputStream("lista.tmp");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            ArrayList<Item> itens = (ArrayList<Item>) objectInput.readObject();
            objectInput.close();
            return itens;
        } catch (FileNotFoundException e){
            System.err.println("Arquivo não existe!");
            //e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.err.println("Classe não encontrada!");
            //e.printStackTrace();
        } catch (IOException e){
            System.err.println("Erro I/O!");
            e.printStackTrace();
        }
        return new ArrayList<Item>();
    }
	
}
