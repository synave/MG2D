package MG2D;

/**
 * Cette classe permet a la création d'une application MG2D avec un taux de rafraichissement précis. 
 * <br /><br />
 * Cette classe sert a un developpement plus efficace d'une appli MG2D.<br />
 * L'utilisateur aura a créer son aplication en héritant de celle-ci et d'ajouter son code dans 'boucle de jeu'
 * L'utilisateur peut définir le taux de rafraichissement de l'application (par défaut 40).<br />
 * @author Equipe 2D, Rémi Synave, Léothen Dusannier
 * @version 1.1
 */
public abstract class ApplicationMG2D{

    // Attribut //

    private int numCollisionLayer = 12;

    // Temps d'attente entre le rafraichissement
    // de deux images consécutives. FPS = (1/delay)*1000
    private int delay;
    protected Fenetre fenetre;

    private boolean jeuEnCours = true;

    // Constructeur //

    /**
     * Crée un application vide.
     */
    public ApplicationMG2D(){

        fenetre = new Fenetre();
        this.delay = 40;
        // une image toutes les 40 ms
        // Donc 25 image/seconde
    }

    /**
     * Crée une application avec un nom de fenetre ainsi que des dimensions précises
     * @param titre Le nom de l'application
     * @param largeur La largeur de la fenetre de l'application
     * @param hauteur La gauteur de la fenetre de l'application
     * @see Fenetre
     */
    public ApplicationMG2D(String titre, int largeur, int hauteur){
        fenetre = new Fenetre(titre, largeur, hauteur);
        this.delay = 40;
    }

    /**
     * Crée une application avec un nom de fenetre ainsi que des dimensions précises et un taux de rafraichissement précis.
     * @param titre Le nom de l'application
     * @param largeur La largeur de la fenetre de l'application
     * @param hauteur La gauteur de la fenetre de l'application
     * @param delay Le taux de rafraichissement souhaiter
     * @see Fenetre
     * @see Fenetre#rafraichir
     */
    public ApplicationMG2D(String titre, int largeur, int hauteur, int delay){
        fenetre = new Fenetre(titre, largeur, hauteur);
        this.delay = delay;
    }

    // Accesseurs //

    // Getter //

    /**
     * Retourne la fenetre de l'application.
     * @return Fenetre type 
     * @see Fenetre
     */
    public Fenetre getFenetre(){
        return fenetre;
    }

    /**
     * Retourne le clavier de l'application.
     * @return Clavier type 
     * @see Clavier
     */
    public Clavier getClavier(){
        return fenetre.getClavier();
    }

    /**
     * Retourne la souris de l'application.
     * @return Souris type 
     * @see Souris
     */
    public Souris getSouris(){
        return fenetre.getSouris();
    }

    /**
     * Fixe le nouveau taux de rafraichissement.
     * @param delay le temps en ms entre deux rafrachissement de la fenêtre.
     */
    public void setDelay(int delay){
        this.delay = delay;
    }

    // Méthodes //

    /**
     * Appel la fonction de boucleDeJeu.<br />
     * Le nombre d'appel a la fonction de boucleDeJeu se fais toute les x secondes, ce nombre étant préciser par le taux de rafraichissement préciser 
     * @see ApplicationMG2D#boucleDeJeu
     */
    public void lancerApplication(){
        initialisation();

        while(jeuEnCours){
            try{
            Thread.sleep(this.delay);
            }catch(Exception e){}

            boucleDeJeu();
            fenetre.rafraichir();
        }

        finDeBoucle();        
    }
    
    /**
     * Ici devra se trouver tout les éléments du code qui doivent etre constament mis a jour pour le bon fonctionnement du jeu.     
     */
    public abstract void boucleDeJeu();

    /**
     * Ici devra se trouver les éléments qui devront etre initialiser au début de la boucle
     */
    public void initialisation(){
        // Implémentation par défaut 
    }

    /**
     * Ici devra se trouver les éléments qui devront avoir lieux une fois que la boucle de jeu se termine
     */
    public void finDeBoucle(){
        // Implémentation par défaut
	System.exit(0);
    }

    /**
     * Permet de mettre fin au jeu 
     */
    public void arretApplication(){
        jeuEnCours = false;
    }

}
