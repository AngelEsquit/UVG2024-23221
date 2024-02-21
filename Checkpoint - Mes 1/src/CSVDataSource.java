import java.io.*;
import java.util.ArrayList;

public class CSVDataSource implements IDataSource {
    
    @Override
    public File guardarEstudiantes(ArrayList<Estudiante> estudiantes, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("id;nombre;apellido\n");

            // Escribir cada estudiante al archivo CSV
            for (Estudiante estudiante : estudiantes) {
                writer.write(String.format("%d;%s;%s\n", estudiante.getId(), estudiante.getNombre(), estudiante.getApellido()));
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
            writer.write("id;nombre;iddocente\n");

            // Escribir cada curso al archivo CSV
            for (Curso curso : cursos) {
                writer.write(String.format("%d;%s;%s\n", curso.getId(), curso.getNombre(), curso.getDocente()));
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarNotas(ArrayList<Estudiante> estudiantes, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("idEstudiante;idCurso;nota\n");

            // Escribir cada estudiante al archivo CSV
            for (Estudiante estudiante : estudiantes) {
                for (Curso curso : estudiante.getCursos()) {
                    writer.write(String.format("%d;%d;%f\n", estudiante.getId(), curso.getId(), curso.getNota()));
                }
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarPagosD(ArrayList<Docente> docentes, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("idDocente;fecha;monto\n");

            // Escribir cada estudiante al archivo CSV
            for (Docente docente : docentes) {
                for (Pago pago : docente.getPagos()) {
                    writer.write(String.format("%d;%s;%f\n", docente.getId(), pago.getFecha(), pago.getMonto()));
                }
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File guardarPagosE(ArrayList<Estudiante> estudiantes, String path) {
        try {
            File file = new File(path+".csv");
            FileWriter writer = new FileWriter(file);

            // Escribir encabezados al archivo CSV
            writer.write("idEstudiante;fecha;monto\n");

            // Escribir cada estudiante al archivo CSV
            for (Estudiante estudiante : estudiantes) {
                for (Pago pago : estudiante.getPagos()) {
                    writer.write(String.format("%d;%s;%f\n", estudiante.getId(), pago.getFecha(), pago.getMonto()));
                }
            }

            writer.close();
            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}