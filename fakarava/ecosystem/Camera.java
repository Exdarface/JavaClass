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
    private Point id_camera;

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


    public Camera(Point id_camera) {
        this.id_camera = id_camera;
        for (Case c : Lagune.grille) {
            if(c.getX() == id_camera.getX() && c.getY() == id_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons.add(p.toString());
                }
            }
        }          
    }

    public void updateCamera(){
        for (Case c : Lagune.grille) {
            if(c.getX() == id_camera.getX() && c.getY() == id_camera.getY()){
                for (Poissons p : c.getContenu()) {
                    this.description_poissons.add(p.toString());
                }
            }
        }     
    }

    public static void updateChasseCamera(){ 
        for (Camera c : Camera.all_camera) {
            ArrayList<String> res = new ArrayList<String>();
            for (Case ca : Lagune.grille) {
                if(ca.getX() == c.getId_camera().getX() && ca.getY() == c.getId_camera().getY()){
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
    @Override
    public String toString(){
        return "Camera de "+this.id_plongeur_assos+": sur la Case"+this.id_camera;
    }

    public void setDescription_poissons(ArrayList<String> description_poissons) {
        this.description_poissons = description_poissons;
    }

    public ArrayList<String> getDescription_poissons() {
        return description_poissons;
    }

    public void setId_camera(Point id_camera) {
        this.id_camera = id_camera;
    }

    public Point getId_camera() {
        return id_camera;
    }

    public void setDescription_chasse(ArrayList<String> description_chasse) {
        this.description_chasse = description_chasse;
    }

    public ArrayList<String> getDescription_chasse() {
        return description_chasse;
    }
    public static ArrayList<Camera> getAll_camera(){
        return all_camera;
    }
    public Integer getId_plongeur_assos(){
        return id_plongeur_assos;
    }
}
