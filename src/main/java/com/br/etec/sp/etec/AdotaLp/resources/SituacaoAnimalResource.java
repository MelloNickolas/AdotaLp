package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.SituacaoAnimalRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.SituacaoAnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.SituacaoAnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/situacaoanimal")
@CrossOrigin("*")
public class SituacaoAnimalResource {

    @Autowired
    private SituacaoAnimalRepository situacaoanimalrepository;

    @GetMapping()
    public List<SituacaoAnimal> listarsituacaoanimal(){
        return situacaoanimalrepository.findAll();
    }

    @GetMapping("/dto")
    public Page<SituacaoAnimalDTO> pesquisar(SituacaoAnimalFilter situacaoAnimalFilter, Pageable pageable){
        return situacaoanimalrepository.Filtrar(situacaoAnimalFilter, pageable);
    }
}
