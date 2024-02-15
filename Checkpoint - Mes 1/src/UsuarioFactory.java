public class UsuarioFactory {
    public static final int Estudiante = 0;
    public static final int Docente = 1;
    public static final int PersonalAdministrativo = 2;
    public static final int Auditor = 3;

    public static Usuario getUsuarioType(int usuarioType, String nombre, String apellido, int id, String curso){
        switch (usuarioType) {
            case Estudiante:
                return new Estudiante(nombre, apellido, id, curso);    

            case Docente:
                return new Docente();

            case PersonalAdministrativo:
                return new PersonalAdministrativo();

            case Auditor:
                return new Auditor();
        
            default:
                return new Estudiante(nombre, apellido, id, curso);
        }
    }
}
