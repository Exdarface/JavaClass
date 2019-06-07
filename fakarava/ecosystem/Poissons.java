package fakarava.ecosystem;


public abstract class Poissons {
    /**
     * @attribute
     */
    private int numero_poisson;

    /**
     * @attribute
     */
    protected static int nbr_poissons = 0;

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
    protected static Integer unite_temps = 1;

    // Constructeurs : 
    public Poissons(String nom,double poids_poisson,Point position_poisson) {
        
        this.nom_poisson = nom;
        this.numero_poisson = nbr_poissons+1;
        this.poids_poisson = poids_poisson;
        this.age_poisson = 1;
        this.position_poisson = position_poisson;
        nbr_poissons++;
    }

    // Methodes d'instances :

    /**
     * Recupere le numro du Poissons pointe
     * @return numero du Poissons pointe
     */
    public Integer getNumero_poisson() {
        return numero_poisson;
    }

    /**
     * Recupere le nom du Poissons pointe
     * @return nom du Poissons pointe
     */
    public String getNom_poisson() {
        return nom_poisson;
    }

    /**
     * Transforme le nom de Poissons pointe
     * @param nom_poisson nouveau nom du Poissons pointe
     */
    public void setNom_poisson(String nom_poisson){
        this.nom_poisson = nom_poisson;
    }

    /**
     * Transforme le poids du Poissons pointe
     * @param poids_poisson nouveau poids du Poissons pointe
     */
    public void setPoids_poisson(double poids_poisson) {
        this.poids_poisson = poids_poisson;
    }

    /**
     * Recupere le poids du Poissons pointe
     * @return le poids du Poissons pointe
     */
    public double getPoids_poisson() {
        return poids_poisson;
    }

    /**
     * Transforme l'age du Poissons pointe
     * @param age_poisson l'age du Poissons pointe
     */
    public void setAge_poisson(Integer age_poisson) {
        this.age_poisson = age_poisson;
    }

    /**
     * Recupere l'age du Poissons pointe
     * @return l'age du Poissons pointe
     */
    public Integer getAge_poisson() {
        return age_poisson;
    }

    /**
     * Transforme la position du Poissons pointe
     * @param position_poisson nouvelle la position du Poissons pointe
     */
    public void setPosition_poisson(Point position_poisson) {
        this.position_poisson = position_poisson;
    }

    /**
     * Recupere la position du Poissons pointe
     * @return la position du Poissons pointe
     */
    public Point getPosition_poisson() {
        return position_poisson;
    }

    /**
     * Deplace le Poissons pointe dans une Case adjacente a la Case d'origine
     */
    public int se_deplace(){
        int[] new_pos = Lagune.getRn().move((int) this.getPosition_poisson().getX(),(int) this.getPosition_poisson().getY() , Lagune.N);
        if(new_pos[0] < Lagune.N && new_pos[1] < Lagune.N){
            this.setPosition_poisson(new Point(new_pos[0],new_pos[1]));
            return 1;
        }
        return 0;
    }
    /**
     * Donne toutes les informations du Poisson pointe
     */
    public String toString(){
        return this.numero_poisson+","+this.nom_poisson+","+Double.toString(this.poids_poisson)+","+
        this.age_poisson+","+this.position_poisson.toString()+"\n";
    }

    // Methodes de Classe :
    /**
     * Recupere le nombre de Poissons cree
     * @return le nombre de Poissons cree
     */
    public static int getNbr_poissons() {
        return nbr_poissons;
    }
    
    /**
     *Transforme l'unite de temps locale des Poissons
     * @param unite_temps nouvelle unite de temps locale
     */
    public static void setUnite_temps(Integer unite_temps) {
        Poissons.unite_temps = unite_temps;
    }

    /**
     * Recupere l'unite de temps locale des Poissons
     * @return l'unite de temps locale des Poissons
     */
    public static Integer getUnite_temps() {
        return unite_temps;
    }
    // Methodes implementees :

    /**
     * Augmente l'age de chaque Poisson de 1
     */
    public void ticktock() {
        for (Case c : Lagune.getGrille()) {
            for (Poissons p : c.getContenu()) {
                p.age_poisson++;
            }
        }
        
    }
}
