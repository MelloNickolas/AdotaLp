package com.br.etec.sp.etec.AdotaLp.repository.adocaodoacao;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdocaoDoacaoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDoacaoRepositoryImpl implements AdocaoDoacaoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<AdocaoDoacao> filtrar(AdocaoDoacaoFilter adocaodoacaofilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<AdocaoDoacao> criteria = builder.createQuery(AdocaoDoacao.class);
        Root<AdocaoDoacao> root = criteria.from(AdocaoDoacao.class);

        Predicate[] predicates = criarrestricoes(adocaodoacaofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("dataadocao")));

        TypedQuery<AdocaoDoacao> query = manager.createQuery(criteria);

        return  new PageImpl<>(query.getResultList(), pageable, total(adocaodoacaofilter));
    }

    private Long total(AdocaoDoacaoFilter adocaodoacaofilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<AdocaoDoacao> root = criteria.from(AdocaoDoacao.class);

        Predicate[] predicates = criarrestricoes(adocaodoacaofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("dataadocao")));

        criteria.select(builder.count(root));

        return  manager.createQuery(criteria).getSingleResult();
    }

    private void addrestricoesdepaginacao(TypedQuery<AdocaoDoacao> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totalresgistros = pageable.getPageSize();
        int primeiroregistrodepagina = paginaatual * totalresgistros;

        query.setFirstResult(primeiroregistrodepagina);
        query.setMaxResults(totalresgistros);
    }

    private Predicate[] criarrestricoes(AdocaoDoacaoFilter adocaodoacaofilter, CriteriaBuilder builder, Root root){

        List<Predicate> predicates = new ArrayList<>();

        // Mesmo erro da tabela de Animal
      
        if (adocaodoacaofilter.getDataadocao() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataadocao"), adocaodoacaofilter.getDataadocao()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
