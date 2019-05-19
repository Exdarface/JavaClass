package fakarava.ecosystem;

//TODO : COMMENTARY
public abstract class Poissons implements Clock {
    /**
     * @attribute
     */
    private int numero_poisson;

    /**
     * @attribute
     */
    protected int nbr_poissons = 0;

    /**
     * @attribute
     */
    private String nom_poisson;

    /**
     * @attribute
     */
    private double poids_poisson;

    /**
     * @attribute
     */
    private int age_poisson;

    /**
     * @attribute
     */
    private Point position_poisson;

    /**
     * @attribute
     */
    public static Integer unite_temps = 1;

    // Générateur aléatoire : 
    static Random rn = Random.getARandom();

    // Constructeurs : 
    public Poissons(String nom,double poids_poisson,Point position_poisson) {
        
        this.nom_poisson = nom;
        this.numero_poisson = nbr_poissons+1;
        this.poids_poisson = poids_poisson;
        this.age_poisson = 1;
        this.position_poisson = position_poisson;
        nbr_poissons++;
    }

    // Méthodes de classe :
    public Integer getNumero_poisson() {
        return numero_poisson;
    }

    public String getNom_poisson() {
        return nom_poisson;
    }

    public void setNom_poisson(String nom_poisson){
        this.nom_poisson = nom_poisson;
    }

    public void setPoids_poisson(double poids_poisson) {
        this.poids_poisson = poids_poisson;
    }

    public double getPoids_poisson() {
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
    public void se_deplace(){
        int[] new_pos = rn.move((int) this.getPosition_poisson().getX(),(int) this.getPosition_poisson().getY() , Lagune.N);
        if(new_pos[0] < Lagune.N && new_pos[1] < Lagune.N)
            this.setPosition_poisson(new Point(new_pos[0],new_pos[1]));
    }
    
    public String toString(){
        return this.numero_poisson+","+this.nom_poisson+","+Double.toString(this.poids_poisson)+","+
        this.age_poisson+","+this.position_poisson.toString()+"\n";
    }

    // Méthodes implémentées : 
    public void ticktock() {
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                p.age_poisson++;
            }
        }
        
    }
}
