package bg.softuni.sportsapptraining.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="disciplines")
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();
    public Discipline(String name, String worldRecordHolder, String worldRecordTime) {
        this.name = name;
        this.worldRecordHolder = worldRecordHolder;
        this.worldRecordTime = worldRecordTime;
    }

}
