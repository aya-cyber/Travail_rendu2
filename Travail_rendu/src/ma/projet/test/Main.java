package ma.projet.main;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.service.MariageService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MariageService mariageService = new MariageService();

        // Créer des femmes
        List<Femme> femmes = new ArrayList<>();
        femmes.add(new Femme("SALIMA", "RAMI", "0600000004", "Casablanca", new Date(90, 8, 3), 4)); // 3 Sept 1990
        femmes.add(new Femme("AMAL", "ALI", "0600000005", "Fès", new Date(95, 8, 3), 2)); // 3 Sept 1995
        femmes.add(new Femme("WAFA", "ALAOUI", "0600000006", "Rabat", new Date(0, 10, 4), 3)); // 4 Nov 2000
        femmes.add(new Femme("KARIMA", "ALAMI", "0600000007", "Marrakech", new Date(89, 8, 3), 0)); // 3 Sept 1989
        femmes.add(new Femme("NOUR", "BENSAID", "0600000008", "Agadir", new Date(92, 5, 10), 1)); // 10 Mai 1992
        femmes.add(new Femme("ZAHRA", "LAAOUINI", "0600000009", "Oujda", new Date(94, 11, 12), 2)); // 12 Déc 1994
        femmes.add(new Femme("LEILA", "MOHAMMED", "0600000010", "Tanger", new Date(85, 7, 22), 3)); // 22 Juil 1985
        femmes.add(new Femme("SAMIRA", "HASSAN", "0600000011", "Essaouira", new Date(88, 0, 1), 1)); // 1 Jan 1988
        femmes.add(new Femme("FATIMA", "ZAHRA", "0600000012", "Kenitra", new Date(91, 3, 20), 2)); // 20 Avr 1991
        femmes.add(new Femme("LAILA", "BENALI", "0600000013", "Meknès", new Date(93, 9, 5), 4)); // 5 Oct 1993

        // Créer des hommes
        List<Homme> hommes = new ArrayList<>();
        hommes.add(new Homme("AHMED", "BELLA", "0600000014", "Salé"));
        hommes.add(new Homme("OUSSAMA", "ELGHARBAWI", "0600000015", "Beni Mellal"));
        hommes.add(new Homme("YASSINE", "BENAISSA", "0600000016", "Nador"));
        hommes.add(new Homme("KHALID", "ZOUITNI", "0600000017", "Tiznit"));
        hommes.add(new Homme("MOHAMED", "ZAHOUI", "0600000018", "Ksar el Kebir"));

        // Mariages (exemples)
        List<Mariage> mariages = new ArrayList<>();
        mariages.add(new Mariage(new Date(90, 8, 3), null, 4, hommes.get(0), femmes.get(0))); // Mariage actif
        mariages.add(new Mariage(new Date(89, 8, 3), new Date(90, 8, 3), 0, hommes.get(1), femmes.get(3))); // Mariage échoué
        mariages.add(new Mariage(new Date(0, 10, 4), null, 3, hommes.get(2), femmes.get(2))); // Mariage actif
        mariages.add(new Mariage(new Date(92, 5, 10), new Date(93, 0, 1), 1, hommes.get(3), femmes.get(4))); // Mariage échoué
        mariages.add(new Mariage(new Date(91, 3, 20), null, 2, hommes.get(4), femmes.get(5))); // Mariage actif

        // Afficher les informations
        System.out.println("Nom : SAFI SAID");
        System.out.println("Mariages En Cours :");
        for (Mariage mariage : mariages) {
            if (mariage.getDateFin() == null) {
                System.out.println("Femme : " + mariage.getFemme().getNom() + " " + mariage.getFemme().getPrenom() +
                        " Date Début : " + new SimpleDateFormat("dd/MM/yyyy").format(mariage.getDateDebut()) +
                        " Nbr Enfants : " + mariage.getNbrEnfant());
            }
        }

        System.out.println("Mariages échoués :");
        for (Mariage mariage : mariages) {
            if (mariage.getDateFin() != null) {
                System.out.println("Femme : " + mariage.getFemme().getNom() + " " + mariage.getFemme().getPrenom() +
                        " Date Début : " + new SimpleDateFormat("dd/MM/yyyy").format(mariage.getDateDebut()) +
                        " Date Fin : " + new SimpleDateFormat("dd/MM/yyyy").format(mariage.getDateFin()) +
                        " Nbr Enfants : " + mariage.getNbrEnfant());
            }
        }

        // Autres affichages selon les besoins...
    }
}
