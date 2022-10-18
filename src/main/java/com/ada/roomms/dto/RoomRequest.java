package com.ada.roomms.dto;

import com.ada.roomms.enumeration.RoomTipos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RoomRequest {
    @Size(max = 12)
    @NotNull(message = "O nome não pode ser vazio")
    private String nome;
    @Size(max = 12)
    @NotNull(message = "A ")
    private Integer coluna;
    @Size(max = 12)
    @NotNull
    private Integer fileira;
    @NotNull
    private RoomTipos tipoDeSala;
}
