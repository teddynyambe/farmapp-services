package co.infinityworx.farm_management.ui.controller.livestock;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEntity;
import co.infinityworx.farm_management.service.livestock.CrashPenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 19:01
 * Project: user_management
 */
@RestController
@RequestMapping("/crashpen")
public class CrashPenController {
    private CrashPenService crashPenService;

    public CrashPenController(CrashPenService crashPenService) {
        this.crashPenService = crashPenService;
    }
//
//    @GetMapping("/all/{farmId}")
//    private ResponseEntity<Map<String, Object>> getAllCrashPensByFarmId(@PathVariable String farmId) {
//        Map<String, Object> uiResponse = new LinkedHashMap<>();
//        List<CrashPenEntity> crashPens = this.crashPenService.getAllCrashPensByFarmId(farmId);
//        uiResponse.put("results", crashPens);
//        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
//    }
//
//    @GetMapping("/{crashPenId}")
//    public ResponseEntity<Map<String, Object>> getCrashPenByCrashPenId(@PathVariable String crashPenId) {
//        Map<String, Object> uiResponse = new LinkedHashMap<>();
//        this.crashPenService.getCrashPenByCrashPenId(crashPenId);
//        return ResponseEntity.status(HttpStatus.OK).body(uiResponse);
//    }
//
//    @PostMapping("/save")
//    public void saveCrashPen(@RequestBody CrashPenEntity crashPen) {
//        this.crashPenService.saveCrashPen(crashPen);
//    }
//    @DeleteMapping("/delete/{crashPenId")
//    public void deleteCrashPen(@PathVariable String crashPenId) {
//        this.crashPenService.deleteCrashPenById(crashPenId);
//    }

}
