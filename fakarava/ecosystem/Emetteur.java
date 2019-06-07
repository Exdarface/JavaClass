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
    private static ArrayList<Emetteur> all_emetteur = new ArrayList<Emetteur>();

    // Constructeurs :
    public Emetteur(Predateurs pr,Integer id_plongeur) {
        this.id_emetteur = next_id_emetteur;
        this.preda_assos = pr;
        this.description_predateur = this.preda_assos.toString();
        this.id_plongeur_assos = id_plongeur;
        next_id_emetteur++;
    }
    
    // Methodes d'instances : 
    
    /**
     *Renvoies les informations de l'Emetteur
     * @return les informations de l'Emetteur
     */
    @Override
    public String toString(){
        return "Emetteur : "+this.id_emetteur+","+this.id_plongeur_assos+","+this.description_predateur;
    }

    /**
     * Renvoies l'id du Plongeur associe à l'Emetteur
     * @return l'id du Plongeur associe à l'Emetteur
     */
    public Integer getId_plongeur_assos() {
        return id_plongeur_assos;
    }

    /**
     * Transforme l'id du Plongeur associe à l'Emetteur
     * @param id_plongeur_assos le nouvel id du Plongeur associe à l'Emetteur
     */
    public void setId_plongeur_assos(Integer id_plongeur_assos) {
        this.id_plongeur_assos = id_plongeur_assos;
    }
    
    /**
     * Renvoies l'id de l'Emetteur
     * @return l'id de l'Emetteur
     */
    public Integer getId_emetteur() {
        return id_emetteur;
    }

    /**
     * Transforme la description du Predateurs associe a l'Emetteur pointee
     * @param description_predateur la nouvelle description de l'Emetteur pointee
     */
    public void setDescription_predateur(String description_predateur) {
        this.description_predateur = description_predateur;
    }

    /**
     * Renvoies la description du Predateur associee à l'Emetteur
     * @return la description du Predateur associee à l'Emetteur
     */
    public String getDescription_predateur() {
        return description_predateur;
    }

    /**
     * Transforme le Predateurs associe a l'Emetteur
     * @param pr le nouveau Predateurs associe a l'Emetteur
     */
    public void setPreda_assos(Predateurs pr){
        this.preda_assos = pr;
    }

    /**
     * Recupere le Predateurs associe a l'Emetteur
     * @return le Predateurs associe a l'Emetteur
     */
    public Predateurs getPreda_assos(){
        return this.preda_assos;
    }

    //Methodes de classe :
    
    /**
     * Mets a jour tout les Emetteurs
     */
    public static void updateEmetteur(){
        for(Emetteur e : Emetteur.getAll_emetteur()){
            e.setDescription_predateur(e.preda_assos.toString());
        }
    }
    
    /**
     * Recupere la liste des Emetteurs
     * @return la liste des Emetteurs
     */ 
    public static ArrayList<Emetteur> getAll_emetteur(){
        return Emetteur.all_emetteur;
    }
}
