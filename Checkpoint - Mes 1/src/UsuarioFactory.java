import java.util.EnumSet;

public class UsuarioFactory {
    public static final int Estudiante = 0;
    public static final int Docente = 1;
    public static final int PersonalAdministrativo = 2;
    public static final int Auditor = 3;

    public static Usuario getUsuarioType(int usuarioType){
        switch (usuarioType) {
            case Estudiante:
                return new Estudiante();    

            case Docente:
                return new XMLDataSource();

            case PersonalAdministrativo:
                return new JSONDataSource();

            case Auditor:
                return new JSONDataSource();
        
            default:
                return new CSVDataSource();
        }
    }
}
