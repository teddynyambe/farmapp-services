package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.FarmEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 16:40
 * Project: user_management
 */

public interface FarmService {
    void saveFarm(FarmEntity farm);
    void deleteFarm(String farmId);
    List<FarmEntity> getAllFarms(String ownerId);
    List<FarmEntity> getFarmsByOwner(String owner);
    FarmEntity getFarmById(Long id);
}
