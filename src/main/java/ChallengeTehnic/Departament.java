package ChallengeTehnic;

/**
 *
 * @author Bogdan
 */
public class Departament {

    private int idDepartament;
    private String numeDepartament;
    private String numeDirector;

    public Departament(int idDepartament, String numeDepartament, String numeDirector) {
        this.idDepartament = idDepartament;
        this.numeDepartament = numeDepartament;
        this.numeDirector = numeDirector;
    }

    public int getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(int idDepartament) {
        this.idDepartament = idDepartament;
    }

    public String getNumeDepartament() {
        return numeDepartament;
    }

    public void setNumeDepartament(String numeDepartament) {
        this.numeDepartament = numeDepartament;
    }

    public String getNumeDirector() {
        return numeDirector;
    }

    public void setNumeDirector(String numeDirector) {
        this.numeDirector = numeDirector;
    }

}
