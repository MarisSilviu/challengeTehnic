package ChallengeTehnic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Proiect {

    private int idProiect;
    private String numeProiect;
    private String membru;
    private Date dataInceput;
    private Date deadline;

    public Proiect(int idProiect, String numeProiect, String membru, Date dataInceput, Date deadline) {
        this.idProiect = idProiect;
        this.numeProiect = numeProiect;
        this.membru = membru;
        this.dataInceput = dataInceput;
        this.deadline = deadline;
    }

    public int getIdProiect() {
        return idProiect;
    }

    public void setIdProiect(int idProiect) {
        this.idProiect = idProiect;
    }

    public String getNumeProiect() {
        return numeProiect;
    }

    public void setNumeProiect(String numeProiect) {
        this.numeProiect = numeProiect;
    }

    public String getMembru() {
        return membru;
    }

    public void setMembru(String membru) {
        this.membru = membru;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void atribuireProiect(List<Angajat> list, Proiect p) {
        String numeAngajat;
        String numeProiect = p.getNumeProiect();
        Date concediuInceput = new Date();
        Date concediuFinal = new Date();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        for (int i = 0; i < list.size(); i++) {
            Date proiectInceput = p.getDataInceput();
            Date proiectDeadline = p.getDeadline();
            Angajat ang = list.get(i);
            numeAngajat = ang.getNume();
            String query = "SELECT DISTINCT * FROM concediu WHERE nume='" + numeAngajat + "'";
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    concediuInceput = rs.getDate("dataInceput");
                    concediuFinal = rs.getDate("dataFinal");
                }
                if ((concediuFinal.before(proiectInceput) && concediuInceput.before(proiectDeadline)) || concediuInceput.after(proiectDeadline)) {
                    java.sql.Date sqlDate = new java.sql.Date(proiectInceput.getTime());
                    java.sql.Date sqlDate2 = new java.sql.Date(proiectDeadline.getTime());
                    String insertSQL = "INSERT INTO proiect VALUES(NULL,'" + numeProiect + "','" + numeAngajat + "','" + sqlDate + "','" + sqlDate2 + "')";
                    stmt.executeUpdate(insertSQL);
                } else {
                    System.out.println("2) Nu poate fi asignat pe proiect: " + numeAngajat);
                }
            } catch (SQLException e) {
                System.out.println("Conectare esuata la baza de date.");
                e.printStackTrace();
            }
        }

    }

    public void departamentProiect(Proiect p) {
        Connection con = null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        String proiectSQL = "SELECT * FROM proiect";
        con = DBConnection.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(proiectSQL);
            while (rs.next()) {
                String membruProiect = rs.getString("membru");
                String mySQL = "SELECT departament FROM angajat WHERE nume='" + membruProiect + "'";
                stmt2 = con.createStatement();
                rs2 = stmt2.executeQuery(mySQL);
                while (rs2.next()) {
                    System.out.println("4) Departament implicat in proiect: " + rs2.getString("departament"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Conectare esuata la baza de date.");
            e.printStackTrace();
        }
    }
}
