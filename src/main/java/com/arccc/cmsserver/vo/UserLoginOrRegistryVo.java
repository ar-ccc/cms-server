package com.arccc.cmsserver.vo;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class UserLoginOrRegistryVo {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
