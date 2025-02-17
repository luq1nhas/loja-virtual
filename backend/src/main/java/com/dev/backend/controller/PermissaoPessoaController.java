package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.service.PermissaoPessoaService;

@RestController
@RequestMapping("/api/permissaopessoa")
public class PermissaoPessoaController {

  @Autowired
  private PermissaoPessoaService permissaoPessoaService;

  @GetMapping("/")
  public List<PermissaoPessoa> obterTodos() {
    return permissaoPessoaService.obterTodos();
  }

  @PostMapping("/")
  public PermissaoPessoa inserir(PermissaoPessoa permissaoPessoa) {
    return permissaoPessoaService.inserir(permissaoPessoa);
  }

  @PutMapping("/")
  public PermissaoPessoa alterar(PermissaoPessoa permissaoPessoa) {
    return permissaoPessoaService.alterar(permissaoPessoa);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(Long id) {
    permissaoPessoaService.excluir(id);
    return ResponseEntity.ok().build();
  }
}
