package com.sigvetl.twoDog.model;

import java.time.LocalDateTime;

public class BatchForm {
    private Integer batchId;
    private Float volume;
    private LocalDateTime brewDate;
    private LocalDateTime tapDate;
    private LocalDateTime finishDate;
    private Float abv;
    private Float og;
    private Float fg;
    private Integer beerId;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public LocalDateTime getBrewDate() {
        return brewDate;
    }

    public void setBrewDate(LocalDateTime brewDate) {
        this.brewDate = brewDate;
    }

    public LocalDateTime getTapDate() {
        return tapDate;
    }

    public void setTapDate(LocalDateTime tapDate) {
        this.tapDate = tapDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public Float getAbv() {
        return abv;
    }

    public void setAbv(Float abv) {
        this.abv = abv;
    }

    public Float getOg() {
        return og;
    }

    public void setOg(Float og) {
        this.og = og;
    }

    public Float getFg() {
        return fg;
    }

    public void setFg(Float fg) {
        this.fg = fg;
    }

    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }
}
