package ru.geekbrains.mortgage.model;

import java.io.Serializable;

public class MortgageResponse implements Serializable {

    private MortgageRequest request;

    private Long id;

    private String resolution;

    public MortgageRequest getRequest() {
        return request;
    }

    public void setRequest(MortgageRequest request) {
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "MortgageResponse{" +
            "request=" + request +
            ", id=" + id +
            ", resolution='" + resolution + '\'' +
            '}';
    }
}
