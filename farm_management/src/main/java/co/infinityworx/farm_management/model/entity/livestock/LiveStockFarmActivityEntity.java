package co.infinityworx.farm_management.model.entity.livestock;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 16:03
 * Project: user_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "iw_livestock_farm_activity")
public class  LiveStockFarmActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="specie_id", referencedColumnName = "id")
    private SpecieEntity specie;
    @Column(name="farm_id")
    private String farmId;
    @Column(name = "owner")
    private String owner;
}
