import java.util.Random;

import MG2D.geometrie.BoiteEnglobante;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;

public class Voiture extends Texture {	
	
	private int val;
	private Random r = new Random(); 
	private int valeatoire;
	private int t=0,o=0,n=1;
	static int blife=0,plife=0,ennemi=0,bonus=100;
	private int x,y,xe,ye;
	private int varD=345,varG=70;
	private boolean a1=true,armeE=false,arme=true;
	
	
/////constructeur	
	public Voiture() {
	}
	
	public  Voiture(String image,Point a) {
		super("img/"+image,a,50,100);
		 
	}
	
	public  Voiture(Point a,String image) {
		super("img/"+image,a); 
	}
	
////////Méthode
	
	//controle d'avion et voiture
	public void controle(int vitesse,boolean activer){
		//activer le controle ajuster à l'avion
		if(activer){
			varD=400;
			varG=0;
		}	
		
					x=0;
					y=0;
			// Bouton Gauche et Droite
			if(Game.clavier.getDroite())
			{
				if (this.getB().getX()>varD )
					x=0;
				else
					x=10;	
			}
				
			if(Game.clavier.getGauche()){
				if (this.getA().getX()<varG )
					x=0;
				else
					x=-10;
			}
			
			// Bouton Haut et Bas
			if(Game.clavier.getHaut()){
				if(this.getB().getY() <= 300)
					y=+7;
				else
					y=0;
			}
			
			if(Game.clavier.getBas()){
				if(this.getA().getY() >=0)
					y=-7;
				else
					y=0;
			}	
			
		this.translater(x,y); 	
	}
	
		//	répétition de voiture
	public void reload(Voiture v01 , Voiture v02,int score){
		
	    if (this.getB().getY() <= 0 && score+750 >= Game.p  ){ 
	    	
	    do{	
	    	this.valeatoire = (r.nextInt(233));
	    }while( v01.val-50< this.valeatoire && this.valeatoire< v01.val+50 ||
	    		v02.val-50 < this.valeatoire && this.valeatoire< v02.val+50 );
	    	
	    	this.translater(-val,0); 
	    	this.translater(valeatoire,690); 
	    	this.val = valeatoire;
	    	
	    }
	    this.effacer(score); 
	}
	
	
	//bouger
	public void action(int var){
		this.translater(0,-var);
	}
	
	//Turbo (Espace)
	public void turbo (){
		if(Game.clavier.getEspace() && t==0){
			 t = 1;
			 Game.vitesse=120;
			// Game.stop =false;
		}else if (!Game.clavier.getEspace()){
			t=9;
			Game.vitesse=60;
		}
		
		if (t>=1 && t<=7){
			this.setImg("img/transformation/0"+t+".png");
			t++;
		}else if(t==8){
			this.setImg("img/transformation/final.png");
			t=5;
		}else if(t==9){
			this.setImg("img/voiture.png");
			t=0;
		}
	}
	

	// Transformation de la voiture
	public void transformation(boolean activer,int a){
	  	if(activer && n!=a){
	  		o++;
	  		if (o%3==0 ){
	  			this.setImg("img/ultranimation/0"+n+".png");
	  		if(n<a)
	  			n++;
	  		else
	  			n=a;
	  		}
	  	}
	}
	
	//Ennemi de l'objet ennemi01
	
	  public void ennemi_start(int score){
		  
		  //faire bouger le vaisseau adversaire 
		  valeatoire = (r.nextInt(12));
	    	if(Game.p>=score && blife!=13 ){	
	    	if(this.getA().getY() <= 400){
	    		ye=1;
	    		if(a1==true){
	    			xe=-5-valeatoire;
	    		if(this.getA().getX() < 0)
	    			a1=false;
	    		}
	    	}
	    		
	    	if(this.getB().getY() >= 600)
	    		ye=-1;
	    	
	    	if (a1==false){
	    		if(this.getA().getX() <= 0)
	    			xe=5+valeatoire;
	    		if(this.getB().getX() >=400)
	    			xe=-5-valeatoire;
	    	}

	    	this.translater(xe,ye);
	    	}
	    	// vaisseau ennemi qui abandonne le terrain
	    	if (blife==13 && this.getA().getY()<601){
	    		if(a1==true){
	    			x=4;
	    			a1=false;
	    		}
	    		else{
	    			x=-4;
	    			a1=true;
	    		}
	    			this.translater(x,valeatoire/4);	
	    	}
	    	this.ennemi();//chagement d'ennemi
	  }  
	  
	  //chagement d'ennemi
	  public void ennemi(){
		 if(blife==13 && this.getA().getY()>=600 && ennemi==1){ // Ennemi 02
			  this.setImg("img/ennemi/02.png");
			  Game.lifeE.setImg("img/Life/lifeE.png");
			  blife=-1;
			  ennemi=2;
			  
		}else if(blife==13 && this.getA().getY()>=600 && ennemi==2){ //Ennemi 03
			  this.setImg("img/ennemi/03.png");
			  Game.lifeE.setImg("img/Life/lifeE.png");
			  blife=-1;
			  ennemi=3;
			  
		}else if (this.getA().getY()>=600 && ennemi==0){
			  ennemi=1;
		}
	  }

/////////////	Arme ennemi et joueur
	  
	  // arme de chaque ennemi et leur Bonus 
	  public void arme_ennemi(Voiture ennemi01,Voiture player,BoiteEnglobante pl01){		 		
		  this.recharger_arme(ennemi01,player);
		 switch (ennemi){
		 	case 1:
		 		this.arme1(pl01,player);
		 		bonus=100;
		 		break;
		 		
		 	case 2:
		 		this.arme2(pl01,player);
		 		bonus=200;
		 		break;
		 	case 3:
		 		this.arme3(pl01,player);
		 		bonus=300;	
		 		break;
		 }
	  }

	  //recharger l'arme (une balle envoyée doit retourner au dessous du vaisseau)
	  public void recharger_arme(Voiture ennemi01,Voiture player){
		  if(ennemi01.getA().getX() + ennemi01.getLargeur()/3 <= player.getA().getX() + player.getLargeur()/2  &&
					ennemi01.getA().getX() + 2*ennemi01.getLargeur()/3 >= player.getA().getX() + player.getLargeur()/2
						 && !armeE  ){
					 if(ennemi01.getB().getY()<601){
						 if(ennemi==1 || ennemi==3)
						 this.setA(new Point((ennemi01.getA().getX() + ennemi01.getB().getX()-this.getLargeur())/2 , (ennemi01.getA().getY()+ ennemi01.getB().getY()-this.getHauteur())/2));
						 if(ennemi==2 || ennemi==3){
						 Game.armeE02.setA(new Point((ennemi01.getA().getX() + ennemi01.getB().getX()-this.getLargeur())/2 , (ennemi01.getA().getY()+ ennemi01.getB().getY()-this.getHauteur())/2));
						 Game.armeE03.setA(new Point((ennemi01.getA().getX() + ennemi01.getB().getX()-this.getLargeur())/2 , (ennemi01.getA().getY()+ ennemi01.getB().getY()-this.getHauteur())/2));
						 }
						 armeE=true;
					 }
				 }
	  }

////////arme ennemi 01   //---> une ball qui suit le joueur
	  public void arme1(BoiteEnglobante pl01,Voiture player){
			if(armeE){
				
				if(player.getA().getX()+50>this.getA().getX())
					this.translater(+3,-6);
					else if(player.getA().getX()+50<this.getA().getX())
					this.translater(-3,-6);
					else
					this.translater(0,-10);
				
				this.life_player(pl01,player,1);
				this.arme_initialisation(pl01);

			if(this.getB().getY()<-100 && Game.armeE02.getB().getY()<-100 && Game.armeE03.getB().getY()<-100) {
				armeE=false;
			}
			}
	  }
///////arme ennemi 02  //---> 2 balle  qui rebondit
	  
  	  public void arme2(BoiteEnglobante pl01,Voiture player){			
	  if(armeE){
		  if(Game.armeE02.intersection(Game.armeE03)){
				this.x=-10;
				this.xe=10;
		  }
			if(Game.armeE02.getA().getX() <=0 )
				this.x=10;
			if(Game.armeE02.getB().getX() >=400 )
				this.x=-10;

			if(Game.armeE03.getA().getX() <=0 )
				this.xe=10;
			if(Game.armeE03.getB().getX() >=400 )
				this.xe=-10;
			
			Game.armeE02.translater(this.x,-8);
			Game.armeE03.translater(this.xe,-8);

			this.life_player(pl01,player,2);
			
			Game.armeE02.arme_initialisation(pl01);
			Game.armeE03.arme_initialisation(pl01);

		if(this.getB().getY()<-100 && Game.armeE02.getB().getY() <-100 && Game.armeE03.getB().getY()<-100) {
			armeE=false;
		}
		
	}
}			



/////arme ennemi (3)   //---> balle qui se sépare puis elle se dirige en parallèle 
  	public void arme3(BoiteEnglobante pl01,Voiture player){			
  		  if(armeE){
  			  if(Game.armeE02.intersection(Game.armeE03)){
  					this.x=-5;
  					this.xe=5;
  			  }

  				if(Game.armeE02.getB().getY() <= 300 )
  					this.x=0;
  				if(Game.armeE03.getB().getY() <= 300 )
  					this.xe=0;
  				
  				this.translater(0,-10);
  				Game.armeE02.translater(this.x,-10);
  				Game.armeE03.translater(this.xe,-10);

  				this.life_player(pl01,player,3);

  				this.arme_initialisation(pl01);
  				Game.armeE02.arme_initialisation(pl01);
  				Game.armeE03.arme_initialisation(pl01);

  			if(this.getB().getY()<-100 && Game.armeE02.getB().getY() <-100 && Game.armeE03.getB().getY()<-100) {
  				armeE=false;
  			}
  			
  		}
  	}		

//initialisation de la balle pour éviter l'exception de la methode setA()

	public void arme_initialisation(BoiteEnglobante pl01){
			if((this.getB().getY()<0 && this.getB().getY()>=-100) || this.intersection(pl01)){
				this.translater(-550, -300);
			}
	}

//barre de vie Joueur
	  public void life_player(BoiteEnglobante pl01,Voiture player,int typearme){
	  			 switch (typearme){
		 	case 1:
		    if((this.intersection(pl01)) && plife !=9){
			    if(plife<8 )
			    	plife++;
				Game.lifeP.setImg("img/Life/0"+plife+".png");
			}	
		 		break;
		 	case 2:
		    if((Game.armeE02.intersection(pl01) || Game.armeE03.intersection(pl01)) && plife !=9){
			    if(plife<8 )
			    	plife++;
				Game.lifeP.setImg("img/Life/0"+plife+".png");
			}
		 		break;
		 	case 3:
		    if((this.intersection(pl01) || Game.armeE02.intersection(pl01) || Game.armeE03.intersection(pl01)) && plife !=9){
			    if(plife<8 )
			    	plife++;
				Game.lifeP.setImg("img/Life/0"+plife+".png");
			}
		 		break;
	  			 }
		 }
	  
////// arme du joueur
	  public void arme_player(Voiture ennemi01,Voiture player,BoiteEnglobante en01){
		    if(Game.clavier.getEspace() && arme && ennemi01.getB().getY()<601){
		    	this.setA(new Point((player.getA().getX() + player.getB().getX()-this.getLargeur())/2 , (player.getA().getY()+player.getB().getY()-this.getHauteur())/2));
		    	arme=false;
		    }
		    
		    if(!arme){
		
		    	this.translater(0,15);
		        if(this.intersection(en01) && blife !=13){
		    	    if(blife<13 )
		    	    	blife=blife+2;
		    		if(blife>13)
		    			blife=13;
		    		Game.point_bonus=Game.point_bonus+bonus;
		    		Game.lifeE.setImg("img/Life/00"+blife+".png");
		    }
		    	if(this.getA().getY()>600 ||this.intersection(en01)){

		    		this.translater(-250, -800);
		    		arme=true;
		    	}
		    }
	  }

//////augmenter la vie du joueur avec la touche Q  (triche)
	  public void uplife(){
		  if(Game.clavier.getQ())
			  plife=0;  
	  }
	
/////// supprimer l'affichage de la voiture
	  
	public void effacer(int score){
		if(score+750 >= Game.p && score <= Game.p)
			Game.fenetre.supprimer(this);
	}
}
