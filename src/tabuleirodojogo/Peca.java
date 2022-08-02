package tabuleirodojogo;

/*Essa classe Pe�a possui uma posi��o protected, isso porque este tipo de posi��o n�o se trata da posi��o no xadrez
 *  e sim de uma posicao simples de matriz. N�o queremos que essa posi��o seja visivel na camada de xadrez, ent�o ser� protected*/

public class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	/*Passando apenas o tabuleiro no construtor, pois a posi��o de uma pe�a rec�m criada ser� nula, 
	 * significnado que a pe�a ainda n�o foi colocada no tabuleiro*/
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	//N�o � permitido que um tabuleiro seja alterado, por isso tem somente o m�todo get;
	//Um tabuleiro s� pode ser acessado por classes do mesmo pacote e as subclasses da classe pe�a;
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}	
	
}
