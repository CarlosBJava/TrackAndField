package com.example.trackandfield.score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ScoreEntity {

    public ScoreEntity() {}

    public ScoreEntity(UUID id, Integer points) {
        this.id = id;
        this.points = points;
    }

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column
    private Integer points;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}

