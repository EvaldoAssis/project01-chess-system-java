package xadrez;

import tabuleirodojogo.TabuleiroException;

/*Essa classe � estendida da classe de exce��o do tabuleiro, 
 * porque dessa maneira basta capturar as exce��es de xadrez 
 * que ela tamb�m capturar� as exce��es do tabuleiro*/
public class XadrezException extends TabuleiroException{

	private static final long serialVersionUID = 1L;

	public XadrezException(String msg) {
		super(msg);
	}
	
}
