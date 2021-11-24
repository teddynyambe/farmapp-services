package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrashPenRepository extends CrudRepository<CrashPenEntity, Long> {
    List<CrashPenEntity> findAllByFarmId(String farmId);
    CrashPenEntity findByCrashPenId(String crashPendId);
    void deleteByCrashPenId(String crashPendId);
}
