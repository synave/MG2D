import MG2D.*;
import MG2D.geometrie.*;

class DynamismeNonContinu{

    public static void main(String[] args){
	Fenetre f = new Fenetre ("Mon appli MG2D", 800, 600);
	Souris souris = f.getSouris();

	int indice=0;
	while(true){
	    System.out.println("indice : "+indice);
	    while(!souris.getClicGauche()){
		try{
		    Thread.sleep(1);
		}
		catch(Exception e){}
	    }
	    System.out.println(souris.getPosition().getX()+ " " + souris.getPosition().getY());
	    f.ajouter(new Cercle (Couleur.BLEU, new Point (souris.getPosition()),5,true));
	    f.rafraichir();
	    indice++;
	}
    }
}
