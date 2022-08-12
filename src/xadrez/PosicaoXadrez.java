package xadrez;

import tabuleirodojogo.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;

	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrexException("Error ao instanciar a posi��o do Xadrez. Valores v�lidos s�o de a1 at� h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	/*
	 * Converte essa posi��o para um posi��o "normal" Ou seja, converter a posi��o
	 * passada pelo usu�rio, por uma posi��o da matriz. Exemplo: Usu�rio digita A2 e
	 * a pe�a � colocada na coluna 0 e na linha 3 (lembrando que a matriz come�a no 0)
	 */
	protected Posicao posicionar() {
		return new Posicao(8 - linha, coluna - 'a');
	}

	protected static PosicaoXadrez fromPosicaoXadrez(Posicao posicao) {
		return new PosicaoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}

	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
}
