import MG2D.*;
import MG2D.geometrie.*;

import java.awt.Font;

class Test_hitbox{
    public static void main(String[] args){
	Fenetre f = new Fenetre("Test hitbox",500,500);
	Clavier clavier = f.getClavier();
	boolean hitboxAffiche=false;

	// Indicateur de collision gauche
	Rectangle r2 = new Rectangle(Couleur.VERT, new Point(0,0),20,20,true);
	f.ajouter(r2);

	// Indicateur de collision droite
	Rectangle r3 = new Rectangle(Couleur.VERT, new Point(480,0),20,20,true);
	f.ajouter(r3);

	// Obstacle
	//Cercle r = new Cercle(Couleur.NOIR, new Point(200,200),10,true);
	Rectangle r = new Rectangle(Couleur.NOIR, new Point(240,240),20,20,true);
	f.ajouter(r);

	// Joueur Droit
	Texture td = new Texture("img/avion1.png",new Point(400,70));
	td.ajouterALaHitbox(new Rectangle(new Point(0,0),new Point(51,30)));
	td.ajouterALaHitbox(new Rectangle(new Point(12,30),new Point(39,54)));
	td.ajouterALaHitbox(new Rectangle(new Point(23,54),new Point(29,75)));
	f.ajouter(td);

	// Joueur Gauche
	Texture tg = new Texture("img/avion1.png",new Point(40,70));
	f.ajouter(tg);

	// Obstacle avec hitbox
	Texture t2 = new Texture("img/avion2.png",new Point(40,350));
	t2.ajouterALaHitbox(new Rectangle(new Point(27,0),new Point(45,19)));
	t2.ajouterALaHitbox(new Rectangle(new Point(17,22),new Point(55,36)));
	t2.ajouterALaHitbox(new Rectangle(new Point(0,36),new Point(72,55)));
	f.ajouter(t2);
	f.ajouter(new Texte(Couleur.NOIR,"Texture avec hitbox",new Font("Calibri",Font.TYPE1_FONT,10), new Point(76,430)));

	// Obstacle sans hitbox
	Texture t3 = new Texture("img/avion2.png",new Point(390,350));
	f.ajouter(t3);
	f.ajouter(new Texte(Couleur.NOIR,"Texture sans hitbox",new Font("Calibri",Font.TYPE1_FONT,10), new Point(425,430)));

	// Indication
	f.ajouter(new Texte(Couleur.NOIR,"Appuyer sur espace pour afficher les hitbox",new Font("Calibri",Font.TYPE1_FONT,15), new Point(250,480)));
	f.ajouter(new Texte(Couleur.NOIR,"z/q/s/d pour bouger",new Font("Calibri",Font.TYPE1_FONT,10), new Point(65,60)));
	f.ajouter(new Texte(Couleur.NOIR,"fléches pour bouger",new Font("Calibri",Font.TYPE1_FONT,10), new Point(425,60)));
	f.ajouter(new Texte(Couleur.NOIR,"Vert : pas de collision. Rouge : collision",new Font("Calibri",Font.TYPE1_FONT,10), new Point(130,10)));
	f.ajouter(new Texte(Couleur.NOIR,"Vert : pas de collision. Rouge : collision",new Font("Calibri",Font.TYPE1_FONT,10), new Point(365,10)));

	while(true){
	    try{
		Thread.sleep(10);
	    }catch(Exception e){}

	    // Deplacement pour l'avion droit
	    if(clavier.getHautEnfoncee())
		td.translater(0,1);
	    
	    if(clavier.getBasEnfoncee())
		td.translater(0,-1);
	    
	    if(clavier.getGaucheEnfoncee())
		td.translater(-1,0);
	    
	    if(clavier.getDroiteEnfoncee())
		td.translater(1,0);

	    // Deplacement pour l'avion gauche
	    if(clavier.getZEnfoncee())
		tg.translater(0,1);
	    
	    if(clavier.getSEnfoncee())
		tg.translater(0,-1);
	    
	    if(clavier.getQEnfoncee())
		tg.translater(-1,0);
	    
	    if(clavier.getDEnfoncee())
		tg.translater(1,0);

	    // Affichage ou non des hitbox
	    if(clavier.getEspaceTape()){
		hitboxAffiche=!hitboxAffiche;
		if(hitboxAffiche){
		    for(int i=0;i<td.getHitbox().size();i++)
			f.ajouter(td.getHitbox().get(i));
		    for(int i=0;i<t2.getHitbox().size();i++)
			f.ajouter(t2.getHitbox().get(i));
		}else{
		    for(int i=0;i<td.getHitbox().size();i++)
			f.supprimer(td.getHitbox().get(i));
		    for(int i=0;i<t2.getHitbox().size();i++)
			f.supprimer(t2.getHitbox().get(i));
		}
	    }

	    // test d'intersection pour l'avion droit
	    if(td.intersection(r) || td.intersection(t2) || td.intersection(t3))
		r3.setCouleur(Couleur.ROUGE);
	    else
		r3.setCouleur(Couleur.VERT);

	    // test d'intersection pour l'avion gauche
	    if(tg.intersection(r) || tg.intersection(t2) || tg.intersection(t3))
		r2.setCouleur(Couleur.ROUGE);
	    else
		r2.setCouleur(Couleur.VERT);
	    
	    f.rafraichir();
	}
				
    }
}
