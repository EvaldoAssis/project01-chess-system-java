package xadrez;

import tabuleirodojogo.Peca;
import tabuleirodojogo.Tabuleiro;

public class PecaXadrez extends Peca {

	private Cores cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	//Não possui método SET porque a cor só pode ser acessada e não trocada
	public Cores getCor() {
		return cor;
	}

}
