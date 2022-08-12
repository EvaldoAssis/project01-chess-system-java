package xadrez;

import tabuleirodojogo.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;

	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrexException("Error ao instanciar a posição do Xadrez. Valores válidos são de a1 até h8.");
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
	 * Converte essa posição para um posição "normal" Ou seja, converter a posição
	 * passada pelo usuário, por uma posição da matriz. Exemplo: Usuário digita A2 e
	 * a peça é colocada na coluna 0 e na linha 3 (lembrando que a matriz começa no 0)
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
