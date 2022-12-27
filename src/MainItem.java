import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MainItem implements Serializable {

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

        } else {
            System.out.println("Você digitou uma opção inválida!");
        }
    }
}