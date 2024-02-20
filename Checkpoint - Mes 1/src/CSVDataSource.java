import java.io.*;
import java.util.ArrayList;

public class CSVDataSource implements IDataSource {
    
    @Override
    public File guardarEstudiantes(ArrayList<Estudiante> estudiantes, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("ID,First Name,Last Name\n");

            // Escribir cada estudiante al archivo CSV
            for (Estudiante estudiante : estudiantes) {
                writer.write(String.format("%d,%s,%s\n", estudiante.getId(), estudiante.getNombre(), estudiante.getApellido()));
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarCursos(ArrayList<Curso> cursos, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("ID,First Name,Last Name\n");

            // Escribir cada curso al archivo CSV
            for (Curso curso : cursos) {
                writer.write(String.format("%d,%s,%s\n", curso.getNombre(), curso.getNota(), estudiante.getApellido()));
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarNotas(ArrayList<Nota> notas, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("ID,First Name,Last Name\n");

            // Escribir cada estudiante al archivo CSV
            for (Nota nota : notas) {
                writer.write(String.format("%d,%s,%s\n", estudiante.getId(), estudiante.getNombre(), estudiante.getApellido()));
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarPagos(ArrayList<Pago> pagos, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("ID,First Name,Last Name\n");

            // Escribir cada estudiante al archivo CSV
            for (Estudiante estudiante : estudiantes) {
                writer.write(String.format("%d,%s,%s\n", estudiante.getId(), estudiante.getNombre(), estudiante.getApellido()));
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}