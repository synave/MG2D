import java.awt.Color;
import java.awt.Font;


import MG2D.Clavier;
import MG2D.Fenetre;
import MG2D.Couleur;
import MG2D.geometrie.BoiteEnglobante;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texte;
import MG2D.geometrie.Texture;

public class Game {
	
	static int vitesse = 60;
	static int s=0,l=1;
	static int m,niv,p,point_bonus=0,point=50;
	static int o,n=1,mk=60,lo,report=4000;
	static boolean activer=false,play=true,mission=true;
	
	static Fenetre fenetre;
	static Interface lifeP,lifeE;
	static Clavier clavier;
	static Voiture armeE02;
	static Voiture armeE03;
	
	public static void main(String[] arg)
	{
		fenetre = new Fenetre("ONE-MISSION v0.0.9",400,600);
		fenetre.setAffichageFPS(true);
		
		//la grande Boucle While la mère des mères des grand-mères	
		while(play){

///////////	Image (Texture)
		
		Interface route01 = new Interface("route01.jpg",new Point(0,0));
		Interface route02 = new Interface("route02.jpg",new Point(0,route01.getB().getY()));
		Interface cloud01 = new Interface("cloud/01.png",new Point(0,600),400,600);
		Interface cloud02 = new Interface("cloud/02.png",new Point(0,1200),400,600);
		Interface bars = new Interface("bars.png",new Point(0,350),401,250);
		
		Interface bot = new Interface("bot/01.png",new Point(0,-125),370,125);
		Interface textera = new Interface("bot/02.png",new Point(0,-90),400,90);
		Interface orbe02 = new Interface("bot/03.png",new Point(150,750),62,62);
		Interface orbe01 = new Interface("bot/03.png",new Point(460,10),50,50);
		
		
		Voiture voiture = new Voiture("voiture.png",new Point(200,200));
		Voiture voiture01 = new Voiture("voiture01.png",new Point(61,-100));
		Voiture voiture02 = new Voiture("voiture02.png",new Point(61,-100));
		Voiture voiture03 = new Voiture("voiture03.png",new Point(61,-100));
		Voiture ennemi01 = new Voiture(new Point(130,700),"ennemi/01.png");
		
		lifeP = new Interface("Life/lifeP.png",new Point(0,-100));
		lifeE = new Interface("Life/lifeE.png",new Point(400,420));
		
		Texture gamerover = new Texture("img/gameover.png",new Point(0,0),400,600);
		
///////////		Font	
		Font arial = new Font("Arial", Font.BOLD, 23);
		Font arial2 = new Font("Arial", Font.BOLD, 47);
		Font arial0 = new Font("Arial", Font.BOLD, 14);
		
////////////	Texte	
		Texte score = new Texte (new Couleur(Color.BLACK), String.valueOf(s),arial,new Point(52,565));
		Texte lvl= new Texte (new Couleur(Color.BLACK), String.valueOf(l),arial2,new Point(346,565));
		Paragraphe p1= new Paragraphe(new Couleur(Color.BLACK), ".....................",arial0,new Point(230,50));
		Paragraphe p2= new Paragraphe (new Couleur(Color.BLACK),".....................",arial0,new Point(230,30));
		
////////////	Arme Player et Ennemi
		Voiture armeE01 = new Voiture(new Point(-200,-200),"arme/03.png");
				armeE02 = new Voiture(new Point(-200,-200),"arme/03.png");
				armeE03 = new Voiture(new Point(-200,-200),"arme/03.png");
		Voiture armeP01 = new Voiture(new Point(-200,-200),"arme/04.png");
	
		////////clavier
		clavier =fenetre.getClavier();
		
		//interface de MENU
		Interface game = new Interface("play/game.png",new Point(0,0));
		Interface play01 = new Interface("play/play01.png",new Point(74,119));

		//initialisation
			lifeP.initialisation();
///////////////////		Affichage (1)
			

		fenetre.ajouter(route01);
		fenetre.ajouter(route02);		
		fenetre.ajouter(play01);
		fenetre.ajouter(game);
		
///////////////// MENU GAME //////////////////////////////////
		
		while(play){//boucle de Menu
			play01.animation_sample("play/play0",4);
			if(clavier.getEntree()){
				fenetre.supprimer(play01);
				fenetre.supprimer(game);
				play=false;
			}
			route02.menu(route01,vitesse);
			route01.action(vitesse);
			route02.action(vitesse);
			//rafraichir
			   fenetre.rafraichir(); 
			try {
			// sieste long
				Thread.sleep(30,60);
			} catch (Exception e) {
				
			}
		}
///////////////////////////////////////////////////////////		
///////////////////		Affichage (2)	//////////////////	
//////////////////////////////////////////////////////////		
		
		//nuage
		fenetre.ajouter(cloud01);
		fenetre.ajouter(cloud02);
		//voiture ennemi 
		fenetre.ajouter(voiture01);
		fenetre.ajouter(voiture02);
		fenetre.ajouter(voiture03);
		
		// arme vaisseau
		fenetre.ajouter(armeE01);
		fenetre.ajouter(armeE02);
		fenetre.ajouter(armeE03);
		fenetre.ajouter(armeP01);
		
		//vaisseau 
		fenetre.ajouter(voiture);// voiture du joueur qui ce transforme en vaisseau 
		fenetre.ajouter(ennemi01);
		
		//barre de vie
		fenetre.ajouter(lifeP);
		fenetre.ajouter(lifeE);
		
		//barre score et level
		fenetre.ajouter(bars);
		fenetre.ajouter(score);
		fenetre.ajouter(lvl);
		
		//notification
		fenetre.ajouter(textera);
		fenetre.ajouter(bot);
		fenetre.ajouter(orbe01);
		fenetre.ajouter(orbe02);
		
////-----------------------------------------------------------/
///-----------------------------------------------------------/
//-----------------------------------------------------------/		
		
		while(!play)
		{

//////////	  Activation de la mission avion
			
			game.mission(p);
			
//////////    BoiteEnglobante des voitures 
		
		   BoiteEnglobante v01= new BoiteEnglobante(new Point(voiture01.getA().getX()+7,voiture01.getA().getY()+5),new Point(voiture01.getB().getX()-8,voiture01.getB().getY()-10));
		   BoiteEnglobante v02= new BoiteEnglobante(new Point(voiture02.getA().getX()+7,voiture02.getA().getY()+5),new Point(voiture02.getB().getX()-8,voiture02.getB().getY()-10));
		   BoiteEnglobante v03= new BoiteEnglobante(new Point(voiture03.getA().getX()+7,voiture03.getA().getY()+5),new Point(voiture03.getB().getX()-8,voiture03.getB().getY()-10));
		   BoiteEnglobante car0= new BoiteEnglobante(new Point(voiture.getA().getX()+6,voiture.getA().getY()+9),new Point(voiture.getB().getX()-10,voiture.getB().getY()-15));
		   

/////// 	GameOver   		/////////////////////////
		if ((car0.intersection (v01) || car0.intersection (v02) || car0.intersection (v03) 
			 || (!activer && p==3000+report) || Voiture.plife == 8)){
			
				if(p==3000+report && !activer){////////////////////////////////////////// GameOver Transformation
					bot.info(textera,3000+report,0);
					p1.mission("échec de la mission:",3000+report,0);
					p2.mission("Orbe De Transformation ",3000+report,0);
					orbe01.icon(3000+report);
				}
				
			if(vitesse !=0 && !activer && Voiture.ennemi!=4 && !clavier.getS()){///////// GameOver Par Defaut 
				vitesse=0;
				fenetre.ajouter(gamerover);
				fenetre.ajouter(bars);
				fenetre.ajouter(score);
				fenetre.ajouter(lvl);	
				
			}
			if(clavier.getEntree() && vitesse==0)//Bouton anti gameover pour le jeu de voiture
					play=true;
		}		
		
		// stopper tout !! 
		if (vitesse != 0)
		{
			route01.repetition(route02,vitesse);
			voiture.controle(vitesse,activer);
			if(!activer)
			voiture.turbo();//Mode Turbo
		}
			
////////// calcul score et level
				
		    //Score 
				p=((route01.l)*point+point_bonus);
				score.setTexte(String.valueOf(p));
				m=p%1000;
	    	
	    	//level
				if(m==0 && p!=0 ){
					niv = ((p/1000)+1);
					lvl.setTexte(String.valueOf(niv));
				}
	    	
///////////		répétitions des voitures ennemies

		voiture01.reload(voiture02,voiture03,3800+report);
		voiture02.reload(voiture01,voiture03,3800+report);
		voiture03.reload(voiture01,voiture02,3800+report);
			
////////	faire bouger les objets (voiture, route )
	
				if (vitesse <=60) //limiteur de vitesse (explication sur le rapport ) 
					mk=vitesse;
				
				if(niv<9){
	    		voiture01.action(mk/(30-3*niv)+vitesse/10);
	    		voiture02.action(mk/(20-2*niv)+vitesse/15);
	    		voiture03.action(mk/(35-4*niv)+vitesse/20);
				}
				route01.action(vitesse);
				route02.action(vitesse);
				
/////////	 changement de map
				
			route01.map(route02,1400+report,4);
			route01.map(route02,4450+report,1);
			
/////////	 ralenti de la cinématique
			
			if(p<4300+report && p>= 4400+report){
				vitesse=vitesse-10;
			if(vitesse<=0)
				vitesse=2;
			}
			if(p==4450+report){
					vitesse=vitesse+1;
				if(vitesse>=10)
					vitesse=10;
			}
///////////// 	notification des missions 
			
			// (1)
			bot.info(textera,1000+report,-100);
			p1.mission("Toucher l'orbe de transformation",1000+report,50);
			p2.mission("et cliquer sur ESPACE",1000+report,50);
			orbe01.icon(1000+report);
			
			// (2)
			
			bot.info(textera,3100+report,-50);
			p1.mission("La transformation",3100+report,50);
			p2.mission("est terminée avec succès",3100+report,50);
			orbe01.icon(3100+report);
			
			// (3)
			
			bot.info(textera,4000+report,50);
			p1.mission("Le pont a été détruit",4000+report,350);
			p2.mission("Par un ennemi non identifié",4000+report,350);
			p1.mission("Activation du mode combat...",4500+report,650);
			p2.mission("L'ennemi a été identifié ",4500+report,500);
			p2.mission("ANALYZING...",4400+report,600);
			
//////////////	activation de la transformation	voiture --> vaisseau et orbe de transformation /////////////////////
			
			if(!car0.intersection(orbe02) && !activer && vitesse!=0){ //orbe qui bouge
				orbe02.orbe(1200+report,5*vitesse/60);
					
			}else if (car0.intersection(orbe02) && clavier.getEspace()){  
				fenetre.supprimer(orbe02);//  disparition de l'orbe
				activer=true;//activation de la transformation
			}
			
			voiture.transformation(activer, 24); // Transformation

//////////////////  2éme partie  ////////////////////////
			
			bars.interfacev2(4600+report, lifeE , lifeP,textera); //changement de l'interface
		  	cloud01.cloud(4600+report, cloud02);	//activation des nuages
		  	ennemi01.ennemi_start(4600+report); // apparition de l'ennemi
		  	
		  	
		  	// activation des armes et la boite englobante 
		  	
		  	if(p>=4600+report){
		  		//BoiteEnglobante des vaisseaux  
				BoiteEnglobante en01= new BoiteEnglobante(new Point(ennemi01.getA().getX()+54,ennemi01.getA().getY()+54),new Point(ennemi01.getB().getX()-54,ennemi01.getB().getY()-54));
				BoiteEnglobante pl01= new BoiteEnglobante(new Point(voiture.getA().getX()+50,voiture.getA().getY()+20),new Point(voiture.getB().getX()-50,voiture.getB().getY()-20));
			
				//les armes 	
				armeP01.arme_player(ennemi01,voiture, en01);
				armeE01.arme_ennemi(ennemi01,voiture , pl01);
		  	}
		  	
		  	// UPlife avec le bouton >> Q <<
		  	voiture.uplife();
		  	
		  	//Bonus Sprcial !! <3
		  	lifeE.Bonus_Life();
		  	
		  	//Game OVER pour le jeu de vaisseau
		  	if (Voiture.plife==8){
		  		activer=false;
		  	}
		  	
			//You win pour le jeu de vaisseau (	Fin de jeu	)
			if(Voiture.blife==13 && ennemi01.getA().getY()>=600 && Voiture.ennemi==3 && vitesse!=0){
					Game.lifeP.setImg("img/play/youwin.png");
					fenetre.supprimer (bars);

					score.translater(70,-60);
					fenetre.supprimer (lvl);
					Voiture.ennemi=4;
			} else if(Voiture.ennemi==4){
				if(clavier.getEntree())
					play=true;// sortir de la boucle while
			}
		  	
	//rafraichir
	   fenetre.rafraichir(); 
	try {
	// sieste rapide
		Thread.sleep(30,60);
	} catch (Exception e) {
		
	}	
		}

		}
	}
}               
