public class PersonalAdministrativo implements Usuario {
    private String nombre;
    private String apellido;
    private int id;

    public PersonalAdministrativo(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante crearEstudiante(int id, String nombre, String apellido) {
        return new Estudiante(id, nombre, apellido);
    }

    public Docente crearDocente(int id, String nombre, String apellido) {
        return new Docente(id, nombre, apellido);
    }

    public Curso crearCurso(String nombre) {
        return new Curso(nombre);
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("1. Personal Administrativo:");
        System.out.println("2. Ingresar Notas");
        System.out.println("3. Consultar Asistencia");
        System.out.println("4. Consultar Pagos");
    }
}
