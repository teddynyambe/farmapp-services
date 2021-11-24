package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.LiveStockFarmActivityEntity;
import co.infinityworx.farm_management.model.repository.livestock.LiveStockFarmActivityRepository;
import co.infinityworx.farm_management.service.livestock.LivesStockFarmActivityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 20:24
 * Project: farm_management
 */
@Service
@Transactional
public class LiveStockFarmActivityServiceImpl implements LivesStockFarmActivityService {
    private LiveStockFarmActivityRepository liveStockFarmActivityRepository;

    public LiveStockFarmActivityServiceImpl(LiveStockFarmActivityRepository liveStockFarmActivityRepository) {
        this.liveStockFarmActivityRepository = liveStockFarmActivityRepository;
    }

    @Override
    public List<LiveStockFarmActivityEntity> getAllFarmActivitiesByOwner(String owner) {
        List<LiveStockFarmActivityEntity> farmActivities = this.liveStockFarmActivityRepository.getAllByOwner(owner);
        return farmActivities;
    }

    @Override
    public List<LiveStockFarmActivityEntity> getAllFarmActivitiesByFarmId(String farmId) {
        List<LiveStockFarmActivityEntity> farmActivities = this.liveStockFarmActivityRepository.getAllByFarmId(farmId);
        return farmActivities;
    }

    @Override
    public void saveFarmActivity(LiveStockFarmActivityEntity farmActivity) {
//        if(farmActivity.getFarmActivityId() == null) {
//            farmActivity.setFarmActivityId(UUID.randomUUID().toString());
//        }
        this.liveStockFarmActivityRepository.save(farmActivity);
    }

//    @Override
//    public void deleteFarmActivity(String farmActivityId) {
//        this.liveStockFarmActivityRepository.deleteByFarmActivityId(farmActivityId);
//    }

    @Override
    public void deleteAllByFarmId(String farmId) {
        liveStockFarmActivityRepository.deleteAllByFarmId(farmId);
    }

    @Override
    public void saveAll(List<LiveStockFarmActivityEntity> activities) {
        liveStockFarmActivityRepository.saveAll(activities);
    }

//    @Override
//    public LiveStockFarmActivityEntity getFarmActivityByActivityId(String activityId) {
//        return this.liveStockFarmActivityRepository.findByFarmActivityId(activityId);
//    }
}