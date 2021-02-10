import java.util.Random;

/**
 * TODO -> faire une classe exposant
 * TODO -> faire une classe equal
 * 
 */

public abstract class EquationGenerator {

    public static final Random      RAND = new Random();        // Random static permettant d'effectuer tous les aléatoires
    public static final int         BOUND = 9;                 // Limite des nombres à générer (entre 0 et 9 (BOUND - 1))

    private static final int        NB_EXP = 3;                 // Nombre d'expressions pouvant être instancié
    private static final int        MAX = 100;
    private static int[]            chances = {20, 50, 70, 90, 100};  // Tableau contenant le % de chance d'instanciation (0 = Plus, 1 = Times, 2 = Number) il doit être de la forme [x, x + y, x + y + z]
    
    // PRESETS

    /** 
     * Génère une fonction de la forme ax + b avec a et b randoms
     * @return Exp
     */
    public static Exp LINEAR()
    {
        return new Plus(
            new Times(
                new Number(RAND.nextInt(BOUND)),
                new Variable("x")
            ), new Number(RAND.nextInt(BOUND)));
    }

    
    /** 
     *  Génère une fonction de la forme ax² + bx + c avec a, b et c randoms
     * @return Exp
     */
    public static Exp QUADRATIC()
    {
        return new Plus(
            new Times(
                new Number(RAND.nextInt(BOUND)),
                new Times(
                    new Variable("x"),
                    new Variable("x")
                )
            ),
            new Plus(
                new Times(
                    new Number(RAND.nextInt(BOUND)),
                    new Variable("x")
                ),
                new Number(RAND.nextInt(BOUND))
            )
        );
    }

    // 
    /**
     * Change le tableau de chance d'instanciation si la somme du nouveau tableau est = CHANCE_SUM
     * @param c : tableau contenant les chances d'apparition des opérateurs
     * @throws Exception : Retourne une exception si le tableau est trop grand/trop petit par rappot au nombre d'expressions
     */
    public static void initChances(int[] c) throws Exception
    {
        if(c.length == NB_EXP)
            System.arraycopy(c, 0, chances, 0, c.length);
        else
            throw new Exception("table length is not valid");
    }

    /**
     * génère une équation (arbre de type Exp) (récursif)
     * @param hmax : hauteur maximale de l'arbre support de l'expression
     * @return arbre d'expression 
     */
    public static Exp generateExpression(int hmax) 
    {
        if(hmax <= 0)
        {
            return new Number(RAND.nextInt(BOUND) + 1);
        }
        else
        {
            int rand = RAND.nextInt(MAX);

            if(rand < chances[0])
            {
                return new Plus(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[1])
            {
                return new Times(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[2])
            {
                return new Minus(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else if(rand < chances[3])
            {
                return new Divide(generateExpression(hmax - 1), generateExpression(hmax - 1));
            }
            else
            {
                return new Number(RAND.nextInt(BOUND) + 1);
            }
        }
    }

    /**
     * Place une variable sur une feuille de l'arbre passé en paramètre (récursif)
     * @param tree : arbre dans lequel on place la variable
     */
    public static void putVariable(Exp tree)
    {
        if(tree != null)
        {
            if(RAND.nextBoolean())
            {
                if(tree.expLeft instanceof Number)
                {
                    tree.expLeft = new Variable("x");
                }
                else
                {
                    putVariable(tree.expLeft);
                }
                
            }
            else
            {
                if(tree.expRight instanceof Number)
                {
                    tree.expRight = new Variable("x");
                }
                else
                {
                    putVariable(tree.expRight);
                }
            }
        }
    }

    /**
     * Génère une équation en fonction de x TODO -> rajouter le egale en racine de l'arbre
     * @param hmax : hauteur maximale de l'arbre
     * @return Retourne un arbre d'expression Exp avec une variabel, cette expression ne contient pas de division par 0
     * @throws Exception 
     */
    public static Exp generateEquation(int hmax) throws Exception
    {
        boolean isValid = true;
        Exp eq = new Divide(new Number(8), new Number(0));
        do
        {            
            try
            {
                eq.evaluate();
                isValid = true;
            }
            catch(Exception e)
            {
                //System.out.println("division par 0");
                eq = generateExpression(hmax);
                isValid = false;
            }

        }while(!isValid);


        putVariable(eq);
        return eq;
    }
}
