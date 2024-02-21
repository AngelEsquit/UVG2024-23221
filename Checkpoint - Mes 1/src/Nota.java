public class Nota {
    private double nota;
    private int idEstudiante;
    private String nombreCurso;

    public Nota(int nota, int idEstudiante,String nombreCurso) {
        this.nota = nota;
        this.idEstudiante = idEstudiante;
        this.nombreCurso = nombreCurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
