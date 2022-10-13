package br.com.people.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.people.domain.AffinityEntity;
import br.com.people.dto.AffinityDto;
import br.com.people.repository.AffinityRepository;

@RunWith(MockitoJUnitRunner.class)
public class AffinityServiceTest {

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        AffinityRepository affinityRepository = Mockito.mock(AffinityRepository.class);
        var affinityEntity = new AffinityEntity();
        affinityEntity.setEstados(Sets.newLinkedHashSet("Hessen"));
        affinityEntity.setRegiao("Test");
        when(affinityRepository.save(any(AffinityEntity.class)))
                .thenReturn(affinityEntity);
        var affinityService = new AffinityService(affinityRepository);
        String id = affinityService.save(new AffinityDto());
        assertEquals(id, "Test");
    }

    @Test
    public void testAllScores() {
        AffinityRepository affinityRepository = Mockito.mock(AffinityRepository.class);
        when(affinityRepository.findById(anyString()))
                .thenReturn(Optional.of( new AffinityEntity()));
        var affinityService = new AffinityService(affinityRepository);
        assertTrue(affinityService.getAffinity("sp").isPresent());
    }

}
