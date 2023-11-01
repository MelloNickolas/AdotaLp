package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.CidadeRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.CidadeFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.CidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/cidade")
@CrossOrigin("*")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidaderepository;

    @GetMapping()
    public List<Cidade> listarcidade(){
        return  cidaderepository.findAll();
    }

    @GetMapping("/dto")
    public Page<CidadeDTO> pesquisar(CidadeFilter cidadefilter, Pageable pageable){
        return cidaderepository.Filtrar(cidadefilter, pageable);
    }
}
