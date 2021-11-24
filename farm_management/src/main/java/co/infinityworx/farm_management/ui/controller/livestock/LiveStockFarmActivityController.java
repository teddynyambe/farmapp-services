package co.infinityworx.farm_management.ui.controller.livestock;

import co.infinityworx.farm_management.model.entity.livestock.LiveStockFarmActivityEntity;
import co.infinityworx.farm_management.service.livestock.LivesStockFarmActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 20:32
 * Project: farm_management
 */
@RestController
@RequestMapping("/livestock/activity")
public class LiveStockFarmActivityController {
    private LivesStockFarmActivityService livesStockFarmActivityService;
    private ModelMapper modelMapper;

    public LiveStockFarmActivityController(LivesStockFarmActivityService livesStockFarmActivityService, ModelMapper modelMapper) {
        this.livesStockFarmActivityService = livesStockFarmActivityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all/{owner}")
    public ResponseEntity<Map<String, Object>> getAllFarmActivitiesByOwner(@PathVariable String owner) {
        Map<String, Object> uiResponse = new LinkedHashMap<>();
        List<LiveStockFarmActivityEntity> activities = this.livesStockFarmActivityService.getAllFarmActivitiesByOwner(owner);
        uiResponse.put("results", activities == null ? new ArrayList<>() : activities);
        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
    }

//    @GetMapping("/all/{farmId}")
//    public ResponseEntity<Map<String, Object>> getAllFarmActivitiesByFarm(@PathVariable String farmId) {
//        Map<String, Object> uiResponse = new LinkedHashMap<>();
//        List<LiveStockFarmActivityEntity> activities = this.livesStockFarmActivityService.getAllFarmActivitiesByFarmId(farmId);
//        uiResponse.put("results", activities == null ? new ArrayList<>() : activities);
//        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
//    }

    @PostMapping("/save/{farmId}")
    public ResponseEntity<Void> saveAllFarmActivity(@RequestBody List<LiveStockFarmActivityEntity> farmActivities, @PathVariable String farmId) {
        this.livesStockFarmActivityService.deleteAllByFarmId(farmId);
        this.livesStockFarmActivityService.saveAll(farmActivities);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

//    @PostMapping("/")

//    @DeleteMapping("/delete/{farmActivityId")
//    public void deleteFarmActivity(@PathVariable String farmActivityId) {
//        this.livesStockFarmActivityService.deleteFarmActivity(farmActivityId);
//    }
}
