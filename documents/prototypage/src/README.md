#### Documentation

##### `public abstract class EquationGenerator`

TODO -> faire une classe exposant TODO -> faire une classe equal

##### `public static Exp LINEAR()`

Génère une fonction de la forme ax + b avec a et b randoms

 * **Returns:** Exp

##### `public static Exp QUADRATIC()`

Génère une fonction de la forme ax² + bx + c avec a, b et c randoms

 * **Returns:** Exp

##### `public static void initChances(int[] c) throws Exception`

Change le tableau de chance d'instanciation si la somme du nouveau tableau est = CHANCE_SUM

 * **Parameters:** `c` — : tableau contenant les chances d'apparition des opérateurs
 * **Exceptions:** `Exception` — : Retourne une exception si le tableau est trop grand/trop petit par rappot au nombre d'expressions

##### `public static Exp generateExpression(int hmax)`

génère une équation (arbre de type Exp) (récursif)

 * **Parameters:** `hmax` — : hauteur maximale de l'arbre support de l'expression
 * **Returns:** arbre d'expression

##### `public static void putVariable(Exp tree)`

Place une variable sur une feuille de l'arbre passé en paramètre (récursif)

 * **Parameters:** `tree` — : arbre dans lequel on place la variable

##### `public static Exp generateEquation(int hmax) throws Exception`

Génère une équation en fonction de x TODO -> rajouter le egale en racine de l'arbre

 * **Parameters:** `hmax` — : hauteur maximale de l'arbre
 * **Returns:** Retourne un arbre d'expression Exp avec une variabel, cette expression ne contient pas de division par 0
 * **Exceptions:** `Exception` — 
