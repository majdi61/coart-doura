package com.coart.doura;

import com.coart.doura.CoartDouraApp;
import com.coart.doura.MongoDbTestContainerExtension;
import com.coart.doura.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CoartDouraApp.class, TestSecurityConfiguration.class })
@ExtendWith(MongoDbTestContainerExtension.class)
public @interface IntegrationTest {
}
