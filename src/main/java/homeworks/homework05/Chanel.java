package homeworks.homework05;

import java.util.ArrayList;
import java.util.Objects;

public class Chanel {
    private String name;
    private Integer number;
    private ArrayList<Program> programArrayList = new ArrayList<Program>();

    public Chanel(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public void addProgramA(Program program) {
        programArrayList.add(program) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Chanel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", programArrayList=" + programArrayList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chanel chanel = (Chanel) o;
        return Objects.equals(name, chanel.name) && Objects.equals(number, chanel.number) && Objects.equals(programArrayList, chanel.programArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, programArrayList);
    }
}

