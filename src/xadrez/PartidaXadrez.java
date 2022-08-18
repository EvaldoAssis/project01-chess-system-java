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
	
	/* Esse met�do recebe um posi��o de origem e uma posi��o de destino
	 * Ap�s isso, as posi��es passadas no argumento s�o convertidas para uma posi��o da matriz usando o m�todo posicionar()
	 * A posi��o de origem � validada pelo m�todo validarPosicaoOrigem()
	 * A variav�l capturarPeca recebe o resultado a opera��o moverPeca() que recebe a posi��o de origem e de destino, j� no formato de matriz
	 * Por fim, o m�todo retorna a posi��o capturada, por�m � feito um downcasting para PecaXadrez porque a pe�a capturada era do tipo Peca
	 * */
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		Peca capturarPeca = moverPeca(origem, destino);
		return (PecaXadrez) capturarPeca;
	}
	
	/*Esse m�todo recebe uma posi��o de origem e outra de destino
	 * Primeiramente � criado uma variavel do tipo Peca que recebe a pe�a que est� na posi��o de origem
	 * Depois � declarada uma outra pe�a que recebe a pe�a que possivelmente estava/esta na posi��o de destino
	 * Por fim � retornada a pe�a capturada
	 * */
	private Peca moverPeca(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca capturarPeca = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return capturarPeca;
	}
	
	/*Esse m�todo testa se determinada pe�a de origem existe em determinada posi��o*/
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new XadrezException("N�o existe pe�a na posi��o de origem");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPosivel()) {
			throw new XadrezException("N�o existe movimentos poss�veis para a pe�a escolhida");
		}
	}

	/*Colocando as pe�as no tabuleiro com as coordenadas do Xadrez*/
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).posicionar());
	}
	
	//M�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
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
