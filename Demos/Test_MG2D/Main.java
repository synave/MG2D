import MG2D.*;
import MG2D.geometrie.*;

public class Main {
	
    public static void main ( String [] args ) {
		
	Fenetre f = new Fenetre ( "Main", 800, 600 );
		
	// Test Point //
		
	Point p1 = f.getMilieu();			// getMilieu () //
	// f.ajouter ( p1 );		
	Point p2 = new Point ( 600, 400 );	// Point ( int x, int y ) //
	// f.ajouter ( p2 );
	Point p3 = new Point ( p1 );		// Point ( Point a ) //
	// f.ajouter ( p3 );

	// Test Ligne //
		
	Ligne l1 = new Ligne ( p1, p2 );	// Ligne ( Point a, Point b ) //
	// f.ajouter ( l1 );
	Ligne l2 = new Ligne ( l1 );		// Ligne ( Ligne l ) //
	// f.ajouter ( l2 );
	
	// Test Rectangle //
		
	Rectangle r1 = new Rectangle ( p1, p2 );						// Rectangle ( Point a, Point b ) //
	// f.ajouter ( r1 );	
	Rectangle r2 = new Rectangle ( p1, p2, true );					// Rectangle ( Point a, Point b, boolean plein ) //
	// f.ajouter ( r2 );
	Rectangle r3 = new Rectangle ( p1, p2, 50, 50 );				// Rectangle ( Point a, Point b, int arcLargeur, int arcHauteur ) //
	// f.ajouter ( r3 );
	Rectangle r4 = new Rectangle ( p1, p2, 50, 50, true );			// Rectangle ( Point a, Point b, int arcLargeur, int arcHauteur, boolean plein ) //
	// f.ajouter ( r4 );
	Rectangle r5 = new Rectangle ( p1, 200, 100 );					// Rectangle ( Point a, int largeur, int hauteur ) //
	// f.ajouter ( r5 );
	Rectangle r6 = new Rectangle ( p1, 200, 100, true );			// Rectangle ( Point a, int largeur, int hauteur, boolean plein ) //
	// f.ajouter ( r6 );
	Rectangle r7 = new Rectangle ( p1, 200, 100, 50, 50 );			// Rectangle ( Point a, int largeur, int hauteur, int arcLargeur, int arcHauteur ) //
	// f.ajouter ( r7 );
	Rectangle r8 = new Rectangle ( p1, 200, 100, 50, 50, true );	// Rectangle ( Point a, int largeur, int hauteur, int arcLargeur, int arcHauteur, boolean plein ) //
	// f.ajouter ( r8 );
		
	// Test Carré //
		
	// f.ajouter ( k4 );
	Carre k1 = new Carre ( p1, 100 );					// Carre ( Point a, int taille ) //
	// f.ajouter ( k5 );
	Carre k2 = new Carre ( p1, 100, true );				// Carre ( Point a, int size, boolean fill ) //
	// f.ajouter ( k6 );
	Carre k3 = new Carre ( p1, 100, 30, 30 );			// Carre ( Point a, int size, int arcWidth, int arcHeight ) //
	// f.ajouter ( k7 );
	Carre k4 = new Carre ( p1, 100, 30, 30, true );		// Carre ( Point a, int size, int arcWidth, int arcHeight, boolean fill ) //
	// f.ajouter ( k8 );
		
	// Test Ovale //

	Ovale o1 = new Ovale ( p1, 100, 50 );			// Ovale ( Point o, int largeur, int hauteur ) //
	// f.ajouter ( o1 );
	Ovale o2 = new Ovale ( p1, 100, 50, true );		// Ovale ( Point o, int largeur, int hauteur, boolean plein ) //
	// f.ajouter ( o2 );
	Ovale o3 = new Ovale ( r1 );					// Ovale ( Rectangle r ) //
	// f.ajouter ( o3 );
	Ovale o4 = new Ovale ( r1, true );				// Ovale ( Rectangle r, boolean plein ) //
	// f.ajouter ( o4 );
		
	// Test Cercle //
		
	Cercle c1 = new Cercle ( p1, 50 );			// Cercle ( Point o, int rayon ) //
	// f.ajouter ( c1 );
	Cercle c2 = new Cercle ( p1, 50, true );	// Cercle ( Point o, int rayon, boolean plein ) //
	// f.ajouter ( c2 );
	Cercle c3 = new Cercle ( k1 );				// Cercle ( Carre x ) //
	// f.ajouter ( c3 );
	Cercle c4 = new Cercle ( k1, true );		// Cercle ( Carre x, boolean plein ) //
	// f.ajouter ( c4 );
		
	// Test Triangle //
		
	Point a = new Point ( 200, 300 );
	Point b = new Point ( 300, 400 );
	Point c = new Point ( 500, 200 );
		
	Triangle t1 = new Triangle ( a, b, c );			// Triangle ( Point x, Point y, Point z ) //
	// f.ajouter ( t1 );		
	Triangle t2 = new Triangle ( a, b, c, true );	// Triangle ( Point x, Point y, Point z, boolean plein ) //
	// f.ajouter ( t2 );
		
	// Test Texture //
		
	Point centre = new Point ( f.getMilieu().getX() - 128, f.getMilieu().getY() - 128 );
		
	Texture img1 = new Texture ( "img/java.png", centre );
	// Texture ( String chemin, Point a ) //
	f.ajouter ( img1 );
		
	Texture img2 = new Texture ( "img/java.png", centre ); 
	img2.setTaille(100,500);
	//f.ajouter ( img2 );
    }
}
