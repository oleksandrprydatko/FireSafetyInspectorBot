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
        String chatID = String.valueOf(message.getChatId());
        userId = Long.valueOf(chatID);

        //екземпляр класу з параметром
        CategoryBuilding categoryBuilding = new CategoryBuilding(userId,databaseRepository);
        FireAlarm fireAlarm = new FireAlarm(userId,databaseRepository);

        Float square = databaseRepository.getSquare(userId);


        //тип та необхідність вогнегасників
        switch (callbackQuery.getData()) {
            case "Розпочати":
                String comandOfMenu = databaseRepository.getComand_of_menu(userId);
                switch (comandOfMenu) {
                    case "/type_number_fire_extinguishers":
                        sendMessage.setText("1. Оберіть тип приміщення/об'єкту \uD83C\uDFD8");
                        sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherTypesKeyboard());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "/degree_of_risk_from_activities":
                        sendMessage.setText("1. Оберіть характеристику об’єкта \uD83C\uDFE0");
                        sendMessage.setReplyMarkup(inlineButton.inlineDegreeOfRiskTechnicalPremisesKeyboard());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "/determination_of_categories":
                        sendMessage.setText("1. Оберіть характеристику, яку необхідно визначити\uD83C\uDFD8");
                        sendMessage.setReplyMarkup(inlineButton.inlineDeterminationCharacteristicKeyboard());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "/zone_classes":
                        sendMessage.setText("1. Оберіть вид речовин, що обертаються у технологічному процесі \uD83C\uDFED\n\n" +
                                "1.1. Використовуються вибухонебезпечні речовини \uD83D\uDCA5\n" +
                                "1.2. Використовуються пожежонебезпечні речовини \uD83D\uDD25\n" +
                                "1.3. Відсутні вибухо- та пожежонебезпечні речовини ♻");
                        sendMessage.setReplyMarkup(inlineButton.inlineZoneClassesKeyboardMarkup());
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "/fire_alarm_installation":
                        sendMessage.setText("Оберіть характеристику, що необхідно визначити:\n\n" +
                                "\uD83D\uDC49 1. Обладнання будівель автоматичними системами протипожежного захисту\n" +
                                "\uD83D\uDC49 2. Обладнання приміщень автоматичними системами протипожежного захисту");
                        sendMessage.setReplyMarkup(inlineButton.inlineTypeOfProtectionFireAlarmKeyboard());
                        messageSender.sendMessage(sendMessage);
                        break;
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
                }else if (square!= null){
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
                        if (square!=null){
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

            // TODO: 08.02.2023 Протестити
                
            //проектування та монтаж пожежної сигналізації
            case "1 протипожежний захист":
                sendMessage.setText("Обрано: Обладнання будівель автоматичними системами протипожежного захисту\n\n" +
                        "1. Виберіть тип об'єкту \uD83C\uDFEB :");
                sendMessage.setReplyMarkup(inlineButton.inlineObjectTypeFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "об’єкт громадського призначення":
                sendMessage.setText("Обрано: об’єкт громадського призначення\n\n" +
                        "2. Виберіть призначення громадського об’єкту:\n\n" +
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
            case "2.1 громадський об'єкт":
                sendMessage.setText("Обрано: об’єкт житлового фонду\n\n" +
                        "3. Оберіть тип будівлі:\n\n " +
                        "\uD83D\uDC49 3.1 Житлова будівля \n" +
                        "\uD83D\uDC49 3.2 Багатоквартирний будинок для осіб похилого віку \n" +
                        "\uD83D\uDC49 3.3 Гуртожиток\n" +
                        "\uD83D\uDC49 3.4 Готель \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeResidentialBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 громадський об'єкт":
                sendMessage.setText("Обрано: адміністративно-офісна будівля\n\n" +
                        "3. Оберіть тип будівлі:\n\n " +
                        "\uD83D\uDC49 3.1 Адміністративні та офісні будівлі  \n" +
                        "\uD83D\uDC49 3.2 Будівлі Державних органів влади, виконавчих комітетів рад народних депутатів областей, міст, районів та відділів управління  \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeOfficeBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3 громадський об'єкт":
                sendMessage.setText("Обрано: банківська установа\n\n" + fireAlarm.getBank());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.4 громадський об'єкт":
                sendMessage.setText("Обрано: торгівельний та/або заклад\n\n" +
                        "3. Оберіть тип будівлі:\n\n" +
                        "\uD83D\uDC49 3.1 Торгівельні центри, криті ринки, магазини, ярмарки\n" +
                        "\uD83D\uDC49 3.2 Торгівельні центри з продажу сільськогосподарських продуктів, промислових товарів\n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeShoppingBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5 громадський об'єкт":
                sendMessage.setText("Обрано: будівля громадського харчування\n\n" +
                        "3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Вбудовані в будівлі іншого призначення \n" +
                        "\uD83D\uDC49 3.2 Окремо стоячі будівлі громадського харчування \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeCateringBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.6 громадський об'єкт":
                sendMessage.setText("Обрано: виставкова або виставково-торгівельна будівля\n\n" +
                        "3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Підземне розміщення \n" +
                        "\uD83D\uDC49 3.2 Надземне розміщення \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeExhibitionBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.7 громадський об'єкт":
                sendMessage.setText("Обрано: культурно-освітній або видовищний заклад\n\n" +
                        "3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Театр, кіноконцертна і концертна зала, цирк, кінотеатр, дозвіллєвий заклад \n" +
                        "\uD83D\uDC49 3.2 Цирк \n" +
                        "\uD83D\uDC49 3.3 Кінотеатр, заклади дозвілля \n" +
                        "\uD83D\uDC49 3.4 Казино, ігровий заклад");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeScienceBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.8 громадський об'єкт":
                sendMessage.setText("Обрано: музей\n\n" + fireAlarm.getMuseum() + "\n\n"+ instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.9 громадський об'єкт":
                sendMessage.setText("Обрано: бібліотека\n\n" +
                        "3. Вкажіть місце розташування об'єкту: \n\n" +
                        "\uD83D\uDC49 3.1 В будівлях органів влади, місцевого самоврядування та/або будівлях з умовною висотою більше 26,5 м \n" +
                        "\uD83D\uDC49 3.2 В інших будівлях \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeLibraryFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.10 громадський об'єкт":
                databaseRepository.setType_of_object_fire_alarm("архів",userId);
                sendMessage.setText("Обрано: архів\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.11 громадський об'єкт":
                sendMessage.setText("Обрано: будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації, навчальні заклади\n\n" +
                        "3. Оберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації \n" +
                        "\uD83D\uDC49 3.2 Дошкільні навчальні заклади\n" +
                        "\uD83D\uDC49 3.3 Загальноосвітні навчальні заклади, навчально-виробничі комбінати, позашкільні заклади\n" +
                        "\uD83D\uDC49 3.4 Спеціальні та санаторні школи, школи-інтернати");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeEducationBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.12 громадський об'єкт":
                databaseRepository.setType_of_object_fire_alarm("охорона здоров'я",userId);
                sendMessage.setText("Обрано: заклади охорони здоров’я\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "2.13 громадський об'єкт":
                sendMessage.setText("Обрано: будівлі спортивного та фізкультурно-оздоровчого призначення\n\n" + fireAlarm.getSport() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.14 громадський об'єкт":
                databaseRepository.setType_of_object_fire_alarm("релігійні будівлі",userId);
                sendMessage.setText("Обрано: культові та релігійні будівлі\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.1 житловий фонд":
                databaseRepository.setType_of_object_fire_alarm("житлова будівля",userId);
                sendMessage.setText("Обрано: житлова будівля\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 житловий фонд":
                sendMessage.setText("Обрано: багатоквартирний будинок для осіб похилого віку\n\n" + fireAlarm.getNursingHome() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 житловий фонд":
                databaseRepository.setType_of_object_fire_alarm("гуртожиток",userId);
                sendMessage.setText("Обрано: гуртожиток\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 житловий фонд":
                databaseRepository.setType_of_object_fire_alarm("готель",userId);
                sendMessage.setText("Обрано: готель\n\n" +
                        "4. Введіть кількість номерів для проживання та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("кількість номерів",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 офісна будівля":
                databaseRepository.setType_of_object_fire_alarm("офісна будівля",userId);
                sendMessage.setText("Обрано: адміністративні та офісні будівлі\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 офісна будівля":
                sendMessage.setText("Обрано: будівлі Державних органів влади, виконавчих комітетів рад народних депутатів областей, міст, районів та відділів управління\n\n" + fireAlarm.getStateAuthorities() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 торгівельна будівля":
                sendMessage.setText("Обрано: торгівельні центри, криті ринки, магазини, ярмарки\n\n" +
                        "4. Оберіть місцерозташування будівлі: \n\n" +
                        "4.1 \uD83D\uDC49 Підземне та підвальне розміщеня\n" +
                        "4.2 \uD83D\uDC49 Надземне розміщення ");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeMallFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.1 торгівельний підземний":
                databaseRepository.setType_of_object_fire_alarm("торгівельний підземний",userId);
                sendMessage.setText("Обрано: підземне та підвальне розміщення\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "4.2 торгівельний надземний":
                databaseRepository.setType_of_object_fire_alarm("торгівельний надземний",userId);
                sendMessage.setText("Обрано: надземне розміщення\n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.2 торгівельна будівля":
                sendMessage.setText("Обрано: торгівельні центри з продажу сільськогосподарських продуктів, промислових товарів\n\n" + fireAlarm.getAgriculturalMall() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 будівля харчування":
                databaseRepository.setType_of_object_fire_alarm("вбудована харчування",userId);
                sendMessage.setText("Обрано: вбудовані в будівлі іншого призначення\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("висота обєкта",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 будівля харчування":
                databaseRepository.setType_of_object_fire_alarm("окрема харчування",userId);
                sendMessage.setText("Обрано: окремо стоячі будівлі громадського харчування\n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.1 виставкова будівля":
                databaseRepository.setType_of_object_fire_alarm("виставкова підземна",userId);
                sendMessage.setText("Обрано: підземне розміщення\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.2 виставкова будівля":
                databaseRepository.setType_of_object_fire_alarm("виставкова надземна",userId);
                sendMessage.setText("Обрано: надземне розміщення\n\n" +
                        "4. Введіть кількість поверхів (1 / 2) та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.1 освітня будівля":
                sendMessage.setText("Обрано: театр, кіноконцертна і концертна зала, цирк, кінотеатр, дозвіллєвий заклад\n\n"+fireAlarm.getTheatre() + "\n\n" +instructionExtinguisher.getStart() );
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 освітня будівля":
                sendMessage.setText("Обрано: цирк\n\n"+fireAlarm.getCircus()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 освітня будівля":
                databaseRepository.setType_of_object_fire_alarm("кінотеатр",userId);
                sendMessage.setText("Обрано: кінотеатр, заклади дозвілля\n\n" +
                        "4. Введіть місткість зали для глядачів та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("глядацькі місця",userId);
                break;
            case "3.4 освітня будівля":
                databaseRepository.setType_of_object_fire_alarm("казино",userId);
                sendMessage.setText("Обрано: казино, ігровий заклад\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.1 бібліотека":
                databaseRepository.setType_of_object_fire_alarm("бібліотека органи влади",userId);
                sendMessage.setText("Обрано: в будівлях органів влади, місцевого самоврядування та/або будівлях з умовною висотою більше 26,5 м\n\n" +
                        "4. Введіть фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("фонд книг",userId);
                break;
            case "3.2 бібліотека":
                databaseRepository.setType_of_object_fire_alarm("бібліотека інші будівлі",userId);
                sendMessage.setText("Обрано: в інших будівлях\n\n" +
                        "4. Введіть фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("фонд книг",userId);
                break;
            case "3.1 навчальні заклади":
                databaseRepository.setType_of_object_fire_alarm("інститути",userId);
                sendMessage.setText("Обрано: будівлі дослідних інститутів, проектних і конструкторських організацій, інформаційні центри, установи органів управління, громадські організації\n\n" +
                        "4. Введіть умовну висоту будівлі(м.) та натисніть \"Далі\" \uD83D\uDC47 ");
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
                sendMessage.setText("Обрано: дошкільні навчальні заклади\n\n"+fireAlarm.getPreschool()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 навчальні заклади":
                sendMessage.setText("Обрано: загальноосвітні навчальні заклади, навчально-виробничі комбінати, позашкільні заклади\n\n"+fireAlarm.getSchool()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 навчальні заклади":
                sendMessage.setText("Обрано: спеціальні та санаторні школи, школи-інтернати\n\n"+fireAlarm.getSpecialSchool()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "об’єкт промислового призначення":
                sendMessage.setText("Обрано: об’єкт промислового призначення\n\n" +
                        "2. Виберіть призначення промислового об'єкту: \n\n" +
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
            case "2.1 промисловий об'єкт":
                sendMessage.setText("Обрано: будівля транспорту\n\n" +
                        "3. Виберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Вокзали всіх видів транспорту\n " +
                        "\uD83D\uDC49 3.2 Ангари технічного обслуговування, будівлі технічного обслуговування аварійно-рятувальних засобів\n" +
                        "\uD83D\uDC49 3.3 Зали керування рухом повітряного транспорту\n" +
                        "\uD83D\uDC49 3.4 Локомотивні ангари, вагонні депо, будівлі трамвайних та тролейбусних депо  ");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 транспорт":
                databaseRepository.setType_of_object_fire_alarm("вокзали",userId);
                sendMessage.setText("Обрано: вокзали всіх видів транспорту\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.2 транспорт":
                sendMessage.setText("Обрано: ангари технічного обслуговування, будівлі технічного обслуговування аварійно-рятувальних засобів\n\n"+fireAlarm.getHangar()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 транспорт":
                sendMessage.setText("Обрано: зали керування рухом повітряного транспорту\n\n"+fireAlarm.getAirTransport()+"\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 транспорт":
                databaseRepository.setType_of_object_fire_alarm("депо",userId);
                sendMessage.setText("Обрано: локомотивні ангари, вагонні депо, будівлі трамвайних та тролейбусних депо\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.2 промисловий об'єкт":
                sendMessage.setText("Обрано: будівля зберігання та обслуговування автомобільного транспорту\n\n" +
                        "3. Виберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Окремо розташовані підземні гаражі\n " +
                        "\uD83D\uDC49 3.2 Наземні гаражі\n" +
                        "\uD83D\uDC49 3.3 Механізовані гаражі, криті автостоянки на території аеропортів та стоянки під аеровокзалами \n" +
                        "\uD83D\uDC49 3.4 Будівлі автозаправних станцій\n" +
                        "\uD83D\uDC49 3.5 Автосалони, станції технічного обслуговування \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeRepairTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 обслуговувавння транспорту":
                databaseRepository.setType_of_object_fire_alarm("підземні гаражі",userId);
                sendMessage.setText("Обрано: окремо розташовані підземні гаражі\n\n" +
                        "4. Введіть кількість одиниць автотранспорту та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("кількість транспорту",userId);
                break;
            case "3.2 обслуговувавння транспорту":
                databaseRepository.setType_of_object_fire_alarm("наземні гаражі",userId);
                sendMessage.setText("Обрано: наземні гаражі\n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47 ");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("поверхи",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 обслуговувавння транспорту":
                sendMessage.setText("Обрано: механізовані гаражі, криті автостоянки на території аеропортів та стоянки під аеровокзалами \n\n" + fireAlarm.getMechanizedGarages() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 обслуговувавння транспорту":
                sendMessage.setText("Обрано: будівлі автозаправних станцій \n\n" + fireAlarm.getGasStation() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.5 обслуговувавння транспорту":
                databaseRepository.setType_of_object_fire_alarm("автосалони",userId);
                sendMessage.setText("Обрано: локомотивні ангари, вагонні депо, будівлі трамвайних та тролейбусних депо \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.3 промисловий об'єкт":
                databaseRepository.setType_of_object_fire_alarm("виробнича будівля",userId);
                sendMessage.setText("Обрано: виробнича будівля \n\n" +
                        "3. Оберіть категорію будинку: ");
                sendMessage.setReplyMarkup(inlineButton.inlineCategoryBuildingFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія А виробнича":
                sendMessage.setText("Обрано: категорія А \n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47" );
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setCategory_buildings("A",userId);
                databaseRepository.setValue("поверхи",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія Б виробнича":
                sendMessage.setText("Обрано: категорія Б \n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47" );
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setCategory_buildings("Б",userId);
                databaseRepository.setValue("поверхи",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія В виробнича":
                sendMessage.setText("Обрано: категорія В \n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47" );
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setCategory_buildings("В",userId);
                databaseRepository.setValue("поверхи",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "2.4 промисловий об'єкт":
                sendMessage.setText("Обрано: складська будівля\n\n" +
                        "3. Виберіть тип складської будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 складська будівлі категорії «А» та «Б»\n" +
                        "\uD83D\uDC49 3.2 складська будівлі категорії «В»\n" +
                        "\uD83D\uDC49 3.3 складська будівлі категорії «В» зі стелажним зберігання висотою 5,5 м та більше\n" +
                        "\uD83D\uDC49 3.4 склади гуми, каучуку та виробів із них\n" +
                        "\uD83D\uDC49 3.5 склади для зберігання негорючих матеріалів в горючій упаковці\n" +
                        "\uD83D\uDC49 3.6 склади для зберігання аміачної селітри та горючих пестицидів\n" +
                        "\uD83D\uDC49 3.7 склади для зберігання фото-, кіно- та аудіоплівки\n" +
                        "\uD83D\uDC49 3.8 склади для зберігання запасу двигунів та агрегатів із паливом та мастилом\n");
                sendMessage.setReplyMarkup(inlineButton.inlineStorageFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 склад":
                databaseRepository.setType_of_object_fire_alarm("склад категорії А та Б",userId);
                sendMessage.setText("Обрано: складська будівля категорії «А» та «Б»\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 склад":
                databaseRepository.setType_of_object_fire_alarm("склад категорії В",userId);
                sendMessage.setText("Обрано: складська будівлі категорії «В»\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 склад":
                databaseRepository.setType_of_object_fire_alarm("склад категорії В стелажний",userId);
                sendMessage.setText("Обрано: складська будівлі категорії «В» зі стелажним зберігання висотою 5,5 м та більше\n\n" +
                         fireAlarm.getStorageRack() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 склад":
                databaseRepository.setType_of_object_fire_alarm("склади гуми",userId);
                sendMessage.setText("Обрано: склади гуми, каучуку та виробів із них\n\n" +
                        "4. Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("поверхи",userId);
                break;
            case "3.5 склад":
                databaseRepository.setType_of_object_fire_alarm("склади негорючих матеріалів",userId);
                sendMessage.setText("Обрано: cклади для зберігання негорючих матеріалів в горючій упаковці\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.6 склад":
                databaseRepository.setType_of_object_fire_alarm("склади селітри",userId);
                sendMessage.setText("Обрано: склади для зберігання аміачної селітри та горючих пестицидів\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.7 склад":
                databaseRepository.setType_of_object_fire_alarm("склади плівки",userId);
                sendMessage.setText("Обрано: склади для зберігання фото-, кіно- та аудіоплівки\n\n" +
                        "3. Ведіть загальну вагу плівки (кг.) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("вага",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.8 склад":
                databaseRepository.setType_of_object_fire_alarm("склади двигунів",userId);
                sendMessage.setText("Обрано: склади для зберігання запасу двигунів та агрегатів із паливом та мастилом\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5 промисловий об'єкт":
                sendMessage.setText("Обрано: споруди резервуарів для зберігання спирту, наземних резервуарів для зберігання нафти та нафтопродуктів \n\n" +
                        "3. Оберіть тип споруди: \n" +
                        "\uD83D\uDC49 3.1 Резервуарні парки спирту\n" +
                        "\uD83D\uDC49 3.2 Наземні резервуари зберігання нафти і нафтопродуктів\n" +
                        "\uD83D\uDC49 3.3 Приміщення зберігання нафтопродуктів з температурою спалаху нижче 120 С у тарі\n" +
                        "\uD83D\uDC49 3.4 Приміщення зберігання нафтопродуктів з температурою спалаху вище 120 С у тарі\n" +
                        "\uD83D\uDC49 3.5 Закриті склади легкозаймистих і горючих рідин, приміщення з установками регенерації");
                sendMessage.setReplyMarkup(inlineButton.inlineStorageTankFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 резервуари":
                databaseRepository.setType_of_object_fire_alarm("резервуари спирту",userId);
                sendMessage.setText("Обрано: резервуарні парки спирту\n\n" +
                        "4. Введіть загальний об'єм (м.куб) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("обєм будівлі",userId);
                break;
            case "3.2 резервуари":
                databaseRepository.setType_of_object_fire_alarm("резервуари нафти",userId);
                sendMessage.setText("Обрано: наземні резервуари зберігання нафти і нафтопродуктів\n\n" +
                        "4. Введіть загальний об'єм (м.куб) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("обєм будівлі",userId);
                break;
            case "3.3 резервуари":
                databaseRepository.setType_of_object_fire_alarm("приміщення нафти нижче 120",userId);
                sendMessage.setText("Обрано: приміщення зберігання нафтопродуктів з температурою спалаху нижче 120 С у тарі\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.4 резервуари":
                databaseRepository.setType_of_object_fire_alarm("приміщення нафти вижче 120",userId);
                sendMessage.setText("Обрано: приміщення зберігання нафтопродуктів з температурою спалаху нижче 120 С у тарі\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.5 резервуари":
                databaseRepository.setType_of_object_fire_alarm("закриті склади",userId);
                sendMessage.setText("Обрано: закриті склади легкозаймистих і горючих рідин, приміщення з установками регенерації\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.6 промисловий об'єкт":
                sendMessage.setText("Обрано: будівля  сільськогосподарського призначення \n\n" +
                        "3. Виберіть тип будівлі: \n" +
                        "\uD83D\uDC49 3.1 Склади зберігання хлібопродуктів \n" +
                        "\uD83D\uDC49 3.2 Склади тарного і безтарного зберігання борошна\n" +
                        "\uD83D\uDC49 3.3 Склади вітамінів, антибіотиків, ферментів, отрутохімікатів, мінеральних добрив \n" +
                        "\uD83D\uDC49 3.4 Матеріальні склади, будинки сільськогосподарського призначення категорії «В»\n" +
                        "\uD83D\uDC49 3.5 Будинки птахофабрик\n" +
                        "\uD83D\uDC49 3.6 Корівники, конюшні, свинарники, вівчарні, кінні заводи\n" +
                        "\uD83D\uDC49 3.7 Склади пестицидів із температурою спалаху нижче 120 С");
                sendMessage.setReplyMarkup(inlineButton.inlineAgricultureFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 сг":
                sendMessage.setText("Обрано: склади зберігання хлібопродуктів\n\n" +
                        "Вкажіть наявність приміщень площею 200м.кв і більше");
                sendMessage.setReplyMarkup(inlineButton.inlineBreadProductsStorageFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "наявні хлібопродукти":
                databaseRepository.setType_of_object_fire_alarm("наявні приміщення",userId);
                sendMessage.setText(fireAlarm.getBreadProductsStorage() + "\n\n" + instructionExtinguisher.getStart());
                break;
            case "відсутні хлібопродукти":
                databaseRepository.setType_of_object_fire_alarm("відсутні приміщення",userId);
                sendMessage.setText(fireAlarm.getBreadProductsStorage() + "\n\n" + instructionExtinguisher.getStart());
                break;
            case "3.2 сг":
                databaseRepository.setType_of_object_fire_alarm("склади борошна",userId);
                sendMessage.setText("Обрано: склади тарного і безтарного зберігання борошна\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.3 сг":
                databaseRepository.setType_of_object_fire_alarm("склади вітамінів",userId);
                sendMessage.setText("Обрано: склади вітамінів, антибіотиків, ферментів, отрутохімікатів, мінеральних добрив\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.4 сг":
                databaseRepository.setType_of_object_fire_alarm("матеріальні склади",userId);
                sendMessage.setText("Обрано: матеріальні склади, будинки сільськогосподарського призначення категорії «В»\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.5 сг":
                databaseRepository.setType_of_object_fire_alarm("птахоферма",userId);
                sendMessage.setText("Обрано: будинки птахофабрик\n\n" + fireAlarm.getPoultryFarm() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.6 сг":
                databaseRepository.setType_of_object_fire_alarm("корівники",userId);
                sendMessage.setText("Обрано: корівники, конюшні, свинарники, вівчарні, кінні заводи \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.7 сг":
                databaseRepository.setType_of_object_fire_alarm("склади пестицидів",userId);
                sendMessage.setText("Обрано: склади пестицидів із температурою спалаху нижче 120 С\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.7 промисловий об'єкт":
                sendMessage.setText("Обрано: транспортний тунель\n\n" +
                        "3. Виберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Транспортні тунелі залізничного транспорту \n" +
                        "\uD83D\uDC49 3.2 Транспортні тунелі автомобільного транспорту ");
                sendMessage.setReplyMarkup(inlineButton.inlineTunnelFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 тунелі":
                sendMessage.setText(fireAlarm.getRailwayTunnel() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 тунелі":
                databaseRepository.setType_of_object_fire_alarm("автомобільні тунелі",userId);
                sendMessage.setText("Обрано: транспортні тунелі автомобільного транспорту \n\n" +
                        "4. Введіть довжину тунелю (м.ф) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("довжина",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "2.8 промисловий об'єкт":
                sendMessage.setText("Обрано: допоміжна будівля трубопроводів\n\n" +
                        "3. Виберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 3.1 Будівлі перекачувальних агрегатів, насосні станції, споруди зв’язку та управління магістральними нафтопроводами і газопроводами \n" +
                        "\uD83D\uDC49 3.2 Насосні та фільтраційні станції магістральних водопроводів ");
                sendMessage.setReplyMarkup(inlineButton.inlinePipelinesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 трубопроводи":
                sendMessage.setText("Обрано: будівлі перекачувальних агрегатів, насосні станції, споруди зв’язку та управління магістральними нафтопроводами і газопроводами\n\n" + fireAlarm.getPumpingStation() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 трубопроводи":
                sendMessage.setText("Обрано: насосні та фільтраційні станції магістральних водопроводів\n\n" + fireAlarm.getFiltrationStation() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.9 промисловий об'єкт":
                sendMessage.setText(fireAlarm.getOilRefiningEnterprisesStorage() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.10 промисловий об'єкт":
                sendMessage.setText("Обрано: склад полімерних (високомолекулярннних) сполук \n\n" +
                        "3. Вкажіть групу горючості сполук:");
                sendMessage.setReplyMarkup(inlineButton.inlineFlammabilityGroupFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Г1":
            case "Г2":
                databaseRepository.setType_of_object_fire_alarm("Г1 або Г2",userId);
                sendMessage.setText("3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "Г3":
            case "Г4":
                databaseRepository.setType_of_object_fire_alarm("Г3 або Г4",userId);
                sendMessage.setText("3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2 протипожежний захист":
                sendMessage.setText("Обрано: Обладнання приміщень автоматичними системами протипожежного захисту\n\n" +
                        "1. Виберіть призначення споруд, приміщень або технологічного обладнання об’єкту:\n\n" +
                        "\uD83D\uDC49 1.1 споруди, приміщення та технологічне обладнання об’єктів енергозабезпечення\n" +
                        "\uD83D\uDC49 1.2 приміщення у будівлях вокзалів і спорудах транспорту\n" +
                        "\uD83D\uDC49 1.3 приміщення сільськогосподарського призначення\n" +
                        "\uD83D\uDC49 1.4 приміщення телекомунікаційних об’єктів\n" +
                        "\uD83D\uDC49 1.5 приміщення в спорудах і будівлях авіаційного транспорту \n" +
                        "\uD83D\uDC49 1.6 приміщення обробки, сортування, зберігання, доставки посилок, кореспонденції, видань та страхової пошти у будинках Укрпошти \n" +
                        "\uD83D\uDC49 1.7 виробничі приміщення\n" +
                        "\uD83D\uDC49 1.8 приміщення у виробничих спорудах і будівлях авіаційного транспорту\n" +
                        "\uD83D\uDC49 1.9 складські приміщення\n" +
                        "\uD83D\uDC49 1.10 приміщення на об’єктах із виробництва солоду, пива та безалкогольних напоїв\n" +
                        "\uD83D\uDC49 1.11 приміщення для автомобільного транспорту\n" +
                        "\uD83D\uDC49 1.12 приміщення в спорудах і будівлях метрополітену\n" +
                        "\uD83D\uDC49 1.13 приміщення в будинках виробничого та громадського призначення\n");
                sendMessage.setReplyMarkup(inlineButton.inlineFireProtectionPremissesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.1 АСПЗ приміщення":
                sendMessage.setText("Обрано: споруди, приміщення та технологічне обладнання об’єктів енергозабезпечення\n\n" +
                        "2. Виберіть тип будівлі: \n\n" +
                        "\uD83D\uDC49 2.1 Внутрішньоцехові, міжцехові кабельні підвали, напівпідвали, тунелі, поверхи, на півповерхи, шахти, галереї, приміщення вводу кабелів, електрощитові \n" +
                        "\uD83D\uDC49 2.2 Кабельні споруди \n" +
                        "\uD83D\uDC49 2.3 Закриті розподільні пристрої і приміщення трансформаторів І і ІІ груп \n" +
                        "\uD83D\uDC49 2.4 Машинні зали електростанцій\n" +
                        "\uD83D\uDC49 2.5 Вбудовані, прибудовані і дахові котельні на рідкому, твердому і комбінованому паливі \n" +
                        "\uD83D\uDC49 2.6 Вбудовані, прибудовані і дахові котельні на газоподібному паливі \n" +
                        "\uD83D\uDC49 2.7 Електрогенераторні з двигунами внутрішнього згорання \n" +
                        "\uD83D\uDC49 2.8 Приміщення вводу кабелів, кабельні шахти, кабельні підвали, тунелі, поверхи всередині та ззовні будівель\n" +
                        "\uD83D\uDC49 2.9 Приміщення з розміщеними трансформаторами, реакторів напруги від 500кВ, маслонаповнених трансформаторів напругою від 220кВ до 330 кВ \n" +
                        "\uD83D\uDC49 2.10 Приміщення трансформаторів напругою вище 110 кВ в закритих підстанціях, закритих підстанціях глибокого введення, закритих розподільчих установках електростанцій і підстанцій з розміщеними трансформаторами\n" +
                        "\uD83D\uDC49 2.11 Закриті склади легкозаймистих і горючих рідин категорій «А», «Б», «В», приміщення регенерації масел \n" +
                        "\uD83D\uDC49 2.12 Приміщення мазутних і масляних насосів, насосів дизельного пального, маслоапаратних, лабораторії, ремонтні майстерні, закриті склади і комори призначені для зберігання та ремонту горючого обладнання та матеріалів \n" +
                        "\uD83D\uDC49 2.13 Закриті трансформаторні майстерні, приміщення електрощитових та кабельні розподільчі установки\n" +
                        "\uD83D\uDC49 2.14 Приміщення подачі палива, закриті склади твердого палива");
                sendMessage.setReplyMarkup(inlineButton.inlineEnergySupplyFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.1 енергозабезпечення":
                sendMessage.setText("Обрано: внутрішньоцехові, міжцехові кабельні підвали, напівпідвали, тунелі, поверхи, на півповерхи, шахти, галереї, приміщення вводу кабелів, електрощитові \n\n"+fireAlarm.getBasements() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.2 енергозабезпечення":
                sendMessage.setText("Обрано: кабельні споруди\n\n" +
                        "3. Виберіть тип споруди: \n" +
                        "\uD83D\uDC49 3.1 Кабельні споруди очисних споруд гідроелектростанцій потужністю від 20 МВт до 100 МВт, підстанцій напругою від 220 кВ до 500 кВ, районних котелень, міських електричних мереж об’ємом більше 50 м3 \n" +
                        "\uD83D\uDC49 3.2 Кабельні споруди внутрішньоцехових комбінованих тунелів\n" +
                        "\uD83D\uDC49 3.3 Кабельні споруди теплових електростанцій незалежно від потужності і гідроелектростанцій потужністю від 100МВт, підстанції від 500кВ, закриті підстанції потужністю від 110 кВ і вище, котельні площадок електростанцій ");
                sendMessage.setReplyMarkup(inlineButton.inlineCablesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 кабельні":
                sendMessage.setText("Обрано: кабельні споруди очисних споруд гідроелектростанцій потужністю від 20 МВт до 100 МВт, підстанцій напругою від 220 кВ до 500 кВ, районних котелень, міських електричних мереж об’ємом більше 50 м3 \n\n" + fireAlarm.getTreatmentPlant() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 кабельні":
                databaseRepository.setType_of_object_fire_alarm("кабельні внутрішньоцехові",userId);
                sendMessage.setText("Обрано: кабельні споруди внутрішньоцехових комбінованих тунелів\n\n" +
                        "3. Введіть об'єм приміщень (м.куб) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("обєм будівлі",userId);
                break;
            case "3.3 кабельні":
                sendMessage.setText("Обрано: кабельні споруди теплових електростанцій незалежно від потужності і гідроелектростанцій потужністю від 100МВт, підстанції від 500кВ, закриті підстанції потужністю від 110 кВ і вище, котельні площадок електростанцій "+fireAlarm.getCableThermalPowerStation() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.3 енергозабезпечення":
                sendMessage.setText("Обрано: закриті розподільні пристрої і приміщення трансформаторів І і ІІ груп\n\n" +
                        "3. Вкажіть наявність маслонаповненого обладнання:");
                sendMessage.setReplyMarkup(inlineButton.inlineOilFilledEquipmentFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "наявне обладнання":
                databaseRepository.setType_of_object_fire_alarm("наявне",userId);
                sendMessage.setText("Обрано: наявне маслонаповнене обладнання\n\n" + fireAlarm.getOilFilledEquipments() + "\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "відсутнє обладнання":
                databaseRepository.setType_of_object_fire_alarm("відсутнє",userId);
                sendMessage.setText("Обрано: відсутнє маслонаповнене обладнання\n\n" + fireAlarm.getOilFilledEquipments() + "\n\n"+instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.4 енергозабезпечення":
                sendMessage.setText("Обрано: машинні зали електростанцій \n\n"+fireAlarm.getEngineRooms() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.5 енергозабезпечення":
                sendMessage.setText("Обрано: вбудовані, прибудовані і дахові котельні на рідкому, твердому і комбінованому паливі \n\n" + fireAlarm.getBoilerRooms() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.6 енергозабезпечення":
                sendMessage.setText("Обрано: вбудовані, прибудовані і дахові котельні на газоподібному паливі\n\n" + fireAlarm.getBoilerGasRooms() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.7 енергозабезпечення":
                sendMessage.setText("Обрано: електрогенераторні з двигунами внутрішнього згорання\n\n" + fireAlarm.getPowerGenerator() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.8 енергозабезпечення":
                sendMessage.setText("Обрано: приміщення вводу кабелів, кабельні шахти, кабельні підвали, тунелі, поверхи всередині та ззовні будівель\n\n" +
                        "3. Вкажіть пожежне навантаження:");
                sendMessage.setReplyMarkup(inlineButton.inlineFireLoadFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "менше 180 МДж/м2":
                databaseRepository.setType_of_object_fire_alarm("менше 180 МДж/м2",userId);
                sendMessage.setText("Обрано: пожежне навантаження менше 180 МДж/м2\n\n" + fireAlarm.getFireLoad() + "\n\n" + instructionExtinguisher.getStart());
                break;
            case "більше 180 МДж/м2":
                databaseRepository.setType_of_object_fire_alarm("більше 180 МДж/м2",userId);
                sendMessage.setText("Обрано: пожежне навантаження більше 180 МДж/м2\n\n" + fireAlarm.getFireLoad() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.9 енергозабезпечення":
                sendMessage.setText("Обрано: приміщення з розміщеними трансформаторами, реакторів напруги від 500кВ, маслонаповнених трансформаторів напругою від 220кВ до 330 кВ\n\n" + fireAlarm.getTransformer() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.10 енергозабезпечення":
                sendMessage.setText("Обрано: приміщення трансформаторів напругою вище 110 кВ в закритих підстанціях, закритих підстанціях глибокого введення, закритих розподільчих установках електростанцій і підстанцій з розміщеними трансформаторами\n\n" + fireAlarm.getTransformerClosedSubstation() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.11 енергозабезпечення":
                databaseRepository.setType_of_object_fire_alarm("склади легкозаймистих рідин",userId);
                sendMessage.setText("Обрано: закриті склади легкозаймистих і горючих рідин категорій «А», «Б», «В», приміщення регенерації масел \n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.12 енергозабезпечення":
                sendMessage.setText("Обрано: приміщення мазутних і масляних насосів, насосів дизельного пального, маслоапаратних, лабораторії, ремонтні майстерні, закриті склади і комори призначені для зберігання та ремонту горючого обладнання та матеріалів \n\n" + fireAlarm.getPumpRooms() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.13 енергозабезпечення":
                sendMessage.setText("Обрано: закриті трансформаторні майстерні, приміщення електрощитових та кабельні розподільчі установки\n\n" + fireAlarm.getTransformerWorkshops() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.14 енергозабезпечення":
                sendMessage.setText("Обрано: приміщення подачі палива, закриті склади твердого палива \n\n" + fireAlarm.getSolidFuelWarehouses() + "\n\n" + instructionExtinguisher.getStart() );
                messageSender.sendMessage(sendMessage);
                break;
            case "1.2 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення у будівлях вокзалів і спорудах транспорту\n\n" +
                        "2. Виберіть тип приміщення: \n" +
                        "\uD83D\uDC49 2.1 приміщення прийому, транспортування та видачі багажу\n" +
                        "\uD83D\uDC49 2.2 камери схову багажу \n" +
                        "\uD83D\uDC49 2.3 автоматичні камери схов багажу\n");
                sendMessage.setReplyMarkup(inlineButton.inlineStationFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 вокзал":
                sendMessage.setText("Обрано: приміщення прийому, транспортування та видачі багажу\n\n" + fireAlarm.getStationPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 вокзал":
                sendMessage.setText("Обрано: камери схову багажу \n\n" +
                        "2. Вкажіть розташування камер схову багажу:");
                sendMessage.setReplyMarkup(inlineButton.inlineLuggageStationFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "надземний поверх камера схову":
                databaseRepository.setType_of_object_fire_alarm("надземний поверх камера схову",userId);
                sendMessage.setText("Обрано: надземний поверх \n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "підземний поверх камера схову":
                databaseRepository.setType_of_object_fire_alarm("підземний поверх камера схову",userId);
                sendMessage.setText("Обрано: підземний поверх \n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.3 вокзал":
                sendMessage.setText("Обрано: автоматичні камери схов багажу\n\n" +
                        "2. Вкажіть місце розташування автоматичних камер схову:");
                sendMessage.setReplyMarkup(inlineButton.inlineAutoLuggageStationFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "надземний поверх автоматична камера":
                databaseRepository.setType_of_object_fire_alarm("надземний поверх автоматична камера",userId);
                sendMessage.setText("Обрано: надземний поверх\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "підземний поверх автоматична камера":
                databaseRepository.setType_of_object_fire_alarm("підземний поверх автоматична камера",userId);
                sendMessage.setText("Обрано: підземний поверх\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "1.3 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення сільськогосподарського призначення\n\n" +
                        "2. Виберіть тип приміщення: \n" +
                        "\uD83D\uDC49 2.1 Приміщення очищення зерна, сушіння і оброблення солоду і зерна\n" +
                        "\uD83D\uDC49 2.2 Приміщення оброблення, сушіння і очищення зерна в кукурудзяно-крохмально-патоковому виробництві, розмельно-сортувальні відділення вівсяних продуктів\n" +
                        "\uD83D\uDC49 2.3 Приміщення кормоцехів, цехів комбікорму, концентрованих кормів, трав’яного борошна, сухого крохмалю, білково-вітамінних добавок, гранулювання готової продукції, оброблення насіння зерна, зерноочисні, насіннєочисні, сушильні\n" +
                        "\uD83D\uDC49 2.4 Приміщення розмельні, лущильні та очищення борошняної сировини, вибійні і фасувальні відділення борошна, круп, комбікормів, приготування емульсії, компоновки отрутохімікатів для протравлювання зернових, відділення розсипних і гранульованих комбікормів, білково-вітамінних добавок, очищення борошнистого зерна, млинозаводи і крупозаводи, вибійні відділення та приміщення фасування борошна, крупи і комбікормів, приміщення обробки насіння кукурудзи, матеріальні склади\n" +
                        "\uD83D\uDC49 2.5 Транспортні галереї зерна та комбікормів, приміщення протравлювання зерна емульсією, складів вітамінів, антибіотиків, ферментопрепаратів і отрутохімікатів");
                sendMessage.setReplyMarkup(inlineButton.inlineAgriculturePremissesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 сг":
                databaseRepository.setType_of_object_fire_alarm("очищення зерна",userId);
                sendMessage.setText("Обрано: приміщення очищення зерна, сушіння і оброблення солоду і зерна\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.2 сг":
                sendMessage.setText("Обрано: приміщення оброблення, сушіння і очищення зерна в кукурудзяно-крохмально-патоковому виробництві, розмельно-сортувальні відділення вівсяних продуктів \n\n" + fireAlarm.getCornCleaning() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3 сг":
                databaseRepository.setType_of_object_fire_alarm("приміщення кормоцехів",userId);
                sendMessage.setText("Обрано: приміщення кормоцехів, цехів комбікорму, концентрованих кормів, трав’яного борошна, сухого крохмалю, білково-вітамінних добавок, гранулювання готової продукції, оброблення насіння зерна, зерноочисні, насіннєочисні, сушильні\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "2.4 сг":
                sendMessage.setText("Обрано: приміщення розмельні, лущильні та очищення борошняної сировини, вибійні і фасувальні відділення борошна, круп, комбікормів, приготування емульсії, компоновки отрутохімікатів для протравлювання зернових, відділення розсипних і гранульованих комбікормів, білково-вітамінних добавок, очищення борошнистого зерна, млинозаводи і крупозаводи, вибійні відділення та приміщення фасування борошна, крупи і комбікормів, приміщення обробки насіння кукурудзи, матеріальні склади \n\n" + fireAlarm.getMills() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.5 сг":
                databaseRepository.setType_of_object_fire_alarm("транспортні галереї",userId);
                sendMessage.setText("Обрано: транспортні галереї зерна та комбікормів, приміщення протравлювання зерна емульсією, складів вітамінів, антибіотиків, ферментопрепаратів і отрутохімікатів\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "1.4 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення телекомунікаційних об’єктів\n\n" +
                        "2. Виберіть тип приміщення: \n" +
                        "\uD83D\uDC49 2.1 приміщення апаратних вузлів, комутаторних, центрів електронного зв’язку, автоматичних телефонних станцій, технологічні приміщення об’єктів електрозв’язку та пунктів цифрових систем передачі даних площею до 24 м2 \n" +
                        "\uD83D\uDC49 2.2 приміщення апаратних радіорелейних споруд, радіотрансляторних та регенераційних вузлів, приміщення введення кабелів електрозв’язку\n" +
                        "\uD83D\uDC49 2.3 приміщення базових станцій мобільного зв’язку");
                sendMessage.setReplyMarkup(inlineButton.inlineTelecommunicationsFacilitiesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.1 телекомунікаційні":
                sendMessage.setText("Обрано: приміщення апаратних вузлів, комутаторних, центрів електронного зв’язку, автоматичних телефонних станцій, технологічні приміщення об’єктів електрозв’язку та пунктів цифрових систем передачі даних площею до 24 м2\n\n" +
                        "3. Вкажіть потужність електрообладнання:");
                sendMessage.setReplyMarkup(inlineButton.inlinePowerTelecommunicationsFacilitiesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "до 12 кВт  телекомунікаційні":
                databaseRepository.setType_of_object_fire_alarm("до 12 кВт",userId);
                sendMessage.setText("Обрано: до 12 кВт\n\n" + fireAlarm.getPowerTransportGalleries() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "більше 12 кВт телекомунікаційні":
                databaseRepository.setType_of_object_fire_alarm("більше 12 кВт",userId);
                sendMessage.setText("Обрано: більше 12 кВт\n\n" + fireAlarm.getPowerTransportGalleries() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.2 телекомунікаційні":
                sendMessage.setText("Обрано: приміщення апаратних радіорелейних споруд, радіотрансляторних та регенераційних вузлів, приміщення введення кабелів електрозв’язку\n\n" + fireAlarm.getPremisesOfRegenerationUnits() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "2.3 телекомунікаційні":
                sendMessage.setText("Обрано: приміщення базових станцій мобільного зв’язку\n\n" +
                        "3. Вкажіть місце розташування базової станції:");
                sendMessage.setReplyMarkup(inlineButton.inlineMobileCommunicationFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "у діючих будинках зв’язку":
            case "у будинках іншого призначення":
            case "окремо розташованих спорудах":
                databaseRepository.setType_of_object_fire_alarm(callbackQuery.getData(),userId);
                sendMessage.setText("Обрано: " + callbackQuery.getData() + "\n\n" + fireAlarm.getMobileCommunication() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.5 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення в спорудах і будівлях авіаційного транспорту\n\n" + fireAlarm.getAitTransportPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.6 АСПЗ приміщення":
                databaseRepository.setType_of_object_fire_alarm("укрпошта",userId);
                sendMessage.setText("Обрано: приміщення обробки, сортування, зберігання, доставки посилок, кореспонденції, видань та страхової пошти у будинках Укрпошти\n\n" +
                        "3. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "1.7 АСПЗ приміщення":
                sendMessage.setText("Обрано: виробничі приміщення\n\n" +
                        "3. Виберіть тип приміщення:\n\n" +
                        "\uD83D\uDC49 3.1 Приміщення за категорією вибухопожежної небезпеки\n" +
                        "\uD83D\uDC49 3.2 Регулювальні, контрольно-вимірювальні ділянки, лабораторії, майстерні, електроремонтні майстерні двигунів, ділянки консервування виробів в установках періодичної дії з використанням горючих рідин,промивання виробів, приміщення деревообробки та столярні майстерні\n" +
                        "\uD83D\uDC49 3.3 Приміщення агрегатних у цокольних, підвальних та напівпідвальних поверхах з наявністю видаткових баків мастила більше 500 л \n" +
                        "\uD83D\uDC49 3.4 Ділянки полірування та шліфування виробів з деревини\n" +
                        "\uD83D\uDC49 3.5 Приміщення витратних комор лакофарбових матеріалів, горючих миючих засобів, мастил, горючих рідин\n" +
                        "\uD83D\uDC49 3.6 Приміщення виробництва деталей із горючих матеріалів, гумотехнічні майстерні\n" +
                        "\uD83D\uDC49 3.7 Приміщення випробувань із використанням легкозаймистих і горючих рідин, екрановані кімнати, приміщення із застосуванням лужних та лужноземельних металів, небезпечних металів, їх зварювання, приміщення приготування клею, наповнення балонів горючими газами, насосні компресорні станції, фарбування занурюванням, струменевим поливанням, фарбоприготувальні приміщення, камери сушіння пофарбованих виробів, масляних охолоджувачів\n" +
                        "\uD83D\uDC49 3.8 Цехові експрес-лабораторії аналізів, приміщення ремонту і перевірки кисневого обладнання, перевірки, ремонту та випробувань паливних приладів, промивки хлорованими вуглеводами, приміщення мазутних, дизельних насосів, циклони забору горючих відходів\n" +
                        "\uD83D\uDC49 3.9 Приміщення випробувальної апаратури, гідровипробувань гасом, дефектоскопії легкозаймистими рідинами, приміщення насосів і вузлів засувок продуктових насосних станцій, складів нафти і нафтопродуктів, каналізаційних насосних станцій\n" +
                        "\uD83D\uDC49 3.10 Камери випробування бустерних і гідравлічних агрегатів, відділення виготовлення і розплавлення модельних форм, ділянки приготування і фарбування різними методами окрім занурення, струменевого покриття і безкамерного фарбування, електромоторні цехи, приміщення масло підживлювальних пристроїв, зберігання, технічного обслуговування і ремонту рухомого складу\n" +
                        "\uD83D\uDC49 3.11 Приміщення обробки металів із використанням устаткування, що містить горючих рідин у силовій гідросистемі та системі охолодження у кількості 60 кг і більше\n" +
                        "\uD83D\uDC49 3.12 Циклони для збору горючих відходів\n" +
                        "\uD83D\uDC49 3.13 Пневмотранспорт горючих матеріалів\n" +
                        "\uD83D\uDC49 3.14 Приміщення для насосів і вузлів засувок, у будівлях насосних станцій резервуарних парків магістральних нафтопроводів незалежно від площі\n" +
                        "\uD83D\uDC49 3.15 Приміщення масляних вимикачів, трансформаторних камер, розподільчих пристроїв розташованих в будівлях іншого призначення\n");
                sendMessage.setReplyMarkup(inlineButton.inlineProductionFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 виробничі":
                sendMessage.setText("Обрано: приміщення за категорією вибухопожежної небезпеки\n\n" +
                        "4. Вкажіть категорію за вибухопожежною небезпекою:");
                sendMessage.setReplyMarkup(inlineButton.inlineCategoryProductionPremissesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія А виробничі приміщення":
            case "Категорія Б виробничі приміщення":
                databaseRepository.setType_of_object_fire_alarm("виробничі А та Б",userId);
                sendMessage.setText("Обрано: " + callbackQuery.getData() + "\n\n" + "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "Категорія В виробничі приміщення":
                sendMessage.setText("Обрано: " + callbackQuery.getData() + "\n\n" + "4. Вкажіть місце розташування приміщення: ");
                sendMessage.setReplyMarkup(inlineButton.inlineLocationProductionFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "підземне розташування":
            case "надземне розташування":
                databaseRepository.setType_of_object_fire_alarm(callbackQuery.getData(),userId);
                sendMessage.setText("Обрано: " + callbackQuery.getData() + "\n\n" + "5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.2 виробничі":
                databaseRepository.setType_of_object_fire_alarm("регулювальні",userId);
                sendMessage.setText("Обрано: регулювальні, контрольно-вимірювальні ділянки, лабораторії, майстерні, електроремонтні майстерні двигунів, ділянки консервування виробів в установках періодичної дії з використанням горючих рідин,промивання виробів, приміщення деревообробки та столярні майстерні\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 виробничі":
                sendMessage.setText("Обрано: приміщення агрегатних у цокольних, підвальних та напівпідвальних поверхах з наявністю видаткових баків мастила більше 500 л \n\n" + fireAlarm.getAggregate() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 виробничі":
                sendMessage.setText("Обрано: ділянки полірування та шліфування виробів з деревини \n\n " +
                        "4. Вкажіть категорію за вибухопожежною небезпекою: ");
                sendMessage.setReplyMarkup(inlineButton.inlineCategoryAggregatePremissesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія АБ агрегатні":
                databaseRepository.setCategory_premises("АБ",userId);
                sendMessage.setText("Обрано: Категорія «А», «Б»" + fireAlarm.getWoodGrinding() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "Категорія В агрегатні":
                databaseRepository.setType_of_object_fire_alarm(callbackQuery.getData(),userId);
                databaseRepository.setCategory_premises("В",userId);
                sendMessage.setText("Обрано: Категорія «В»\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "3.5 виробничі":
                databaseRepository.setType_of_object_fire_alarm("приміщення мастил",userId);
                sendMessage.setText("Обрано: приміщення витратних комор лакофарбових матеріалів, горючих миючих засобів, мастил, горючих рідин\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.6 виробничі":
                databaseRepository.setType_of_object_fire_alarm("гумотехнічні майстерні",userId);
                sendMessage.setText("Обрано: приміщення виробництва деталей із горючих матеріалів, гумотехнічні майстерні\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.7 виробничі":
                sendMessage.setText("Обрано: приміщення випробувань із використанням легкозаймистих і горючих рідин, екрановані кімнати, приміщення із застосуванням лужних та лужноземельних металів, небезпечних металів, їх зварювання, приміщення приготування клею, наповнення балонів горючими газами, насосні компресорні станції, фарбування занурюванням, струменевим поливанням, фарбоприготувальні приміщення, камери сушіння пофарбованих виробів, масляних охолоджувачів\n\n" + fireAlarm.getTestPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.8 виробничі":
                sendMessage.setText("Обрано: цехові експрес-лабораторії аналізів, приміщення ремонту і перевірки кисневого обладнання, перевірки, ремонту та випробувань паливних приладів, промивки хлорованими вуглеводами, приміщення мазутних, дизельних насосів, циклони забору горючих відходів\n\n" + fireAlarm.getAnalysisLaboratories() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.9 виробничі":
                databaseRepository.setType_of_object_fire_alarm("випробувальна апаратура",userId);
                sendMessage.setText("Обрано: приміщення випробувальної апаратури, гідровипробувань гасом, дефектоскопії легкозаймистими рідинами, приміщення насосів і вузлів засувок продуктових насосних станцій, складів нафти і нафтопродуктів, каналізаційних насосних станцій\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.10 виробничі":
                databaseRepository.setType_of_object_fire_alarm("випробування агрегатів",userId);
                sendMessage.setText("Обрано: камери випробування бустерних і гідравлічних агрегатів, відділення виготовлення і розплавлення модельних форм, ділянки приготування і фарбування різними методами окрім занурення, струменевого покриття і безкамерного фарбування, електромоторні цехи, приміщення масло підживлювальних пристроїв, зберігання, технічного обслуговування і ремонту рухомого складу\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.11 виробничі":
                databaseRepository.setType_of_object_fire_alarm("обробка металів",userId);
                sendMessage.setText("Обрано: приміщення обробки металів із використанням устаткування, що містить горючих рідин у силовій гідросистемі та системі охолодження у кількості 60 кг і більше\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.12 виробничі":
                databaseRepository.setType_of_object_fire_alarm("циклони",userId);
                sendMessage.setText("Обрано: циклони для збору горючих відходів\n\n" +
                        "4. Вкажіть об'єм бункеру (м.куб) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("обєм будівлі",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.13 виробничі":
                sendMessage.setText("Обрано: пневмотранспорт горючих матеріалів\n\n" + fireAlarm.getPneumaticTransport() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.14 виробничі":
                databaseRepository.setType_of_object_fire_alarm("приміщення насосів",userId);
                sendMessage.setText("Обрано: приміщення для насосів і вузлів засувок, у будівлях насосних станцій резервуарних парків магістральних нафтопроводів незалежно від площі\n\n" +
                        "4. Вкажіть продуктивність насосних станцій та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("продуктивність",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.15 виробничі":
                databaseRepository.setType_of_object_fire_alarm("приміщення вимикачів",userId);
                sendMessage.setText("Обрано: приміщення масляних вимикачів, трансформаторних камер, розподільчих пристроїв розташованих в будівлях іншого призначення\n\n" +
                        "4. Вкажіть масу мастила та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("вага",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.8 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення у виробничих спорудах і будівлях авіаційного транспорту\n\n" +
                        "3. Оберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 3.1 Приміщення демонтажу і монтажу двигунів, повітряних гвинтів, шасі, коліс, фарбування, промивки, випробування, ремонту і перевірки паливних приладів, приміщення консервації і розконсервації двигунів, підшипників, агрегатів, ремонтні і слюсарні приміщення виробів із скла, пластмаси, крісел, приміщення сушіння і укладання гальмівних парашутів, приміщення обслуговування планерів та систем літаків, випробування агрегатів та систем літаків, приміщення термічних робіт, дефектування знімних деталей та вузлів літаків, приміщення випробування, ремонту та обслуговування силових установок \n\n" +
                        "\uD83D\uDC49 3.2 Приміщення ділянок розбирання, розконсервування авіадвигунів, випробування паливних агрегатів, промивання легкозаймистими і горючими рідинами, дільниці промивання деталей гарячим маслом чи гасом під тиском, приміщення фарбування деталей\n" +
                        "\uD83D\uDC49 3.3 Складські приміщення для зберігання мастильних матеріалів на об’єктах авіаційного транспорту");
                sendMessage.setReplyMarkup(inlineButton.inlinePremissesAirTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 авіаційний":
                databaseRepository.setType_of_object_fire_alarm("монтаж двигунів",userId);
                sendMessage.setText("Обрано: приміщення демонтажу і монтажу двигунів, повітряних гвинтів, шасі, коліс, фарбування, промивки, випробування, ремонту і перевірки паливних приладів, приміщення консервації і розконсервації двигунів, підшипників, агрегатів, ремонтні і слюсарні приміщення виробів із скла, пластмаси, крісел, приміщення сушіння і укладання гальмівних парашутів, приміщення обслуговування планерів та систем літаків, випробування агрегатів та систем літаків, приміщення термічних робіт, дефектування знімних деталей та вузлів літаків, приміщення випробування, ремонту та обслуговування силових установок \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 авіаційний":
                sendMessage.setText("Обрано: приміщення ділянок розбирання, розконсервування авіадвигунів, випробування паливних агрегатів, промивання легкозаймистими і горючими рідинами, дільниці промивання деталей гарячим маслом чи гасом під тиском, приміщення фарбування деталей\n\n" + fireAlarm.getPlacesDisassembly() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 авіаційний":
                databaseRepository.setType_of_object_fire_alarm("складські мастильні",userId);
                sendMessage.setText("Обрано: складські приміщення для зберігання мастильних матеріалів на об’єктах авіаційного транспорту\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.9 АСПЗ приміщення":
                sendMessage.setText("Обрано: складські приміщення\n\n" +
                        "3. Оберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 3.1 Склади зберігання горючих і негорючих вантажів у горючій упаковці з висотою зберігання вантажів від 5,5 м, склади целулоїду і виробів із нього, склади, приміщення і камери легкозаймистих рідин та їх оперативного запасу, склади лужних і лужноземельних металів та порошків, склади витратного запасу двигунів та агрегатів з наявністю в них мастил\n" +
                        "\uD83D\uDC49 3.2 Склади і приміщення для зберігання аміачної селітри і горючих пестицидів\n" +
                        "\uD83D\uDC49 3.3 Приміщення архівів місткістю до 150 тисяч умовних одиниць\n" +
                        "\uD83D\uDC49 3.4 Складські приміщення гуми, каучуку і виробів із них, приміщення зберігання нафтопродуктів із температурою спалаху менше 120 0С в тарі, склади горючих хімікатів, склади деревини \n" +
                        "\uD83D\uDC49 3.5 Склади горючих матеріалів або негорючих матеріалів у горючій упаковці розміщених у підвалах\n" +
                        "\uD83D\uDC49 3.6 Приміщення зберігання нафтопродуктів із температурою спалаху більше 120 0С в тарі \n" +
                        "\uD83D\uDC49 3.7 Склади горючих матеріалів (крім деревини, лужних металів, гуми і виробів, нафтопродуктів, селітри та пестицидів)\n" +
                        "\uD83D\uDC49 3.8 Склади негорючих матеріалів у горючій упаковці, елінги");
                sendMessage.setReplyMarkup(inlineButton.inlineStoragePremissesFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 складські":
                sendMessage.setText("Обрано: склади зберігання горючих і негорючих вантажів у горючій упаковці з висотою зберігання вантажів від 5,5 м, склади целулоїду і виробів із нього, склади, приміщення і камери легкозаймистих рідин та їх оперативного запасу, склади лужних і лужноземельних металів та порошків, склади витратного запасу двигунів та агрегатів з наявністю в них мастил\n\n" + fireAlarm.getCelluloidStorage() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 складські":
                databaseRepository.setType_of_object_fire_alarm("склади горючих пестицидів",userId);
                sendMessage.setText("Обрано: склади і приміщення для зберігання аміачної селітри і горючих пестицидів\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 складські":
                databaseRepository.setType_of_object_fire_alarm("архіви до 150тис.",userId);
                sendMessage.setText("Обрано: приміщення архівів місткістю до 150 тисяч умовних одиниць\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 складські":
                databaseRepository.setType_of_object_fire_alarm("склади гуми",userId);
                sendMessage.setText("Обрано: складські приміщення гуми, каучуку і виробів із них, приміщення зберігання нафтопродуктів із температурою спалаху менше 120 0С в тарі, склади горючих хімікатів, склади деревини \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.5 складські":
                databaseRepository.setType_of_object_fire_alarm("горючі в підвалах",userId);
                sendMessage.setText("Обрано: склади горючих матеріалів або негорючих матеріалів у горючій упаковці розміщених у підвалах\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.6 складські":
                databaseRepository.setType_of_object_fire_alarm("нафтопродукти",userId);
                sendMessage.setText("Обрано: приміщення зберігання нафтопродуктів із температурою спалаху більше 120 0С в тарі \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.7 складські":
                databaseRepository.setType_of_object_fire_alarm("склади горючих матеріалів",userId);
                sendMessage.setText("Обрано: склади горючих матеріалів (крім деревини, лужних металів, гуми і виробів, нафтопродуктів, селітри та пестицидів)\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.8 складські":
                databaseRepository.setType_of_object_fire_alarm("елінги",userId);
                sendMessage.setText("Обрано: склади негорючих матеріалів у горючій упаковці, елінги \n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.10 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення на об’єктах із виробництва солоду, пива та безалкогольних напоїв\n\n" +
                        "3. Оберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 3.1 Надсилосні і підсилосні приміщення\n" +
                        "\uD83D\uDC49 3.2 Приміщення дробильних відділень, бункери дробильного солоду, відділення обробки та очищення зерна, зберігання недробленого продукту, склади хмелю та сировини, дробильно-полірувальні відділення сухого дроблення, відділення сушіння солоду, підробітку солодовні, підлогові склади ячменю та солоду, закриті складські приміщення пальної сировини, горючої продукції та тари із горючих матеріалів\n" +
                        "\uD83D\uDC49 3.3 Холодильно-компресорне відділення, склади аміаку, масла, пального, допоміжного матеріалі і матеріальні");
                sendMessage.setReplyMarkup(inlineButton.inlineBeerProductionFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 пиво":
                sendMessage.setText("Обрано: надсилосні і підсилосні приміщення\n\n" + fireAlarm.getSiloPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 пиво":
                databaseRepository.setType_of_object_fire_alarm("дробильне відділення",userId);
                sendMessage.setText("Обрано: приміщення дробильних відділень, бункери дробильного солоду, відділення обробки та очищення зерна, зберігання недробленого продукту, склади хмелю та сировини, дробильно-полірувальні відділення сухого дроблення, відділення сушіння солоду, підробітку солодовні, підлогові склади ячменю та солоду, закриті складські приміщення пальної сировини, горючої продукції та тари із горючих матеріалів\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 пиво":
                databaseRepository.setType_of_object_fire_alarm("холодильно-компресорне відділення",userId);
                sendMessage.setText("Обрано: холодильно-компресорне відділення, склади аміаку, масла, пального, допоміжного матеріалі і матеріальні\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.11 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення для автомобільного транспорту\n\n" +
                        "3. Виберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 3.1 В одноповерхових будинках І та ІІ ступеня вогнестійкості\n" +
                        "\uD83D\uDC49 3.2 В будинках ІІІ та IV ступеня вогнестійкості\n" +
                        "\uD83D\uDC49 3.3 В будинках ІІІа ступеня вогнестійкості \n" +
                        "\uD83D\uDC49 3.4 У будинках з двома поверхами і більше, у підвальних, цокольних, підземних поверхах, приміщення гаражів і стоянок з механізованими пристроями паркування, приміщення у будівлях різного призначення які пристосовані під автосалони, приміщення зберігання автомототранспорту у підвальних, цокольних, підземних поверхах\n" +
                        "\uD83D\uDC49 3.5 Приміщення для зберігання, технічного обслуговування і ремонту автомобілів");
                sendMessage.setReplyMarkup(inlineButton.inlineAutoTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 автотранспорт":
                sendMessage.setText("Обрано: в одноповерхових будинках І та ІІ ступеня вогнестійкості\n\n" +
                        "4. Вкажіть тип транспорту: \n\n" +
                        "\uD83D\uDC49 4.1 легковий та вантажний автомобільний транспорт, автобуси І категорії, суміщене зберігання з іншими видами транспорту менше 50 % автобусів від загальної кількості транспорту \n" +
                        "\uD83D\uDC49 4.2 автобуси ІІ та ІІІ категорій, суміщене зберігання з іншими видами транспорту більше 50 % автобусів від загальної кількості транспорту \n");
                sendMessage.setReplyMarkup(inlineButton.inlineTypeAutoTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.1 вид транспорту":
                databaseRepository.setType_of_object_fire_alarm("легковий транспорт",userId);
                sendMessage.setText("Обрано: легковий та вантажний автомобільний транспорт, автобуси І категорії, суміщене зберігання з іншими видами транспорту менше 50 % автобусів від загальної кількості транспорту \n\n" +
                        "5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                databaseRepository.setValue("площа",userId);
                break;
            case "4.2 вид транспорту":
                databaseRepository.setType_of_object_fire_alarm("автобуси",userId);
                sendMessage.setText("Обрано: автобуси ІІ та ІІІ категорій, суміщене зберігання з іншими видами транспорту більше 50 % автобусів від загальної кількості транспорту\n\n" +
                        "5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 автотранспорт":
                databaseRepository.setType_of_object_fire_alarm("авто в будинках ІІІст",userId);
                sendMessage.setText("Обрано: в будинках ІІІ та IV ступеня вогнестійкості\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 автотранспорт":
                databaseRepository.setType_of_object_fire_alarm("авто в будинках ІІІа ст.",userId);
                sendMessage.setText("Обрано: в будинках ІІІа ступеня вогнестійкості\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 автотранспорт":
                sendMessage.setText("Обрано: у будинках з двома поверхами і більше, у підвальних, цокольних, підземних поверхах, приміщення гаражів і стоянок з механізованими пристроями паркування, приміщення у будівлях різного призначення які пристосовані під автосалони, приміщення зберігання автомототранспорту у підвальних, цокольних, підземних поверхах\n\n" + fireAlarm.getAutoMoreTwoFloors() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.5 автотранспорт":
                sendMessage.setText("Обрано: приміщення для зберігання, технічного обслуговування і ремонту автомобілів\n\n" +
                        "4. Виберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 4.1 У підвальних, цокольних, підземних поверхах незалежно від поверховості, підземних і цокольних поверхах будівель іншого призначення\n" +
                        "\uD83D\uDC49 4.2 Службові приміщення персоналу гаражів\n" +
                        "\uD83D\uDC49 4.3 Зони електрошаф, венткамер, бойлерних, теплопунктів і насосних станцій ");
                sendMessage.setReplyMarkup(inlineButton.inlineRepairAutoTransportFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.1 ремонт авто":
                sendMessage.setText("Обрано: у підвальних, цокольних, підземних поверхах незалежно від поверховості, підземних і цокольних поверхах будівель іншого призначення \n\n" + fireAlarm.getRepairAutoInBasement() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.2 ремонт авто":
                sendMessage.setText("Обрано: службові приміщення персоналу гаражів\n\n" + fireAlarm.getStaffPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "4.3 ремонт авто":
                sendMessage.setText("Обрано: зони електрошаф, венткамер, бойлерних, теплопунктів і насосних станцій зони електрошаф, венткамер, бойлерних, теплопунктів і насосних станцій\n\n" + fireAlarm.getElectricCabinetZones() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "1.12 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення в спорудах і будівлях метрополітену\n\n" +
                        "3. Виберіть тип приміщення:\n\n" +
                        "\uD83D\uDC49 3.1 Підземні приміщення і споруди метрополітенів за винятком пасажирських приміщень, акумуляторних, насосних, теплових вузлів, санвузлів, калориферних, камер тунельної вентиляції і приміщень категорії «Д» \n" +
                        "\uD83D\uDC49 3.2 Дільниці на лініях, в електродепо та приміщеннях метрополітену\n" +
                        "\uD83D\uDC49 3.3 Об’єкти торгівельного та соціально-побутового призначення розміщених на площах і в під вуличних переходах метрополітену, шафи вводів електроживлення і шафи управління ескалаторами у машинних відділеннях, підбалюстрадний простір ескалаторів у похилому тонелі та натяжній, підземні та наземні комори мастильних матеріалів\n" +
                        "\uD83D\uDC49 3.4 Кабельні канали, кабельні підвали, кабельні тунелі вздовж станцій, кабельні поверхи, кабельні колектори наземних об’єктів та електродепо \n" +
                        "\uD83D\uDC49 3.5 Відстійно-ремонтні корпуси і будинках електродепо");
                sendMessage.setReplyMarkup(inlineButton.inlineSubwayFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 метрополітен":
                sendMessage.setText("підземні приміщення і споруди метрополітенів за винятком пасажирських приміщень, акумуляторних, насосних, теплових вузлів, санвузлів, калориферних, камер тунельної вентиляції і приміщень категорії «Д» \n\n" + fireAlarm.getSubway() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 метрополітен":
                sendMessage.setText("Обрано: дільниці на лініях, в електродепо та приміщеннях метрополітену\n\n" + fireAlarm.getStationsElectricalDepot() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 метрополітен":
                sendMessage.setText("Обрано: об’єкти торгівельного та соціально-побутового призначення розміщених на площах і в під вуличних переходах метрополітену, шафи вводів електроживлення і шафи управління ескалаторами у машинних відділеннях, підбалюстрадний простір ескалаторів у похилому тонелі та натяжній, підземні та наземні комори мастильних матеріалів \n\n" + fireAlarm.getStationsElectricalDepot() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.4 метрополітен":
                databaseRepository.setType_of_object_fire_alarm("кабельні канали",userId);
                sendMessage.setText("Обрано: кабельні канали, кабельні підвали, кабельні тунелі вздовж станцій, кабельні поверхи, кабельні колектори наземних об’єктів та електродепо \n\n" +
                        "4. Вкажіть пожежне навантаження (МДж/м2) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("продуктивність",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "3.5 метрополітен":
                databaseRepository.setType_of_object_fire_alarm("відстійно-ремонтні корпуси",userId);
                sendMessage.setText("Обрано: відстійно-ремонтні корпуси і будинках електродепо\n\n" +
                        "4. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                databaseRepository.setValue("площа",userId);
                messageSender.sendMessage(sendMessage);
                break;
            case "1.13 АСПЗ приміщення":
                sendMessage.setText("Обрано: приміщення в будинках виробничого та громадського призначення\n\n" +
                        "3. Виберіть тип приміщення: \n\n" +
                        "\uD83D\uDC49 3.1 приміщення електрообчислювальних машин обробки даних, серверні, централізованого контролю і управління технологічним процесом \n" +
                        "\uD83D\uDC49 3.2 простори за підвісними стелями та під фальшпідлогою\n" +
                        "\uD83D\uDC49 3.3 приміщення електронних АТС та серверних у 4- та 5-зіркових готелях");
                sendMessage.setReplyMarkup(inlineButton.inlinePremissesProductionPurposeFireAlarmKeyboard());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.1 виробничого призначення":
                sendMessage.setText("Обрано: приміщення електрообчислювальних машин обробки даних, серверні, централізованого контролю і управління технологічним процесом\n\n" + fireAlarm.getServerPremisses() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.2 виробничого призначення":
                sendMessage.setText("Обрано: простори за підвісними стелями та під фальшпідлогою\n\n" + fireAlarm.getSuspendedCeiling() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "3.3 виробничого призначення":
                sendMessage.setText("Обрано: приміщення електронних АТС та серверних у 4- та 5-зіркових готелях\n\n" + fireAlarm.getServerInHotel() + "\n\n" + instructionExtinguisher.getStart());
                messageSender.sendMessage(sendMessage);
                break;
            case "Далі сигналізація":
                switch (databaseRepository.getType_of_object_fire_alarm(userId)){
                    case "житлова будівля":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getHousing()+"\n\n"+instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "гуртожиток":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getDormitory()+"\n\n"+instructionExtinguisher.getStart());
                        }
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
                            sendMessage.setText(fireAlarm.getHotelHeigth() + "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "офісна будівля":
                        if (databaseRepository.getHeight_object(userId) == null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOffice()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "торгівельний підземний":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getUndergroundMall()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "торгівельний надземний":
                        if (databaseRepository.getFloors(userId) == null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && square == null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && square!=null){
                            sendMessage.setText(fireAlarm.getGroundMall()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "вбудована харчування":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getBuiltInCatering()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "окрема харчування":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && square==null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && square!=null){
                            sendMessage.setText(fireAlarm.getSeparateCatering()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "виставкова підземна":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getExhibitionUnderground()+ "\n\n" +instructionExtinguisher.getStart());
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
                        }else if (databaseRepository.getFloors(userId)!= null && databaseRepository.getFire_resistance(userId)!=null && square==null && databaseRepository.getValue(userId).equals("вогнеснійкість будівлі")){
                                sendMessage.setText("6. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                                databaseRepository.setValue("площа",userId);
                        }else if (square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)!=null && square!=null){
                            sendMessage.setText(fireAlarm.getExhibitionGround()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "кінотеатр":
                        if (databaseRepository.getSeats(userId)==null){
                            sendMessage.setText(fireAlarm.getSeatsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCinema()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "казино":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCasino()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "бібліотека органи влади":
                        if (databaseRepository.getBooks_storage(userId)==null){
                            sendMessage.setText(fireAlarm.getBooksStorageEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getLibrary()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "бібліотека інші будівлі":
                        if (databaseRepository.getBooks_storage(userId)==null){
                            sendMessage.setText(fireAlarm.getBooksStorageEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getLibraryOtherBuildings()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "архів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getArchive()+ "\n\n" +instructionExtinguisher.getStart());
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
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getFloors(userId)!=null && databaseRepository.getValue(userId).equals("площа")&&square==null){
                                sendMessage.setText(fireAlarm.getSquareEmpty());
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getHeight_object(userId)!=null && databaseRepository.getFloors(userId)!=null && square!=null){
                            if (square<=300 && databaseRepository.getArchives(userId)==null){
                                sendMessage.setText("7. Наявні приміщення для зберігання цінних документів та архівів?");
                                sendMessage.setReplyMarkup(inlineButton.inlineInstitutesFireAlarmKeyboard());
                            }else {
                                sendMessage.setText(fireAlarm.getInstitutes()+ "\n\n" +instructionExtinguisher.getStart());
                            }
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "охорона здоров'я":
                        if (databaseRepository.getHeight_object(userId)==null){
                            sendMessage.setText(fireAlarm.getHeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getHealthCare()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "релігійні будівлі":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getReligious()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "вокзали":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStation()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "депо":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getDepot()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "підземні гаражі":
                        if (databaseRepository.getAmount_of_transport(userId)==null){
                            sendMessage.setText(fireAlarm.getAmountOfTransportEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getUndergroundGarages()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "наземні гаражі":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)==null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть ступінть вогнестійкості(1 / 2 / 3 / 3а / 4 та натисніть \"Далі\" \uD83D\uDC47 ");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("вогнеснійкість будівлі",userId);
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)!=null && databaseRepository.getValue(userId).equals("вогнеснійкість будівлі")){
                            sendMessage.setText(fireAlarm.getFireResistanceEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)!=null && square==null && databaseRepository.getValue(userId).equals("вогнеснійкість будівлі")){
                            sendMessage.setText("6. Введіть загальну площу будівлі та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getFire_resistance(userId)!=null && square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри. \n\n" +
                                    "Надішліть загальну площу приміщень(м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getGarages()+ "\n\n" +instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "автосалони":
                        if (square==null){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри. \n\n" +
                                    "Надішліть загальну площу приміщень(м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCarDealership() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "виробнича будівля":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null &&square==null && databaseRepository.getValue(userId).equals("поверхи")) {
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getFloors(userId)!=null && square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && square!=null){
                            sendMessage.setText(fireAlarm.getProductionBuilding() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склад категорії А та Б":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageA() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склад категорії В":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageB() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади гуми":
                        if (databaseRepository.getFloors(userId)==null){
                            sendMessage.setText(fireAlarm.getFloorsEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else if (databaseRepository.getFloors(userId)!=null && databaseRepository.getValue(userId).equals("поверхи")){
                            sendMessage.setText("5. Введіть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            databaseRepository.setValue("площа",userId);
                        }else if (databaseRepository.getFloors(userId)!=null && square==null && databaseRepository.getValue(userId).equals("площа")){
                            sendMessage.setText("Ви не ввели рекомендовані системою параметри. \n\n" +
                                    "Надішліть загальну площу приміщень(м.кв) та натисніть \"Далі\" \uD83D\uDC47");
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageRubber() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади негорючих матеріалів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageNonCombustibleSubstances()+"\n\n"+instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади селітри":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageSaltpeter() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади плівки":
                        if (databaseRepository.getWeight(userId)==null){
                            sendMessage.setText(fireAlarm.getWeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getStorageFilm() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади двигунів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getStorageEngine() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "резервуари спирту":
                        if (databaseRepository.getVolume_premises(userId)==null){
                            sendMessage.setText(fireAlarm.getVolumeEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getAlcoholTanks() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "резервуари нафти":
                        if (databaseRepository.getVolume_premises(userId)==null){
                            sendMessage.setText(fireAlarm.getVolumeEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOilTanks() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення нафти нижче 120":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOilPremissesBellow120() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення нафти вижче 120":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOilPremissesHigher120() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "закриті склади":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getClosedStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади борошна":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getFlourStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади вітамінів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getVitaminsStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "матеріальні склади":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getMaterialStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "корівники":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getBarn() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади пестицидів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getPesticidesStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "автомобільні тунелі":
                        if (databaseRepository.getLength(userId)==null){
                            sendMessage.setText(fireAlarm.getLengthEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCarTunnel());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "Г1 або Г2":
                    case "Г3 або Г4":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getPolymersStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "кабельні внутрішньоцехові":
                        if (databaseRepository.getVolume_premises(userId)==null){
                            sendMessage.setText(fireAlarm.getVolumeEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getInternalCableStructure() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади легкозаймистих рідин":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getFlammableLiquidsStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "надземний поверх камера схову":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else{
                            sendMessage.setText(fireAlarm.getCloakroom() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "підземний поверх камера схову":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCloakroomUnderground() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "надземний поверх автоматична камера":
                    case "підземний поверх автоматична камера":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getAutoCloakroom() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "очищення зерна":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getGrainCleaning() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення кормоцехів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getPremissesOfCompoundFeedShops() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "транспортні галереї":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getTransportGalleries() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "укрпошта":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getUkrainianPost() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "виробничі А та Б":
                    case "підземне розташування":
                    case "надземне розташування":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getProductionPremisses() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "регулювальні":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getAdjustment() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "Категорія В агрегатні":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getWoodGrinding() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення мастил":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getOilPremisses() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "гумотехнічні майстерні":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getRubberEngineeringWorkshops() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "випробувальна апаратура":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getTestEquipment() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "випробування агрегатів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getTestAggregate() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "обробка металів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getMetalProcessing() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "циклони":
                        if (databaseRepository.getVolume_premises(userId)==null){
                            sendMessage.setText(fireAlarm.getVolumeEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCyclones() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення насосів":
                        if (databaseRepository.getProductivity(userId)==null){
                            sendMessage.setText(fireAlarm.getProductivityEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getPumpsPremisses() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "приміщення вимикачів":
                        if (databaseRepository.getWeight(userId)==null){
                            sendMessage.setText(fireAlarm.getWeightEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getSwitchPremisses() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "монтаж двигунів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getInstallationOfEngines() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "складські мастильні":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getLubricantStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади горючих пестицидів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getFlammablePesticidesStorage());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "архіви до 150тис.":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getArchivesUpTo150());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади каучуку":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getRubberStorage() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "горючі в підвалах":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getFlammableInBasement() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "нафтопродукти":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getPetroleumProducts() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "склади горючих матеріалів":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCombustibleMaterials() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "елінги":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getBoatRamps() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "дробильне відділення":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCrushingDepartment() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "холодильно-компресорне відділення":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCompressorDepartment() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "легковий транспорт":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCar() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "автобуси":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getBus() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "авто в будинках ІІІст":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getAutoInPremisses3fireResistance() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "авто в будинках ІІІа ст.":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getAutoInPremisses3aFireResistance() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "кабельні канали":
                        if (databaseRepository.getProductivity(userId)==null){
                            sendMessage.setText(fireAlarm.getProductivityEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getCableChannels() + "\n\n" + instructionExtinguisher.getStart());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;
                    case "відстійно-ремонтні корпуси":
                        if (square==null){
                            sendMessage.setText(fireAlarm.getSquareEmpty());
                            sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                        }else {
                            sendMessage.setText(fireAlarm.getSumpHousing());
                        }
                        messageSender.sendMessage(sendMessage);
                        break;



                }
                break;
        }
    }
    String result() { // виводить результат для вогнегасника
        String s6 = null;
        String typePremisses = databaseRepository.getType_premises(userId);
        String typeExtinguisher = databaseRepository.getType_extinguisher(userId);
        switch (typePremisses) {
            case "Виробничі_складські":
                IndustrialPremises ip = new IndustrialPremises(userId, databaseRepository);
                switch (typeExtinguisher) {
                    case "порошковий":
                        s6 = ip.quantityExtinguisherPoroshok();
                        break;
                    case "водопінний":
                        s6 = ip.quantityExtinguisherVodopinni();
                        break;
                    case "водяний":
                        s6 = ip.quantityExtinguisherVodiani();
                        break;
                    case "газовий":
                        s6 = ip.quantityExtinguisherGazovyi();
                        break;
                }
                break;
            case "Громадські": {
                PublicPremises pp = new PublicPremises(userId, databaseRepository);
                if (typeExtinguisher.equals("порошковий")) {
                    s6 = pp.quantityExtinguisherPoroshok();
                }
                if (typeExtinguisher.equals("водопінний")) {
                    s6 = pp.quantityExtinguisherVodopinni();
                }
                if (typeExtinguisher.equals("водяний")) {
                    s6 = pp.quantityExtinguisherVodiani();
                }
                break;
            }
            case "Житлові":
                TypesLivingSpace lp = new TypesLivingSpace();
                s6 = lp.quantityExtinguisherLivingSpace();
                break;
            case "Гаражі":
                Garages gg = new Garages(userId, databaseRepository);
                s6 = gg.quantityExtinguisherGarages();
                break;
            case "Технічні приміщення": {
                PublicPremises pp = new PublicPremises(userId, databaseRepository);
                s6 = pp.quantityExtinguisherTekhPrym();
                break;
            }
            case "Кухні": {
                PublicPremises pp = new PublicPremises(userId, databaseRepository);
                s6 = pp.quantityExtinguisherVodianiKitchen();
                break;
            }
        }
        return s6;
    }
    String resultDegreeRisk() { // виводить результат для ступеня ризику
        String s6 = null;
        String characteristicsObject = databaseRepository.getCharacteristics_object(userId);
        DegreeRiskObject dro = new DegreeRiskObject(userId,databaseRepository);
        switch (characteristicsObject){
            case "експлуатується":
                s6 = dro.degreeRiskObjectExploited();
                break;
            case "проєктується":
                s6 = dro.degreeRiskObjectProjected();
                break;
        }
        return s6;
    }
}


