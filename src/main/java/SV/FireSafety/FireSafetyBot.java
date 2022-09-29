package SV.FireSafety;

import SV.FireSafety.processors.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class FireSafetyBot extends TelegramLongPollingBot {
    private Processor processor;

    @Override
    public String getBotUsername() {
        return "Interactive_Inspector_Test_Bot";
    }

    @Override
    public String getBotToken() {
        return "5726997593:AAFxbabAkVO4DvE6UVL_jVj-Mxi0qV2cfJ0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        processor.process(update);
    }

    @Autowired
    public void setProcessor(Processor processor){
        this.processor = processor;
    }

}
