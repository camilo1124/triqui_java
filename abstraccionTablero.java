package paquete_triqui;

public class abstraccionTablero{

	private char estado[];

	public abstraccionTablero(){
		this.estado = new char[9];
	}

	public abstraccionTablero(char estado[]){
		this.estado = estado;
	}

	public char[] obtenerEstado(){
		return this.estado;
	}
	public void cambiarEstado(char simbolo,int posicion){
		this.estado[posicion] = simbolo;
	}
	
	public boolean estaVacio(){
		for (int i = 0;i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (this.estado[j + (i*3)] != '\0'){
					return false;
				}
			}
		}
		return true;
	}

	public boolean estaLleno(){
		for (int i = 0;i < 3; i++){
			for (int j = 0;j < 3; j++){
				if (this.estado[j + (i*3)] == '\0'){
					return false;
				}
			}
		}
		return true;
	}

	public char ganador(){

		char jugador = 'N';

		for (int i = 0;i < 3 ; i++){
			if(this.iguales(this.estado[0 + (3*i)],this.estado[1 + (3*i)],this.estado[2 + (3*i)])){
				jugador = this.estado[0 + (3*i)];
			}
		}
		for (int i = 0;i < 3 ; i++){
			if(this.iguales(this.estado[0 + (i)],this.estado[3 + (i)],this.estado[6 + (i)])){
				jugador = this.estado[0 + (i)];
			}
		}
		if(this.iguales(this.estado[0],this.estado[4],this.estado[8])){
			jugador = this.estado[0];
		}
		if(this.iguales(this.estado[6],this.estado[4],this.estado[2])){
			jugador = this.estado[6];
		}

		if (jugador == 'N' && (this.estaLleno() == true)){
			return 'E';
		}else{
			return jugador;
		}
	}

	public boolean iguales(char a,char b,char c){
		return (a==b && b==c && a!='\0');
	}

}

