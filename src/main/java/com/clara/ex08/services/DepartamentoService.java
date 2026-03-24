package com.clara.ex08.services;


import com.clara.ex08.models.DepartamentoModel;
import com.clara.ex08.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> findById(Long id){
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public void deletar(Long id){
       departamentoRepository.findById(id);
    }

    public DepartamentoModel atualizar(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel model = departamentoRepository.findById(id).get();
        model.setNome(departamentoModel.getNome());
        return departamentoRepository.save(model);
    }

}

