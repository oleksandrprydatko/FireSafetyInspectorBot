package SV.FireSafety.services;

import SV.FireSafety.model.BotMenu;
import SV.FireSafety.repository.BotMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class InlineButtonFromDB {
    public InlineKeyboardMarkup inlineStartKeyboard(List<BotMenu> botMenus){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (BotMenu botMenu: botMenus){
            keyboard.add(Collections.singletonList(InlineKeyboardButton.builder()
                    .text(botMenu.getMenuName()).callbackData(botMenu.getMenuId()).build()));
        }
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
}
