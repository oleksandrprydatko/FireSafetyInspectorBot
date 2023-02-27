package SV.FireSafety;

import SV.FireSafety.model.BotMenu;
import SV.FireSafety.repository.BotMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class FireSafetyApplication {

    @Autowired
    BotMenuRepository botMenuRepository;
    public static void main(String[] args) {
        SpringApplication.run(FireSafetyApplication.class, args);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener() {
        return new ApplicationListener<ApplicationReadyEvent>() {
            @Override
            public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//                List<BotMenu> rootMenus = botMenuRepository.findAll();
                List<BotMenu> rootMenus = botMenuRepository.findRootMenus();
                for(BotMenu botMenu: rootMenus){
                    List<BotMenu> subMenu = botMenuRepository.findSubMenus(botMenu.getId());
                    log.debug("{}", subMenu.size());
                }
            }
        };
    }

}
