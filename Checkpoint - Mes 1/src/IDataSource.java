import java.io.File;
import java.util.ArrayList;

public interface IDataSource {
    public File guardarEstudiantes(ArrayList<Estudiante> estudiantes, String path);
    public File guardarCursos(ArrayList<Curso> cursos, String path);
    public File guardarNotas(ArrayList<Nota> notas, String path);
    public File guardarPagosD(ArrayList<Pago> pagos, String path);
    public File guardarPagosE(ArrayList<Pago> pagos, String path);
}