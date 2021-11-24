package co.infinityworx.farm_management.model.entity.livestock;

import lombok.*;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 15:33
 * Project: user_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_crashpen")
// Holding Yard
public class CrashPenEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "crashpen_id", unique = true)
    private String crashPenId;
    private String description;
    @ManyToOne
    @JoinColumn(name = "farm_id", referencedColumnName = "id")
    @Getter(value = AccessLevel.NONE)
    private FarmEntity farm;
}
