package modal;
import java.util.List;

public class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if (space.stream().flatMap(Collection::stream).noneMatch(s -> Is.isFixed() && nonNull(s.getActual()))) {
            
        }
    }
}
