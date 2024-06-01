import MG2D.*;
import MG2D.geometrie.*;



class Exercice1{
    public static void main(String[] args){
	Fenetre f = new Fenetre("Exercice 1", 800, 600);
	Cercle roueG = new Cercle(Couleur.NOIR, new Point(100,200), 20, true);
	Cercle roueD = new Cercle(Couleur.NOIR, new Point(300,200), 20, true);
	Rectangle caisse = new Rectangle (Couleur.GRIS_FONCE, new Point(60,200), new Point(340,240), true);
	Rectangle vitreMilieu = new Rectangle (Couleur.GRIS, new Point(160,240), new Point(240,280), true);
	Triangle vitreArriere = new Triangle (Couleur.GRIS_CLAIR, new Point(160,280), new Point(60,240), new Point(160,240), true);
	Triangle vitreAvant = new Triangle (Couleur.GRIS_CLAIR, new Point(240,280), new Point(240,240), new Point(280,240), true);
	f.ajouter(caisse);
	f.ajouter(vitreMilieu);
	f.ajouter(vitreArriere);
	f.ajouter(vitreAvant);
	f.ajouter(roueG);
	f.ajouter(roueD);
	
	f.rafraichir();
    }
}
