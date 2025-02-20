package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.repository.ProdutoImagemRepository;

@Service
public class ProdutoImagemService {

  @Autowired
  private ProdutoImagemRepository produtoImagemRepository;

  public List<ProdutoImagem> obterTodos() {
    return produtoImagemRepository.findAll();
  }

  public ProdutoImagem inserir(ProdutoImagem produtoImagem) {
    produtoImagem.setDataCriacao(new java.util.Date());
    return produtoImagemRepository.saveAndFlush(produtoImagem);
  }

  public ProdutoImagem alterar(ProdutoImagem produtoImagem) {
    produtoImagem.setDataAtualizacao(new java.util.Date());
    return produtoImagemRepository.saveAndFlush(produtoImagem);
  }

  public void excluir(Long id) {
    ProdutoImagem produtoImagem = produtoImagemRepository.findById(id).get();
    produtoImagemRepository.delete(produtoImagem);
  }
}
