package co.infinityworx.farm_management.model.entity.livestock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 10:30
 * Project: farm_management
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "iw_animal_event")
public class AnimalEventEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "animal_event_id")
    private String animalEventId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    @Getter(value = AccessLevel.NONE)
    private AnimalEntity animal;
    private String description;
    @ManyToOne
    @JoinColumn(name = "specie_event_id", referencedColumnName = "id")
    private SpecieEventTemplateEntity specieEventTemplate;
    private LocalDateTime eventDate;
}
