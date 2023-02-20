package paquete_triqui;

public class ambiente{

	private char tableroAmbiente[];
	private agente agenteAmbiente;
	private  adversario adversarioAmbiente;
	private boolean turnoAgentePorPartida;
	private boolean turnoAgente;

	public ambiente(){
		this.tableroAmbiente = new char[9];
		this.agenteAmbiente = new agente();
		this.adversarioAmbiente = new adversario();
		this.turnoAgentePorPartida = true;
		this.turnoAgente = this.turnoAgentePorPartida;
	}

	public void reiniciar(){
		this.tableroAmbiente = new char[9];
		this.turnoAgente = this.turnoAgentePorPartida;
		this.mostrarTablero();
	}


	public void mostrarTablero(){
		System.out.println("----------");
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (tableroAmbiente[j + (3*i)] == '\0'){
					System.out.print(" |");
				}else{
					System.out.print(Character.toString(this.tableroAmbiente[j + (3*i)]));
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}

	public boolean turnoDelAgente(){
		return this.turnoAgente;
	}

	public void revisarFindeJuego(){
		abstraccionTablero estadoActual = new abstraccionTablero(this.tableroAmbiente);
		if (estadoActual.ganador() != 'N'){
			switch (estadoActual.ganador()){
				case 'X':
					System.out.println("X gana el juego");
					this.reiniciar();
					break;
				case 'O':
					System.out.println("O gana el juego");
					this.reiniciar();
					break;
				case 'E':
					System.out.println("Es un empate");
					this.reiniciar();
					break;
			}
		}
	}
	public void accionAdversario(){
		System.out.println("Turno del adversario");
		int evaluarDesicion = this.adversarioAmbiente.desicion();
		if (evaluarDesicion >= 0){
			this.tableroAmbiente[evaluarDesicion] = this.adversarioAmbiente.signo();
		}else{
			this.turnoAgentePorPartida = ((this.turnoAgentePorPartida)?false:true);
			this.reiniciar();

		}
	}
	public void accionAgente(){
		System.out.println("Turno del agente");
		//El agente forma su percepcion a traves del sensor
		this.agenteAmbiente.sensor(this.tableroAmbiente);
		this.tableroAmbiente[this.agenteAmbiente.desicion()] = this.agenteAmbiente.signo();
	}
	public void cambiarTurno(){
		this.turnoAgente = ((this.turnoAgente == true) ? false : true);
	}

}
