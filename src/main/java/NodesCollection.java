import java.util.ArrayList;
import java.util.List;

public class NodesCollection {


    public NodesCollection(String stringOfExpression) {
        this.stringOfExpression = stringOfExpression;
    }

    public String stringOfExpression;
    List<Node> nodes = new ArrayList<>();
}



