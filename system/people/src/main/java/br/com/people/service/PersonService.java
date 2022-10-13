package br.com.people.service;

import br.com.people.domain.AffinityEntity;
import br.com.people.domain.PersonEntity;
import br.com.people.domain.ScoreEntity;
import br.com.people.dto.PersonDto;
import br.com.people.dto.response.PersonResponse;
import br.com.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository repository;
    private ScoreService scoreService;
    private AffinityService affinityService;

    @Autowired
    public PersonService(PersonRepository repository, ScoreService scoreService, AffinityService affinityService){
        this.repository = repository;
        this.scoreService = scoreService;
        this.affinityService = affinityService;
    }

    @Transactional
    public Long save(PersonDto personDto) {
        var personEntity = new PersonEntity();
        personEntity.setCidade(personDto.getCidade());
        personEntity.setEstado(personDto.getEstado());
        personEntity.setNome(personDto.getNome());
        personEntity.setIdade(personDto.getIdade());
        personEntity.setTelefone(personDto.getTelefone());
        personEntity.setRegiao(personDto.getRegiao());
        personEntity.setScore(personDto.getScore());
        var personEntitySaved = repository.save(personEntity);
        return personEntitySaved.getId();
    }


    public Optional<PersonResponse> getPerson(Long id) {
        Optional<PersonEntity> personEntityOptional = repository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return Optional.empty();
        }
        var personEntity = personEntityOptional.get();
        PersonResponse personResponse = new PersonResponse();
        personResponse.setIdade(personEntity.getIdade());
        personResponse.setNome(personEntity.getNome());
        personResponse.setTelefone(personEntity.getTelefone());
        states(personResponse, personEntity.getRegiao());
        score(personResponse, personEntity.getScore());
        return Optional.of(personResponse);
    }

    public void score(PersonResponse personResponse, Integer score) {
        List<ScoreEntity> scoreList = scoreService.getAllScores();
        scoreList.stream().filter(s -> s.getScoreInicial() <= score && s.getScoreFinal() >= score).forEach(
                s -> personResponse.setScoreDescricao(s.getDescricao())
        );
    }

    public void states(PersonResponse personResponse, String regiao) {
        Optional<AffinityEntity> affinityEntityOptional = affinityService.getAffinity(regiao);
        if (affinityEntityOptional.isPresent()){
            var affinityEntity = affinityEntityOptional.get();
            personResponse.getEstados().addAll(affinityEntity.getEstados());
        }
    }
}
