import MG2D.geometrie.*;



import javax.swing.JFrame;

import MG2D.Fenetre;

public class Test_Texture extends JFrame {
	
    public static void main ( String [] args ) {
		
	// Variables //
		
	Texture background = new Texture ( "img/bob.jpg", new Point ( 0, 0 ) );
		
	final int largeur = background.getLargeur();
	final int hauteur = background.getHauteur();
		
	// Fenêtre //
		
	Fenetre f = new Fenetre ( "Problem ?", largeur, hauteur );
	f.setBackground ( Couleur.NOIR );
		
	int x = f.getMilieu().getX();
	int y = f.getMilieu().getY();
		
	Point a = new Point ( x - 128, y - 128 );
	Point b = new Point ( x + 128, y + 128 );
		
	f.ajouter ( background );
		
	Texture t = new Texture ( "img/t.png", a );
	t.setTaille(400,250);

	f.ajouter ( t );
		
	int dx = -1, dy = -1;
		
	while ( true ) {
			
	    try {
				
		Thread.sleep ( 2 );
	    }
			
	    catch ( Exception e ) {
				
		System.out.println ( e );
	    }
			
	    if ( t.getA().getX() == 0 )
		dx = 1;
			
	    if ( t.getB().getX() == largeur )
		dx = -1;

	    if ( t.getA().getY() == 0 )
		dy = 1;
			
	    if ( t.getB().getY() == hauteur )
		dy = -1;
			
	    t.translater(dx,dy);
									
	    f.rafraichir();
	}
    }
}
