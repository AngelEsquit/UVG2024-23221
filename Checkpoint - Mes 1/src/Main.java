import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();

        ArrayList<Usuario> lecturaEstudiantes = new ArrayList<>();
        lecturaEstudiantes = csvReader.ReadCSVEstudiantes("src/estudiantes.csv");

        ArrayList<String> lecturaCursos = new ArrayList<>();
        lecturaCursos = csvReader.ReadCSVCursos("src/cursos.csv");

        ArrayList<ArrayList<String>> lecturaNotas = new ArrayList<>();
        lecturaNotas = csvReader.ReadCSVNotas("src/notas.csv");

        ArrayList<ArrayList<String>> lecturaPagosD = new ArrayList<>();
        lecturaPagosD = csvReader.ReadCSVPagosD("src/pagosD.csv");

        ArrayList<ArrayList<String>> lecturaPagosE = new ArrayList<>();
        lecturaPagosE = csvReader.ReadCSVPagosE("src/pagosE.csv");

        System.out.println("");

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

        // Crear un usuario de tipo personal administrativo
        PersonalAdministrativo personalAdministrativo = new PersonalAdministrativo("Juan", "Perez", 1234);
        usuarios.add(personalAdministrativo);

        // Crear un usuario de tipo auditor
        Auditor auditor = new Auditor("Pedro", "Gonzalez", 5678);
        usuarios.add(auditor);

        // Crear un usuario de tipo docente
        Docente docente = new Docente(123, "Carlos", "Gomez");
        usuarios.add(docente);

        // Creación de usuarios
        for (Usuario estudiante : lecturaEstudiantes) {
            usuarios.add(estudiante);
        }

        // Creación de cursos
        for (String curso : lecturaCursos) {
            cursos.add(new Curso(curso));
        }

        // Asignación de notas
        for (ArrayList<String> nota : lecturaNotas) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(nota.get(0)) && usuario.getId() == Integer.parseInt(nota.get(1))) {
                    for (Curso curso : ((Estudiante) usuario).getCursos()) {
                        if (curso.getNombre().equals(nota.get(1))) {
                            curso.setNota(Double.parseDouble(nota.get(2)));
                        }
                    }
                }
            }
        }

        // Asignación de pagos de docentes
        for (ArrayList<String> pagoD : lecturaPagosD) {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == Integer.parseInt(pagoD.get(0)) && usuario instanceof Docente) {
                    ((Docente) usuario).realizarPago(pagoD.get(1), Integer.parseInt(pagoD.get(2)));
                }
            }
        }

        // Asignación de pagos de estudiantes
        for (ArrayList<String> pagoE : lecturaPagosE) {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == Integer.parseInt(pagoE.get(0)) && usuario instanceof Estudiante) {
                    ((Estudiante) usuario).realizarPago(pagoE.get(2), Integer.parseInt(pagoE.get(2)));
                }
            }
        }

        // Separar usuarios por tipo
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Docente> docentes = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario instanceof Estudiante) {
                estudiantes.add((Estudiante) usuario);
            } else if (usuario instanceof Docente) {
                docentes.add((Docente) usuario);
            }
        }

        // Lógica de inicio de sesión

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de la universidad");
        System.out.println("");
        System.out.println("Usuarios de prueba: ");
        System.out.println("Estudiante: ");
        System.out.println("Nombre: Juan, ID: 1");
        System.out.println("");
        System.out.println("Docente: ");
        System.out.println("Nombre: Carlos, ID: 123");
        System.out.println("");
        System.out.println("Personal Administrativo: ");
        System.out.println("Nombre: Juan, ID: 1234");
        System.out.println("");
        System.out.println("Auditor: ");
        System.out.println("Nombre: Pedro, ID: 5678");
        System.out.println("");
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println(nombreUsuario);
        System.out.print("Ingrese el ID como contraseña: ");
        int idContraseña = scanner.nextInt();
        System.out.println(idContraseña);
        scanner.nextLine();

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
                                    cursos.add(((PersonalAdministrativo) tUsuario).crearCurso(nombre));
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
                                                curso.setDocente(usuario.getId());
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
                            System.out.println("Seleccione el tipo de archivo al que desea exportar el resumen: ");
                            System.out.println("1. CSV");
                            System.out.println("2. JSON");
                            System.out.println("3. XML");
                            int tipoArchivo = scanner.nextInt();
                            scanner.nextLine();
                            switch (tipoArchivo) {
                                case 1:
                                    ((Auditor) tUsuario).exportarResumen(1, estudiantes, cursos, docentes);
                                    break;
                                case 2:
                                    ((Auditor) tUsuario).exportarResumen(2, estudiantes, cursos, docentes);
                                    break;
                                case 3:
                                    ((Auditor) tUsuario).exportarResumen(3, estudiantes, cursos, docentes);
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            }
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