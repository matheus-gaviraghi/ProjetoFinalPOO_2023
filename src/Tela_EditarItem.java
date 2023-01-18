import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Tela_EditarItem extends JFrame {

	private static final long serialVersionUID = 2717548967459433495L;
	
	private JPanel contentPane;
	private JTextField textField_CodigoItem;
	private JTextField textField_Descricao;
	private JTextField textField_Quantidade;
	private JTextField textField_Preco;
	private JTextField textField_Comprimento;
	private JTextField textField_Cor;
	private JTextField textField_Largura;
	private JTextField textField_Espessura;
	
	private int codigoItemBuscado;

	private boolean itemTipoEspecifico;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_EditarItem frame = new Tela_EditarItem();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println("Criação da tela de Editar Item falhou!");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_EditarItem() {
		// definição do JFrame
		setTitle("Editar Item");
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
		JLabel tituloMenu = new JLabel("Editar Item");
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMenu.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tituloMenu.setBounds(0, 38, 1028, 67);
		contentPane.add(tituloMenu);
		
		JLabel labelPedirCodigo = new JLabel("Digite o código do item a ser editado:");
		labelPedirCodigo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPedirCodigo.setBounds(73, 142, 307, 21);
		contentPane.add(labelPedirCodigo);
		
		textField_CodigoItem = new JTextField();
		textField_CodigoItem.setHorizontalAlignment(SwingConstants.CENTER);
		textField_CodigoItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_CodigoItem.setBounds(381, 136, 74, 34);
		contentPane.add(textField_CodigoItem);
		textField_CodigoItem.setColumns(10);
		
		JTextPane textPane_InfosItem = new JTextPane();
		textPane_InfosItem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPane_InfosItem.setEditable(false);
		textPane_InfosItem.setBounds(507, 115, 480, 201);
		textPane_InfosItem.setVisible(false);
		contentPane.add(textPane_InfosItem);
		
		
		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelDescricao.setBounds(80, 379, 123, 19);
		labelDescricao.setVisible(false);
		contentPane.add(labelDescricao);
		
		textField_Descricao = new JTextField();
		textField_Descricao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Descricao.setColumns(10);
		textField_Descricao.setBounds(80, 404, 244, 36);
		textField_Descricao.setVisible(false);
		contentPane.add(textField_Descricao);
		
		JLabel labelQuantidade = new JLabel("Quantidade:");
		labelQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelQuantidade.setBounds(412, 379, 123, 19);
		labelQuantidade.setVisible(false);
		contentPane.add(labelQuantidade);
		
		textField_Quantidade = new JTextField();
		textField_Quantidade.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Quantidade.setColumns(10);
		textField_Quantidade.setBounds(412, 404, 244, 36);
		textField_Quantidade.setVisible(false);
		contentPane.add(textField_Quantidade);
		
		JLabel labelPreco = new JLabel("Preço:");
		labelPreco.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPreco.setBounds(743, 379, 123, 19);
		labelPreco.setVisible(false);
		contentPane.add(labelPreco);
		
		textField_Preco = new JTextField();
		textField_Preco.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Preco.setColumns(10);
		textField_Preco.setBounds(743, 404, 244, 36);
		textField_Preco.setVisible(false);
		contentPane.add(textField_Preco);
		
		
		JLabel labelComprimento = new JLabel("Comprimento (cm):");
		labelComprimento.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelComprimento.setBounds(80, 458, 193, 19);
		labelComprimento.setVisible(false);
		contentPane.add(labelComprimento);
		
		textField_Comprimento = new JTextField();
		textField_Comprimento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Comprimento.setColumns(10);
		textField_Comprimento.setBounds(80, 483, 244, 36);
		textField_Comprimento.setVisible(false);
		contentPane.add(textField_Comprimento);
		
		JLabel labelCor = new JLabel("Cor:\r\n");
		labelCor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelCor.setBounds(80, 529, 193, 19);
		labelCor.setVisible(false);
		contentPane.add(labelCor);
		
		textField_Cor = new JTextField();
		textField_Cor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Cor.setColumns(10);
		textField_Cor.setBounds(80, 554, 244, 36);
		textField_Cor.setVisible(false);
		contentPane.add(textField_Cor);
		
		JLabel labelLargura = new JLabel("Largura (cm):");
		labelLargura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelLargura.setBounds(412, 458, 123, 19);
		labelLargura.setVisible(false);
		contentPane.add(labelLargura);
		
		textField_Largura = new JTextField();
		textField_Largura.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Largura.setColumns(10);
		textField_Largura.setBounds(412, 483, 244, 36);
		textField_Largura.setVisible(false);
		contentPane.add(textField_Largura);
		
		JLabel labelEspessura = new JLabel("Espessura (cm):");
		labelEspessura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelEspessura.setBounds(743, 458, 161, 19);
		labelEspessura.setVisible(false);
		contentPane.add(labelEspessura);
		
		textField_Espessura = new JTextField();
		textField_Espessura.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Espessura.setColumns(10);
		textField_Espessura.setBounds(743, 483, 244, 36);
		textField_Espessura.setVisible(false);
		contentPane.add(textField_Espessura);
		
		
		JButton buttonEditarItem = new JButton("Editar Item");
		buttonEditarItem.setForeground(Color.WHITE);
		buttonEditarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonEditarItem.setBackground(Color.GRAY);
		buttonEditarItem.setBounds(858, 592, 129, 70);
		buttonEditarItem.setVisible(false);
		buttonEditarItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(verificarSeCamposBasicosForamPreenchidos() == false) {
					JOptionPane.showMessageDialog(null, "Você deve preencher o campo de descrição!", "Campo não preenchido", JOptionPane.ERROR_MESSAGE);
				} else {
					
					try {
						Item itemBuscado = buscarItem(codigoItemBuscado);
						editarItemLista(itemBuscado.getCodigo());
					
					} catch(Exception erro) {
						JOptionPane.showMessageDialog(null, "Não foi possível editar! Deixe o campo de pesquisa do código preenchido e tente novamente!", "Erro na edição do item!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		contentPane.add(buttonEditarItem);
		
		
		JButton buttonBuscarItem = new JButton("Pesquisar Item");
		buttonBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// esconde campos mostrados para o item pesquisado anteriormente
				labelDescricao.setVisible(false);
				textField_Descricao.setVisible(false);
				labelPreco.setVisible(false);
				textField_Preco.setVisible(false);
				labelQuantidade.setVisible(false);
				textField_Quantidade.setVisible(false);
				labelComprimento.setVisible(false);
				textField_Comprimento.setVisible(false);
				labelLargura.setVisible(false);
				textField_Largura.setVisible(false);
				labelEspessura.setVisible(false);
				textField_Espessura.setVisible(false);
				labelCor.setVisible(false);
				textField_Cor.setVisible(false);
				
				try {
					
					if(!textField_CodigoItem.getText().trim().equals("")) {
						codigoItemBuscado = Integer.valueOf(textField_CodigoItem.getText().trim());
						Item itemBuscado = buscarItem(codigoItemBuscado);
						
	
						textPane_InfosItem.setVisible(true);
						textPane_InfosItem.setText(itemBuscado.toString());
						
						// torna visível os campos de preenchimento em comum entre os tipos de item
						labelDescricao.setVisible(true);
						textField_Descricao.setVisible(true);
						textField_Descricao.setText(itemBuscado.getDescricao());
						
						labelPreco.setVisible(true);
						textField_Preco.setVisible(true);
						textField_Preco.setText(String.valueOf(itemBuscado.getPreco()));
						
						labelQuantidade.setVisible(true);
						textField_Quantidade.setVisible(true);
						textField_Quantidade.setText(String.valueOf(itemBuscado.getQuantidade()));
						
						
						// torna visível os campos de ItemEspecifico se o item for deste tipo
						if(itemBuscado instanceof ItemEspecifico) {
							ItemEspecifico itemPesquisado = (ItemEspecifico) itemBuscado;
							
							itemTipoEspecifico = true;
							
							labelComprimento.setVisible(true);
							textField_Comprimento.setVisible(true);
							textField_Comprimento.setText(String.valueOf(itemPesquisado.getComprimento()));
							
							labelLargura.setVisible(true);
							textField_Largura.setVisible(true);
							textField_Largura.setText(String.valueOf(itemPesquisado.getLargura()));
							
							labelEspessura.setVisible(true);
							textField_Espessura.setVisible(true);
							textField_Espessura.setText(String.valueOf(itemPesquisado.getEspessura()));
							
							labelCor.setVisible(true);
							textField_Cor.setVisible(true);
							textField_Cor.setText(String.valueOf(itemPesquisado.getCor()));
						} else {
							itemTipoEspecifico = false;
						}
						
						buttonEditarItem.setVisible(true);
					}
		
				} catch(Exception erro) {
					textPane_InfosItem.setVisible(false);
					buttonEditarItem.setVisible(false);
					JOptionPane.showMessageDialog(null, erro, "Erro de busca de item", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonBuscarItem.setForeground(Color.WHITE);
		buttonBuscarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBuscarItem.setBackground(Color.GRAY);
		buttonBuscarItem.setBounds(73, 205, 129, 34);
		contentPane.add(buttonBuscarItem);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setForeground(Color.WHITE);
		buttonCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonCancelar.setBackground(Color.GRAY);
		buttonCancelar.setBounds(663, 592, 129, 70);
		buttonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); // fecha a tela de edição
				Tela_Aplicacao telaInicial = new Tela_Aplicacao();
				telaInicial.setVisible(true); // torna a tela inical visível
			}
		});
		contentPane.add(buttonCancelar);
	}
	
	
	public Item buscarItem(int codigo) throws ItemNaoEncontrado{
		ArrayList<Item> lista = lerArquivoTemporario();
		
		for(int indice=0; indice<lista.size(); indice++) {
			if(lista.get(indice).getCodigo() == codigo) {
				return lista.get(indice);
			}
		}
		
		throw new ItemNaoEncontrado("O item de código " + codigo + " não existe!");
	}
	
	
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
	
	
	
	public void editarItemLista(int codigo){
    	
		ArrayList<Item> lista = lerArquivoTemporario();
		
		int posicaoObjetoLista = 0;
		
		for(int indice=0; indice<lista.size(); indice++) {
			if(lista.get(indice).getCodigo() == codigo) {
				posicaoObjetoLista = indice;
			}
		}
		
		Item itemBuscado = lista.get(posicaoObjetoLista);
		
    	if(verificarPreenchimentoCorretoDosCampos(itemTipoEspecifico) == true) {
    		// pega o conteudo inserido nos campos
        	String conteudoDescricao = textField_Descricao.getText().trim();
        	String conteudoQuantidade = textField_Quantidade.getText().trim();
        	String conteudoPreco = textField_Preco.getText().trim();
        	
        	itemBuscado.changeDescricao(conteudoDescricao);
        	
        	if(!conteudoQuantidade.equals("")) { // se o campo Quantidade foi preenchido
    			Integer quantidade = Integer.valueOf(conteudoQuantidade);
    			itemBuscado.setQuantidade(quantidade);
    		}
        	
        	if(!conteudoPreco.equals("")) { // se o campo Preço foi preenchido
    			Double preco = Double.valueOf(conteudoPreco);
    			itemBuscado.setPreco(preco);
    		}
        	
        	
        	if(itemBuscado instanceof ItemEspecifico) {

        		// pega o conteudo inserido nos campos extras
            	String conteudoComprimento = textField_Comprimento.getText().trim();
            	String conteudoEspessura = textField_Espessura.getText().trim();
            	String conteudoLargura = textField_Largura.getText().trim();
            	String conteudoCor = textField_Cor.getText().trim();
        		
            	if(!conteudoComprimento.equals("")) { // se o campo Comprimento foi preenchido
            		Double comprimento = Double.valueOf(conteudoComprimento);
            		((ItemEspecifico) itemBuscado).setComprimento(comprimento);
        		}
        		
            	if(!conteudoEspessura.equals("")) { // se o campo Espessura foi preenchido
            		Double espessura = Double.valueOf(conteudoEspessura);
            		((ItemEspecifico) itemBuscado).setEspessura(espessura);
        		}
            	
            	if(!conteudoLargura.equals("")) { // se o campo Largura foi preenchido
            		Double largura = Double.valueOf(conteudoLargura);
            		((ItemEspecifico) itemBuscado).setLargura(largura);
        		}
        		
            	if(!conteudoCor.equals("")) { // se o campo Cor foi preenchido
            		((ItemEspecifico) itemBuscado).setCor(conteudoCor);
        		}
        	}
        		
            salvarArquivoTemporario(lista);
            
            JOptionPane.showMessageDialog(null, "Item editado com sucesso!", "Edição de um item", JOptionPane.INFORMATION_MESSAGE);
        	dispose(); // fecha a tela de edição
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
