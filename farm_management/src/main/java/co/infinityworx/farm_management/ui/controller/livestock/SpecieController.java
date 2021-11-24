package co.infinityworx.farm_management.ui.controller.livestock;

import co.infinityworx.farm_management.model.entity.livestock.SpecieEntity;
import co.infinityworx.farm_management.service.livestock.SpecieService;
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
 * Date: 14/09/2021
 * Time: 23:50
 * Project: farm_services
 */
@RequestMapping("/specie")
@RestController
public class SpecieController {
    private SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }



    @GetMapping("/all/{owner}")
    public ResponseEntity<Map<String, Object>> getAllSpecies(@PathVariable String owner) {
        List<Map<String,Object>> species = this.specieService.getAllSpecies(owner);
        Map<String, Object> userResponse = new LinkedHashMap<>();
        userResponse.put("results", species.size() > 0 ? species : new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(){
        List<SpecieEntity> species = this.specieService.getAll();
        Map<String, Object> userResponse = new LinkedHashMap<>();
        userResponse.put("results", species.size() > 0 ? species : new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
