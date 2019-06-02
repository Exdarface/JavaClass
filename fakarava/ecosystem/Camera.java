package fakarava.ecosystem;

import java.util.ArrayList;

public class Camera {
    /**
     * @attribute
     */
    private ArrayList<String> description_poissons;

    /**
     * @attribute
     */
    private Point pos_camera;

    /**
     * @attribute
     */
    private int id_camera;

    /**
     * @attribute
     */
    private static int next_id_camera=1;
    /**
     * @attribute
     */
    private ArrayList<String> description_chasse;

    /**
     * @attribute
     */
    private static ArrayList<Camera> all_camera;
    /**
     * @attribute
     */
    private Integer id_plongeur_assos;

    // Constructeurs : 
    public Camera(Point pos_camera, Integer id_plongeur_assos) {
        this.pos_camera = pos_camera;
        for (Case c : Lagune.grille) {
            if(c.getX() == pos_camera.getX() && c.getY() == pos_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons.add(p.toString());
                }
            }
        }
        this.id_camera = Camera.next_id_camera;
        Camera.next_id_camera++;
        this.id_plongeur_assos = id_plongeur_assos;
    }

    // Méthodes d'instance : 

    /**
     * Mets à jour la description d'une Camera
     */
    public void updateCamera(){
        for (Case c : Lagune.grille) {
            if(c.getX() == pos_camera.getX() && c.getY() == pos_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons.add(p.toString());
                }
            }
        }     
    }

    /**
     * Renvoie l'id de la Camera pointée
     * @return l'id de la Camera pointée
     */
    public int getId_camera(){
        return this.id_camera;
    }

    /**
     * Recupère la description des poissons perçus par la Camera
     * @return la description des poissons perçus par la Camera
     */
    public ArrayList<String> getDescription_poissons() {
        return description_poissons;
    }

    /**
     * Récupère la position de la Camera
     * @return la position de la Camera
     */
    public Point getPos_camera() {
        return pos_camera;
    }

    /**
     * Transforme la description de la chasse perçue par la Camera
     * @param description_chasse la nouvelle description de la chasse perçue par la Camera
     */
    public void setDescription_chasse(ArrayList<String> description_chasse) {
        this.description_chasse = description_chasse;
    }

    /**
     * Récupère la description de la chasse perçue par la Camera
     * @return la description de la chasse perçue par la Camera
     */
    public ArrayList<String> getDescription_chasse() {
        return description_chasse;
    }

    /**
     * Récupère l'id du plongeur à qui appartient la Camera
     * @return l'id du plongeur à qui appartient la Camera
     */
    public Integer getId_plongeur_assos(){
        return id_plongeur_assos;
    }

    /**
     * Passage en String des informations de la Camera
     */
    @Override
    public String toString(){
        return "Camera de "+this.id_plongeur_assos+": sur la Case"+this.pos_camera;
    }

    //Méthodes de classe :

    /**
     * Récupère la liste de toutes les Camera
     * @return la liste de toutes les Camera
     */
    public static ArrayList<Camera> getAll_camera(){
        return all_camera;
    }

    /**
     * Mets à jour toutes les descriptions de Chasse des Camera
     */
    public static void updateChasseCamera(){ 
        for (Camera c : Camera.all_camera) {
            ArrayList<String> res = new ArrayList<String>();
            for (Case ca : Lagune.grille) {
                if(ca.getX() == c.getPos_camera().getX() && ca.getY() == c.getPos_camera().getY()){
                    //Remplir un tableau de Proies et de Predateurs de la Case
                    ArrayList<Predateurs> tab_pred = new ArrayList<Predateurs>();
                    ArrayList<Proies> tab_prey = new ArrayList<Proies>();
                    for (Poissons p : ca.getContenu()) {
                        if(p.getClass() == Proies.class){
                            tab_prey.add((Proies)p);
                        }
                        if(p.getClass() == Predateurs.class){
                            tab_pred.add((Predateurs)p);
                        }
                    }
                    for (int i = 0; i < ca.getContenu().size(); i++) {
                        if(ca.getContenu().get(i).getClass() == Proies.class){
                            boolean estPresent = false;
                            for(int j = 0; j < tab_prey.size();j++){
                                if(ca.getContenu().get(i) == tab_prey.get(j)){
                                    estPresent = true;
                                }
                            }
                            if(!estPresent){
                                res.add("Le Poissons"+ca.getContenu().get(i).getNom_poisson()+"est mort.");
                            }
                        }
                        if(ca.getContenu().get(i).getClass() == Predateurs.class){
                            boolean estPresent = false;
                            for(int j = 0; j < tab_pred.size();j++){
                                if(ca.getContenu().get(i) == tab_pred.get(j)){
                                    estPresent = true;
                                }
                            }
                            if(!estPresent){
                                res.add("Le Poissons"+ca.getContenu().get(i).getNom_poisson()+"est mort.");
                                for (Emetteur e : Emetteur.getAll_emetteur()) {
                                    if(e.getPreda_assos() == ca.getContenu().get(i)){
                                        Emetteur.getAll_emetteur().remove(e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        c.setDescription_chasse(res);
        }
        
    }
}
