package tabuleirodojogo;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	/* Construtor */
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException(
					"Erro ao criar tabuleiro: É necessário que haja pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	/*Linhas e Colunas não possui método set, pois depois de criado um tabuleiro não pode ser alterado */

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição não existente no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	/*Esse metodo vai na matriz de pecas do tabuleiro na linha e coluna especificada
	e atribuir a posição da matriz de peça, a peça que veio como argumento*/
	public void colocarPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) {
			throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição inexistente no tabuleiro");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	/*
	 * Esse método se trta de um método auxiliar que testa se uma posição existe no
	 * tabuleiro da seguinte forma: Se a linha for mair ou igual a 0, se a linha for
	 * menor que a altura do tabuleiro (quantidade de linhas, atributo linhas) Se a
	 * coluna for mais ou igual a 0, se a coluna for menor que a comprimento
	 * (quantidade de colunas, atributo colunas)
	 */
	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	// Esse método retorno o método acima
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	/*
	 * Metodo que verifica se uma determinada peça existe Ele testa se a peça em
	 * determinada posição é diferente nulo
	 */
	public boolean existePeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição inexistente no tabuleiro");
		}
		return peca(posicao) != null;
	}

}
