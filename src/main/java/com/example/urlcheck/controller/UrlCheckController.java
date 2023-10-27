package com.example.urlcheck.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.urlcheck.model.ResultsEntry;
import com.example.urlcheck.service.HttpRequestHandler;
import com.example.urlcheck.service.ResultsService;

import org.springframework.web.bind.annotation.RequestParam;

/*
 * Controller for all application mappings.
 */
@Controller
public class UrlCheckController {

    @Autowired
    private ResultsService resultsService;

    /*
     * Model attribute for all table entries. Managed by resultsService.
     */
    @ModelAttribute("allResultsEntries")
    public List<ResultsEntry> populateResultsEntries() {
        return this.resultsService.findAll();
    }

    /*
     * Mapping for display page.
     */
    @GetMapping
    public String index(final ResultsEntry resultsEntry, final Integer checkInterval) {
        return "index";
    }

    /*
     * Mapping to remove an entry from the table by button.
     * List item is retrieved by index.
     */
    @PostMapping(value = "/", params = "removeEntry")
    public String removeEntry(@RequestParam("removeEntry") Integer idx, @ModelAttribute ResultsEntry resultsEntry,
            Model model) {

        this.resultsService.removeByIdx(idx);

        return "redirect:/";
    }

    /*
     * Mapping for insert operation button.
     */
    @PostMapping(value = "/", params = "addEntry")
    public String addEntry(@ModelAttribute ResultsEntry resultsEntry, BindingResult error, Model model) {

        resultsEntry.setLastCheckDateTime(LocalDateTime.now());
        resultsEntry.setStatusCode(HttpRequestHandler.requestHttpResponse(resultsEntry.getUrl()));
        this.resultsService.add(resultsEntry);

        return "redirect:/";
    }

    /*
     * This is scheduled task that will be performed every ${checkInterval}
     * milliseconds.
     * Iterates over all present table entries and performs an http request on their
     * url attribute.
     * The returned status code is saved in the entry object.
     * Interval can be set in the application properties.
     * Will only check valid connection. entries with status code 0 will be skipped.
     */
    // TODO: find a way to dynamically set the check interval. Trigger?
    // @Scheduled(fixedRateString = "10000")
    @Scheduled(fixedRateString = "${prop.checkInterval}")
    public void performUrlCheck() {
        List<ResultsEntry> resultsEntries = resultsService.findAll();
        LocalDateTime currenTime = LocalDateTime.now();
        for (ResultsEntry entry : resultsEntries) {
            // if (entry.getStatusCode() != 0) {
                Integer responseCode = HttpRequestHandler.requestHttpResponse(entry.getUrl());
                entry.setStatusCode(responseCode);
                entry.setLastCheckDateTime(currenTime);
            // }
        }
    }

}
