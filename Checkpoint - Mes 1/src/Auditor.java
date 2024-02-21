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

    public void revisarNotas(Estudiante estudiante) {
        System.out.println("Notas de " + estudiante.getNombre() + " " + estudiante.getApellido());
        for (Curso curso : estudiante.getCursos()) {
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Nota: " + curso.getNota());
        }
    }

    public void revisarPagosEstudiante(Estudiante estudiante) {
        System.out.println("Pagos de " + estudiante.getNombre() + " " + estudiante.getApellido());
        for (Pago pago : estudiante.getPagos()) {
            System.out.println("Fecha: " + pago.getFecha());
            System.out.println("Monto: " + pago.getMonto());
        }
    }

    public void revisarPagosDocente(Docente docente) {
        System.out.println("Pagos de " + docente.getNombre() + " " + docente.getApellido());
        for (Pago pago : docente.getPagos()) {
            System.out.println("Fecha: " + pago.getFecha());
            System.out.println("Monto: " + pago.getMonto());
        }
    }

    public void exportarResumen(String tipoArchivo) {
        System.out.println("Exportando resumen de notas, asistencia y pagos");
        System.out.println("Tipo de archivo: " + tipoArchivo);
        
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Auditor:");
        System.out.println("Consultar Notas de Estudiantes");
        System.out.println("Consultar Asistencia");
        System.out.println("Consultar Pagos");
    }
}
