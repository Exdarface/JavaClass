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

    // Méthodes d'instance :

    /**
     * Récupère le numéro du Poissons pointé
     * @return numéro du Poissons pointé
     */
    public Integer getNumero_poisson() {
        return numero_poisson;
    }

    /**
     * Récupère le nom du Poissons pointé
     * @return nom du Poissons pointé
     */
    public String getNom_poisson() {
        return nom_poisson;
    }

    /**
     * Transforme le nom de Poissons pointé
     * @param nom_poisson nouveau nom du Poissons pointé
     */
    public void setNom_poisson(String nom_poisson){
        this.nom_poisson = nom_poisson;
    }

    /**
     * Transforme le poids du Poissons pointé
     * @param poids_poisson nouveau poids du Poissons pointé
     */
    public void setPoids_poisson(double poids_poisson) {
        this.poids_poisson = poids_poisson;
    }

    /**
     * Récupère le poids du Poissons pointé
     * @return le poids du Poissons pointé
     */
    public double getPoids_poisson() {
        return poids_poisson;
    }

    /**
     * Transforme l'âge du Poissons pointé
     * @param age_poisson l'âge du Poissons pointé
     */
    public void setAge_poisson(Integer age_poisson) {
        this.age_poisson = age_poisson;
    }

    /**
     * Récupère l'âge du Poissons pointé
     * @return l'âge du Poissons pointé
     */
    public Integer getAge_poisson() {
        return age_poisson;
    }

    /**
     * Transforme la position du Poissons pointé
     * @param position_poisson nouvelle la position du Poissons pointé
     */
    public void setPosition_poisson(Point position_poisson) {
        this.position_poisson = position_poisson;
    }

    /**
     * Récupère la position du Poissons pointé
     * @return la position du Poissons pointé
     */
    public Point getPosition_poisson() {
        return position_poisson;
    }

    /**
     * Déplace le Poissons pointé dans une Case adjacente à la Case d'origine
     */
    public void se_deplace(){
        int[] new_pos = rn.move((int) this.getPosition_poisson().getX(),(int) this.getPosition_poisson().getY() , Lagune.N);
        if(new_pos[0] < Lagune.N && new_pos[1] < Lagune.N)
            this.setPosition_poisson(new Point(new_pos[0],new_pos[1]));
    }
    /**
     * Donne toutes les informations du Poisson pointé
     */
    public String toString(){
        return this.numero_poisson+","+this.nom_poisson+","+Double.toString(this.poids_poisson)+","+
        this.age_poisson+","+this.position_poisson.toString()+"\n";
    }

    // Methodes de Classe :
    /**
     * R�cup�re le nombre de Poissons cr��s
     * @return le nombre de Poissons cr��s
     */
    public static int getNbr_poissons() {
        return nbr_poissons;
    }
    
    /**
     *Transforme l'unit� de temps locale des Poissons
     * @param unite_temps nouvelle unit� de temps locale
     */
    public static void setUnite_temps(Integer unite_temps) {
        Poissons.unite_temps = unite_temps;
    }

    /**
     * R�cup�re l'unit� de temps locale des Poissons
     * @return l'unit� de temps locale des Poissons
     */
    public static Integer getUnite_temps() {
        return unite_temps;
    }
    // Méthodes implémentées :

    /**
     * Augmente l'âge de chaque Poisson de 1
     */
    public void ticktock() {
        for (Case c : Lagune.grille) {
            for (Poissons p : c.getContenu()) {
                p.age_poisson++;
            }
        }
        
    }
}
