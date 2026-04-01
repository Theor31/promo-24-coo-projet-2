# Questions

## Q1
Une méthode default définie dans une interface ne peut pas accéder directement aux champs privés d'une classe qui l'implémente.

## Q2

Machine contient de l'état (champs privés comme condition, capacity) et un constructeur qui l'initialise. Une interface ne peut pas avoir de champs d'instance ni de constructeurs, elle ne peut que déclarer des signatures. Seule une classe abstraite le peut.

## Q4

Stock<Duck> accepte uniquement un Stock dont le type générique exact est Duck. En revanche, Stock<? extends Duck> accepte un Stock de tout type qui étend Duck (StandardDuck, MiniDuck, LuxuryDuck).

```java
Order order = new Order(DuckType.STANDARD, 5, 50.0, 3);
Stock<StandardDuck> standardStock = new Stock<>();
standardStock.add(new StandardDuck(75));

// Compile avec Stock<? extends Duck>
boolean ok1 = order.canBeFulfilled(standardStock);

// Ne compile pas avec Stock<Duck>
// order.canBeFulfilled(standardStock);  // Type mismatch
```