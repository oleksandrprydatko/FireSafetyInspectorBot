package SV.FireSafety.repository;

import SV.FireSafety.model.BotMenu;
import SV.FireSafety.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BotMenuRepository extends JpaRepository<BotMenu, Integer> {

    @Query(value = "from BotMenu b where b.parentMenuId is null")
    List<BotMenu> findRootMenus();
    @Query(value = "from BotMenu b where b.parentMenuId = :parentMenuId")
    List<BotMenu> findSubMenus(Integer parentMenuId);

    @Query(value = "from BotMenu b where b.menuId = :menuId")
    Optional<BotMenu> findVal(String menuId);
}
