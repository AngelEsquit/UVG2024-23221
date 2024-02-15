import java.util.ArrayList;

public class Curso {
    private String nombre;
    
    ArrayList<Usuario> estudiantes = new ArrayList<Usuario>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Usuario> estudiantes) {
        this.estudiantes = estudiantes;
    }
}