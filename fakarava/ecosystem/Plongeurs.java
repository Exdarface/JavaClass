package fakarava.ecosystem;

import java.util.ArrayList;


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
    
    /**
     * @attribute
     */
    private Integer nb_action = 1;
    
    /**
     *@attribute
     */
    private static ArrayList<Plongeurs> list_plong = new ArrayList<Plongeurs>();
    
    /**
     * @attribute
     */
    private ArrayList<String> toDoList;
    
    // Constructeurs:
    public Plongeurs(String name, String labo) {
        this.nom = name;
        this.labo = labo;
        this.id_plongeur = next_id_plongeur;
        next_id_plongeur++;
        this.toDoList = new ArrayList<String>();
        Plongeurs.list_plong.add(this);
    }

    // Methodes d'instance:
    /**
     * Transforme le nombre d'action du Plongeur
     * @param nb_action nouveau nombre d'action
     */
    public void setNb_action(Integer nb_action) {
        this.nb_action = nb_action;
    }

    /**
     * Recupere le nombre d'action du Plongeur
     * @return le nombre d'action du Plongeur
     */
    public Integer getNb_action() {
        return nb_action;
    }

    /**
     * Renvoies la TODO_Liste du Plongeurs pointé
     * @return la TODO_Liste du Plongeurs pointé
     */
    public ArrayList<String> getToDoList() {
        return toDoList;
    }

    /**
     * Renvoie la liste des Plongeurs present dans la Lagune
     * @return la liste des Plongeurs present dans la Lagune
     */
    public static ArrayList<Plongeurs> getList_plong() {
        return list_plong;
    }

    /**
     * Presente le Plongeurs pointe
     */
    public void se_presenter() {
        String res = "Plongeur " + this.id_plongeur + " : " + 
            this.nom + " (" + this.labo + ")";
            System.out.println(res);
    }
    
    /**
     * Remplis les logs du Plongeurs pointe
     */
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

    /**
     * Renvoies le labo du Plongeurs pointe
     * @return le labo du Plongeurs pointe
     */
    public String getLabo() {
        return labo;
    }

    /**
     * Renvoies l'id du Plongeurs pointe
     * @return l'id du Plongeurs pointe
     */
    public Integer getId_plongeur() {
        return id_plongeur;
    }

    /**
     * Mets a jour les logs du Plongeurs pointe
     * @param log les nouveaux logs du Plongeurs pointe
     */
    public void setLog(String log) {
        this.log = log;
    }

    /**
     * Renvoies les logs du Plongeurs pointe
     * @return les logs du Plongeurs pointe
     */ 
    public String getLog() {
        return log;
    }

    /**
     * Renvoies le nom du Plongeurs pointe
     * @return le nom du Plongeurs pointe
     */
    public String getNom() {
        return nom;
    }
    
    /**
     *Renvoies les informations du Plongeurs pointe
     * @return les informations du Plongeurs pointe
     */
    public String toString(){
        return this.nom + " " + this.id_plongeur + " (" + 
            this.labo + ") " + this.log;
    }
}
