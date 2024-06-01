import MG2D.*;
import MG2D.geometrie.*;

import java.awt.Font;


// permet de tester la fonctionnalité des collisions
public class Test_Animation2 {
	
    public static void main ( String [] args ) {

	int largeur=800, hauteur=600;
		
	Fenetre f = new Fenetre ( "Collision", largeur, hauteur );
		
	Clavier clavier = f.getClavier();
		
	Animation a = new Animation ( "img/carPlanche1_","0000000000","0000000011","png", new Point(300,150));
	a.setLecture(false);
	a.setNumeroImage("0000000000");
		
	f.ajouter ( a );

	f.ajouter(new Texte(Couleur.NOIR,"Restez appuyé sur espace pour accélérer.",new Font("Calibri", Font.TYPE1_FONT, 30),new Point(largeur/2,550)));
		
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

	    if( clavier.getEspaceEnfoncee()){
		if(a.getLecture()==false)
		    a.setLecture(true);
	    }else{
		if(a.getLecture()==true){
		    a.setLecture(false);
		    a.setNumeroImage("0000000000");
		}
	    }
	    
					
	    f.rafraichir();
	}
    }
}
