package xadrez.pecas;

import tabuleirodojogo.Posicao;
import tabuleirodojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez{

	public Torre(Tabuleiro tabuleiro, Cores cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPosiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		
		/*Os c�digos abaixo est�o dividos, por�m tem o funcionam praticamente igual, 
		 * alterando apenas a "dire��o (acima, a esquerda, a direta, abaixo). Funcionam da seguinte forma:"
		 *Enquanto a posi��o p existir e n�o tiver uma pe�a l�
		 *Marcar a matriz como verdadeira e setar a linha/coluna com o valor devido
		 *Depois testa se tem pe�a advers�ria*/
		
		// acima da pe�a
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// a esquerda da pe�a
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// a direita da pe�a
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// abaixo da pe�a
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
	
}
