package SV.FireSafety.services;

public class PublicPremises extends Variables {
    Variables variables = new Variables();
    double array[] = { 0, 0, 0, 0, 0, 0, 0 };

    double square() {
        if (variables.getData().isEmpty() == false) {
            return Double.parseDouble(variables.getData().get(0));
        } else {
            return 0;
        }
    }

    public String quantityExtinguisherTekhPrym() {
        double squareTekhPrym = 0;
        String s = null;
        if (variables.getKitchen() == "кухні") {

            if (variables.getData().size() > 1) {
                squareTekhPrym = Double.parseDouble(variables.getData().get(2));
                array[5] = Math.ceil(squareTekhPrym / 20);
                array[6] = Math.ceil(squareTekhPrym / 20);
                s = "8. Рекомендована додаткова кількість вогнегасників для обладнання технічних приміщень (обираємо один з варіантів на загальну площу технічних приміщень):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6]) + " од. \n";
            } else {
                s = "🚨 Не задано площу технічного приміщення. Зазначне площу та повторіть спробу!";
            }
        } else {
            if (variables.getData().size() > 1) {
                squareTekhPrym = Double.parseDouble(variables.getData().get(1));
                array[5] = Math.ceil(squareTekhPrym / 20);
                array[6] = Math.ceil(squareTekhPrym / 20);
                s = "8. Рекомендована додаткова кількість вогнегасників для обладнання технічних приміщень (обираємо один з варіантів на загальну площу технічних приміщень):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + ((int) array[5]) + " од. \n" + "2. ВВК-5 - " + ((int) array[6]) + " од. \n";
            } else {
                s = "🚨 Не задано площу технічного приміщення. Зазначне площу та повторіть спробу!";
            }
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
        if (variables.isB1() == false) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВП-8 - " + ((int) array[2]) + " од. \n" + "4. ВП-9 - " + ((int) array[3]) + " од. \n"
                        + "5. ВП-12 - " + ((int) array[4]) + " од. \n";
                if (variables.getTypeSpacesBuild() == "архіви") {
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
        } else if (variables.isB1() == true) {
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
        if (variables.isB1() == false) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВВП-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВП-9 - " + ((int) array[2]) + " од. \n" + "4. ВВП-12 - " + ((int) array[3]) + " од. \n";
                if (variables.getTypeSpacesBuild() == "архіви") {
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
        } else if (variables.isB1() == true) {
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
        if (variables.getKitchen() == "кухні") {
            array[0] = Math.ceil(Double.parseDouble(variables.getData().get(1)));
            array[1] = Math.ceil(Double.parseDouble(variables.getData().get(1)));
            array[2] = Math.ceil(Double.parseDouble(variables.getData().get(1)));
            array[3] = Math.ceil(Double.parseDouble(variables.getData().get(1)));
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення. Зазначне площу та повторіть спробу!";
            } else {
                s = "6. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + ((int) array[0]) + " од. \n" + "2. ВВ-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВ-12 - " + ((int) array[3]) + " од. \n";
                s = s + "❗️ Для гасіння пожеж класу F (горіння речовин, які застосовуються для приготування їжі "
                        + "(рослинні або тваринні масла і жири)) оснащують водяними вогнегасниками, що містять воду "
                        + "з сольовими добавками у відповідності до галузевих норм, погоджених у встановленому порядку";
            }
        }

        if (variables.getKitchen() == null && square() <= 100) {
            array[0] = 2;
            array[1] = 2;
            array[2] = 2;
            array[3] = 2;
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);
        } else if (variables.getKitchen() == null && square() > 100) {
            array[0] = Math.ceil((Math.ceil(square() / 10)) / 5);
            array[1] = Math.ceil((Math.ceil(square() / 10)) / 6);
            array[2] = Math.ceil((Math.ceil(square() / 10)) / 9);
            array[3] = Math.ceil((Math.ceil(square() / 10)) / 12);
            array[4] = Math.ceil(square() / 20);
            array[5] = Math.ceil(square() / 20);

        }
        if (variables.getKitchen() == null && variables.isB1() == false) {
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + ((int) array[0]) + " од. \n" + "2. ВВ-6 - " + ((int) array[1]) + " од. \n"
                        + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВ-12 - " + ((int) array[3]) + " од. \n";
                if (variables.getTypeSpacesBuild() == "архіви") {
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
        } else if (variables.isB1() == true) {
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
}
