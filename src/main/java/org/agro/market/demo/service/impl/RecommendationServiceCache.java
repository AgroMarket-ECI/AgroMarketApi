package org.agro.market.demo.service.impl;

import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.model.Disease;
import org.agro.market.demo.repository.model.Treatment;
import org.agro.market.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class RecommendationServiceCache implements RecommendationService {

    private static final HashMap<String, List<String>> recommendationsList = new HashMap<>();
    private static final List<Treatment> treatmentsList = new ArrayList<>();
    private static final List<Disease> diseasesList = new ArrayList<>();

    private final ProductRepository productRepository;

    public RecommendationServiceCache(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    static {

        diseasesList.add(new Disease("antracnosis", "Las manchas de apariencia de mojada en el follaje o los frutos son los primeros indicios visibles. El tejido de las hojas muere, adquiriendo una textura de papel y un color marrón a medida que la enfermedad se propaga. En los frutos que maduran, como el tomate o la papaya, las manchas circulares de aspecto acuoso (como podrido) que se hunden hacia el interior crecen y penetran en el fruto.", "antracnosis.jpg"));
        diseasesList.add(new Disease("botrytis", "Suelen ser unas manchas de color marrón en las hojas y capullos, o manchas oscuras en los pétalos de las flores. Al avanzar la enfermedad, las flores y los frutos se pudren, y las manchas comienzan a verse como un moho velloso de tono grisáceo. \n" +
                "Aunque por sí solo no suele matar las orquídeas, las debilita y favorece el asentamiento y progreso de otras plagas.", "botrytis.jpg"));
        diseasesList.add(new Disease("oidio", "Se caracteriza por la aparición de manchas blanquecinas como si fuera un especie de harina que va secando las hojas. Se trata de un hongo que actúa sobre tallos y hojas de la planta.\n" +
                "\n" +
                "Las hojas infectadas se tornan amarillas y se retuercen. Los retoños y capullos de flores crecen de forma distorsionada, y las flores y frutos no suelen tener el moho blanco pero las plantas infectadas producirán una cosecha pobre y frutos de poca calidad..", "oidio.jpg"));
        diseasesList.add(new Disease("podredumbre-gris", "En hojas se caracteriza por presentar manchas café en V desde el borde de la hoja. También puede secar completamente las hojas donde se observa el crecimiento del micelio sobre el tejido afectado. En tallo y brotes, se presenta necrosis, compresión y muerte del tejido. En frutos se pueden presentar zonas acuosas en frutos verdes como también pudrición en frutos maduros causando pérdidas de producción importantes.\n", "podredumbre-gris.jpg"));
        diseasesList.add(new Disease("tizon-temprano", "Los primeros síntomas no suelen aparecer hasta que los frutos se han formado. Las manchas en las hojas aparecen primero en las hojas inferiores y más antiguas, y luego avanzan hacia la parte superior.\n" +
                "\n" +
                "Las manchas del tizón temprano empiezan como manchas irregulares de color marrón que se amplían de forma similar a los aros de una diana alrededor de un centro de tejido muerto. La hoja se pone amarilla, luego marrón y finalmente se cae de la planta. Los frutos afectados presentan grietas o manchas hundidas cerca del tallo. A diferencia de las manchas enchumbadas en agua de la antracnosis, las lesiones del tizón temprano tienen una apariencia seca o semejante al cuero.", "tizon-temprano.jpg"));
        diseasesList.add(new Disease("cochinillas", "Estas debilitan las plantas al succionar los jugos de los tallos y las hojas. Las plantas afectadas se marchitan, se enrollan y pierden el color. Las hojas se caen de forma prematura, los frutos no se forman adecuadamente y las ramas pequeñas mueren. Las cochinillas pseudocóccidas excretan una sustancia dulce llamada ligamaza que a menudo se convierte en un moho negro. Las hormigas se alimentan de esta ligamaza y, por lo tanto, suelen acompañar a las infestaciones de cochinillas.", "cochinillas.jpg"));

        recommendationsList.put("antracnosis.jpg", new ArrayList<>(Arrays.asList("1", "2", "3", "4")));
        recommendationsList.put("oidio.jpg", new ArrayList<>(Arrays.asList("5", "6", "7")));
        recommendationsList.put("podredumbre-gris.jpg", new ArrayList<>(Arrays.asList("8", "9")));
        recommendationsList.put("tizon-temprano.jpg", new ArrayList<>(Arrays.asList("10", "11")));
        recommendationsList.put("botrytis.jpg", new ArrayList<>(Arrays.asList("12", "13")));
        recommendationsList.put("cochinillas.jpg", new ArrayList<>(Arrays.asList("14", "15", "16", "17")));

        treatmentsList.add(new Treatment("1", "treatment1",
                "1.\tUse el Daconil al detectar el primer síntoma de la enfermedad o como tratamiento preventivo.\n" +
                        "2.\tAgítelo bien y sostenga el rociador a una distancia de 8 pulg. a 12 pulg. (20,32 cm a 30,48 cm) del área a tratar.\n" +
                        "3.\tDespués de 24 horas, utilice el carbendazim para rocear su planta hasta mojar completamente las superficies superiores e inferiores.\n" +
                        "4.\tEvite el riego desde arriba para no estimular el brote ni propagar la enfermedad.\n" +
                        "5.\tPara tener un tratamiento completo y efectivo use el casafe-v para evitar el crecimiento de maleza. Asegúrese de instruirse con un profesional para proporcionar la cantidad adecuada a su planta.\n", new ArrayList<>(Arrays.asList(new Product("61a90d1eaa24ecbcbe2c9ce7"), new Product("61a90dbcaa24ecbcbe2c9ce9"), new Product("61a90d7faa24ecbcbe2c9ce8")))));
        treatmentsList.add(new Treatment("2", "treatment2",
                "1.\tUsar guantes impermeables durante la manipulación y la aplicación.\n" +
                        "2.\tSe recomienda usar el cabrio WG en una o dos aplicaciones con un intervalo de 15 días, con un plazo de seguridad de 100 días y con una dosis de 0,5 Kg/ha.\n" +
                        "3.\tEmpezar el uso de codimurm junto a él cabrio WG.\n" +
                        "4.\tVerter agua en un recipiente con el polvo de codimurm y agitar hasta conseguir la disolución del polvo. Aplicar a dosis de 0.3%-0.4%, limitar la aplicación a un máximo de 6 aplicaciones por periodo de cultivo (con un intervalo entre tratamientos de 7 días).\n" +
                        "5.\tPara un resultado más efectivo usar el poltix con una dosis a valorar según el desarrollo del hongo. Aconsejamos utilizar una dosis más alta de 40-80 cc/hl durante los periodos de mayor riesgo de ataque y sobre las variedades más sensibles.\n", new ArrayList<>(Arrays.asList(new Product("61a90e01aa24ecbcbe2c9ceb"), new Product("61a90e79aa24ecbcbe2c9cef"), new Product("61a90e3aaa24ecbcbe2c9ced")))));
        treatmentsList.add(new Treatment("12", "treatment12",
                "1.\tAplicar el Teldor fungicida preventivamente o al observarse los primeros síntomas de la enfermedad.\n" +
                "2.\tAplicar al 0.15% con un máximo de 1,5 kg/ha de producto, excepto en cultivos de invernadero en aplicaciones con lanza o pistola, que se aplicará como máximo 1.25 kg/ha.\n" +
                "3.\tPasada 1 hora de la aplicación del Teldor fungicida, agitar bien el producto de Fordazim fungicida antes de usarlo.\n" +
                "4.\tHacer una premezcla en poca cantidad de agua. \n" +
                "5.\tLlenar un recipiente con agua hasta la mitad, agregar la premezcla y completar la cantidad de agua para la dosis recomendada por hectárea que vienen en la ficha técnica del producto.\n" +
                "6.\tRepetir el tratamiento a diario hasta obtener resultados.\n", new ArrayList<>(Arrays.asList(new Product("61a90e3aaa24ecbcbe2c9ced"), new Product("61a90e24aa24ecbcbe2c9cec")))));
        treatmentsList.add(new Treatment("13", "treatment13",
                "1.\tDebido a que el uso de Maneb es más eficaz cuando se utiliza en tratamientos preventivos, se recomienda usarlo al ver los primeros indicios de la enfermedad o cuando las condiciones climáticas favorezcan el establecimiento y desarrollo de este tipo de enfermedades.\n" +
                "2.\tAplicar el Maneb fungicida en pulverización normal 250 g/hl ó 1,5 - 2,5 kg/ha, especialmente cuando se utilicen pulverizadores de bajo volumen.\n" +
                "3.\tPara el uso del fungicida Arko se requiere diluir el polvo que este contine en agua y mezclar hasta que quede totalmente homogéneo. \n" +
                "4.\tRociar el producto sobre la zona afectada y dejar actuar. Repetir el proceso 3 veces por semana.\n", new ArrayList<>(Arrays.asList(new Product("61a90e5eaa24ecbcbe2c9cee"), new Product("61a90e79aa24ecbcbe2c9cef")))));
        treatmentsList.add(new Treatment("5", "treatment5",
                "1.\tAgregue 20 g de HTpro DUNE por cada litro de agua.\n" +
                        "2.\tMezcle totalmente y rocié con pulverizador sobre la hojas.\n" +
                        "3.\tPasados 30 minutos utilice humus líquido para distribuirlo sobre el suelo de cultivo utilizando una proporción que oscile entre el medio kilo y el kilo por metro cuadrado.\n" +
                        "4.\tHumus líquido día de por medio durante una semana y notará el cambio increíblemente en sus frutos. No solo serán de mayor tamaño, sino que, además, tendrán mejor sabor.\n", new ArrayList<>(Arrays.asList(new Product("61b181bf02341973a7ef30ec"), new Product("61b1825f02341973a7ef30ed")))));

        treatmentsList.add(new Treatment("6", "treatment6",
                "1.\tUse guantes impermeables durante la manipulación y la aplicación.\n" +
                        "2.\tCombinar el azufre en polvo con el fungicida Sercadis para aumentar la eficacia.\n" +
                        "3.\tEspolvorear la mezcla anterior sobre la planta afectada a temperaturas menores de 28º y con baja humedad.\n" +
                        "4.\tPara finalizar el tratamiento aplicar el Trichox en suspensión luego de ser dispersado en agua.\n", new ArrayList<>(Arrays.asList(new Product("61b1833202341973a7ef30ee"), new Product("61b1844102341973a7ef30ef"), new Product("61b1849002341973a7ef30f0")))));
    }

    @Override
    public List<Treatment> treatmentsByImage(String imageUrl) {
        List<Product> productsList = new ArrayList<>();
        productsList.addAll(productRepository.findAll());
        List<Treatment> plantTreatments = new ArrayList<>();
        if (recommendationsList.containsKey(imageUrl)) {
            List<String> treatmentsByDisease = recommendationsList.get(imageUrl);
            for (String idT : treatmentsByDisease) {
                for (Treatment t : treatmentsList) {
                    if (idT.equals(t.getId())) {
                        t.setProducts(productsByTreatment(t.getProducts(), productsList));
                        plantTreatments.add(t);
                    }
                }
            }
        }
        return plantTreatments;
    }

    @Override
    public Disease infoDisease(String imageUrl) {
        for (Disease d : diseasesList) {
            if (d.getImage().equals(imageUrl)) {
                return d;
            }
        }
        return null;
    }

    private List<Product> productsByTreatment(List<Product> products, List<Product> productsList) {
        List<Product> productTreatments = new ArrayList<>();
        for (Product prevP : products) {
            for (Product posP : productsList) {
                if (prevP.getId().equals(posP.getId())) {
                    productTreatments.add(posP);
                }
            }
        }
        return productTreatments;
    }

	@Override
	public Treatment TreatmentbyId(int idTreatment) {
		for(Treatment treatment:treatmentsList) {
			if(treatment.getId().equals(idTreatment+"")) {
				return treatment;
			}
		}
		return null;
	}


}