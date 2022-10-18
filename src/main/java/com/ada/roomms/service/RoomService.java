package com.ada.roomms.service;

import com.ada.roomms.enumeration.RoomTipos;
import com.ada.roomms.model.Room;
import com.ada.roomms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomService {

    private RoomRepository repository;
    @Autowired
    public void setRepository(RoomRepository repository) {
        this.repository = repository;
    }

    //Cadastrar Sala - Lucas
    public Mono<ResponseEntity<Room>> saveRoom(Room room){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        return repository.save(room).map(room1 ->
                 ResponseEntity.created(uriComponentsBuilder.path("room/{id}")
                         .buildAndExpand(room1.getId()).toUri()).body(room1));
    }

//Listar Salas - Bruno
    public Flux<Room> getAll() {
        return repository.findAll();
    }

//Consultar sala (livre) - Artur
    public Flux<Room> consult(String nome, RoomTipos tipo) {
        return repository.findRoomByNomeContainingIgnoreCaseOrTipoDeSala(nome, tipo);
    }


//Alterar sala - Artur
    public Mono<ResponseEntity<Room>> put(Long id, Room room) {
        return repository.findById(id).flatMap(existingRoom -> {
            room.setId(id);
            existingRoom = room;
            return repository.save(existingRoom);
        }).map(updatedRoom -> ResponseEntity.ok(updatedRoom)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

//Deletar Sala - gustavo
    public Mono<ResponseEntity<Void>> deleteById(Long id) {
        return repository.findById(id)
                .flatMap(existingProduct -> repository.delete(existingProduct)
                        .then(Mono.just(ResponseEntity.noContent().<Void>build())))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

//Buscar por ID - Ingrid
    public Mono<ResponseEntity<Room>> getId(Long id){
        return repository.findById(id).map(
                        room -> ResponseEntity.ok(room)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}