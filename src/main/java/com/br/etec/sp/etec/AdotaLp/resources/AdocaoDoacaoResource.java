package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.AdocaoDoacaoRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdocaoDoacaoFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdocaoDoacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/adocaodoacao")
@CrossOrigin("*")
public class AdocaoDoacaoResource {

    @Autowired
    private AdocaoDoacaoRepository adocaodoacaorepository;

    @GetMapping()
    public List<AdocaoDoacao> listaradocaodoacao(){
        return adocaodoacaorepository.findAll();
    }

    @GetMapping("/dto")
    public Page<AdocaoDoacaoDTO> pesquisar(AdocaoDoacaoFilter adocaodoacaofilter, Pageable pageable){
        return adocaodoacaorepository.filtrar(adocaodoacaofilter, pageable);
    }


    
}
