package com.example.trackandfield.score;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getScores() {
        return scoreRepository.findAll().stream()
            .map(this::mapToScore)
            .toList();
    }

    public Score createScore(Score score) {
        var entity = mapToEntity(score);
        var storedEntity = scoreRepository.save(entity);
        return mapToScore(storedEntity);
    }

    public void removeScore(UUID id) {
        var entity = scoreRepository.findById(id);
        entity.ifPresent(scoreRepository::delete);
    }

    private Score mapToScore(ScoreEntity entity) {
        return new Score(
            entity.getId(),
            entity.getPoints()
        );
    }

    private ScoreEntity mapToEntity(Score score) {
        return new ScoreEntity(
            UUID.randomUUID(),
            score.points()
        );
    }
}
