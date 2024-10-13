package ma.projet.beans;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Femme extends Personne {
    private int nbrEnfant;

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance, int nbrEnfant) {
        super(nom, prenom, telephone, adresse, dateNaissance);
        this.nbrEnfant = nbrEnfant;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }
}
