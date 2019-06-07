package fakarava.ecosystem;

import java.util.ArrayList;

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
    protected ArrayList<Poissons> contenu;

    /**
     * @attribute
     */
    private Boolean is_passe= false;

    /**
     * @attribute
     */
    protected Integer id_camera_assos;

    // Constructeurs :
    public Case(int x,int y){
        this.x = x;
        this.y = y;
        this.contenu = new ArrayList<Poissons>();
    }

    // MÃ©thodes d'instances : 

    /**
     * Recupere la coordonnee X de la Case
     * @return la coordonnee X de la Case
     */
    public Integer getX() {
        return x;
    }

    /**
     * Recupere la coordonnee Y de la Case
     * @return la coordonee Y de la Case
     */
    public Integer getY() {
        return y;
    }

    /**
     * Remplace le contenu d'une Case
     * @param p nouveau contenu
     */
    public void setContenu(ArrayList<Poissons> p){
        this.contenu = p;
    }
    /**
     * Recupere le contenu d'une Case
     * @return le contenu d'une case
     */
    public ArrayList<Poissons> getContenu() {
        return contenu;
    }
    /**
     * Transforme l'etat une Case, la rendant passe ou non, tout en indentant le nombre de passe de la Lagune
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
     * Recupere l'Etat de la Case
     * @return Etat de la Case
     */
    public Boolean getIs_passe() {
        return is_passe;
    }

    /**
     * Recupere l'id de la Camera presente dans la Case
     * @return l'id de la Camera presente dans la Case
     */
    public Integer getId_camera_assos(){
        return id_camera_assos;
    }

    /**
     * Transforme l'id de la Camera presente dans la Case
     * @param id_camera_assos l'id de la nouvelle Camera presente dans la Case
     */
    public void setId_camera_assos(Integer id_camera_assos){
        this.id_camera_assos = id_camera_assos;
    }

    // MÃ©thodes de classe : 

    /**
     * Recupere l'index d'une Case grace a ses coordonnees dans la grille de la Lagune
     * @param p coordonnees de la Case voulue
     * @return coordonnees de la Case voulu adaptee a la grille de la Lagune
     */
    public static int getCase(Point p) {
        Double res = -1.0;
        if (p.getX()<N && p.getY()<N) {
            res = p.getX()*Lagune.getN()+p.getY();
        }
        return res.intValue();
    }
    
    /**
     * Renvoies la Case associée aux coordonnées en paramètres
     * @param p les coordonnées
     * @return la Case voulue
     */
    public static Case getCasec(Point p){
        int pos = Case.getCase(p);
        return Lagune.getGrille().get(pos);
    }
}
