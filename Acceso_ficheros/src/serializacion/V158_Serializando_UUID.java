// Referencias:
//
// Vídeo 158 - Utilización de serialVersionUUID para verificar versiones al serializar
//
// Constante private static final serialVersionUUID

package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class V158_Serializando_UUID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		V158_Administrador jefe = new V158_Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);

		V158_Empleado[] personal = new V158_Empleado[3];
		personal[0] = jefe;
		personal[1] = new V158_Empleado("Ana", 25000, 2000, 10, 1);
		personal[2] = new V158_Empleado("Luis", 10000, 2012, 9, 15);

		try {

			String ruta = "Z:/temp/V157_Objeto.dat";

			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(ruta));
			escribiendo_fichero.writeObject(personal);
			escribiendo_fichero.close();

			ObjectInputStream leyendo_fichero = new ObjectInputStream(new FileInputStream(ruta));
			V158_Empleado[] personal_recuperado = (V158_Empleado[]) leyendo_fichero.readObject();
			leyendo_fichero.close();

			for (V158_Empleado emp : personal_recuperado) {
				System.out.println(emp);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class V158_Empleado implements Serializable {

	// Default:
	private static final long serialVersionUID = 1L;

	// Generated:
	// private static final long serialVersionUID = -3057889232490069984L;

	public V158_Empleado(String n, double s, int agno, int mes, int dia) {
		nombre = n;
		sueldo = s;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		fechaContrato = calendario.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void subirSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

	public String toString() {
		return "Nombre=" + nombre + ", sueldo=" + sueldo + ", fecha de contrato=" + fechaContrato;
	}

	private String nombre;
	private double sueldo;
	private Date fechaContrato;
}

// ------------------------------------------------------------

class V158_Administrador extends V158_Empleado {

	// Default:
	private static final long serialVersionUID = 1L;

	// Generated:
	// private static final long serialVersionUID = -3057889232490069984L;

	public V158_Administrador(String n, double s, int agno, int mes, int dia) {
		super(n, s, agno, mes, dia);
		incentivo = 0;
	}

	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}

	public void setIncentivo(double b) {
		incentivo = b;
	}

	public String toString() {
		return super.toString() + ", incentivo=" + incentivo;
	}

	private double incentivo;
}