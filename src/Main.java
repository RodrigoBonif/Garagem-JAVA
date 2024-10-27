import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Veiculo veiculoTemporario = new VeiculoNacional("", "", "vermelho");

        while (true) {
            System.out.println("1. Adicionar Veículo Nacional");
            System.out.println("2. Adicionar Veículo Importado");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Listar Veículo por placa");
            System.out.println("5. Excluir Veículo");
            System.out.println("6. Atualizar informações do veículo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Placa: ");
                    String placaNacional = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marcaNacional = scanner.nextLine();
                    System.out.print("Cor (vermelho, azul, amarelo): ");
                    String corNacional = scanner.nextLine();
                    try {
                        Veiculo veiculoNacional = new VeiculoNacional(placaNacional, marcaNacional, corNacional);
                        veiculoNacional.create();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Placa: ");
                    String placaImportado = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marcaImportada = scanner.nextLine();
                    System.out.print("Cor: ");
                    String corImportada = scanner.nextLine();
                    try {
                        Veiculo veiculoImportado = new VeiculoImportado(placaImportado, marcaImportada, corImportada);
                        veiculoImportado.create();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Lista de Veículos:");
                    veiculoTemporario.readAll();
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.print("Informe a placa do veiculo a ser consultado: ");
                    String placaConsulta = scanner.nextLine();
                    System.out.println("Veículo consultado: ");
                    veiculoTemporario.read(placaConsulta);
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.print("Informe a placa do veiculo a ser excluido: ");
                    String placaExclusao = scanner.nextLine();
                    veiculoTemporario.delete(placaExclusao);
                    System.out.println("\n");
                    break;

                case 6:
                    System.out.print("Informe a placa do veiculo a ser atualizado: ");
                    String placaAtualizacao = scanner.nextLine();
                    System.out.print("Nova placa: ");
                    String novaPlaca = scanner.nextLine();
                    System.out.print("Nova marca: ");
                    String novaMarca = scanner.nextLine();
                    System.out.print("Nova cor: ");
                    String novaCor = scanner.nextLine();
                    if (veiculoTemporario.getTipo() == "nacional") {
                        if (!veiculoTemporario.validarCor(novaCor)) {
                            System.out.println("Cor inválida");
                            break;
                        }
                    }
                    veiculoTemporario.update(placaAtualizacao, novaPlaca, novaMarca, novaCor);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente. \n");
                    break;
            }
        }
    }
}
