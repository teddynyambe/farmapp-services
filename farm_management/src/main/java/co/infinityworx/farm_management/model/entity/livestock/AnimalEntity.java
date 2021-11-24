package co.infinityworx.farm_management.model.entity.livestock;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 15:32
 * Project: user_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_animal")
public class AnimalEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="animal_id", unique = true)
    private String animalId;
    private String farmId;
    private String tag;
    @ManyToOne
    private SpecieEntity specie;
    private String description;
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy ="animal", fetch = FetchType.LAZY)
    private Set<AnimalEventEntity> animalEvents;
    @OneToMany(mappedBy ="animal")
    private Set<AnimalBreedEntity> animalBreed;
    @OneToOne
    @JoinColumn(name = "dam_id", referencedColumnName = "id")
    private DamEntity damId;
    @OneToOne
    @JoinColumn(name = "sire_id", referencedColumnName = "id")
    private SireEntity sireId;
}
