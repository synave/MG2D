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
import MG2D.*;
import MG2D.geometrie.*;


/*
class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;
	private Clavier clavier = getClavier();
	
	public Animation animation1, animation2 ;

	int vitesse = 5; 

	public Exercice1(){
		super();
	}

	public void initialisation() {
		fenetre = getFenetre();

		animation1 = new Animation(
			"./img/moving/duck",
			1,
			6,
			"png",
			100,
			new Point(350,350),
			100,
			100
		);

		animation2 = new Animation(
			"./img/idle/duck",
			1,
			3,
			"png",
			100,
			new Point(64,64),
			100,
			100
		);

		Cercle nouvelleCollision = new Cercle(new Point(50,50), 16);

		fenetre.ajouter(nouvelleCollision);

		fenetre.ajouter(animation2);

		fenetre.ajouter(animation2.getHitbox());
		fenetre.ajouter(animation1.getHitbox());

		animation1.changeFormeHitbox(nouvelleCollision);

		fenetre.ajouter(animation1);
		fenetre.ajouter(animation1.getHitbox());
	}

    public void boucleDeJeu(){
		if (clavier.getZEnfoncee()){ animation1.translater(0, vitesse); }
		if (clavier.getSEnfoncee()){ animation1.translater(0, -vitesse); }
		if (clavier.getQEnfoncee()){ animation1.translater(-vitesse, 0); }
		if (clavier.getDEnfoncee()){ animation1.translater(vitesse, 0); }

		if (animation1.intersection(animation2)){
			System.out.println("Collision !");
		} 
    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
	}*/
