# 💰 Projeto Gerenciador Financeiro

Este é um sistema de **gerenciamento financeiro** desenvolvido em **Java Spring Boot**, com objetivo de controlar contas, lançamentos e centros de custo.  
O projeto foi desenvolvido como atividade prática da disciplina de Programação.

---

## 🚀 Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL / H2 (ambiente de testes)
- Swagger (documentação da API)
- JWT (autenticação)

---

## 📌 Funcionalidades
- Cadastro de Banco
- Cadastro de Conta
- Cadastro de Pessoa e Usuário
- Cadastro de Centro de Custo
- Registro de Lançamentos (Receitas e Despesas)
- Situação dos lançamentos (ABERTO ou BAIXADO)

---

## 🗂 Estrutura do Projeto
- `domains` → Entidades e Enums  
- `repositories` → Interfaces JPA  
- `services` → Regras de negócio  
- `controllers` → APIs REST  
- `resources` → Configurações (`application.properties`)

---

## 📊 Diagrama de Classes
![Diagrama](./docs/diagrama.png)

---

## 🔧 Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/ronanfAlves/gerenciado-financas.git
