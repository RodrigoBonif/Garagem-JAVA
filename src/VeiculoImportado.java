public class VeiculoImportado extends Veiculo {
    public VeiculoImportado(String placa, String marca, String cor) {
        super(placa, marca, cor, "importado");
    }

    @Override
    public boolean validarCor(String cor) {
        return true;
    }
}
