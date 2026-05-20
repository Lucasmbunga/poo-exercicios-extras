package ao.universidade.poo.biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        Livro l1 = new Livro("Introdução a Java", "Ana Silva", "9781234567890");
        Livro l2 = new Livro("Estruturas de Dados", "Carlos Souza", "9780987654321");

        Aluno a1 = new Aluno("João Pereira", "2023001", "Engenharia Informática");
        Aluno a2 = new Aluno("Maria Costa", "2023002", "Sistemas de Informação");

        System.out.println("Estado inicial dos livros:");
        System.out.println(l1.info());
        System.out.println(l2.info());
        System.out.println();

        System.out.println("João tenta emprestar o livro 1:");
        boolean sucesso = a1.matricularLivro(l1);
        System.out.println("Empréstimo bem sucedido? " + sucesso);
        System.out.println(a1.mostrarEmprestimos());
        System.out.println(l1.info());
        System.out.println();

        System.out.println("Maria tenta emprestar o mesmo livro 1:");
        boolean sucesso2 = a2.matricularLivro(l1);
        System.out.println("Empréstimo bem sucedido? " + sucesso2);
        System.out.println(a2.mostrarEmprestimos());
        System.out.println(l1.info());
        System.out.println();

        System.out.println("João devolve o livro 1:");
        boolean devolvido = a1.devolverLivro(l1);
        System.out.println("Devolução efetuada? " + devolvido);
        System.out.println(a1.mostrarEmprestimos());
        System.out.println(l1.info());
        System.out.println();

        System.out.println("Agora Maria tenta novamente:");
        boolean sucesso3 = a2.matricularLivro(l1);
        System.out.println("Empréstimo bem sucedido? " + sucesso3);
        System.out.println(a2.mostrarEmprestimos());
        System.out.println(l1.info());
    }

}
