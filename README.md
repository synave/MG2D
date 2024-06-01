# MG2D
Moteur graphique 2D très simple avec gestion des collisions (et en Français)
Développé à l'origine par un groupe d'étudiant de DUT info à Calais.




La bibliothèque MG2D a pour but le développement de jeux rétros facilement.
Elle offre la possiblité de créer des fenêtres ainsi que d'y ajouter des primitives géométriques, des textures et des images animées. MG2D permet également le contrôle des applications créées grâce au clavier et à la souris.
La bibliothèque est entièrement en Français ce qui permet une prise en main facilitée.

Pour une installation expliquée pas à pas, reportez vous au fichier installation_de_la_bibliotheque_sous_Linux. N'hésitez pas à jeter un oeil aux démos fournies se trouvant dans le répertoire Demos et à faire le TP de prise en main.


                             ''~``
                            ( o o )
    +------------------.oooO--(_)--Oooo.------------------+
    |                                                     |
    |                      Projet 2D                      |
    |          Moteur graphique 2D minimaliste            |
    |                                                     |
    +-----------------------------------------------------+
    |                                                     |
    | C'est désormais terminé, la deadline est atteinte ! |
    |                                                     |
    | Après plusieurs mois de codage intensif, nous voilà |
    | enfin au moment de lancer notre moteur dans le      |
    | monde sauvage de la notation ... :'(                |
    |                                                     |
    | C'est avec plaisir que l'Equipe 2D vous fournit ce  |
    | .zip et espère que vous passerez de bons moments à  |
    | programmer de petits jeux rétro !                   |
    |                                                     |
    | La bibliothèque javazoom a été utilisée pour la     |
    | partie son. http://www.javazoom.net                 |
    |                                                     |
    +-----------------------------------------------------+
    |                                                     |
    | Projet 2D                                           |
    | Version 2.85                                        |
    | 13 Janvier 2020                                     |
    |                                                     |
    | Développé par :                                     |
    |   - Anthony Desitter                                |
    |   - Nicolas Dubrunfaut                              |
    |   - Maxime Langa                                    |
    |   - Guillaume Langa                                 |
    |                                                     |
    |   - Rémi Synave                                     |
    |                                                     |
    +-----------------------------------------------------+
    |                                                     |
    | Les sources sont disponibles dans le dossier Demos. |
    |                                                     |
    | Les jeux sont disponibles dans les dossiers :       |
    |   - Kowasu Renga (casse-brique)                     |
    |   - Snake Eater (snake)                             |
    |   - Pong (le classique)                             |
    |   - One Mission (jeu de voiture et shoot'em up)     |
    |   - Space 420 (shoot'em up)                         |
    |                                                     |
    | Le dossier Test_MG2D contient tous les tests        |
    | relatifs au moteur MG2D.                            |
    |                                                     |
    +-----------------------------------------------------+
    |                                                     |
    | Nous tenons à remercier M. Synave, notre tuteur,    |
    | pour ses nombreux conseils et son aide précieuse    |
    | sans laquelle ce projet n'en serait pas arrivé là.  |
    |                                                     |
    | En espérant que vous apprécierez notre petite       |
    | surprise plus bas :)                                |
    |                                                     |
    +-----------------------------------------------------+
    |                                                     |
    | Historique des versions :                           |
    | - 0.1 : 19/03/2012                                  |
    | - 0.2 : 01/03/2013                                  |
    | - 0.3 : 01/09/2014                                  |
    | - 1.0 : 02/03/2015                                  |
    | - 1.1 : 27/01/2016                                  |
    | - 1.2 : 14/02/2016                                  |
    | - 1.3 : 14/02/2016                                  |
    | - 1.35 : 15/03/2016                                 |
    | - 2.0 : 20/03/2016                                  |
    | - 2.1 : 24/03/2016                                  |
    | - 2.2 : 05/04/2016                                  |
    | - 2.3 : 17/04/2016                                  |
    | - 2.4 : 21/10/2016                                  |
    | - 2.5 : 21/03/2017                                  |
    | - 2.6 : 10/04/2017                                  |
    | - 2.7 : 04/06/2017                                  |
    | - 2.8 : 28/06/2017                                  |
    | - 2.85 : 13/01/2020                                 |
    | - 2.9 : 17/04/2020                                  |
    |                                                     |
    |                    .oooO                            |
    |                    (   )   Oooo.                    |
    +---------------------\ (----(   )--------------------+
                           \_)    ) /
                                 (_/









                                      _____
                                     .-~~     ~~~~--......___
                                    <  |-.                   ~~--._
                                    |  |  ~T-....______     ______ `.
                                    |  |   |       .   ~~~~~      ~~~
                                    |  |   `.     /    -~~-.
                                    |  |  . |   .'    '             /`.
                                    :  |  | |   |    '            ,' ,.`.
                                    \  |  | /   | ,''            / ,' \  ~-.
                                     \  . |`-~~--L |.--.       ,'     /.   `
                              ____  ,'\ >  .~.'   ~`'   `~-.  /   ,  / >    `.
                            /~   _\/   `' '  |           .  \/  ,' .'.~,\    `.
                           /   ,d#b    / '   |           `     '.-~~~,'  >    `m.
                           \  m####b  | '    `            |    ~~~~-<  ,d#.    "##
                         ,-~' ######b ||   |  `           `          \d"d#b      Y
                          ~:  #######b|:   `\  `         ` :          "d###b      .
                           | d########b\    \\  `.        :|           "####b     :
                           ' ##########b     \`-.  .      |`.:          "####b     .
                          ;  ###########\     `--`=`.\     .||          |#####b    |
                         :   ###########b\ :      __  .   '|;|      \   d######\   |
                          \.'############/.`   .-~ \-.|  /./,'      .' d######P `  |
                           ; ###########P | \  ;,b `~|; /,'~`      ,',d######P   | |
                          < :"#########P  '  : \ /.  |,' T~|/ , +-~ db"#####P    | |
                           ~| ########P ,'   '  `-'  ~   P ; /  |  d#######P      \|
                             ~`#####P' /    /           <'  <   `~""######P
                               `###P ,'    <          `.`- / ;  |    "###P..
                            __  "#P /     / \      ._ /   | .   `.    ##P__ ~7~
                         .-~  ~--~\/    ,'/ ,`     | '   _| |     \ -_ P~  ~-'
                        '~\_.-~~7\/    / |L/. `.   `'  .-`  |`.   \`.  ~~~.
                          ~    / |    .| '|-/   `.  .-~\  \\ \_`-. \`  \`.|
                              /  /`.  |_\\\_\.-...~~<__.\  \`-.~~ `-|   | \
                             '~., ##m##"      \  oo. .'  `.~~T~ ~~~/:-. | |
                               |  ###P   .'   |_|88)mmmm'-~  |    / | | /,'
                                  ##"    :   dd##>"""####b~-. .  /  | ;-
                                  |      :  d###P     ~"~~   > `<  ,'/
                                  |      `./"#P~        |   /    \  ~
                                  |       /  |          ;  /      |
                                  `      /   |      |     .       |
                                   \    /    |      |  :  '       '
                                    \  ; /`.  \     \  ','       ,
                                     \| '   `.  \  | `./        .
                                      |/      `--._;_ /   ._ _.+'
                                      |             /`-..   ~  |
                                       \           |   ,'      |
                                        `.          \,'/       |
                                          `._      ,' /        |
            _...---.._                      \.       /_        |
           ,'          ~~"--..                ~     /~ ~-_     ;
          /                   ~"-._            \   /      T.  .
         /                         ~-.         |  /       `8bd8
        /              .              `-.      | '         8888
        \             -.\                `-.    '`.        8888b
         \              ~-.                 `-.   |   :   d8888P\
      ,-~~\                ~.                  `. |   ;  d8888P  \
     /     \                 `.                 .~'.    d8888P    \   _.,_
    .       \                  `.               `.  `. d8888P      \-~  ~ ~-.
    |        \                   .               |    <8888P        \        ~-.
    |         \                   \              |     \88P .        \         |
     .         `.                  \             |     |`P-~          .        \
                 \                  \            |     |              |        .'
      `           `.                 \           |     |              |        >
       `           \.                 \          |     |              |        '
        `           \`.                \         '     |              ;       ~;
         .           \ -.               \       '      '             .        /
         `               -.              \     '      :              ;      /~
          .           `    -              \  .'       '             .~-.  /~
          `            \    ~-             \~        /              ;   ~~
           `            .     ~.            \     _-~              /
            .            \      -_           \  .-                /
            `                    _-           \~                .'
             .            |`.---~  ~.          \              _-
             `            |  `.___.-~\          \         _.-~
              .           |    `.     \          \~-.__.-~
              `           |      `-.   `.         \
               `          `         ~~---\         \
                .          .              `.        `.
                `          :                \         `.
                 \         `                 \          `.
                  \         .                 `.         `~~-.
                   \        :                   `         \   \
                    .        .                   \         : `.\
                    `        :                    \        |  | .
                     \        .                    \       |  |
                      \       :                     \      `  |  `
                       .                             .      | |_  .
                       `       `.                    `      ` | ~.;
                        \       `.                    .      . .
                         .       `.                   `      ` `
                         `.       `._.                 \      `.\
                          `        <  \                 `.     | .
                           `       `   :                 `     | |
                            `       \                     `    | |
                             `.     |   \                  :  .' |
     "Super-Idol Misty May"   `     |    \                 `_-'  |
       (from "Otaku no         :    | |   |                 :    ;
         Video [1985]")        `    ; |~-.|                 :    '
         --- Dov Sherman        :   \ |                     `   ,
                                `    \`                      :  '
                                 :    \`                     `_/
                                 `     .\
                                  `    ` \
                                   \    | :
                                    \  .'  :
                                     T~    :
                                     |    .'
                                     |    :
                                     |    '
                                     |   /
                                     `_.' 
