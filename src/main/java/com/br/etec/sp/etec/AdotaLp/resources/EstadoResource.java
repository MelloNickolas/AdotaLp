package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Estado;
import com.br.etec.sp.etec.AdotaLp.repository.EstadoRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.EstadoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/estado")
@CrossOrigin("*")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoreposiroty;

    @GetMapping()
    public List<Estado> listarestado(){
        return  estadoreposiroty.findAll();
    }

    @GetMapping("/dto")
    public Page<Estado> pesquisar(EstadoFilter estadofilter, Pageable pageable){
        return estadoreposiroty.Filtrar(estadofilter, pageable);
    }
}