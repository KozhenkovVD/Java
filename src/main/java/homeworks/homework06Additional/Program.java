package homeworks.homework06Additional;

import java.util.Objects;

public class Program {
    private String name;
    private Integer rating;
    private Integer viewerCount;

    public Program(String name, Integer rating, Integer viewerCount) {
        this.name = name;
        this.rating = rating;
        this.viewerCount = viewerCount;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", viewerCount=" + viewerCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(name, program.name) && Objects.equals(rating, program.rating) && Objects.equals(viewerCount, program.viewerCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, viewerCount);
    }
}
