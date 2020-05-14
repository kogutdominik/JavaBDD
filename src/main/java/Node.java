public class Node {

    private String nameOfNode;
    private int colour;

    public Node(int nameOfNode) {
        this.nameOfNode = "V" + nameOfNode;
        this.colour = 0;
    }

    public String getNameOfNode() {
        return nameOfNode;
    }

    public void setNameOfNode(String nameOfNode) {
        this.nameOfNode = nameOfNode;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nameOfNode='" + nameOfNode + '\'' +
                ", colour=" + colour +
                '}';
    }
}