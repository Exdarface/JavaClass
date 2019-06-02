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
    private static Integer next_id_plongeur = 1;
    /**
     * @attribute
     */
    private String log;

    /**
     * @attribute
     */
    private String nom;

    // Constructeurs:
    public Plongeurs(String name, String labo) {
        this.nom = name;
        this.labo = labo;
        this.id_plongeur = next_id_plongeur;
        next_id_plongeur++;
    }

    // Méthodes d'instance:
    public void se_presenter() {
        String res = "Plongeur " + this.id_plongeur + " : " + 
            this.nom + " (" + this.labo + ")";
            System.out.println(res);
    }

    public void remplir_log() {
        Camera.updateChasseCamera();
        for (Camera c : Camera.getAll_camera()) {
            if(c.getId_plongeur_assos() == this.getId_plongeur()){
                String res = "";
                c.updateCamera();
                res += "Camera" + c.getPos_camera().toString()+":\n"+c.getDescription_poissons()+"\n"+c.getDescription_chasse();
                this.log += res;
            }
        }
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
