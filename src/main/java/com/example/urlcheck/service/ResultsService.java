package com.example.urlcheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlcheck.model.ResultsEntry;
import com.example.urlcheck.model.ResultsRepository;

@Service
public class ResultsService {
    
    @Autowired
    private ResultsRepository resultsRepository;

    public List<ResultsEntry> findAll() {
        return this.resultsRepository.findAll();
    }

    public void add(final ResultsEntry resultsEntry) {
        this.resultsRepository.add(resultsEntry);
    }

    public void remove(ResultsEntry resultsEntry) {
        this.resultsRepository.remove(resultsEntry);
    }

    public void removeByIdx(Integer index) {
        this.resultsRepository.removeByIdx(index);
    }

}
