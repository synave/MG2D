import MG2D.*;
import MG2D.geometrie.*;

class TestHitBox extends ApplicationMG2D{

    private Texture vaisseau;
    private GroupeHitbox gh;
    private Clavier c;
    private int vitesse;
    private Cercle ennemi;
    private double dx, dy;
    private Dessin hitbox;
    private Carre temoin;

    public TestHitBox(String str, int largeur, int hauteur, int delay){
	super(str, largeur, hauteur, delay);
	vitesse = 2;
	vaisseau = new Texture("img/vaisseau.png", new Point(100,100), 200, 200);
	this.getFenetre().ajouter(vaisseau);
	c = this.getClavier();
	ennemi = new Cercle(Couleur.ROUGE, new Point(15,450), 10, true);
	this.getFenetre().ajouter(ennemi);
	dx = 1;
	dy = 1;
	gh = new GroupeHitbox();
	gh.insertion(new Rectangle(new Point(50,75),100,50));
	gh.insertion(new Rectangle(new Point(75,50),50,100));
	vaisseau.changeFormeHitbox(gh);
	this.getFenetre().ajouter(gh);
	temoin = new Carre(Couleur.ROUGE, new Point(0,0), 10, true);
	this.getFenetre().ajouter(temoin);
    }

    public void initialisation(){
    }

    public void boucleDeJeu(){
	if(c.getQEnfoncee()) {vaisseau.translater(-vitesse, 0);}
	if(c.getDEnfoncee()) {vaisseau.translater(vitesse, 0);}
	if(c.getZEnfoncee()) {vaisseau.translater(0, vitesse);}
	if(c.getSEnfoncee()) {vaisseau.translater(0, -vitesse);}
	ennemi.translater(dx, dy);
	if(ennemi.getO().getX()-ennemi.getRayon() == 0) dx = 1;
	if(ennemi.getO().getX()+ennemi.getRayon() == 800) dx = -1;
	if(ennemi.getO().getY()-ennemi.getRayon() == 0) dy = 1;
	if(ennemi.getO().getY()+ennemi.getRayon() == 600) dy = -1;

	if(ennemi.intersection(gh)) temoin.setCouleur(Couleur.VERT);
	else temoin.setCouleur(Couleur.ROUGE);
    }

    public void finDeBoucle(){
    }
    
}
