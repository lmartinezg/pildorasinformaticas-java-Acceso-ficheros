// Referencias:
//
// Vídeo 159 - Ficheros y Directorios
// Clase: File
// Métodos:
//  String getAbsolutePath()
//  String getCanonicalPath()
//  boolean exists()
//  boolean isDirectory()

package ficheros_directorios;

import java.io.File;
import java.io.IOException;

public class V159_Pruebas_rutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathname = "bin";
		File archivo = new File(pathname);

		System.out.println("pathSeparator: " + File.pathSeparator);
		System.out.println("pathSeparatorChar: " + File.pathSeparatorChar);
		System.out.println("separator: " + File.separator);
		System.out.println("separatorChar: " + File.separatorChar);

		System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
		try {
			System.out.println("Ruta canónica: " + archivo.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Es directorio: " + archivo.isDirectory());
		System.out.println("Existe: " + archivo.exists());

	}

}
