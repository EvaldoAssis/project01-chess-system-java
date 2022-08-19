package xadrez;

import tabuleirodojogo.Peca;
import tabuleirodojogo.Posicao;
import tabuleirodojogo.Tabuleiro;

public abstract class PecaXadrez extends Peca {

	private Cores cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	//Não possui método SET porque a cor só pode ser acessada e não trocada
	public Cores getCor() {
		return cor;
	}

	/*Esse método será reaproveitado em todas as peças, por este motivo ela está na classe PecaXadrez
	 * Ela testa se existe a peça de um adversário em determianda posição. A operação é feita da seguinte forma:
	 * A variavel p do tipo PecaXadrez recebe a peça que estivar na posição passada no argumento
	 * No retorno o método testa se a peça da posição é diferente de null 
	 * e se a cor da peça é diferente da cor das nossas peças (se é diferente da cor da peça do adversário))*/
	protected boolean existePecaAdversaria(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
	
}
