# 🛒 Spring-Pedido

> Microsserviço de gerenciamento de pedidos construído com Spring Boot.

---

## 📋 Sobre o Projeto

**Spring-Pedido** é uma API RESTful desenvolvida com **Spring Boot** para gerenciar o ciclo de vida de pedidos em um sistema de e-commerce ou plataforma de vendas. O serviço é responsável por criar, consultar, atualizar e cancelar pedidos, integrando-se com outros microsserviços da plataforma.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 17+ |
| Spring Boot | 3.x |
| Spring Data JPA | - |
| Spring Web | - |
| Spring Validation | - |

---

## 📁 Estrutura do Projeto

```
spring-pedido/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/pedido/
│   │   │   ├── controller/       # Endpoints REST
│   │   │   ├── service/          # Regras de negócio
│   │   │   ├── repository/       # Acesso a dados (JPA)
│   │   │   ├── model/            # Entidades JPA
│   │   │   ├── dto/              # Objetos de transferência
│   │   └── resources/
│   │       └── application.yml   # Configurações
├── pom.xml
└── README.md
```

---

## ⚙️ Configuração

### Pré-requisitos

- **Java 17+** instalado


---

## 📡 Endpoints da API

Base URL: `http://localhost:8080/api/pedidos`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/` | Lista todos os pedidos |
| `GET` | `/{id}` | Busca pedido por ID |
| `POST` | `/` | Cria um novo pedido |
| `PUT` | `/{id}` | Atualiza um pedido existente |
| `DELETE` | `/{id}` | Cancela/remove um pedido |





---

## 🤝 Contribuindo

1. Faça um **fork** do projeto
2. Crie uma branch para sua feature: `git checkout -b feature/minha-feature`
3. Commit suas alterações: `git commit -m 'feat: adiciona minha feature'`
4. Push para a branch: `git push origin feature/minha-feature`
5. Abra um **Pull Request**

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<p align="center">
  Feito com ☕ e Spring Boot
</p>
