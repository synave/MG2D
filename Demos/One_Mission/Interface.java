import MG2D.geometrie.Point;
import MG2D.geometrie.Texture;


public class Interface extends Texture {
	
	 	int l=0;
		public int val;
		public int valeatoire;
		private int tr=3,ani=1;
		private Boolean activer=true;
		private Boolean mission=true;

		
/////constructeur
	public Interface(String image,Point a,int x,int y) {
		super("img/"+image,a,x,y);
	}
	
	public Interface(String image,Point a) {
		super("img/"+image,a);
	}
	
/////initialisation des variables pour la premiere boucle (pour rejouer sur le méme programme)
	public void initialisation(){
		 Game.vitesse = 60;
		 Game.s=0;Game.l=1;
		 Game.m=0;Game.niv=0;Game.p=0;Game.point_bonus=0;Game.point=50;
		 Game.o=0;Game.n=1;Game.mk=60;Game.lo=0;Game.report=4000;
		 Voiture.blife=0;Voiture.plife=0;Voiture.ennemi=0;
		 Game.activer=false;mission=true;
	}
//////activation de la 2éme mission avec le bouton D (NB : la mission s'active après le score en temps réel +1000 )
	public void mission(int score){
		if(Game.clavier.getD() && mission){
			Game.report=score;
			mission=false;
		}
	}
	
//répétition de la route	
	public void repetition(Interface route,int vitesse) {
	    if (this.getB().getY() <= 0 && vitesse !=0) {
	    	this.setA(new Point(0,route.getB().getY()));
	    	l++; //combien de tour par répétition
	    }
	    
	    if (route.getB().getY() <= 0 && vitesse !=0)	{
	       	route.setA(new Point(0,this.getB().getY())); 	
	    }
	}
	
// voiture qui bouge
	public void action(int vitesse){
		this.translater(0,-vitesse);
	}	
	
//changement de la route en 3 étapes pour garder le réalisme du map
	
	public void map(Interface r1,int b,int n1 ){

		if (r1.getB().getY() <=0 && Game.p==b )
			r1.setImg("img/Trans/route0"+(n1+2)+".jpg");
		
		if (r1.getB().getY() <=0 && Game.p==b+50)
			r1.setImg("img/Trans/route0"+(n1+1)+".jpg");
		
		if (this.getB().getY() <=0 && Game.p==b){
			this.setImg("img/Trans/route0"+(n1)+".jpg");
		}
	}

//animation sample
	public void animation_sample(String lien,int two){
		
	    if (ani<two){
			this.setImg("img/"+lien+ani+".png");
			ani++;
		}else if(ani==two){
			ani=1;
		}
	    
	}
//animation de la route pour le MENU (répétition de la route anti-incrémentation l=0) 
	public void menu(Interface route,int vitesse){
		this.repetition(route, vitesse);
		l=0;
	}
//////////////////////  notification  ///////////////////////////////// 
	public void info(Interface t,int score,int cb){
		if( Game.p>=score && score+500-cb>=Game.p){
			if(this.getA().getY()<0)
				this.translater(0,5);
			if(t.getA().getY()<0)
				t.translater(0,10);
		}else if(Game.p>score+600-cb && score+900-cb>=Game.p){
			if(this.getB().getY()>0)
				this.translater(0,-5);
			if(t.getB().getY()>0)
				t.translater(0,-10);
		}
	}
//// icon orbe pour la notification
	public void icon(int score){
		if( Game.p>=score && score+500>=Game.p){
			if(this.getA().getX()>=350)
				this.translater(-10,0);
		}
		if(Game.p>score+700 && score+1000>=Game.p){
			if(this.getA().getX()<=400)
				this.translater(+11,0);
		}
	}
//orbe de transformation en action et qui transforme
	public void orbe(int score,int var){
		
		if(Game.p>=score){    
			this.translater(0,val); 
	    if (this.getA().getY() < 200){ 
	    	val=var;
	    }else if(this.getB().getY()> 500 ){
	    	val=-var;
	    }
	    
	    if (tr>=3 && tr<=6){
			this.setImg("img/bot/0"+tr+".png");
			tr++;
		}else if(tr==7){
			tr=3;
		}
	    
	   }
	}
// Interface v2.0 pour la partie vaisseau changement de barre de score/lvl et implémentation de la
	  public void interfacev2 (int score,Interface lifeE , Interface lifeP,Interface Textera){	
	    	if (this.getA().getY() <600 && Game.p==score-50)
	    		this.translater(0,5);
	    	
	    	if ( Game.p>=score && score+50 >= Game.p  ){
	    			slow(23);
	    			Textera.setImg("img/bot/002.png");
	    		if (this.getB().getY() >605){
	    			this.setImg("img/bars2.png");
	    			this.translater(0,-5);
	    		}

	    		if(lifeE.getA().getX() >= 240)
	    			lifeE.translater(-10,0);
	    		if(lifeP.getA().getY() != 0)
	    			lifeP.translater(0,5);
	    	}
	    	
	    }

// des nuages ça fait du bien  
	  public void cloud(int score,Interface cloud02){
	    if(Game.p>=score){
	    	score_v2(score+50);
	        if (cloud02.getA().getY() == 0 && Game.vitesse !=0)	{
	        	this.setA(new Point(0,600));
	        }
	        
	        if (this.getA().getY() == 0 && Game.vitesse !=0)	{
	           	cloud02.setA(new Point(0,600)); 	
	        }
	        
	        this.translater(0,-10);
	        cloud02.translater(0,-10);
	   }
	 }
//Arrêter l'incrémentation du score et activer le mode bonus pour le 2éme jeu de vaisseau  
	  public void score_v2(int score){
		  if(Game.p>score){
	        	Game.point_bonus=Game.p;
	        	Game.point=0;
		  }
	  }
//slowwwwww
	public void slow(int v){
		Game.vitesse=v;
	}
//Bonus du jeu cadeau ( ajouté en dernière min  ><" )
	public void Bonus_Life(){
			  if(Voiture.ennemi==2 && activer){ //apres avoir gagner l'ennemi 1
				  
			  	Game.point_bonus=Game.point_bonus+2000-Voiture.plife*100;
			  	if(Voiture.plife == 2)
			  	Voiture.plife=1;
			  	if(Voiture.plife >2)
			  	Voiture.plife=Voiture.plife-2;
			  	if(Voiture.plife>=1)
			  	Game.lifeP.setImg("img/Life/0"+Voiture.plife+".png");
			  	activer=false;
			  	System.out.println("Score 1   :"+Game.p);
			  	
			  }else if(Voiture.ennemi==3 && !activer){  //apres avoir gagner l'ennemi 2
				  
			 Game.point_bonus=Game.point_bonus+6000-Voiture.plife*200;
			  	if(Voiture.plife == 2)
			  	Voiture.plife=1;
			  	if(Voiture.plife >2)
			  	Voiture.plife=Voiture.plife-2;
			  	if(Voiture.plife>=1)
			  	Game.lifeP.setImg("img/Life/0"+Voiture.plife+".png");
				activer=true;
				System.out.println("Score 2   :"+Game.point_bonus);
				
			  }else if(Voiture.ennemi==4 && activer){ //apres avoir gagner l'ennemi 3  (Fin du Jeu)
				 Game.point_bonus=Game.point_bonus+10000-Voiture.plife*300;
				activer=false;
				System.out.println("--------------------------");
				System.out.println("Score Final:"+Game.point_bonus);
				System.out.println("--------------------------");
			  }
			  
	}
	
}


