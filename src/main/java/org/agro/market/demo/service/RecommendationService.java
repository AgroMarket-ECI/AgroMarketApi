package org.agro.market.demo.service;

import org.agro.market.demo.repository.document.Treatment;

import java.util.List;

public interface RecommendationService {
    List<Treatment> treatmentsByImage(String imageUrl);
}
