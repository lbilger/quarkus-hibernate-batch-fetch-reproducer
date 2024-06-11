package org.example;


import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class ExampleEntityStandaloneTest {

    @Test
    public void testIt() {
        try (var entityManagerFactory = Persistence.createEntityManagerFactory("default")) {
            try (var entityManager = entityManagerFactory.createEntityManager()) {
                entityManager.getTransaction().begin();
                new ExampleService(entityManager).createTestData();
                entityManager.getTransaction().commit();
            }

            try (var entityManager = entityManagerFactory.createEntityManager()) {
                entityManager.getTransaction().begin();
                new ExampleService(entityManager).printElements();
                entityManager.getTransaction().commit();
            }
        }
    }
}
