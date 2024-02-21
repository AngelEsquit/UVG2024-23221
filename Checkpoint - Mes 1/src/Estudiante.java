import java.util.ArrayList;

public class Estudiante implements Usuario {
    private String nombre;
    private String apellido;
    private int id;
    private ArrayList<Curso> cursos = new ArrayList<Curso>();
    private ArrayList<Pago> pagos = new ArrayList<Pago>();

    public Estudiante(int id, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public void realizarPago(String fecha, int monto) {
        Pago pago = new Pago(fecha, monto);
        pagos.add(pago);
    }

    public void consultarPagos() {
        for (Pago pago : pagos) {
            System.out.println("Fecha: " + pago.getFecha() + " Monto: " + pago.getMonto());
        }
    }

    public void consultarNota(String curso) {
        for (Curso c : cursos) {
            if (c.getNombre().equals(curso)) {
                System.out.println("Nota: " + c.getNota());
            }
        }
    }
    
    @Override
    public void mostrarOpciones() {
        System.out.println("Estudiante:");
        System.out.println("1. Consultar nota de una clase específica");
        System.out.println("2. Realizar Pago");
        System.out.println("3. Consultar Pagos.");
    }
}