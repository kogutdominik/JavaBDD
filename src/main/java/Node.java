public class Node {
    public Node(int nameOfNode) {
        this.nameOfNode="v"+nameOfNode;
        this.colour="0";
    }

    public String nameOfNode;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String colour;
}
