public class VeiculoNacional extends Veiculo {
    private static final String[] CORES_PRIMARIAS = {"vermelho", "azul", "amarelo"};

    public VeiculoNacional(String placa, String marca, String cor) {
        super(placa, marca, cor, "nacional");
        if (!validarCor(cor)) {
            throw new IllegalArgumentException("Cor inválida para veículo nacional. \n");
        }
    }

    @Override
    public boolean validarCor(String cor) {
        for (String c : CORES_PRIMARIAS) {
            if (c.equalsIgnoreCase(cor)) {
                return true;
            }
        }
        return false;
    }
}
