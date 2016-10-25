// Referencias:
//
// Vídeo 159 - Acceso a ficheros
// Clase: File
// Métodos:
//  delete()

package ficheros_directorios;

import java.io.File;

public class V159_Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String basePath, pathName;
		File ruta;

		basePath = ("Z:" + File.separator + "Dropbox" + File.separator + "LMG" + File.separator + "Cursos"
				+ File.separator + "2016 - Java" + File.separator + "_Plantillas");

		pathName = basePath + File.separator + "test_file.txt";
		System.out.println("pathName: " + pathName);
		ruta = new File(pathName);

		System.out.println("(Antes) - Existe: " + ruta.exists());
		ruta.delete();
		System.out.println("(Después) - Existe: " + ruta.exists());

	}

}
