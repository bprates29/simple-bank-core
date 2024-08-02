# Sistema Bancário Básico

## Descrição do Projeto
O projeto desenvolvido é um sistema bancário básico utilizando Java com o framework Spring Boot. O sistema permite gerenciar clientes, contas bancárias e transações. O modelo de negócio é composto por quatro classes principais: Pessoa, Cliente, Conta e Transacao.

- **Pessoa** é uma superclasse abstrata que define atributos básicos comuns a todos os tipos de pessoas no sistema.
- **Cliente** é uma subclasse de Pessoa que representa um cliente do banco, contendo informações adicionais específicas para clientes, como email e status de atividade.
- **Conta** representa uma conta bancária associada a um cliente, incluindo informações como saldo e número da conta.
- **Transacao** representa uma transação bancária, podendo ser um crédito (C) ou débito (D), com informações sobre o valor e descrição da transação.

## Diagrama de Classes

```plaintext
+----------------+            +--------------------+
|    Pessoa      |<--------->|    Cliente          |
+----------------+            +--------------------+
| - id: Integer  |            | - email: String    |
| - nome: String |            | - isAtivo: Boolean |
+----------------+            +--------------------+
                               ^
                               |
                               |
                            +-----------------------+
                            |     Conta             |
                            +-----------------------+
                            | - id: Integer         |
                            | - saldo: Double       |
                            | - numeroConta: String |
                            +-----------------------+
                               ^
                               |
                               |
                            +---------------------+
                            |   Transacao         |
                            +---------------------+
                            | - id: Integer       |
                            | - valor: Double     |
                            | - tipo: Enum(C, D)  |
                            | - descricao: String |
                            +---------------------+
```
## Configuração do Projeto

### Pré-requisitos
- **Java 17 ou superior** 
- **Maven**

## Executando o Projeto

Para compilar e executar o projeto, utilize o Maven:
```
./mvnw spring-boot:run
```

## Estrutura dos Arquivos de Dados

**cliente.txt**

```
1;João da Silva;joao.silva@example.com;true
2;Maria Oliveira;maria.oliveira@example.com;true
3;Carlos Pereira;carlos.pereira@example.com;false
```

**conta.txt**

```
1;1500.50;123456-7
2;2300.75;234567-8
3;320.00;345678-9
```

**transacoes.txt**

```
1;100.50;Pagamento de conta;1
2;200.00;Depósito;2
3;-50.75;Saque;1
4;300.00;Transferência;3
5;-150.00;Pagamento de fatura;2
```

## Contribuindo
1. Faça um fork do projeto

2. Crie uma branch para sua feature (git checkout -b feature/nova-feature)

3. Commit suas mudanças (git commit -am 'Adiciona nova feature')

4. Push para a branch (git push origin feature/nova-feature)

5. Crie um novo Pull Request