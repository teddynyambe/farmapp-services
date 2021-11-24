package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 18:44
 * Project: user_management
 */
public interface CrashPenService
{
    List<CrashPenEntity> getAllCrashPensByFarmId(String farmId);
    CrashPenEntity getCrashPenByCrashPenId(String crashPenId);
    void deleteCrashPenById(String crashPenId);
    void saveCrashPen(CrashPenEntity crashPen);
    CrashPenEntity getCrashPenById(Long id);

}
