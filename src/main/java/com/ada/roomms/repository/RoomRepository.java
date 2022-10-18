package com.ada.roomms.repository;

import com.ada.roomms.enumeration.RoomTipos;
import com.ada.roomms.model.Room;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;
@Repository
public interface RoomRepository extends ReactiveCrudRepository<Room, UUID> {

    Flux<Room> findRoomByNomeContainingIgnoreCase(String nome);
    Flux<Room> findRoomByTipoDeSala(RoomTipos tipo);

}
