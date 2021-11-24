package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.LiveStockFarmActivityEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 20:18
 * Project: farm_management
 */
public interface LivesStockFarmActivityService {
    List<LiveStockFarmActivityEntity> getAllFarmActivitiesByOwner(String owner);
    List<LiveStockFarmActivityEntity> getAllFarmActivitiesByFarmId(String farmId);
    void saveFarmActivity(LiveStockFarmActivityEntity farmActivity);
//    void deleteFarmActivity(String farmActivityId);
    void deleteAllByFarmId(String farmId);
    void saveAll(List<LiveStockFarmActivityEntity> activities);
//    LiveStockFarmActivityEntity getFarmActivityByActivityId(String activityId);
}
