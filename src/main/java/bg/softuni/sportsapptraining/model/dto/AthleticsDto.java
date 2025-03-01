package bg.softuni.sportsapptraining.model.dto;

public class AthleticsDto {

    private String discipline;
    private String worldChampion;
    private String worldRecord;

    public AthleticsDto(String s, String ноаЛайлс, String string, String url) {
    }

    public AthleticsDto(String discipline, String worldChampion, String worldRecord) {
        this.discipline = discipline;
        this.worldChampion = worldChampion;
        this.worldRecord = worldRecord;
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
