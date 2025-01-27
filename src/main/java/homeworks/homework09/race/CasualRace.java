package homeworks.homework09.race;

public class CasualRace extends Race{

    public CasualRace() {
    }

    public CasualRace(Integer length, String route, Integer prize) {
        super(length, route, prize);
    }

    @Override
    public String toString() {
        return "CasualRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participant=" + super.getParticipant() +
                '}';
    }
}
