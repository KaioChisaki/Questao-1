public class No <T>{
    private T valor;
    private No prox;
    public No (T valor){
        this.valor= valor;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
