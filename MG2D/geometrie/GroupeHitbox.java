package MG2D.geometrie;

import java.util.ArrayList;
import java.awt.Graphics;

/**
 * Cette classe permet a la création d'un groupe de dessins dertinés a être utilisés comme hitbox pour une texture.
 * <br /><br />
 * Un groupe de collision est un ensemble de dessins qui sont utilisés pour détecter les collisions avec d'autres dessins.
 * @author Léothen Dusannier
 * @author Rémi Synave
 * @version 1.1
 */
public class GroupeHitbox extends Dessin {

    // attributs //

    private ArrayList<Dessin> managedDessins;

    // constructeurs //

    /**
     * Crée un groupe de collision vide.
     */
    public GroupeHitbox(){
        managedDessins = new ArrayList<>();
    }

    // getters et setters //

    /**
     * Ajoute un dessin au groupe de collision.
     * @param t Le dessin à ajouter.
     */
    public void insertion(Dessin t){
        if(!managedDessins.contains(t)){
            managedDessins.add(t);
        }
    }

    /**
     * Supprime un dessin du groupe de collision.
     * @param indice L'indice du dessin à supprimer.
     */
    public void suppression(int indice){
        if(indice >= 0 && indice < managedDessins.size()){
            managedDessins.remove(indice);
        }
    }

    /**
     * Supprime un dessin du groupe de collision.
     * @param t Le dessin à supprimer.
     */
    public void suppression(Dessin t){
        managedDessins.remove(t);
    }

    /**
     * Retourne la liste des dessins gérés par le groupe de collision.
     * @return La liste des dessins gérés.
     */
    public ArrayList<Dessin> getManagedDessins(){
        return managedDessins;
    }

    /**
     * Retourne un dessin du groupe de collision en fonction de son indice.
     * @param indice L'indice du dessin à retourner.
     * @return Le dessin correspondant à l'indice, ou null s'il n'existe pas.
     */
    public Dessin getManagedDessin(int indice){
        if(indice >= 0 && indice < managedDessins.size()){
            return managedDessins.get(indice);
        }
        return null;
    }

    // méthodes //

    /**
     * Vérifie si le groupe de collision intersecte un autre dessin.
     * @param d Le dessin à vérifier.
     * @return true si l'un des dessins du groupe intersecte le dessin donné, false sinon.
     */
    public boolean intersection(Dessin d){
        for(Dessin t : managedDessins){
            if(t.intersection(d)){
                return true;
            }
        }
        return false;
    }

    /**
     * Affiche tous les dessins du groupe de collision.
     * @param g Le contexte graphique.
     */
    public void afficher ( Graphics g ) {
        for(Dessin t : managedDessins){
            t.afficher(g);
        }
    }

    /**
     * Retourne une représentation textuelle du groupe de collision.
     * @return La chaîne de caractères représentant le groupe de collision.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CollisionGroupe : \n");
        for(Dessin t : managedDessins){
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Retourne la boîte englobante du groupe de collision.
     * @return vide parce que la classe CollisionGroupe n'est pas une forme géométrique.
     */
    public BoiteEnglobante getBoiteEnglobante(){
        return null;
    }

    /**
     * Translate tous les dessins du groupe de collision.
     * @param x La translation en x.
     * @param y La translation en y.
     */
    public void translater(double x, double y){
        for(Dessin t : managedDessins){
            t.translater(x, y);
        }
    }
}
