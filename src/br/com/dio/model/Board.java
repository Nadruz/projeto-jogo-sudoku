package src.br.com.dio.model; 
import java.util.Collection;
import java.util.List;

import static src.br.com.dio.model.GameStatusEnum.COMPLETE;
import static src.br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static src.br.com.dio.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    // o objeto fornece informações sobre ele
    public GameStatusEnum getStatus() {
        // caso nenhum espaço "não-fixo" tenha sido preenchido
        if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))) {
            return GameStatusEnum.NON_STARTED;
        }

        // verifica se tem pelo menos uma ocorrência na lista
        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == NON_STARTED) {
            return false;
        }

        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }



}
