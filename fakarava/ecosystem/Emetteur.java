package fakarava.ecosystem;

import java.util.ArrayList;

public class Emetteur {
    /**
     * @attribute
     */
    private Integer id_emetteur;

    /**
     * @attribute
     */
    protected static Integer next_id_emetteur = 1;

    /**
     * @attribute
     */
    private String description_predateur;

    /**
     * @attribute
     */
    private Predateurs preda_assos;

    /**
     * @attribute
     */
    private Integer id_plongeur_assos;

    /**
     * @attribute
     */
    private static ArrayList<Emetteur> all_emetteur;

    //Constructeurs :
    public Emetteur(Predateurs pr,Integer id_plongeur) {
        this.id_emetteur = next_id_emetteur;
        this.preda_assos = pr;
        this.description_predateur = this.preda_assos.toString();
        this.id_plongeur_assos = id_plongeur;
        next_id_emetteur++;
    }

    // Méthodes d'Instances : 

    /**
     * Mets à jour l'emetteur pointé
     */
    public void updateEmetteur(){
        this.setDescription_predateur(this.preda_assos.toString());
    }

    /**
     * Renvoies l'id du Plongeur associé à l'Emetteur
     * @return l'id du Plongeur associé à l'Emetteur
     */
    public Integer getId_plongeur_assos() {
        return id_plongeur_assos;
    }

    /**
     * Renvoies l'id de L'Emetteur
     * @return l'id de L'Emetteur
     */
    public Integer getId_emetteur() {
        return id_emetteur;
    }

    /**
     * Change la description du Predateurs associé à l'Emetteur
     * @param description_predateur la nouvelle description du Predateurs associé à l'Emetteur
     */
    public void setDescription_predateur(String description_predateur) {
        this.description_predateur = description_predateur;
    }

    /**
     * Renvoies la description du Predateurs associé à l'Emetteur
     * @return la description du Predateurs associé à l'Emetteur
     */
    public String getDescription_predateur() {
        return description_predateur;
    }

    /**
     * Renvoies l'id du Predateurs associé à l'Emetteur
     * @return l'id du Predateurs associé à l'Emetteur
     */
    public Predateurs getPreda_assos(){
        return this.preda_assos;
    }

    /**
     * Donne toutes les informations de l'Emetteur pointé
     */
    @Override
    public String toString(){
        return "Emetteur : "+this.id_emetteur+","+this.id_plongeur_assos+","+this.description_predateur;
    }

    //Méthodes de classe :

    /**
     * Renvoies la liste de tous les Emetteur
     * @return la liste de tous les Emetteur
     */
    public static ArrayList<Emetteur> getAll_emetteur(){
        return Emetteur.all_emetteur;
    } 
}
