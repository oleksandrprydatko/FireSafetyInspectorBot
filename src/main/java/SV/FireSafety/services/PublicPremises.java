package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class PublicPremises {

    Long userId;
    DatabaseRepository databaseRepository;
    public PublicPremises(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    double[] array = { 0, 0, 0, 0, 0, 0, 0 };

    float square() {
        return databaseRepository.getSquare(userId);
    }
    float squareTechnicalPremisses(){return databaseRepository.getSquare_technical_premises(userId);}
    String b1(){return databaseRepository.getB1(userId);}
    String typeSpacesBuild(){return databaseRepository.getType_spaces_build(userId);}
    int workplace(){return databaseRepository.getWorkplace(userId);}

    public String quantityExtinguisherTekhPrym() {
        double squareTekhPrym = squareTechnicalPremisses();
        String s;
            if (squareTekhPrym == 0){
                s = "🚨 Не задано площу технічного приміщення. Зазначте площу та повторіть спробу!";
            }else {
                array[5] = Math.ceil(squareTekhPrym / 20);
                array[6] = Math.ceil(squareTekhPrym / 20);
                s = "8. Рекомендована додаткова кількість вогнегасників для обладнання технічних приміщень (обираємо один з варіантів на загальну площу технічних приміщень):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6]) + " од. \n";
            }
        return s;
    }

    public String quantityExtinguisherPoroshok() {
        String s = null;

        if (square() <= 100) {
            array[0] = 2;
            array[1] = 2;
            array[2] = 2;
            array[3] = 2;
            array[4] = 2;
            array[5] = Math.ceil(square() / 20);
            array[6] = Math.ceil(square() / 20);
        } else if (square() > 100) {
            array[0] = Math.ceil((Math.ceil(square() / 10)) / 5);
            array[1] = Math.ceil((Math.ceil(square() / 10)) / 6);
            array[2] = Math.ceil((Math.ceil(square() / 10)) / 8);
            array[3] = Math.ceil((Math.ceil(square() / 10)) / 9);
            array[4] = Math.ceil((Math.ceil(square() / 10)) / 12);
            array[5] = Math.ceil(square() / 20);
            array[6] = Math.ceil(square() / 20);

        }
        if (b1().equals("false")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВП-8 - " + ((int) array[2]) + " од. \n" + "4. ВП-9 - " + ((int) array[3]) + " од. \n"
                        + "5. ВП-12 - " + ((int) array[4]) + " од. \n";
                if (typeSpacesBuild().equals("архіви")) {
                    array[5] = Math.ceil(square() / 50);
                    array[6] = Math.ceil(square() / 50);
                    s = s + "🧯"
                            + " Додатково приміщення архівів, бібліотек, музеїв необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6])
                            + " од. \n";
                }
            }
            if (square() > 100) {
                s = s + "🧯 Примітка: дозволяється комбінувати порошкові вогнегасники з різною масою вогнегасної суміші "
                        + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";
            }
        } else if (b1().equals("true")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВП-8 - " + ((int) array[2]) + " од. \n" + "4. ВП-9 - " + ((int) array[3]) + " од. \n"
                        + "5. ВП-12 - " + ((int) array[4]) + " од. \n";
                if (square() < 20) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати:\n";
                    s = s + "1. ВВК-2 - 1 од. \n";
                } else if (square() >= 20 && square() < 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6])
                            + " од. \n";

                } else if (square() > 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6])
                            + " од. \n";
                    s = s + "🧯 Примітка: дозволяється комбінувати порошкові вогнегасники з різною масою вогнегасної суміші "
                            + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";
                }
            }
        }
        return s;

    }

    public String quantityExtinguisherVodopinni() {
        String s = null;

        if (square() <= 100) {
            array[0] = 2;
            array[1] = 2;
            array[2] = 2;
            array[3] = 2;
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);
        } else if (square() > 100) {
            array[0] = Math.ceil((Math.ceil(square() / 10)) / 5);
            array[1] = Math.ceil((Math.ceil(square() / 10)) / 6);
            array[2] = Math.ceil((Math.ceil(square() / 10)) / 9);
            array[3] = Math.ceil((Math.ceil(square() / 10)) / 12);
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);

        }
        if (b1().equals("false")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВП-9 - " + ((int) array[2]) + " од. \n" + "4. ВВП-12 - " + ((int) array[3]) + " од. \n";
                if (typeSpacesBuild().equals("архіви")) {
                    array[4] = Math.ceil(square() / 50);
                    array[5] = Math.ceil(square() / 50);
                    s = s + "🧯"
                            + " Додатково приміщення архівів, бібліотек, музеїв необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";
                }
            }
            if (square() > 100) {
                s = s + "🧯 Примітка: дозволяється комбінувати водопінні вогнегасники з різною масою вогнегасної суміші "
                        + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";
            }
        } else if (b1().equals("true")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВП-9 - " + ((int) array[2]) + " од. \n" + "4. ВВП-12 - " + ((int) array[3]) + " од. \n";
                if (square() < 20) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати:\n";
                    s = s + "1. ВВК-2 - 1 од. \n";
                } else if (square() >= 20 && square() < 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";

                } else if (square() > 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";
                    s = s + "🧯 Примітка: дозволяється комбінувати водопінні вогнегасники з різною масою вогнегасної суміші "
                            + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";
                }

            }
        }
        return s;
    }

    public String quantityExtinguisherVodiani() {
        String s = null;
        if (square() <= 100) {
            array[0] = 2;
            array[1] = 2;
            array[2] = 2;
            array[3] = 2;
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);
        } else if (square() > 100) {
            array[0] = Math.ceil((Math.ceil(square() / 10)) / 5);
            array[1] = Math.ceil((Math.ceil(square() / 10)) / 6);
            array[2] = Math.ceil((Math.ceil(square() / 10)) / 9);
            array[3] = Math.ceil((Math.ceil(square() / 10)) / 12);
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);

        }
        if (b1().equals("false")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + ((int) array[0]) + " од. \n" + "2. ВВ-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВ-12 - " + ((int) array[3]) + " од. \n";
                if (typeSpacesBuild().equals("архіви")) {
                    array[4] = Math.ceil(square() / 50);
                    array[5] = Math.ceil(square() / 50);
                    s = s + "🧯"
                            + " Додатково приміщення архівів, бібліотек, музеїв необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";
                }
            }
            if (square() > 100) {
                s = s + "🧯 Примітка: дозволяється комбінувати водяні вогнегасники з різною масою вогнегасної суміші "
                        + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";
            }
        } else if (b1().equals("true")) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + ((int) array[0]) + " од. \n" + "2. ВВ-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВ-12 - " + ((int) array[3]) + " од. \n";
                if (square() < 20) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати:\n";
                    s = s + "1. ВВК-2 - 1 од. \n";
                } else if (square() >= 20 && square() < 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";

                } else if (square() > 100) {
                    s = s + "🧯" + " Додатково приміщення з оргтехнікою необхідно обладнати (один з варіантів):\n";
                    s = s + "1. ВВК-3,5 - " + ((int) array[4]) + " од. \n" + "2. ВВК-5 - " + ((int) array[5])
                            + " од. \n";
                    s = s + "🧯 Примітка: дозволяється комбінувати водяні вогнегасники з різною масою вогнегасної суміші "
                            + "із розрахунку 1 кг вогнегасної речовини на 10 м.кв. площі";

                }
            }
        }
        return s;
    }
    public String quantityExtinguisherVodianiKitchen() {
        String s;
            array[0] = Math.ceil(workplace());
            array[1] = Math.ceil(workplace());
            array[2] = Math.ceil(workplace());
            array[3] = Math.ceil(workplace());
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення. Зазначте площу та повторіть спробу!";
            } else {
                s = "6. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + ((int) array[0]) + " од. \n" + "2. ВВ-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВ-12 - " + ((int) array[3]) + " од. \n";
                s = s + "❗️ Для гасіння пожеж класу F (горіння речовин, які застосовуються для приготування їжі "
                        + "(рослинні або тваринні масла і жири)) оснащують водяними вогнегасниками, що містять воду "
                        + "з сольовими добавками у відповідності до галузевих норм, погоджених у встановленому порядку";
            }

        return s;
    }
}

