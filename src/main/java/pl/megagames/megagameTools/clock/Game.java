package pl.megagames.megagameTools.clock;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
class Game {
    private String name;
    private List<Phase> phases;

    Game() {
        this.name = "";
        this.phases = new LinkedList<>();
    }
}
