import MG2D.*;
import MG2D.geometrie.*;

class App extends ApplicationMG2D{
    private Rectangle r;
    private Fenetre f;
    Clavier clavier;

    public App(){
	super("ceci est une test", 1000, 500, 40);
	f = this.getFenetre();
	clavier = this.getClavier();
	r = new Rectangle(Couleur.ROUGE, new Point(10,10), new Point(100,100), true);
	f.ajouter(r);
    }

    public void boucleDeJeu(){
	r.translater(1,0);
	if(clavier.getHautEnfoncee())
	    r.translater(0,1);
	if(clavier.getQTape())
	    System.exit(0);
    }

    public static void main(String[] args){
	App bouge = new App();
	bouge.lancerApplication();
    }
}
