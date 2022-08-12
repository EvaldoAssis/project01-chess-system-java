package xadrez;

import java.awt.Color;

import tabuleirodojogo.Posicao;
import tabuleirodojogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicialSetup();
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

	/*Colocando as pe�as no tabuleiro com as coordenadas do Xadrez*/
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).posicionar());
	}
	
	//M�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
	private void inicialSetup() {
		colocarNovaPeca('b', 6, new Torre(tabuleiro, Cores.WHITE));
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cores.BLACK));
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cores.WHITE));
	}

}
