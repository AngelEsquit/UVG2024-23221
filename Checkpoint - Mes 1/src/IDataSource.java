import java.io.File;
import java.util.ArrayList;

public interface IDataSource {
    public File guardarEstudiantes(ArrayList<Estudiante> estudiantes, String path);
    public File guardarCursos(ArrayList<Curso> cursos, String path);
    public File guardarNotas(ArrayList<Estudiante> notas, String path);
    public File guardarPagosD(ArrayList<Docente> pagos, String path);
    public File guardarPagosE(ArrayList<Estudiante> pagos, String path);
}