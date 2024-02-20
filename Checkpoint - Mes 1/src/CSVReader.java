import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    // Variable para saltar la primera fila de encabezados
    boolean primera_fila = true;

    // Variables para almacenar los datos de los jugadores
    int conteo = -1;

    String columna1;
    String columna2;
    String columna3;
    String columna4;
    String columna5;
    String columna6;

    public void ReadCSVEstudiantes(String csvFilePath) {
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

                Estudiante estudiante = new Estudiante(Integer.parseInt(columna1), columna2, columna3); // Crear un nuevo estudiante
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
