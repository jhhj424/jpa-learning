package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "station")
public class Station extends BaseEntity{
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "station")
    private List<LineStation> lineStations = new ArrayList<>();

    protected Station() {}

    public Station(String name) {
        this.name = name;
    }

    public Station(String name, List<LineStation> lineStations) {
        this.name = name;
        this.lineStations = lineStations;
    }

    public String getName() {
        return name;
    }

    public List<LineStation> getLineStations() {
        return lineStations;
    }
}
