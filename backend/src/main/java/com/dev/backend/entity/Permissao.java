package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "permissao")
@Data
public class Permissao {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;

  @OneToMany(mappedBy = "permissao", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PermissaoPessoa> permissaoPessoas;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;

}
