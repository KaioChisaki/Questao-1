import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op;
        ListaEncadeadaComparator<Aluno> listaOrdNome = new ListaEncadeadaComparator<Aluno>(true, new ComparadorAlunoNome());
        ListaEncadeadaComparator<Aluno> listaOrdMatricula = new ListaEncadeadaComparator<>(true, new ComparadorAlunoMatricula());

        System.out.println("""
                Bom Dia, o que deseja realizar?
                
                1)Cadastrar Aluno;
                2)Remover Aluno;
                3)Verificar se Aluno está na lista;
                4)Buscar Aluno na lista;
                5)Mostrar lista;
                0)Sair.""");
        op = scan.nextInt();
        while (op != 0) {
            if (op == 1) {
                int matricula;
                String nome;
                System.out.println("Digite a matricula: ");
                matricula = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o nome: ");
                nome = scan.nextLine();
                Aluno a = new Aluno(matricula, nome);
                listaOrdMatricula.adicionar(a);
                listaOrdNome.adicionar(a);
            }else
            if (op == 2) {
                int matricula;
                String nome;
                Aluno a1, a2;
                System.out.println("Digite a matricula: ");
                matricula = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o nome: ");
                nome = scan.nextLine();
                Aluno a = new Aluno(matricula, nome);
                a1 = listaOrdMatricula.remover(a);
                a2 = listaOrdNome.remover(a);
                if (a1 !=null && a2!= null){
                    System.out.println("Aluno removido");
                }else{
                    System.out.println("Aluno não existe na Lista");
                }
            }else if (op == 3) {
                int matricula;
                String nome;
                System.out.println("Digite a matricula: ");
                matricula = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o nome: ");
                nome = scan.nextLine();
                Aluno a = new Aluno(matricula, nome);
                if (listaOrdMatricula.contemElemento(a) && listaOrdNome.contemElemento(a)) {
                    System.out.println("Aluno Encontrado");
                }else{
                    System.out.println("Aluno não existe na lista");
                }

            }else if (op == 4) {
                int matricula;
                String nome;
                Aluno a1, a2;
                System.out.println("Digite a matricula: ");
                matricula = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o nome: ");
                nome = scan.nextLine();
                Aluno a = new Aluno(matricula, nome);
                a1 = listaOrdMatricula.pesquisar(a);
                a2 = listaOrdNome.pesquisar(a);
                if (a1 !=null && a2!= null){
                    System.out.println("Aluno Buscado");
                }else{
                    System.out.println("Aluno não existe na Lista");
                }
            }else if(op==5){
                System.out.println("Liste Ordenada por Nome: "+ listaOrdNome);
                System.out.println("Lista Ordenada por Matricula: " + listaOrdMatricula);
            }else {
                System.out.println("Opção Inexistente.\nDigite novamente.");
            }
            System.out.println("""
                Bom Dia, o que deseja realizar?
                
                1)Cadastrar Aluno;
                2)Remover Aluno;
                3)Verificar se Aluno está na lista;
                4)Buscar Aluno na lista;
                5)Mostrar lista;
                0)Sair.""");
            op = scan.nextInt();
        }
    }

}