import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Passeio> listaPasseio = new ArrayList<>(5);
    public static ArrayList<Carga> listaCarga = new ArrayList<>(5);

    private static boolean verificarPlacaPasseio(String placa, ArrayList<Passeio> lista){

        for(int i=0;i<lista.size();i++) {
            if (placa.equalsIgnoreCase(lista.get(i).getPlaca())) {
                return true;
            }
        }
        return false;
    }
    private static boolean verificarPlacaCarga(String placa, ArrayList<Carga> listaC){
        if(!listaC.isEmpty()){
            for(int i=0;i<= listaC.size();i++) {
                if (placa.equalsIgnoreCase(listaC.get(i).getPlaca())) {
                    return true;
                }
            }}
        return false;
    }
    public static void main(String[] args) {
        menu();

    }
    private static void menu() {
        boolean programaConcluido = false;
        int opcao;
        do {
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial" +
                    "\n1. Cadastrar Veiculo de Passeio" +
                    "\n2. Cadastrar Veiculo de Carga" +
                    "\n3. Imprimir Todos os Veiculos de Passeio" +
                    "\n4. Imprimir Todos os Veiculos de Carga" +
                    "\n5. Imprimir Veiculo de Passeio pela Placa" +
                    "\n6. Imprimir Veiculo de Carga pela Placa" +
                    "\n7. Sair do Sistema");

            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarCarroPasseio(listaPasseio,listaCarga);
                    break;
                case 2:
                    cadastrarCarroCarga(listaPasseio,listaCarga);
                    break;
                case 3:
                    imprimirCarroPasseio(listaPasseio);
                    break;
                case 4:
                    imprimirCarroCarga(listaCarga);
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("digite a placa do carro de passeio que deseja consultar: ");
                    String placaPasseio = scan.nextLine();
                    imprimirCarrosPasseioPelaPlaca(listaPasseio,placaPasseio);
                    break;
                case 6:
                    scan.nextLine();
                    System.out.println("digite a placa do carro de Carga que deseja consultar:");
                    String placaCarga = scan.nextLine();
                    imprimirCarrosCargaPelaPlaca(listaCarga,placaCarga);
                    break;
                case 7:
                    programaConcluido = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!programaConcluido);
    }

    private static void imprimirCarrosPasseioPelaPlaca(ArrayList<Passeio> listaPasseio,String placa) {
        boolean carroCadastrado = false;
        for(Passeio p : listaPasseio){
            if(p.getPlaca().equalsIgnoreCase(placa)){
                carroCadastrado=true;
                System.out.println("______________________________________\nVeiculo Passeio {\n quantidade de passageiros:"+p.getQtdPassageiros()+"\n placa: "+
                        p.getPlaca()+"\n marca:"+p.getMarca()+"\n modelo:"+ p.getModelo()+"\n cor:"+ p.getCor()+"\n" +
                        " velocidade máxima:"+p.getVelocMax()+"\n quantidade de rodas:"+ p.getQtdRodas()+"\ncalculo: "+p.calcular()+"\n MOTOR\n"+"quantidade de pistões:"+
                        p.getMotor().getQtdPist()+"\npotência:"+p.getMotor().getPotencia()+"\n______________________________________");
            }
        }
        if(carroCadastrado){
            menu();
        }
        else{
            boolean opcaoValida=false;
            do {
                System.out.println("Carro não cadastrado no sistema, deseja consultar outro carro? [1]SIM [2]NÃO");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite a placa do carro de passeio:");
                        String placaConsulta = scan.nextLine();
                        opcaoValida=true;
                        imprimirCarrosPasseioPelaPlaca(listaPasseio, placaConsulta);
                        break;
                    case 2:
                        opcaoValida=true;
                        menu();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }while(opcaoValida);
        }
    }
    private static void imprimirCarrosCargaPelaPlaca(ArrayList<Carga> listaCarga,String placa) {
        boolean carroCadastrado = false;
        for(Carga p : listaCarga){
            if(p.getPlaca().equalsIgnoreCase(placa)){
                carroCadastrado=true;
                System.out.println("Veiculo Carga {\n carga máxima:"+p.getCargaMax()+"\ntara:"+p.getTara()+"\n placa: "+
                        p.getPlaca()+"\n marca:"+p.getMarca()+"\n modelo:"+ p.getModelo()+"\n cor:"+ p.getCor()+"\n" +
                        " velocidade máxima:"+p.getVelocMax()+"\n quantidade de rodas:"+ p.getQtdRodas()+"\ncalculo: "+p.calcular()+"\n MOTOR\n"+"quantidade de pistões:"+
                        p.getMotor().getQtdPist()+"\npotência:"+p.getMotor().getPotencia()+"______________________________________");
            }
        }
        if(carroCadastrado){
            menu();
        }
        else{
            boolean opcaoValida=false;
            do {
                System.out.println("Carro não cadastrado no sistema, deseja consultar outro carro? [1]SIM [2]NÃO");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite a placa do carro de carga:");
                        String placaConsulta = scan.nextLine();
                        opcaoValida=true;
                        imprimirCarrosCargaPelaPlaca(listaCarga,placaConsulta);
                        break;
                    case 2:
                        opcaoValida=true;
                        menu();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }while(opcaoValida);
        }
    }

    private static void imprimirCarroCarga(ArrayList<Carga> listaCarga) {
        if(!listaCarga.isEmpty()) {
            for (Carga p: listaCarga) {
                System.out.println("Veiculo Carga {\n carga máxima:"+p.getCargaMax()+"\ntara:"+p.getTara()+"\n placa: "+
                        p.getPlaca()+"\n marca:"+p.getMarca()+"\n modelo:"+ p.getModelo()+"\n cor:"+ p.getCor()+"\n" +
                        " velocidade máxima:"+p.getVelocMax()+"\n quantidade de rodas:"+ p.getQtdRodas()+"\n MOTOR\n"+"quantidade de pistões:"+
                        p.getMotor().getQtdPist()+"\npotência:"+p.getMotor().getPotencia()+"______________________________________");
            }
        }
        else{
            System.out.println("não há carros de carga cadastrados");
        }
    }

    private static void imprimirCarroPasseio(ArrayList<Passeio> listaPasseio) {
        if(!listaPasseio.isEmpty()) {
            for (Passeio p: listaPasseio) {
                System.out.println("Veiculo Passeio {\n quantidade de passageiros:"+p.getQtdPassageiros()+"\n placa: "+
                        p.getPlaca()+"\n marca:"+p.getMarca()+"\n modelo:"+ p.getModelo()+"\n cor:"+ p.getCor()+"\n" +
                        " velocidade máxima:"+p.getVelocMax()+"\n quantidade de rodas:"+ p.getQtdRodas()+"\n MOTOR\n"+"quantidade de pistões:"+
                        p.getMotor().getQtdPist()+"\npotência:"+p.getMotor().getPotencia()+"\n______________________________________");
            }
        }
        else{
            System.out.println("não há carros de passeio cadastrados");
        }
    }

    private static void cadastrarCarroCarga(ArrayList<Passeio> listaPasseio, ArrayList<Carga> listaCarga) {
        if (listaCarga.size()<5) {
            scan.nextLine();
            System.out.println("Digite a placa do veiculo: ");
            String placaCarga = scan.nextLine();
            if(!verificarPlacaCarga(placaCarga,listaCarga)) {
                System.out.println("Digite a carga do veiculo: ");
                int carga = scan.nextInt();
                System.out.println("Digite a tara:");
                int tara = scan.nextInt();
                System.out.println("Digite a marca:");
                String marcaCarga = scan.nextLine();
                System.out.println("digite o modelo:");
                String modeloCarga = scan.nextLine();
                System.out.println("Digite a cor:");
                String corCarga = scan.nextLine();
                System.out.println("Digite a velocidade maxima do veiculo (em km/h):");
                float velocidadeMaxCarga = scan.nextFloat();
                System.out.println("Digite a quantidade de rodas:");
                int qtdRodasCarga = scan.nextInt();
                System.out.println("Digite a quantidade de pistões:");
                int qtdPistoesCarga = scan.nextInt();
                System.out.println("Digite a potência:");
                int potenciaCarga = scan.nextInt();
                Motor motorCarga = new Motor(qtdPistoesCarga, potenciaCarga);
                Carga carroCarga = new Carga(carga, tara, placaCarga, marcaCarga, modeloCarga, corCarga, velocidadeMaxCarga, qtdRodasCarga, motorCarga);
                listaCarga.add(carroCarga);
                if(listaCarga.size()<5) {
                    System.out.println("deseja cadastrar mais um carro de carga? [1]SIM [2]NÃO");
                    int opcaoCadastrar = scan.nextInt();
                    switch (opcaoCadastrar) {
                        case 1:
                            cadastrarCarroCarga(listaPasseio, listaCarga);
                            break;
                        case 2:
                            menu();
                            break;
                    }
                }
            }
            else{
                System.out.println("placa já está registrada no sistema");
            }
        }else{
            System.out.println("quantidade máxima de carros de carga atingida");
        }
        menu();
    }

    private static void cadastrarCarroPasseio(ArrayList<Passeio> listaPasseio,ArrayList<Carga> listaCarga) {
        if(listaPasseio.size()<5) {
            scan.nextLine();
            System.out.println("Digite a placa do veiculo: ");
            String placa = scan.nextLine();
            if(!verificarPlacaPasseio(placa,listaPasseio)) {
                System.out.println("Digite a marca:");
                String marca = scan.nextLine();
                System.out.println("digite o modelo:");
                String modelo = scan.nextLine();
                System.out.println("Digite a cor:");
                String cor = scan.nextLine();
                System.out.println("Digite a velocidade maxima do veiculo (em km/h):");
                float velocidadeMax = scan.nextFloat();
                System.out.println("Digite a quantidade de rodas:");
                int qtdRodas = scan.nextInt();
                System.out.println("Digite a quantidade de pistões:");
                int qtdPistoes = scan.nextInt();
                System.out.println("Digite a potência:");
                int potencia = scan.nextInt();
                System.out.println("Digite a quantidade de passsageiros: ");
                int quantPassageiros = scan.nextInt();
                Motor motorPasseio = new Motor(qtdPistoes, potencia);
                Passeio carroPasseio = new Passeio(quantPassageiros, placa, marca, modelo, cor, velocidadeMax, qtdRodas, motorPasseio);
                listaPasseio.add(carroPasseio);
                if(listaPasseio.size()<5) {
                System.out.println("deseja cadastrar mais um carro de passeio? [1]SIM [2]NÃO");
                int opcaoCadastrar = scan.nextInt();
                    switch (opcaoCadastrar) {
                        case 1:
                            cadastrarCarroPasseio(listaPasseio, listaCarga);
                            break;
                        case 2:
                            menu();
                            break;
                    }
                }
            }else{
                System.out.println("placa já está registrada no sistema");
            }
        }else{
            System.out.println("Quantidade Maxima de carros de passeio atingida");
        }
        menu();
    }
}
