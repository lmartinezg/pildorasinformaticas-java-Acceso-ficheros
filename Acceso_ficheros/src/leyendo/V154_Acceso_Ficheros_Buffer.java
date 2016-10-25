// Referencias: 
//
// Vídeo 154 - Leer fichero mediante buffer
//
// Clase BufferedReader.- 
// Método readLine() - Lee líneas completas

package leyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class V154_Acceso_Ficheros_Buffer {

	public static void main(String[] args) {

		V154_Leer_Fichero accediendo = new V154_Leer_Fichero();
		accediendo.lee();

	}

}

class V154_Leer_Fichero {

	public void lee() {

		// boolean FileReader_abierto = false;
		// boolean BufferedReader_abierto = false;

		String ruta = "Z:/Dropbox/LMG/Cursos/2016 - Java/V154_ejemplo.txt";
		int numero_linea = 0;

		try {
			entrada = new FileReader(ruta);
			// FileReader_abierto = true;

			mibuffer = new BufferedReader(entrada);
			// BufferedReader_abierto = true;

			String linea;

			do {
				linea = mibuffer.readLine();
				if (linea != null) {
					numero_linea++;
					System.out.printf("%3d %s%n", numero_linea, linea);
				}
			} while (linea != null);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichero no encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de Entrada/Salida.");
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			// if (FileReader_abierto) {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// }
			// if (BufferedReader_abierto) {
			try {
				mibuffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// }
		}
	}

	private FileReader entrada;
	private BufferedReader mibuffer;
}
