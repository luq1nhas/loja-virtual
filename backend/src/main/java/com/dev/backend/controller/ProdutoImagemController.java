package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.service.ProdutoImagemService;

@RestController
@RequestMapping("/api/produtoImagem")
public class ProdutoImagemController {

  @Autowired
  private ProdutoImagemService produtoImagemService;

  @GetMapping("/")
  public List<ProdutoImagem> obterTodos() {
    return produtoImagemService.obterTodos();
  }

  @PostMapping("/")
  public ProdutoImagem inserir(@RequestBody ProdutoImagem produtoImagem) {
    return produtoImagemService.inserir(produtoImagem);
  }

  @PutMapping("/")
  public ProdutoImagem alterar(@RequestBody ProdutoImagem produtoImagem) {
    return produtoImagemService.alterar(produtoImagem);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
    produtoImagemService.excluir(id);
    return ResponseEntity.ok().build();
  }
}
