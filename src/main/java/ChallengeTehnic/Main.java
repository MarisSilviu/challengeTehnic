package ChallengeTehnic;

import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Main {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM angajat";
            ResultSet rs = st.executeQuery(query);
            List<Angajat> listaAngajati = new ArrayList<Angajat>();

            while (rs.next()) {
                Angajat angajat = new Angajat(rs.getInt("idAngajat"), rs.getString("nume"), rs.getString("functie"), rs.getDate("dataAngajarii"), rs.getString("departament"), rs.getString("superior"));
                listaAngajati.add(angajat);

                // TASK 1: Calculam salariul primind un angajat ca si parametru - in cazul nostru afisam salariile tututor angajatilor
                System.out.println("1) Salariu: " + angajat.calculSalariu(angajat));

            }

            // TASK 2: Asignarea tuturor angajatilor disponibili pe proiectul 'Challenge tehnic'. Cei indisponibili sunt printati in consola
            String query2 = "SELECT * FROM proiect WHERE numeProiect='Challenge tehnic'";
            ResultSet rs2 = st.executeQuery(query2);
            rs2.next();
            Proiect proiect = new Proiect(rs2.getInt("idProiect"), rs2.getString("numeProiect"), rs2.getString("membru"), rs2.getDate("dataInceput"), rs2.getDate("deadline"));
            proiect.atribuireProiect(listaAngajati, proiect);

            // TASK 3: Afisam toti angajatii unui departament primit ca si parametru - in cazul nostru departamentul Software
            Departament dep = new Departament(3, "Software", "Magda Oprea");
            listaAngajati.get(0).afisareAngajati(dep);

            // TASK 4: Afisarea tuturor departamentelor ce participa la proiectul 'Challenge tehnic'
            proiect.departamentProiect(proiect);

            // TASK 5: Interschimbarea primului angajat cu un nou angajat numit 'Marcel Inlocuitor'
            Date today = new Date(System.currentTimeMillis());
            Angajat schimbat = listaAngajati.get(0);
            Angajat inlocuitor = new Angajat(15, "Marcel Inlocuitor", "Rezerva", today, "Financiar", "Bogdan");
            schimbat.inlocuireAngajat(schimbat, inlocuitor);

        } catch (SQLException e) {
            System.out.println("Conectare esuata la baza de date.");
        }
    }
}
