package MG2D;

public abstract class ApplicationMG2D{

    // Temps d'attente entre le rafraichissement
    // de deux images consécutives. FPS = (1/delay)*1000
    private int delay;
    private Fenetre fenetre;

    public ApplicationMG2D(){
	fenetre = new Fenetre();
	this.delay = 40;
	// une image toutes les 40 ms
	// Donc 25 image/seconde
    }

    public ApplicationMG2D(String titre, int largeur, int hauteur){
	fenetre = new Fenetre(titre, largeur, hauteur);
	this.delay = 40;
    }

    public ApplicationMG2D(String titre, int largeur, int hauteur, int delay){
	fenetre = new Fenetre(titre, largeur, hauteur);
	this.delay = delay;
    }

    public Fenetre getFenetre(){
	return fenetre;
    }

    public Clavier getClavier(){
	return fenetre.getClavier();
    }

    public Souris getSouris(){
	return fenetre.getSouris();
    }

    public void setDelay(int delay){
	this.delay = delay;
    }

    public void lancerApplication(){
	while(true){
	    try{
		Thread.sleep(this.delay);
	    }catch(Exception e){}
	    boucleDeJeu();
	    fenetre.rafraichir();
	}
    }
    
    public abstract void boucleDeJeu();
}
