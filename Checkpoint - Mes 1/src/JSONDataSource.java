import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONDataSource implements IDataSource {

    private final ObjectMapper objectMapper;

    public JSONDataSource() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public File guardarCursos(ArrayList<Curso> cursos, String path) {
        try {
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, cursos);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarEstudiantes(ArrayList<Estudiante> estudiantes, String path) {
        try {
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, estudiantes);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarNotas(ArrayList<Estudiante> estudiantes, String path) {
        try {
            // Guardar los detalles de cada curso de cada estudiante
            ArrayList<Nota> notas = new ArrayList<>();
            for (Estudiante estudiante : estudiantes) {
                for (Curso curso : estudiante.getCursos()) {
                    Nota nota = new Nota((int) curso.getNota(), estudiante.getId(), curso.getId());
                    notas.add(nota);
                }
            }
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, notas);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarPagosD(ArrayList<Docente> docentes, String path) {
        try {
            ArrayList<Pago> pagos = new ArrayList<>();
            for (Docente docente : docentes) {
                for (Pago pago : docente.getPagos()) {
                    pagos.add(pago);
                }
            }
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, pagos);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarPagosE(ArrayList<Estudiante> estudiantes, String path) {
        try {
            ArrayList<Pago> pagos = new ArrayList<>();
            for (Estudiante estudiante : estudiantes) {
                for (Pago pago : estudiante.getPagos()) {
                    pagos.add(pago);
                }
            }
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, pagos);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}