package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> obterTodos() {
    return pessoaRepository.findAll();
  }

  public Pessoa inserir(Pessoa pessoa) {
    pessoa.setDataCriacao(new java.util.Date());
    return pessoaRepository.saveAndFlush(pessoa);
  }

  public Pessoa alterar(Pessoa pessoa) {
    pessoa.setDataAtualizacao(new java.util.Date());
    return pessoaRepository.saveAndFlush(pessoa);
  }

  public void excluir(Long id) {
    Pessoa pessoa = pessoaRepository.findById(id).get();
    pessoaRepository.delete(pessoa);
  }
}
