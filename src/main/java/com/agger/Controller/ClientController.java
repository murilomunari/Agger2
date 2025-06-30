package com.agger.Controller;

import com.agger.DTO.ClientDTO;
import com.agger.Model.Client;
import com.agger.Service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> create(@Valid @RequestBody ClientDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(data));
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<Client>> findByCpf(@Valid @RequestBody String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByCpf(cpf));
    }
}
