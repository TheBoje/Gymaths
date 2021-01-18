import java.util.List;
import java.util.Random;

public abstract class ExpGenerator 
{
    private static int     m_heightMax;    // hauteur maximale de l'arbre 
    private static Random  m_random;       // instance de random

    public static void init(int h)
    {
        m_heightMax = h;
        m_random = new Random();
    }
}
