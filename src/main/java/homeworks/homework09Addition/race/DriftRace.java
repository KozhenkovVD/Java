package homeworks.homework09Addition.race;

public class DriftRace extends Race {
    public DriftRace(Integer length, String route, Integer prize) {
        super(length, route, prize);
    }

    public DriftRace() {
    }

    @Override
    public String toString() {
        return "DriftRace{" +
                "length=" + super.getLength() +
                ", route=" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participant=" + super.getParticipant() +
                '}';
    }
}
