package com.ada.roomms.model;

import com.ada.roomms.enumeration.RoomTipos;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Getter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    @Size(max = 12)
    private String nome;
    @Column(nullable = false, unique = false)
    @Size(max = 12)
    private Integer coluna;
    @Column (nullable = false,unique = false)
    @Size(max = 12)
    private Integer fileira;
    private RoomTipos tipoDeSala;
}
