package jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "station")
public class Station extends BaseEntity{
    @Column(unique = true)
    private String name;
    @ManyToMany
    private List<Line> lines = new ArrayList<>();

    protected Station() {}

    public Station(String name) {
        this.name = name;
    }

    public Station(String name, List<Line> lines) {
        this.name = name;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name) &&
                Objects.equals(lines, station.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lines);
    }
}
