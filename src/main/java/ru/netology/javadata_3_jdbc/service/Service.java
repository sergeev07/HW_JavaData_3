package ru.netology.javadata_3_jdbc.service;

import ru.netology.javadata_3_jdbc.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<String> getProduct (String name){
        return repository.getProductName(name);
    }
}
