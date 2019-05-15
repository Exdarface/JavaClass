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
    private String[] contenu;

    /**
     * @attribute
     */
    private Boolean is_passe;

    public static Case get_case(Point p) {
    }

    public void creer_passe() {
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setContenu(String[] contenu) {
        this.contenu = contenu;
    }

    public String[] getContenu() {
        return contenu;
    }

    public void setIs_passe(Boolean is_passe) {
        this.is_passe = is_passe;
    }

    public Boolean getIs_passe() {
        return is_passe;
    }
}
