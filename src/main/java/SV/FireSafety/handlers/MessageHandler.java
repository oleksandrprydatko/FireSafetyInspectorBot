package SV.FireSafety.handlers;

import SV.FireSafety.messagesender.MessageSender;
import SV.FireSafety.services.DBWorker;
import SV.FireSafety.services.InlineButton;
import SV.FireSafety.services.InstructionExtinguisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.Optional;
import java.util.Scanner;

@Component
public class MessageHandler implements Handler<Message> {
    //конструктор класу MessageSender
    private final MessageSender messageSender;
    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    //екземпляри класів
    InstructionExtinguisher instructionExtinguisher = new InstructionExtinguisher();
    InlineButton inlineButton = new InlineButton();
    DBWorker dbWorker = new DBWorker();

    @Override
    public void choose(Message message) {
        System.out.println(message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        String chatID = String.valueOf(message.getChatId());
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> comandEntity = message.getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (comandEntity.isPresent()) {
                String command = message.getText().substring(comandEntity.get().getOffset(),
                        comandEntity.get().getLength());
                switch (command) {
                    case "/start":
                        String text = "Вітаю! Я чат-бот Fire Safety Bot \uD83C\uDDFA\uD83C\uDDE6 \n Для початку роботи скористайтеся командами бота👇";
                        sendMessage.setText(text);
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        return;
                    case "/on_start":
                        sendMessage.setText("🇺🇦 Для початку роботи повторно скористайтеся командами бота Fire Safety Bot 👇");
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        //очищення бази
                        dbWorker.update(chatID);
                        return;
                        // видає посилання на портал електронних послуг
                    case "/service_portal":
                        //встановлення команди в БД
                        dbWorker.setComandOfMenu(chatID,"/service_portal");
                        sendMessage.setText("🇺🇦 Ви обрали портал електронних послуг ДСНС України. Для переходу скористайтесь посиланням 👇");
                        sendMessage.setReplyMarkup(inlineButton.inlineServicePortalKeyboardMarkup());
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        //очищення бази
                        dbWorker.update(chatID);
                        return;
                    // розпочинає роботу вогнегасника + виводить інструкцію
                    case "/type_number_fire_extinguishers":
                        //встановлення команди в БД
                        dbWorker.setComandOfMenu(chatID,"/type_number_fire_extinguishers");
                        sendMessage.setText("Я підсистема Extinguisher Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу вибрати тип та необхідну кількість вогнегасників \uD83E\uDDEF \n\n Для початку роботи натисніть <Розпочати> \n\n \uD83D\uDCDA Для ознайомлення з інструкцією користувача скористайтесь відповідним меню");
                        sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        //очищення бази
                        dbWorker.update(chatID);
                        return;
                    // визначення ступення ризику
                    case "/degree_of_risk_from_activities":
                        //встановлення команди в БД
                        dbWorker.setComandOfMenu(chatID,"/degree_of_risk_from_activities");
                        sendMessage.setText("Я підсистема Degree of subject risk Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити ступніть ризику від провадження господарської діяльності \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        //очищення бази
                        dbWorker.update(chatID);
                        return;
                    case "/determination_of_categories":
                        //встановлення команди в БД
                        dbWorker.setComandOfMenu(chatID,"/determination_of_categories");
                        sendMessage.setText("Я підсистема Determination of categories of premisses according to fire hazard \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу з визначенням категорій приміщень,будинків та зовнішніх установок за вибухопожежною та пожежною небезпекою \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //перевірка чи юзер є в БД/ додавання його в базу
                        dbWorker.checkUser(chatID);
                        //очищення бази
                        dbWorker.update(chatID);
                        return;
                    case "/feedback_info":
                        sendMessage.setText(instructionExtinguisher.feedback());
                        messageSender.sendMessage(sendMessage);
                        return;
                    default:
                        sendMessage.setText("Зазначено не коректні дані: " + message.getText() + " Спробуйте ще раз!");
                        messageSender.sendMessage(sendMessage);
                }
                }
        }
        if (message.hasText()){ //якщо введено текст, перевірка чи це значення
            String messageText = message.getText();

            Scanner sc = new Scanner(message.getText());
            if (sc.hasNextDouble()) {
                sendMessage.setText("Надіслані дані збережено: " + messageText);
                messageSender.sendMessage(sendMessage);
                if (dbWorker.getValue(chatID).equals("площа")){
                    //встановлення в БД площі об'єкта
                    dbWorker.setSquare(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("паркування")){
                    //встановлення в БД кількість місць для паркування
                    dbWorker.setParking(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("технічні приміщення")){
                    dbWorker.setSquareTechnicalPremises(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("робочі місця")){
                    dbWorker.setWorkplace(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("постійно перебувають на обєкті")){
                    dbWorker.setConstantlyAtFacility(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("періодично перебувають на обєкті")){
                    dbWorker.setPeriodicallyAtFacility(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("висота обєкта")){
                    dbWorker.setHeightObject(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("усунено порушень")){
                    dbWorker.setFixedViolations(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("не усунено порушень")){
                    dbWorker.setNoFixedViolations(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("загиблі")){
                    dbWorker.setDeadPeople(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("збитки")){
                    dbWorker.setLosses(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("дохід")){
                    dbWorker.setTaxFreeIncome(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("травмовані")){
                    dbWorker.setInjuredPeople(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("обєм будівлі")){
                    dbWorker.setVolumePremises(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("обєм приміщень А")){
                    dbWorker.setVolumeRoomsA(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("обєм приміщень Б")){
                    dbWorker.setVolumeRoomsБ(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("обєм приміщень В")){
                    dbWorker.setVolumeRoomsB(chatID,messageText);
                }else if (dbWorker.getValue(chatID).equals("обєм приміщень Г")){
                    dbWorker.setVolumeRoomsГ(chatID,messageText);
                }
            }else{
                sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                messageSender.sendMessage(sendMessage);
            }
        }else {
            sendMessage.setText("Помилка");
            messageSender.sendMessage(sendMessage);
        }

    }
}
