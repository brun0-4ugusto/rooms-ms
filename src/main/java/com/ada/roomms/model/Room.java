package com.ada.roomms.model;

import com.ada.roomms.enumeration.RoomTipos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private Long id;
    private String nome;
    private Integer coluna;
    private Integer fileira;
    @Column("tipoDeSala")
    private RoomTipos tipoDeSala;
}
