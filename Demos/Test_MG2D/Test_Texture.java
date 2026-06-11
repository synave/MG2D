import MG2D.geometrie.*;
import MG2D.*;



import javax.swing.JFrame;

import MG2D.Fenetre;

public class Test_Texture extends JFrame {
	
    public static void main ( String [] args ) {
		
	// Variables //
		
	final int largeur = 800;
	final int hauteur = 600;

	Texture background = new Texture ( "./img/bob.jpg", new Point ( 0, 0 ), largeur, hauteur );
		
	// Fenêtre //
		
	Fenetre f = new Fenetre ( "Problem ?", largeur, hauteur );
	f.setBackground ( Couleur.NOIR );
		
	double x = f.getMilieu().getX();
	double y = f.getMilieu().getY();
		
	Point a = new Point ( x - 128, y - 128 );
	Point b = new Point ( x + 128, y + 128 );
		
	f.ajouter ( background );
		
	Texture t = new Texture ( "./img/t.png", a );
	t.setTaille(largeur/10, hauteur/10);

	f.ajouter ( t );
		
	int dx = -1, dy = -1;
		
	while ( true ) {
			
	    try {		
		Thread.sleep ( 2 );
	    }
	    catch ( Exception e ) {
		System.out.println ( e );
	    }
			
	    if ( t.getA().getX() == 0 ) dx = 1;		
	    if ( t.getB().getX() == largeur ) dx = -1;
	    if ( t.getA().getY() == 0 ) dy = 1;
	    if ( t.getB().getY() == hauteur ) dy = -1;
			
	    t.translater(dx,dy);
									
	    f.rafraichir();
	}
    }
}
