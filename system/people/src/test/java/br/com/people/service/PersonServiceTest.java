package br.com.people.service;

import br.com.people.domain.AffinityEntity;
import br.com.people.domain.PersonEntity;
import br.com.people.domain.ScoreEntity;
import br.com.people.dto.PersonDto;
import br.com.people.dto.response.PersonResponse;
import br.com.people.repository.PersonRepository;
import br.com.people.util.DataUtil;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repository;
    @Mock
    private ScoreService scoreService;
    @Mock
    private AffinityService affinityService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testSave() {
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        var personEntity = new PersonEntity();
        personEntity.setId(100l);
        when(personRepository.save(any(PersonEntity.class)))
                .thenReturn(personEntity);
        var personService = new PersonService(personRepository, scoreService, affinityService);
        PersonDto personDto = DataUtil.createPerson();
        long id = personService.save(personDto);
        assertEquals(id, 100l);
    }

    @Test
    public void testFindPerson() {
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        when(personRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        var personService = new PersonService(personRepository, scoreService, affinityService);
        assertEquals(Optional.empty(), personService.getPerson(100l));
    }

    @Test
    public void testScore() {
        var personResponse = new PersonResponse();
        ScoreService scoreService = Mockito.mock(ScoreService.class);
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setScoreInicial(100);
        scoreEntity.setScoreFinal(200);
        scoreEntity.setDescricao("teste");
        when(scoreService.getAllScores())
                .thenReturn(List.of(scoreEntity));
        var personService = new PersonService(repository, scoreService, affinityService);
        personService.score(personResponse,150);
        assertEquals(personResponse.getScoreDescricao(),"teste" );
    }

    @Test
    public void testStates() {
        var personResponse = new PersonResponse();
        Set<String> estados = new HashSet<>();
        estados.add("Minas do Oeste");
        estados.add("São Oeste");
        AffinityService affinityService = Mockito.mock(AffinityService.class);
        var affinityEntity = new AffinityEntity();
        affinityEntity.setRegiao("sudoeste");
        affinityEntity.setEstados(estados);
        when(affinityService.getAffinity(anyString()))
                .thenReturn(Optional.of(affinityEntity));
        var personService = new PersonService(repository, scoreService, affinityService);
        personService.states(personResponse, "sudoeste");
        assertFalse(personResponse.getEstados().isEmpty());
    }

}
