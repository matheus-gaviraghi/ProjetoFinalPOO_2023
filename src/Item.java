
public class Item {

    protected int codigo;
    protected String descricao;
    protected int quantidade;
    protected double preco;

    Item(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    Item(int codigo, String descricao, int quantidade){
        this(codigo, descricao);
        this.quantidade = quantidade;
    }

    Item(int codigo, String descricao, int quantidade, double preco){
        this(codigo, descricao, quantidade);
        this.preco = preco;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void changeDescricao(String descricao){
        this.descricao = descricao;
    }

    public String toString(){
        String retorno;

        retorno = "\nEste item possui as seguintes características: " +
                "\nCodigo: " + codigo + "\nDescricao: " + descricao +
                "\nQuantidade: " + quantidade + "\nPreco: " + preco;

        return retorno;
    }

}

