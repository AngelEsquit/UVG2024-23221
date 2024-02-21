import java.util.ArrayList;

public class Auditor implements Usuario {
    private String nombre;
    private String apellido;
    private int id;

    public Auditor(String nombre, String apellido, int id) {
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

    public void exportarResumen(int tipoArchivo, ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos, ArrayList<Docente> docentes) {
        System.out.println("Exportando resumen de notas, asistencia y pagos");
        System.out.println("Tipo de archivo: " + tipoArchivo);
        
        DatasourceFactory.getDataSourceInstance(tipoArchivo).guardarEstudiantes(estudiantes, "test/estudiantes");
        DatasourceFactory.getDataSourceInstance(tipoArchivo).guardarCursos(cursos, "test/cursos");
        DatasourceFactory.getDataSourceInstance(tipoArchivo).guardarNotas(estudiantes, "test/notas");
        DatasourceFactory.getDataSourceInstance(tipoArchivo).guardarPagosE(estudiantes, "test/pagosE");
        DatasourceFactory.getDataSourceInstance(tipoArchivo).guardarPagosD(docentes, "test/pagosD");
    }   

    @Override
    public void mostrarOpciones() {
        System.out.println("Auditor:");
        System.out.println("1. Consultar Notas de Estudiantes");
        System.out.println("2. Consultar Asistencia");
        System.out.println("3. Consultar Pagos");
        System.out.println("4. Exportar Resumen");
    }
}
