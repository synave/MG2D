import MG2D.*;
import MG2D.geometrie.*;


// permet de tester la fonctionnalité des collisions
public class Collision {
	
    public static void main ( String [] args ) {
		
	final int rayon = 10;
	final int largeur = 800;
	final int hauteur = 600;
		
	int dx = 1, dy = 1, cx = 1, cy = 1;
		
	Fenetre f = new Fenetre ( "Collision", largeur, hauteur);
		
	Clavier clavier = f.getClavier();
		
	Point centre = new Point ( 200, 200 );

	Carre k = new Carre ( Couleur.ROUGE, new Point ( 300, 400 ), 50, true );
		
	Cercle c = new Cercle ( Couleur.VERT, centre, rayon , true );
		
	f.ajouter ( c );
	f.ajouter ( k );
		
	while ( true ) {
			
	    try {				
		Thread.sleep ( 5 );
		System.out.println(c.getO());
	    }		
	    catch ( Exception e ) {				
		System.out.println ( e );
	    }
			
	    if ( clavier.getGaucheEnfoncee() && k.getA().getX() > 0 )
		k.translater(-1,0);
			
			
	    if ( clavier.getDroiteEnfoncee() && k.getB().getX() < largeur )
		k.translater(1,0);
   
			
	    if ( clavier.getHautEnfoncee() && k.getB().getY() < hauteur )
		k.translater(0,1);
			
			
	    if ( clavier.getBasEnfoncee() && k.getA().getY() > 0 )
		k.translater(0,-1);
			
			
	    if ( c.getO().getX() - rayon <= 0 ){
		System.out.println("test1");
		dx = 1;
	    }
			
	    if ( c.getO().getX() + rayon >= largeur ){
		System.out.println("test2");
		dx = -1;
	    }
			
	    if ( c.getO().getY() - rayon <= 0 ){
		System.out.println("test3");
		dy = 1;
	    }
			
	    if ( c.getO().getY() + rayon >= hauteur ){
		System.out.println("test4");
		dy = -1;
	    }
			
	    if ( c.intersection ( k ) ) {
				
		if ( c.getO().getX() < k.getA().getX() )
		    dx = -1;
				
		if ( c.getO().getX() > k.getB().getX() )
		    dx = 1;
				
		if ( c.getO().getY() < k.getA().getY() )
		    dy = -1;
				
		if ( c.getO().getY() > k.getB().getY() )
		    dy = 1;
				
		System.out.println ("Collision : oui" );
	    }
			
	       
	    c.translater(dx*cx,dy*cy);
					
	    f.rafraichir();
	}
    }
}
