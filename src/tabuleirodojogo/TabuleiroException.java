package tabuleirodojogo;


//Exceção personalizada para a classe tabuleiro
public class TabuleiroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TabuleiroException(String msg) {
		super(msg);
	}

}
