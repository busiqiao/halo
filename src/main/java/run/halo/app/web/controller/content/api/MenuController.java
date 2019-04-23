package run.halo.app.web.controller.content.api;

import run.halo.app.model.dto.MenuDTO;
import run.halo.app.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Portal menu controller.
 *
 * @author johnniang
 * @date 4/3/19
 */
@RestController("PortalMenuController")
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    @ApiOperation("Lists all menus")
    public List<MenuDTO> listAll(@SortDefault(sort = "sort", direction = DESC) Sort sort) {
        return menuService.listDtos(sort);
    }
}