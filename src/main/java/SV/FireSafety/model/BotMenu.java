package SV.FireSafety.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bot_menu", schema = "inspector")
public class BotMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "menu_id")
    private String menuId;

    @JoinColumn(name = "parent_menu_id")
    private Integer parentMenuId;

//    @OneToMany(mappedBy = "parentMenuId", fetch = FetchType.EAGER)
////    @Fetch(FetchMode.JOIN)
//    private List<BotMenu> subMenu;

    @Column(name = "menu_val")
    private String menuVal;
    @Column(name = "menu_name")
    private String menuName;
}
