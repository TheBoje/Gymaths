import java.util.Random;

public abstract class EquationGenerator {

    public static final Random      RAND = new Random();        // Random static permettant d'effectuer tous les aléatoires
    public static final int         BOUND = 10;                 // Limite des nombres à générer (entre 0 et 9 (BOUND - 1))

    private static final int        NB_EXP = 3;                 // Nombre d'expressions pouvant être instancié
    private static final int        CHANCES_SUM = 100;          // Somme du tableau d'entier "chances"
    private static int[]            chances = new int[NB_EXP];  // Tableau contenant le % de chance d'instanciation (0 = Plus, 1 = Times, 2 = Number)
    

    // Calcul la somme des cases d'un tableau d'entier
    private static int tableSum(int[] tab)
    {
        int sum = 0;
        for(int i = 0; i < tab.length; i++)
            sum += tab[i];

        return sum;
    }

    // Change le tableau de chance d'instanciation si la somme du nouveau tableau est = CHANCE_SUM
    public static void initChances(int[] c) throws Exception
    {
        if(tableSum(c) == CHANCES_SUM)
            System.arraycopy(c, 0, chances, 0, c.length);
        else
            throw new Exception("Table sum not equal to " + CHANCES_SUM);
    }

    // génère une équation (arbre de type Exp)
    public static Exp generateEquation(int hmax) 
    {
        if(hmax <= 0)
        {
            return new Number(RAND.nextInt(BOUND));
        }
        else
        {
            int rand = RAND.nextInt(NB_EXP);

            if(chances)
        }
    }

}
