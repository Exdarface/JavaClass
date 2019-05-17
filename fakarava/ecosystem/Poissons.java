package fakarava.ecosystem;

//TODO : COMMENTARY
public abstract class Poissons implements Clock {
    /**
     * @attribute
     */
    private Integer numero_poisson;

    /**
     * @attribute
     */
    protected Integer nbr_poissons = 0;

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
    private Integer age_poisson;

    /**
     * @attribute
     */
    private Point position_poisson;

    /**
     * @attribute
     */
    protected static Integer unite_temps = 0;

    // Générateur aléatoire : 
    static Random rn = Random.getARandom();

    // Constructeurs : 
    public Poissons(double poids_poisson,Point position_poisson) {
        
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
    public void se_deplace(Point p){
        //TODO : Faire la méthode
    }
    
    public String toString(){
        return this.numero_poisson.toString()+","+this.nom_poisson+","+Double.toString(this.poids_poisson)+","+
        this.age_poisson.toString()+","+this.position_poisson.toString()+"\n";
    }

    // Méthodes implémentées : 
    public void ticktok(){
        this.age_poisson++;
    }
}
