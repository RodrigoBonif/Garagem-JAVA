import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public abstract class Veiculo implements VeiculoCRUDInterface {
    Connection connection = null;
    protected String placa;
    protected String marca;
    protected String cor;
    protected String tipo;

    public Veiculo(String placa, String marca, String cor, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.tipo = tipo;
        connection = crud.DatabaseManager.getDatabaseManager();
    }

    @Override
    public void create() throws Exception {
        String sql = "insert into veiculo(placa,marca,cor,tipo) values (?,?,?,?)";
        try {
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            pst.setString(1, this.placa);
            pst.setString(2, this.marca);
            pst.setString(3, this.cor);
            pst.setString(4, this.tipo);
            pst.executeUpdate();
            System.out.println("Veiculo Cadastrado");
        } catch (SQLException ex) {
            System.out.println("Veiculo Nao Cadastrado " + ex);
        }
    }

    public String read(String placa) {
        String sql = "SELECT * FROM veiculo WHERE placa = ?";
        try {
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            pst.setString(1, placa);
            ResultSet rst = pst.executeQuery();
            rst.next();
            String placaVeiculo = rst.getString(2);
            String marcaVeiculo = rst.getString(3);
            String corVeiculo = rst.getString(4);
            String tipoVeiculo = rst.getString(5);
            System.out.printf("Placa: %s Marca: %s Cor: %s Tipo: %s \n", placaVeiculo, marcaVeiculo, corVeiculo, tipoVeiculo);
            return placaVeiculo;
        } catch (SQLException se) {
            System.out.println("Erro ao Consultar Veiculo " + se);
            return "";
        }
    }

    public void readAll() {
        String sql = "SELECT id, placa, marca, cor, tipo FROM veiculo";
        try {
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                int id = rst.getInt(1);
                String placa = rst.getString(2);
                String marca = rst.getString(3);
                String cor = rst.getString(4);
                String tipo = rst.getString(5);
                System.out.printf("_______________________ \n");
                System.out.printf("Código: %d Placa: %s Marca: %s Cor: %s Tipo: %s \n", id, placa, marca, cor, tipo);
            }
        } catch (SQLException se) {
            System.out.println("Erro ao Consultar Veiculos " + se);
        }
    }

    public void update(String placaAntiga, String placa, String marca, String cor) throws Exception {
        String sql = "UPDATE veiculo SET placa = ?, marca = ?, cor = ? WHERE placa = ?";
        try {
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            pst.setString(1, placa);
            pst.setString(2, marca);
            pst.setString(3, cor);
            pst.setString(4, placaAntiga);
            int ret = pst.executeUpdate();

            if(ret > 0){
                System.out.println(String.format("Linhas afetadas %d", ret));
                System.out.printf("Registro alterado");
            }else{
                System.out.println("Não foi possível alterar o Registro do Veiculo");
            }
        }catch (SQLException se) {
            System.out.println("Erro ao Atualizar Veiculo " + se);
        }
    }

    @Override
    public void delete(String placa) {
        String sql = "DELETE FROM veiculo WHERE placa = ?";
        try {
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            pst.setString(1, placa);

            int ret = pst.executeUpdate();
            if(ret > 0){
                System.out.printf("Veiculo Excluido: %s ", placa);
            }else{
                System.out.println("Não foi possível Excluir o Registro do Veiculo");
            }
        } catch (SQLException se) {
            System.out.println("Erro em Excluir Veiculo " + se);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public abstract boolean validarCor(String cor);
}
