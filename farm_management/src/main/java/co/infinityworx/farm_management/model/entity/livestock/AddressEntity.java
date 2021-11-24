package co.infinityworx.farm_management.model.entity.livestock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 15:46
 * Project: user_management
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iw_address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lineOne;
    private String lineTwo;
    private String latitude;
    private String longitude;
    private String mobileNumber;
    private String town;
    private String province;
    private String country;
    private String areaName;
}
