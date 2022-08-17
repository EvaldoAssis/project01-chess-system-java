package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		
		//Colocando true no while para ficar repetindo sem parar
		while (true) {
			
			//Imprimindo o tabuleiro
			UI.printTabuleiro(partida.getPecas());
			
			System.out.println();
			
			//Pedindo que o usuário digite a posição de origem
			System.out.println("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			
			//Pedindo que o usuário digite a posição de destino
			System.out.println("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
			
			//Chamando os métodos para mover da orgiem para o destino
			PecaXadrez capturarPecaXadrez = partida.executarMovimentoXadrez(origem, destino);
			
		}
	}

} 
