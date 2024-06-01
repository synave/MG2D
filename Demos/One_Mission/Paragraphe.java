import java.awt.Font;

import MG2D.Couleur;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texte;


public class Paragraphe extends Texte {
	
/////constructeur
	public Paragraphe(Couleur couleur,String texte, Font police, Point a){
		super(couleur,texte,police,a);
	}
	
//////// texte de mission
	public void mission(String text,int score,int cb){
		
		if(Game.p==score){
			Game.fenetre.ajouter(this);
			this.setTexte(text);
		}else if(Game.p<=score+750-cb && Game.p>=score+700-cb ){
			Game.fenetre.supprimer(this);
		}
	}
	
}
