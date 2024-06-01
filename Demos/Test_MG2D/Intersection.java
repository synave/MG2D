import MG2D.*;
import MG2D.geometrie.*;



public class Intersection {
	
    public static void main ( String [] args ) {
		
	Fenetre f1 = new Fenetre ( "Point", 900, 600 ); {
			
	    Ligne l1 = new Ligne ( new Point ( 0, 300 ), new Point ( 900, 300 ) );
	    Ligne l2 = new Ligne ( new Point ( 300, 0 ), new Point ( 300, 600 ) );
	    Ligne l3 = new Ligne ( new Point ( 600, 0 ), new Point ( 600, 600 ) );
			
	    f1.ajouter ( l1 );
	    f1.ajouter ( l2 );
	    f1.ajouter ( l3 );
							
	    testPoint ( f1 );
	}
		
	Fenetre f2 = new Fenetre ( "Ligne", 900, 600 ); {
			
	    Ligne l1 = new Ligne ( new Point ( 0, 300 ), new Point ( 900, 300 ) );
	    Ligne l2 = new Ligne ( new Point ( 300, 0 ), new Point ( 300, 600 ) );
	    Ligne l3 = new Ligne ( new Point ( 600, 0 ), new Point ( 600, 600 ) );
			
	    f2.ajouter ( l1 );
	    f2.ajouter ( l2 );
	    f2.ajouter ( l3 );
							
	    testLigne ( f2 );
	}		
    } // Fin main //
	
    public static void testPoint ( Fenetre f ) {
		
	/* Point - Point */ {
			
	    Point p1 = new Point ( 145, 150 );
	    Point p2 = new Point ( p1 );
	    Point p3 = new Point ( 155, 150 );
			
	    f.ajouter ( p1 );
	    f.ajouter ( p2 );
	    f.ajouter ( p3 );
			
	    if ( p1.intersection ( p2 ) )
		p2.setCouleur ( Couleur.ROUGE );
			
	    else
		p2.setCouleur ( Couleur.VERT );
			
	    if ( p1.intersection ( p3 ) )
		p3.setCouleur ( Couleur.ROUGE );
			
	    else
		p3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Point */
		
	/* Point - Ligne */ {
			
	    Point p = new Point ( 450, 150 );

	    Ligne l1 = new Ligne ( new Point ( 400, 150 ), new Point ( 500, 150 ) );
	    Ligne l2 = new Ligne ( new Point ( 400, 120 ), new Point ( 500, 220 ) );
	    Ligne l3 = new Ligne ( new Point ( 400, 250 ), new Point ( 500, 250 ) );
			
	    f.ajouter ( l1 );
	    f.ajouter ( l2 );
	    f.ajouter ( l3 );
			
	    f.ajouter ( p );
			
	    if ( p.intersection ( l1 ) )
		l1.setCouleur ( Couleur.ROUGE );
			
	    else
		l1.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( l2 ) )
		l2.setCouleur ( Couleur.ROUGE );
			
	    else
		l2.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( l3 ) )
		l3.setCouleur ( Couleur.ROUGE );
			
	    else
		l3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Ligne */
		
	/* Point - Rectangle */ {
			
	    Point p = new Point ( 750, 150 );
			
	    Rectangle r1 = new Rectangle ( new Point ( 700, 100 ), new Point ( 800, 200 ) );
	    Rectangle r2 = new Rectangle ( p, 30, 40 );
	    Rectangle r3 = new Rectangle ( new Point ( 800, 250 ), 20, 40 );
			
	    f.ajouter ( r1 );
	    f.ajouter ( r2 );
	    f.ajouter ( r3 );
			
	    f.ajouter ( p );
			
	    if ( p.intersection ( r1 ) )
		r1.setCouleur ( Couleur.ROUGE );
			
	    else
		r1.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( r2 ) )
		r2.setCouleur ( Couleur.ROUGE );
			
	    else
		r2.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( r3 ) )
		r3.setCouleur ( Couleur.ROUGE );
			
	    else
		r3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Rectangle */
		
	/* Point - Ovale */ {
			
	    Point p = new Point ( 150, 450 );
			
	    Ovale o1 = new Ovale ( p, 40, 60 );
	    Ovale o2 = new Ovale ( new Point ( 160, 480 ), 40, 60 );
	    Ovale o3 = new Ovale ( new Point ( 200, 450 ), 40, 60 );
			
	    f.ajouter ( o1 );
	    f.ajouter ( o2 );
	    f.ajouter ( o3 );
			
	    f.ajouter ( p );
			
	    if ( p.intersection ( o1 ) )
		o1.setCouleur ( Couleur.ROUGE );
			
	    else
		o1.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( o2 ) )
		o2.setCouleur ( Couleur.ROUGE );
			
	    else
		o2.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( o3 ) )
		o3.setCouleur ( Couleur.ROUGE );
			
	    else
		o3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Ovale */
		
	/* Point - Cercle */ {
			
	    Point p = new Point ( 450, 450 );
			
	    Cercle c1 = new Cercle ( p, 30 );
	    Cercle c2 = new Cercle ( new Point ( 475, 475 ), 30 );
	    Cercle c3 = new Cercle ( new Point ( 550, 550 ), 30 );
			
	    f.ajouter ( c1 );
	    f.ajouter ( c2 );
	    f.ajouter ( c3 );
			
	    f.ajouter ( p );
			
	    if ( p.intersection ( c1 ) )
		c1.setCouleur ( Couleur.ROUGE );
			
	    else
		c1.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( c2 ) )
		c2.setCouleur ( Couleur.ROUGE );
			
	    else
		c2.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( c3 ) )
		c3.setCouleur ( Couleur.ROUGE );
			
	    else
		c3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Cercle */
		
	/* Point - Triangle */ {
			
	    Point p = new Point ( 750, 450 );
			
	    Triangle t1 = new Triangle ( new Point ( 750, 425 ), new Point ( 775, 475 ), new Point ( 725, 475 ) );
	    Triangle t2 = new Triangle ( new Point ( 770, 440 ), new Point ( 785, 475 ), new Point ( 740, 465 ) );
	    Triangle t3 = new Triangle ( new Point ( 800, 500 ), new Point ( 820, 520 ), new Point ( 780, 520 ) );
			
	    f.ajouter ( t1 );
	    f.ajouter ( t2 );
	    f.ajouter ( t3 );
			
	    f.ajouter ( p );
			
	    if ( p.intersection ( t1 ) )
		t1.setCouleur ( Couleur.ROUGE );
			
	    else
		t1.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( t2 ) )
		t2.setCouleur ( Couleur.ROUGE );
			
	    else
		t2.setCouleur ( Couleur.VERT );
			
	    if ( p.intersection ( t3 ) )
		t3.setCouleur ( Couleur.ROUGE );
			
	    else
		t3.setCouleur ( Couleur.VERT );
	} /* Fin Point - Triangle */
    } /* Fin testPoint */

    public static void testLigne ( Fenetre f ) {
		
	/* Ligne - Ligne */ {
			
	    Ligne l1 = new Ligne ( new Point ( 400, 100 ), new Point ( 500, 200 ) );
	    Ligne l2 = new Ligne ( new Point ( 500, 100 ), new Point ( 400, 200 ) );
	    Ligne l3 = new Ligne ( new Point ( 400, 130 ), new Point ( 500, 230 ) );
	    Ligne l4 = new Ligne ( new Point ( 400, 250 ), new Point ( 500, 250 ) );
	    Ligne l5 = new Ligne ( new Point ( 480, 50 ), new Point ( 440, 120 ) );
			
	    f.ajouter ( l1 );
	    f.ajouter ( l2 );
	    f.ajouter ( l3 );
	    f.ajouter ( l4 );
	    f.ajouter ( l5 );
			
	    if ( l1.intersection ( l2 ) )
		l2.setCouleur ( Couleur.ROUGE );
			
	    else
		l2.setCouleur ( Couleur.VERT );
			
	    if ( l1.intersection ( l3 ) )
		l3.setCouleur ( Couleur.ROUGE );
			
	    else
		l3.setCouleur ( Couleur.VERT );
			
	    if ( l1.intersection ( l4 ) )
		l4.setCouleur ( Couleur.ROUGE );
			
	    else
		l4.setCouleur ( Couleur.VERT );
			
	    if ( l1.intersection ( l5 ) )
		l5.setCouleur ( Couleur.ROUGE );
			
	    else
		l5.setCouleur ( Couleur.VERT );
	} /* Fin Ligne - Ligne */
		
	/* Ligne - Rectangle */ {
			
	    Ligne l = new Ligne ( new Point ( 720, 120 ), new Point ( 780, 180 ) );
			
	    Rectangle r1 = new Rectangle ( new Point ( 710, 110 ), new Point ( 790, 190 ) );
	    Rectangle r2 = new Rectangle ( new Point ( 750, 120 ), 30, 20 );
	    Rectangle r3 = new Rectangle ( new Point ( 740, 160 ), 30, 20 );
	    Rectangle r4 = new Rectangle ( new Point ( 800, 250 ), 30, 20 );
			
	    f.ajouter ( r1 );
	    f.ajouter ( r2 );
	    f.ajouter ( r3 );
	    f.ajouter ( r4 );
			
	    f.ajouter ( l );

	    if ( l.intersection ( r1 ) )
		r1.setCouleur ( Couleur.ROUGE );
			
	    else
		r1.setCouleur ( Couleur.VERT );	

	    if ( l.intersection ( r2 ) )
		r2.setCouleur ( Couleur.ROUGE );
			
	    else
		r2.setCouleur ( Couleur.VERT );	

	    if ( l.intersection ( r3 ) )
		r3.setCouleur ( Couleur.ROUGE );
			
	    else
		r3.setCouleur ( Couleur.VERT );	

	    if ( l.intersection ( r4 ) )
		r4.setCouleur ( Couleur.ROUGE );
			
	    else
		r4.setCouleur ( Couleur.VERT );	
	} /* Fin Ligne - Rectangle */
		
	/* Ligne - Ovale */ {
			
	    Ligne l = new Ligne ( new Point ( 120, 420 ), new Point ( 180, 480 ) );
			
	    Ovale o1 = new Ovale ( new Point ( 150, 450 ), 90, 110 );
	    Ovale o2 = new Ovale ( new Point ( 170, 430 ), 30, 20 );
	    Ovale o3 = new Ovale ( new Point ( 160, 470 ), 30, 20 );
	    Ovale o4 = new Ovale ( new Point ( 200, 550 ), 30, 20 );
			
	    f.ajouter ( o1 );
	    f.ajouter ( o2 );
	    f.ajouter ( o3 );
	    f.ajouter ( o4 );
			
	    f.ajouter ( l );
			
	    if ( l.intersection ( o1 ) )
		o1.setCouleur ( Couleur.ROUGE );
			
	    else
		o1.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( o2 ) )
		o2.setCouleur ( Couleur.ROUGE );
			
	    else
		o2.setCouleur ( Couleur.VERT );
			
	    if ( l.intersection ( o3 ) )
		o3.setCouleur ( Couleur.ROUGE );
			
	    else
		o3.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( o4 ) )
		o4.setCouleur ( Couleur.ROUGE );
			
	    else
		o4.setCouleur ( Couleur.VERT );	
	} /* Fin Ligne - Ovale */
		
	/* Ligne - Cercle */ {
			
	    Ligne l = new Ligne ( new Point ( 420, 420 ), new Point ( 480, 480 ) );
			
	    Cercle c1 = new Cercle ( new Point ( 450, 450 ), 60 );
	    Cercle c2 = new Cercle ( new Point ( 470, 430 ), 10 );
	    Cercle c3 = new Cercle ( new Point ( 460, 470 ), 10 );
	    Cercle c4 = new Cercle ( new Point ( 500, 550 ), 10 );
			
	    f.ajouter ( c1 );
	    f.ajouter ( c2 );
	    f.ajouter ( c3 );
	    f.ajouter ( c4 );
			
	    f.ajouter ( l );
			
	    if ( l.intersection ( c1 ) )
		c1.setCouleur ( Couleur.ROUGE );
			
	    else
		c1.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( c2 ) )
		c2.setCouleur ( Couleur.ROUGE );
			
	    else
		c2.setCouleur ( Couleur.VERT );
			
	    if ( l.intersection ( c3 ) )
		c3.setCouleur ( Couleur.ROUGE );
			
	    else
		c3.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( c4 ) )
		c4.setCouleur ( Couleur.ROUGE );
			
	    else
		c4.setCouleur ( Couleur.VERT );	
	} /* Fin Ligne - Cercle */
		
	/* Ligne - Triangle */ {
			
	    Ligne l = new Ligne ( new Point ( 720, 420 ), new Point ( 780, 480 ) );
			
	    Triangle t1 = new Triangle ( new Point ( 750, 350 ), new Point ( 850, 500 ), new Point ( 650, 500 ) );
	    Triangle t2 = new Triangle ( new Point ( 750, 420 ), new Point ( 760, 430), new Point ( 740, 430 ) );
	    Triangle t3 = new Triangle ( new Point ( 750, 440 ), new Point ( 760, 460 ), new Point ( 740, 460 ) );
	    Triangle t4 = new Triangle ( new Point ( 750, 540 ), new Point ( 760, 560 ), new Point ( 740, 560 ) );
			
	    f.ajouter ( t1 );
	    f.ajouter ( t2 );
	    f.ajouter ( t3 );
	    f.ajouter ( t4 );
			
	    f.ajouter ( l );
			
	    if ( l.intersection ( t1 ) )
		t1.setCouleur ( Couleur.ROUGE );
			
	    else
		t1.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( t2 ) )
		t2.setCouleur ( Couleur.ROUGE );
			
	    else
		t2.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( t3 ) )
		t3.setCouleur ( Couleur.ROUGE );
			
	    else
		t3.setCouleur ( Couleur.VERT );	
			
	    if ( l.intersection ( t4 ) )
		t4.setCouleur ( Couleur.ROUGE );
			
	    else
		t4.setCouleur ( Couleur.VERT );	
	} /* Fin Ligne - Triangle */
    } /* Fin testLigne */

    public static void testRectangle ( Fenetre f ) {
		
	// TODO : travail à faire, si l'envie vous prend :) //
    } /* Fin testRectangle */

    public static void testOvale ( Fenetre f ) {
		
	// TODO : travail à faire, si l'envie vous prend :) //
    } /* Fin testOvale */

    public static void testCercle ( Fenetre f ) {
		
	// TODO : travail à faire, si l'envie vous prend :) //
    } /* Fin testCercle */

    public static void testTriangle ( Fenetre f ) {
		
	// TODO : travail à faire, si l'envie vous prend :) //
    } /* Fin testTriangle */
} /* Fin Intersection */

