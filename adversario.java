package paquete_triqui;
import java.util.Scanner;

public class adversario{
	private int jugada;
	private char signo;

	public adversario(){
		this.jugada = 0;
		this.signo = 'O';
	}
	public int desicion(){
		Scanner movimiento  = new Scanner(System.in);
		this.jugada = movimiento.nextInt();
		return this.jugada;

	}
	public char signo(){
		return this.signo;
	}
}
