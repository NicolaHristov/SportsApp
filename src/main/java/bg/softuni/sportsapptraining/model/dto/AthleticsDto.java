package bg.softuni.sportsapptraining.model.dto;

public class AthleticsDto {

    private String discipline;
    private String worldChampion;
    private String worldRecord;

    public AthleticsDto() {
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getWorldChampion() {
        return worldChampion;
    }

    public void setWorldChampion(String worldChampion) {
        this.worldChampion = worldChampion;
    }

    public String getWorldRecord() {
        return worldRecord;
    }

    public void setWorldRecord(String worldRecord) {
        this.worldRecord = worldRecord;
    }
}
