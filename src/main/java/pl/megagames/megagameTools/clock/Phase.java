package pl.megagames.megagameTools.clock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Phase {
    private String name;
    private long end;

    Phase() {
        this.name = "";
    }
}
