package xadrez;

import tabuleirodojogo.Tabuleiro;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
	}
	
	//Esse método retorna uma matriz de peças
	//O primeiro FOR peercorre as linhas
	//O primeiro FOR peercorre as linhas
	/*Para cada posição [i],[j] do tabuleiro, a matriz denomida como MAT na linha i e coluna j, 
	 * vai receber o tabuleiro.peca(i, j). Entretanto é necessário fazer o dowcasting para PecaXadrez para
	 * ser intepretado como peça de xadrez e não peça comum */
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	

}
