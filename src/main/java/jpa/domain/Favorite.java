package jpa.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "favorite")
public class Favorite extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "from_station_id")
    private Station fromStation;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "to_station_id")
    private Station toStation;

    public static class Builder {
        private Station fromStation;
        private Station toStation;

        public Builder() {}

        public Builder fromStation(Station fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public Builder toStation(Station toStation) {
            this.toStation = toStation;
            return this;
        }

        public Favorite build() {
            return new Favorite(this);
        }
    }

    protected Favorite() {}

    private Favorite(Builder builder) {
        fromStation = builder.fromStation;
        toStation   = builder.toStation;
        if (fromStation.equals(toStation) || fromStation.getName().equals(toStation.getName())) {
            throw new IllegalArgumentException("출발역과 도착역은 같을 수 없습니다.");
        }
    }

    public String getFromStationName() {
        return fromStation.getName();
    }

    public String getToStationName() {
        return toStation.getName();
    }

    public Long getId() {
        return id;
    }
}
