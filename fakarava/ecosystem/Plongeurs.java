package fakarava.ecosystem;

public class Plongeurs {
    /**
     * @attribute
     */
    private String labo;

    /**
     * @attribute
     */
    private Integer id_plongeur;

    /**
     * @attribute
     */
    private String log;

    /**
     * @attribute
     */
    private String nom;

    // Constructeurs:
    public Plongeurs(Integer id_plongeur, String nom, String labo, String log) {
        this.nom = nom;
        this.labo = labo;
        this.id_plongeur = id_plongeur;
        this.log = log;
    }
    public Plongeurs(String name, String labo) {
        this.nom = name;
        this.labo = labo;
    }

    // Méthodes d'instance:
    public void se_presenter() {
        String res = "Plongeur " + this.id_plongeur + " : " + 
            this.nom + " (" + this.labo + ")";
    }

    public void remplir_log() {
        // TODO : Finir la méthode
    }

    public String getLabo() {
        return labo;
    }

    public Integer getId_plongeur() {
        return id_plongeur;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public String getNom() {
        return nom;
    }
    public String toString(){
        return this.nom + " " + this.id_plongeur + " (" + 
            this.labo + ") " + this.log;
    }
}
