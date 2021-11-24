package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.LiveStockFarmActivityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LiveStockFarmActivityRepository extends CrudRepository<LiveStockFarmActivityEntity, Long> {
    List<LiveStockFarmActivityEntity> getAllByOwner(String owner);
    List<LiveStockFarmActivityEntity> getAllByFarmId(String farmId);
//    void deleteByFarmActivityId(String farmActivityId);
//    List<LiveStockFarmActivityEntity> findByOwner(String owner);
    void deleteAllByFarmId(String farmId);
}
