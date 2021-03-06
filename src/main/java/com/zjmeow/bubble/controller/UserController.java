package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.AvatarDTO;
import com.zjmeow.bubble.model.dto.InfoDTO;
import com.zjmeow.bubble.model.dto.LocationDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.UserDetailVO;
import com.zjmeow.bubble.model.vo.UserMapVO;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 用户资料控制器
 * @author: zjm
 **/
@RequestMapping(value = "/users")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/avatar")
    ApiResponse<String> uploadAvatar(@Valid AvatarDTO avatarDTO) {
        userService.updateAvatar(avatarDTO);
        return RestResultGenerator.genResult("上传成功", "ok");
    }

    @PostMapping("/info")
    ApiResponse<String> updateInfo(@Valid InfoDTO infoDTO) {
        userService.updateInfo(infoDTO);
        return RestResultGenerator.genResult("修改成功", "ok");
    }

    /**
     * 更新用户位置，用户通过定时调用这个接口来在地图上形成移动的效果
     * TODO:引入 redis 增加处理速度，避免每次都写入数据库，因为业务原因，可以每次登录后重新定位。
     */
    @PostMapping("/location")
    ApiResponse<String> updateLocation(@Valid LocationDTO locationDTO) {
        userService.updateLocation(locationDTO);
        return RestResultGenerator.genResult("上传成功", "ok");
    }

    /**
     * 获取附近的用户，用户也是定时获取这个接口
     * TODO:引入缓存避免每次都从数据库中拿出
     */
    @GetMapping("/around")
    ApiResponse<List<UserMapVO>> getAround(@RequestParam("lng") @NotNull Double lng,
                                           @RequestParam("lat") @NotNull Double lat) {

        return RestResultGenerator.genResult(userService.selectUserByLocation(lng, lat), "ok");
    }


    @GetMapping("/detail")
    ApiResponse<UserDetailVO> getUserDetail(@RequestParam("id") @NotNull Integer id) {
        UserDetailVO userDetailVO = userService.selectUserById(id);
        return RestResultGenerator.genResult(userDetailVO, "ok");
    }
}
