package com.ada.roomms.controller;

import com.ada.roomms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;

    }

//    @GetMapping
//    public Mono<RoomService> filterById(@RequestParam(""))

}
