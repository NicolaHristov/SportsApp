package com.nikola.sportsapp.model.dto;

public class DisciplineDto {

    private Long id;
    private String name;
    private String sportName;
    private String worldRecordHolder;
    private String worldRecordTime;

    public String getWorldRecordHolder() {
        return worldRecordHolder;
    }

    public void setWorldRecordHolder(String worldRecordHolder) {
        this.worldRecordHolder = worldRecordHolder;
    }

    public String getWorldRecordTime() {
        return worldRecordTime;
    }

    public void setWorldRecordTime(String worldRecordTime) {
        this.worldRecordTime = worldRecordTime;
    }

    public DisciplineDto() {
    }

    public DisciplineDto(Long id, String name, String sportName, String worldRecordHolder, String worldRecordTime) {
        this.id = id;
        this.name = name;
        this.sportName = sportName;
        this.worldRecordHolder = worldRecordHolder;
        this.worldRecordTime = worldRecordTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSportName() {
        return sportName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

}
