import MG2D.geometrie.*;
import java.awt.Font;

import MG2D.Fenetre;

public class Test_Texte {
	
    public static void main ( String [] args ) {
		
	// Variables //
		
	Texte t1 = new Texte ( Couleur.NOIR, "ceci est un essai de texte centré au milieu de l'écran", new Font("Calibri", Font.TYPE1_FONT, 20),  new Point(400,300), Texte.CENTRE);
	Texte t2 = new Texte ( Couleur.NOIR, "Et ça un texte aligné sur le bord gauche", new Font("Calibri", Font.TYPE1_FONT, 20),  new Point(0,200), Texte.GAUCHE);

	System.out.println("taille du texte du haut : "+t1.getLargeur()+"x"+t1.getHauteur());
	System.out.println("taille du texte du bas : "+t2.getLargeur()+"x"+t2.getHauteur());
		
	final int largeur = 800;
	final int hauteur = 600;
		
	// Fenêtre //
		
	Fenetre f = new Fenetre ( "Test texte", largeur, hauteur );
		
	f.ajouter ( t1 );
	f.ajouter ( t2 );

	f.ajouter(new Rectangle(Couleur.ROUGE,t1.getBoiteEnglobante().getA(), t1.getBoiteEnglobante().getB(), false));
	f.ajouter(new Rectangle(Couleur.ROUGE,t2.getBoiteEnglobante().getA(), t2.getBoiteEnglobante().getB(), false));

	f.rafraichir();
    }
}
