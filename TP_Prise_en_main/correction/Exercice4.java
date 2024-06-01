import MG2D.*;
import MG2D.geometrie.*;



class Exercice4{
    public static void main(String[] args){
	int vitesse = 1; 
	Fenetre f = new Fenetre("Exercice 4", 800, 600);
	Clavier clavier = f.getClavier();
	Souris souris = f.getSouris();
	Cercle roueG = new Cercle(Couleur.NOIR, new Point(100,200), 20, true);
	Cercle roueD = new Cercle(Couleur.NOIR, new Point(300,200), 20, true);
	Rectangle caisse = new Rectangle (Couleur.GRIS_FONCE, new Point(60,200), new Point(340,240), true);
	Rectangle vitreMilieu = new Rectangle (Couleur.GRIS, new Point(160,240), new Point(240,280), true);
	Triangle vitreArriere = new Triangle (Couleur.GRIS_CLAIR, new Point(160,280), new Point(60,240), new Point(160,240), true);
	Triangle vitreAvant = new Triangle (Couleur.GRIS_CLAIR, new Point(240,280), new Point(240,240), new Point(280,240), true);
	f.ajouter(caisse);
	f.ajouter(vitreMilieu);
	f.ajouter(vitreArriere);
	f.ajouter(vitreAvant);
	f.ajouter(roueG);
	f.ajouter(roueD);
	
	f.rafraichir();

	

	while(true){
	    try{
		Thread.sleep(40);
	    }catch(Exception e){}
	    if(clavier.getHaut())
		vitesse++;
	    if(clavier.getBas() && vitesse>0)
		vitesse--;
	    if(souris.getClicGauche())
		if(caisse.getCouleur().equals(Couleur.GRIS_FONCE))
		    caisse.setCouleur(Couleur.ROUGE);
		else
		    caisse.setCouleur(Couleur.GRIS_FONCE);
	    roueG.translater(vitesse,0);
	    roueD.translater(vitesse,0);
	    caisse.translater(vitesse,0);
	    vitreMilieu.translater(vitesse,0);
	    vitreArriere.translater(vitesse,0);
	    vitreAvant.translater(vitesse,0);
	    if(caisse.getB().getX()>700){
		roueG.setO(new Point(100,200));
		roueD.setO(new Point(300,200));
		caisse.setA(new Point(60,200));
		caisse.setB(new Point(340,240));
		vitreMilieu.setA(new Point(160,240));
		vitreMilieu.setB(new Point(240,280));
		vitreArriere.setA(new Point(160,280));
		vitreArriere.setB(new Point(60,240));
		vitreArriere.setC(new Point(160,240));
		vitreAvant.setA(new Point(240,280));
		vitreAvant.setB(new Point(240,240));
		vitreAvant.setC(new Point(280,240));
		f.snapShot();
	    }
	    f.rafraichir();
	}
    }
}
