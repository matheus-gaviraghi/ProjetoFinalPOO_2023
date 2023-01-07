import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DemoItem {

    public static void main(String[] args) {
       // declaração de variáveis e objetos utilizados na aplicação
        Scanner scanner = new Scanner(System.in);
        // ArrayList <Item> itens = new ArrayList<Item>();

        System.out.println("Bem vindo ao Controle de Estoque!");

        String tipoItem = "";

        do{
            do {
                System.out.println("Qual tipo de item você deseja cadastrar? 1-Item Normal OU 2-Item Específico");
                tipoItem = scanner.nextLine();

                if (!tipoItem.equals("1") && !tipoItem.equals("2")) {
                    System.err.println("Você digitou uma opção inválida!");
                }
            } while(!tipoItem.equals("1") && !tipoItem.equals("2"));


            if(tipoItem.equals("1")){
                System.out.println("Digite a descrição: ");
                String descricao = scanner.nextLine();
                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                Item novoItem = new Item(descricao, quantidade);
                inserirItem(novoItem);

            } else if (tipoItem.equals("2")){
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

                Item novoItem = new ItemEspecifico(0, descricao, quantidade, precoUnitario,
                        comprimento, largura, espessura, cor);

                inserirItem(novoItem);
            }
            System.out.println("Deseja adicionar mais um item?[S,N]");
            if(scanner.nextLine().toLowerCase().equals("n")){
                mostrarItensLista(lerArquivoTemporario());
                break;
            }
        } while(true);
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

    public static void mostrarItensLista(ArrayList<Item> lista){
        for (Item item: lista) {
            System.out.println(item);
        }
    }

    public static void inserirItem(Item novoItem){

        ArrayList<Item> lista = lerArquivoTemporario();

        if(lista.isEmpty()){
            System.out.println("Lista vazia!");
            int codigoPrimeiroItem = 1;
            novoItem.setCodigo(codigoPrimeiroItem);

            lista.add(novoItem);

            System.out.println("Primeiro item adicionado! Tamanho lista: " + lista.size());
            salvarArquivoTemporario(lista);
        } else {
            int ultimoCodigo = lista.get(lista.size()-1).codigo;
            System.out.println("Codigo ultimo elemento: " + ultimoCodigo);

            novoItem.setCodigo(ultimoCodigo+1);
            lista.add(novoItem);

            System.out.printf("Item %d adicionado! Tamanho lista: %d", ultimoCodigo+1,lista.size());
            System.out.println();
            salvarArquivoTemporario(lista);
        }
    }


}