import java.util.ArrayList;
import java.util.List;

public class NodesCollection {
/*zmienna na postawie ktorej tworzony jest zbior wierzcholkow*/
    String stringOfExpression;
    List<Node> nodes = new ArrayList<>();
    public NodesCollection(String stringOfExpression) {
        this.stringOfExpression = stringOfExpression;
    }
}



