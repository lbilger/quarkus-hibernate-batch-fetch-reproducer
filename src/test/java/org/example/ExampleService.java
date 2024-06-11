package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Set;

@Transactional
@ApplicationScoped
public class ExampleService {
    final EntityManager entityManager;

    @Inject
    public ExampleService(EntityManager entityManager) {this.entityManager = entityManager;}

    public void createTestData() {
        entityManager.persist(new ExampleEntity("id-1", Set.of("element-1")));
        entityManager.persist(new ExampleEntity("id-2", Set.of("element-2")));
        entityManager.persist(new ExampleEntity("id-3", Set.of("element-3")));
    }

    public void printElements() {
        var entities = entityManager.createQuery("select e from ExampleEntity e", ExampleEntity.class).getResultList();
        entityManager.createQuery("select e from DummyEntity e where 1 = 0", DummyEntity.class).getResultList();
        entities.stream().map(ExampleEntity::getAnElementCollection).forEach(System.out::println);
    }
}
