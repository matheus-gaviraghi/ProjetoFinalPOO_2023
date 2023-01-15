import java.io.Serializable;

public class ItemEspecifico extends Item implements Serializable {
	
	protected double comprimento, largura, espessura;
	protected String cor;
	
	ItemEspecifico(int codigo, String descricao){
		super(codigo, descricao);
		this.comprimento = 0.0;
		this.largura = 0.0;
		this.espessura = 0.0;
		this.cor = "Não definida";
	}
	
	ItemEspecifico(int codigo, String descricao, int quantidade){
		super(codigo, descricao, quantidade);
		this.comprimento = 0.0;
		this.largura = 0.0;
		this.espessura = 0.0;
		this.cor = "Não definida";
	}
	
	ItemEspecifico(int codigo, String descricao, int quantidade, double preco,
				   double comprimento, double largura, double espessura, String cor){
		super(codigo, descricao, quantidade, preco);
		this.comprimento = comprimento;
		this.largura = largura;
		this.espessura = espessura;
		this.cor = cor;
	}
	
	public double getComprimento() {
		return comprimento;
	}
	
	public double getLargura() {
		return largura;
	}
	
	public double getEspessura() {
		return espessura;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String toString(){
		String retorno = super.toString();

		retorno += "\nComprimento: " + comprimento +
				  "\nLargura: " + largura +
				  "\nEspessura: " + espessura +
				  "\nCor: " + cor;

		return retorno;
	}
}
