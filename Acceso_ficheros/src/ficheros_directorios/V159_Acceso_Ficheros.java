// Referencias:
//
// Vídeo 159 - Acceso a ficheros
// Clase: File
// Métodos:
//  String getAbsolutePath()
//  String getCanonicalPath()
//  boolean exists()
//  boolean isDirectory()

package ficheros_directorios;

import java.io.File;
import java.io.IOException;

public class V159_Acceso_Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathname = ("Z:" + File.separator + "Dropbox" + File.separator + "LMG" + File.separator + "Cursos"
				+ File.separator + "2016 - Java" + File.separator + "_Plantillas");
		File ruta = new File(pathname);

		System.out.println("Ruta absoluta: " + ruta.getAbsolutePath());

		String[] nombres_archivos = ruta.list();

		for (String string : nombres_archivos) {
			System.out.println(string);

			File f = new File(ruta.getAbsolutePath(), string);
			if (f.isDirectory()) {
				String archivos_subcarpeta[] = f.list();
				for (String string2 : archivos_subcarpeta) {
					System.out.println("\\--" + string2);

				}
			}
		}

	}

}
