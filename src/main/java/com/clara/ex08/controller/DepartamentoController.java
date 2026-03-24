package com.clara.ex08.controller;
import com.clara.ex08.models.DepartamentoModel;
import com.clara.ex08.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/departamentos")

public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> fornecedorModels = departamentoService.findAll();
        return ResponseEntity.ok().body(fornecedorModels);
    }

    @PostMapping
    ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamento) {
        DepartamentoModel requeste = departamentoService.criarDepartamento(departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento (@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarId(@PathVariable Long id) {
        return departamentoService.findById(id);
    }
}