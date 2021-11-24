package co.infinityworx.farm_management.model.entity.livestock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 21/07/2021
 * Time: 11:33
 * Project: farm_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_sire")
public class SireEntity {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private AnimalEntity animal;
}
