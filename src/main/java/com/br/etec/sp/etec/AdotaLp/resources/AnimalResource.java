package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AnimalRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/animal")
@CrossOrigin("*")
public class AnimalResource {

    @Autowired
    private AnimalRepository animalrepository;

    @GetMapping()
    public Page<AnimalDTO> pesquisar(AnimalFilter animalfilter, Pageable pageable){
        return animalrepository.Filtrar(animalfilter, pageable);
    }
    @GetMapping("/todos")
    public List<Animal> listaranimal(){
        return animalrepository.findAll();
    }
}
