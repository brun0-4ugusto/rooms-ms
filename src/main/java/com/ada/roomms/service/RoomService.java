package com.ada.roomms.service;

import com.ada.roomms.enumeration.RoomTipos;
import com.ada.roomms.model.Room;
import com.ada.roomms.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomService {

    private RoomRepository repository;

//Cadastrar Sala - Lucas
    public Mono<ResponseEntity<Room>> saveRoom(Room room){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        return repository.save(room).map(room1 ->
                 ResponseEntity.created(uriComponentsBuilder.path("room/{id}").buildAndExpand(room1.getId()).toUri()).body(room1));
    }

//Listar Salas - Bruno
    public Flux<ResponseEntity<Room>> getAll() {
        return repository.findAll().map(room -> ResponseEntity.ok(room));
    }

//Consultar sala (livre) - Artur
    public Flux<ResponseEntity<Room>> consultNome(String nome) {
        return repository.findRoomByNomeContainingIgnoreCase(nome).map(room -> ResponseEntity.ok(room));
    }

//Consultar sala (livre) - Artur
    public Flux<ResponseEntity<Room>> consultTipo(RoomTipos tipo) {
        return repository.findRoomByTipoDeSala(tipo).map(room -> ResponseEntity.ok(room));
    }

//Alterar sala - Artur
    public Mono<ResponseEntity<Room>> put(UUID id, Room room) {
        return repository.findById(id).flatMap(existingRoom -> {
            room.setId(id);
            return repository.save(existingRoom);
        }).map(updatedRoom -> ResponseEntity.ok(updatedRoom)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

//Deletar Sala - gustavo
    public Mono<ResponseEntity<Void>> deleteById(UUID id) {
        return repository.findById(id)
                .flatMap(existingProduct -> repository.delete(existingProduct)
                        .then(Mono.just(ResponseEntity.noContent().<Void>build())))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

//Buscar por ID - Ingrid
    public Mono<ResponseEntity<Room>> getId(UUID id){
        return repository.findById(id).map(
                        room -> ResponseEntity.ok(room)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}