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

    public void InserirElemento (T elem){
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

    public void InserirElementoOrd(T elem){
        No<T> novo = new No(elem);
        No<T> atual, ant;
        atual = this.prim;
        ant=null;
        if (this.prim==null){
            this.prim=novo;
            this.ult=novo;
        }
        else{
            while(atual!=null && comparador.compare(atual.getValor(),elem)<0){
                ant=atual;
                atual=atual.getProx();
            }
            if(ant==null){
                novo.setProx(this.prim);
                this.prim=novo;
            } else if (atual==null) {
                this.ult.setProx(novo);
                this.ult=novo;

                
            }else {
                ant.setProx(novo);
                novo.setProx(atual);
            }
        }
        this.quantidade++;
    }

    public boolean contemElemento(T valor){
        No<T> aux = this.prim;
        while(aux!=null){
            if (comparador.compare(aux.getValor(),valor)==0)
                return true;
            aux = aux.getProx();
        }
        return false;
    }

    public T pesquisar(T valor) {
        No<T> aux = this.prim;
        while (aux != null) {
            if (comparador.compare(aux.getValor(), valor) == 0)
                return aux.getValor();
            aux = aux.getProx();
        }
        return null;
    }
}
