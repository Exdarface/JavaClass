package fakarava.control;

import fakarava.ecosystem.Camera;
import fakarava.ecosystem.Case;
import fakarava.ecosystem.Emetteur;
import fakarava.ecosystem.Lagune;
import fakarava.ecosystem.Plongeurs;
import fakarava.ecosystem.Point;
import fakarava.ecosystem.Poissons;
import fakarava.ecosystem.Predateurs;
import fakarava.ecosystem.Proies;
import fakarava.ecosystem.Random;

import java.util.ArrayList;

public class Fakarava {
    // Champs :
    private static boolean isDay= true;
    public static boolean end;
    
    // Méthodes de classe :

    /**
     * Initialise une instance d'une Lagune
     * @param biteFactor Puissance de la morsure des Predateurs
     * @param maxCurrentStrength Force du courant Maximale
     * @param maxDensity Densité de population de Poissons Maximale
     * @param n Longueur de coté de la grille de la Lagune
     * @param predatorCloneTime Délai de reproduction des Predateurs
     * @param preyCloneTime Délai de reproduction des Proies
     * @param seed graine de la simulation
     */
    public static void init( int biteFactor, int maxCurrentStrength, int maxDensity,int n, int predatorCloneTime, int preyCloneTime, Long seed){
        Predateurs.setBITE_FACTOR(biteFactor);
        Lagune.setMAX_CURRENT_STRENGTH(maxCurrentStrength);
        Lagune.setMAX_DENSITY(maxDensity);
        Lagune.setN(n);
        Predateurs.setPREDATOR_CLONE_TIME(predatorCloneTime);
        Proies.setPREY_CLONE_TIME(preyCloneTime);
        Lagune.creer_grille();
        if(seed != null)
            Random.mySeed = seed;
        Lagune.setRn(fakarava.ecosystem.Random.getARandom());
        Fakarava.end = false;
        

    }
    
    /**
     * Creation d'un Predateurs
     * @param name nom du Predateurs
     * @param weight poids du Predateurs
     * @param x position x du Predateurs
     * @param y position y du Predateurs
     * @return numero du Predateurs
     */
    public static int createPredator(String name, double weight, int x, int y){
        Predateurs preda = new Predateurs(name,weight,new Point(x, y));
        int emplacement = Case.getCase(preda.getPosition_poisson());
        Lagune.getGrille().get(emplacement).getContenu().add((Poissons)preda);
        int new_preda = preda.getNumero_poisson();
        return new_preda;
    }

    /**
     * Creation d'une Proies
     * @param name nom de la Proies
     * @param weight poids de la Proies
     * @param x position x de la Proies
     * @param y position y de la Proies
     * @param dayVivacity vivacite de la Proies de jour
     * @return numero de la Proies
     */
    public static int createPrey(String name, double weight, int x, int y, int dayVivacity){
        Proies prey = new Proies(name, weight, new Point(x,y), dayVivacity);
        int emplacement = Case.getCase(prey.getPosition_poisson());
        Lagune.getGrille().get(emplacement).getContenu().add((Poissons)prey);
        int new_prey = prey.getNumero_poisson();
        return new_prey;
    }

    /**
     * Creation d'une passe
     * @param x coordonnée x de la Case se transformant en passe
     * @param y coordonnée y de la Case se transformant en passe
     * @return La position absolue dans la grille de la Lagune
     */
    public static int createFishway(int x, int y){
        if(y == 0 || y == Lagune.getN()-1){
            Case.getCasec(new Point(x,y)).setIs_passe(true);
            System.out.println("Passe cree");
        }
        else if((y > 0 && y<Lagune.getN()-1) && (x == 0 || x == Lagune.getN()-1)){
            Case.getCasec(new Point(x,y)).setIs_passe(true);
            System.out.println("Passe cree");
        }
        return x*Lagune.getN()+y;
    }

    /**
     * Creation d'une passe
     * @param name nom du plongeur
     * @param labo nom du laboratoire
     * @return id du plongeur créé
     */
    public static int createDiver(String name, String labo){
        int new_diver = new Plongeurs(name, labo).getId_plongeur();
        return new_diver;
    }

    /**
     * Supprime les composants du plongeurs (Emetteur et Camera)
     * @param diver plongeur associé
     */
    public static void deleteDiver(int diver){
        for(int i = 0;i< Camera.getAll_camera().size();i++){
            if(Camera.getAll_camera().get(i).getId_plongeur_assos() == diver)
                Camera.getAll_camera().remove(Camera.getAll_camera().get(i));
        }
        for(int i = 0;i<Emetteur.getAll_emetteur().size();i++){
            if(Emetteur.getAll_emetteur().get(i).getId_plongeur_assos() == diver)
                Emetteur.getAll_emetteur().remove(Emetteur.getAll_emetteur().get(i));
        }
        for(int i = 0; i < Plongeurs.getList_plong().size();i++){
            if(Plongeurs.getList_plong().get(i).getId_plongeur() == diver)
                Plongeurs.getList_plong().remove(Plongeurs.getList_plong().get(i));
        }
    }

    public static void putCamera(int diver, int fishway){
        for(Plongeurs p : Plongeurs.getList_plong()){
            if(p.getId_plongeur() == diver){
                if((p.getNb_action() == 1 && p.getToDoList().isEmpty())
                   ||(p.getNb_action() == 1 && (!p.getToDoList().isEmpty()) && p.getToDoList().get(0) == "Poser une Camera : "+
                                                                        new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString())){
                    new Camera(new Point(fishway/Lagune.getN(),fishway%Lagune.getN()),diver);
                    System.out.println("Camera placee");
                    if(p.getNb_action() == 1 && (!p.getToDoList().isEmpty()) && p.getToDoList().get(0) == "Poser une Camera : "+
                                                                        new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString())
                        p.getToDoList().remove(0);
                }
                else{
                    p.getToDoList().add("Poser une Camera" + new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString());
                }
            }
        }
    }

    public static void putTransmitters(int diver, int fishway){
        for(Plongeurs p : Plongeurs.getList_plong()){
            if(p.getId_plongeur() == diver){
                if((p.getNb_action() == 1 && p.getToDoList().isEmpty())
               ||(p.getNb_action() == 1 && (!p.getToDoList().isEmpty()) && p.getToDoList().get(0) =="Poser des Emetteurs"+ new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString())){
                    for (Case c : Lagune.getGrille()) {
                        if(Case.getCase(new Point(c.getX(),c.getY())) == fishway){
                            for (Poissons po : c.getContenu()) {
                                if(po.getClass() == Predateurs.class){
                                    new Emetteur(((Predateurs)po), diver);
                                }
                            }
                        }
                    }
                    System.out.println("Emetteur poses");
                    p.setNb_action(0);
                    if(p.getNb_action() == 1 && p.getToDoList().get(0) =="Poser des Emetteurs"+ new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString())
                        p.getToDoList().remove(0);
                }
                else{
                    p.getToDoList().add("Poser des Emetteurs"+ new Point(fishway/Lagune.getN(),fishway%Lagune.getN()).toString());
                }
            }
        }
    }
    /**
     * augmente les pendules chronobiologiques des Poissons et des Plongeurs
     */
    public static void clockForward(){
        Poissons.setUnite_temps(Poissons.getUnite_temps()+1);
        for (Case c : Lagune.getGrille()) {
            for (Poissons p : c.getContenu()) {
                    p.ticktock();            
            }   
        }
        Proies.se_reproduitprey();
        Predateurs.se_reproduitpred();
        for (Case c : Lagune.getGrille()) {
            if(c.getContenu().size() != 0){
                for(int i =0; i< c.getContenu().size();i++) {
                    int reu = c.getContenu().get(i).se_deplace();
                    if(reu == 1){
                        Case.getCasec(c.getContenu().get(i).getPosition_poisson()).getContenu().add(c.getContenu().get(i));
                        c.getContenu().remove(c.getContenu().get(i)); 
                    }
                }
            }
        }
        if(Fakarava.isDay == true){
            Fakarava.isDay = false;
            
        }
        else{
            Fakarava.isDay = true;
            for(Plongeurs p : Plongeurs.getList_plong()){
                p.setNb_action(1);
            }
        }
        Predateurs.chasse();
        Camera.updateChasseCamera();
        //Iteration 1 : Trop de Poissons dans la Lagune
        if(Lagune.getMAX_DENSITY() < Poissons.getNbr_poissons()){
            System.out.println("Il y a trop de poissons dans la Lagune, le programme s'arrete.");
            Fakarava.end = true;
        }
        //Iteration 2 : Plus de Proies dans la Lagune
        ArrayList<Proies> list_prey = new ArrayList<Proies>();
        for (Case c : Lagune.getGrille()) {
            for (Poissons p : c.getContenu()) {
                if(p.getClass() == Proies.class){
                    list_prey.add((Proies)p);
                }
            }
        }
        
        System.out.println("Nombres de proies restantes :"+list_prey.size());
        if(list_prey.size() == 0){
            System.out.println("Il n'y as plus de Proies dans la Lagune, le programme s'arr�te.");
            Fakarava.end = true;
        }
        //Iteration 3 : Il n'y as plus de Plongeurs
        if(Plongeurs.getList_plong().size() == 0){
            System.out.println("Il n'y as plus de plongeurs, le programme s'arrete.");
            Fakarava.end = true;
        }
    }

    /**
     * Permet de voir l'�volution de la simulation
     * @return l'�volution de la simulation
     */
    public static String[] spyReport(){
        int length = 0;
        for(Case c : Lagune.getGrille()){
            length = c.getContenu().size();
        }
        String[] res = new String[length];
        int i = 0;
        for(Case c : Lagune.getGrille()){
            for(Poissons p : c.getContenu()){
                res[i] = p.toString();
                i++;
            }
        }
        return res;
    }
}
