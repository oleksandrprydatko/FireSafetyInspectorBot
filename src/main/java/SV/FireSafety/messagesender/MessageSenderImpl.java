package SV.FireSafety.messagesender;

import SV.FireSafety.FireSafetyBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private FireSafetyBot fireSafetyBot;
    @Autowired
    public void setFireSafetyBot(FireSafetyBot fireSafetyBot){
        this.fireSafetyBot = fireSafetyBot;
    }
    @Override
    public void sendMessage(SendMessage sendMessage) {
        try{
            fireSafetyBot.execute(sendMessage);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendEditMessage(EditMessageText editMessageText) {
        try{
            fireSafetyBot.execute(editMessageText);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
