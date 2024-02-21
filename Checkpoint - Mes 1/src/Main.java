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

Auditor:

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
        ArrayList<Curso> cursos = new ArrayList<>();
        int tipoUsuario = 0;
        boolean encontrado = false;
        Usuario tUsuario = null;
        int cursoNum = 1;
        int opcion = 0;

        String nombre;
        String apellido;
        int id;

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
                    tipoUsuario = 1;
                    encontrado = true;
                } else if (usuario instanceof Docente) {
                    tipoUsuario = 2;
                    encontrado = true;
                } else if (usuario instanceof PersonalAdministrativo) {
                    tipoUsuario = 3;
                    encontrado = true;
                } else if (usuario instanceof Auditor) {
                    tipoUsuario = 4;
                    encontrado = true;
                }

                tUsuario = usuario;
                break;
            }
        }

        if (encontrado) {
            switch (tipoUsuario) {
                case 1:
                    // Estudiante login logic
                    tUsuario.mostrarOpciones();
                    System.out.println("Ingrese la opción que desea realizar: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion) {
                        case 1:
                            for (Curso curso : ((Estudiante) tUsuario).getCursos()) {
                                System.out.println(cursoNum + curso.getNombre());
                                cursoNum += 1;
                            }

                            System.out.println("Ingrese el curso que desee consultar: ");
                            opcion = scanner.nextInt();
            
                            ((Estudiante) tUsuario).consultarNota(((Estudiante) tUsuario).getCursos().get(opcion - 1).getNombre());
                            break;
                        case 2:
                            System.out.println("Ingrese la fecha del pago: ");
                            String fecha = scanner.nextLine();
                            System.out.println("Ingrese el monto del pago: ");
                            int monto = scanner.nextInt();
                            ((Estudiante) tUsuario).realizarPago(fecha, monto);
                            break;
                        case 3:
                            ((Estudiante) tUsuario).consultarPagos();
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                case 2:
                    // Docente login logic
                    tUsuario.mostrarOpciones();
                    System.out.println("Ingrese la opción que desea realizar: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nombre del estudiante: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el nombre del curso: ");
                            String curso = scanner.nextLine();
                            System.out.println("Ingrese la nota del estudiante: ");
                            int nota = scanner.nextInt();
                            ((Docente) tUsuario).ingresarNota(usuarios, (Estudiante)tUsuario, curso, nota);
                            break;
                        case 2:
                            System.out.println("Ingrese la fecha del pago: ");
                            String fecha = scanner.nextLine();
                            System.out.println("Ingrese el monto del pago: ");
                            int monto = scanner.nextInt();
                            scanner.nextLine();
                            ((Docente) tUsuario).realizarPago(fecha, monto);
                            System.out.println("Cobro realizado correctamente");
                            break;
                        case 3:
                            ((Docente) tUsuario).historialPagos();
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                case 3:
                    // Personal Administrativo login logic
                    tUsuario.mostrarOpciones();
                    System.out.println("Ingrese la opción que desea realizar: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el tipo de lo que desea crear: ");
                            System.out.println("1. Estudiante");
                            System.out.println("2. Docente");
                            System.out.println("3. Curso");

                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    System.out.println("Ingrese el nombre del estudiante: ");
                                    nombre = scanner.nextLine();
                                    System.out.println("Ingrese el apellido del estudiante: ");
                                    apellido = scanner.nextLine();
                                    System.out.println("Ingrese el ID del estudiante: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    usuarios.add(((PersonalAdministrativo) tUsuario).crearEstudiante(id, nombre, apellido));
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nombre del docente: ");
                                    nombre = scanner.nextLine();
                                    System.out.println("Ingrese el apellido del docente: ");
                                    apellido = scanner.nextLine();
                                    System.out.println("Ingrese el ID del docente: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    usuarios.add(((PersonalAdministrativo) tUsuario).crearDocente(id, nombre, apellido));
                                    break;
                                case 3:
                                    System.out.println("Ingrese el nombre del curso: ");
                                    nombre = scanner.nextLine();
                                    System.out.println("Ingrese el ID del curso: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    cursos.add(((PersonalAdministrativo) tUsuario).crearCurso(id, nombre));
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            }
                            tipo = 0;
                            break;
                        case 2:
                            //Asignar estudiante a curso
                            System.out.println("Ingrese el nombre del estudiante: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el ID del estudiante: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Estudiante) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        System.out.println("Ingrese el nombre del curso: ");
                                        nombre = scanner.nextLine();
                                        for (Curso curso : cursos) {
                                            if (curso.getNombre().equals(nombre)) {
                                                ((Estudiante) usuario).getCursos().add(curso);
                                                System.out.println("Estudiante asignado correctamente");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 3:
                            //Asignar catedrático a curso
                            System.out.println("Ingrese el nombre del docente: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el ID del docente: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Docente) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        System.out.println("Ingrese el nombre del curso: ");
                                        nombre = scanner.nextLine();
                                        for (Curso curso : cursos) {
                                            if (curso.getNombre().equals(nombre)) {
                                                curso.setDocente((Docente) usuario);
                                                System.out.println("Docente asignado correctamente");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 4:
                            //Asignar pago a catedrático
                            System.out.println("Ingrese el nombre del docente: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el ID del docente: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Docente) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        System.out.println("Ingrese la fecha del pago: ");
                                        String fecha = scanner.nextLine();
                                        System.out.println("Ingrese el monto del pago: ");
                                        int monto = scanner.nextInt();
                                        scanner.nextLine();
                                        ((Docente) usuario).realizarPago(fecha, monto);
                                        System.out.println("Cobro realizado correctamente");
                                        break;
                                    }
                                }
                            }
                            break;
                        case 5:
                            //Resumen de Notas y Resumen de Pagos de Estudiantes
                            System.out.println("Resumen de Notas");
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Estudiante) {
                                    System.out.println("Nombre: " + usuario.getNombre());
                                    for (Curso curso : ((Estudiante) usuario).getCursos()) {
                                        System.out.println("Curso: " + curso.getNombre() + " Nota: " + curso.getNota());
                                    }
                                }
                            }

                            System.out.println("Resumen de Pagos de Estudiantes");
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Estudiante) {
                                    System.out.println("Nombre: " + usuario.getNombre());
                                    ((Estudiante) usuario).consultarPagos();
                                }
                            }
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                case 4:
                    // Auditor Externo login logic
                    tUsuario.mostrarOpciones();
                    System.out.println("Ingrese la opción que desea realizar: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            encontrado = false;
                            System.out.println("Ingrese el nombre del estudiante: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Estudiante) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        ((Auditor) tUsuario).revisarNotas((Estudiante) usuario);
                                        encontrado = true;
                                        break;
                                    }
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Estudiante no encontrado");
                            }
                            break;
                        case 2:
                            encontrado = false;
                            System.out.println("Ingrese el nombre del estudiante: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Estudiante) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        ((Auditor) tUsuario).revisarPagosEstudiante((Estudiante) usuario);
                                        encontrado = true;
                                        break;
                                    }
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Estudiante no encontrado");
                            }
                            break;
                        case 3:
                            encontrado = false;
                            System.out.println("Ingrese el nombre del docente: ");
                            nombre = scanner.nextLine();
                            System.out.println("Ingrese el id del docente: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            for (Usuario usuario : usuarios) {
                                if (usuario instanceof Docente) {
                                    if (usuario.getNombre().equals(nombre) && usuario.getId() == id) {
                                        ((Auditor) tUsuario).revisarPagosDocente((Docente) usuario);
                                        break;
                                    }
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Estudiante no encontrado");
                            }
                            break;
                        case 4:
                            
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } else {
            System.out.println("Usuario no encontrado");
        }

        tipoUsuario = 0;
        encontrado = false;
        tUsuario = null;
        cursoNum = 1;
        opcion = 0;
    }
}