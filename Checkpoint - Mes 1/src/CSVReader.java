import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    int conteo = -1;

    String columna1;
    String columna2;
    String columna3;
    String columna4;
    String columna5;
    String columna6;

    public CSVReader() {
    }

    public ArrayList<Usuario> ReadCSVEstudiantes(String csvFilePath) {
        int conteo = -1;
        boolean primera_fila = true;
        ArrayList<Usuario> estudiantes = new ArrayList<Usuario>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) {
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") || datos.equals("0")) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // Id
                                columna1 = datos;
                                break;
                            case 1: // Nombre
                                columna2 = datos;
                                break;
                            case 2: // Apellido
                                columna3 = datos;
                                break;
                            default:
                                break;
                        }
                    }
                }

                estudiantes.add(new Estudiante(Integer.parseInt(columna1), columna2, columna3)); // Crear un nuevo estudiante
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return estudiantes;
    }

    public ArrayList<String> ReadCSVCursos(String csvFilePath) {
        int conteo = -1;
        ArrayList<String> cursos = new ArrayList<String>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            boolean primera_fila = true; // Add this line to skip the first row
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) {
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") || datos.equals("0")) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // Id
                                columna1 = datos;
                                break;
                            case 1: // Nombre
                                columna2 = datos;
                                break;
                            case 2: // Docente
                                columna3 = datos;
                                break;
                            default:
                                break;
                        }
                    }
                }

                cursos.add(columna2); // Crear un nuevo curso
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return cursos;
    }

    public ArrayList<ArrayList<String>> ReadCSVNotas(String csvFilePath) {
        int conteo = -1;
        ArrayList<ArrayList<String>> notas = new ArrayList<ArrayList<String>>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            boolean primera_fila = true;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) {
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                ArrayList<String> notasTemp = new ArrayList<String>(); // Create a new ArrayList for each row
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") || datos.equals("0")) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // IdEstudiante
                                columna1 = datos;
                                break;
                            case 1: // IdCurso
                                columna2 = datos;
                                break;
                            case 2: // Nota
                                columna3 = datos;
                                break;
                            default:
                                break;
                        }
                    }
                }
                notasTemp.add(columna1);
                notasTemp.add(columna2);
                notasTemp.add(columna3);
                notas.add(notasTemp); // Add the ArrayList to the main ArrayList
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return notas;
    }

    public ArrayList<ArrayList<String>> ReadCSVPagosD(String csvFilePath) {
        int conteo = -1;
        boolean primera_fila = true;
        ArrayList<ArrayList<String>> pagos = new ArrayList<ArrayList<String>>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) {
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                ArrayList<String> pagosTemp = new ArrayList<String>(); // Create a new ArrayList for each row
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") || datos.equals("0")) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // IdDocente
                                columna1 = datos;
                                break;
                            case 1: // Fecha
                                columna2 = datos;
                                break;
                            case 2: // Monto
                                columna3 = datos;
                                break;
                            default:
                                break;
                        }
                    }
                }
                pagosTemp.add(columna1);
                pagosTemp.add(columna2);
                pagosTemp.add(columna3);
                pagos.add(pagosTemp); // Agergar pagos de un estudiante
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return pagos;
    }

    public ArrayList<ArrayList<String>> ReadCSVPagosE(String csvFilePath) {
        int conteo = -1;
        boolean primera_fila = true;
        ArrayList<ArrayList<String>> pagos = new ArrayList<ArrayList<String>>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) {
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                ArrayList<String> pagosTemp = new ArrayList<String>(); // Create a new ArrayList for each row
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") || datos.equals("0")) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // IdEstudiante
                                columna1 = datos;
                                break;
                            case 1: // Fecha
                                columna2 = datos;
                                break;
                            case 2: // Monto
                                columna3 = datos;
                                break;
                            default:
                                break;
                        }
                    }
                }
                pagosTemp.add(columna1);
                pagosTemp.add(columna2);
                pagosTemp.add(columna3);
                pagos.add(pagosTemp); // Agregar pagos de un estudiante
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return pagos;
    }
}
