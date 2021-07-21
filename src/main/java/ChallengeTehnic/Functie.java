package ChallengeTehnic;

/**
 *
 * @author Bogdan
 */
public class Functie {

    private int idFunctie;
    private String numeFunctie;
    private int salariuBaza;

    public Functie(int idFunctie, String numeFunctie, int salariuBaza) {
        this.idFunctie = idFunctie;
        this.numeFunctie = numeFunctie;
        this.salariuBaza = salariuBaza;
    }

    public int getIdFunctie() {
        return idFunctie;
    }

    public void setIdFunctie(int idFunctie) {
        this.idFunctie = idFunctie;
    }

    public String getNumeFunctie() {
        return numeFunctie;
    }

    public void setNumeFunctie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }

    public int getSalariuBaza() {
        return salariuBaza;
    }

    public void setSalariuBaza(int salariuBaza) {
        this.salariuBaza = salariuBaza;
    }

}
