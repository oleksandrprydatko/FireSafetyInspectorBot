package LDUBGD.Inspector.service;

public class DegreeRiskObject extends ExtinguisherJavaBot {

	String s = null;
	int R1 = 0;
	int R2 = 0;
	int R3 = 0;
	int R31 = 0;
	int R32 = 0;
	int R4 = 0;
	int R5 = 0;
	int R51 = 0;
	int R52 = 0;
	int R53 = 0;
	int R54 = 0;
	int R6 = 0;
	int R61 = 0;
	int R62 = 0;
	int R7 = 0;

	String degreeRiskObjectExploited() {
		if (typeObjectOfRisk == "об'єкт підвищеної небезпеки") {
			R1 = 31;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт оборони") {
			R1 = 33;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт енергетичного комплексу") {
			R1 = 35;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт транспорту") {
			R1 = 21;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт держрезерву") {
			R1 = 30;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт аграрного комплексу") {
			R1 = 25;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт зв'язку") {
			R1 = 20;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт авіації") {
			R1 = 30;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт машинобувної промисловості") {
			R1 = 20;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт металургії") {
			R1 = 22;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт хімпрому") {
			R1 = 31;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт науки") {
			R1 = 10;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт метрології") {
			R1 = 12;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт гідрометеорології") {
			R1 = 14;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт будматеріалів") {
			R1 = 21;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт фінансово-бюджетний") {
			R1 = 15;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт харчовий") {
			R1 = 18;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт легкої промисловості") {
			R1 = 20;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" && typeStateOwnedObject == "об’єкт поліграфії") {
			R1 = 16;
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення"
				&& typeStateOwnedObject == "об’єкт геологорозвідувальний") {
			R1 = 16;
		}
		if (typeObjectOfRisk == "об’єкт метрополітену") {
			R1 = 28;
		}
		if (typeObjectOfRisk == "нерухома пам'ятка" && typeCulturalObject == "пам'ятка національного значення") {
			R1 = 30;
		}
		if (typeObjectOfRisk == "нерухома пам'ятка" && typeCulturalObject == "пам'ятка місцевого значення") {
			R1 = 10;
		}
		if (typeObjectOfRisk == "промисловий або складський об’єкт"
				&& (categoryPremises == "Категорія А" || categoryPremises == "Категорія Б")) {
			R1 = 36;
		}
		if (typeObjectOfRisk == "промисловий або складський об’єкт" && categoryPremises == "Категорія В"
				&& typeIndustrialStorageFacility == "промисловий об'єкт") {
			if (Double.parseDouble(data.get(0)) <= 1000) {
				R1 = 5;
			} else if (Double.parseDouble(data.get(0)) > 1000 && (Double.parseDouble(data.get(0)) <= 5000)) {
				R1 = 15;
			} else if (Double.parseDouble(data.get(0)) > 5000)
				R1 = 36;
		}
		if (typeObjectOfRisk == "промисловий або складський об’єкт" && categoryPremises == "Категорія В"
				&& typeIndustrialStorageFacility == "складський об’єкт") {
			if (Double.parseDouble(data.get(0)) <= 5000) {
				R1 = 5;
			} else if (Double.parseDouble(data.get(0)) > 5000 && (Double.parseDouble(data.get(0)) <= 10000)) {
				R1 = 15;
			} else if (Double.parseDouble(data.get(0)) > 10000)
				R1 = 36;
		}
		if (typeObjectOfRisk == "промисловий або складський об’єкт"
				&& (categoryPremises == "Категорія Г" || categoryPremises == "Категорія Д")) {
			R1 = 0;
		}
		if (Double.parseDouble(data.get(0)) <= 300) {
			R2 = 1;
		}
		if (Double.parseDouble(data.get(0)) > 300 && Double.parseDouble(data.get(0)) <= 2000) {
			R2 = 13;
		}
		if (Double.parseDouble(data.get(0)) > 2000 && Double.parseDouble(data.get(0)) <= 7500) {
			R2 = 21;
		}
		if (Double.parseDouble(data.get(0)) > 7500 && Double.parseDouble(data.get(0)) <= 20000) {
			R2 = 26;
		}
		if (Double.parseDouble(data.get(0)) > 20000) {
			R2 = 31;
		}
		if (Double.parseDouble(data.get(1)) <= 50) {
			R31 = 5;
		} else if (Double.parseDouble(data.get(1)) > 50 && Double.parseDouble(data.get(1)) <= 400) {
			R31 = 10;
		} else if (Double.parseDouble(data.get(1)) > 400) {
			R31 = 15;
		}
		if (Double.parseDouble(data.get(2)) <= 100) {
			R32 = 5;
		} else if (Double.parseDouble(data.get(2)) > 100 && Double.parseDouble(data.get(2)) <= 1000) {
			R32 = 10;
		} else if (Double.parseDouble(data.get(2)) > 1000) {
			R32 = 15;
		}
		R3 = Math.max(R31, R32);
		if (Double.parseDouble(data.get(3)) <= 9) {
			R4 = 5;
		} else if (Double.parseDouble(data.get(3)) > 9 && Double.parseDouble(data.get(3)) <= 26.5) {
			R4 = 10;
		} else if (Double.parseDouble(data.get(3)) > 26.5 && Double.parseDouble(data.get(3)) <= 47) {
			R4 = 20;
		} else if (Double.parseDouble(data.get(3)) > 47) {
			R4 = 30;
		}
		if (levelEmergency == "НС державного рівня") {
			R5 = 20;
		}
		if (levelEmergency == "НС регіонального рівня" && Double.parseDouble(data.get(4)) >= 3) {
			R5 = 20;
		}
		if (levelEmergency == "НС регіонального рівня" && Double.parseDouble(data.get(4)) < 3) {
			R5 = 15;
		}
		if (levelEmergency == "НС місцевого рівня") {
			if (Double.parseDouble(data.get(4)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(4)) == 0) {
				R51 = 10;
			}
			if (Double.parseDouble(data.get(5)) >= (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(5)) < (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 10;
			}
			R5 = Math.max(R51, R52);
		}
		if (levelEmergency == "НС об’єктового рівня") {
			if (Double.parseDouble(data.get(4)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(4)) == 0) {
				R51 = 5;
			}
			if (Double.parseDouble(data.get(5)) >= (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(5)) >= (300 * Double.parseDouble(data.get(6)))
					&& Double.parseDouble(data.get(5)) < (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 10;
			} else if (Double.parseDouble(data.get(5)) < (300 * Double.parseDouble(data.get(6)))) {
				R52 = 5;
			}
			if (Double.parseDouble(data.get(7)) >= 5) {
				R53 = 10;
			} else if (Double.parseDouble(data.get(7)) < 5) {
				R53 = 5;
			}
			R5 = Math.max(R51, R52);
			R5 = Math.max(R5, R53);
		}
		if (levelEmergency == "не класифікована НС") {
			if (Double.parseDouble(data.get(4)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(4)) == 0) {
				R51 = 0;
			}
			if (Double.parseDouble(data.get(5)) >= (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(5)) >= (300 * Double.parseDouble(data.get(6)))
					&& Double.parseDouble(data.get(5)) < (1000 * Double.parseDouble(data.get(6)))) {
				R52 = 10;
			} else if (Double.parseDouble(data.get(5)) < (300 * Double.parseDouble(data.get(6)))) {
				R52 = 0;
			}
			if (Double.parseDouble(data.get(7)) >= 5) {
				R53 = 10;
			} else if (Double.parseDouble(data.get(7)) >= 1 && Double.parseDouble(data.get(7)) < 5) {
				R53 = 5;
			} else if (Double.parseDouble(data.get(7)) == 0) {
				R53 = 0;
			}
			R5 = Math.max(R51, R52);
			R5 = Math.max(R5, R53);
		}
		if (levelEmergency == "без НС") {
			R5 = 0;
		}
		if (levelEmergency == "не класифікована НС" || levelEmergency == "НС об’єктового рівня") {
			if (Double.parseDouble(data.get(8)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(8)) >= 3 && Double.parseDouble(data.get(8)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(8)) >= 1 && Double.parseDouble(data.get(8)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(9)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(9)) >= 3 && Double.parseDouble(data.get(9)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(9)) >= 1 && Double.parseDouble(data.get(9)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);

		}
		if (levelEmergency == "НС місцевого рівня") {
			if (Double.parseDouble(data.get(7)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(7)) >= 3 && Double.parseDouble(data.get(7)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(7)) >= 1 && Double.parseDouble(data.get(7)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(8)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(8)) >= 3 && Double.parseDouble(data.get(8)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(8)) >= 1 && Double.parseDouble(data.get(8)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		if (levelEmergency == "НС регіонального рівня") {
			if (Double.parseDouble(data.get(5)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(5)) >= 3 && Double.parseDouble(data.get(5)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(5)) >= 1 && Double.parseDouble(data.get(5)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(6)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(6)) >= 3 && Double.parseDouble(data.get(6)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(6)) >= 1 && Double.parseDouble(data.get(6)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		if (levelEmergency == "НС державного рівня" || levelEmergency == "без НС") {
			if (Double.parseDouble(data.get(4)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(4)) >= 3 && Double.parseDouble(data.get(4)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(5)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(5)) >= 3 && Double.parseDouble(data.get(5)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(5)) >= 1 && Double.parseDouble(data.get(5)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		int R = R1 + R2 + R3 + R4 + R5 + R6;
		if (R <=20) {
			s = "Висновки:\n"
					+ "Суб’єкт господарювання – незначного ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на п’ять років";
		}
		if (R >20 && R <=40) {
			s = "Висновк:\n"
					+"Суб’єкт господарювання – середнього ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на три роки";
		}
		if (R >40 && R <=100) {
			s = "Висновки:\n"
					+"Суб’єкт господарювання – високого ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на два роки";
		}
		return s;
	}

	String degreeRiskObjectProjected() {
		if (levelEmergency == "НС державного рівня") {
			R5 = 20;
		}
		if (levelEmergency == "НС регіонального рівня" && Double.parseDouble(data.get(0)) >= 3) {
			R5 = 20;
		}
		if (levelEmergency == "НС регіонального рівня" && Double.parseDouble(data.get(0)) < 3) {
			R5 = 15;
		}
		if (levelEmergency == "НС місцевого рівня") {
			if (Double.parseDouble(data.get(0)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(0)) >= 1 && Double.parseDouble(data.get(0)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(0)) == 0) {
				R51 = 10;
			}
			if (Double.parseDouble(data.get(1)) >= (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(1)) < (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 10;
			}
			R5 = Math.max(R51, R52);
		}
		if (levelEmergency == "НС об’єктового рівня") {
			if (Double.parseDouble(data.get(0)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(0)) >= 1 && Double.parseDouble(data.get(0)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(0)) == 0) {
				R51 = 5;
			}
			if (Double.parseDouble(data.get(1)) >= (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(1)) >= (300 * Double.parseDouble(data.get(2)))
					&& Double.parseDouble(data.get(1)) < (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 10;
			} else if (Double.parseDouble(data.get(1)) < (300 * Double.parseDouble(data.get(2)))) {
				R52 = 5;
			}
			if (Double.parseDouble(data.get(3)) >= 5) {
				R53 = 10;
			} else if (Double.parseDouble(data.get(3)) < 5) {
				R53 = 5;
			}
			R54 = Math.max(R51, R52);
			R5 = Math.max(R54, R53);
		}
		if (levelEmergency == "не класифікована НС") {
			if (Double.parseDouble(data.get(0)) >= 3) {
				R51 = 20;
			} else if (Double.parseDouble(data.get(0)) >= 1 && Double.parseDouble(data.get(0)) < 3) {
				R51 = 15;
			} else if (Double.parseDouble(data.get(0)) == 0) {
				R51 = 0;
			}
			if (Double.parseDouble(data.get(1)) >= (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 15;
			} else if (Double.parseDouble(data.get(1)) >= (300 * Double.parseDouble(data.get(2)))
					&& Double.parseDouble(data.get(1)) < (1000 * Double.parseDouble(data.get(2)))) {
				R52 = 10;
			} else if (Double.parseDouble(data.get(1)) < (300 * Double.parseDouble(data.get(2)))) {
				R52 = 0;
			}
			if (Double.parseDouble(data.get(3)) >= 5) {
				R53 = 10;
			} else if (Double.parseDouble(data.get(3)) >= 1 && Double.parseDouble(data.get(3)) < 5) {
				R53 = 5;
			} else if (Double.parseDouble(data.get(3)) == 0) {
				R53 = 0;
			}
			R54 = Math.max(R51, R52);
			R5 = Math.max(R54, R53);
		}
		if (levelEmergency == "без НС") {
			R5 = 0;
		}
		if (levelEmergency == "не класифікована НС" || levelEmergency == "НС об’єктового рівня") {
			if (Double.parseDouble(data.get(4)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(4)) >= 3 && Double.parseDouble(data.get(4)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(5)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(5)) >= 3 && Double.parseDouble(data.get(5)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(5)) >= 1 && Double.parseDouble(data.get(5)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);

		}
		if (levelEmergency == "НС місцевого рівня") {
			if (Double.parseDouble(data.get(3)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(3)) >= 3 && Double.parseDouble(data.get(3)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(3)) >= 1 && Double.parseDouble(data.get(3)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(4)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(4)) >= 3 && Double.parseDouble(data.get(4)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(4)) >= 1 && Double.parseDouble(data.get(4)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		if (levelEmergency == "НС регіонального рівня") {
			if (Double.parseDouble(data.get(1)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(1)) >= 3 && Double.parseDouble(data.get(1)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(1)) >= 1 && Double.parseDouble(data.get(1)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(2)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(2)) >= 3 && Double.parseDouble(data.get(2)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(2)) >= 1 && Double.parseDouble(data.get(2)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		if (levelEmergency == "НС державного рівня" || levelEmergency == "без НС") {
			if (Double.parseDouble(data.get(0)) > 10) {
				R62 = 5;
			} else if (Double.parseDouble(data.get(0)) >= 3 && Double.parseDouble(data.get(0)) <= 10) {
				R62 = 3;
			} else if (Double.parseDouble(data.get(0)) >= 1 && Double.parseDouble(data.get(0)) < 3) {
				R62 = 1;
			}
			if (Double.parseDouble(data.get(1)) > 10) {
				R61 = 25;
			} else if (Double.parseDouble(data.get(1)) >= 3 && Double.parseDouble(data.get(1)) <= 10) {
				R61 = 20;
			} else if (Double.parseDouble(data.get(1)) >= 1 && Double.parseDouble(data.get(1)) < 3) {
				R61 = 10;
			}
			R6 = Math.max(R61, R62);
		}
		if (typeResultDegreeRisk == "об’єкт із значними наслідками") {
			R7=41;
		}
		if (typeResultDegreeRisk == "об’єкт із середніми наслідками") {
			R7=21;
		}
		if (typeResultDegreeRisk == "об’єкт із незначними наслідками") {
			R7=11;
		}
		int R = R1 + R2 + R3 + R4 + R5 + R6 + R7;
		if (R <=20) {
			s = "Висновки:\n"
					+ "Суб’єкт господарювання – незначного ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на п’ять років";
		}
		if (R >20 && R <=40) {
			s = "Висновк:\n"
					+"Суб’єкт господарювання – середнього ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на три роки";
		}
		if (R >40 && R <=100) {
			s = "Висновки:\n"
					+"Суб’єкт господарювання – високого ступеня ризику\n"
					+ "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються не частіше одного разу на два роки";
		}
		return s;
	}
}
