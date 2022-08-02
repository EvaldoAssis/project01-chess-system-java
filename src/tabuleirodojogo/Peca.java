package tabuleirodojogo;

/*Essa classe Peça possui uma posição protected, isso porque este tipo de posição não se trata da posição no xadrez
 *  e sim de uma posicao simples de matriz. Não queremos que essa posição seja visivel na camada de xadrez, então será protected*/

public class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	/*Passando apenas o tabuleiro no construtor, pois a posição de uma peça recém criada será nula, 
	 * significnado que a peça ainda não foi colocada no tabuleiro*/
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	//Não é permitido que um tabuleiro seja alterado, por isso tem somente o método get;
	//Um tabuleiro só pode ser acessado por classes do mesmo pacote e as subclasses da classe peça;
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}	
	
}
