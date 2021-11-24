package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEntity;
import co.infinityworx.farm_management.model.repository.livestock.CrashPenRepository;
import co.infinityworx.farm_management.service.livestock.CrashPenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 18:47
 * Project: user_management
 */
@Service
public class CrashPenServiceImpl implements CrashPenService {
    private CrashPenRepository crashPenRepository;

    public CrashPenServiceImpl(CrashPenRepository crashPenRepository) {
        this.crashPenRepository = crashPenRepository;
    }

    @Override
    public List<CrashPenEntity> getAllCrashPensByFarmId(String farmId) {
        List<CrashPenEntity> crashPens = this.crashPenRepository.findAllByFarmId(farmId);
        return crashPens;
    }

    @Override
    public CrashPenEntity getCrashPenByCrashPenId(String crashPenId) {
        CrashPenEntity crashPen = this.crashPenRepository.findByCrashPenId(crashPenId);
        return crashPen;
    }

    @Override
    public void deleteCrashPenById(String crashPenId) {
        this.crashPenRepository.deleteByCrashPenId(crashPenId);
    }

    @Override
    public void saveCrashPen(CrashPenEntity crashPen) {
        if(crashPen.getCrashPenId()==null) {
            crashPen.setCrashPenId(UUID.randomUUID().toString());
        }
        this.crashPenRepository.save(crashPen);
    }

    @Override
    public CrashPenEntity getCrashPenById(Long id) {
        return crashPenRepository.findById(id).get();
    }
}
