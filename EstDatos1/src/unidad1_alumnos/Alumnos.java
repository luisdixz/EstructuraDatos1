package unidad1_alumnos;

public class Alumnos implements Comparable {
	
	private String numControl;
	private String nombre;
	private String direccion;
	
	public String getNumControl() {
		return numControl;
	}
	public void setNumControl(String numControl) {
		this.numControl = numControl;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Número de control: "+ this.numControl + "\nNombre del alumno: "+ this.nombre + "\nDirección del alumno: " + this.direccion;
	}
	
	@Override
	public int compareTo(Object ob) {
		// TODO Auto compareTo-generated method stub
		Alumnos alo = (Alumnos) ob;
		return this.getNumControl().compareTo(alo.getNumControl());
	}
}
