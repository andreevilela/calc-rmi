package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalcServer extends UnicastRemoteObject implements Calc {

	private static final long serialVersionUID = 1L;

	
	public CalcServer() throws RemoteException {
		super();
	}

	@Override
	public int getSoma(int a, int b) throws RemoteException {
		System.out.println("Calculando a soma de " + a + " + " + b);
		return a + b;
	}

	@Override
	public int getSubtracao(int a, int b) throws RemoteException {
		System.out.println("Calculando a subtração de " + a + " - " + b);
		return a - b;
	}

	@Override
	public int getMultiplicacao(int a, int b) throws RemoteException {
		System.out.println("Calculando a multiplicação de " + a + " * " + b);
		return a * b;
	}

	@Override
	public double getDivisao(int a, int b) throws RemoteException {
		System.out.println("Calculando a divesão de " + a + " / " + b);
		return (double) a / (b + 0.000000001);
	}
	

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		LocateRegistry.createRegistry(2335);
		CalcServer f = new CalcServer();
		Naming.rebind("//localhost:2335/calc", f);
		System.out.println("\n Servidor Calculadora pronto");
		
	}
}
