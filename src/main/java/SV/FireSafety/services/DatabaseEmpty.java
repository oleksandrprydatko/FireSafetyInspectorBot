package SV.FireSafety.services;

public class DatabaseEmpty {
    private String roomsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть кількість номерів для проживання та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getRoomsEmpty(){
        return roomsEmpty();
    }

    private String heightEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть умовну висоту будівлі (м.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getHeightEmpty(){
        return heightEmpty();
    }

    private String squareEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSquareEmpty(){
        return squareEmpty();
    }
    private String squareTechnicalEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну площу приміщень технічних приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSquareTechnicalEmpty(){
        return squareTechnicalEmpty();
    }

    private String floorsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getFloorsEmpty(){
        return floorsEmpty();
    }

    private String fireResistanceEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть ступінь вогнестійкості будівлі (1,2,3,3a,3б,4,4a,5) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getFireResistanceEmpty(){
        return fireResistanceEmpty();
    }

    private String seatsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть місткість зали для глядачів та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSeatsEmpty(){
        return seatsEmpty();
    }

    private String booksStorageEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть  фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getBooksStorageEmpty(){
        return booksStorageEmpty();
    }

    private String amountOfTransportEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть  кількість одиниць автотранспорту та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getAmountOfTransportEmpty(){
        return amountOfTransportEmpty();
    }

    private String weightEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну вагу (кг.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getWeightEmpty(){
        return weightEmpty();
    }

    private String volumeEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальний об'єм (м.куб) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getVolumeEmpty(){
        return volumeEmpty();
    }

    private String lengthEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну довжину (м.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getLengthEmpty(){
        return lengthEmpty();
    }

    private String productivityEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть продуктивність (м.куб/год) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getProductivityEmpty(){
        return productivityEmpty();
    }

}
