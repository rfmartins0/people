package br.com.people.service;

import br.com.people.domain.ScoreEntity;
import br.com.people.dto.ScoreDto;
import br.com.people.repository.ScoreRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceTest {

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        ScoreRepository scoreRepository = Mockito.mock(ScoreRepository.class);
        var scoreEntity = new ScoreEntity();
        scoreEntity.setScoreInicial(100);
        scoreEntity.setScoreFinal(200);
        scoreEntity.setDescricao("test");
        when(scoreRepository.save(any(ScoreEntity.class)))
                .thenReturn(scoreEntity);
        var scoreService = new ScoreService(scoreRepository);
        long id = scoreService.save(new ScoreDto());
        assertEquals(id, 100l);
    }

    @Test
    public void testAllScores() {
        ScoreRepository scoreRepository = Mockito.mock(ScoreRepository.class);
        when(scoreRepository.findAll())
                .thenReturn(List.of(new ScoreEntity()));
        var scoreService = new ScoreService(scoreRepository);
        assertEquals(scoreService.getAllScores().size(), 1);
    }

}
