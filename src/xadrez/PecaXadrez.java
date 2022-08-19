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
	
	//N�o possui m�todo SET porque a cor s� pode ser acessada e n�o trocada
	public Cores getCor() {
		return cor;
	}

	/*Esse m�todo ser� reaproveitado em todas as pe�as, por este motivo ela est� na classe PecaXadrez
	 * Ela testa se existe a pe�a de um advers�rio em determianda posi��o. A opera��o � feita da seguinte forma:
	 * A variavel p do tipo PecaXadrez recebe a pe�a que estivar na posi��o passada no argumento
	 * No retorno o m�todo testa se a pe�a da posi��o � diferente de null 
	 * e se a cor da pe�a � diferente da cor das nossas pe�as (se � diferente da cor da pe�a do advers�rio))*/
	protected boolean existePecaAdversaria(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
	
}
