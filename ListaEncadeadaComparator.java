import java.util.Comparator;

public class ListaEncadeadaComparator <T> {
    private No<T> prim, ult;
    private int quantidade;
    private final boolean ordenada;
    private Comparator<T> comparador;

    public ListaEncadeadaComparator(boolean ehOrdenada, Comparator<T> comparador){
        this.prim=this.ult=null;
        this.quantidade=0;
        this.ordenada=ehOrdenada;
        this.comparador=comparador;
    }
    public String toString(){
        No<T> aux = this.prim;
        String s = "[";
        while(aux!=null){
            s+=aux.getValor();
            if(aux!=this.ult)
                s+=",";
            aux = aux.getProx();
        }
        return (s+"]");
    }

    public void adicionar(T elem){
        if (this.ordenada) {
            No<T> novo = new No(elem);
            No<T> atual, ant;
            atual = this.prim;
            ant = null;
            if (this.prim == null) {
                this.prim = novo;
                this.ult = novo;
            } else {
                while (atual != null && comparador.compare(atual.getValor(), elem) < 0) {
                    ant = atual;
                    atual = atual.getProx();
                }
                if (ant == null) {
                    novo.setProx(this.prim);
                    this.prim = novo;
                } else if (atual == null) {
                    this.ult.setProx(novo);
                    this.ult = novo;


                } else {
                    ant.setProx(novo);
                    novo.setProx(atual);
                }
            }
            this.quantidade++;
        }else{
            No<T> novo = new No(elem);
            if (this.prim==null){
                this.prim=novo;
                this.ult=novo;
            }
            else{
                this.ult.setProx(novo);
                this.ult=novo;
            }
            this.quantidade++;
        }
    }

    public boolean contemElemento(T valor){
        No<T> aux = this.prim;
        if (this.ordenada) {
            while (aux != null && comparador.compare(aux.getValor(), valor) <= 0) {
                if (comparador.compare(aux.getValor(), valor) == 0)
                    return true;
                aux = aux.getProx();
            }
            return false;
        }else{
            while(aux!=null){
                if (comparador.compare(aux.getValor(),valor)==0)
                    return true;
                aux = aux.getProx();
            }
            return false;
        }
    }

    public T pesquisar(T valor) {
        No<T> aux = this.prim;
        if (this.ordenada) {
            while (aux != null && comparador.compare(aux.getValor(), valor) <= 0) {
                if (comparador.compare(aux.getValor(), valor) == 0)
                    return aux.getValor();
                aux = aux.getProx();
            }
            return null;
        } else {
            while (aux != null) {
                if (comparador.compare(aux.getValor(), valor) == 0)
                    return aux.getValor();
                aux = aux.getProx();
            }
            return null;
        }
    }

    public T remover(T valor){
        No<T> aux = this.prim, ant = null;
        if (this.ordenada){
            while (aux != null && comparador.compare(aux.getValor(), valor) <= 0) {
                if (comparador.compare(aux.getValor(), valor) == 0){
                    if (aux == this.prim){
                        this.prim = this.prim.getProx();
                        if (aux == this.ult)
                            this.ult = null;
                        this.quantidade--;
                        return aux.getValor();


                    }else{
                        ant.setProx(aux.getProx());
                        if (aux==this.ult)
                            this.ult=ant;
                        this.quantidade--;
                        return aux.getValor();

                    }
                }
                ant=aux;
                aux = aux.getProx();
            }

        }else{
            while (aux != null) {
                if (comparador.compare(aux.getValor(), valor) == 0){
                    if (aux == this.prim){
                        this.prim = this.prim.getProx();
                        if (aux == this.ult)
                            this.ult = null;
                        this.quantidade--;
                        return aux.getValor();


                    }else{
                        ant.setProx(aux.getProx());
                        if (aux==this.ult)
                            this.ult=ant;
                        this.quantidade--;
                        return aux.getValor();

                    }
                }
                ant=aux;
                aux = aux.getProx();
            }

        }
        return null;
    }

}
