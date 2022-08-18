package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();

		// Colocando true no while para ficar repetindo sem parar
		while (true) {
			
			try {

				UI.clearScreen();
				
				// Imprimindo o tabuleiro
				UI.printTabuleiro(partida.getPecas());

				System.out.println();

				// Pedindo que o usuário digite a posição de origem
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

				// Pedindo que o usuário digite a posição de destino
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

				// Chamando os métodos para mover da origem para o destino
				PecaXadrez capturarPecaXadrez = partida.executarMovimentoXadrez(origem, destino);

			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
