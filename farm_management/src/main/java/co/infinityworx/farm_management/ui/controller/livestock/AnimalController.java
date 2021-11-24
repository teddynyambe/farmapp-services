package co.infinityworx.farm_management.ui.controller.livestock;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEntity;
import co.infinityworx.farm_management.service.livestock.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 18:07
 * Project: user_management
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Map<String, Object>> getAllAnimalsByFarm(@PathVariable String farmId) {
        Map<String, Object> uiResponse = new LinkedHashMap<>();
        List<AnimalEntity> animals = this.animalService.getAllFarmAnimals(farmId);
        uiResponse.put("results", animals == null ? new ArrayList<>() : animals);
        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
    }
}
