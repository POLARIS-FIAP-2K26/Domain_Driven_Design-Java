package app;
import model.SensorClimatico;
import model.SensorIncendio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Interação com o usuário via Swing.
public class WallEDashboard extends JFrame {

    private JTextField txtTemperatura, txtUmidade, txtDistancia;
    private JCheckBox chkFogo;
    private JTextArea txtConsole;

    public WallEDashboard() {
        setTitle("Wall-E - Dashboard de Monitoramento (ODS 9)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Entrada de Dados (Simulando leituras do ESP32)
        JPanel painelInputs = new JPanel(new GridLayout(5, 2, 5, 5));
        painelInputs.setBorder(BorderFactory.createTitledBorder("Simulador de Leituras do ESP32"));

        painelInputs.add(new JLabel("Temperatura (°C):"));
        txtTemperatura = new JTextField();
        painelInputs.add(txtTemperatura);

        painelInputs.add(new JLabel("Umidade (%):"));
        txtUmidade = new JTextField();
        painelInputs.add(txtUmidade);

        painelInputs.add(new JLabel("Distância Obstáculo (cm):"));
        txtDistancia = new JTextField();
        painelInputs.add(txtDistancia);

        painelInputs.add(new JLabel("Sensor Infravermelho (Fogo):"));
        chkFogo = new JCheckBox("Fogo Detectado");
        painelInputs.add(chkFogo);

        JButton btnProcessar = new JButton("Processar Dados do Robô");
        painelInputs.add(btnProcessar);

        add(painelInputs, BorderLayout.NORTH);

        // Painel de Log/Console
        txtConsole = new JTextArea();
        txtConsole.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtConsole);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console de Monitoramento"));
        add(scrollPane, BorderLayout.CENTER);

        // Ação do Botão
        btnProcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarLeituras();
            }
        });
    }

    private void processarLeituras() {
        try {
            double temp = Double.parseDouble(txtTemperatura.getText());
            double umid = Double.parseDouble(txtUmidade.getText());
            double dist = Double.parseDouble(txtDistancia.getText());
            boolean fogo = chkFogo.isSelected();

            // Instanciando os objetos (Modelagem Orientada a Objetos)
            SensorClimatico clima = new SensorClimatico("DHT-11", "Módulo Superior", temp, umid);
            SensorIncendio incendio = new SensorIncendio("US-IR-01", "Chassi Frontal", dist, fogo);

            // Exibindo no Console
            txtConsole.append("--- Nova Leitura ---\n");
            txtConsole.append(clima.processarLeitura() + "\n");
            txtConsole.append(incendio.processarLeitura() + "\n");
            txtConsole.append("Status Alerta: " + incendio.verificarAlerta() + "\n\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos nas leituras.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Inicializando o Swing na thread correta
        SwingUtilities.invokeLater(() -> {
            new WallEDashboard().setVisible(true);
        });
    }
}