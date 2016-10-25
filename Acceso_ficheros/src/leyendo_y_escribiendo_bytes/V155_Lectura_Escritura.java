// Referencias:
//
// Vídeos 155 y 156 - Leer y escribir bytes en ficheros
//
// Clases: FileInputStream, FileOutputStream
// Métodos: read(), write(), close()

package leyendo_y_escribiendo_bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class V155_Lectura_Escritura {

	static String ruta1 = "Z:/temp/logo corporativo.jpg";
	static String ruta2 = "Z:/temp/logo corporativo_copia.jpg";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int contador = 0;
		int datos_entrada[] = new int[64 * 1024];

		try {

			System.out.println("Inicio lectura fichero original.");

			FileInputStream archivo_lectura = new FileInputStream(ruta1);
			boolean final_arch = false;

			while (!final_arch) {
				int byte_entrada = archivo_lectura.read();
				if (byte_entrada == -1) {
					final_arch = true;
				} else {
					datos_entrada[contador] = byte_entrada;
					contador++;
					System.out.printf("%5d %3d%n", contador, byte_entrada);
				}
			}
			archivo_lectura.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al acceder al fichero origen.");
		}
		System.out.println();
		System.out.println("Contador: " + contador);
		System.out.println();

		crea_fichero(datos_entrada, contador);
	}

	static void crea_fichero(int datos_nuevo_fichero[], int contador) {

		try {

			System.out.println("Inicio grabación nuevo fichero.");

			FileOutputStream fichero_nuevo = new FileOutputStream(ruta2);

			// for (int i = 0; i < datos_nuevo_fichero.length; i++) {
			for (int i = 0; i < contador; i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			fichero_nuevo.close();
			System.out.println("Fin grabación nuevo fichero.");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al crear el nuevo archivo.");
		}

	}
}
