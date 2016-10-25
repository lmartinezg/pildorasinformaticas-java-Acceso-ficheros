// Referencias: 
//
// Vídeo 152 - Leer Stream
//
// Clase FileReader
// Método read() (no interpreta los saltos de línea (devuelve dos int, 0A + 0D)
// Método close() (se ve en el vídeo 153)
// En el vídeo 153 hay otra posible modificación al bucle while para procesar correctamente el primer caracter

package leyendo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class V152_Acceso_Ficheros {

	public static void main(String[] args) {

		Leer_Fichero accediendo = new Leer_Fichero();
		accediendo.lee(2);

	}

}

class Leer_Fichero {

	public void lee(int tipo_impr) {

		String ruta = "Z:/Dropbox/LMG/Cursos/2016 - Java/V152_ejemplo.txt";
		boolean abierto = false;

		try {
			entrada = new FileReader(ruta);
			abierto = true;

			System.out.println("Fichero: " + ruta);
			System.out.println("Encoding: " + entrada.getEncoding());
			System.out.println("Estado FileReader abierto: " + abierto);
			System.out.println();

			System.out.println("-- Inicio --");

			// Ejemplo original del vídeo. Falla al omitir el primer caracter
			// int c = entrada.read();
			// while (c != -1) {
			// c = entrada.read();
			// System.out.println(c);
			// }

			// Versión corregida
			int i;
			do {
				i = entrada.read();

				if (!(i == -1)) {
					switch (tipo_impr) {
					case 1:
						System.out.println(i + "\t" + (char) i);
						break;
					case 2:
						System.out.print((char) i);
						break;
					default:
						System.out.print((char) i);
					}
				}
			} while (!(i == -1));

			System.out.println("-- Fin --");

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado: " + ruta);
		} catch (IOException e) {
			System.out.println("Error de entrada/salida.");
			// e.printStackTrace();
		} finally {
			try {
				if (abierto) {
					entrada.close();
					abierto = false;
				}
			} catch (IOException e) {
			}
		}

		System.out.println("Estado FileReader abierto: " + abierto);

	}

	private FileReader entrada;
}