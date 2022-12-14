package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cores;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {


	/*C?digos especiais das cores para imprimir no console
	 * Acima: Cores do texto
	 * Abaixo: Cores di fundo
	 * 
	 * 	https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	 */
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
	}
	
	/*Esse metodo ? utilizado para ler a posi??o do xadrez, funciona da seguinte maneira: 
	 * Ele recebe como argumento o que foi lido no Scanner do programa principal
	 * Recorta a String recebida para pegar a coluna desejada usando o chartAt(0) (pega a primeira letra da String)
	 * Recorta o String a partir da posi??o 1 e converte para inteiro para pegar a linha
	 * O m?todo recebe uma nova posi??o xadrez, recebendo a coluna e a linha citadas anteriormente
	 * Lan?a uma excess?o se houver entrada de dados inv?lida*/
	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
		try {
			String s = sc.nextLine();
			//
			char coluna = s.charAt(0);
			//
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoXadrez(coluna, linha);	
		}catch (Exception e) {
			throw new InputMismatchException("Erro para ler posi??o do xadrez. Valores v?lidos s?o de A1 at? H8.");
		}
	}

	public static void printTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	/*Para imprimir a pe?a, tem 2 testes
	 * 1? Se a pe?a ? nula
	 * 2? Se a cor da pe?a for branca ou se a cor da pe?a ? amarela*/
	private static void printPeca(PecaXadrez peca) {
    	if (peca == null) {
            System.out.print("-");
        }
        else {
            if (peca.getCor() == Cores.WHITE) {
                System.out.print(ANSI_RED + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
}