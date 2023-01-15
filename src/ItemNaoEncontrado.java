
public class ItemNaoEncontrado extends Exception{

	private static final long serialVersionUID = 7799549058873050933L;

	public ItemNaoEncontrado() {
	
	}
	
	public ItemNaoEncontrado(String mensagemErro) {
		super(mensagemErro);
	}
}
