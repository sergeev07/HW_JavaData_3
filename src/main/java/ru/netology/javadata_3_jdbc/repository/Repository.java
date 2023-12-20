package ru.netology.javadata_3_jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@org.springframework.stereotype.Repository
public class Repository {
    private final NamedParameterJdbcTemplate template;
    private String script = read("db/select_product_name.sql");

    public Repository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private String read(String script) {
        try (InputStream stream = new ClassPathResource(script).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){
        List<String> result = template.queryForList(script, Map.of("name",name), String.class);
        System.out.println(result);
        return result;
    }

}
