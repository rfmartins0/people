package br.com.people.util;

import br.com.people.dto.PersonDto;

public class DataUtil {

    private DataUtil() {

    }

    public static PersonDto createPerson() {
        var personDto = new PersonDto();
        personDto.setCidade("Itapeva");
        personDto.setEstado("SP");
        personDto.setNome("Astrogildo");
        personDto.setIdade((short) 85);
        personDto.setTelefone("7777777777");
        personDto.setRegiao("Sudeste");
        personDto.setScore(500);
        return personDto;
    }


}
