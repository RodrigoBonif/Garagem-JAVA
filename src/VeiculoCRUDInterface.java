import java.util.List;

public interface VeiculoCRUDInterface {
    void create() throws Exception;
    String read(String placa);
    void readAll() throws Exception;
    void update(String placaAntiga, String placa, String marca, String cor) throws Exception;
    void delete(String placa) throws Exception;
}
