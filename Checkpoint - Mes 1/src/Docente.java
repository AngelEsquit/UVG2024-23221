import java.util.ArrayList;

public class Docente implements Usuario {
    private String nombre;
    private String apellido;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Docente(String nombre, String apellido, int id) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.id = id;
    }

    public void ingresarNota(ArrayList<Usuario> usuarios, Estudiante estudiante, String curso, double nota) {
        boolean encontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Estudiante) {
                if (usuario.getNombre() == estudiante.getNombre() && usuario.getId() == estudiante.getId()) {
                    for (Curso cursoEstudiante : ((Estudiante) usuario).getCursos()) {
                        if (cursoEstudiante.getNombre().equals(curso)) {
                            cursoEstudiante.setNota(nota);
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
        }

        if (encontrado) {
            System.out.println("Nota ingresada correctamente");
        } else {
            System.out.println("No se encontró el estudiante o el curso");
        }
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Docente:");
        System.out.println("Consultar Notas de Estudiantes");
        System.out.println("Ingresar Notas");
        System.out.println("Consultar Asistencia");
    }
}
