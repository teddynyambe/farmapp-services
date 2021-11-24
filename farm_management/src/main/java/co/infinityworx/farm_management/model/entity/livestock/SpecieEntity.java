package co.infinityworx.farm_management.model.entity.livestock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
@Table(name = "iw_specie")
public class SpecieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "specie_id", unique = true, nullable = false)
    private String specieId;
    private String specie;

//    @OneToMany(mappedBy = "specie")
//    private Set<SpecieEventTemplateEntity> specieEventTemplateEntity;
}
