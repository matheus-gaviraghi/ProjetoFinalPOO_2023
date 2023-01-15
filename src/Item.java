import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 2728188997394689930L;
	
	protected int codigo;
    protected String descricao;
    protected int quantidade;
    protected double preco;

    Item(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = 0;
        this.preco = 0.0;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
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

        retorno = "Este item possui as seguintes características: " +
                "\nCódigo: " + codigo + "\nDescrição: " + descricao +
                "\nQuantidade: " + quantidade + "\nPreço: " + preco;

        return retorno;
    }

}

