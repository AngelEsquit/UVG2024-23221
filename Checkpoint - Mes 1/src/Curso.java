import java.util.Random;

public class Curso {
    private int id;
    private String nombre;
    private double nota;
    private int idDocente;
    private Random random = new Random();

    public Curso(String nombre) {
        this.nombre = nombre;
        this.id = random.nextInt(0, 40);
        this.idDocente = random.nextInt(0, 40);
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getDocente() {
        return idDocente;
    }

    public void setDocente(int docente) {
        this.idDocente = docente;
    }
}