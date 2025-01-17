package com.oksana.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * Role domain
 *
 * @author Oksana Yurkiv
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idRol;

    @NotEmpty
    private String nombre;

}
