package jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineRepository extends JpaRepository<Line, Long> {
    Line findByName(String name);

    List<Line> findByColor(String color);
}
