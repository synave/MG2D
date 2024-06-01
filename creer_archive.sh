#!/bin/bash

if [ $# -ne 1 ]
then
    echo "usage : $0 <numero de version>"
    exit
fi

version=$1

if [ -e "MG2D_"$version ]
then
    echo "MG2D_"$version" existe déjà."
    exit
fi

if [ -e "MG2D_"$version".zip" ]
then
    echo "L'archive MG2D_"$version".zip existe déjà."
    exit
fi

repertoire="MG2D_"$version

archive=$repertoire".zip"

echo "test_ok"

mkdir $repertoire

make doc

cp -r AUTHOR build.xml COPYING Demos doc_MG2D installation_de_la_bibliotheque jlayer1.0.1.tar.gz license logo.png MG2D README.md TP_Prise_en_main $repertoire

rm -rf doc_MG2D

rm -rf $repertoire/TP_Prise_en_main/images $repertoire/TP_Prise_en_main/tp_prise_en_main.tex $repertoire/MG2D/audio/BruitageATester.java $repertoire/MG2D/audio/MusiqueATester.java

zip -r $archive $repertoire

rm -rf $repertoire

mv $archive anciennesVersions
