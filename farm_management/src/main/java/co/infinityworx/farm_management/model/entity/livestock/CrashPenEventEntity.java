package co.infinityworx.farm_management.model.entity.livestock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 11:51
 * Project: farm_management
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "iw_crashpen_event")
public class CrashPenEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "crashpen_event_id")
    private String crashPenEventId;
    @ManyToOne
    @JoinColumn(name = "crashPen_id")
    private CrashPenEntity crashPen;
    @ManyToOne
    @JoinColumn(name = "specie_event_id", referencedColumnName = "id")
    private CrashPenEventTemplateEntity crashPenEventTemplate;
    private LocalDateTime eventDate;
}
