//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaEncadeadaComparator<Aluno> listaOrdNome = new ListaEncadeadaComparator<Aluno>(true,new ComparadorAlunoNome());
        ListaEncadeadaComparator<Aluno> listaOrdMatricula = new ListaEncadeadaComparator<>(true, new ComparadorAlunoMatricula());

        Aluno a1 = new Aluno(1, "Zé");
        Aluno a2 = new Aluno(2,"Mané");
        Aluno a3 = new Aluno(3, "Jojo");
        Aluno a4;

        listaOrdNome.InserirElementoOrd(a1);
        listaOrdMatricula.InserirElementoOrd(a1);
        listaOrdNome.InserirElementoOrd(a2);
        listaOrdMatricula.InserirElementoOrd(a2);
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
    }
}