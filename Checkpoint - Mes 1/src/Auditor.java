public class Auditor implements Usuario {
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

    @Override
    public void mostrarOpciones() {
        System.out.println("Auditor:");
        System.out.println("Consultar Notas de Estudiantes");
        System.out.println("Consultar Asistencia");
        System.out.println("Consultar Pagos");
    }
}
