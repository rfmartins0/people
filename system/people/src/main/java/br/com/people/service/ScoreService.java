package br.com.people.service;

import br.com.people.domain.ScoreEntity;
import br.com.people.dto.ScoreDto;
import br.com.people.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {

    private ScoreRepository repository;

    @Autowired
    public ScoreService(ScoreRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Integer save(ScoreDto scoreDto) {
        var scoreEntity = new ScoreEntity();
        scoreEntity.setDescricao(scoreDto.getScoreDescricao());
        scoreEntity.setScoreFinal(scoreDto.getScoreFinal());
        scoreEntity.setScoreInicial(scoreDto.getScoreInicial());
        ScoreEntity scoreEntitySaved =  repository.save(scoreEntity);
        return scoreEntitySaved.getScoreInicial();
    }

    public List<ScoreEntity> getAllScores(){
        return (List<ScoreEntity>) repository.findAll();
    }


}
