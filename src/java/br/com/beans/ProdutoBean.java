/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author gustavoscipiao
 */
@Named(value = "produtoBean")
@RequestScoped
public class ProdutoBean {

    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public void adicionarProduto() throws EntityNotFoundException, Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerceariaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ProdutoBean produto = new ProdutoBean();
        produto.setDescricao("CAFE");
        em.merge(produto);
        em.getTransaction().commit();
        em.close();

    }

}
