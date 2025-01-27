package homeworks.homework09Addition.race;

public class DragRace extends Race {
    public DragRace(Integer length, String route, Integer prize) {
        super(length, route, prize);
    }

    public DragRace() {
    }

    @Override
    public String toString() {
        return "DragRace{" +
                "length=" + super.getLength() +
                ", route=" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participant=" + super.getParticipant() +
                '}';
    }
}
