package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {

  @Autowired
  private PermissaoPessoaRepository permissaoPessoaRepository;

  public List<PermissaoPessoa> obterTodos() {
    return permissaoPessoaRepository.findAll();
  }

  public PermissaoPessoa inserir(PermissaoPessoa permissaoPessoa) {
    return permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
  }

  public PermissaoPessoa alterar(PermissaoPessoa permissaoPessoa) {
    return permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
  }

  public void excluir(Long id) {
    PermissaoPessoa permissaoPessoa = permissaoPessoaRepository.findById(id).get();
    permissaoPessoaRepository.delete(permissaoPessoa);
  }
}
