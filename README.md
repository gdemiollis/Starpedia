# Starpedia

Starpedia est un simple projet me servant de terrain de jeux pour tester les dernières nouveautés ainsi qu'un architecture orientée tests.

## Présentation des librairies et pratiques utilisées :
[SWAPI](https://github.com/gdemiollis/SWAPI-Java-SDK) le sdk forké et mis à jour par moi-même
[RXJAVA2](https://github.com/ReactiveX/RxJava) Pour remplacer les Asynctask
[Dagger2](https://google.github.io/dagger/) pour 2 raisons : simplifier les tests et profiter pleinement des flavors
Flavors afin de pouvoir avoir 2 environnements : le premier faisant les vrais appels réseaux, le second utilisant des données mockées. 
Ce dernier est devenu indispensable dans mon expérience actuelle car 
 - Il arrive que l'environnement sur lequel je travaille au quotidien ne soit pas disponible
 - Lorsque je travail sur du UI, le résultat arrive instantanément
 - Pour les tests UI, je ne suis plus dépendant de latences réseaux.
JUnit pour les tests unitaires
Espresso pour les test UI
> À noter : je n'ai pas écris trop de tests unitaires sur les vues, je n'ai donc pas eu besoin de Robolectric.

##Flavors
Il y a 2 flavors dans ce projet :
 - Remote : Flavor livrée en production.
L'implémentation des services faisant appel au sdk SWAPI est faite dans le dossier [remote](https://github.com/gdemiollis/Starpedia/tree/master/app/src/remote)
 - Mock : Flavor utilisé lors du dévelopement dans le cas où le contenu affiché à l'écran n'est pas important.
L'implémentation de ces services est faite dans le dossier [mock](https://github.com/gdemiollis/Starpedia/tree/master/app/src/mock)
> Les tests UI sont exécutés avec cette flavor.
 
## Design Pattern utilisés
 - (Factory)(https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)) pour les [services](https://github.com/gdemiollis/Starpedia/blob/master/app/src/main/java/fr/and1droid/starpedia/service/ServiceFactory.java) et les [fragmnets de détail](https://github.com/gdemiollis/Starpedia/blob/master/app/src/main/java/fr/and1droid/starpedia/ui/detail/FragmentFactory.java)
 - [Template method](https://en.wikipedia.org/wiki/Template_method_pattern) avec les [appels vers l'API](https://github.com/gdemiollis/Starpedia/blob/master/app/src/remote/java/fr/and1droid/starpedia/service/BaseServiceImpl.java)
 - Un simili [Builder](https://en.wikipedia.org/wiki/Builder_pattern) lors de la construction des [vues de détail](https://github.com/gdemiollis/Starpedia/blob/master/app/src/main/java/fr/and1droid/starpedia/ui/detail/DetailView.java#L38)

## Tests
Les tests UI peuvent se lancer avec la commande
```sh
$ ./gradlew connectedMockDebugAndroidTest
```

## TODOS
Pas implémenté le scroll infini par manque de temps
Terminer la branche Search. Le but étant d'appeler en parallèles plusieurs services et de merger les réponses dans un seul et même flow de réponse avec RXJava2.
Implémenter une version tablette digne de ce nom
Les objects sont actuellement passés entre les écrans sous forme Serializable. Mesurer si c'est plus efficace de les transformer en Parcelable
