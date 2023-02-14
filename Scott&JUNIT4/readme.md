# Scott & Junit4



Scott est un outil pour les tests, qui permet de remonter la stack en affichant les valeurs des variables et des paramètres au long de l'exécution du test.


## Installation
>Pour installer scott, nous avons ajouter la dépendance dans notre pom.xml. maven se charge d'installer Scott

## Utilisation

>Une fois ajouter, viendra ajouter son anayse des tests dans la console apres le build de maven.

> Scott execute son analyse seulement si le test ne passe pas. Par conséquent, dans notre rendu, nous avons fait expres de

>Pas de manipulation suplémentaire est à faire pour utiliser la dépendance avec les paramettres par défaut.

## Problemes rencontrés

>Faire attention aux problemes de version du plugin en fonction de la version de java utilisée.
Nous avons eu un problème avec une boucle foreach. scott ne parvenait pas à remonter la stack et nous lancait une erreur. les boucles for sont donc à éviter dans les tests.

> Nous n'avons pas pu utiliser Scott avec Junit5 car il y a une issue active sur leur github. N'etant pas une version stable, nous avons préféré nous rabbatre sur une version stable.

## Conclusion

Scott est une dépendance utile à ajouter lors du test de votre projet, permettant de faciliter la détection des erreurs et de les corriger plus rapidement.