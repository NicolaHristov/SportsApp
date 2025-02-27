package bg.softuni.sportsapptraining.model;

import jakarta.persistence.*;

@Entity
@Table(name ="disciplines")
public class Discipline {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "world_record_holder")
    private String worldRecordHolder;

    @Column(name = "world_record_time")
    private String worldRecordTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sport sport;

    public Discipline() {
    }

    public Discipline(String name, String worldRecordHolder, String worldRecordTime) {
        this.name = name;
        this.worldRecordHolder = worldRecordHolder;
        this.worldRecordTime = worldRecordTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
