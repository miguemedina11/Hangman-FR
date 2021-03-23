
////////////////////////////////
//    Francisco Lara Marin    //
//   Miguel Medina Martinez   //
////////////////////////////////

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;



public class AhorcadoServidor {

	public static void main(String[] args) {
	
		// Puerto de escucha
		int port=8989;
		// string auxiliar para recibir o enviar datos.
		String buffer;

		ServerSocket socketServidor;
		
		try {
			// Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"
			//////////////////////////////////////////////////
			socketServidor= new ServerSocket(port);
			//////////////////////////////////////////////////
			
			// Mientras ... siempre!
			do {
				Socket socketServicio = null;
				// Aceptamos una nueva conexión con accept()
				/////////////////////////////////////////////////
				try {
					socketServicio=socketServidor.accept();
				} catch (IOException e) {
					System.out.println("Error : No se pudo aceptar la conexion solicitada");
				}
				
				//////////////////////////////////////////////////
				
				Procesador procesador=new Procesador(socketServicio);
				procesador.run();
				
			} while (true);
			
		} catch (IOException e) {
			System.err.println("Error al escuchar en el puerto "+port);
		}

	}

}
