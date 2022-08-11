package xadrez;

import tabuleirodojogo.Peca;
import tabuleirodojogo.Tabuleiro;

public class PecaXadrez extends Peca {

	private Cores cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	//N�o possui m�todo SET porque a cor s� pode ser acessada e n�o trocada
	public Cores getCor() {
		return cor;
	}

}
