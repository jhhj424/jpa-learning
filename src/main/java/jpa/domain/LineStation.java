package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LineStation extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private Line line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    private int distance;

    protected LineStation() {}

    public LineStation(Line line, Station station, int distance) {
        this.line = line;
        this.station = station;
        this.distance = distance;
    }

    public Line getLine() {
        return line;
    }

    public Station getStation() {
        return station;
    }

    public int getDistance() {
        return distance;
    }
}
