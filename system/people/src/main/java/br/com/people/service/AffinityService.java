package br.com.people.service;

import br.com.people.domain.AffinityEntity;
import br.com.people.dto.AffinityDto;
import br.com.people.repository.AffinityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AffinityService {

    private AffinityRepository repository;

    @Autowired
    public AffinityService(AffinityRepository repository){
        this.repository = repository;
    }

    @Transactional
    public String save(AffinityDto affinityDto) {
        var affinityEntity = new AffinityEntity();
        affinityEntity.setRegiao(affinityDto.getRegiao());
        affinityEntity.setEstados(affinityDto.getEstados());
        AffinityEntity AffinityEntitySaved =  repository.save(affinityEntity);
        return AffinityEntitySaved.getRegiao();
    }

    public Optional<AffinityEntity> getAffinity(String regiao){
        return repository.findById(regiao);
    }


}
