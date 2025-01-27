package homeworks.homework09Addition.race;

import java.util.Objects;

public class CircuitRace extends Race{
    private Integer laps;

    public CircuitRace() {
    }

    public CircuitRace(Integer length, String route, Integer prize, Integer laps) {
        super(length, route, prize);
        this.laps = laps;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CircuitRace that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(laps, that.laps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laps);
    }

    @Override
    public String toString() {
        return "CircuitRace{" +
                "length=" + super.getLength() +
                ", route=" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participant=" + super.getParticipant() +
                ", laps=" + laps +
                '}';
    }
}
