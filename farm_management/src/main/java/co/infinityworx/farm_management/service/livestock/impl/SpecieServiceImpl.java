package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.LiveStockFarmActivityEntity;
import co.infinityworx.farm_management.model.entity.livestock.SpecieEntity;
import co.infinityworx.farm_management.model.repository.livestock.LiveStockFarmActivityRepository;
import co.infinityworx.farm_management.model.repository.livestock.SpecieRepository;
import co.infinityworx.farm_management.service.livestock.SpecieService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 12:38
 * Project: farm_management
 */
@Service
public class SpecieServiceImpl implements SpecieService {
    private SpecieRepository specieRepository;
    private LiveStockFarmActivityRepository liveStockFarmActivityRepository;

    public SpecieServiceImpl(SpecieRepository specieRepository, LiveStockFarmActivityRepository liveStockFarmActivityRepository) {
        this.specieRepository = specieRepository;
        this.liveStockFarmActivityRepository = liveStockFarmActivityRepository;
    }

    @Override
    public void saveSpecie(SpecieEntity specie) {
        if(specie.getSpecieId() == null) {
            specie.setSpecieId(UUID.randomUUID().toString());
        }
        this.specieRepository.save(specie);
    }

    @Override
    public SpecieEntity getSpecieById(Long id) {
        SpecieEntity specie = this.specieRepository.findById(id).get();
        return specie;
    }

    @Override
    public SpecieEntity getSpecieBySpecieId(String specieId) {
        return specieRepository.findBySpecieId(specieId);
    }

    @Override
    public List<Map<String,Object>> getAllSpecies(String owner) {
        List<Map<String, Object>> species = new LinkedList<>();
        List<LiveStockFarmActivityEntity> allByFarmId = liveStockFarmActivityRepository.getAllByOwner(owner);
        this.specieRepository.findAll().forEach((item) -> {
            LiveStockFarmActivityEntity selectedSpecie = allByFarmId.stream().filter((activity) -> activity.getSpecie().getSpecieId().equals(item.getSpecieId())).findAny().orElse(null);
            if(selectedSpecie != null) {
                System.out.println(selectedSpecie.getId() +" -> " + item.getId());
                    species.add(Map.of("selected", true,"specie", item));
                } else {
                System.out.println("not selected -> " + item.getSpecie());
                    species.add(Map.of("selected", false, "specie", item));
                }
            });
        return species;
    }

    @Override
    public List<SpecieEntity> getAll() {
        List<SpecieEntity> list = new ArrayList<>();
        specieRepository.findAll().forEach((item) -> list.add(item));
        return list;
    }
}
