# 🐾 PetHealth – Sistema de Plano de Saúde Pet

## 📌 Sobre o projeto
O **PetHealth** é uma API REST desenvolvida com **Spring Boot** para gerenciar **tutores, pets e agendamentos de consultas veterinárias** baseada em problemas reais de em uma empresa de plano de saúde animal.  

👉 O sistema inclui:  
- CRUD completo de **Tutores** e **Pets**  
- Agendamento de consultas com **regras de negócio**:
  - **Carência de 30 dias** após cadastro do tutor  
  - Validação de **disponibilidade de horários** por mês  
- Integração com **Swagger/OpenAPI** para documentação interativa  
- Arquitetura baseada em **boas práticas e padrões de projeto**  

---

## ⚙️ Tecnologias utilizadas
- **Java 24**  
- **Spring Boot 3.5.x**  
  - Spring Web  
  - Spring Data JPA (Hibernate)  
  - Spring Validation  
- **H2 Database** (em memória, para testes)  
- **Lombok**  
- **Swagger / OpenAPI** (springdoc)  

---

## 🗂️ Estrutura do Projeto
```
src/main/java/com/pethealth
 ├── controller    # Endpoints REST
 ├── model         # Entidades JPA (Tutor, Pet, Agendamento)
 ├── repository    # Repositórios (Spring Data)
 ├── service       # Regras de negócio
 └── dto           # Objetos de transferência (DTOs)
```

---

## 🚀 Como rodar o projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/pethealth.git
cd pethealth
```

### 2. Rodar com Maven
```bash
mvn spring-boot:run
```

O servidor iniciará em:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 📖 Documentação da API
Acesse a documentação interativa do Swagger:  
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📬 Exemplos de uso

### Criar um Tutor
```http
POST /tutores
Content-Type: application/json

{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "dataCadastro": "2025-09-01"
}
```

### Criar um Pet
```http
POST /pets
Content-Type: application/json

{
  "nome": "Rex",
  "especie": "Cachorro",
  "tutorId": 1
}
```

### Agendar uma consulta
```http
POST /agendamentos
Content-Type: application/json

{
  "petId": 1,
  "dataConsulta": "2025-10-15T10:00:00"
}
```

⚠️ Caso o tutor ainda esteja em carência, o sistema retornará erro:
```json
{
  "error": "Tutor ainda está em carência, não pode agendar."
}
```

---

## 🌟 Habilidades demonstradas
- **Backend moderno com Spring Boot 3.5**  
- **Modelagem de domínio** (Tutores, Pets, Agendamentos)  
- **CRUD completo** com DTOs e validações  
- **Regras de negócio reais** (carência, disponibilidade mensal)  
- **Boas práticas** (camadas Controller, Service, Repository, DTO)  
- **Documentação clara e intuitiva com Swagger**  
- **Banco em memória (H2)** para facilitar testes  

---

## ✨ Próximos passos / Possíveis melhorias
- Autenticação e autorização com **Spring Security + JWT**  
- Integração com banco de dados relacional (PostgreSQL/MySQL)  
- Deploy em **Docker**  
- Testes unitários e de integração com **JUnit + Mockito**  

---

🔗 **Autor:** [João Pedro Pimenta](https://www.linkedin.com/in/joao-pedro-pimenta)
