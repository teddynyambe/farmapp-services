package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.FarmEntity;
import co.infinityworx.farm_management.model.repository.livestock.FarmRepository;
import co.infinityworx.farm_management.service.livestock.FarmService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 17:03
 * Project: user_management
 */
@Service
@Transactional
public class FarmServiceImpl implements FarmService {
    private FarmRepository farmRepository;


    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public void saveFarm(FarmEntity farm) {
        if(farm.getId() == null) {
            farm.setFarmId(UUID.randomUUID().toString());
        }
        farmRepository.save(farm);
    }

    @Override
    public void deleteFarm(String farmId) {
        this.farmRepository.deleteByFarmId(farmId);
    }

    @Override
    public List<FarmEntity> getAllFarms(String ownerId) {
        List<FarmEntity> farms = new ArrayList<>();
        this.farmRepository.findAll().forEach(farm->farms.add(farm));
        return farms;
    }

    @Override
    public List<FarmEntity> getFarmsByOwner(String owner) {
        return this.farmRepository.findByOwner(owner);
    }

    @Override
    public FarmEntity getFarmById(Long id) {
        return this.farmRepository.findById(id).get();
    }
}
