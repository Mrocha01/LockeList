# Lista Encadeada em Java

Este repositório contém a implementação de uma **Lista Encadeada Genérica** em Java, desenvolvida com o objetivo de praticar manipulação de estruturas dinâmicas de dados.

## 📌 Funcionalidades

- Adicionar elementos em qualquer posição da lista
- Remover elementos em qualquer posição da lista
- Buscar elementos por índice
- Verificar o tamanho da lista

## 🛠 Estrutura do Código

O projeto é composto pelos seguintes arquivos principais:

- **`No.java`** - Classe que representa um nó da lista, contendo um elemento genérico e a referência para o próximo nó.
- **`ListaEncadeada.java`** - Implementa a lógica da lista encadeada, incluindo os métodos de adição, remoção e busca.
- **`Main.java`** - Classe principal para testes da lista encadeada.

## 📜 Como Usar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. Acesse a pasta do projeto:
   ```sh
   cd nome-do-repositorio
   ```

3. Compile e execute o programa:
   ```sh
   javac Main.java
   java Main
   ```

## 📌 Exemplo de Uso

Exemplo de como adicionar e remover elementos da lista:

```java
ListaEncadeada<String> lista = new ListaEncadeada<>();
lista.adiciona("A");
lista.adiciona("B");
lista.adiciona("C");

lista.removeElemento(1); // Remove o elemento na posição 1 ("B")
```

## 🏗 Melhorias Futuras

- Implementação de um iterador para percorrer a lista
- Implementação de uma lista duplamente encadeada
- Conversão da lista para um array
