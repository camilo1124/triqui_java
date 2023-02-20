package paquete_triqui;

import java.util.Random;
import java.lang.Math.*;

public class agentePrograma{
	private char signoIdentidad;
	private char signoAdversario;
	private boolean maximizar;

	public agentePrograma(){
		this.signoIdentidad = 'X';
		this.signoAdversario = 'O';
		this.maximizar = true;

	}
	public char obtenerSigno(){
		return this.signoIdentidad;
	}
	public void cambiarRol(){
		this.signoIdentidad = ((this.signoIdentidad=='X')?'O':'X');
		this.signoAdversario = ((this.signoAdversario=='X')?'O':'X');
		this.maximizar =((this.maximizar)?false:true);
	}
	public int calcular(abstraccionTablero percepcion){
		/*
		if (percepcion.estaVacio()){
			//this.cambiarRol();
			Random rd = new Random();
			return rd.nextInt(9);
		}
		*/
		
		
		int mejorPuntaje = -30000;
		int movimiento = 15;

		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3;j++){
				if (percepcion.obtenerEstado()[j + (3*i)] == '\0'){
					percepcion.cambiarEstado(this.signoIdentidad,(j+(3*i)));
					int puntaje = minimax(percepcion,false);
					percepcion.cambiarEstado('\0',(j+(3*i)));
					if (puntaje > mejorPuntaje){
						mejorPuntaje = puntaje;
						movimiento = (j+(3*i));
					}
				}
			}
		}
		return movimiento;

	}
	public int minimax(abstraccionTablero escenario,boolean maximizando){
		char escenarioEstado = escenario.ganador();
		if (escenarioEstado != 'N'){
			switch (escenarioEstado){
				case 'X':
					return 1;
				case 'O':
					return -1;
				case 'E':
					return 0;
				default:
					break;
			}
		}
		if(maximizando == true){
			int mejorPuntaje = -30000;
				for (int i = 0;i < 3; i++){
					for (int j = 0; j < 3 ; j++){
						if (escenario.obtenerEstado()[j +(3*i)] == '\0'){
							escenario.cambiarEstado(this.signoIdentidad,(j + (3*i)));
							int puntaje = minimax(escenario,false);
							escenario.cambiarEstado('\0',(j + (3*i)));
							mejorPuntaje = Math.max(puntaje,mejorPuntaje);
						}
					}
				}
			return mejorPuntaje;
		}else{
			int mejorPuntaje = 30000;
				for (int i = 0;i < 3; i++){
					for (int j = 0; j < 3 ; j++){
						if (escenario.obtenerEstado()[j +(3*i)] == '\0'){
							escenario.cambiarEstado(this.signoAdversario,(j + (3*i)));
							int puntaje = minimax(escenario,true);
							escenario.cambiarEstado('\0',(j + (3*i)));
							mejorPuntaje = Math.min(puntaje,mejorPuntaje);
						}
					}
				}
			return mejorPuntaje;
		}
	}
}
