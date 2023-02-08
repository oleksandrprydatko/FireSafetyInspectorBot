package SV.FireSafety.handlers;

import SV.FireSafety.messagesender.MessageSender;
import SV.FireSafety.repository.DatabaseRepository;
import SV.FireSafety.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;


@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {

    //конструктор класу MessageSender
    private final MessageSender messageSender;

    public CallbackQueryHandler(MessageSender messageSender,
                                DatabaseRepository databaseRepository) {
        this.messageSender = messageSender;
        this.databaseRepository = databaseRepository;
    }

    //екземпляри класів
    InstructionExtinguisher instructionExtinguisher = new InstructionExtinguisher();
    InlineButton inlineButton = new InlineButton();
    Categories categories = new Categories();
    Characteristics characteristics = new Characteristics();
    ZoneClasses zc = new ZoneClasses();

    String s2 = null;
    String s3 = null;
    String s4 = null;
    String s5 = null;
    String s7 = null;
    String s8 = null;
    String s9 = null;
    String s10 = null;

    Long userId;

    @Autowired
    DatabaseRepository databaseRepository;

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
        userId = Long.valueOf(chatID);
        //екземпляр класу з параметром
        CategoryBuilding categoryBuilding = new CategoryBuilding(userId,databaseRepository);
        FireAlarm fireAlarm = new FireAlarm(userId,databaseRepository);
        //тип та необхідність вогнегасників
        switch (callbackQuery.getData()) {
            case "Розпочати":
                if (databaseRepository.getComand_of_menu(userId).equals("/type_number_fire_extinguishers")) {
                    sendMessage.setText("1. Оберіть тип приміщення/об'єкту \uD83C\uDFD8");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getComand_of_menu(userId).equals("/degree_of_risk_from_activities")){
                    sendMessage.setText("1. Оберіть характеристику об’єкта \uD83C\uDFE0");
                    sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskTechnicalPremisesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getComand_of_menu(userId).equals("/determination_of_categories")) {
                    sendMessage.setText("1. Оберіть характеристику, яку необхідно визначити\uD83C\uDFD8");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getComand_of_menu(userId).equals("/zone_classes")) {
                    sendMessage.setText("1. Оберіть вид речовин, що обертаються у технологічному процесі \uD83C\uDFED\n\n" +
                            "1.1. Використовуються вибухонебезпечні речовини \uD83D\uDCA5\n" +
                            "1.2. Використовуються пожежонебезпечні речовини \uD83D\uDD25\n" +
                            "1.3. Відсутні вибухо- та пожежонебезпечні речовини ♻");
                    sendMessage.setReplyMarkup(inlineButton.inlineZoneClassesKeyboardMarkup());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getComand_of_menu(userId).equals("/fire_alarm_installation")){
                    sendMessage.setText("1. Виберіть тип об'єкту \uD83C\uDFEB :");
                    sendMessage.setReplyMarkup(inlineButton.inlineObjectTypeFireAlarmKeyboard());
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
                databaseRepository.setType_premises("Виробничі_складські",userId);
                sendMessage.setText("2. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою (порядковість не має значення) \uD83D\uDCA5");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCategoryPremissesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія А":
                s3 = "Обрано: приміщення категорії А";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                databaseRepository.setCategory_premises("Категорія А",userId);
                sendMessage.setText("3. Оберіть клас можливої пожежі \uD83D\uDEA8");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Б":
                s3 = "Обрано: приміщення категорії Б";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                databaseRepository.setCategory_premises("Категорія Б",userId);
                sendMessage.setText("3. Оберіть клас можливої пожежі \uD83D\uDEA8");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія В":
                s3 = "Обрано: приміщення категорії В";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                databaseRepository.setCategory_premises("Категорія В",userId);
                sendMessage.setText("2.1. Зазначте чи наявні в приміщенні виробництва (складському примішенні) горючі рідини та гази \uD83D\uDCA8");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForBKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "наявні горючі рідини та гази":
                s3 = "Обрано: приміщення категорії В з наявністю горючих рідин та газів";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорію приміщень
                databaseRepository.setCategory_premises("Категорія В з ГГ",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "відсутні горючі рідини та гази":
                s3 = "Обрано: приміщення категорії В за відсутності горючих рідин та газів";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорію приміщень
                databaseRepository.setCategory_premises("Категорія В без ГГ",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForB2_ДKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Г":
                s3 = "Обрано: приміщення категорії Г";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                databaseRepository.setCategory_premises("Категорія Г",userId);
                sendMessage.setText("3. Оберіть клас можливої пожежі \uD83D\uDEA8");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Д":
                s3 = "Обрано: приміщення категорії Д";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії будівлі
                databaseRepository.setCategory_premises("Категорія Д",userId);
                sendMessage.setText("3. Оберіть клас можливої пожежі \uD83D\uDEA8");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherFireClassForB2_ДKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі A":
                s4 = "Обрано: клас ймовірної пожежі A";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі A",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassAKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі B":
                s4 = "Обрано: клас ймовірної пожежі B";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі B",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassВKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі C":
                s4 = "Обрано: клас ймовірної пожежі C";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі C",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassC_DKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі D":
                s4 = "Обрано: клас ймовірної пожежі D";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі D",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassC_DKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі F":
                s4 = "Обрано: клас ймовірної пожежі F";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //становлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі F",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassFKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Клас ймовірної пожежі E":
                s4 = "Обрано: клас ймовірної пожежі E";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД класу пожежі
                databaseRepository.setClass_fire("Клас пожежі E",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeExtinguisherForClassEKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Порошковий":
                s5 = "Обрано: порошковий вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                databaseRepository.setType_extinguisher("порошковий",userId);
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Водопінний":
                s5 = "Обрано: водопінний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                databaseRepository.setType_extinguisher("водопінний",userId);
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Водяний":
                s5 = "Обрано: водяний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                databaseRepository.setType_extinguisher("водяний",userId);
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Газовий":
                s5 = "Обрано: газовий вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу вогнегасника
                databaseRepository.setType_extinguisher("газовий",userId);
                sendMessage.setText("5. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Громадські":
                s2 = "Обрано: Громадські приміщення (у т.ч. об'єкти адміністративного, побутового та торгівельного призначення)";
                sendMessage.setText(s2);
                messageSender.sendMessage(sendMessage);
                //встановлюємо в БД тип приміщення
                databaseRepository.setType_premises("Громадські",userId);
                sendMessage.setText("2. Оберіть тип громадської будівлі/приміщення (порядковість не має значення): \uD83C\uDFE2");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypeSpacesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Адміністративні будівлі":
                s7 = "Обрано: адміністративні будівлі/приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                databaseRepository.setType_spaces_build("адміністративні",userId);
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка? \uD83D\uDCBB");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Будівлі побутового призначення":
                s7 = "Обрано: приміщення побутового призначення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                databaseRepository.setType_spaces_build("побутові",userId);
                sendMessage.setText("3. Оберіть тип  побутового приміщення: ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherPreparingFoodKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Підприємства торгівлі":
                s7 = "Обрано: тогрівельні приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                databaseRepository.setType_spaces_build("торгівельні",userId);
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка? \uD83D\uDCBB");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Офісні приміщення":
                s7 = "Обрано: офісні приміщення";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                databaseRepository.setType_spaces_build("офісні",userId);
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка? \uD83D\uDCBB");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Архіви, бібліотеки, музеї":
                s7 = "Обрано: архіви, бібліотеки, музеї";
                sendMessage.setText(s7);
                messageSender.sendMessage(sendMessage);
                //становлення в БД тип будівель
                databaseRepository.setType_spaces_build("архіви",userId);
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка? \uD83D\uDCBB");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, використовується":
                s8 = "Обрано: в приміщеннях використовується оргтехніка";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД чи використовується оргтехніка
                databaseRepository.setB1("true",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForPublicPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, не використовується":
                s8 = "Обрано: в приміщеннях не використовується оргтехніка";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД чи використовується оргтехніка
                databaseRepository.setB1("false",userId);
                sendMessage.setText("4. Оберіть бажаний/наявний тип вогнегасника \uD83E\uDDEF");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForPublicPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Приміщення для приготування їжі":
                s8 = "Обрано: приміщення для приготування їжі";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД приміщення використовується для приготування їжі
                databaseRepository.setType_premises("Кухні",userId);
                databaseRepository.setKitchen(1,userId);
                sendMessage.setText("4. Вкажіть кількість окремих робочих місць де в технологічному процесі приготування їжі застосовуються рослинні або тваринні масла і жири. Пілся - оберіть тип вогнегасника \uD83E\uDDEF: ");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKitchenKeyboard());
                databaseRepository.setValue("робочі місця",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Інші побутові приміщення":
                s8 = "Обрано: в приміщеннях відсутні технологічні процеси приготування їжі";
                sendMessage.setText(s8);
                messageSender.sendMessage(sendMessage);
                databaseRepository.setKitchen(0,userId);
                sendMessage.setText("3. Чи використовується в досліджуваному приміщенні оргтехніка? \uD83D\uDCBB");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherOfficeEquipmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Водяний для кухні":
                s5 = "Обрано: водяний вогнегасник";
                sendMessage.setText(s5);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("6. Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" ");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, передбачені":
                s9 = "Обрано: наявні технічні приміщення (у т.ч. комори, електрощитові тощо)\n";
                sendMessage.setText(s9);
                messageSender.sendMessage(sendMessage);
                databaseRepository.setB2("true",userId);
                sendMessage.setText("8. Надішліть загальну площу технічних приміщень (м.кв.) після чого натисніть \"Розрахувати\"");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateTechnicalPremisesKeyboard());
                databaseRepository.setType_premises("Технічні приміщення",userId);
                databaseRepository.setValue("технічні приміщення",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, не передбачені":
                sendMessage.setText("Технічні приміщення відсутні. Додаткового остащення вогнегасниками не потребується");
                databaseRepository.setB2("false",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Житлові":
                s2 = "Обрано: Житлові приміщення";
                sendMessage.setText(s2);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу приміщення
                databaseRepository.setType_premises("Житлові",userId);
                sendMessage.setText("2. Оберіть різновид житлового приміщення \uD83C\uDFE1");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypesLivingKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Квартири":
                s10 = "Обрано: квартири багатоквартирних житлових будинків";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result());
                messageSender.sendMessage(sendMessage);
                break;
            case "Гуртожитки":
                s10 = "Обрано: кімната/секція/блок гуртожитку";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result());
                messageSender.sendMessage(sendMessage);
                break;
            case "Будинки індивідуальної забудови":
                s10 = "Обрано: житлові будинки індивідуальної забудови";
                sendMessage.setText(s10);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(result());
                messageSender.sendMessage(sendMessage);
                break;
            case "Гаражі/автомайстерні":
                s2 = "Обрано: Приміщення автогаражів, автостоянок та/або автомайстерень";
                sendMessage.setText(s2);
                //встановлення в БД типу приміщення
                databaseRepository.setType_premises("Гаражі",userId);
                sendMessage.setText("2. Надішліть кількість місць стоянки автомобілів у боксі (гаражі, стоянці) після чого натисніть \"Розрахувати\" \uD83C\uDD7F️");
                sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                databaseRepository.setValue("паркування",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Розрахувати":
                if(databaseRepository.getValue(userId).equals("паркування")){
                    if (databaseRepository.getParking(userId)!=null){
                        sendMessage.setText(result());
                        messageSender.sendMessage(sendMessage);
                    }else{
                        sendMessage.setText("Ви не ввели рекомендовані системою параметри. \n\n" +
                                "2. Надішліть кількість місць стоянки автомобілів у боксі (гаражі, стоянці) після чого натисніть \"Розрахувати\" \uD83C\uDD7F️");
                        sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                        messageSender.sendMessage(sendMessage);
                    }
                }else if (databaseRepository.getSquare(userId)!= null){
                    sendMessage.setText(result());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText("7. Чи передбачені в досліджуваних приміщеннях комори, електрощитові, вентиляційні камери або інші технічні приміщення? ⚡️");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTechnicalАcilitiesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else {
                    sendMessage.setText("Ви не ввели рекомендовані системою параметри. \n\n" +
                            "Надішліть площу приміщення/поверху(м.кв) та натисніть \" Розрахувати \" \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "Розрахувати(техн.прим)":
                if (databaseRepository.getSquare_technical_premises(userId)!=null){
                    sendMessage.setText(result());
                    messageSender.sendMessage(sendMessage);
                }else{
                    sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                            "Надішліть загальну площу технічних приміщень (м.кв.) після чого натисніть \"Розрахувати\" \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherCalculateTechnicalPremisesKeyboard());
                    messageSender.sendMessage(sendMessage);
                }

                break;


            //кейси, що відповідають за роботу бота - визначення ступеня ризику
            case "Об’єкт що експлуатується":
                s2 = "Обрано: об'єкт експлуатується";
                sendMessage.setText(s2);
                //встановлює в БД характеристику об'єкта
                databaseRepository.setCharacteristics_object("експлуатується",userId);
                sendMessage.setText("2. Оберіть тип об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "\uD83D\uDC49 2.1. Об’єкт підвищеної небезпеки\n" +
                        "\uD83D\uDC49 2.2. Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави\n" +
                        "\uD83D\uDC49 2.3. Об’єкт метрополітену\n" +
                        "\uD83D\uDC49 2.4. Об’єкт, включений до Державного реєстру нерухомих пам’яток\n" +
                        "\uD83D\uDC49 2.5. Промисловий або складський об’єкт\n" +
                        "\uD83D\uDC49 2.6. Інший об’єкт");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskDataEntryKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Об’єкт на стадії будівництва":
                s2 = "Обрано: об'єкт на стадії будівництва";
                sendMessage.setText(s2);
                //встановлює в БД характеристику об'єкта
                databaseRepository.setCharacteristics_object("проєктується",userId);
                databaseRepository.setValue("null",userId);
                sendMessage.setText("2. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n" +
                        "\n" +
                        "\uD83D\uDC49 2.1. Надзвичайна ситуація державного рівня\n" +
                        "\uD83D\uDC49 2.2. Надзвичайна ситуація регіонального рівня\n" +
                        "\uD83D\uDC49 2.3. Надзвичайна ситуація місцевого рівня\n" +
                        "\uD83D\uDC49 2.4. Надзвичайна ситуація об’єктового рівня\n" +
                        "\uD83D\uDC49 2.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                        "\uD83D\uDC49 2.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesDesigningBuildingKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1":
                s3 = "Обрано: Об’єкт підвищеної небезпеки";
                //встановлює в БД типу об'єкту ризику
                databaseRepository.setType_object_of_risk("обєкт підвищеної небезпеки",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \uD83D\uDC47 \n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2":
                s3 = "Обрано: Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                databaseRepository.setType_object_of_risk("обєкт стратегічного значення",userId);
                sendMessage.setText("3. Оберіть різновид об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "\uD83D\uDC49 3.1. Об’єкт сфери оборони \n" +
                        "\uD83D\uDC49 3.2. Об’єкт паливно-енергетичного комплексу\n" +
                        "\uD83D\uDC49 3.3. Об’єкт транспортної галузі \n" +
                        "\uD83D\uDC49 3.4. Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву \n" +
                        "\uD83D\uDC49 3.5. Об’єкт агропромислового комплексу \n" +
                        "\uD83D\uDC49 3.6. Об’єкт сфери електронних комунікацій та зв’язку \n" +
                        "\uD83D\uDC49 3.7. Об’єкт авіаційної та ракетно-космічної промисловості \n" +
                        "\uD83D\uDC49 3.8. Об’єкт машинобудівної промисловості \n" +
                        "\uD83D\uDC49 3.9. Об’єкт металургійного комплексу \n" +
                        "\uD83D\uDC49 3.10. Об’єкт хімічного комплексу \n" +
                        "\uD83D\uDC49 3.11. Об’єкт наукової діяльності \n" +
                        "\uD83D\uDC49 3.12. Об’єкт сфери стандартизації, метрології та сертифікації \n" +
                        "\uD83D\uDC49 3.13. Об’єкт гідрометеорологічної діяльності \n" +
                        "\uD83D\uDC49 3.14. Об’єкт промисловості будівельних матеріалів \n" +
                        "\uD83D\uDC49 3.15. Об’єкт фінансово-бюджетної сфери \n" +
                        "\uD83D\uDC49 3.16. Об’єкт харчової промисловості \n" +
                        "\uD83D\uDC49 3.17. Об’єкт легкої промисловості \n" +
                        "\uD83D\uDC49 3.18. Об’єкт поліграфії \n" +
                        "\uD83D\uDC49 3.19. Об’єкт геологорозвідувальної галузі");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskStateOwnedObjectKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3":
                s3 = "Обрано: Об’єкт метрополітену";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                databaseRepository.setType_object_of_risk("обєкт метрополітену",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"\n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.4":
                s3 = "Обрано: Об’єкт, включений до Державного реєстру нерухомих пам’яток";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                databaseRepository.setType_object_of_risk("нерухома памятка",userId);
                sendMessage.setText("3. Оберіть різновид об’єкта (з запропонованого переліку):\n" +
                        "\n" +
                        "\uD83D\uDC49 3.1. Пам’ятка культурної спадщини національного значення \n" +
                        "\uD83D\uDC49 3.2. Пам’ятка культурної спадщини місцевого значення");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectsCulturalHeritageKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5":
                s3 = "Обрано: Промисловий або складський об’єкт";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД типу об'єкту ризику
                databaseRepository.setType_object_of_risk("промисловий або складський обєкт",userId);
                sendMessage.setText("3. Оберіть різновид об’єкта:");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskIndustrialWarehouseObjectsKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Промисловий об’єкт":
                s4 = "Обрано: Промисловий об’єкт";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлює в БД тип промислового об'єкту
                databaseRepository.setType_industrial_storage_facility("промисловий обєкт",userId);
                sendMessage.setText("4. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою 🔥");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskCategoryPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Складський об’єкт":
                s4 = "Обрано: Складський об’єкт";
                //встановлює в БД тип промислового об'єкту
                databaseRepository.setType_industrial_storage_facility("складський обєкт",userId);
                sendMessage.setText("4. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою 🔥");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskCategoryPremisesKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення А":
                s3 = "Обрано: приміщення категорії А";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                databaseRepository.setCategory_premises("Категорія А",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n ");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Б":
                s3 = "Обрано: приміщення категорії Б";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                databaseRepository.setCategory_premises("Категорія Б",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення В":
                s3 = "Обрано: приміщення категорії В";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                databaseRepository.setCategory_premises("Категорія В",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Г":
                s3 = "Обрано: приміщення категорії Г";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                databaseRepository.setCategory_premises("Категорія Г",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення Д":
                s3 = "Обрано: приміщення категорії Д";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД категорії приміщення
                databaseRepository.setCategory_premises("Категорія Д",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("\"Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.6":
                s3 = "Обрано: Інші об’єкти";
                sendMessage.setText(s3);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД тип об'єкту ризику
                databaseRepository.setType_object_of_risk("інші обєкти",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"\n");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Далі":
                if (databaseRepository.getCharacteristics_object(userId).equals("експлуатується")){
                    if (databaseRepository.getValue(userId).equals("площа")){
                        if (databaseRepository.getSquare(userId)!=null){
                            databaseRepository.setValue("постійно перебувають на обєкті",userId);
                            sendMessage.setText("Введіть максимальну розрахункову (проектну) кількість людей, які ПОСТІЙНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (databaseRepository.getValue(userId).equals("постійно перебувають на обєкті")){
                        if (databaseRepository.getConstantly_at_facility(userId)!=null){
                            databaseRepository.setValue("періодично перебувають на обєкті",userId);
                            sendMessage.setText("Введіть максимальну розрахункову (проектну) кількість людей, які ПЕРІОДИЧНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть максимальну розрахункову (проектну) кількість людей, які ПОСТІЙНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (databaseRepository.getValue(userId).equals("періодично перебувають на обєкті")){
                        if (databaseRepository.getPeriodically_at_facility(userId)!=null){
                            databaseRepository.setValue("висота обєкта",userId);
                            sendMessage.setText("Введіть значення умовної висоти об’єкта (м.) (визначається різницею позначок найнижчого рівня проїзду (встановлення)"
                                    + " пожежних автодрабин (автопідйомників) і підлоги верхнього поверху без урахування верхніх технічних поверхів, "
                                    + "якщо на технічних поверхах розміщено лише інженерні обладнання та комунікації будинку). Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                    "Введіть максимальну розрахункову (проектну) кількість людей, які ПЕРІОДИЧНО перебувають на об’єкті (осіб) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (databaseRepository.getValue(userId).equals("висота обєкта")){
                        if (databaseRepository.getHeight_object(userId)!=null){
                            if (databaseRepository.getType_object_of_risk(userId).equals("обєкт підвищеної небезпеки") || databaseRepository.getType_object_of_risk(userId).equals("обєкт метрополітену")
                                    || databaseRepository.getType_object_of_risk(userId).equals("інші обєкти")) {
                                sendMessage.setText("3. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n" +
                                        "\n" +
                                        "\uD83D\uDC49 3.1. Надзвичайна ситуація державного рівня\n" +
                                        "\uD83D\uDC49 3.2. Надзвичайна ситуація регіонального рівня\n" +
                                        "\uD83D\uDC49 3.3. Надзвичайна ситуація місцевого рівня\n" +
                                        "\uD83D\uDC49 3.4. Надзвичайна ситуація об’єктового рівня\n" +
                                        "\uD83D\uDC49 3.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                                        "\uD83D\uDC49 3.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskDangerousEventsKeyboard());
                                messageSender.sendMessage(sendMessage);
                                databaseRepository.setValue("null",userId);
                            } else if (databaseRepository.getType_object_of_risk(userId).equals("обєкт стратегічного значення") || databaseRepository.getType_object_of_risk(userId).equals("нерухома памятка")) {
                                sendMessage.setText("4. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n" +
                                        "\uD83D\uDC49 4.1. Надзвичайна ситуація державного рівня\n" +
                                        "\uD83D\uDC49 4.2. Надзвичайна ситуація регіонального рівня\n" +
                                        "\uD83D\uDC49 4.3. Надзвичайна ситуація місцевого рівня\n" +
                                        "\uD83D\uDC49 4.4. Надзвичайна ситуація об’єктового рівня\n" +
                                        "\uD83D\uDC49 4.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n" +
                                        "\uD83D\uDC49 4.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesStrategicKeyboard());
                                messageSender.sendMessage(sendMessage);
                                databaseRepository.setValue("null",userId);
                            } else if (databaseRepository.getType_object_of_risk(userId).equals("промисловий або складський обєкт")) {
                                sendMessage.setText("5. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
                                        + "\uD83D\uDC49 5.1. Надзвичайна ситуація державного рівня\n"
                                        + "\uD83D\uDC49 5.2. Надзвичайна ситуація регіонального рівня\n"
                                        + "\uD83D\uDC49 5.3. Надзвичайна ситуація місцевого рівня\n"
                                        + "\uD83D\uDC49 5.4. Надзвичайна ситуація об’єктового рівня\n"
                                        + "\uD83D\uDC49 5.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
                                        + "\uD83D\uDC49 5.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesIndustrialKeyboard());
                                messageSender.sendMessage(sendMessage);
                                databaseRepository.setValue("null",userId);
                            } else if (databaseRepository.getType_object_of_risk(userId).equals("проєктується")) {
                                sendMessage.setText("2. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
                                        + "\uD83D\uDC49 2.1. Надзвичайна ситуація державного рівня\n"
                                        + "\uD83D\uDC49 2.2. Надзвичайна ситуація регіонального рівня\n"
                                        + "\uD83D\uDC49 2.3. Надзвичайна ситуація місцевого рівня\n"
                                        + "\uD83D\uDC49 2.4. Надзвичайна ситуація об’єктового рівня\n"
                                        + "\uD83D\uDC49 2.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
                                        + "\uD83D\uDC49 2.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskScaleOfEmergenciesDesigningBuildingKeyboard());
                                messageSender.sendMessage(sendMessage);
                                databaseRepository.setValue("null",userId);
                            }
                        } else {
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                    "Введіть значення умовної висоти об’єкта (м.) (визначається різницею позначок найнижчого рівня проїзду (встановлення)"
                                    + "пожежних автодрабин (автопідйомників) і підлоги верхнього поверху без урахування верхніх технічних поверхів, "
                                    + "якщо на технічних поверхах розміщено лише інженерні обладнання та комунікації будинку). Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (databaseRepository.getLevel_emergency(userId)!=null){
                        if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) == null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getFixed_violations(userId)==null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getFixed_violations(userId)==null)
                                || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня")||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getFixed_violations(userId) == null)){
                            if (databaseRepository.getValue(userId).equals("усунено порушень") && databaseRepository.getFixed_violations(userId) == null) {
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                        "Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта " +
                                        "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else {
                                databaseRepository.setValue("усунено порушень",userId);
                                sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта " +
                                        "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\"\uD83D\uDC47 \n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }
                        }else if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня")||databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) != null && databaseRepository.getNo_fixed_violations(userId) == null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getNo_fixed_violations(userId) ==null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getNo_fixed_violations(userId)==null)
                                || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") ||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС"))  && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getNo_fixed_violations(userId) == null)){
                            if (databaseRepository.getValue(userId).equals("не усунено порушень") && databaseRepository.getNo_fixed_violations(userId) == null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                        "Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією" +
                                        "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \uD83D\uDC47 ");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else {
                                databaseRepository.setValue("не усунено порушень",userId);
                                sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією \n" +
                                        "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \uD83D\uDC47 \n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }
                        }else if ((databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") || databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) == null){
                            if (databaseRepository.getValue(userId).equals("загиблі") && databaseRepository.getDead_people(userId) == null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                        "Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \uD83D\uDC47 ");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else {
                                databaseRepository.setValue("загиблі",userId);
                                sendMessage.setText("Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \uD83D\uDC47 \n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }

                        }else if ((databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) == null){
                            if (databaseRepository.getValue(userId).equals("збитки") && databaseRepository.getLosses(userId) == null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                        "Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else{
                                databaseRepository.setValue("збитки",userId);
                                sendMessage.setText("Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\" \uD83D\uDC47 \n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }
                        }else if ((databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) != null && databaseRepository.getTax_free_income(userId) == null){
                            if (databaseRepository.getValue(userId).equals("дохід") && databaseRepository.getTax_free_income(userId) == null){
                                sendMessage.setText("Ва не ввели рекомендовані системою параметри \n\n" +
                                        "Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else {
                                databaseRepository.setValue("дохід",userId);
                                sendMessage.setText("Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \uD83D\uDC47 \n");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }

                        }else if ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) != null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getInjured_people(userId) == null){
                            if (databaseRepository.getValue(userId).equals("травмовані") && databaseRepository.getInjured_people(userId) == null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                        "Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" \uD83D\uDC47 ");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }else {
                                databaseRepository.setValue("травмовані",userId);
                                sendMessage.setText("Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" \uD83D\uDC47 ");
                                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                                messageSender.sendMessage(sendMessage);
                            }
                        }else if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) != null && databaseRepository.getNo_fixed_violations(userId) != null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getFixed_violations(userId)!=null)
                                || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getFixed_violations(userId)!=null)
                                || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня")||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getFixed_violations(userId) != null)){
                            sendMessage.setText(resultDegreeRisk());
                            messageSender.sendMessage(sendMessage);
                        }
                    }
                }else if (databaseRepository.getCharacteristics_object(userId).equals("проєктується")){
                    if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) == null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getFixed_violations(userId)==null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getFixed_violations(userId)==null)
                            || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня")||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getFixed_violations(userId) == null)){
                        if (databaseRepository.getValue(userId).equals("усунено порушень") && databaseRepository.getFixed_violations(userId) == null) {
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта " +
                                    "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            databaseRepository.setValue("усунено порушень",userId);
                            sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта " +
                                    "УСУНЕНИХ за останніх 5 років. Натисніть \"Далі\"\uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня")||databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) != null && databaseRepository.getNo_fixed_violations(userId) == null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getNo_fixed_violations(userId) ==null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getNo_fixed_violations(userId)==null)
                            || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") ||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС"))  && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getNo_fixed_violations(userId) == null)) {
                        if (databaseRepository.getValue(userId).equals("не усунено порушень") && databaseRepository.getNo_fixed_violations(userId) == null){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                    "Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією" +
                                    "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            databaseRepository.setValue("не усунено порушень",userId);
                            sendMessage.setText("Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією \n" +
                                    "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if ((databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") || databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) == null){
                        if (databaseRepository.getValue(userId).equals("загиблі") && databaseRepository.getDead_people(userId) == null){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            databaseRepository.setValue("загиблі",userId);
                            sendMessage.setText("Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if ((databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) == null){
                        if (databaseRepository.getValue(userId).equals("збитки") && databaseRepository.getLosses(userId) == null){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else{
                            databaseRepository.setValue("збитки",userId);
                            sendMessage.setText("Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if ((databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") || databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) != null && databaseRepository.getTax_free_income(userId) == null){
                        if (databaseRepository.getValue(userId).equals("дохід") && databaseRepository.getTax_free_income(userId) == null){
                            sendMessage.setText("Ва не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            databaseRepository.setValue("дохід",userId);
                            sendMessage.setText("Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть \"Далі\" \uD83D\uDC47 \n");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня") || databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId) != null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getInjured_people(userId) == null){
                        if (databaseRepository.getValue(userId).equals("травмовані") && databaseRepository.getInjured_people(userId) == null){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                                    "Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }else {
                            databaseRepository.setValue("травмовані",userId);
                            sendMessage.setText("Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                            messageSender.sendMessage(sendMessage);
                        }
                    }else if (((databaseRepository.getLevel_emergency(userId).equals("НС державного рівня") || databaseRepository.getLevel_emergency(userId).equals("без НС")) && databaseRepository.getFixed_violations(userId) != null && databaseRepository.getNo_fixed_violations(userId) != null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС регіонального рівня") &&  databaseRepository.getDead_people(userId) != null && databaseRepository.getFixed_violations(userId)!=null)
                            || (databaseRepository.getLevel_emergency(userId).equals("НС місцевого рівня") && databaseRepository.getDead_people(userId) != null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId) != null && databaseRepository.getFixed_violations(userId)!=null)
                            || ((databaseRepository.getLevel_emergency(userId).equals("НС обєктового рівня")||databaseRepository.getLevel_emergency(userId).equals("не класифікована НС")) && databaseRepository.getDead_people(userId)!=null && databaseRepository.getLosses(userId)!=null && databaseRepository.getTax_free_income(userId)!=null && databaseRepository.getInjured_people(userId) !=null && databaseRepository.getFixed_violations(userId) != null)){
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
                if (databaseRepository.getWorkplace(userId)!=null){
                    sendMessage.setText("5. Оберіть необхідний тип вогнегасника");
                    sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherForKitchenKeyboard());
                    messageSender.sendMessage(sendMessage);
                }else{
                    sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                            "Вкажіть кількість окремих робочих місць де в технологічному процесі приготування їжі застосовуються рослинні або тваринні масла і жири. Після - оберіть тип вогнегасника \uD83E\uDDEF:");
                    sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKitchenKeyboard());
                    messageSender.sendMessage(sendMessage);
                }
                break;
            case "🏢 3.1":
                s4 = "Обрано: Об’єкт сфери оборони";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт оборони",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.2":
                s4 = "Обрано: Об’єкт паливно-енергетичного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт енергетичного комплексу",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.3":
                s4 = "Обрано: Об’єкт транспортної галузі";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт транспорту",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.4":
                s4 = "Обрано: Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт держрезерву",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.5":
                s4 = "Обрано: Об’єкт агропромислового комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт аграрного комплексу",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.6":
                s4 = "Обрано: Об’єкт сфери електронних комунікацій та зв’язку";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт зв'язку",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.7":
                s4 = "Обрано: Об’єкт авіаційної та ракетно-космічної промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт авіації",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.8":
                s4 = "Обрано: Об’єкт машинобудівної промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт машинобувної промисловості",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.9":
                s4 = "Обрано: Об’єкт металургійного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт металургії",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.10":
                s4 = "Обрано: Об’єкт хімічного комплексу";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт хімпрому",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.11":
                s4 = "Обрано: Об’єкт наукової діяльності";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт науки",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.12":
                s4 = "Обрано: Об’єкт сфери стандартизації, метрології та сертифікації";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт метрології",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.13":
                s4 = "Обрано: Об’єкт гідрометеорологічної діяльності";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт гідрометеорології",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.14":
                s4 = "Обрано: Об’єкт промисловості будівельних матеріалів";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт будматеріалів",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.15":
                s4 = "Обрано: Об’єкт фінансово-бюджетної сфери";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт фінансово-бюджетний",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.16":
                s4 = "Обрано: Об’єкт харчової промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт харчовий",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.17":
                s4 = "Обрано: Об’єкт легкої промисловості";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт легкої промисловості",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.18":
                s4 = "Обрано: Об’єкт поліграфії";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт поліграфії",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏢 3.19":
                s4 = "Обрано: Об’єкт геологорозвідувальної галузі";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //встановлення в БД типу об'єкту державної власності
                databaseRepository.setType_state_owned_object("обєкт геологорозвідувальний",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏛 3.1":
                s4 = "Обрано: Пам’ятка культурної спадщини національного значення";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_culture_object("памятка національного значення",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🏛 3.2":
                s4 = "Обрано: Пам’ятка культурної спадщини місцевого значення";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_culture_object("памятка місцевого значення",userId);
                databaseRepository.setValue("площа",userId);
                sendMessage.setText("Надішліть загальну площу об'єкта (м.кв.) та натисніть \"Далі\"");
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.1":
            case "🔥 4.1":
            case "🔥 3.1":
            case "🔥 2.1":
                s3 = "Обрано: надзвичайна ситуація державного рівня";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("НС державного рівня",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.2":
            case "🔥 4.2":
            case "🔥 3.2":
            case "🔥 2.2":
                s3 = "Обрано: надзвичайна ситуація регіонального рівня";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("НС регіонального рівня",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.3":
            case "🔥 4.3":
            case "🔥 3.3":
            case "🔥 2.3":
                s3 = "Обрано: надзвичайна ситуація місцевого рівня";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("НС місцевого рівня",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.4":
            case "🔥 4.4":
            case "🔥 3.4":
            case "🔥 2.4":
                s3 = "Обрано: надзвичайна ситуація об’єктового рівня";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("НС обєктового рівня",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.5":
            case "🔥 4.5":
            case "🔥 3.5":
            case "🔥 2.5":
                s3 = "Обрано: небезпечна подія, що не класифікується як надзвичайна ситуація";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("не класифікована НС",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "🔥 5.6":
            case "🔥 4.6":
            case "🔥 3.6":
            case "🔥 2.6":
                s3 = "Обрано: надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало";
                sendMessage.setText(s3);
                databaseRepository.setLevel_emergency("без НС",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskObjectAreaKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.1":
                s4 = "Обрано: Об’єкт із значними наслідками (СС3)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                databaseRepository.setType_result_degree_risk("об’єкт із значними наслідками",userId);
                sendMessage.setText(resultDegreeRisk());
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.2":
                s4 = "Обрано: Об’єкт із середніми наслідками (СС2)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                databaseRepository.setType_result_degree_risk("об’єкт із середніми наслідками",userId);
                sendMessage.setText(resultDegreeRisk());
                messageSender.sendMessage(sendMessage);
                break;
            case "⚡️ 3.3":
                s4 = "Обрано: Об’єкт із незначними наслідками (СС1)";
                sendMessage.setText(s4);
                messageSender.sendMessage(sendMessage);
                //додавання в БД тип об'єкту із наслідками
                databaseRepository.setType_result_degree_risk("об’єкт із незначними наслідками",userId);
                sendMessage.setText(resultDegreeRisk());
                messageSender.sendMessage(sendMessage);
                break;

            // кейси, що відповідають за визначення категорій приміщень за пожежною небезпекою
            case "Категорія Прим./Буд/Зовн.Уст":
                sendMessage.setText("2. Оберіть місце розташування технологічної установки\uD83D\uDCCD");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationLocationKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Використовується в прим.":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі\uD83D\uDD25");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceRoomsKeyboard());
                // додавання в БД чи використовується об'єкт в приміщенні
                databaseRepository.setUsed_indoors("true",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Так, є необхідність":
                databaseRepository.setValue("обєм будівлі",userId);
                sendMessage.setText("1. Надішліть об'єм будівлі та натисніть \" Далі \" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Ні, необхідність відсутня":
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "Використовується на вулиці":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі\uD83D\uDD25");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationTypeOfSubstanceExternalKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія приміщення":
                sendMessage.setText("2. Оберіть вид речовини, що обертається у технологічному процесі\uD83D\uDD25");
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
                if (databaseRepository.getUsed_indoors(userId).equals("true")){
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
                if (databaseRepository.getUsed_indoors(userId).equals("true")){
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
                if (databaseRepository.getUsed_indoors(userId).equals("true")){
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
                if (databaseRepository.getUsed_indoors(userId).equals("true")){
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
                if (databaseRepository.getUsed_indoors(userId).equals("true")){
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
                databaseRepository.setValue("обєм будівлі",userId);
                sendMessage.setText("1. Надішліть об'єм будівлі та натисніть \" Далі \" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Далі категорія будівлі":
                if (databaseRepository.getVolume_premises(userId) == null){
                    sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n" +
                            "Надішліть об'єм будівлі та натисніть \" Далі \" \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                }else{
                    if (databaseRepository.getVolume_premises(userId) !=null && databaseRepository.getCategory_buildings(userId) == null) {
                        sendMessage.setText("Оберіть найнебезпечнішу категорію виробництва ⚠️");
                        sendMessage.setReplyMarkup(inlineButton.inlineDeterminationMostDangerousCategoryKeyboard());
                    }else {
                        if (databaseRepository.getValue(userId).equals("обєм приміщень А")) {
                            if (databaseRepository.getVolume_rooms_a(userId) == null) {
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                        "Надішліть об'єм приміщень категорії А та натисніть \" Далі \" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                            } else {
                                if (categoryBuilding.getBuildingCategoryA()) {
                                    sendMessage.setText(categories.getCategoryAб());
                                } else {
                                    databaseRepository.setValue("обєм приміщень Б",userId);
                                    sendMessage.setText("Надішліть об'єм приміщень категорії Б та натисніть \" Далі \" \uD83D\uDC47");
                                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                                }
                            }
                        }else if (databaseRepository.getValue(userId).equals("обєм приміщень Б")) {
                            if (databaseRepository.getVolume_rooms_б(userId)==null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                            "Надішліть об'єм приміщень категорії Б та натисніть \" Далі \" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                            }else {
                                if (categoryBuilding.getBuildingCategoryБ()){
                                sendMessage.setText(categories.getCategoryБб());
                                }else {
                                    databaseRepository.setValue("обєм приміщень В",userId);
                                    sendMessage.setText("Надішліть об'єм приміщень категорії B та натисніть \" Далі \" \uD83D\uDC47");
                                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                                }
                            }
                        }else if (databaseRepository.getValue(userId).equals("обєм приміщень В")){
                            if (databaseRepository.getVolume_rooms_в(userId)==null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                            "Надішліть об'єм приміщень категорії В та натисніть \" Далі \" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                            }else {
                                if (categoryBuilding.getBuildingCategoryВ()){
                                    sendMessage.setText(categories.getCategoryВб());
                                }else {
                                    databaseRepository.setValue("обєм приміщень Г",userId);
                                    sendMessage.setText("Надішліть об'єм приміщень категорії Г та натисніть \" Далі \" \uD83D\uDC47");
                                    sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                                }
                            }
                        }else if (databaseRepository.getValue(userId).equals("обєм приміщень Г")){
                            if (databaseRepository.getVolume_rooms_г(userId)==null){
                                sendMessage.setText("Ви не ввели рекомендовані системою параметри \n\n " +
                                            "Надішліть об'єм приміщень категорії Г та натисніть \" Далі \" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                            }else {
                                if (categoryBuilding.getBuildingCategoryГ()){
                                    sendMessage.setText(categories.getCategoryГб());
                                }else {
                                    sendMessage.setText(categories.getCategoryДб());
                                }
                            }
                        }
                    }
                }
                messageSender.sendMessage(sendMessage);
                break;
            case "А - вибухопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії А та натисніть \" Далі \" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setCategory_buildings("А",userId);
                databaseRepository.setValue("обєм приміщень А",userId);
                break;
            case "Б - вибухопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії Б та натисніть \" Далі \" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setCategory_buildings("Б",userId);
                databaseRepository.setValue("обєм приміщень Б",userId);
                break;
            case "В - пожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії В та натисніть \" Далі \" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setCategory_buildings("В",userId);
                databaseRepository.setValue("обєм приміщень В",userId);
                break;
            case "Г - помірнопожежонебезпечна":
                sendMessage.setText("Надішліть об'єм приміщень категорії Г та натисніть \" Далі \" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineDeterminationContinueKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setCategory_buildings("Г",userId);
                databaseRepository.setValue("обєм приміщень Г",userId);
                break;
            case "Д - зниженопожежонебезпечна":
                sendMessage.setText(categories.getCategoryД());
                messageSender.sendMessage(sendMessage);
                break;


            //кейси що відповідають за роботу класу зони
            case "1.1_Zone_classes":
                sendMessage.setText("Обрано: Використовуються вибухонебезпечні речовини");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("2. Оберіть період присутності вибухонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.1. Вибухонебезпечне середовище присутнє постійно, часто або протягом тривалого часу \n" +
                        "\uD83D\uDC49 2.2. Вибухонебезпечне середовище може утворитись під час нормальної експлуатації\n" +
                        "\uD83D\uDC49 2.3. Вибухонебезпечне середовище відсутнє або при утворенні триває не довго, та може виникати у випадку аварії");

                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1_Zone_classes":
                sendMessage.setText("Обрано: Вибухонебезпечне середовище присутнє постійно, часто або протягом тривалого часу");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте особливості простору вибухонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.1.1. Простір, у якому вибухонебезпечне середовище знаходиться в межах корпусів технологічного обладнання \n" +
                        "\uD83D\uDC49 2.1.2. Простір, у якому вибухонебезпечне середовище знаходиться, як в межах, так і  поза межами корпусів технологічного обладнання та утворений пиловими хмарами");

                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentTwoKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1.1_Zone_classes":
                sendMessage.setText(zc.zoneClass0());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1.2_Zone_classes":
                sendMessage.setText(zc.zoneClass20());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2_Zone_classes":
                sendMessage.setText("Обрано: Вибухонебезпечне середовище може утворитись під час нормальної експлуатації");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте особливості простору вибухонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.2.1. Простір, у якому вибухонебезпечне середовище може утворюватися під час нормальної роботи \n" +
                        "\uD83D\uDC49 2.2.2. Простір, у якому під час нормальної експлуатації ймовірна поява пилу у вигляді хмари в кількості, достатній для утворення вибухонебезпечні суміші");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentThreeKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2.1_Zone_classes":
                sendMessage.setText(zc.zoneClass1());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2.2_Zone_classes":
                sendMessage.setText(zc.zoneClass21());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3_Zone_classes":
                sendMessage.setText("Обрано: Вибухонебезпечне середовище відсутнє або при утворенні триває не довго, та може виникати у випадку аварії");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте особливості простору вибухонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.3.1. Простір, у якому вибухонебезпечне середовище за нормальних умов експлуатації відсутнє, а якщо виникає то рідко і триває недовго, викликаючи аварії катастрофічних розмірів  \n" +
                        "\uD83D\uDC49 2.3.2. Простір, у якому пил у завислому стані може з’являтися не часто й існувати недовго або в якому шари вибухонебезпечного пилу можуть існувати й утворювати вибухонебезпечні суміші в разі аварії");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentFourKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3.1_Zone_classes":
                sendMessage.setText(zc.zoneClass2());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3.2_Zone_classes":
                sendMessage.setText(zc.zoneClass22());
                messageSender.sendMessage(sendMessage);
                break;

            case "1.2_Zone_classes":
                sendMessage.setText("Обрано: Використовуються пожежонебезпечні речовини");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("2. Оберіть місце присутності пожежонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.1. Пожежонебезпечне середовище присутнє \n" +
                        "\uD83D\uDC49 2.2. В приміщенні присутні речовини");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentFiveKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1_Zone_classes":
                sendMessage.setText("Обрано: Пожежонебезпечне середовище присутнє");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте особливості пожежонебезпечного середовища: \n\n" +
                        "\uD83D\uDC49 2.1.1. В середині приміщень \n" +
                        "\uD83D\uDC49 2.1.2. Поза приміщеннями");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentSixKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1.1_Zone_classes":
                sendMessage.setText("Обрано: Пожежонебезпечне середовище в середині приміщень");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте характеристику простору у приміщенні: \n\n" +
                        "\uD83D\uDC493.1.1.1. Простір приміщення, у якому знаходиться горюча рідина, яка має температуру спалаху більше + 61 С\n" +
                        "\uD83D\uDC492.1.1.2. Простір приміщення, у якому можуть накопичуватись і виділятися горючий пил або волокна\n" +
                        "\uD83D\uDC492.1.1.3. Простір приміщення, у якому знаходяться тверді горючі речовини та матеріали");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentSevenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1.1.1_Zone_classes":
                sendMessage.setText(zc.zoneClassP_I());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1.1.2_Zone_classes":
                sendMessage.setText(zc.zoneClassP_II());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1.1.3_Zone_classes":
                sendMessage.setText(zc.zoneClassP_IIa());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1.2_Zone_classes":
                sendMessage.setText("Обрано: Пожежонебезпечне середовище поза приміщеннями");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(zc.zoneClassP_III());
                messageSender.sendMessage(sendMessage);
                break;

            case "3.2_Zone_classes":
                sendMessage.setText("Обрано: В приміщенні присутні речовини");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("Зазначте характеристику горючих речовин: \n\n" +
                        "\uD83D\uDC49 2.2.1. Горючі рідини з температурою спалаху більше + 61 С у закритому тиглі \n" +
                        "\uD83D\uDC49 2.2.2. Горючі пили або волокна, при надлишковому розрахунковому тиску вибуху ≤ 5 кПа \n" +
                        "\uD83D\uDC49 2.2.3. Тверді горючі речовини та матеріали");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentEightKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2.1_Zone_classes":
                sendMessage.setText(zc.zoneClassP_I());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2.2_Zone_classes":
                sendMessage.setText(zc.zoneClassP_II());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2.3_Zone_classes":
                sendMessage.setText(zc.zoneClassP_IIa());
                messageSender.sendMessage(sendMessage);
                break;


                case "1.3_Zone_classes":
                sendMessage.setText("Обрано: Відсутні вибухо- та пожежонебезпечні речовини");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("2. Оберіть вид приміщення: \n\n" +
                        "\uD83D\uDC49 2.1. Приміщення сухе, відносна вологість до 60 % \n" +
                        "\uD83D\uDC49 2.2. Приміщення вологе, відносна вологість від 60 % до 75 % \n" +
                       "\uD83D\uDC49 2.3. Приміщення сире, відносна вологість більше 75 % \n" +
                        "\uD83D\uDC49 2.4. Приміщення особливо сире, відносна вологість близька до 100 % ");
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentNineKeyboard());
                messageSender.sendMessage(sendMessage);
                break;

            case "4.1_Zone_classes":
                sendMessage.setText("Обрано: Приміщення сухе, відносна вологість до 60 %");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Зазначте особливості приміщення де відбувається технологічний процес: \n\n" +
                        "\uD83D\uDC49 3.1. Приміщення гаряче, температура більше + 35 С \n" +
                        "\uD83D\uDC49 3.2. Приміщення запилене \n" +
                        "\uD83D\uDC49 3.3. Приміщення з агресивними парами, рідинами, газами \n" +
                        "\uD83D\uDC49 3.4. Відсутні особливості технологічного процесу ");
                databaseRepository.setHumidity_of_space("сухе",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentTenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.2_Zone_classes":
                sendMessage.setText("Обрано: Приміщення вологе, відносна вологість від 60 % до 75%");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Зазначте особливості приміщення де відбувається технологічний процес: \n\n" +
                        "\uD83D\uDC49 3.1. Приміщення гаряче, температура більше + 35 С \n" +
                        "\uD83D\uDC49 3.2. Приміщення запилене \n" +
                        "\uD83D\uDC49 3.3. Приміщення з агресивними парами, рідинами, газами \n" +
                        "\uD83D\uDC49 3.4. Відсутні особливості технологічного процесу ");
                databaseRepository.setHumidity_of_space("вологе",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentTenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.3_Zone_classes":
                sendMessage.setText("Обрано: Приміщення сире, відносна вологість більше 75%");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Зазначте особливості приміщення де відбувається технологічний процес: \n\n" +
                        "\uD83D\uDC49 3.1. Приміщення гаряче, температура більше + 35 С \n" +
                        "\uD83D\uDC49 3.2. Приміщення запилене \n" +
                        "\uD83D\uDC49 3.3. Приміщення з агресивними парами, рідинами, газами \n" +
                        "\uD83D\uDC49 3.4. Відсутні особливості технологічного процесу ");
                databaseRepository.setHumidity_of_space("сире",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentTenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.4_Zone_classes":
                sendMessage.setText("Обрано: Приміщення особливо сире, відносна вологість близько до 100%");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Зазначте особливості приміщення де відбувається технологічний процес: \n\n" +
                        "\uD83D\uDC49 3.1. Приміщення гаряче, температура більше + 35 С \n" +
                        "\uD83D\uDC49 3.2. Приміщення запилене \n" +
                        "\uD83D\uDC49 3.3. Приміщення з агресивними парами, рідинами, газами \n" +
                        "\uD83D\uDC49 3.4. Відсутні особливості технологічного процесу ");
                databaseRepository.setHumidity_of_space("особливо сире",userId);
                sendMessage.setReplyMarkup(inlineButton.inlineExplosiveEnvironmentTenKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "5.1_Zone_classes":
                sendMessage.setText("Обрано: гаряче приміщення");
                messageSender.sendMessage(sendMessage);
                if (databaseRepository.getHumidity_of_space(userId).equals("сухе")){
                    sendMessage.setText(zc.zoneClassSukhi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassGariachi());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getHumidity_of_space(userId).equals("вологе")){
                    sendMessage.setText(zc.zoneClassVologi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassGariachi());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("сире")){
                    sendMessage.setText(zc.zoneClassSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassGariachi());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("особливо сире")){
                    sendMessage.setText(zc.zoneClassOsoblyvoSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassGariachi());
                    messageSender.sendMessage(sendMessage);

                }
                break;
            case "5.2_Zone_classes":
                sendMessage.setText("Обрано: запилене приміщення");
                messageSender.sendMessage(sendMessage);
                if (databaseRepository.getHumidity_of_space(userId).equals("сухе")){
                    sendMessage.setText(zc.zoneClassSukhi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassZapyleni());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getHumidity_of_space(userId).equals("вологе")){
                    sendMessage.setText(zc.zoneClassVologi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassZapyleni());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("сире")){
                    sendMessage.setText(zc.zoneClassSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassZapyleni());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("особливо сире")){
                    sendMessage.setText(zc.zoneClassOsoblyvoSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassZapyleni());
                    messageSender.sendMessage(sendMessage);

                }
                break;
            case "5.3_Zone_classes":
                sendMessage.setText("Обрано: Приміщення з агресивними парами, рідинами, газами");
                messageSender.sendMessage(sendMessage);
                if (databaseRepository.getHumidity_of_space(userId).equals("сухе")){
                    sendMessage.setText(zc.zoneClassSukhi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassKhimichni());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getHumidity_of_space(userId).equals("вологе")){
                    sendMessage.setText(zc.zoneClassVologi());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassKhimichni());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("сире")){
                    sendMessage.setText(zc.zoneClassSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassKhimichni());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("особливо сире")){
                    sendMessage.setText(zc.zoneClassOsoblyvoSyri());
                    messageSender.sendMessage(sendMessage);
                    sendMessage.setText(zc.zoneClassKhimichni());
                    messageSender.sendMessage(sendMessage);

                }
                break;
            case "5.4_Zone_classes":
                sendMessage.setText("Відсутні особливості технологічного процесу");
                messageSender.sendMessage(sendMessage);
                if (databaseRepository.getHumidity_of_space(userId).equals("сухе")){
                    sendMessage.setText(zc.zoneClassSukhi());
                    messageSender.sendMessage(sendMessage);
                }else if (databaseRepository.getHumidity_of_space(userId).equals("вологе")){
                    sendMessage.setText(zc.zoneClassVologi());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("сире")){
                    sendMessage.setText(zc.zoneClassSyri());
                    messageSender.sendMessage(sendMessage);
                }else if(databaseRepository.getHumidity_of_space(userId).equals("особливо сире")){
                    sendMessage.setText(zc.zoneClassOsoblyvoSyri());
                    messageSender.sendMessage(sendMessage);

                }
                break;

            //проектування та монтаж пожежної сигналізації
            case "об’єкт громадського призначення":
                sendMessage.setText("Обрано: об’єкт громадського призначення");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("2. Виберіть призначення громадського об’єкту:\n\n" +
                        "\uD83D\uDC49 2.1 Об’єкт житлового фонду \n" +
                        "\uD83D\uDC49 2.2 Адміністративно-офісна будівля \n" +
                        "\uD83D\uDC49 2.3 Банківська установа\n" +
                        "\uD83D\uDC49 2.4 Торгівельний та/або заклад\n" +
                        "\uD83D\uDC49 2.5 Будівля громадського харчування\n" +
                        "\uD83D\uDC49 2.6 Виставкова або виставково-торгівельна будівля\n" +
                        "\uD83D\uDC49 2.7 Культурно-освітній або видовищний заклад\n" +
                        "\uD83D\uDC49 2.8 Музей\n" +
                        "\uD83D\uDC49 2.9 Бібліотека\n" +
                        "\uD83D\uDC49 2.10 Архів\n" +
                        "\uD83D\uDC49 2.11 Будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації, навчальні заклади\n" +
                        "\uD83D\uDC49 2.12 Заклади охорони здоров’я\n" +
                        "\uD83D\uDC49 2.13 Будівлі спортивного та фізкультурно-оздоровчого призначення\n" +
                        "\uD83D\uDC49 2.14 Культові та релігійні будівлі");
                sendMessage.setReplyMarkup(inlineButton.inlinePurposePublicObjectFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "об’єкт промислового призначення":
                sendMessage.setText("Обрано: об’єкт промислового призначення");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("2. Виберіть призначення промислового об'єкту: \n\n" +
                        "\uD83D\uDC49 2.1 Будівля транспорту\n" +
                        "\uD83D\uDC49 2.2 Будівля зберігання та обслуговування автомобільного транспорту \n" +
                        "\uD83D\uDC49 2.3 Виробнича будівля \n" +
                        "\uD83D\uDC49 2.4 Складська будівля\n" +
                        "\uD83D\uDC49 2.5 Споруди резервуарів для зберігання спирту, наземних резервуарів для зберігання нафти та нафтопродуктів \n" +
                        "\uD83D\uDC49 2.6 Будівля  сільськогосподарського призначення\n" +
                        "\uD83D\uDC49 2.7 Транспортний тунель\n" +
                        "\uD83D\uDC49 2.8 Допоміжна будівля трубопроводів\n" +
                        "\uD83D\uDC49 2.9 Склади нафтохімічних і нафтопереробних підприємств\n" +
                        "\uD83D\uDC49 2.10 Склад полімерних (високомолекулярннних) сполук \n");
                sendMessage.setReplyMarkup(inlineButton.inlinePurposeIndustrialObjectFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 громадський об'єкт":
                sendMessage.setText("Обрано: об’єкт житлового фонду");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі:\n\n " +
                        "\uD83D\uDC49 3.1 Житлова будівля \n" +
                        "\uD83D\uDC49 3.2 Багатоквартирний будинок для осіб похилого віку \n" +
                        "\uD83D\uDC49 3.3 Гуртожиток\n" +
                        "\uD83D\uDC49 3.4 Готель \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeResidentialBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 громадський об'єкт":
                sendMessage.setText("Обрано: адміністративно-офісна будівля");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі:\n\n " +
                        "\uD83D\uDC49 3.1 Адміністративні та офісні будівлі  \n" +
                        "\uD83D\uDC49 3.2 Будівлі Державних органів влади, виконавчих комітетів рад народних депутатів областей, міст, районів та відділів управління  \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeOfficeBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3 громадський об'єкт":
                sendMessage.setText("Обрано: банківська установа ");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getBank());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.4 громадський об'єкт":
                sendMessage.setText("Обрано: торгівельний та/або заклад");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі:\n\n" +
                        "\uD83D\uDC49 3.1 Торгівельні центри, криті ринки, магазини, ярмарки\n" +
                        "\uD83D\uDC49 3.2 Торгівельні центри з продажу сільськогосподарських продуктів, промислових товарів\n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeShoppingBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5 громадський об'єкт":
                sendMessage.setText("Обрано: будівля громадського харчування");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Вбудовані в будівлі іншого призначення \n" +
                        "\uD83D\uDC49 3.2 Окремо стоячі будівлі громадського харчування \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeCateringBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.6 громадський об'єкт":
                sendMessage.setText("Обрано: виставкова або виставково-торгівельна будівля");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Підземне розміщення \n" +
                        "\uD83D\uDC49 3.2 Надземне розміщення \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeExhibitionBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.7 громадський об'єкт":
                sendMessage.setText("Обрано: культурно-освітній або видовищний заклад");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі: \n\n" +
                        "3.1 \uD83D\uDC49 Театр, кіноконцертна і концертна зала, цирк, кінотеатр, дозвіллєвий заклад \n" +
                        "3.2 \uD83D\uDC49 Цирк \n" +
                        "3.3 \uD83D\uDC49 Кінотеатр, заклади дозвілля \n" +
                        "3.4 \uD83D\uDC49 Казино, ігровий заклад");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeScienceBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.8 громадський об'єкт":
                sendMessage.setText("Обрано: музей");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getMuseum());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.9 громадський об'єкт":
                sendMessage.setText("Обрано: бібліотека");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Вкажіть місце розташування об'єкту: \n\n" +
                        "3.1 \uD83D\uDC49 В будівлях органів влади, місцевого самоврядування та/або будівлях з умовною висотою більше 26,5 м \n" +
                        "3.2 \uD83D\uDC49 В інших будівлях \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeLibraryFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.10 громадський об'єкт":
                sendMessage.setText("Обрано: архів");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("архів",userId);
                sendMessage.setText("4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.11 громадський об'єкт":
                sendMessage.setText("Обрано: будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації, навчальні заклади");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("3. Оберіть тип будівлі: \n\n" +
                        "3.1 \uD83D\uDC49 Будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації \n" +
                        "3.2 \uD83D\uDC49 Дошкільні навчальні заклади\n" +
                        "3.3 \uD83D\uDC49 Загальноосвітні навчальні заклади, навчально-виробничі комбінати, позашкільні заклади\n" +
                        "3.4 \uD83D\uDC49 Спеціальні та санаторні школи, школи-інтернати");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeEducationBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.12 громадський об'єкт":
                sendMessage.setText("Обрано: заклади охорони здоров’я");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("охорона здоров'я",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "2.13 громадський об'єкт":
                sendMessage.setText("Обрано: будівлі спортивного та фізкультурно-оздоровчого призначення ");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getSport());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.14 громадський об'єкт":
                sendMessage.setText("Обрано: культові та релігійні будівлі");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("релігійні будівлі",userId);
                sendMessage.setText("4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.1 житловий фонд":
                sendMessage.setText("Обрано: житлова будівля");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("житлова будівля",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 житловий фонд":
                sendMessage.setText("Обрано: багатоквартирний будинок для осіб похилого віку");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getNursingHome());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 житловий фонд":
                sendMessage.setText("Обрано: гуртожиток");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("гуртожиток",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 житловий фонд":
                sendMessage.setText("Обрано: готель");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("готель",userId);
                sendMessage.setText("4. Введіть кількість номерів для проживання та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("кількість номерів",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 офісна будівля":
                sendMessage.setText("Обрано: адміністративні та офісні будівлі ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("офісна будівля",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 офісна будівля":
                sendMessage.setText("Обрано: будівлі Державних органів влади, виконавчих комітетів рад народних депутатів областей, міст, районів та відділів управління ");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getStateAuthorities());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 торгівельна будівля":
                sendMessage.setText("Обрано: торгівельні центри, криті ринки, магазини, ярмарки");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText("4. Оберіть місцерозташування будівлі: \n\n" +
                        "4.1 \uD83D\uDC49 Підземне та підвальне розміщеня\n" +
                        "4.2 \uD83D\uDC49 Надземне розміщення ");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeMallFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.1 торгівельний підземний":
                sendMessage.setText("Обрано: підземне та підвальне розміщення ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("торгівельний підземний",userId);
                sendMessage.setText("4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "4.2 торгівельний надземний":
                sendMessage.setText("Обрано: надземне розміщення ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("торгівельний надземний",userId);
                sendMessage.setText("4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.2 торгівельна будівля":
                sendMessage.setText("Обрано: торгівельні центри з продажу сільськогосподарських продуктів, промислових товарів  ");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getAgriculturalMall());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 будівля харчування":
                sendMessage.setText("Обрано: вбудовані в будівлі іншого призначення ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("вбудована харчування",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 будівля харчування":
                sendMessage.setText("Обрано: окремо стоячі будівлі громадського харчування");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("окрема харчування",userId);
                sendMessage.setText("4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.1 виставкова будівля":
                sendMessage.setText("Обрано: підземне розміщення ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("виставкова підземна",userId);
                sendMessage.setText("4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.2 виставкова будівля":
                sendMessage.setText("Обрано: надземне розміщення ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("виставкова надземна",userId);
                sendMessage.setText("4. Введіть кількість поверхів (1 / 2) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.1 освітня будівля":
                sendMessage.setText("Обрано: театр, кіноконцертна і концертна зала, цирк, кінотеатр, дозвіллєвий заклад");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getTheatre());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 освітня будівля":
                sendMessage.setText("Обрано: цирк");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getCircus());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 освітня будівля":
                sendMessage.setText("Обрано: кінотеатр, заклади дозвілля");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("кінотеатр",userId);
                sendMessage.setText("4. Введіть місткість зали для глядачів та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("глядацькі місця",userId);
                break;
            case "3.4 освітня будівля":
                sendMessage.setText("Обрано: казино, ігровий заклад");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("казино",userId);
                sendMessage.setText("4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.1 бібліотека":
                sendMessage.setText("Обрано: в будівлях органів влади, місцевого самоврядування та/або будівлях з умовною висотою більше 26,5 м");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("бібліотека органи влади",userId);
                sendMessage.setText("4. Введіть фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("фонд книг",userId);
                break;
            case "3.2 бібліотека":
                sendMessage.setText("Обрано: в інших будівлях ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("бібліотека інші будівлі",userId);
                sendMessage.setText("4. Введіть фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("фонд книг",userId);
                break;
            case "3.1 навчальні заклади":
                sendMessage.setText("Обрано: будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації ");
                messageSender.sendMessage(sendMessage);
                databaseRepository.setType_of_object_fire_alarm("інститути",userId);
                sendMessage.setText("4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "так інститути":
                databaseRepository.setArchives(true,userId);
                sendMessage.setText("Обрано: наявність приміщень для зберігання цінних документів та архівів");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "ні інститути":
                databaseRepository.setArchives(false,userId);
                sendMessage.setText("Обрано: відсутні приміщення для зберігання цінних документів та архівів");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 навчальні заклади":
                sendMessage.setText("Обрано: дошкільні навчальні заклади");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getPreschool());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 навчальні заклади":
                sendMessage.setText("Обрано: загальноосвітні навчальні заклади, навчально-виробничі комбінати, позашкільні заклади");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getSchool());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 навчальні заклади":
                sendMessage.setText("Обрано: спеціальні та санаторні школи, школи-інтернати");
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(fireAlarm.getSpecialSchool());
                messageSender.sendMessage(sendMessage);
                sendMessage.setText(instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            // TODO: 08.02.2023 ПРОТЕСТИТИ і залити на гіт
            case "Далі сигналізація":
                switch (databaseRepository.getType_of_object_fire_alarm(userId)){
                    case "житлова будівля":
                        sendMessage.setText(fireAlarm.getHousing());
                        messageSender.sendMessage(sendMessage);
                        sendMessage.setText(instructionExtinguisher.getStart());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "гуртожиток":
                        sendMessage.setText(fireAlarm.getDormitory());
                        messageSender.sendMessage(sendMessage);
                        sendMessage.setText(instructionExtinguisher.getStart());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "готель":
                        if (databaseRepository.getValue(userId).equals("кількість номерів") && (databaseRepository.getHotel_rooms(userId) == null)){
                            sendMessage.setText(fireAlarm.getRoomsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getValue(userId).equals("кількість номерів") && (databaseRepository.getHotel_rooms(userId) != null)){
                            sendMessage.setText(fireAlarm.getHotel());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText("5. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("висота обєкта",userId);
                        }else if (databaseRepository.getValue(userId).equals("висота обєкта") && (databaseRepository.getHeight_object(userId) == null)){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getValue(userId).equals("висота обєкта") && (databaseRepository.getHeight_object(userId) != null)){
                            sendMessage.setText(fireAlarm.getHotelHeigth());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "офісна будівля":
                        if (databaseRepository.getHeight_object(userId) == null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOffice());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "торгівельний підземний":
                        if (databaseRepository.getSquare(userId)==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getUndergroundMall());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "торгівельний надземний":
                        if (databaseRepository.getFloors(userId) == null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getSquare(userId) == null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getSquare(userId)==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getSquare(userId)!=null){
                            sendMessage.setText(fireAlarm.getGroundMall());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "вбудована харчування":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getBuiltInCatering());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "окрема харчування":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getSquare(userId)==null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getSquare(userId)==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getSquare(userId)!=null){
                            sendMessage.setText(fireAlarm.getSeparateCatering());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "виставкова підземна":
                        if (databaseRepository.getSquare(userId)==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getExhibitionUnderground());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "виставкова надземна":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getValue(userId).equals("поверхи")){
                            if (databaseRepository.getFloors(userId)>2){
                                sendMessage.setText("Данні введено не корректно. Виставкова або виставково-торгівельна будівля надземного розміщення може містити не більше ніж 2 поверхи.\n\n" +
                                        "Введіть кількість поверхів (1 / 2) та натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            }else {
                                if (databaseRepository.getFloors(userId)==1){
                                    sendMessage.setText("5. Введіть ступінь вогнестійкості будівлі (1,2,3,3a,3б,4,4a,5) та натисніть \"Далі\" \uD83D\uDC47");
                                }else {
                                    sendMessage.setText("5. Введіть ступінь вогнестійкості будівлі (1,2,3) та натисніть \"Далі\" \uD83D\uDC47");
                                }
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                                databaseRepository.setValue("вогнеснійкість будівлі",userId);
                            }
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)==null && databaseRepository.getValue(userId).equals("вогнеснійкість будівлі")){
                            sendMessage.setText(fireAlarm.getFireResistanceEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!= null && databaseRepository.getFire_resistance(userId)!=null && databaseRepository.getSquare(userId)==null){
                                sendMessage.setText("6. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                                databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getSquare(userId)==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)!=null && databaseRepository.getSquare(userId)!=null){
                            sendMessage.setText(fireAlarm.getExhibitionGround());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "кінотеатр":
                        if (databaseRepository.getSeats(userId)==null){
                            sendMessage.setText(fireAlarm.getSeatsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCinema());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "казино":
                        if (databaseRepository.getSquare(userId)==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCasino());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "бібліотека органи влади":
                        if (databaseRepository.getBooks_storage(userId)==null){
                            sendMessage.setText(fireAlarm.getBooksStorageEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getLibrary());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "бібліотека інші будівлі":
                        if (databaseRepository.getBooks_storage(userId)==null){
                            sendMessage.setText(fireAlarm.getBooksStorageEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getLibraryOtherBuildings());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "архів":
                        if (databaseRepository.getSquare(userId)==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getArchive());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "інститути":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getValue(userId).equals("висота обєкта")){
                            sendMessage.setText("5. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("поверхи",userId);
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getValue(userId).equals("поверхи")&& databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getFloors(userId)!=null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("6. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getFloors(userId)!=null && databaseRepository.getValue(userId).equals("площа")&&databaseRepository.getSquare(userId)==null){
                                sendMessage.setText(fireAlarm.getSquareEmpty());
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getFloors(userId)!=null && databaseRepository.getSquare(userId)!=null){
                            if (databaseRepository.getSquare(userId)<=300 && databaseRepository.getArchives(userId)==null){
                                sendMessage.setText("7. Наявні приміщення для зберігання цінних документів та архівів?");
                                sendMessage.setReplyMarkup(inlineButton.inlineInstitutesFireAlarmKeyboard());
                            }else {
                                sendMessage.setText(fireAlarm.getInstitutes());
                                messageSender.sendMessage(sendMessage);
                                sendMessage.setText(instructionExtinguisher.getStart());
                            }
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "охорона здоров'я":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getHealthCare());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "релігійні будівлі":
                        if (databaseRepository.getSquare(userId)==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getReligious());
                            messageSender.sendMessage(sendMessage);
                            sendMessage.setText(instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                }
                break;
        }
    }
    String result() { // виводить результат для вогнегасника
        String s6 = null;
        if (databaseRepository.getType_premises(userId).equals("Виробничі_складські")) {
            IndustrialPremises ip = new IndustrialPremises(userId,databaseRepository);
            if (databaseRepository.getType_extinguisher(userId).equals("порошковий")) {
                s6 = ip.quantityExtinguisherPoroshok();
            } else if (databaseRepository.getType_extinguisher(userId).equals("водопінний")) {
                s6 = ip.quantityExtinguisherVodopinni();
            } else if (databaseRepository.getType_extinguisher(userId).equals("водяний")) {
                s6 = ip.quantityExtinguisherVodiani();
            } else if (databaseRepository.getType_extinguisher(userId).equals("газовий")) {
                s6 = ip.quantityExtinguisherGazovyi();
            }
        } else if (databaseRepository.getType_premises(userId).equals("Громадські")) {
            PublicPremises pp = new PublicPremises(userId,databaseRepository);
            if (databaseRepository.getType_extinguisher(userId).equals("порошковий")) {
                s6 = pp.quantityExtinguisherPoroshok();
            }
            if (databaseRepository.getType_extinguisher(userId).equals("водопінний")) {
                s6 = pp.quantityExtinguisherVodopinni();
            }
            if (databaseRepository.getType_extinguisher(userId).equals("водяний")) {
                s6 = pp.quantityExtinguisherVodiani();
            }
        } else if (databaseRepository.getType_premises(userId).equals("Житлові")) {
            TypesLivingSpace lp = new TypesLivingSpace();
            s6 = lp.quantityExtinguisherLivingSpace();
        }else if (databaseRepository.getType_premises(userId).equals("Гаражі")) {
            Garages gg = new Garages(userId,databaseRepository);
            s6 = gg.quantityExtinguisherGarages();
        }else if (databaseRepository.getType_premises(userId).equals("Технічні приміщення")){
            PublicPremises pp = new PublicPremises(userId,databaseRepository);
            s6 = pp.quantityExtinguisherTekhPrym();
        }else if (databaseRepository.getType_premises(userId).equals("Кухні")){
            PublicPremises pp = new PublicPremises(userId,databaseRepository);
            s6 = pp.quantityExtinguisherVodianiKitchen();
        }
        return s6;
    }
    String resultDegreeRisk() { // виводить результат для ступеня ризику
        String s6 = null;
        DegreeRiskObject dro = new DegreeRiskObject(userId,databaseRepository);
        if (databaseRepository.getCharacteristics_object(userId).equals("експлуатується")) {
            s6 = dro.degreeRiskObjectExploited();
        }
        if (databaseRepository.getCharacteristics_object(userId).equals("проєктується")) {
            s6 = dro.degreeRiskObjectProjected();
        }
        return s6;
    }
}


