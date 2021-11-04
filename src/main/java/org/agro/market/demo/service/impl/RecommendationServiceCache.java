package org.agro.market.demo.service.impl;

import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.document.Treatment;
import org.agro.market.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class RecommendationServiceCache implements RecommendationService {

    private static final HashMap<String,List<String>> recommendationsList = new HashMap<>();
    private static final List<Treatment> treatmentsList = new ArrayList<>();

    private final ProductRepository productRepository;

    public RecommendationServiceCache(@Autowired ProductRepository productRepository )
    {
        this.productRepository = productRepository;
    }

    static {
        recommendationsList.put("antracnosis.jpg", new ArrayList<>(Arrays.asList("1", "2", "3","4")));
        recommendationsList.put("oidio.jpg", new ArrayList<>(Arrays.asList("5", "6", "7")));
        recommendationsList.put("podredumbre-gris.jpg", new ArrayList<>(Arrays.asList("8", "9")));
        recommendationsList.put("tizon-temprano.jpg", new ArrayList<>(Arrays.asList("10", "11")));
        recommendationsList.put("botrytis.jpg", new ArrayList<>(Arrays.asList("12", "13")));
        recommendationsList.put("cochinillas.jpg", new ArrayList<>(Arrays.asList("14", "15", "16","17")));

        treatmentsList.add(new Treatment("1","treatment1", new ArrayList<>(Arrays.asList(new Product("618309a81e87654cb3c36585"),new Product("61830a951e87654cb3c36586"),new Product("61830cec1e87654cb3c36587")))));
        treatmentsList.add(new Treatment("2","treatment2", new ArrayList<>(Arrays.asList(new Product("61830e5a1e87654cb3c36588"),new Product("61830eb51e87654cb3c36589"),new Product("61830f2b1e87654cb3c3658a")))));
        treatmentsList.add(new Treatment("12","treatment12", new ArrayList<>(Arrays.asList(new Product("618310691e87654cb3c3658c"),new Product("618310b61e87654cb3c3658d")))));
        treatmentsList.add(new Treatment("13","treatment13", new ArrayList<>(Arrays.asList(new Product("6183111f1e87654cb3c3658e"),new Product("618311761e87654cb3c3658f")))));
    }

    @Override
    public List<Treatment> treatmentsByImage(String imageUrl) {
        List<Product> productsList = new ArrayList<>();
        productsList.addAll(productRepository.findAll());
        List<Treatment> plantTreatments = new ArrayList<>();
        if (recommendationsList.containsKey(imageUrl)){
            List<String> treatmentsByDisease = recommendationsList.get(imageUrl);
            for (String idT : treatmentsByDisease){
                for (Treatment t : treatmentsList){
                    if (idT.equals(t.getId())){
                        t.setProducts(productsByTreatment(t.getProducts(), productsList));
                        plantTreatments.add(t);
                    }
                }
            }
        }
        return plantTreatments;
    }

    private List<Product> productsByTreatment(List<Product> products, List<Product> productsList) {
        List<Product> productTreatments = new ArrayList<>();
        for (Product prevP : products){
            for (Product posP : productsList){
                if (prevP.getId().equals(posP.getId())){
                    productTreatments.add(posP);
                }
            }
        }
        return productTreatments;
    }
}