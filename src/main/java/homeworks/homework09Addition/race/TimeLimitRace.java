package homeworks.homework09Addition.race;

import java.util.Objects;

public class TimeLimitRace extends Race{
    private Integer goldTime;

    public TimeLimitRace() {
    }

    public TimeLimitRace(Integer length, String route, Integer prize, Integer goldTime) {
        super(length, route, prize);
        this.goldTime = goldTime;
    }

    public Integer getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(Integer goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeLimitRace that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(goldTime, that.goldTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goldTime);
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "length=" + super.getLength() +
                ", route=" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participant=" + super.getParticipant() +
                ", goldTime=" + goldTime +
                '}';
    }
}
