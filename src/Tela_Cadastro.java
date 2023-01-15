import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Tela_Cadastro extends JFrame {

	private static final long serialVersionUID = 1412749792496420137L;
	
	private JPanel contentPane;
	private JTextField textField_Descricao;
	private JTextField textField_Quantidade;
	private JTextField textField_Preco;
	private JTextField textField_Comprimento;
	private JTextField textField_Largura;
	private JTextField textField_Espessura;
	private JTextField textField_Cor;
	
	private static boolean checkboxSelecionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro frame = new Tela_Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println("Criação da tela de Cadastro falhou!");
					e.printStackTrace();
				}
			}
		});
	}

	
	// CONSTRUÇÃO DA INTERFACE GRÁFICA
	
	/**
	 * Definição da estrutura do Frame Tela de Cadastro.
	 */
	public Tela_Cadastro() {
		// definição do JFrame
		setTitle("Cadastrar Item");
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
		JLabel tituloMenu = new JLabel("Cadastrar Item");
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMenu.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tituloMenu.setBounds(0, 38, 1028, 67);
		contentPane.add(tituloMenu);
		
		textField_Descricao = new JTextField();
		textField_Descricao.setBounds(62, 177, 244, 36);
		contentPane.add(textField_Descricao);
		textField_Descricao.setColumns(10);
		
		textField_Quantidade = new JTextField();
		textField_Quantidade.setColumns(10);
		textField_Quantidade.setBounds(394, 177, 244, 36);
		contentPane.add(textField_Quantidade);
		
		textField_Preco = new JTextField();
		textField_Preco.setColumns(10);
		textField_Preco.setBounds(725, 177, 244, 36);
		contentPane.add(textField_Preco);
		
		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelDescricao.setBounds(62, 152, 123, 19);
		contentPane.add(labelDescricao);
		
		JLabel labelQuantidade = new JLabel("Quantidade:");
		labelQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelQuantidade.setBounds(394, 152, 123, 19);
		contentPane.add(labelQuantidade);
		
		JLabel labelPreco = new JLabel("Preço:");
		labelPreco.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPreco.setBounds(725, 152, 123, 19);
		contentPane.add(labelPreco);
		
		
		JLabel labelComprimento = new JLabel("Comprimento (cm):");
		labelComprimento.setEnabled(false);
		labelComprimento.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelComprimento.setBounds(62, 340, 193, 19);
		contentPane.add(labelComprimento);
		
		textField_Comprimento = new JTextField();
		textField_Comprimento.setEnabled(false);
		textField_Comprimento.setEditable(false);
		textField_Comprimento.setColumns(10);
		textField_Comprimento.setBounds(62, 365, 244, 36);
		contentPane.add(textField_Comprimento);
		
		JLabel labelLargura = new JLabel("Largura (cm):");
		labelLargura.setEnabled(false);
		labelLargura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelLargura.setBounds(394, 340, 123, 19);
		contentPane.add(labelLargura);
		
		textField_Largura = new JTextField();
		textField_Largura.setEditable(false);
		textField_Largura.setEnabled(false);
		textField_Largura.setColumns(10);
		textField_Largura.setBounds(394, 365, 244, 36);
		contentPane.add(textField_Largura);
		
		JLabel labelEspessura = new JLabel("Espessura (cm):");
		labelEspessura.setEnabled(false);
		labelEspessura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelEspessura.setBounds(725, 340, 161, 19);
		contentPane.add(labelEspessura);
		
		textField_Espessura = new JTextField();
		textField_Espessura.setEnabled(false);
		textField_Espessura.setEditable(false);
		textField_Espessura.setColumns(10);
		textField_Espessura.setBounds(725, 365, 244, 36);
		contentPane.add(textField_Espessura);
		
		JLabel labelCor = new JLabel("Cor:\r\n");
		labelCor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelCor.setEnabled(false);
		labelCor.setBounds(62, 438, 193, 19);
		contentPane.add(labelCor);
		
		textField_Cor = new JTextField();
		textField_Cor.setEnabled(false);
		textField_Cor.setEditable(false);
		textField_Cor.setColumns(10);
		textField_Cor.setBounds(62, 463, 244, 36);
		contentPane.add(textField_Cor);
		
		
		JCheckBox checkBox_ItemEspecifico = new JCheckBox("Este é um item específico");	
		// verifica se o checkbox de ItemEspecifico foi selecionado
		checkBox_ItemEspecifico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == checkBox_ItemEspecifico) {
					if(checkBox_ItemEspecifico.isSelected() == true) {
						labelComprimento.setEnabled(true);
						textField_Comprimento.setEnabled(true);
						textField_Comprimento.setEditable(true);
						labelLargura.setEnabled(true);
						textField_Largura.setEditable(true);
						textField_Largura.setEnabled(true);
						labelEspessura.setEnabled(true);
						textField_Espessura.setEnabled(true);
						textField_Espessura.setEditable(true);
						labelCor.setEnabled(true);
						textField_Cor.setEnabled(true);
						textField_Cor.setEditable(true);
						
						checkboxSelecionado = true;
					} else {
						labelComprimento.setEnabled(false);
						textField_Comprimento.setEnabled(false);
						textField_Comprimento.setEditable(false);
						labelLargura.setEnabled(false);
						textField_Largura.setEditable(false);
						textField_Largura.setEnabled(false);
						labelEspessura.setEnabled(false);
						textField_Espessura.setEnabled(false);
						textField_Espessura.setEditable(false);
						labelCor.setEnabled(false);
						textField_Cor.setEnabled(false);
						textField_Cor.setEditable(false);
						
						checkboxSelecionado = false;
					}
				}
			}
		});
		
		checkBox_ItemEspecifico.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkBox_ItemEspecifico.setBounds(62, 258, 244, 21);
		contentPane.add(checkBox_ItemEspecifico);		
	
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); // fecha a tela de cadastro
				Tela_Aplicacao telaInicial = new Tela_Aplicacao();
				telaInicial.setVisible(true); // torna a tela inical visível
			}
		});
		buttonCancelar.setForeground(Color.WHITE);
		buttonCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonCancelar.setBackground(Color.GRAY);
		buttonCancelar.setBounds(62, 562, 129, 70);
		contentPane.add(buttonCancelar);
		
		
		
		JButton buttonCadastrarItem = new JButton("Cadastrar Item");
		buttonCadastrarItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(verificarSeCamposBasicosForamPreenchidos() == false) {
					JOptionPane.showMessageDialog(null, "Você deve preencher o campo de descrição!", "Campo não preenchido", JOptionPane.ERROR_MESSAGE);
				} else {
					inserirItemLista();
				}
			}
		});
		buttonCadastrarItem.setForeground(Color.WHITE);
		buttonCadastrarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonCadastrarItem.setBackground(Color.GRAY);
		buttonCadastrarItem.setBounds(840, 562, 129, 70);
		contentPane.add(buttonCadastrarItem);
	}
	
	
	
	
	
	// IMPLEMENTAÇÃO DOS MÉTODOS A SEREM UTILIZADOS NA APLICAÇÃO
	
	public ArrayList<Item> lerArquivoTemporario(){
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
            //e.printStackTrace();
        }
        return new ArrayList<Item>();
    }
	
	
	
	public void salvarArquivoTemporario(ArrayList<Item> lista){
        try{
            FileOutputStream fileOut = new FileOutputStream("lista.tmp");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(lista);
            objectOut.close();
        } catch (FileNotFoundException e){
            System.err.println("Arquivo não pode ser criado!");
            e.printStackTrace();
        } catch (IOException e){
            System.err.println("Erro I/O!");
            e.printStackTrace();
        }
        System.out.println("Arquivo salvo com sucesso!");
    }

	
	
    public void inserirItemLista(){
    	
    	ArrayList<Item> lista = lerArquivoTemporario();
    	
    	// verifica qual deve ser o código do novo item a ser cadastrado
    	int codigoItem;
    	
    	if(lista.isEmpty()){
            codigoItem = 1;
        } else {
        	codigoItem = lista.get(lista.size()-1).codigo + 1;
        }
    	
    	
    	if(verificarPreenchimentoCorretoDosCampos(checkboxSelecionado) == true) {
    		// pega o conteudo inserido nos campos
        	String conteudoDescricao = textField_Descricao.getText().trim();
        	String conteudoQuantidade = textField_Quantidade.getText().trim();
        	String conteudoPreco = textField_Preco.getText().trim();
        	
        	// verifica qual tipo de objeto deve ser criado e realiza a criação
        	if(checkboxSelecionado == false) { // O item é do tipo Item
        		
        		Item novoItem = new Item(codigoItem, conteudoDescricao);
        		
        		if(!conteudoQuantidade.equals("")) { // se o campo Quantidade foi preenchido
        			Integer quantidade = Integer.valueOf(conteudoQuantidade);
        			novoItem.setQuantidade(quantidade);
        		}
        		
        		if(!conteudoPreco.equals("")) { // se o campo Preço foi preenchido
        			Double preco = Double.valueOf(conteudoPreco);
        			novoItem.setPreco(preco);
        		}
        		
        		// adicionando o novo item a lista de itens
            	lista.add(novoItem);
            	salvarArquivoTemporario(lista);
        		
        	} else { // O item é do tipo ItemEspecifico
        		
        		ItemEspecifico novoItem = new ItemEspecifico(codigoItem, conteudoDescricao);
        		
        		if(!conteudoQuantidade.equals("")) { // se o campo Quantidade foi preenchido
        			Integer quantidade = Integer.valueOf(conteudoQuantidade);
        			novoItem.setQuantidade(quantidade);
        		}
        		
        		if(!conteudoPreco.equals("")) { // se o campo Preço foi preenchido
        			Double preco = Double.valueOf(conteudoPreco);
        			novoItem.setPreco(preco);
        		}
        		
        		// pega o conteudo inserido nos campos extras
            	String conteudoComprimento = textField_Comprimento.getText().trim();
            	String conteudoEspessura = textField_Espessura.getText().trim();
            	String conteudoLargura = textField_Largura.getText().trim();
            	String conteudoCor = textField_Cor.getText().trim();
        		
            	if(!conteudoComprimento.equals("")) { // se o campo Comprimento foi preenchido
            		Double comprimento = Double.valueOf(conteudoComprimento);
        			novoItem.setComprimento(comprimento);
        		}
        		
            	if(!conteudoEspessura.equals("")) { // se o campo Espessura foi preenchido
            		Double espessura = Double.valueOf(conteudoEspessura);
        			novoItem.setEspessura(espessura);
        		}
            	
            	if(!conteudoLargura.equals("")) { // se o campo Largura foi preenchido
            		Double largura = Double.valueOf(conteudoLargura);
        			novoItem.setLargura(largura);
        		}
        		
            	if(!conteudoCor.equals("")) { // se o campo Cor foi preenchido
        			novoItem.setCor(conteudoCor);
        		}
            	
            	// adicionando o novo item a lista de itens
            	lista.add(novoItem);
            	salvarArquivoTemporario(lista);
        	}
        	
        	JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!", "Cadastro de novo item", JOptionPane.INFORMATION_MESSAGE);
        	dispose(); // fecha a tela de cadastro
			Tela_Aplicacao telaInicial = new Tela_Aplicacao();
			telaInicial.setVisible(true); // torna a tela de inicio visível
    	} 
    }

    
    public boolean verificarSeCamposBasicosForamPreenchidos() {
    	
    	// pega o conteudo inserido no campo de descrição
    	String conteudoDescricao = textField_Descricao.getText().trim(); 
    	
    	if(conteudoDescricao.equals("")) { return false; }
    	
    	return true; 	
    }
    
    
    // recebe como argumento se o checkBox de ItemEspecifico foi selecionado
    public boolean verificarPreenchimentoCorretoDosCampos(boolean checkBoxSelecionado) {
    	
    	// campos que devem ser verificados são aqueles que envolvem números (não pode ser texto)
    	
    	JTextField[] arrayDeCampos;
    	
    	if(checkBoxSelecionado == false){
    		arrayDeCampos = new JTextField[2];
    		arrayDeCampos[0] = textField_Quantidade;
    		arrayDeCampos[1] = textField_Preco;
    	} else {
    		arrayDeCampos = new JTextField[5];
    		arrayDeCampos[0] = textField_Quantidade;
    		arrayDeCampos[1] = textField_Preco;
    		arrayDeCampos[2] = textField_Comprimento;
    		arrayDeCampos[3] = textField_Largura;
    		arrayDeCampos[4] = textField_Espessura;
    	}
    	
    	for(int indice = 0; indice < arrayDeCampos.length; indice++) {
    		try {
    			if(indice == 0) {
    				if(!arrayDeCampos[indice].getText().trim().equals("")) {
    					Integer valorConvertido = Integer.valueOf(arrayDeCampos[indice].getText().trim());
    				}
    			} else {
    				if(!arrayDeCampos[indice].getText().trim().equals("")) {
    					Double valorConvertido = Double.valueOf(arrayDeCampos[indice].getText().trim());
    				}
    			}
    		} catch (Exception e){
    			String[] nomeCampos = null;
    			if(arrayDeCampos.length == 2) {
    				nomeCampos = new String[2];
    				nomeCampos[0] = "Quantidade"; 
    	    		nomeCampos[1] = "Preço";
    			} else if (arrayDeCampos.length == 5){  
    				nomeCampos = new String[5];
    				nomeCampos[0] = "Quantidade"; 
    	    		nomeCampos[1] = "Preço";
    	    		nomeCampos[2] = "Comprimento"; 
    	    		nomeCampos[3] = "Largura";
    	    		nomeCampos[4] = "Espessura";
    			}
    			
    			JOptionPane.showMessageDialog(null, "O campo " + nomeCampos[indice] + " foi preenchido incorretamente!", "Erro de preenchimento de campo", JOptionPane.ERROR_MESSAGE);
    			System.err.println("Erro de conversao de campos: " + e);
    			System.err.println("Campo que provocou o erro: " + indice);
    			return false;
    		}
    	}
    	
    	return true;
    }

}
