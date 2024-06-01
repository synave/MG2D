# Script créer par VOITURIER Noa

# Vérifier si le fichier MG2D_2.9.zip existe dans le répertoire courant
if [ ! -f "MG2D_2.9.zip" ]; then
    # Téléchargement de MG2D_2.9.zip
    wget http://185.185.43.66:27010/ressource/MG2D_2.9.zip
    echo "Fichier MG2D_2.9.zip téléchargé."
else
    echo "Fichier MG2D_2.9.zip détecté."
fi

# Décompression du fichier zip
echo "Décompression de MG2D_2.9.zip..."
unzip MG2D_2.9.zip

# Déplacement de MG2D dans le répertoire personnel
mv MG2D_2.9/MG2D ~
echo "Dossier déplacé."

# Ajout de la ligne dans le fichier bashrc

if ! grep -q "export CLASSPATH=\$CLASSPATH:.:~" ~/.bashrc; then
    echo "export CLASSPATH=\$CLASSPATH:.:~" >> ~/.bashrc
    echo "Variable d'environnement modifiée."
else
    echo "Variable d'environnement déjà modifiée."
fi
# Afficher fin de l'installation et attendre une touche pour quitter
echo "Fin de l'installation. Merci de quitter le terminal en appuyant sur une touche."
