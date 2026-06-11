import MG2D.*;
import MG2D.geometrie.*;


// Classe permettant de tester la fonctionnalité des collisions
public class Collision {
	
    public static void main ( String [] args ) {

	// Attributs du cercle qui va bouger sur l'écran
	final int rayon = 10;
	final int largeur = 800;
	final int hauteur = 600;
	Point centre = new Point ( 200, 200 );

	// Direction du cercle
	int dx = 1, dy = 1;

	// Création de la fenêtre MG2D
	Fenetre f = new Fenetre ( "Collision", largeur, hauteur);
	// Récupération du clavier associé
	Clavier clavier = f.getClavier();

	
	// Définition des objets à afficher : le carré et le cercle
	Carre k = new Carre ( Couleur.ROUGE, new Point ( 300, 400 ), 50, true );		
	Cercle c = new Cercle ( Couleur.VERT, centre, rayon , true );

	// On les ajoute à la fenêtre
	f.ajouter ( c );
	f.ajouter ( k );

	// On boucle tant qu'on n'a pas appuyé sur la lettre Q pour sortir
	while ( !clavier.getQTape() ) {

	    // Pause de 5 ms
	    try {				
		Thread.sleep ( 5 );
	    }		
	    catch ( Exception e ) {				
		System.out.println ( e );
	    }

	    // Déplacement du carré avec les flèches
	    if ( clavier.getGaucheEnfoncee() && k.getA().getX() > 0 ) k.translater(-1,0);
	    if ( clavier.getDroiteEnfoncee() && k.getB().getX() < largeur ) k.translater(1,0);
	    if ( clavier.getHautEnfoncee() && k.getB().getY() < hauteur ) k.translater(0,1);
	    if ( clavier.getBasEnfoncee() && k.getA().getY() > 0 ) k.translater(0,-1);

	    // Gestion des collisions entre le cercle et les bords de l'écran
	    if ( c.getO().getX() - rayon <= 0 ) dx = 1;			
	    if ( c.getO().getX() + rayon >= largeur ) dx = -1;			
	    if ( c.getO().getY() - rayon <= 0 ) dy = 1;			
	    if ( c.getO().getY() + rayon >= hauteur ) dy = -1;

	    // Gestion de la collision entre le carré et le cercle
	    if ( c.intersection ( k ) ) {	
		if ( c.getO().getX() < k.getA().getX() ) dx = -1;
		if ( c.getO().getX() > k.getB().getX() ) dx = 1;
		if ( c.getO().getY() < k.getA().getY() ) dy = -1;				
		if ( c.getO().getY() > k.getB().getY() ) dy = 1;
				
		System.out.println ("Collision !" );
	    }

	    // Modification de la position du cercle
	    c.translater(dx,dy);

	    // Mise à jour de l'affichage
	    f.rafraichir();
	}
    }
}
