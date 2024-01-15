package com.example.application;

import com.example.application.entities.Person;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
@Theme(value = "hilla-autogrid-mongodb")
public class Application implements AppShellConfigurator {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        mongoTemplate.findAllAndRemove(new Query(), Person.class);

        // Generate test data for 500 persons
        for (int i = 1; i <= 500; i++) {
            mongoTemplate.insert(new Person("First Name " + i, "Last Name " + i, "Street " + i, 10000 + i, "City " + i, "Country " + i, "mail" + i + "@example.com", "123456789" + i));
        }
    }
}
