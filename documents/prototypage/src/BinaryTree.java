public class BinaryTree {

    private Node key;
    private BinaryTree lson;
    private BinaryTree rson;

    private BinaryTree(Node r, BinaryTree ls, BinaryTree rs) {
        this.key = r;
        this.lson = ls;
        this.rson = rs;
    }

    public static BinaryTree rooting(Node r, BinaryTree ls, BinaryTree rs) throws Exception {
        if (r != null)
            return new BinaryTree(r, ls, rs);
        else
            throw new Exception("Node is null");
    }

    public static BinaryTree empty() {
        return null;
    }

    // ROTATIONS
    // DROITE
    public void rotateRight() {

    }

    // GAUCHE
    public void rotateLeft() {
        
    }

    // GETTERS
    public BinaryTree lson() {
        return this.lson;
    }

    public BinaryTree rson() {
        return this.rson;
    }

    public Node root() {
        return this.key;
    }
}
