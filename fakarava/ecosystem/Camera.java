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
    public static Camera add_camera() {
        // TODO : Finir la méthode
    }
    @Override
    public String toString(){
        // TODO : Finir la méthode
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
