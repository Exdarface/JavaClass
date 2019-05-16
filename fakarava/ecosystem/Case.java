package fakarava.ecosystem;


import java.awt.Point;

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
     * @associates <{String}>
     */
    private Poissons[] contenu;

    /**
     * @attribute
     */
    private Boolean is_passe;

    public void Case(int x,int y){
        this.x = x;
        this.y = y;
    }

    public static void get_case(Point p,Case c) {
        if (p.getX()<N && p.getY()<N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(p.getX()== i && p.getY()== j){
                        c = grille[i*N+j];
                    }
                }
            }
        }        
    }

    public void creer_passe() {
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setContenu(Poissons[] contenu) {
        this.contenu = contenu;
    }

    public Poissons[] getContenu() {
        return contenu;
    }

    public void setIs_passe(Boolean is_passe) {
        this.is_passe = is_passe;
    }

    public Boolean getIs_passe() {
        return is_passe;
    }
}
