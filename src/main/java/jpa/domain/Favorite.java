package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "favorite")
public class Favorite extends BaseEntity {
    @OneToOne
    private Station fromStation;
    @OneToOne
    private Station toStation;

    protected Favorite() {}

    public Favorite(Station from, Station to) {
        this.fromStation = from;
        this.toStation = to;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return Objects.equals(fromStation, favorite.fromStation) &&
                Objects.equals(toStation, favorite.toStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromStation, toStation);
    }
}
