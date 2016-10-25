// Referencias:
//
// Vídeo 159 - Acceso a ficheros
// Clase: File
// Métodos:
//  mkdir()
//  createNewFile()

package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class V159_Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String basePath, pathName;
		File ruta;

		basePath = ("Z:" + File.separator + "Dropbox" + File.separator + "LMG" + File.separator + "Cursos"
				+ File.separator + "2016 - Java" + File.separator + "_Plantillas");

		pathName = basePath + File.separator + "test_dir";
		ruta = new File(pathName);
		System.out.println("Creando directorio: " + ruta.getAbsolutePath());
		ruta.mkdir();

		pathName = basePath + File.separator + "test_file.txt";
		System.out.println("pathName: " + pathName);
		ruta = new File(pathName);

		String archivo_destino = ruta.getAbsolutePath();
		System.out.println("archivo_destino: " + archivo_destino);

		try {
			System.out.println("Creando archivo: " + ruta.getAbsolutePath());
			ruta.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir(archivo_destino);

	}

}

class Escribiendo {

	void escribir(String ruta_archivo) {

		String frase = "Esto es un ejemplo.";

		try {
			FileWriter escritura = new FileWriter(ruta_archivo);

			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
