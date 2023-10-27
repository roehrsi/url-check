package com.example.urlcheck.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/*
 * Repository to keep track of a list of all {url, status code} pairs.
 * supports returning the list of all entries, adding a new entry to the list and deleting an entry by url.
 */
@Repository
public class ResultsRepository {

    private final List<ResultsEntry> resultsEntries = new ArrayList<ResultsEntry>();

    public ResultsRepository() {
        super();
    }

    public List<ResultsEntry> findAll() {
        return new ArrayList<ResultsEntry>(this.resultsEntries);
    }

    public void add(final ResultsEntry entry) {
        this.resultsEntries.add(entry);
    }

    /*
     * Remove a list entry by object.
     * Note: not used in implementation.
     */
    public void remove(ResultsEntry entry) {
        this.resultsEntries.remove(entry);
    }

    /*
     * Remove a list entry by index
     */
    public void removeByIdx(int index) {
        this.resultsEntries.remove(index);
    }

}
