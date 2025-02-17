package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;

  @Email(message = "E-mail inválido")
  @NotBlank(message = "E-mail é obrigatório")
  private String email;

  @CPF(message = "CPF inválido")
  @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
  @NotBlank(message = "CPF é obrigatório")
  private String cpf;

  @ManyToOne
  @JoinColumn(name = "idCidade")
  private Cidade cidade;

  private String senha;
  private String endereco;
  private String cep;

  @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PermissaoPessoa> permissaoPessoas;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;
}
