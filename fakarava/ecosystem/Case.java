package fakarava.ecosystem;

public class Case extends Lagune {
    /**
     * @attribute
     */
    private Integer x;

    /**
     * @attribute
     */
    private Integer y;

    /**
     * @attribute
     * @associates <{Poissons}>
     */
    protected Poissons[] contenu;

    /**
     * @attribute
     */
    private Boolean is_passe= false;

    // Constructeurs :
    public Case(int x,int y){
        this.x = x;
        this.y = y;
    }

    // Méthodes d'instances : 

    /**
     * Récupère la coordonnée X de la Case
     * @return la coordonnée X de la Case
     */
    public Integer getX() {
        return x;
    }

    /**
     * Récupère la coordonnée Y de la Case
     * @return la coordonée Y de la Case
     */
    public Integer getY() {
        return y;
    }

    /**
     * Supprime un Poissons de la Case
     * @param num numéro unique du Poissons
     */
    public void removeContenu(int num) {
        Poissons[] temp = {};
        for (int i = 0; i < this.getContenu().length; i++) {
            if(this.getContenu()[i].getNumero_poisson() != num)
                temp[temp.length] = this.getContenu()[i];
        }
        this.setContenu(temp);
    }

    /**
     * Remplace le contenu d'une Case
     * @param p nouveau contenu
     */
    public void setContenu(Poissons[] p){
        this.contenu = p;
    }
    /**
     * Récupère le contenu d'une Case
     * @return le contenu d'une case
     */
    public Poissons[] getContenu() {
        return contenu;
    }

    /**
     * Transforme l'état une Case, la rendant passe ou non, tout en indentant le nombre de passe de la Lagune
     * @param is_passe Etat de la Case
     */
    public void setIs_passe(Boolean is_passe) {
        if(is_passe == false){
            this.is_passe = is_passe;
            nb_passe--;
        }
        else{
            this.is_passe = is_passe;
            nb_passe++;
        }
        
    }

    /**
     * Récupère l'état de la Case
     * @return Etat de la Case
     */
    public Boolean getIs_passe() {
        return is_passe;
    }

    /**
     * Ajoute un Poissons dans le contenu d'une Case
     * @param p Poissons à ajouter
     */
	public void addContenu(Poissons p) {
        contenu[contenu.length] = p;
    }

    // Méthodes de classe : 

    /**
     * Récupère l'index d'une Case grâce à ses coordonnées dans la grille de la Lagune
     * @param p coordonnées de la Case voulue
     * @return coordonnées de la Case voulu adaptée à la grille de la Lagune
     */
    public static int getCase(Point p) {
        int res = -1;
        if (p.getX()<N && p.getY()<N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(p.getX()== i && p.getY()== j){
                        res = i*N+j;
                    }
                }
            }
        }
        return res;        
    }
}
