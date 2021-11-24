package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.FarmEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FarmRepository extends CrudRepository<FarmEntity, Long> {
    void deleteByFarmId(String farmId);
    List<FarmEntity> findByOwner(String owner);
}
