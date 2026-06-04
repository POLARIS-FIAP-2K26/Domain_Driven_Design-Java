package abstracts;

// Classe abstrata que define a base estrutural para qualquer sensor do robô.
public abstract class Sensor {
    private String idSensor;
    private String localizacao;

    public Sensor(String idSensor, String localizacao) {
        this.idSensor = idSensor;
        this.localizacao = localizacao;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    // Método abstrato que força as subclasses a definirem como processam seus dados.
    public abstract String processarLeitura();
}