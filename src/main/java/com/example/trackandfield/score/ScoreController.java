package com.example.trackandfield.score;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@ResponseBody
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    ResponseEntity<List<Score>> getScores() {
        return ResponseEntity.ok(scoreService.getScores());
    }

    @PostMapping
    ResponseEntity<Score> postScore(@RequestBody Score score) {
        if (score.points() < 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(scoreService.createScore(score));
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteScore(@PathVariable UUID id) {
        scoreService.removeScore(id);
        return ResponseEntity.ok().build();
    }
}
