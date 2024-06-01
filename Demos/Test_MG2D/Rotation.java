import MG2D.*;

import MG2D.geometrie.*;


// permet de montrer une primitive qui tourne (programmation de la fonctionnalité)
public class Rotation {
	
    public static void main ( String [] args ) {
		
    	Couleur rouge = Couleur.ROUGE;
	    	
    	Fenetre f = new Fenetre ( "Rotation", 800, 600 );
 	
    	double delta = 0;
    	int numcolor = 0;
    	
    	Point a = new Point ( ( int ) ( 400 + Math.cos ( delta + Math.PI ) * 100 ), ( int ) ( 300 + Math.sin ( delta + Math.PI ) * 100 ) );
    	Point b = new Point ( ( int ) ( 400 + Math.cos ( delta +3.0 * Math.PI / 2.0 ) * 100 ), ( int ) ( 300 + Math.sin ( delta + 3.0 * Math.PI / 2.0 ) * 100 ) );
    	Point c = new Point ( ( int ) ( 400 + Math.cos ( delta ) * 100 ), ( int ) ( 300 + Math.sin ( delta ) * 100 ) );
    	Point d = new Point ( ( int ) ( 400 + Math.cos ( delta + Math.PI / 2.0 ) * 100 ), ( int ) ( 300 + Math.sin ( delta + Math.PI / 2.0 ) * 100 ) );
    			    
    	Triangle t1 = new Triangle ( rouge, a, b, c, true);		
    	Triangle t2 = new Triangle ( Couleur.VERT, a, c, d, true );
    	
    	f.ajouter ( t1 );
    	f.ajouter ( t2 );
    	
    	while ( true ) {
    		
    	    try {
    	    	
    	    	Thread.sleep ( 10 );
    	    }
    	    
    	    catch ( Exception e ) {
    	    	
    	    	System.out.println ( e );
    	    }
    	    
    	    delta = delta + Math.PI / 80.0;
    	    
    	    if ( delta > 360 )
    	    	delta -= 360;
    	    

	    t1.setA(new Point(( int ) ( 400 + Math.cos ( delta + Math.PI ) * 100 ),( int ) ( 300 + Math.sin ( delta + Math.PI ) * 100 )));
	    t1.setB(new Point(( int ) ( 400 + Math.cos ( delta + 3.0 * Math.PI / 2.0 ) * 100 ),( int ) ( 300 + Math.sin ( delta + 3.0 * Math.PI / 2.0 ) * 100 )));
	    t1.setC(new Point(( int ) ( 400 + Math.cos ( delta ) * 100 ),( int ) ( 300 + Math.sin ( delta ) * 100 )));

	    t2.setA(new Point(( int ) ( 400 + Math.cos ( delta + Math.PI ) * 100 ),( int ) ( 300 + Math.sin ( delta + Math.PI ) * 100 )));
    	    t2.setB(new Point(( int ) ( 400 + Math.cos ( delta ) * 100 ),( int ) ( 300 + Math.sin ( delta ) * 100 )));
	    t2.setC(new Point(( int ) ( 400 + Math.cos ( delta + Math.PI / 2.0 ) * 100 ),( int ) ( 300 + Math.sin ( delta + Math.PI / 2.0 ) * 100 )));
    	    f.rafraichir();    	    
	}
    }
}
