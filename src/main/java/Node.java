public class Node {
    public Node(int nameOfNode) {
        this.nameOfNode="v"+nameOfNode;
        this.colour=0;
    }

    private int colour;
    private String nameOfNode;


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

}
