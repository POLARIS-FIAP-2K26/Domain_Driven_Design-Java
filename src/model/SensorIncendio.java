package model;
import abstracts.Sensor;
import interfaces.Monitoravel;

// Herança: SensorIncendio herda de Sensor e Implementa Monitoravel.
public class SensorIncendio extends Sensor implements Monitoravel {
    private double distanciaObstaculo;
    private boolean focoIncendio;

    public SensorIncendio(String idSensor, String localizacao, double distanciaObstaculo, boolean focoIncendio) {
        super(idSensor, localizacao);
        this.distanciaObstaculo = distanciaObstaculo;
        this.focoIncendio = focoIncendio;
    }

    // Sobrescrita do método abstrato.
    @Override
    public String processarLeitura() {
        String statusFogo = focoIncendio ? "FOGO DETECTADO!" : "Livre";
        return "Infra/Ultra [" + getIdSensor() + "]: Distância: " + distanciaObstaculo + "cm | Status: " + statusFogo;
    }

    // Implementação da interface.
    @Override
    public String verificarAlerta() {
        if (focoIncendio) {
            return "ALERTA CRÍTICO: Incêndio detectado em " + getLocalizacao() + "!";
        } else if (distanciaObstaculo < 10.0) {
            return "AVISO: Obstáculo muito próximo (" + distanciaObstaculo + "cm). Risco de colisão.";
        }
        return "Área segura.";
    }
}