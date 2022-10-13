package br.com.people.repository;

import br.com.people.domain.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testaDataPersistencia() {
        var personEntity = new PersonEntity();
        personEntity.setScore(700);
        personEntity.setTelefone("11111111111");
        personEntity.setIdade((short)22);
        personEntity.setCidade("Guarulhos");
        personEntity.setEstado("SP");
        personEntity.setNome("Walter");
        var personEntitySaved = this.entityManager.persistAndFlush(personEntity);
        assertNotNull(personEntitySaved.getDataInclusao());
    }


}
