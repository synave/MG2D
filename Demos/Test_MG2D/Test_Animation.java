import MG2D.*;
import MG2D.geometrie.*;

import java.awt.Font;


// permet de tester la fonctionnalité des collisions
public class Test_Animation {
	
    public static void main ( String [] args ) {

	int largeur=900, hauteur=600;
		
	Fenetre f = new Fenetre ( "Collision", largeur, hauteur );
		
	Clavier clavier = f.getClavier();
		
	Animation a = new Animation ( "img/carPlanche2_","0000000000","0000000015","png", new Point(350,150));
	a.setLecture(false);
	a.setNumeroImage("0000000000");
		
	f.ajouter ( a );

	f.ajouter(new Texte(Couleur.NOIR,"Appuyez sur espace pour (re)lancer l'animation.",new Font("Calibri", Font.TYPE1_FONT, 30),new Point(largeur/2,550)));
		
	while ( true ) {
			
	    try {				
		Thread.sleep ( 100 );
	    }		
	    catch ( Exception e ) {				
		System.out.println ( e );
	    }
			
	    if ( clavier.getGauche() && a.getA().getX()-10 >= 0 )
		a.translater(-10,0);
			
			
	    if ( clavier.getDroite() && a.getB().getX()+10 <= largeur )
		a.translater(10,0);
   
			
	    if ( clavier.getHaut() && a.getB().getY()+10 <= hauteur )
		a.translater(0,10);
			
			
	    if ( clavier.getBas() && a.getA().getY()-10 >= 0 )
		a.translater(0,-10);

	    if( clavier.getEspaceTape()){
		a.setLecture(true);
		a.setNumeroImage("0000000000");
	    }

	    if(a.surDerniereImage()){
		a.setLecture(false);
	    }
	    
					
	    f.rafraichir();
	}
    }
}
