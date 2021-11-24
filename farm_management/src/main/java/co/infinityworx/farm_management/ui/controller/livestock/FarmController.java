package co.infinityworx.farm_management.ui.controller.livestock;

import co.infinityworx.farm_management.model.entity.livestock.FarmEntity;
import co.infinityworx.farm_management.service.livestock.FarmService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 21:25
 * Project: user_management
 */
@RestController
@RequestMapping("/farm")
public class FarmController {
    private FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/all/{owner}")
    public ResponseEntity<Map<String, Object>> getAllFarmsByOwner(@PathVariable String owner) {
        System.out.println("============ In here =============");
        Map<String, Object> uiResponse = new LinkedHashMap<>();
        List<FarmEntity> allFarms = farmService.getFarmsByOwner(owner);
        uiResponse.put("results", allFarms);
        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
    }

//    @GetMapping("/all/{farmId}")
//    public ResponseEntity<Map<String, Object>> getFarmByOwnerAndFarmId(@PathVariable String farmId, @PathVariable String owner) {
//        Map<String, Object> uiResponse = new LinkedHashMap<>();
//        FarmEntity farm = this.farmService.getFarmsByOwner(owner);
//        uiResponse.put("results", farm == null ? new ArrayList<FarmEntity>() : farm);
//
//        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
//    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveFarm(@RequestBody FarmEntity farm){
        this.farmService.saveFarm(farm);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @DeleteMapping("/{farmId}")
    public ResponseEntity<Void> deleteFarm(@PathVariable String farmId) {
        this.farmService.deleteFarm(farmId);
        return  ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
