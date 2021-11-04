package org.agro.market.demo.service;

import org.agro.market.demo.repository.model.Disease;
import org.agro.market.demo.repository.model.Treatment;

import java.util.List;

public interface RecommendationService {
    List<Treatment> treatmentsByImage(String imageUrl);
    Disease infoDisease(String imageUrl);
}
