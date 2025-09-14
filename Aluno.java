public class Aluno implements Comparable<Aluno>{
    private String nome;
    private int matricula;

    public Aluno(int mat, String n){
        this.matricula = mat;
        this.nome= n;
    }

    public String toString(){
        return Integer.toString(this.matricula) + " - " + this.nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareTo(a.getNome());
    }
}
