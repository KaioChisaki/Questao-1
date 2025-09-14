//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaEncadeadaComparator<Aluno> listaOrdNome = new ListaEncadeadaComparator<Aluno>(false,new ComparadorAlunoNome());
        ListaEncadeadaComparator<Aluno> listaOrdMatricula = new ListaEncadeadaComparator<>(false, new ComparadorAlunoMatricula());

        Aluno a1 = new Aluno(1, "Zé");
        Aluno a2 = new Aluno(2,"Mané");
        Aluno a3 = new Aluno(3, "Jojo");
        Aluno a4;
        Aluno a5;
        Aluno a6;

        listaOrdNome.adicionar(a1);
        listaOrdMatricula.adicionar(a1);
        listaOrdNome.adicionar(a2);
        listaOrdMatricula.adicionar(a2);
        listaOrdNome.adicionar(a3);
        listaOrdMatricula.adicionar(a3);
        if (listaOrdMatricula.contemElemento(a3)) {
            System.out.println("God Demais");
        }else{
            System.out.println("Paia demais");
        }
        if (listaOrdMatricula.contemElemento(a2)) {
            System.out.println("God Demais");
        }else{
            System.out.println("Paia demais");
        }
        a4 = listaOrdMatricula.pesquisar(a3);
        if (a4!=null) {
            System.out.println(a4);
        }else{
            System.out.println("Aluno não existe");
        }
        System.out.println("Lista ordenada por Nome: " + listaOrdNome);
        System.out.println("Lista ordenada por Matricula: " + listaOrdMatricula);
        a5 = listaOrdNome.remover(a2);
        System.out.println("Lista ordenada por Nome: " + listaOrdNome);
        System.out.println(a5);
        a6 = listaOrdMatricula.remover(a1);
        System.out.println("Lista ordenada por Matricula: " + listaOrdMatricula);
        System.out.println(a6);
    }
}