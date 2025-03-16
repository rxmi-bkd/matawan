# MATAWAN

***Temps passé : 45 minutes***

### Stack technique :

- ***Build*** : Maven

- ***Base de données*** : h2 car elle est embarquée et ne nécessite pas de configuration particulière.

- ***Framework*** : Spring Boot car c'est le framework avec lequel je travaille actuellement et que je connais le mieux.

Pour lancer l'application il faut exécuter la commande suivante :

````mvn spring-boot:run````

### Endpoints disponibles :

- POST : http://localhost:8080/teams

````
// exemple de body

{
    "team": {
        "name": "team1",
        "acronym": "t1",
        "budget": 1000000
    },
    "players": [
        {
            "name": "player1",
            "position": "defense"
        },
        {
            "name": "player2",
            "position": "defense"
        }
    ]
}
````

- GET : http://localhost:8080/teams

````
Les query params disponibles sont :
- page : numéro de la page
- size : nombre d'éléments par page
- direction : ordre de tri (asc ou desc)
- SortBy : colonne de tri (name, acronym ou budget)
````