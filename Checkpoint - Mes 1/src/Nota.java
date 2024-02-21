public class Nota {
    private double nota;
    private int idEstudiante;
    private int idCurso;

    public Nota(int nota, int idEstudiante, int idCurso) {
        this.nota = nota;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
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

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
