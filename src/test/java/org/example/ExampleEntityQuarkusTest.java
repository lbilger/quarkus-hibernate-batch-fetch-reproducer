package org.example;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ExampleEntityQuarkusTest {
    @Inject
    ExampleService exampleService;

    @Test
    public void testIt() {
        exampleService.createTestData();
        exampleService.printElements();
    }
}
