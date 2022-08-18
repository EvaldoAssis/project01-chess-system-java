package xadrez;

import tabuleirodojogo.Peca;
import tabuleirodojogo.Posicao;
import tabuleirodojogo.Tabuleiro;
import tabuleirodojogo.TabuleiroException;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicialSetup();
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
	
	/* Esse metódo recebe um posição de origem e uma posição de destino
	 * Após isso, as posições passadas no argumento são convertidas para uma posição da matriz usando o método posicionar()
	 * A posição de origem é validada pelo método validarPosicaoOrigem()
	 * A variavél capturarPeca recebe o resultado a operação moverPeca() que recebe a posição de origem e de destino, já no formato de matriz
	 * Por fim, o método retorna a posição capturada, porém é feito um downcasting para PecaXadrez porque a peça capturada era do tipo Peca
	 * */
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		Peca capturarPeca = moverPeca(origem, destino);
		return (PecaXadrez) capturarPeca;
	}
	
	/*Esse método recebe uma posição de origem e outra de destino
	 * Primeiramente é criado uma variavel do tipo Peca que recebe a peça que está na posição de origem
	 * Depois é declarada uma outra peça que recebe a peça que possivelmente estava/esta na posição de destino
	 * Por fim é retornada a peça capturada
	 * */
	private Peca moverPeca(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca capturarPeca = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return capturarPeca;
	}
	
	/*Esse método testa se determinada peça de origem existe em determinada posição*/
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPosivel()) {
			throw new XadrezException("Não existe movimentos possíveis para a peça escolhida");
		}
	}

	/*Colocando as peças no tabuleiro com as coordenadas do Xadrez*/
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).posicionar());
	}
	
	//Método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
	private void inicialSetup() {
		colocarNovaPeca('c', 1, new Torre(tabuleiro, Cores.WHITE));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cores.WHITE));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cores.WHITE));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cores.WHITE));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cores.WHITE));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cores.WHITE));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cores.BLACK));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cores.BLACK));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cores.BLACK));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cores.BLACK));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cores.BLACK));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cores.BLACK));
	}

}
