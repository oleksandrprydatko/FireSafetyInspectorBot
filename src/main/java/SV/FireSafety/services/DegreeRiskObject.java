package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class DegreeRiskObject{
    Long userId;
    DatabaseRepository databaseRepository;

    public DegreeRiskObject(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

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
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт підвищеної небезпеки")) {
            R1 = 31;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт оборони")) {
            R1 = 33;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт енергетичного комплексу")) {
            R1 = 35;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт транспорту")) {
            R1 = 21;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт держрезерву")) {
            R1 = 30;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт аграрного комплексу")) {
            R1 = 25;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт зв'язку")) {
            R1 = 20;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт авіації")) {
            R1 = 30;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт машинобувної промисловості")) {
            R1 = 20;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт металургії")) {
            R1 = 22;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт хімпрому")) {
            R1 = 31;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт науки")) {
            R1 = 10;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт метрології")) {
            R1 = 12;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт гідрометеорології")) {
            R1 = 14;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт будматеріалів")) {
            R1 = 21;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт фінансово-бюджетний")) {
            R1 = 15;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт харчовий")) {
            R1 = 18;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт легкої промисловості")){
            R1 = 20;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення") && databaseRepository.getType_state_owned_object(userId).equals("об’єкт поліграфії")) {
            R1 = 16;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об'єкт стратегічного значення")
                && databaseRepository.getType_state_owned_object(userId).equals("об’єкт геологорозвідувальний")) {
            R1 = 16;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("об’єкт метрополітену")) {
            R1 = 28;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("нерухома пам'ятка") && databaseRepository.getType_culture_object(userId).equals("пам'ятка національного значення")) {
            R1 = 30;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("нерухома пам'ятка") && databaseRepository.getType_culture_object(userId).equals("пам'ятка місцевого значення")) {
            R1 = 10;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("промисловий або складський об’єкт")
                && (databaseRepository.getCategory_premises(userId).equals("Категорія А") || databaseRepository.getCategory_premises(userId).equals("Категорія Б"))) {
            R1 = 36;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("промисловий або складський об’єкт") && databaseRepository.getCategory_premises(userId).equals("Категорія В")
                && databaseRepository.getType_industrial_storage_facility(userId).equals("промисловий об'єкт")) {
            if ((databaseRepository.getSquare(userId)) <= 1000) {
                R1 = 5;
            } else if ((databaseRepository.getSquare(userId)) > 1000 && ((databaseRepository.getSquare(userId)) <= 5000)) {
                R1 = 15;
            } else if ((databaseRepository.getSquare(userId)) > 5000)
                R1 = 36;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("промисловий або складський об’єкт") && databaseRepository.getCategory_premises(userId).equals("Категорія В")
                && databaseRepository.getType_industrial_storage_facility(userId).equals("складський об’єкт")) {
            if ((databaseRepository.getSquare(userId)) <= 5000) {
                R1 = 5;
            } else if ((databaseRepository.getSquare(userId)) > 5000 && ((databaseRepository.getSquare(userId)) <= 10000)) {
                R1 = 15;
            } else if ((databaseRepository.getSquare(userId)) > 10000)
                R1 = 36;
        }
        if (databaseRepository.getType_object_of_risk(userId).equals("промисловий або складський об’єкт")
                && (databaseRepository.getCategory_premises(userId).equals("Категорія Г") || databaseRepository.getCategory_premises(userId).equals("Категорія Д"))) {
            R1 = 0;
        }
        if ((databaseRepository.getSquare(userId)) <= 300) {
            R2 = 1;
        }
        if ((databaseRepository.getSquare(userId)) > 300 && (databaseRepository.getSquare(userId)) <= 2000) {
            R2 = 13;
        }
        if ((databaseRepository.getSquare(userId)) > 2000 && (databaseRepository.getSquare(userId)) <= 7500) {
            R2 = 21;
        }
        if ((databaseRepository.getSquare(userId)) > 7500 && (databaseRepository.getSquare(userId)) <= 20000) {
            R2 = 26;
        }
        if ((databaseRepository.getSquare(userId)) > 20000) {
            R2 = 31;
        }
        if ((databaseRepository.getConstantly_at_facility(userId)) <= 50) {
            R31 = 5;
        } else if ((databaseRepository.getConstantly_at_facility(userId)) > 50 && (databaseRepository.getConstantly_at_facility(userId)) <= 400) {
            R31 = 10;
        } else if ((databaseRepository.getConstantly_at_facility(userId)) > 400) {
            R31 = 15;
        }
        if ((databaseRepository.getPeriodically_at_facility(userId)) <= 100) {
            R32 = 5;
        } else if ((databaseRepository.getPeriodically_at_facility(userId)) > 100 && (databaseRepository.getPeriodically_at_facility(userId)) <= 1000) {
            R32 = 10;
        } else if ((databaseRepository.getPeriodically_at_facility(userId)) > 1000) {
            R32 = 15;
        }
        R3 = Math.max(R31, R32);
        if ((databaseRepository.getHeight_object(userId)) <= 9) {
            R4 = 5;
        } else if ((databaseRepository.getHeight_object(userId)) > 9 && (databaseRepository.getHeight_object(userId)) <= 26.5) {
            R4 = 10;
        } else if ((databaseRepository.getHeight_object(userId)) > 26.5 && (databaseRepository.getHeight_object(userId)) <= 47) {
            R4 = 20;
        } else if ((databaseRepository.getHeight_object(userId)) > 47) {
            R4 = 30;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС державного рівня")) {
            R5 = 20;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") && (databaseRepository.getDead_people(userId)) >= 3) {
            R5 = 20;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") && (databaseRepository.getDead_people(userId)) < 3) {
            R5 = 15;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 10;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            }
            R5 = Math.max(R51, R52);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС об’єктового рівня")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 5;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) >= (300 * (databaseRepository.getTax_free_income(userId)))
                    && (databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            } else if ((databaseRepository.getDead_people(userId)) < (300 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 5;
            }
            if ((databaseRepository.getInjured_people(userId)) >= 5) {
                R53 = 10;
            } else if ((databaseRepository.getInjured_people(userId)) < 5) {
                R53 = 5;
            }
            R5 = Math.max(R51, R52);
            R5 = Math.max(R5, R53);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 0;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) >= (300 * (databaseRepository.getTax_free_income(userId)))
                    && (databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            } else if ((databaseRepository.getDead_people(userId)) < (300 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 0;
            }
            if ((databaseRepository.getInjured_people(userId)) >= 5) {
                R53 = 10;
            } else if ((databaseRepository.getInjured_people(userId)) >= 1 && (databaseRepository.getInjured_people(userId)) < 5) {
                R53 = 5;
            } else if ((databaseRepository.getInjured_people(userId)) == 0) {
                R53 = 0;
            }
            R5 = Math.max(R51, R52);
            R5 = Math.max(R5, R53);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("без НС")) {
            R5 = 0;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("не класифікована НС") || databaseRepository.getLevel_emergency(userId).equals("НС об’єктового рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);

        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
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

    public String degreeRiskObjectProjected() {
        if (databaseRepository.getLevel_emergency(userId).equals("НС державного рівня")) {
            R5 = 20;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") && (databaseRepository.getDead_people(userId)) >= 3) {
            R5 = 20;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") && (databaseRepository.getDead_people(userId)) < 3) {
            R5 = 15;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 10;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            }
            R5 = Math.max(R51, R52);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС об’єктового рівня")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 5;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) >= (300 * (databaseRepository.getTax_free_income(userId)))
                    && (databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            } else if ((databaseRepository.getDead_people(userId)) < (300 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 5;
            }
            if ((databaseRepository.getInjured_people(userId)) >= 5) {
                R53 = 10;
            } else if ((databaseRepository.getInjured_people(userId)) < 5) {
                R53 = 5;
            }
            R54 = Math.max(R51, R52);
            R5 = Math.max(R54, R53);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) {
            if ((databaseRepository.getDead_people(userId)) >= 3) {
                R51 = 20;
            } else if ((databaseRepository.getDead_people(userId)) >= 1 && (databaseRepository.getDead_people(userId)) < 3) {
                R51 = 15;
            } else if ((databaseRepository.getDead_people(userId)) == 0) {
                R51 = 0;
            }
            if ((databaseRepository.getDead_people(userId)) >= (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 15;
            } else if ((databaseRepository.getDead_people(userId)) >= (300 * (databaseRepository.getTax_free_income(userId)))
                    && (databaseRepository.getDead_people(userId)) < (1000 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 10;
            } else if ((databaseRepository.getDead_people(userId)) < (300 * (databaseRepository.getTax_free_income(userId)))) {
                R52 = 0;
            }
            if ((databaseRepository.getInjured_people(userId)) >= 5) {
                R53 = 10;
            } else if ((databaseRepository.getInjured_people(userId)) >= 1 && (databaseRepository.getInjured_people(userId)) < 5) {
                R53 = 5;
            } else if ((databaseRepository.getInjured_people(userId)) == 0) {
                R53 = 0;
            }
            R54 = Math.max(R51, R52);
            R5 = Math.max(R54, R53);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("без НС")) {
            R5 = 0;
        }
        if (databaseRepository.getLevel_emergency(userId).equals("не класифікована НС") || databaseRepository.getLevel_emergency(userId).equals("НС об’єктового рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);

        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) {
            if ((databaseRepository.getFixed_violations(userId)) > 10) {
                R62 = 5;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 3 && (databaseRepository.getFixed_violations(userId)) <= 10) {
                R62 = 3;
            } else if ((databaseRepository.getFixed_violations(userId)) >= 1 && (databaseRepository.getFixed_violations(userId)) < 3) {
                R62 = 1;
            }
            if ((databaseRepository.getNo_fixed_violations(userId)) > 10) {
                R61 = 25;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 3 && (databaseRepository.getNo_fixed_violations(userId)) <= 10) {
                R61 = 20;
            } else if ((databaseRepository.getNo_fixed_violations(userId)) >= 1 && (databaseRepository.getNo_fixed_violations(userId)) < 3) {
                R61 = 10;
            }
            R6 = Math.max(R61, R62);
        }
        if (databaseRepository.getType_result_degree_risk(userId).equals("об’єкт із значними наслідками")){
            R7=41;
        }
        if (databaseRepository.getType_result_degree_risk(userId).equals("об’єкт із середніми наслідками")) {
            R7=21;
        }
        if (databaseRepository.getType_result_degree_risk(userId).equals("об’єкт із незначними наслідками")) {
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
