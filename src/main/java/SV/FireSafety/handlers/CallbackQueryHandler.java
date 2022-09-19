package SV.FireSafety.handlers;

import SV.FireSafety.messagesender.MessageSender;
import SV.FireSafety.services.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;


@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {

    //конструктор класу MessageSender
    private final MessageSender messageSender;

    public CallbackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    //екземпляри класів
    InstructionExtinguisher instructionExtinguisher = new InstructionExtinguisher();
    InlineButton inlineButton = new InlineButton();
    Categories categories = new Categories();
    Characteristics characteristics = new Characteristics();
    DBWorker dbWorker = new DBWorker();

    //
    String s2 = null;
    String s3 = null;
    String s4 = null;
    String s5 = null;
    String s7 = null;
    String s8 = null;
    String s9 = null;
    String s10 = null;

    @Override
    public void choose(CallbackQuery callbackQuery) {
        //надіслати нове повідомлення в конкретний чат
        Message message = callbackQuery.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.HTML);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        //надіслати друге повідомлення
        SendMessage sendSecondMessage = new SendMessage();
        sendSecondMessage.setParseMode(ParseMode.HTML);
        sendSecondMessage.setChatId(String.valueOf(message.getChatId()));
        String chatID = String.valueOf(message.getChatId());
        //екземпляр класу з параметром
        CategoryBuilding categoryBuilding = new CategoryBuilding(chatID);
        //тип та необхідність вогнегасників
        switch (callbackQuery.getData()) {
            case "Розпочати":
                if ( dbWorker.getComandOfMenu(chatID).equals("/type_number_fire_extinguishers")) {
                    sendMessage.setText("1. Оберіть тип приміщення/об'єкту");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else if (dbWorker.getComandOfMenu(chatID).equals("/degree_of_risk_from_activities")){
                    sendMessage.setText("1. Оберіть характеристику об’єкта");
                    sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskTechnicalPremisesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else if(dbWorker.getComandOfMenu(chatID).equals("/determination_of_categories")) {
                    sendMessage.setText("1. Оберіть характеристику, що необхідно визначити");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "Інструкція":
                sendMessage.setText(instructionExtinguisher.instruction());
                messageSender.sendMessage(sendMessage);
                break;
            case "Виробничі/складські":
                s2 = "Обрано: Виробничі (складські) приміщення";
                sendMessage.setText(s2);
                messageSender.sendMessage(sendMessage);
                //встановлюємо в БД тип приміщення
                dbWorker.setTypePremises(chatID,"Виробничі_складські");
                sendMessage.setText("2. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою (порядковість не має значення)");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCategoryPremissesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія А":
                s3 = "Обрано: приміщення категорії А";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                dbWorker.setCategoryPremises(chatID,"Категорія А");
                sendMessage.setText("3. Оберіть клас можливої пожежі");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Б":
                s3 = "Обрано: приміщення категорії Б";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                dbWorker.setCategoryPremises(chatID,"Категорія Б");
                sendMessage.setText("3. Оберіть клас можливої пожежі");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія В":
                s3 = "Обрано: приміщення категорії В";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                dbWorker.setCategoryPremises(chatID,"Категорія В");
                sendMessage.setText("2.1. Зазначте чи наявні в приміщенні виробництва (складському примішенні) горючі рідини та гази");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForBKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "наявні горючі рідини та гази":
                s3 = "Обрано: приміщення категорії В з наявністю горючих рідин та газів";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорію приміщень
                dbWorker.setCategoryPremises(chatID,"Категорія В з ГГ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "відсутні горючі рідини та гази":
                s3 = "Обрано: приміщення категорії В за відсутності горючих рідин та газів";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорію приміщень
                dbWorker.setCategoryPremises(chatID,"Категорія В без ГГ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForB2_ДKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Г":
                s3 = "Обрано: приміщення категорії Г";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                dbWorker.setCategoryPremises(chatID,"Категорія Г");
                sendMessage.setText("3. Оберіть клас можливої пожежі");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Д":
                s3 = "Обрано: приміщення категорії Д";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                dbWorker.setCategoryPremises(chatID,"Категорія Д");
                sendMessage.setText("3. Оберіть клас можливої пожежі");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForB2_ДKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі A":
                s4 = "Обрано: клас ймовірної пожежі A";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі A");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassAKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі B":
                s4 = "Обрано: клас ймовірної пожежі B";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі B");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassВKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі C":
                s4 = "Обрано: клас ймовірної пожежі C";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі C");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassC_DKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі D":
                s4 = "Обрано: клас ймовірної пожежі D";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі D");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassC_DKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі F":
                s4 = "Обрано: клас ймовірної пожежі F";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //становлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі F");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassFKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі E":
                s4 = "Обрано: клас ймовірної пожежі E";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                dbWorker.setClassFire(chatID,"Клас пожежі E");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassEKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Порошковий":
                s5 = "Обрано: порошковий вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                dbWorker.setTypeExtinguisher(chatID,"порошковий");
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"площа");
                messageSender.sendMessage(sendMessage);
                break;
            case "Водопінний":
                s5 = "Обрано: водопінний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                dbWorker.setTypeExtinguisher(chatID,"водопінний");
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"площа");
                messageSender.sendMessage(sendMessage);
                break;
            case "Водяний":
                s5 = "Обрано: водяний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                dbWorker.setTypeExtinguisher(chatID,"водяний");
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"площа");
                messageSender.sendMessage(sendMessage);
                break;
            case "Газовий":
                s5 = "Обрано: газовий вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                dbWorker.setTypeExtinguisher(chatID,"газовий");
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"площа");
                messageSender.sendMessage(sendMessage);
                break;
            case "Громадські":
                s2 = "Обрано: Громадські приміщення (у т.ч. об'єкти адміністративного, побутового та торгівельного призначення)";
                sendMessage.setText(s2);
                messageSender.sendMessage(sendMessage);
                //встановлюємо в БД тип приміщення
                dbWorker.setTypePremises(chatID,"Громадські");
                sendMessage.setText("2. Оберіть тип громадської будівлі/приміщення (порядковість не має значення): ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeSpacesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Адміністративні будівлі":
                s7 = "Обрано: адміністративні будівлі/приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                dbWorker.setTypeSpacesBuild(chatID,"адміністративні");
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка?");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Будівлі побутового призначення":
                s7 = "Обрано: приміщення побутового призначення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                dbWorker.setTypeSpacesBuild(chatID,"побутові");
                sendMessage.setText("3. Оберіть тип  побутового приміщення: ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherPreparingFoodKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Підприємства торгівлі":
                s7 = "Обрано: тогрівельні приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                dbWorker.setTypeSpacesBuild(chatID,"торгівельні");
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка?");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Офісні приміщення":
                s7 = "Обрано: офісні приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                dbWorker.setTypeSpacesBuild(chatID,"офісні");
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка?");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Архіви, бібліотеки, музеї":
                s7 = "Обрано: архіви, бібліотеки, музеї";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                dbWorker.setTypeSpacesBuild(chatID,"архіви");
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка?");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, використовується":
                s8 = "Обрано: в приміщеннях використовується оргтехніка";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД чи використовується оргтехніка
                dbWorker.setB1(chatID,"true");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForPublicPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, не використовується":
                s8 = "Обрано: в приміщеннях не використовується оргтехніка";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД чи використовується оргтехніка
                dbWorker.setB1(chatID,"false");
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForPublicPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Приміщення для приготування їжі":
                s8 = "Обрано: приміщення для приготування їжі";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД приміщення використовується для приготування їжі
                dbWorker.setTypePremises(chatID,"Кухні");
                dbWorker.setKitchen(chatID,"true");
                sendMessage.setText("4. Вкажіть кількість окремих робочих місць де в технологічному процесі приготування їжі застосовуються рослинні або тваринні масла і жири. Пілся - оберіть тип вогнегасника \uD83E\uDDEF: ");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKitchenKeyboard());
                dbWorker.setValue(chatID,"робочі місця");
                messageSender.sendMessage(sendMessage);
                break;
            case "Інші побутові приміщення":
                s8 = "Обрано: в приміщеннях відсутні технологічні процеси приготування їжі";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                dbWorker.setKitchen(chatID,"false");
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка?");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Водяний для кухні":
                s5 = "Обрано: водяний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("6. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"площа");
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, передбачені":
                s9 = "Обрано: наявні технічні приміщення (у т.ч. комори, електрощитові тощо)\n";
                sendMessage.setText(s9);
                messageSender.sendMessage(sendMessage);
                dbWorker.setB2(chatID,"true");
                sendMessage.setText("8. Надішліть загальну площу технічних приміщень (м.кв.) після чого натисніть \"Розрахувати\"");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setTypePremises(chatID,"Технічні приміщення");
                dbWorker.setValue(chatID,"технічні приміщення");
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, не передбачені":
                sendMessage.setText("Технічні приміщення відсутні. Додаткового остащення вогнегасниками не потребується");
                dbWorker.setB2(chatID,"false");
                messageSender.sendMessage(sendMessage);
                break;
            case "Житлові":
                s2 = "Обрано: Житлові приміщення";
                sendMessage.setText(s2);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу приміщення
                dbWorker.setTypePremises(chatID,"Житлові");
                sendMessage.setText("2. Оберіть різновид житлового приміщення");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypesLivingKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Квартири":
                s10 = "Обрано: квартири багатоквартирних житлових будинків";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result(chatID));
                messageSender.sendMessage(sendMessage);
                break;
            case "Гуртожитки":
                s10 = "Обрано: кімната/секція/блок гуртожитку";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result(chatID));
                messageSender.sendMessage(sendMessage);
                break;
            case "Будинки індивідуальної забудови":
                s10 = "Обрано: житлові будинки індивідуальної забудови";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result(chatID));
                messageSender.sendMessage(sendMessage);
                break;
            case "Гаражі/автомайстерні":
                s2 = "Обрано: Приміщення автогаражів, автостоянок та/або автомайстерень";
                sendMessage.setText(s2);
                //встановлення в БД типу приміщення
                dbWorker.setTypePremises(chatID,"Гаражі");
                sendMessage.setText("2. Надішліть кількість місць стоянки автомобілів у боксі (гаражі, стоянці) після чого натисніть \"Розрахувати\"");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                dbWorker.setValue(chatID,"паркування");
                messageSender.sendMessage(sendMessage);
                break;
            case "Розрахувати":
                try{
                    if (dbWorker.getKitchen(chatID).equals("true") || dbWorker.getKitchen(chatID).equals("false")){
                        dbWorker.setKitchen(chatID,null);
                        sendMessage.setText(result(chatID));
                        messageSender.sendMessage(sendMessage);
                        sendMessage.setText("7. Чи передбачені в досліджуваних приміщеннях комори, електрощитові, вентиляційні камери або інші технічні приміщення?");
                        sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTechnicalАcilitiesKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else{
                        sendMessage.setText(result(chatID));
                        messageSender.sendMessage(sendMessage);
                    }
                }catch (NullPointerException e){
                    sendMessage.setText(result(chatID));
                    messageSender.sendMessage(sendMessage);
                }
                break;


            //кейси, що відповідають за роботу бота - визначення ступеня ризику
            case "Об’єкт що експлуатується":
                s2 = "Обрано: об'єкт експлуатується";
                sendMessage.setText(s2);
                //встановлює в БД характеристику об'єкта
                dbWorker.setCharacteristicsObject(chatID,"експлуатується");
                sendMessage.setText("2. Оберіть тип об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "2.1. Об’єкт підвищеної небезпеки\n" +
                        "2.2. Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави\n" +
                        "2.3. Об’єкт метрополітену\n" +
                        "2.4. Об’єкт, включений до Державного реєстру нерухомих пам’яток\n" +
                        "2.5. Промисловий або складський об’єкт\n" +
                        "2.6. Інший об’єкт");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskDataEntryKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Об’єкт на стадії будівництва":
                s2 = "Обрано: об'єкт на стадії будівництва";
                sendMessage.setText(s2);
                //встановлює в БД характеристику об'єкта
                dbWorker.setCharacteristicsObject(chatID,"проєктується");
                sendMessage.setText("2. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n" +
                        "\n" +
                        "2.1. Надзвичайна ситуація державного рівня\n" +
                        "2.2. Надзвичайна ситуація регіонального рівня\n" +
                        "2.3. Надзвичайна ситуація місцевого рівня\n" +
                        "2.4. Надзвичайна ситуація об’єктового рівня\n" +
                        "2.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                        "2.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesDesigningBuildingKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1":
                s3 = "Обрано: Об’єкт підвищеної небезпеки";
                //встановлює в БД типу об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"обєкт підвищеної небезпеки");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2":
                s3 = "Обрано: Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"обєкт стратегічного значення");
                sendMessage.setText("3. Оберіть різновид об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "3.1. Об’єкт сфери оборони \n" +
                        "3.2. Об’єкт паливно-енергетичного комплексу\n" +
                        "3.3. Об’єкт транспортної галузі \n" +
                        "3.4. Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву \n" +
                        "3.5. Об’єкт агропромислового комплексу \n" +
                        "3.6. Об’єкт сфери електронних комунікацій та зв’язку \n" +
                        "3.7. Об’єкт авіаційної та ракетно-космічної промисловості \n" +
                        "3.8. Об’єкт машинобудівної промисловості \n" +
                        "3.9. Об’єкт металургійного комплексу \n" +
                        "3.10. Об’єкт хімічного комплексу \n" +
                        "3.11. Об’єкт наукової діяльності \n" +
                        "3.12. Об’єкт сфери стандартизації, метрології та сертифікації \n" +
                        "3.13. Об’єкт гідрометеорологічної діяльності \n" +
                        "3.14. Об’єкт промисловості будівельних матеріалів \n" +
                        "3.15. Об’єкт фінансово-бюджетної сфери \n" +
                        "3.16. Об’єкт харчової промисловості \n" +
                        "3.17. Об’єкт легкої промисловості \n" +
                        "3.18. Об’єкт поліграфії \n" +
                        "3.19. Об’єкт геологорозвідувальної галузі");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskStateOwnedObjectKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3":
                s3 = "Обрано: Об’єкт метрополітену";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"обєкт метрополітену");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"\n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.4":
                s3 = "Обрано: Об’єкт, включений до Державного реєстру нерухомих пам’яток";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"нерухома памятка");
                sendMessage.setText("3. Оберіть різновид об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "3.1. Пам’ятка культурної спадщини національного значення \n" +
                        "3.2. Пам’ятка культурної спадщини місцевого значення");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectsCulturalHeritageKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5":
                s3 = "Обрано: Промисловий або складський об’єкт";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"промисловий або складський обєкт");
                sendMessage.setText("3. Оберіть різновид об’єкта:");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskIndustrialWarehouseObjectsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Промисловий об’єкт":
                s4 = "Обрано: Промисловий об’єкт";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД тип промислового об'єкту
                dbWorker.setTypeIndustrialStorageFacility(chatID,"промисловий обєкт");
                sendMessage.setText("4. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskCategoryPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Складський об’єкт":
                s4 = "Обрано: Складський об’єкт";
                //встановлює в БД тип промислового об'єкту
                dbWorker.setTypeIndustrialStorageFacility(chatID,"складський обєкт");
                sendMessage.setText("4. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskCategoryPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення А":
                s3 = "Обрано: приміщення категорії А";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                dbWorker.setCategoryPremises(chatID,"Категорія А");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Б":
                s3 = "Обрано: приміщення категорії Б";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                dbWorker.setCategoryPremises(chatID,"Категорія Б");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення В":
                s3 = "Обрано: приміщення категорії В";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                dbWorker.setCategoryPremises(chatID,"Категорія В");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Г":
                s3 = "Обрано: приміщення категорії Г";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                dbWorker.setCategoryPremises(chatID,"Категорія Г");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Д":
                s3 = "Обрано: приміщення категорії Д";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                dbWorker.setCategoryPremises(chatID,"Категорія Д");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.6":
                s3 = "Обрано: Інші об’єкти";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД тип об'єкту ризику
                dbWorker.setTypeObjectOfRisk(chatID,"інші обєкти");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"\n" +
                        "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Далі":
                if (dbWorker.getCharacteristicsObject(chatID).equals("експлуатується")){
                    if (dbWorker.getValue(chatID).equals("площа")){
                        dbWorker.setValue(chatID,"постійно перебувають на обєкті");
                        sendMessage.setText("Введіть максимальну розрахункову (проектну) кількість людей, які ПОСТІЙНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (dbWorker.getValue(chatID).equals("постійно перебувають на обєкті")){
                        dbWorker.setValue(chatID,"періодично перебувають на обєкті");
                        sendMessage.setText("Введіть максимальну розрахункову (проектну) кількість людей, які ПЕРІОДИЧНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (dbWorker.getValue(chatID).equals("періодично перебувають на обєкті")){
                        dbWorker.setValue(chatID,"висота обєкта");
                        sendMessage.setText("Введіть значення умовної висоти об’єкта (м.) (визначається різницею позначок найнижчого рівня проїзду (встановлення)"
                                + " пожежних автодрабин (автопідйомників) і підлоги верхнього поверху без урахування верхніх технічних поверхів, "
                                + "якщо на технічних поверхах розміщено лише інженерні обладнання та комунікації будинку). Натисніть \"Далі\" \n"
                                + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (dbWorker.getValue(chatID).equals("висота обєкта")){
                        if (dbWorker.getTypeObjectOfRisk(chatID).equals("обєкт підвищеної небезпеки") || dbWorker.getTypeObjectOfRisk(chatID).equals("обєкт метрополітену")
                                || dbWorker.getTypeObjectOfRisk(chatID).equals("інші обєкти")) {
                            sendMessage.setText("3. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n" +
                                    "\n" +
                                    "3.1. Надзвичайна ситуація державного рівня\n" +
                                    "3.2. Надзвичайна ситуація регіонального рівня\n" +
                                    "3.3. Надзвичайна ситуація місцевого рівня\n" +
                                    "3.4. Надзвичайна ситуація об’єктового рівня\n" +
                                    "3.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                                    "3.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskDangerousEventsKeyboard());
                            messageSender.sendMessage(sendMessage);
                            dbWorker.setValue(chatID,null);
                        } else if (dbWorker.getTypeObjectOfRisk(chatID).equals("обєкт стратегічного значення") || dbWorker.getTypeObjectOfRisk(chatID).equals("нерухома памятка")) {
                            sendMessage.setText("4. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n" +
                                    "4.1. Надзвичайна ситуація державного рівня\n" +
                                    "4.2. Надзвичайна ситуація регіонального рівня\n" +
                                    "4.3. Надзвичайна ситуація місцевого рівня\n" +
                                    "4.4. Надзвичайна ситуація об’єктового рівня\n" +
                                    "4.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                                    "4.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesStrategicKeyboard());
                            messageSender.sendMessage(sendMessage);
                            dbWorker.setValue(chatID,null);
                        } else if (dbWorker.getTypeObjectOfRisk(chatID).equals("промисловий або складський обєкт")) {
                            sendMessage.setText("5. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
                                    + "5.1. Надзвичайна ситуація державного рівня\n"
                                    + "5.2. Надзвичайна ситуація регіонального рівня\n"
                                    + "5.3. Надзвичайна ситуація місцевого рівня\n"
                                    + "5.4. Надзвичайна ситуація об’єктового рівня\n"
                                    + "5.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
                                    + "5.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesIndustrialKeyboard());
                            messageSender.sendMessage(sendMessage);
                            dbWorker.setValue(chatID,null);
                        } else if (dbWorker.getTypeObjectOfRisk(chatID).equals("проєктується")) {
                            sendMessage.setText("2. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
                                    + "2.1. Надзвичайна ситуація державного рівня\n"
                                    + "2.2. Надзвичайна ситуація регіонального рівня\n"
                                    + "2.3. Надзвичайна ситуація місцевого рівня\n"
                                    + "2.4. Надзвичайна ситуація об’єктового рівня\n"
                                    + "2.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
                                    + "2.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesDesigningBuildingKeyboard());
                            messageSender.sendMessage(sendMessage);
                            dbWorker.setValue(chatID,null);
                        }
                    }else if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня") || dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) == null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getFixedViolations(chatID)==null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getFixedViolations(chatID)==null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня")||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getFixedViolations(chatID) == null)){
                        dbWorker.setValue(chatID,"усунено порушень");
                        sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта \n" +
                                "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня")||dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) != null && dbWorker.getNoFixedViolations(chatID) == null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getNoFixedViolations(chatID) ==null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getNoFixedViolations(chatID)==null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") ||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС"))  && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getNoFixedViolations(chatID) == null)){
                        dbWorker.setValue(chatID,"не усунено порушень");
                        sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією \n" +
                                "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") || dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) == null){
                        dbWorker.setValue(chatID,"загиблі");
                        sendMessage.setText("Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \n"
                                + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) == null){
                        dbWorker.setValue(chatID,"збитки");
                        sendMessage.setText("Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\"\n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) != null && dbWorker.getTaxFreeIncome(chatID) == null){
                        dbWorker.setValue(chatID,"дохід");
                        sendMessage.setText("Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) != null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getInjuredPeople(chatID) == null){
                        dbWorker.setValue(chatID,"травмовані");
                        sendMessage.setText("Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" " +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня") || dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) != null && dbWorker.getNoFixedViolations(chatID) != null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getFixedViolations(chatID)!=null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getFixedViolations(chatID)!=null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня")||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getFixedViolations(chatID) != null)){
                        sendMessage.setText(resultDegreeRisk(chatID));
                        messageSender.sendMessage(sendMessage);
                    }
                }else if (dbWorker.getCharacteristicsObject(chatID).equals("проєктується")){
                    if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня") || dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) == null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getFixedViolations(chatID)==null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getFixedViolations(chatID)==null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня")||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getFixedViolations(chatID) == null)){
                        dbWorker.setValue(chatID,"усунено порушень");
                        sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта \n" +
                                "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня")||dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) != null && dbWorker.getNoFixedViolations(chatID) == null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getNoFixedViolations(chatID) ==null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getNoFixedViolations(chatID)==null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") ||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС"))  && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getNoFixedViolations(chatID) == null)) {
                        dbWorker.setValue(chatID, "не усунено порушень");
                        sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією \n" +
                                "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47\"");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") || dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) == null){
                        dbWorker.setValue(chatID,"загиблі");
                        sendMessage.setText("Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \n"
                                + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) == null){
                        dbWorker.setValue(chatID,"збитки");
                        sendMessage.setText("Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\"\n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") || dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) != null && dbWorker.getTaxFreeIncome(chatID) == null){
                        dbWorker.setValue(chatID,"дохід");
                        sendMessage.setText("Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \n" +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня") || dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID) != null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getInjuredPeople(chatID) == null){
                        dbWorker.setValue(chatID,"травмовані");
                        sendMessage.setText("Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" " +
                                "Якщо введено помилкові дані - скористайтесь меню \"На початок\" \uD83D\uDC47");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }else if (((dbWorker.getLevelEmergency(chatID).equals("НС державного рівня") || dbWorker.getLevelEmergency(chatID).equals("без НС")) && dbWorker.getFixedViolations(chatID) != null && dbWorker.getNoFixedViolations(chatID) != null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС регіонального рівня") &&  dbWorker.getDeadPeople(chatID) != null && dbWorker.getFixedViolations(chatID)!=null)
                            || (dbWorker.getLevelEmergency(chatID).equals("НС місцевого рівня") && dbWorker.getDeadPeople(chatID) != null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID) != null && dbWorker.getFixedViolations(chatID)!=null)
                            || ((dbWorker.getLevelEmergency(chatID).equals("НС обєктового рівня")||dbWorker.getLevelEmergency(chatID).equals("не класифікована НС")) && dbWorker.getDeadPeople(chatID)!=null && dbWorker.getLosses(chatID)!=null && dbWorker.getTaxFreeIncome(chatID)!=null && dbWorker.getInjuredPeople(chatID) !=null && dbWorker.getFixedViolations(chatID) != null)){
                        sendMessage.setText("3. Оберіть тип об'єкта для встановлення показників ступеня ризику за класом наслідків (відповідальності) під час будівництва (з запропонованого переліку):\n" +
                                "3.1. Об’єкт із значними наслідками (СС3)\n" +
                                "3.2. Об’єкт із середніми наслідками (СС2)\n" +
                                "3.3. Об’єкт із незначними наслідками (СС1)");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskConstructionConsequencesKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }
                }
                break;
            case "Далі кухні":
                sendMessage.setText("5. Оберіть необхідний тип вогнегасника");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForKitchenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.1":
                s4 = "Обрано: Об’єкт сфери оборони";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт оборони");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.2":
                s4 = "Обрано: Об’єкт паливно-енергетичного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт енергетичного комплексу");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.3":
                s4 = "Обрано: Об’єкт транспортної галузі";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт транспорту");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.4":
                s4 = "Обрано: Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт держрезерву");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.5":
                s4 = "Обрано: Об’єкт агропромислового комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт аграрного комплексу");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.6":
                s4 = "Обрано: Об’єкт сфери електронних комунікацій та зв’язку";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт зв'язку");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.7":
                s4 = "Обрано: Об’єкт авіаційної та ракетно-космічної промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт авіації");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.8":
                s4 = "Обрано: Об’єкт машинобудівної промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт машинобувної промисловості");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.9":
                s4 = "Обрано: Об’єкт металургійного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт металургії");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.10":
                s4 = "Обрано: Об’єкт хімічного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт хімпрому");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.11":
                s4 = "Обрано: Об’єкт наукової діяльності";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт науки");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.12":
                s4 = "Обрано: Об’єкт сфери стандартизації, метрології та сертифікації";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт метрології");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.13":
                s4 = "Обрано: Об’єкт гідрометеорологічної діяльності";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт гідрометеорології");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.14":
                s4 = "Обрано: Об’єкт промисловості будівельних матеріалів";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт будматеріалів");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.15":
                s4 = "Обрано: Об’єкт фінансово-бюджетної сфери";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт фінансово-бюджетний");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.16":
                s4 = "Обрано: Об’єкт харчової промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт харчовий");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.17":
                s4 = "Обрано: Об’єкт легкої промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт легкої промисловості");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.18":
                s4 = "Обрано: Об’єкт поліграфії";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт поліграфії");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.19":
                s4 = "Обрано: Об’єкт геологорозвідувальної галузі";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                dbWorker.setTypeStateOwnedObject(chatID,"обєкт геологорозвідувальний");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏛 3.1":
                s4 = "Обрано: Пам’ятка культурної спадщини національного значення";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                dbWorker.setTypeCulturalObject(chatID,"памятка національного значення");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏛 3.2":
                s4 = "Обрано: Пам’ятка культурної спадщини місцевого значення";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                dbWorker.setTypeCulturalObject(chatID,"памятка місцевого значення");
                dbWorker.setValue(chatID,"площа");
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n"
                        + "Якщо введено помилкові дані - скористайтесь меню \"На початок\" 👇");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.1":
            case "🔥 4.1":
            case "🔥 3.1":
            case "🔥 2.1":
                s3 = "Обрано: надзвичайна ситуація державного рівня";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"НС державного рівня");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.2":
            case "🔥 4.2":
            case "🔥 3.2":
            case "🔥 2.2":
                s3 = "Обрано: надзвичайна ситуація регіонального рівня";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"НС регіонального рівня");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.3":
            case "🔥 4.3":
            case "🔥 3.3":
            case "🔥 2.3":
                s3 = "Обрано: надзвичайна ситуація місцевого рівня";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"НС місцевого рівня");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.4":
            case "🔥 4.4":
            case "🔥 3.4":
            case "🔥 2.4":
                s3 = "Обрано: надзвичайна ситуація об’єктового рівня";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"НС обєктового рівня");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.5":
            case "🔥 4.5":
            case "🔥 3.5":
            case "🔥 2.5":
                s3 = "Обрано: небезпечна подія, що не класифікується як надзвичайна ситуація";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"не класифікована НС");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.6":
            case "🔥 4.6":
            case "🔥 3.6":
            case "🔥 2.6":
                s3 = "Обрано: надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало";
                sendMessage.setText(s3);
                dbWorker.setLevelEmergency(chatID,"без НС");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.1":
                s4 = "Обрано: Об’єкт із значними наслідками (СС3)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                dbWorker.setTypeResultDegreeRisk(chatID,"об’єкт із значними наслідками");
                sendMessage.setText(resultDegreeRisk(chatID));
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.2":
                s4 = "Обрано: Об’єкт із середніми наслідками (СС2)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                dbWorker.setTypeResultDegreeRisk(chatID,"об’єкт із середніми наслідками");
                sendMessage.setText(resultDegreeRisk(chatID));
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.3":
                s4 = "Обрано: Об’єкт із незначними наслідками (СС1)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                dbWorker.setTypeResultDegreeRisk(chatID,"об’єкт із незначними наслідками");
                sendMessage.setText(resultDegreeRisk(chatID));
                messageSender.sendMessage(sendMessage);
                break;

            // кейси, що відповідають за визначення категорій приміщень за пожежною небезпекою
            case "Категорія Прим./Буд/Зовн.Уст":
                sendMessage.setText("2. Оберіть місце розташування технологічної установки");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationLocationKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Використовується в прим.":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceRoomsKeyboard());
                // додавання в БД чи використовується об'єкт в приміщенні
                dbWorker.setUsedIndoors(chatID,"true");
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, є необхідність":
                dbWorker.setValue(chatID,"обєм будівлі");
                sendMessage.setText("1. Надішліть об'єм будівлі та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, необхідність відсутня":
                sendMessage.setText("🇺🇦 Для початку роботи повторно скористайтеся командами бота Fire Safety Bot 👇");
                messageSender.sendMessage(sendMessage);
                break;
            case "Використовується на вулиці":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceRoomsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            //характеристики горючих/негорючих речовин що обертаються в технологічному процесі
            case "Горючі гази":
                sendMessage.setText(characteristics.getCharacteristicCombustibleGasesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleGasesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Легкозаймисті рідини":
                sendMessage.setText(characteristics.getCharacteristicFlammableLiquidsRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicFlammableLiquidsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Вибухові речовини":
                sendMessage.setText(characteristics.getCharacteristicExplosiveSubstancesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicExplosiveSubstancesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі рідини":
                sendMessage.setText(characteristics.getCharacteristicCombustibleLiquidsRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleLiquidsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі пили":
                sendMessage.setText(characteristics.getCharacteristicCombustibleSawsRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleSawsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі волокна":
                sendMessage.setText(characteristics.getCharacteristicCombustibleFibersRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleFibersKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Тверді горючі речовини":
                sendMessage.setText(characteristics.getCharacteristicSolidСombustibleSubstancesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicSolidСombustibleSubstancesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Тверді важкогорючі речовини":
                sendMessage.setText(characteristics.getCharacteristicSolidHighlyFlammableSubstancesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Важкогорючі рідини":
                sendMessage.setText(characteristics.getCharacteristicHighlyFlammableLiquidRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicHighlyFlammableLiquidKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Негорючі речовини":
                sendMessage.setText(characteristics.getCharacteristicNonCombustibleSubstancesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicNonCombustibleSubstancesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 Горючі гази":
            case "2.1 Легкозаймисті рідини":
            case "2.1 Вибухові речовини":
                sendMessage.setText(categories.getCategoryA());
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getUsedIndoors(chatID).equals("true")){
                    sendMessage.setText("Чи є необхідність визначити категорію будівлі?");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationNecessityCategoriesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "2.2 Легкозаймисті рідини":
            case "2.1 Горючі рідини":
            case "2.1 Горючі пили":
            case "2.1 Горючі волокна":
                sendMessage.setText(categories.getCategoryБ());
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getUsedIndoors(chatID).equals("true")){
                    sendMessage.setText("Чи є необхідність визначити категорію будівлі?");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationNecessityCategoriesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "2.2 Горючі гази":
            case "2.3 Легкозаймисті рідини":
            case "2.2 Вибухові речовини":
            case "2.2 Горючі рідини":
            case "2.2 Горючі пили":
            case "2.2 Горючі волокна":
            case "2.1 Тверді горючі речовини":
            case "2.1 Тверді важкогорючі речовини":
            case "2.1 Важкогорючі рідини":
                sendMessage.setText(categories.getCategoryВ());
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getUsedIndoors(chatID).equals("true")){
                    sendMessage.setText("Чи є необхідність визначити категорію будівлі?");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationNecessityCategoriesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "2.3 Горючі гази":
            case "2.4 Легкозаймисті рідини":
            case "2.3 Горючі рідини":
            case "2.2 Тверді горючі речовини":
            case "2.1 Негорючі речовини":
                sendMessage.setText(categories.getCategoryГ());
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getUsedIndoors(chatID).equals("true")){
                    sendMessage.setText("Чи є необхідність визначити категорію будівлі?");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationNecessityCategoriesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "2.5 Легкозаймисті рідини":
            case "2.3 Вибухові речовини":
            case "2.4 Горючі рідини":
            case "2.3 Тверді горючі речовини":
            case "2.3 Тверді важкогорючі речовини":
            case "2.2 Важкогорючі рідини":
            case "2.2 Негорючі речовини":
                sendMessage.setText(categories.getCategoryД());
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getUsedIndoors(chatID).equals("true")){
                    sendMessage.setText("Чи є необхідність визначити категорію будівлі?");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationNecessityCategoriesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "Категорія зовнішньої установки":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі гази З":
                sendMessage.setText(characteristics.getCharacteristicCombustibleGasesExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleGasesExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Легкозаймисті рідини З":
                sendMessage.setText(characteristics.getCharacteristicFlammableLiquidsExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicFlammableLiquidsExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Вибухові речовини З":
                sendMessage.setText(characteristics.getCharacteristicExplosiveSubstancesRooms());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicExplosiveSubstancesExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі рідини З":
                sendMessage.setText(characteristics.getCharacteristicCombustibleLiquidsExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleLiquidsExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі пили З":
                sendMessage.setText(characteristics.getCharacteristicCombustibleSawsExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleSawsExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Горючі волокна З":
                sendMessage.setText(characteristics.getCharacteristicCombustibleFibersExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicCombustibleFibersExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Тверді горючі речовини З":
                sendMessage.setText(characteristics.getCharacteristicSolidСombustibleSubstancesExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicSolidСombustibleSubstancesExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Тверді важкогорючі речовини З":
                sendMessage.setText(characteristics.getCharacteristicSolidHighlyFlammableSubstancesExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Важкогорючі рідини З":
                sendMessage.setText(characteristics.getCharacteristicHighlyFlammableLiquidExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicHighlyFlammableLiquidExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Негорючі речовини З":
                sendMessage.setText(characteristics.getCharacteristicNonCombustibleSubstancesExternal());
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicNonCombustibleSubstancesExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 Горючі гази З":
            case "2.1 Легкозаймисті рідини З":
            case "2.1 Вибухові речовини З":
                sendMessage.setText(categories.getCategoryАз());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 Легкозаймисті рідини З":
            case "2.1 Горючі рідини З":
            case "2.1 Горючі пили З":
            case "2.1 Горючі волокна З":
                sendMessage.setText(categories.getCategoryБз());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 Горючі гази З":
            case "2.3 Легкозаймисті рідини З":
            case "2.2 Вибухові речовини З":
            case "2.2 Горючі рідини З":
            case "2.2 Горючі пили З":
            case "2.2 Горючі волокна З":
            case "2.1 Тверді горючі речовини З":
            case "2.1 Тверді важкогорючі речовини З":
            case "2.1 Важкогорючі рідини З":
                sendMessage.setText(categories.getCategoryВз());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3 Горючі гази З":
            case "2.4 Легкозаймисті рідини З":
            case "2.3 Горючі рідини З":
            case "2.2 Тверді горючі речовини З":
            case "2.1 Негорючі речовини З":
                sendMessage.setText(categories.getCategoryГз());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 Тверді важкогорючі речовини З":
            case "2.2 Важкогорючі рідини З":
            case "2.2 Негорючі речовини З":
                sendMessage.setText(categories.getCategoryДз());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія будівлі":
                dbWorker.setValue(chatID,"обєм будівлі");
                sendMessage.setText("1. Надішліть об'єм будівлі та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Далі категорія будівлі":
                if (dbWorker.getVolumePremises(chatID) == null){
                    sendMessage.setText("Площу не введено");
                }else{
                    if (dbWorker.getVolumePremises(chatID) !=null && dbWorker.getCategoryBuildings(chatID) == null) {
                        sendMessage.setText("Оберіть найнебезпечнішу категорію виробництва");
                        sendMessage.setReplyMarkup(inlineButton.inlineDeterminationMostDangerousCategoryKeyboard());
                    }else if (dbWorker.getVolumeRoomsA(chatID) != null && dbWorker.getVolumeRoomsБ(chatID)==null){
                        if (categoryBuilding.getBuildingCategoryA()){
                            sendMessage.setText(categories.getCategoryAб());
                        }else{
                            dbWorker.setValue(chatID,"обєм приміщень Б");
                            sendMessage.setText("Надішліть об'єм приміщень категорії Б та натисніть \" Далі \"");
                            sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                        }
                    }else if ((dbWorker.getVolumeRoomsA(chatID) != null && dbWorker.getVolumeRoomsБ(chatID) != null && dbWorker.getVolumeRoomsB(chatID)==null)||dbWorker.getVolumeRoomsA(chatID)==null && dbWorker.getVolumeRoomsБ(chatID)!=null && dbWorker.getVolumeRoomsB(chatID)==null){
                        if (categoryBuilding.getBuildingCategoryБ()){
                            sendMessage.setText(categories.getCategoryБб());
                        }else{
                            dbWorker.setValue(chatID,"обєм приміщень В");
                            sendMessage.setText("Надішліть об'єм приміщень категорії B та натисніть \" Далі \"");
                            sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                        }
                    }else if ((dbWorker.getVolumeRoomsA(chatID) != null && dbWorker.getVolumeRoomsБ(chatID) != null && dbWorker.getVolumeRoomsB(chatID) != null && dbWorker.getVolumeRoomsГ(chatID)==null)||((dbWorker.getVolumeRoomsA(chatID) == null && dbWorker.getVolumeRoomsБ(chatID) != null && dbWorker.getVolumeRoomsB(chatID) != null && dbWorker.getVolumeRoomsГ(chatID)==null) || (dbWorker.getVolumeRoomsA(chatID) == null && dbWorker.getVolumeRoomsБ(chatID) == null && dbWorker.getVolumeRoomsB(chatID) != null && dbWorker.getVolumeRoomsГ(chatID)==null))){
                        if (categoryBuilding.getBuildingCategoryВ()){
                            sendMessage.setText(categories.getCategoryВб());
                        }else {
                            dbWorker.setValue(chatID,"обєм приміщень Г");
                            sendMessage.setText("Надішліть об'єм приміщень категорії Г та натисніть \" Далі \"");
                            sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                        }
                    }else{
                        if (categoryBuilding.getBuildingCategoryГ()){
                            sendMessage.setText(categories.getCategoryГб());
                        }else{
                            sendMessage.setText(categories.getCategoryДб());
                        }
                    }
                }
                messageSender.sendMessage(sendMessage);
                break;
            case "А - вибухопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії А та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                dbWorker.setCategoryBuildings(chatID,"А");
                dbWorker.setValue(chatID,"обєм приміщень А");
                break;
            case "Б - вибухопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії Б та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                dbWorker.setCategoryBuildings(chatID,"Б");
                dbWorker.setValue(chatID,"обєм приміщень Б");
                break;
            case "В - пожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії В та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                dbWorker.setCategoryBuildings(chatID,"В");
                dbWorker.setValue(chatID,"обєм приміщень В");
                break;
            case "Г - помірнопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії Г та натисніть \" Далі \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                dbWorker.setCategoryBuildings(chatID,"Г");
                dbWorker.setValue(chatID,"обєм приміщень Г");
                break;
            case "Д - зниженопожежонебезпечна":
                sendMessage.setText(categories.getCategoryД());
                messageSender.sendMessage(sendMessage);
                break;
        }


    }
    String result(String chatID) { // виводить результат для вогнегасника
        String s6 = null;
        if (dbWorker.getTypePremises(chatID).equals("Виробничі_складські")) {
            IndustrialPremises ip = new IndustrialPremises(chatID);
            if (dbWorker.getTypeExtinguisher(chatID).equals("порошковий")) {
                s6 = ip.quantityExtinguisherPoroshok();
            } else if (dbWorker.getTypeExtinguisher(chatID).equals("водопінний")) {
                s6 = ip.quantityExtinguisherVodopinni();
            } else if (dbWorker.getTypeExtinguisher(chatID).equals("водяний")) {
                s6 = ip.quantityExtinguisherVodiani();
            } else if (dbWorker.getTypeExtinguisher(chatID).equals("газовий")) {
                s6 = ip.quantityExtinguisherGazovyi();
            }
        } else if (dbWorker.getTypePremises(chatID).equals("Громадські")) {
            PublicPremises pp = new PublicPremises(chatID);
            if (dbWorker.getTypeExtinguisher(chatID).equals("порошковий")) {
                s6 = pp.quantityExtinguisherPoroshok();
            }
            if (dbWorker.getTypeExtinguisher(chatID).equals("водопінний")) {
                s6 = pp.quantityExtinguisherVodopinni();
            }
            if (dbWorker.getTypeExtinguisher(chatID).equals("водяний")) {
                s6 = pp.quantityExtinguisherVodiani();
            }
        } else if (dbWorker.getTypePremises(chatID).equals("Житлові")) {
            TypesLivingSpace lp = new TypesLivingSpace();
            s6 = lp.quantityExtinguisherLivingSpace();
        }else if (dbWorker.getTypePremises(chatID).equals("Гаражі")) {
            Garages gg = new Garages(chatID);
            s6 = gg.quantityExtinguisherGarages();
        }else if (dbWorker.getTypePremises(chatID).equals("Технічні приміщення")){
            PublicPremises pp = new PublicPremises(chatID);
            s6 = pp.quantityExtinguisherTekhPrym();
        }else if (dbWorker.getTypePremises(chatID).equals("Кухні")){
            PublicPremises pp = new PublicPremises(chatID);
            s6 = pp.quantityExtinguisherVodianiKitchen();
        }
        return s6;
    }
    String resultDegreeRisk(String chatID) { // виводить результат для ступеня ризику
        String s6 = null;
        DegreeRiskObject dro = new DegreeRiskObject(chatID);
        if (dbWorker.getCharacteristicsObject(chatID).equals("експлуатується")) {
            s6 = dro.degreeRiskObjectExploited();
        }
        if (dbWorker.getCharacteristicsObject(chatID).equals("проєктується")) {
            s6 = dro.degreeRiskObjectProjected();
        }
        return s6;
    }
}

// on_start - На початок
//type_number_fire_extinguishers - Визначення типу та необхідної кількості вогнегасників
//degree_of_risk_from_activities - Оцінка ступеня ризику від провадження господарської діяльності
//determination_of_categories - Визначення категорій приміщень за пожежною небезпекою
//feedback_info - Інформація. Зворотній зв'язок