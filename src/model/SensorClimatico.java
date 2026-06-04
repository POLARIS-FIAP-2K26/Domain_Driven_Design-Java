package model;
import abstracts.Sensor;
import interfaces.Monitoravel;

// Herança: SensorClimatico herda de Sensor.
public class SensorClimatico extends Sensor {
    private double temperatura;
    private double umidade;

    // Sobrecarga de Métodos: Construtor 1 (Inicializa zerado)
    public SensorClimatico(String idSensor, String localizacao) {
        super(idSensor, localizacao);
        this.temperatura = 0.0;
        this.umidade = 0.0;
    }

    // Sobrecarga de Métodos: Construtor 2 (Inicializa com valores)
    public SensorClimatico(String idSensor, String localizacao, double temperatura, double umidade) {
        super(idSensor, localizacao);
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public void atualizarLeitura(double temperatura, double umidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    // Sobrescrita do método abstrato.
    @Override
    public String processarLeitura() {
        return "Clima [" + getIdSensor() + "]: Temp: " + temperatura + "°C | Umid: " + umidade + "%";
    }
}