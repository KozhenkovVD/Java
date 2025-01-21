package homeworks.homework06Additional;

import java.util.ArrayList;
import java.util.Objects;

public class Channel {
    private String name;
    private Integer number;
    private ArrayList<Program> programArrayList = new ArrayList<Program>();

    public Channel(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", programArrayList=" + programArrayList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(name, channel.name) && Objects.equals(number, channel.number) && Objects.equals(programArrayList, channel.programArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, programArrayList);
    }
}
