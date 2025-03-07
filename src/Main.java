import lista.ListaEncadeada;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

//        lista.adiciona(1);
//        lista.adiciona(2);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adicionaFinal(0,3);
        lista.adicionaFinal(0,6);
        lista.adicionaFinal(1,5);
        lista.adicionaFinal(1,7);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        System.out.println(lista.buscaPosicao(3));

        lista.removeElemento(3);
        System.out.println(lista);
//        lista.removeElemento(0);
//        System.out.println(lista);
//        lista.removeElemento(0);
//        System.out.println(lista);
//        lista.removeElemento(0);
//        System.out.println(lista);
        lista.status();
    }
}