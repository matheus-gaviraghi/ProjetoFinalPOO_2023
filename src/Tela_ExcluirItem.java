import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Tela_ExcluirItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ExcluirItem frame = new Tela_ExcluirItem();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println("Criação da tela de Excluir Item falhou!");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_ExcluirItem() {
		// definição do JFrame
		setTitle("Excluir Item");
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
		JLabel tituloMenu = new JLabel("Excluir Item");
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMenu.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tituloMenu.setBounds(0, 38, 1028, 67);
		contentPane.add(tituloMenu);
		
		JLabel labelPedirCodigo = new JLabel("Digite o código do item a ser excluido:");
		labelPedirCodigo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelPedirCodigo.setBounds(73, 142, 307, 21);
		contentPane.add(labelPedirCodigo);
		
		textField_Codigo = new JTextField();
		textField_Codigo.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Codigo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Codigo.setBounds(381, 136, 74, 34);
		contentPane.add(textField_Codigo);
	
		
		JTextPane textPane_InfosItem = new JTextPane();
		textPane_InfosItem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPane_InfosItem.setEditable(false);
		textPane_InfosItem.setBounds(507, 115, 480, 201);
		textPane_InfosItem.setVisible(false);
		contentPane.add(textPane_InfosItem);
		
		
		JButton buttonBuscarItem = new JButton("Pesquisar Item");
		buttonBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				try {
					if(!textField_Codigo.getText().trim().equals("")) {
						Item itemBuscado = buscarItem(Integer.valueOf(textField_Codigo.getText().trim()));
						
						textPane_InfosItem.setVisible(true);
						textPane_InfosItem.setText(itemBuscado.toString());
						
					}
					
				} catch(Exception erro) {
					textPane_InfosItem.setVisible(false);
					JOptionPane.showMessageDialog(null, erro, "Erro de busca de item", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonBuscarItem.setForeground(Color.WHITE);
		buttonBuscarItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBuscarItem.setBackground(Color.GRAY);
		buttonBuscarItem.setBounds(73, 206, 129, 34);
		contentPane.add(buttonBuscarItem);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setForeground(Color.WHITE);
		buttonCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonCancelar.setBackground(Color.GRAY);
		buttonCancelar.setBounds(73, 576, 129, 70);
		contentPane.add(buttonCancelar);
		
		JButton buttonExcluirItem = new JButton("Excluir Item");
		buttonExcluirItem.setForeground(Color.WHITE);
		buttonExcluirItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonExcluirItem.setBackground(Color.GRAY);
		buttonExcluirItem.setBounds(851, 576, 129, 70);
		contentPane.add(buttonExcluirItem);
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
	
	
	
	public void excluirItemLista(int codigo){
    	
		ArrayList<Item> lista = lerArquivoTemporario();
		
		int posicaoObjetoLista = 0;
		
		for(int indice=0; indice<lista.size(); indice++) {
			if(lista.get(indice).getCodigo() == codigo) {
				posicaoObjetoLista = indice;
			}
		}
		
		Item itemBuscado = lista.get(posicaoObjetoLista);
	}

}
