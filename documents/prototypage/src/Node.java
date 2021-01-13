public class Node {
    private enum Node_Type {
        PLUS("+", 10), MINUS("-", 10), MULTIPLY("*", 10), DIVIDE("/", 10), EQUAL("=", 1), VALUE("v", 2),
        VARIABLE("x", 3);

        private String str;
        private int prob;

        private Node_Type(String str, int prob) {
            this.str = str;
            this.prob = prob;
        }

        // getters
        public String getStr() {
            return this.str;
        }

        public int getProb()
        {
            return this.prob;
        }
    }

    private Integer value;
    private Node_Type type;

    public Node(Node_Type type) throws Exception {
        if (type != Node_Type.VALUE) {
            this.type = type;
            this.value = null;
        } else {
            throw new Exception("Error Node initialisation: value needed");
        }
    }

    public Node(Node_Type type, int value) {
        if (type == Node_Type.VALUE) {
            this.type = type;
            this.value = (Integer) value;
        } else {
            this.type = type;
            this.value = null;
        }
    }

    public Integer getValue() {
        return this.value;
    }

    public Node_Type getType() {
        return this.type;
    }

}
