public class Estudiante implements Usuario {
    private String nombre;
    private String apellido;
    private int id;
    private String curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Estudiante(String nombre, String apellido, int id, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    
    @Override
    public void mostrarOpciones() {
        System.out.println("Estudiante:");
        System.out.println("Consultar nota de una clase específica");
        System.out.println("Realizar Pago");
        System.out.println("Consultar Pagos.");
    }
}