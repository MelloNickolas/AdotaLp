package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Raca;
import com.br.etec.sp.etec.AdotaLp.repository.RacaRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.RacaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/raca")
@CrossOrigin("*")
public class RacaResource {

    @Autowired
    private RacaRepository racarepository;

    @GetMapping()
    public List<Raca> listarraca(){
        return racarepository.findAll();
    }

    @GetMapping("/dto")
    public Page<Raca> pesquisar(RacaFilter racafilter, Pageable pageable){
        return racarepository.Filtrar(racafilter, pageable);
    }

}