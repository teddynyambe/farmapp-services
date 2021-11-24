package co.infinityworx.farm_management.model.entity.livestock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 11:57
 * Project: farm_management
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "iw_crashPenEventTemplate")
public class CrashPenEventTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "crashpen_event_id")
    private String crashPenEventId;
    private String event;
    private Long eventWeight;
}
