package homeworks.homework09Addition.race;

import homeworks.homework09.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    public Race() {
    }

    private Integer length;
    private String route;
    private Integer prize;
    private List<Car> participant = new ArrayList<Car>();

    public Race(Integer length, String route, Integer prize) {
        this.length = length;
        this.route = route;
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race race)) return false;
        return Objects.equals(length, race.length) && Objects.equals(route, race.route) && Objects.equals(prize, race.prize) && Objects.equals(participant, race.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prize, participant);
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route=" + route +
                ", prize=" + prize +
                ", participant=" + participant +
                '}';
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public List<Car> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Car> participant) {
        this.participant = participant;
    }

}
