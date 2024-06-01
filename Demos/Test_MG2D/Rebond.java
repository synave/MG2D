import MG2D.Fenetre;
import MG2D.Couleur;

import MG2D.geometrie.Cercle;
import MG2D.geometrie.Point;


// permet de montrer une primitive qui rebondit (programmation de la fonctionnalité)
public class Rebond {
	
    public static void main ( String [] args ) {
		
	final int rayon = 100;
	final int largeur = 800;
	final int hauteur = 600;
				
	Fenetre f = new Fenetre ( "Rebond", largeur, hauteur );
		
	int dx = 1, dy = 1;
		
	Point centre = f.getMilieu();
	Cercle c = new Cercle ( Couleur.VERT, centre, rayon , true );
				    
	f.ajouter ( c );
		
	while ( true ) {
			
	    try {
				
		Thread.sleep ( 5 );
	    }
			
	    catch ( Exception e ) {
				
		System.out.println ( e );
	    }
						
	    if ( c.getO().getX() - rayon == 0 )
		dx = 1;
			
	    if ( c.getO().getX() + rayon == largeur )
		dx = -1;
			
	    if ( c.getO().getY() - rayon == 0 )
		dy = 1;
			
	    if ( c.getO().getY() + rayon == hauteur )
		dy = -1;
			
	    c.translater(dx,dy);

	    f.rafraichir();
	}
    }	
}
