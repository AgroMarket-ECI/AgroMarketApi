package org.agro.market.demo.controller.recommendation;

import org.agro.market.demo.repository.model.Disease;
import org.agro.market.demo.repository.model.Treatment;
import org.agro.market.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/recommendation")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(@Autowired RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{imageUrl}")
    public List<Treatment> recommendationsByImage(@PathVariable String imageUrl){
        return recommendationService.treatmentsByImage(imageUrl);
    }

    @GetMapping("/info/{imageUrl}")
    public Disease infoDiseaseByImage(@PathVariable String imageUrl){
        return recommendationService.infoDisease(imageUrl);
    }
    
    @GetMapping("/treatment/{idTreatment}")
    public Treatment TreatmentbyId(@PathVariable int idTreatment){
        return recommendationService.TreatmentbyId(idTreatment);
    }
}
