package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEventEntity;
import co.infinityworx.farm_management.model.repository.livestock.AnimalEventRepository;
import co.infinityworx.farm_management.service.livestock.AnimalEventService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 14:16
 * Project: farm_management
 */
@Service
public class AnimalEventServiceImpl implements AnimalEventService {
    private AnimalEventRepository animalEventRepository;

    public AnimalEventServiceImpl(AnimalEventRepository animalEventRepository) {
        this.animalEventRepository = animalEventRepository;
    }

    @Override
    public void saveAnimalEvent(AnimalEventEntity animalEvent) {
        if(animalEvent.getAnimalEventId() == null) {
            animalEvent.setAnimalEventId(UUID.randomUUID().toString());
        }
        animalEventRepository.save(animalEvent);
    }
}
