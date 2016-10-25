// Referencias: 
//
// Vídeo 153 - Escribir Stream
//
// Clase FileWriter
// Método read() (no interpreta los saltos de línea (devuelve dos int, 0A + 0D)

package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class V153_Acceso_Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escribir_Fichero escribiendo = new Escribir_Fichero();
		escribiendo.escribe();
	}

}

class Escribir_Fichero {

	public void escribe() {

		String ruta = "Z:/Dropbox/LMG/Cursos/2016 - Java/V153_ejemplo.txt";
		boolean abierto = false;

		String frase = "Esto es una prueba de escritura.";

		try {
			// salida = new FileWriter(ruta);
			// El segundo parámetro corresponde a append:
			// true=>añadir,
			// false=>reemplazar.
			salida = new FileWriter(ruta, true);
			abierto = true;

			System.out.println("Fichero: " + ruta);
			System.out.println("Encoding: " + salida.getEncoding());
			System.out.println("Estado FileWriter abierto: " + abierto);
			System.out.println();

			System.out.println("-- Inicio --");
			for (int i = 0; i < frase.length(); i++) {
				salida.write(frase.charAt(i));
			}
		} catch (IOException e) {
			System.out.println("Error de entrada/salida.");
			// e.printStackTrace();
		} finally {
			try {
				if (abierto) {
					salida.close();
					abierto = false;
				}
			} catch (IOException e) {
			}
		}

		System.out.println("-- Fin --");

		System.out.println("Estado FileWriter abierto: " + abierto);

	}

	private FileWriter salida;
}
