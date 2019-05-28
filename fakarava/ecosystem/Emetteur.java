package fakarava.ecosystem;

public class Emetteur {
    /**
     * @attribute
     */
    private Integer id_emetteur;

    /**
     * @attribute
     */
    protected static Integer next_id_emetteur = 1;

    /**
     * @attribute
     */
    private String[] description_predateur;

    /**
     * @attribute
     */
    private Predateurs preda_assos;

    /**
     * @attribute
     */
    private Integer id_plongeur_assos;

    /**
     * @attribute
     */
    private static Emetteur[] all_emetteur;

    public Emetteur(String[] description_predateur,Predateurs pr,Integer id_plongeur) {
        this.id_emetteur = next_id_emetteur;
        this.description_predateur = description_predateur;
        this.preda_assos = pr;
        this.id_plongeur_assos = id_plongeur;
        next_id_emetteur++;
    }

    public void updateEmetteur(){
        String[] tab = {preda_assos.getNom_poisson(),preda_assos.getNumero_poisson().toString(),preda_assos.getAge_poisson().toString()
            ,String.valueOf(preda_assos.getPoids_poisson()),preda_assos.getPosition_poisson().toString()};
        this.description_predateur = tab;
    }
    public static Emetteur add_emetteur(Plongeurs pl,Predateurs pr) {
        String[] tab = {pr.getNom_poisson(),pr.getNumero_poisson().toString(),pr.getAge_poisson().toString(),
            String.valueOf(pr.getPoids_poisson()),pr.getPosition_poisson().toString()};
        return new Emetteur(tab,pr,pl.getId_plongeur());

    }
    @Override
    public String toString(){
        return "Emetteur : "+this.id_emetteur+","+this.id_plongeur_assos+","+this.description_predateur;
    }

    public Integer getId_plongeur_assos() {
        return id_plongeur_assos;
    }

    public void setId_plongeur_assos(Integer id_plongeur_assos) {
        this.id_plongeur_assos = id_plongeur_assos;
    }

    public Integer getId_emetteur() {
        return id_emetteur;
    }

    public void setDescription_predateur(String[] description_predateur) {
        this.description_predateur = description_predateur;
    }

    public String[] getDescription_predateur() {
        return description_predateur;
    }

    public void setPreda_assos(Predateurs pr){
        this.preda_assos = pr;
    }

    public Predateurs getPreda_assos(){
        return this.preda_assos;
    }

    public static Emetteur[] getAll_emetteur(){
        return Emetteur.all_emetteur;
    }
    public static void setAll_emetteur(Emetteur[] all_emetteur){
        Emetteur.all_emetteur = all_emetteur;
    }
    public static void removeAll_emetteur(Emetteur e){
        boolean estTrouve = false;
        for (int i = 0; i < Emetteur.all_emetteur.length-1; i++) {
            if(e == Emetteur.all_emetteur[i]){
                estTrouve = true;
            }
            if(e != Emetteur.all_emetteur[i] && (estTrouve)){
                Emetteur.all_emetteur[i] = Emetteur.all_emetteur[i+1];
            }
        }
    }
}
