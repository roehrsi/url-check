package com.example.urlcheck.model;

import java.time.LocalDateTime;

/**  POJO for Check results
*   String url                      The url to check
*   String statusCode               The returned status code of the given url
*   LocalDateTime lastCheckDateTime The date of the last check on this entry.
*/
public class ResultsEntry {
    private String url;
    private Integer statusCode;
    private LocalDateTime lastCheckDateTime;

    public ResultsEntry(String url, Integer statusCode, LocalDateTime lastCheckDateTime) {
        this.url = url;
        this.statusCode = statusCode;
        this.lastCheckDateTime = lastCheckDateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getLastCheckDateTime() {
        return lastCheckDateTime;
    }

    public void setLastCheckDateTime(LocalDateTime lastCheckDateTime) {
        this.lastCheckDateTime = lastCheckDateTime;
    }

}
