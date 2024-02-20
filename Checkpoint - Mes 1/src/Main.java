import java.util.ArrayList;
import java.util.Scanner;

/* Utilizando el patron de diseño "Factory" cree un programa que permita el acceso el sistema universitario para Estudiantes, Docentes, Personal Administrativo y Auditoría Externa.

Al ingresar a través del mismo "Login" se les mostrará diferentes opciones:

Estudiante:

Consultar nota de una clase específica
Realizar Pago
Consultar Pagos.

Docente:

Ingresar notas de los estudiantes en una clase en específico (La clase debe estar creada y los estudiantes asignados, el catedrático debe tener rol de catedrático).
Cobrar Pago.
Historial de Pagos

Personal Administrativo:

Crear Cursos, Docentes y Estudiantes
Asignar estudiante a curso
Asignar catedrático a curso
Asignar pago a catedrático
Resumen de Notas y Resumen de Pagos de Estudiantes.

Auditor Externo:

Revisará notas
Revisara coutas pagadas de estudiantes
Revisará Pagos a docentes
Cree las estructuras y los algoritmos necesarios, sabiendo que los resumenes se pueden exportar en cualquier formato, utilice la clase "Factory" en donde lo considere adecuado, está de más decirlo pero toda esta información se debe guardar en archivos, seleccione el formato que considere adecuado.
un resumen de la estructura de los archivos CSV que necesitas para tu programa en Java:

Estudiantes:

ID del estudiante (int)
Nombre (String)
Apellido (String)


Cursos:

ID del curso (int)
Nombre del curso (String)
Nota (int)


Notas:

ID del estudiante (int)
Nombre del curso (String)
Nota (double)


Pagos:

ID del estudiante (int)
Monto pagado (double)
Fecha de pago (String)*/

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese el ID como contraseña: ");
        int idContraseña = scanner.nextInt();

        // Lógica de inicio de sesión

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idContraseña && usuario.getNombre().equals(nombreUsuario)) {
                System.out.println("Bienvenido " + usuario.getNombre());
                if (usuario instanceof Estudiante) {
                    usuario.mostrarOpciones();
                } else if (usuario instanceof Docente) {
                    usuario.mostrarOpciones();
                } else if (usuario instanceof PersonalAdministrativo) {
                    usuario.mostrarOpciones();
                } else if (usuario instanceof AuditorExterno) {
                    usuario.mostrarOpciones();
                }
            }
        }

        int option = scanner.nextInt();
        
        switch (option) {
            case 1:
                // Estudiante login logic
                break;
            case 2:
                // Docente login logic
                break;
            case 3:
                // Personal Administrativo login logic
                break;
            case 4:
                // Auditor Externo login logic
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
}