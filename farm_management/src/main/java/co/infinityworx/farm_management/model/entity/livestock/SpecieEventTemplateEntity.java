package co.infinityworx.farm_management.model.entity.livestock;

import lombok.*;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 10:34
 * Project: farm_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_specie_event_template")
public class SpecieEventTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "specie_event_id")
    private String specieEventId;
    @ManyToOne
    @JoinColumn(name="specie_id", referencedColumnName = "id")
    @Getter(value = AccessLevel.NONE)
    private SpecieEntity specie;
    private String event;
    private Long eventWeight;
}
