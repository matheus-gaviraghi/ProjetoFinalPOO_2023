import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MainItem{

    private static int codigo = 0;

    public static void main(String[] args) {
       // declaração de variáveis e objetos utilizados na aplicação
        Scanner scanner = new Scanner(System.in);
        ArrayList <Item> itens = new ArrayList<Item>();


        System.out.println("Qual tipo de item você deseja cadastrar? 1-Item Normal OU 2-Item Específico");
        int tipoItem = scanner.nextInt();
        scanner.nextLine();

        if(tipoItem == 1){
            codigo++;
            System.out.println("Digite a descrição: ");
            String descricao = scanner.nextLine();
            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            System.out.println("Digite o preço unitário: ");
            double precoUnitario = scanner.nextDouble();

            System.out.println("\nTamanho do ArrayList antes de criar o objeto: " + itens.size());
            Item novoItem = new Item(codigo, descricao, quantidade, precoUnitario);
            itens.add(novoItem);
            System.out.println("Tamanho do ArrayList após criar o objeto e add: " + itens.size());

            System.out.println(itens.get(0));

            System.out.println("Salvando lista");
            salvarArquivoTemporario(itens);

            System.out.println("Recuperando lista");
            ArrayList<Item> listaLida = lerArquivoTemporario();
            System.out.println(listaLida.get(0));

        } else if (tipoItem == 2){
            codigo++;
            System.out.println("Digite a descrição: ");
            String descricao = scanner.nextLine();
            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            System.out.println("Digite o preço unitário: ");
            double precoUnitario = scanner.nextDouble();
            System.out.println("Digite o comprimento: ");
            double comprimento = scanner.nextDouble();
            System.out.println("Digite a largura: ");
            double largura = scanner.nextDouble();
            System.out.println("Digite a espessura: ");
            double espessura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite a cor: ");
            String cor = scanner.nextLine();

            System.out.println("\nTamanho do ArrayList antes de criar o objeto: " + itens.size());
            Item novoItem = new ItemEspecifico(codigo, descricao, quantidade, precoUnitario,
                                                                comprimento, largura, espessura, cor);
            itens.add(novoItem);
            System.out.println("Tamanho do ArrayList após criar o objeto e add: " + itens.size());

            System.out.println(itens.get(0));

            System.out.println("Salvando lista");
            salvarArquivoTemporario(itens);

            System.out.println("Recuperando lista");
            ArrayList<Item> listaLida = lerArquivoTemporario();
            System.out.println(listaLida.get(0));

        } else {
            System.out.println("Você digitou uma opção inválida!");
        }
    }

    public static void salvarArquivoTemporario(ArrayList lista){
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

    public static ArrayList<Item> lerArquivoTemporario(){
        try{
            FileInputStream fileInput = new FileInputStream("lista.tmp");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            ArrayList<Item> itens = (ArrayList<Item>) objectInput.readObject();
            objectInput.close();
            return itens;
        } catch (FileNotFoundException e){
            System.err.println("Arquivo não pode ser criado!");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.err.println("Classe não encontrada!");
            e.printStackTrace();
        } catch (IOException e){
            System.err.println("Erro I/O!");
            e.printStackTrace();
        }
        return null;
    }

}