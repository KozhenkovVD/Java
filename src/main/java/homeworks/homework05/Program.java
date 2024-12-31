package homeworks.homework05;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getViewerCount() {
        return viewerCount;
    }

    public void setViewerCount(Integer viewerCount) {
        this.viewerCount = viewerCount;
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
