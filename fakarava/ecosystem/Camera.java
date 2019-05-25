package fakarava.ecosystem;

public class Camera extends Plongeurs {
    /**
     * @attribute
     */
    private String description_poissons;

    /**
     * @attribute
     */
    private Point id_camera;

    /**
     * @attribute
     */
    private String description_chasse;

    public static Camera add_camera() {
        // TODO : Finir la méthode
    }
    @Override
    public String toString(){
        // TODO : Finir la méthode
    }

    public void setDescription_poissons(String description_poissons) {
        this.description_poissons = description_poissons;
    }

    public String getDescription_poissons() {
        return description_poissons;
    }

    public void setId_camera(Point id_camera) {
        this.id_camera = id_camera;
    }

    public Point getId_camera() {
        return id_camera;
    }

    public void setDescription_chasse(String description_chasse) {
        this.description_chasse = description_chasse;
    }

    public String getDescription_chasse() {
        return description_chasse;
    }
}
