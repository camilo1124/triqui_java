package paquete_triqui;

public class main{
	public static void main(String[] args){
		ambiente Ambiente = new ambiente();
		do{
			Ambiente.mostrarTablero();
			Ambiente.revisarFindeJuego();
			if (Ambiente.turnoDelAgente() == true){
				Ambiente.accionAgente();
				Ambiente.cambiarTurno();
			}else{
				Ambiente.cambiarTurno();
				Ambiente.accionAdversario();
			}
		}while(true);
	}
}
