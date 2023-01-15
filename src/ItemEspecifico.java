import java.io.Serializable;

public class ItemEspecifico extends Item implements Serializable {
	
	private static final long serialVersionUID = 7500106824771378466L;
	
	protected double comprimento, largura, espessura;
	protected String cor;
	
	ItemEspecifico(int codigo, String descricao){
		super(codigo, descricao);
		this.comprimento = 0.0;
		this.largura = 0.0;
		this.espessura = 0.0;
		this.cor = "Não definida";
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
