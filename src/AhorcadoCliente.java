
////////////////////////////////
//    Francisco Lara Marin    //
//   Miguel Medina Martinez   //
////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class AhorcadoCliente {

	public static void main(String[] args) {
		
		String buferEnvio;
		String buferRecepcion;
		String palabra;
		char letra;
		int opcion;
		Scanner teclado = new Scanner(System.in); //Entrada de teclado
		int vidas;
		Boolean fin = false;
		
		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
		// Puerto en el que espera el servidor:
		int port=8989;
		
		// Socket para la conexión TCP
		Socket socketServicio=null;
		
		try {
			// Creamos un socket que se conecte a "hist" y "port":
			//////////////////////////////////////////////////////
			socketServicio= new Socket (host, port);
			//////////////////////////////////////////////////////			
			
			BufferedReader inReader = new BufferedReader (new InputStreamReader (socketServicio.getInputStream()));
			PrintWriter outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
			

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBIENVENIDO AL JUEGO DEL");
			System.out.println("            _    _   ____   _____    _____            _____    ____  ");
			System.out.println("     /\\    | |  | | / __ \\ |  __ \\  / ____|    /\\    |  __ \\  / __ \\ ");
			System.out.println("    /  \\   | |__| || |  | || |__) || |        /  \\   | |  | || |  | |");
			System.out.println("   / /\\ \\  |  __  || |  | ||  _  / | |       / /\\ \\  | |  | || |  | |");
			System.out.println("  / ____ \\ | |  | || |__| || | \\ \\ | |____  / ____ \\ | |__| || |__| |");
			System.out.println(" /_/    \\_\\|_|  |_| \\____/ |_|  \\_\\ \\_____|/_/    \\_\\|_____/  \\____/ ");
			System.out.println("                                                                     ");
			System.out.println("                                                                     ");
			System.out.println("\n\n\n\n\n\n\n\n Seleccione una opcion para continuar:\n   1. EMPEZAR JUEGO\n   2. SALIR");
			System.out.println("\n");



			opcion = teclado.nextInt();
			outPrinter.println(Integer.toString(opcion)); //Envio la opcion al servidor
			buferRecepcion = inReader.readLine();
			while (buferRecepcion.compareTo("ERROR No existe esa opcion") == 0){
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("ESA OPCION NO EXISTE ELIJA UNA DE LAS SIGUIENTES:\n   1. EMPEZAR JUEGO\n   2. SALIR\n\n");
				opcion = teclado.nextInt();
				outPrinter.println(Integer.toString(opcion)); //Envio la opcion al servidor
				buferRecepcion = inReader.readLine();
			}



			while (buferRecepcion.compareTo("OK Empezando el Juego") == 0){
				vidas = 10;
				fin=false;

				// Comienza a jugar
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				palabra = inReader.readLine();
				//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nVA A COMENZAR EL JUEGO.");
				
				
				while ( !fin ){

					/////////////////////////////////////////////////////////
					//////           PANTALLA PRINCIPAL   ///////////////////
					/////////////////////////////////////////////////////////

					System.out.println("                     ________________ \n                    |                |\n                    |   TU PALABRA   |\n                    |________________|");

					System.out.print("\n\n\n                      ");
					for (int i=0 ; i<palabra.length() ; i++){
						System.out.print(palabra.charAt(i)+"  ");
					}
					System.out.print("\n");

					dibujarAhorcado(vidas);

					System.out.println("\n\nEscribe una letra para adivinar: ");

					/////////////////////////////////////////////////////////
					// Leemos la letra

					letra = teclado.next().charAt(0);
					outPrinter.println(letra);

					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				
					buferRecepcion = inReader.readLine();
					if ( buferRecepcion.compareTo("*FALLO*") == 0){
						vidas--;
						System.out.println("Fallaste!");

					}
					else{
						System.out.println("Letra Acertada");
						palabra = buferRecepcion;
					}

					if ( (inReader.readLine()).compareTo("FIN ha terminado el juego") == 0)
						fin = true;
				}

				if (vidas != 0){
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("                         *******************************\n                         *****   ¡¡ENHORABUENA!!   *****\n                         ****  ACERTASTE LA PALABRA ****\n                         *******************************\n\n\n\n\n");
				}
				else{
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("                         PERDISTE :(");
					dibujarAhorcado(0);	
				}

				System.out.println("\n\n\n\nQUIERES JUGAR DE NUEVO?\n   1. SI\n   2. NO");
				opcion = teclado.nextInt();
				outPrinter.println(Integer.toString(opcion)); //Envio la opcion al servidor
				buferRecepcion = inReader.readLine();

				while (buferRecepcion.compareTo("ERROR No existe esa opcion") == 0){
					System.out.println("ESA OPCION NO EXISTE ELIJA UNA DE LAS SIGUIENTES:\n   1. SI\n   2. NO");
					opcion = teclado.nextInt();
					outPrinter.println(Integer.toString(opcion)); //Envio la opcion al servidor
					buferRecepcion = inReader.readLine();
				}
			}
			
			System.out.println("\nHA TERMINADO EL JUEGO");
			teclado.close();
			socketServicio.close();

			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}


	private static void dibujarAhorcado( int vidas){

		switch (vidas){

			case 10:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 9:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |     _________________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 8:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |                                       |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 7:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 6:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 5:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |                T         |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 4:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |                T         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 3:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |             ___T         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 2:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |             ___T___      |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 1:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |             ___T___      |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |               /          |");
				System.out.println("           |            |              /           |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
			case 0:
				System.out.println("            _______________________________________ ");
				System.out.println("           |                                       |");
				System.out.println("           |             ________________          |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |_        |");
				System.out.println("           |            |               (  )       |");
				System.out.println("           |            |             ___T___      |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |                |         |");
				System.out.println("           |            |               / \\        |");
				System.out.println("           |            |              /   \\       |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |            |                          |");
				System.out.println("           |     _______|_________                 |");
				System.out.println("           |                                       |");
				System.out.println("           |_______________________________________|");
				break;
		}


	}


}
