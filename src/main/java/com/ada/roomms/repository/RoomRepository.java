package com.ada.roomms.repository;

import com.ada.roomms.enumeration.RoomTipos;
import com.ada.roomms.model.Room;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;
public interface RoomRepository extends R2dbcRepository<Room, Long> {

    Flux<Room> findRoomByNomeContainingIgnoreCaseOrTipoDeSala(String nome, RoomTipos tipos);

}
