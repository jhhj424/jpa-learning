package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "line")
public class Line extends BaseEntity {
    @Column(unique = true)
    private String name;
    private String color;
    @OneToMany(mappedBy = "line")
    private List<LineStation> lineStations = new ArrayList<>();

    protected Line() {}

    public Line(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Line(String name, String color, List<LineStation> lineStations) {
        this.name = name;
        this.color = color;
        this.lineStations = lineStations;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<LineStation> getLineStations() {
        return lineStations;
    }
}
