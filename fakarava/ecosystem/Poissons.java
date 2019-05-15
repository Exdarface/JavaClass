package fakarava.ecosystem;

import java.awt.Point;

public abstract class Poissons implements Clock {
    /**
     * @attribute
     */
    private Integer numero_poisson;

    /**
     * @attribute
     */
    private String nom_poisson;

    /**
     * @attribute
     */
    private float poids_poisson;

    /**
     * @attribute
     */
    private Integer age_poisson;

    /**
     * @attribute
     */
    private Point position_poisson;

    public Poissons(Integer numero_poisson, String nom_poisson, float poids_poisson, Integer age_poisson,
                    Point position_poisson) {
        this.numero_poisson = numero_poisson;
        this.nom_poisson = nom_poisson;
        this.poids_poisson = poids_poisson;
        this.age_poisson = age_poisson;
        this.position_poisson = position_poisson;
    }

    public Integer getNumero_poisson() {
        return numero_poisson;
    }

    public String getNom_poisson() {
        return nom_poisson;
    }

    public void setPoids_poisson(float poids_poisson) {
        this.poids_poisson = poids_poisson;
    }

    public float getPoids_poisson() {
        return poids_poisson;
    }

    public void setAge_poisson(Integer age_poisson) {
        this.age_poisson = age_poisson;
    }

    public Integer getAge_poisson() {
        return age_poisson;
    }

    public void setPosition_poisson(Point position_poisson) {
        this.position_poisson = position_poisson;
    }

    public Point getPosition_poisson() {
        return position_poisson;
    }
    public void se_deplace(Point p){
    }
    public void ticktok(){
        this.age_poisson++;
    }
    public String toString(){
    }
}
