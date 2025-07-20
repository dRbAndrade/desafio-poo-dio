import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var listaDevs = new HashSet<Dev>();
        var listaConteudos = new HashSet<Conteudo>();

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        listaConteudos.add(curso1);
        listaConteudos.add(curso2);
        listaConteudos.add(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.setConteudos(listaConteudos);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        devCamila.progredir();
        devCamila.progredir();

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        listaDevs.add(devCamila);
        listaDevs.add(devJoao);

        bootcamp.setDevsInscritos(listaDevs);

        var selection = 0;
        var scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao desafio Bootcamp Java Developer!");
        do {
            System.out.println();
            System.out.println("Selecione uma opção: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Informações do Bootcamp");
            System.out.println("2 - Inscrever-se no Bootcamp");
            System.out.println("3 - Listar inscritos no Bootcamp");
            selection = scanner.nextInt();
            switch (selection) {
                case 1: displayBootcampInfo(bootcamp); break;
                case 2: enrollInBootcamp(bootcamp); break;
                case 3: listEnrolledDevs(bootcamp); break;
            }
        }while (selection != 0);
        System.out.println("Obrigado por participar do nosso Bootcamp!");
        scanner.close();

    }

    static void displayBootcampInfo(Bootcamp bootcamp) {
        System.out.println("Nome: " + bootcamp.getNome());
        System.out.println("Descrição: " + bootcamp.getDescricao());
        System.out.println("Data inicial: " + bootcamp.getDataInicial());
        System.out.println("Data final: " + bootcamp.getDataFinal());
        System.out.println("Numero de inscritos: " + bootcamp.getDevsInscritos().size());
    }

    static void enrollInBootcamp(Bootcamp bootcamp) {
        System.out.println("Informe o nome do Dev: ");
        var devName = new Scanner(System.in).nextLine();
        var dev = new Dev();
        dev.setNome(devName);
        bootcamp.getDevsInscritos().add(dev);
        System.out.println("Dev " + dev.getNome() + " inscrito com sucesso!");
    }

    static void listEnrolledDevs(Bootcamp bootcamp) {
        System.out.println("Inscritos no Bootcamp: ");
        bootcamp.getDevsInscritos().forEach(System.out::println);
    }

}
