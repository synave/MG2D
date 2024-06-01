import MG2D.*;
import MG2D.geometrie.*;

class DynamismeContinu{

    public static void main(String[] args){
	Fenetre f = new Fenetre ("Mon appli MG2D", 800, 600);
	Clavier clavier = f.getClavier();

	Cercle c = new Cercle (Couleur.BLEU, new Point (200,100),5,true);
	f.ajouter(c);

	while(true){
	    try{
		Thread.sleep(40);
	    }
	    catch(Exception e){}

	    int x = c.getO().getX()-200;
	    int y = c.getO().getY()-100;
	    x=(x+2)%400;

	    if(clavier.getHaut()){
		y=(y+50)%500;
	    }

	    c.setO(new Point(x+200,y+100));
	    f.rafraichir();
	}
    }

}
