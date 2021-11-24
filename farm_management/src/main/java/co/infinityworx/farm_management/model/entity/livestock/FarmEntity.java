package co.infinityworx.farm_management.model.entity.livestock;

import co.infinityworx.farm_management.util.enums.SizeType;
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
 * Time: 15:31
 * Project: user_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_farm")
public class FarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "farm_id")
    private String farmId;
    @Column(name="farm_name")
    private String farmName;
    private Double farmSize;
    private SizeType sizeType;
    @Column(nullable = false)
    private String owner;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
    @OneToMany(mappedBy = "farm")
    private Set<CrashPenEntity> crashPens;
}
