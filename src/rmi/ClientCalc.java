package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientCalc {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Calc calculator;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n ########################### \n "
					+ "\n 1- adição"
					+ "\n 2- subtração"
					+ "\n 3- multiplicação"
					+ "\n 4- divisão"
					+ "\n 5- sair"
					+ "\n \n ################################# \n");
			
			System.out.println("Entre com a opção? ");
			int opt = sc.nextInt();
			
			if (opt == 5) {
				break;
			}
			System.out.println("Entre com o primeiro valor: ");
			int a = sc.nextInt();
			
			System.out.println("Entre com o segundo valor: ");
			int b = sc.nextInt();
			
			int result;
			calculator = (Calc) Naming.lookup("rmi://localhost:2335/calc");
			
			switch (opt) {
			case 1: {
				result = calculator.getSoma(a, b);
				System.out.println("\n Adição: " + result);
				break;
			} case 2: {
				result = calculator.getSubtracao(a, b);
				System.out.println("\n Subtração: " + result);
				break;
			}case 3: {
				result = calculator.getMultiplicacao(a, b);
				System.out.println("\n Multiplicação: " + result);
				break;
			}case 4: {
				double result1 = (int) calculator.getDivisao(a, b);
				System.out.println("\n Divisão: " + result1);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
		}

	}

}
