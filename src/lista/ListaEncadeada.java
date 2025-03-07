package lista;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    public void adiciona(T elemento) {
        No<T> celula = new No<T>(elemento); // proximo == null;

        if(this.tamanho == 0) {
            this.inicio = celula; // manter a referência do primeiro elemento;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula; // manter a referência do ultimo elemento;
        this.tamanho++;
    }

    public void limpa() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    private No<T> buscaPorNo(int posicao) {

        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posiçao nao existe.");
        }

        No<T> noAtual = this.inicio;

        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }

    public T buscaPosicao(int posicao) {
        return this.buscaPorNo(posicao).getElemento();
    }

    public String buscarElemento(T elemento) {

        int posicao = 0;

        for (No<T> atual = this.inicio; atual != null;) {

            if(atual.getElemento().equals(elemento)){
                return "Elemento encontrado! Posiçao: " + posicao;
            } else {
                atual = atual.getProximo();
                posicao++;
            }
        }
        return "elemento nao encontrado!";
    }

    public void adicionaFinal(int posicao, T elemento) {

        if(!(posicao >= 0 && posicao <= this.tamanho)){
            throw new IllegalArgumentException("Posiçao nao existe.");
        }

        if(this.tamanho == 0){
            this.adiciona(elemento);
        } else if (posicao == 0){
            No<T> celula = new No<T>(elemento, this.inicio);
            this.inicio = celula;
            this.tamanho++;
        } else if (posicao == this.tamanho) {
            this.adiciona(elemento);
        } else {
            No<T> noAnterior = this.buscaPorNo(posicao - 1);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public void removeElemento(int posicao) {

        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posiçao nao existe.");
        }

        if(posicao == 0) { // primeiro elemento;
            No<T> primeiro = this.inicio;
            No<T> proximo = primeiro.getProximo();
            primeiro.setElemento(null);
            primeiro.setProximo(null);
            this.inicio = proximo;

            if(this.tamanho == 1) {
                this.ultimo = null;
            }

            this.tamanho--;
        } else if(posicao == this.tamanho - 1){ // ultimo elemento;
            No<T> noAnterior = this.buscaPorNo(posicao - 1);
            this.ultimo.setElemento(null);
            this.ultimo = noAnterior;
            noAnterior.setProximo(null);
            this.tamanho--;
        } else {
            No<T> noAnterior = this.buscaPorNo(posicao - 1);
            No<T> noDesejado = noAnterior.getProximo();
            No<T> noProximo = noDesejado.getProximo();

            noDesejado.setElemento(null);
            noDesejado.setProximo(null);
            noAnterior.setProximo(noProximo);

            this.tamanho--;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void status() {
        System.out.println("Primeiro: " + this.inicio.getElemento());
        System.out.println("Ultimo: " + this.ultimo.getElemento());
        System.out.println("Ultima Posiçao: " + (this.tamanho - 1));
    }

    @Override
    public String toString() {
        if(this.tamanho == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }
}
