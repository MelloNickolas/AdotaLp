package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdotanteDoadorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adotantedoador")
public class AdotanteDoadorResource {

    @Autowired
    private AdotanteDoadorRepository adotantedoadorrepository;

    @GetMapping()
    public Page<AdotanteDoador> pesquisar(AdotanteDoadorFilter adotantedoadorfilter, Pageable pageable){
        return  adotantedoadorrepository.Filtrar(adotantedoadorfilter, pageable);
    }

    @GetMapping("/todos")
    public List<AdotanteDoador> listaradotantedoador(){
        return adotantedoadorrepository.findAll();
    }
}
