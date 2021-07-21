package ChallengeTehnic;

import java.util.Date;

/**
 *
 * @author Bogdan
 */
public class Concediu {

    private int idConcediu;
    private String nume;
    private Date dataInceput;
    private Date dataFinal;

    public Concediu(int idConcediu, String nume, Date dataInceput, Date dataFinal) {
        this.idConcediu = idConcediu;
        this.nume = nume;
        this.dataInceput = dataInceput;
        this.dataFinal = dataFinal;
    }

    public int getIdConcediu() {
        return idConcediu;
    }

    public void setIdConcediu(int idConcediu) {
        this.idConcediu = idConcediu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

}
