package com.oksana.domain;

import com.oksana.infrastructure.persistence.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {

    private Long idUsuario;

    @NotNull
    private String username;
    @NotNull
    private String password;

    private List<RoleEntity> roleEntities;


}
