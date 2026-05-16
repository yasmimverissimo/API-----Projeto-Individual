package Atividade.ProjetoIndividual.controller;

import Atividade.ProjetoIndividual.entity.Cliente;
import Atividade.ProjetoIndividual.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    //Para Cadastrar Cliente
    @PostMapping
    public ResponseEntity<Cliente>cadastrar(@Valid @RequestBody Cliente cliente) {
        Cliente salvo = repository.save(cliente);
        return ResponseEntity.status(201).body(salvo);
    }
    // Para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    // Buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Para buscar cliente por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
        return repository.findByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Para buscar cliente pelo nome (parcial)
    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
        List<Cliente> clientes = repository.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(clientes);
    }

    // Para remover cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
