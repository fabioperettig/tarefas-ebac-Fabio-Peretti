package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class IClienteRepositoryCriteriaImpl implements IClienteRepositoryCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> buscaCriteria(String nome, String contato) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> querry = cb.createQuery(Cliente.class);
        Root<Cliente> cRoot = querry.from(Cliente.class);

        List<Predicate> predicateList = new ArrayList<>();

        if (nome != null && !nome.isEmpty()) {
            predicateList.add(cb.like(cRoot.get("nome"), "%" + nome + "%"));
        }
        if (contato != null && !contato.isEmpty()) {
            predicateList.add(cb.equal(cRoot.get("contato"), contato));
        }

        querry.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(querry).getResultList();
    }
}
