package ChallengeTehnic;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.sql.*;

/**
 *
 * @author Bogdan
 */
public class Angajat {

    private int idAngajat;
    private String nume;
    private String functie;
    private java.util.Date dataAngajarii;
    private String departament;
    private String superior;

    public Angajat(int idAngajat, String nume, String functie, java.util.Date dataAngajarii, String departament, String superior) {
        this.idAngajat = idAngajat;
        this.nume = nume;
        this.functie = functie;
        this.dataAngajarii = dataAngajarii;
        this.departament = departament;
        this.superior = superior;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public java.util.Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(java.util.Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int calculAni() {
        java.util.Date currentDate = new java.util.Date();
        int k = 0;
        long diffInMillies = Math.abs(currentDate.getTime() - dataAngajarii.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        while (diff - 365 > 0) {
            k++;
            diff = diff - 365;
        }
        return k;
    }

    public int calculSalariu(Angajat ang) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int salariuBaza = 0;
        String functie = ang.getFunctie();
        String sqlQuery = "SELECT salariuBaza FROM functie WHERE numeFunctie='" + functie + "'";
        int nrAni = ang.calculAni();

        con = DBConnection.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            rs.next();
            salariuBaza = rs.getInt("salariuBaza");

        } catch (SQLException e) {
            System.out.println("Conectare esuata la baza de date.");
        }
        int salariuTotal = (nrAni + 1) * salariuBaza;
        return salariuTotal;
    }

    public void afisareAngajati(Departament dep) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String departamentAles = dep.getNumeDepartament();
        String sqlQuery = "SELECT nume FROM angajat WHERE departament='" + departamentAles + "'";
        con = DBConnection.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                System.out.println("3) Angajat departament " + departamentAles + ": " + rs.getString("nume"));
            }

        } catch (SQLException e) {
            System.out.println("Conectare esuata la baza de date.");
        }
    }

    public void inlocuireAngajat(Angajat a, Angajat b) {
        b.setDepartament(a.getDepartament());
        b.setSuperior(a.getSuperior());

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sqlQuery = "UPDATE proiect SET membru='" + b.getNume() + "' WHERE membru='" + a.getNume() + "'";
        String angajatQuery = "UPDATE angajat SET nume='" + b.getNume() + "', dataAngajarii='" + b.getDataAngajarii() + "' WHERE nume='" + a.getNume() + "'";
        con = DBConnection.getConnection();
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sqlQuery);
            stmt.executeUpdate(angajatQuery);
        } catch (SQLException e) {
            System.out.println("Conectare esuata la baza de date.");
        }
    }

}
