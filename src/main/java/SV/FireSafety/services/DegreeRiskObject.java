package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class DegreeRiskObject{
    Long userId;
    DatabaseRepository databaseRepository;


    public DegreeRiskObject(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }
    float square() {
        return databaseRepository.getSquare(userId);
    }
    float heightObject(){return databaseRepository.getHeight_object(userId);}
    float taxFreeIncome(){return databaseRepository.getTax_free_income(userId);}
    int constantlyAtFacility(){return databaseRepository.getConstantly_at_facility(userId);}
    int periodicallyAtFacility(){return databaseRepository.getPeriodically_at_facility(userId);}
    int fixedViolations(){return databaseRepository.getFixed_violations(userId);}
    int noFixedViolations(){return databaseRepository.getNo_fixed_violations(userId);}
    int deadPeople(){return databaseRepository.getDead_people(userId);}
    int injuredPeople(){return databaseRepository.getInjured_people(userId);}
    String typeObjectOfRisk(){return databaseRepository.getType_object_of_risk(userId);}
    String typeStateOwnedObject(){return databaseRepository.getType_state_owned_object(userId);}
    String typeCultureObject(){return databaseRepository.getType_culture_object(userId);}
    String categoryPremisses(){return databaseRepository.getCategory_premises(userId);}
    String typeIndustrialStorageFacility(){return databaseRepository.getType_industrial_storage_facility(userId);}
    String levelEmergency(){return databaseRepository.getLevel_emergency(userId);}
    String typeResultDegreeRisk(){return databaseRepository.getType_result_degree_risk(userId);}
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

    public String degreeRiskObjectExploited() {
        if (typeObjectOfRisk().equals("об'єкт підвищеної небезпеки")) {
            R1 = 31;
        }
        if (typeObjectOfRisk().equals("об'єкт стратегічного значення") && typeStateOwnedObject().equals("I та II категорій критичності")) {
            R1 = 35;
        }
        if (typeObjectOfRisk().equals("об'єкт стратегічного значення")
                && typeStateOwnedObject().equals("III та IV категорій критичності")) {
            R1 = 15;
        }
        if (typeObjectOfRisk().equals("об’єкт метрополітену")) {
            R1 = 28;
        }
        if (typeObjectOfRisk().equals("нерухома пам'ятка") && typeCultureObject().equals("пам'ятка національного значення")) {
            R1 = 30;
        }
        if (typeObjectOfRisk().equals("нерухома пам'ятка") && typeCultureObject().equals("пам'ятка місцевого значення")) {
            R1 = 10;
        }
        if (typeObjectOfRisk().equals("промисловий або складський об’єкт")
                && (categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б"))) {
            R1 = 36;
        }
        if (typeObjectOfRisk().equals("промисловий або складський об’єкт") && categoryPremisses().equals("Категорія В")
                && typeIndustrialStorageFacility().equals("промисловий об'єкт")) {
            if ((square()) <= 1000) {
                R1 = 5;
            } else if ((square()) > 1000 && ((square()) <= 5000)) {
                R1 = 15;
            } else if ((square()) > 5000)
                R1 = 36;
        }
        if (typeObjectOfRisk().equals("промисловий або складський об’єкт") && categoryPremisses().equals("Категорія В")
                && typeIndustrialStorageFacility().equals("складський об’єкт")) {
            if ((square()) <= 5000) {
                R1 = 5;
            } else if ((square()) > 5000 && ((square()) <= 10000)) {
                R1 = 15;
            } else if ((square()) > 10000)
                R1 = 36;
        }
        if (typeObjectOfRisk().equals("промисловий або складський об’єкт")
                && (categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))) {
            R1 = 0;
        }
        if (typeObjectOfRisk().equals("підземні, цокольні та/або підвальні поверхи")){
            R1 = 10;
        }
        if ((square()) <= 300) {
            R2 = 1;
        }
        if ((square()) > 300 && (square()) <= 2000) {
            R2 = 13;
        }
        if ((square()) > 2000 && (square()) <= 7500) {
            R2 = 21;
        }
        if ((square()) > 7500 && (square()) <= 20000) {
            R2 = 26;
        }
        if ((square()) > 20000) {
            R2 = 31;
        }
        if ((constantlyAtFacility()) <= 50) {
            R31 = 5;
        } else if ((constantlyAtFacility()) > 50 && (constantlyAtFacility()) <= 400) {
            R31 = 10;
        } else if ((constantlyAtFacility()) > 400) {
            R31 = 15;
        }
        if ((periodicallyAtFacility()) <= 100) {
            R32 = 5;
        } else if ((periodicallyAtFacility()) > 100 && (periodicallyAtFacility()) <= 1000) {
            R32 = 10;
        } else if ((periodicallyAtFacility()) > 1000) {
            R32 = 15;
        }
        R3 = Math.max(R31, R32);
        if ((heightObject()) <= 9) {
            R4 = 5;
        } else if ((heightObject()) > 9 && (heightObject()) <= 26.5) {
            R4 = 10;
        } else if ((heightObject()) > 26.5 && (heightObject()) <= 47) {
            R4 = 20;
        } else if ((heightObject()) > 47) {
            R4 = 30;
        }
        if (levelEmergency().equals("НС державного рівня")) {
            R5 = 20;
        }
        if (levelEmergency().equals("НС регіонального рівня") && (deadPeople()) >= 3) {
            R5 = 20;
        }
        if (levelEmergency().equals("НС регіонального рівня") && (deadPeople()) < 3) {
            R5 = 10;
        }
        if (levelEmergency().equals("НС місцевого рівня")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 10;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            }
            R5 = Math.max(R51, R52);
        }
        if (levelEmergency().equals("НС об’єктового рівня")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 5;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) >= (300 * (taxFreeIncome()))
                    && (deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            } else if ((deadPeople()) < (300 * (taxFreeIncome()))) {
                R52 = 5;
            }
            if ((injuredPeople()) >= 5) {
                R53 = 10;
            } else if ((injuredPeople()) < 5) {
                R53 = 5;
            }
            R5 = Math.max(R51, R52);
            R5 = Math.max(R5, R53);
        }
        if (levelEmergency().equals("не класифікована НС")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 0;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) >= (300 * (taxFreeIncome()))
                    && (deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            } else if ((deadPeople()) < (300 * (taxFreeIncome()))) {
                R52 = 0;
            }
            if ((injuredPeople()) >= 5) {
                R53 = 10;
            } else if ((injuredPeople()) >= 1 && (injuredPeople()) < 5) {
                R53 = 5;
            } else if ((injuredPeople()) == 0) {
                R53 = 0;
            }
            R5 = Math.max(R51, R52);
            R5 = Math.max(R5, R53);
        }
        if (levelEmergency().equals("без НС")) {
            R5 = 0;
        }
        if (levelEmergency().equals("не класифікована НС") || levelEmergency().equals("НС об’єктового рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);

        }
        if (levelEmergency().equals("НС місцевого рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (levelEmergency().equals("НС регіонального рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (levelEmergency().equals("НС державного рівня") || levelEmergency().equals("без НС")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        int R = R1 + R2 + R3 + R4 + R5 + R6;
        if (R <=20) {
            s = "Висновки:\n"
                    + "Суб’єкт господарювання – незначного ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на п’ять років</b> \uD83D\uDD34";
        }
        if (R >20 && R <=40) {
            s = "Висновки:\n"
                    +"Суб’єкт господарювання – середнього ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на три роки</b> \uD83D\uDD34";
        }
        if (R >40 && R <=100) {
            s = "Висновки:\n"
                    +"Суб’єкт господарювання – високого ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на два роки</b> \uD83D\uDD34";
        }
        return s;
    }

    public String degreeRiskObjectProjected() {
        if (levelEmergency().equals("НС державного рівня")) {
            R5 = 20;
        }
        if (levelEmergency().equals("НС регіонального рівня") && (deadPeople()) >= 3) {
            R5 = 20;
        }
        if (levelEmergency().equals("НС регіонального рівня") && (deadPeople()) < 3) {
            R5 = 10;
        }
        if (levelEmergency().equals("НС місцевого рівня")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 10;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            }
            R5 = Math.max(R51, R52);
        }
        if (levelEmergency().equals("НС об’єктового рівня")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 5;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) >= (300 * (taxFreeIncome()))
                    && (deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            } else if ((deadPeople()) < (300 * (taxFreeIncome()))) {
                R52 = 5;
            }
            if ((injuredPeople()) >= 5) {
                R53 = 10;
            } else if ((injuredPeople()) < 5) {
                R53 = 5;
            }
            R54 = Math.max(R51, R52);
            R5 = Math.max(R54, R53);
        }
        if (levelEmergency().equals("не класифікована НС")) {
            if ((deadPeople()) >= 3) {
                R51 = 20;
            } else if ((deadPeople()) >= 1 && (deadPeople()) < 3) {
                R51 = 10;
            } else if ((deadPeople()) == 0) {
                R51 = 0;
            }
            if ((deadPeople()) >= (1000 * (taxFreeIncome()))) {
                R52 = 15;
            } else if ((deadPeople()) >= (300 * (taxFreeIncome()))
                    && (deadPeople()) < (1000 * (taxFreeIncome()))) {
                R52 = 10;
            } else if ((deadPeople()) < (300 * (taxFreeIncome()))) {
                R52 = 0;
            }
            if ((injuredPeople()) >= 5) {
                R53 = 10;
            } else if ((injuredPeople()) >= 1 && (injuredPeople()) < 5) {
                R53 = 5;
            } else if ((injuredPeople()) == 0) {
                R53 = 0;
            }
            R54 = Math.max(R51, R52);
            R5 = Math.max(R54, R53);
        }
        if (levelEmergency().equals("без НС")) {
            R5 = 0;
        }
        if (levelEmergency().equals("не класифікована НС") || levelEmergency().equals("НС об’єктового рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);

        }
        if (levelEmergency().equals("НС місцевого рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (levelEmergency().equals("НС регіонального рівня")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (levelEmergency().equals("НС державного рівня") || levelEmergency().equals("без НС")) {
            if ((fixedViolations()) > 10) {
                R62 = 5;
            } else if ((fixedViolations()) >= 3 && (fixedViolations()) <= 10) {
                R62 = 3;
            } else if ((fixedViolations()) >= 1 && (fixedViolations()) < 3) {
                R62 = 1;
            }
            if ((noFixedViolations()) > 10) {
                R61 = 25;
            } else if ((noFixedViolations()) >= 3 && (noFixedViolations()) <= 10) {
                R61 = 20;
            } else if ((noFixedViolations()) >= 1 && (noFixedViolations()) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (typeResultDegreeRisk().equals("об’єкт із значними наслідками")){
            R7=41;
        }
        if (typeResultDegreeRisk().equals("об’єкт із середніми наслідками")) {
            R7=21;
        }
        if (typeResultDegreeRisk().equals("об’єкт із незначними наслідками")) {
            R7=11;
        }
        int R = R1 + R2 + R3 + R4 + R5 + R6 + R7;
        if (R <=20) {
            s = "Висновки:\n"
                    + "Суб’єкт господарювання – незначного ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на п’ять років</b> \uD83D\uDD34";
        }
        if (R >20 && R <=40) {
            s = "Висновки:\n"
                    +"Суб’єкт господарювання – середнього ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на три роки</b> \uD83D\uDD34";
        }
        if (R >40 && R <=100) {
            s = "Висновки:\n"
                    +"Суб’єкт господарювання – високого ступеня ризику\n"
                    + "Планові заходи державного нагляду (контролю) у сфері техногенної та пожежної безпеки здійснюються <b>не частіше одного разу на два роки</b> \uD83D\uDD34";
        }
        return s;
    }
}
