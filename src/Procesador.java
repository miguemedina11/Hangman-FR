
////////////////////////////////
//    Francisco Lara Marin    //
//   Miguel Medina Martinez   //
////////////////////////////////

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Collections;



//
// Nota: si esta clase extendiera la clase Thread, y el procesamiento lo hiciera el método "run()",
// ¡Podríamos realizar un procesado concurrente! 
//
public class Procesador {
	// Referencia a un socket para enviar/recibir las peticiones/respuestas
	private Socket socketServicio;

	// Para que la palabra sea diferente, usamos un generador de números aleatorios.
	private Random random;

	//array con palabras a adivinar
	private ArrayList<String> palabras;

	// Palabra a adivinar
	private String palabraElegida;

	private String palabraVacia;

	//booleano que indica si el juego ha acabado
	private Boolean fin;

	//Variable que guarda las vidas del cliente
	int vidas;
	
	// Constructor que tiene como parámetro una referencia al socket abierto en por otra clase
	public Procesador(Socket socketServicio) {
		this.socketServicio=socketServicio;
		random=new Random();
		inicializarPalabras();
		fin = false;
		vidas = 10;
		palabraVacia = "";
	}
	
	
	
	// Aquí es donde se realiza el procesamiento realmente:
	void run(){

		System.out.println("JUGADOR CONECTADO");
		
		String datosRecibidos;
		String  datosEnviar;
		int opcion;
		char lectura;
		
		try {
			// Obtiene los flujos de escritura/lectura
			BufferedReader inReader = new BufferedReader (new InputStreamReader (socketServicio.getInputStream()));
			PrintWriter outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
			

			opcion = Integer.parseInt(inReader.readLine());  // Lectura de la opcion del menu
			while(opcion!=1 && opcion!=2){
				outPrinter.println("ERROR No existe esa opcion");
				opcion = Integer.parseInt(inReader.readLine());
			}


			while (opcion == 1){
				outPrinter.println("OK Empezando el Juego");
				Collections.shuffle(palabras);
				palabraElegida = palabras.get(0);
				vidas = 10;
				palabraVacia = "";
				fin=false;

				for (int i=0 ; i< palabraElegida.length() ; i++){
					palabraVacia += "_";
				}
				outPrinter.println(palabraVacia);

				
				

				while ( !fin ){

					lectura = ((inReader.readLine()).toUpperCase()).charAt(0);
					
					if (buscarEnPalabra(lectura)){
						//Si se ha acertado
						outPrinter.println(palabraVacia);
					}
					else{
						//Si no se ha acertado
						vidas--;
						
						outPrinter.println("*FALLO*");
					}

					fin = (palabraElegida.compareTo(palabraVacia) == 0) || (vidas == 0);
					if (fin)
						outPrinter.println("FIN ha terminado el juego");
					else
						outPrinter.println("NO FIN ha terminado el juego");				
				}

				

				opcion = Integer.parseInt(inReader.readLine());  // Lectura de la opcion del menu
				while(opcion!=1 && opcion!=2){
					System.out.println("Opción incorrecta");
					opcion = Integer.parseInt(inReader.readLine());
				}
			}
			
			outPrinter.println("OK Saliendo del Juego");
			
			socketServicio.close();
			
			
		} catch (IOException e) {
			System.err.println("Error al obtener los flujo de entrada/salida.");
		}

	}

	private void inicializarPalabras(){
		
		palabras = new ArrayList<String>();

		palabras.add("COCHE");
		palabras.add("ORDENADOR");
		palabras.add("PLAYA");
		palabras.add("PUERTA");
		palabras.add("MURCIELAGO");
		palabras.add("FUTBOLISTA");
		palabras.add("ESTERNOCLEIDOMASTOIDEO");
		palabras.add("PROFESOR");
	}

	private Boolean buscarEnPalabra (char letra){

		Boolean result = false;
		String aux = "";
		
		for (int i=0 ; i<palabraElegida.length(); i++){
			if (palabraElegida.charAt(i) == letra){
				aux+=letra;
				result = true;
			}
			else
				aux+=palabraVacia.charAt(i);
		}

		palabraVacia = aux;

		return result;

	}



}
