package org.agro.market.demo.controller.recommendation;

import org.agro.market.demo.repository.document.Treatment;
import org.agro.market.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
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
}
