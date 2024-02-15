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
Cree las estructuras y los algoritmos necesarios, sabiendo que los resumenes se pueden exportar en cualquier formato, utilice la clase "Factory" en donde lo considere adecuado, está de más decirlo pero toda esta información se debe guardar en archivos, seleccione el formato que considere adecuado.*/

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Factory
        Factory factory = new Factory();

        // Crear un objeto de tipo Estudiante
        Usuario estudiante = factory.getUsuario("Estudiante");

        // Llamar al método de la clase Estudiante
        estudiante.mostrarOpciones();

        // Crear un objeto de tipo Docente
        Usuario docente = factory.getUsuario("Docente");

        // Llamar al método de la clase Docente
        docente.mostrarOpciones();

        // Crear un objeto de tipo PersonalAdministrativo
        Usuario personalAdministrativo = factory.getUsuario("PersonalAdministrativo");

        // Llamar al método de la clase PersonalAdministrativo
        personalAdministrativo.mostrarOpciones();

        // Crear un objeto de tipo AuditorExterno
        Usuario auditorExterno = factory.getUsuario("AuditorExterno");

        // Llamar al método de la clase AuditorExterno
        auditorExterno.mostrarOpciones();
    }
}