package xadrez;

import tabuleirodojogo.TabuleiroException;

/*Essa classe é estendida da classe de exceção do tabuleiro, 
 * porque dessa maneira basta capturar as exceções de xadrez 
 * que ela também capturará as exceções do tabuleiro*/
public class XadrezException extends TabuleiroException{

	private static final long serialVersionUID = 1L;

	public XadrezException(String msg) {
		super(msg);
	}
	
}
