package fakarava.ecosystem;

public class Camera {
    /**
     * @attribute
     */
    private String[] description_poissons;

    /**
     * @attribute
     */
    private Point id_camera;

    /**
     * @attribute
     */
    private String[] description_chasse;

    /**
     * @attribute
     */
    private static Camera[] all_camera;
    /**
     * @attribute
     */
    private Integer id_plongeur_assos;


    public Camera(Point id_camera) {
        this.id_camera = id_camera;
        for (Case c : Lagune.grille) {
            if(c.getX() == id_camera.getX() && c.getY() == id_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons[this.description_poissons.length] = p.toString();
                }
            }
        }          
    }

    public void updateCamera(){
        for (Case c : Lagune.grille) {
            if(c.getX() == id_camera.getX() && c.getY() == id_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons[this.description_poissons.length] = p.toString();
                }
            }
        }     
    }

    public static void updateChasseCamera(){ 
        for (Camera c : Camera.all_camera) {
            String[] res = {};
            for (Case ca : Lagune.grille) {
                if(ca.getX() == c.getId_camera().getX() && ca.getY() == c.getId_camera().getY()){
                    //Remplir un tableau de Proies et de Predateurs de la Case
                    Predateurs[] tab_pred = {};
                    Proies[] tab_prey = {};
                    for (Poissons p : ca.getContenu()) {
                        if(p.getClass() == Proies.class){
                            tab_prey[tab_prey.length] = ((Proies)p);
                        }
                        if(p.getClass() == Predateurs.class){
                            tab_pred[tab_pred.length] = ((Predateurs)p);
                        }
                    }
                    for (int i = 0; i < ca.getContenu().length; i++) {
                        if(ca.getContenu()[i].getClass() == Proies.class){
                            boolean estPresent = false;
                            for(int j = 0; j < tab_prey.length;j++){
                                if(ca.getContenu()[i] == tab_prey[j]){
                                    estPresent = true;
                                }
                            }
                            if(!estPresent){
                                res[res.length] = "Le Poissons"+ca.getContenu()[i].getNom_poisson()+"est mort.";
                            }
                        }
                        if(ca.getContenu()[i].getClass() == Predateurs.class){
                            boolean estPresent = false;
                            for(int j = 0; j < tab_pred.length;j++){
                                if(ca.getContenu()[i] == tab_pred[j]){
                                    estPresent = true;
                                }
                            }
                            if(!estPresent){
                                res[res.length] = "Le Poissons"+ca.getContenu()[i].getNom_poisson()+"est mort.";
                                for (Emetteur e : Emetteur.getAll_emetteur()) {
                                    if(e.getPreda_assos() == ca.getContenu()[i]){
                                        Emetteur.removeAll_emetteur(e);
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
    @Override
    public String toString(){
        return "Camera de "+this.id_plongeur_assos+": sur la Case"+this.id_camera;
    }

    public void setDescription_poissons(String[] description_poissons) {
        this.description_poissons = description_poissons;
    }

    public String[] getDescription_poissons() {
        return description_poissons;
    }

    public void setId_camera(Point id_camera) {
        this.id_camera = id_camera;
    }

    public Point getId_camera() {
        return id_camera;
    }

    public void setDescription_chasse(String[] description_chasse) {
        this.description_chasse = description_chasse;
    }

    public String[] getDescription_chasse() {
        return description_chasse;
    }
    public static Camera[] getAll_camera(){
        return all_camera;
    }
    
}
