package com.ada.roomms.controller;

import com.ada.roomms.enumeration.RoomTipos;
import com.ada.roomms.model.Room;
import com.ada.roomms.repository.RoomRepository;
import com.ada.roomms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return roomService.deleteById(id);
    }


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Room>> filterById(@PathVariable Long id){
        return roomService.getId(id);
    }

    @PostMapping
    public Mono<ResponseEntity<Room>> saveRoom(@RequestBody Room room){
        return roomService.saveRoom(room);
    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<Room>> atualizar(@PathVariable Long id, @RequestBody Room room) {
        return roomService.put(id, room);
    }

    @GetMapping("/search")
    public Flux<Room> consultNome(@RequestParam(required = false) String nome,
                                                  @RequestParam(required = false) RoomTipos tipo) {
        return roomService.consult(nome, tipo);
    }

    @GetMapping
    public Flux<Room> getAll() {
         return roomService.getAll();
    }
}
