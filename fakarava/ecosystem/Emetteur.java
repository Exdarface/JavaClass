package fakarava.ecosystem;

public class Emetteur {
    /**
     * @attribute
     */
    private Integer id_emetteur;

    /**
     * @attribute
     */
    private String description_predateur;

    /**
     * @attribute
     */
    private Integer id_plongeur_assos;

    public Emetteur(Integer id_emetteur, String description_predateur,Integer id_plongeur) {
        this.id_emetteur = id_emetteur;
        this.description_predateur = description_predateur;
        this.id_plongeur_assos = id_plongeur;
    }

    public static Emetteur add_emetteur(Plongeurs pl,Predateurs pr) {
        return new Emetteur(pr.getNumero_poisson(), pr.toString(),pl.getId_plongeur());

    }
    @Override
    public String toString(){
        return "Emetteur : "+this.id_emetteur+","+this.id_plongeur_assos+","+this.description_predateur;
    }

    public Integer getId_plongeur(){
        return id_plongeur_assos;
    }
    public void setId_plongeur(Integer id_plongeur_assos){
        this.id_plongeur_assos = id_plongeur_assos;
    }
    public Integer getId_emetteur() {
        return id_emetteur;
    }

    public void setDescription_predateur(String description_predateur) {
        this.description_predateur = description_predateur;
    }

    public String getDescription_predateur() {
        return description_predateur;
    }
}
