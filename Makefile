all : doc
	javac MG2D/*.java
	javac MG2D/geometrie/*.java
	javac MG2D/audio/*.java

doc : 
	javadoc -charset utf8 -d doc_MG2D MG2D/*.java MG2D/geometrie/*.java MG2D/audio/*.java

clean :
	rm -rf doc_MG2D MG2D/*.class MG2D/*~ MG2D/geometrie/*.class MG2D/geometrie/*~ MG2D/audio/*~ MG2D/audio/*.class MG2D/audio/*/*~ MG2D/audio/*/*.class MG2D/audio/*/*/*~ MG2D/audio/*/*/*.class
