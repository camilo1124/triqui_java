package paquete_triqui;

public class agente{
	//Identidad del agente o estado de creencia
	private agentePrograma programaDelAgente;
	private abstraccionTablero percepcion;

	public agente(){
		this.programaDelAgente = new agentePrograma();
	}
	public void sensor(char representacion_tablero[]){
		this.percepcion = new abstraccionTablero(representacion_tablero);
	}
	public int desicion(){
		return this.programaDelAgente.calcular(this.percepcion); 

	}
	public char signo(){
		return programaDelAgente.obtenerSigno();
	}
}
