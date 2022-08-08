package xadrez;

import tabuleirodojogo.Tabuleiro;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
	}
	
	//Esse m�todo retorna uma matriz de pe�as
	//O primeiro FOR peercorre as linhas
	//O primeiro FOR peercorre as linhas
	/*Para cada posi��o [i],[j] do tabuleiro, a matriz denomida como MAT na linha i e coluna j, 
	 * vai receber o tabuleiro.peca(i, j). Entretanto � necess�rio fazer o dowcasting para PecaXadrez para
	 * ser intepretado como pe�a de xadrez e n�o pe�a comum */
	
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
