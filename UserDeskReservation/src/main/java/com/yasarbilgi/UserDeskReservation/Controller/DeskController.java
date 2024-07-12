package com.yasarbilgi.UserDeskReservation.Controller;

import com.yasarbilgi.UserDeskReservation.DTO.DeskDTO;
import com.yasarbilgi.UserDeskReservation.Service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desks")
public class DeskController {

    private final DeskService deskService;

    @Autowired
    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @PostMapping
    public ResponseEntity<DeskDTO> createDesk(@RequestBody DeskDTO deskDTO) {
        DeskDTO createdDesk = deskService.createDesk(deskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDesk);
    }

    @GetMapping("/{deskId}")
    public ResponseEntity<DeskDTO> getDeskById(@PathVariable Long deskId) {
        DeskDTO deskDTO = deskService.getDeskById(deskId);
        return ResponseEntity.ok(deskDTO);
    }

    @GetMapping
    public ResponseEntity<List<DeskDTO>> getAllDesks() {
        List<DeskDTO> desks = deskService.getAllDesks();
        return ResponseEntity.ok(desks);
    }

    @PutMapping("/{deskId}")
    public ResponseEntity<DeskDTO> updateDesk(@PathVariable Long deskId, @RequestBody DeskDTO updatedDesk) {
        DeskDTO deskDTO = deskService.updateDesk(deskId, updatedDesk);
        return ResponseEntity.ok(deskDTO);
    }

    @DeleteMapping("/{deskId}")
    public ResponseEntity<Void> deleteDesk(@PathVariable Long deskId) {
        deskService.deleteDesk(deskId);
        return ResponseEntity.noContent().build();
    }
}