package views;

import domain.model.*;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal extends JFrame{
    private JPanel mainPanel;
    private JLabel titulo;
    private JPanel panelCentral;
    private JTextField unidadesFuente;
    private JComboBox selectorMedidaFuente;
    private JTextField unidadesDestino;
    private JComboBox selectorMedidaDestino;

    public Principal(String title){
        super(title);
        this.rellenarSelectores();
        this.agregarListenersParaSelectores();
        this.agregarListenersParaInputs();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    private void agregarListenersParaInputs(){
        unidadesFuente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarMedidasEquivalentes();
            }
        });

        unidadesDestino.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarMedidasEquivalentes();
            }
        });
    }

    private void rellenarSelectores(){
        Object items[] = {kilometro.INSTANCE, metro.INSTANCE, centimetro.INSTANCE, milimetro.INSTANCE};
        for(Object item : items){
            this.selectorMedidaFuente.addItem(item);
            this.selectorMedidaDestino.addItem(item);
        }
    }


    private void agregarListenersParaSelectores(){
        selectorMedidaFuente.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    mostrarMedidasEquivalentes();
                }
            }
        });

        selectorMedidaDestino.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    mostrarMedidasEquivalentes();
                }
            }
        });
    }

    private void mostrarMedidasEquivalentes(){
        convertible unidadDeMedidaFuente  = (convertible) selectorMedidaFuente.getSelectedItem();
        convertible unidadDeMedidaDestino = (convertible) selectorMedidaDestino.getSelectedItem();
        String valorUnidadesFuente = unidadesFuente.getText();
        if(!valorUnidadesFuente.isEmpty()){
            Double unidades = new Double(valorUnidadesFuente);

            Double unidadesConvertidas = convertirUnidades(unidades, unidadDeMedidaFuente, unidadDeMedidaDestino);
            String detalleUnidadesConvertidas = String.format("%.2f", unidadesConvertidas);
            unidadesDestino.setText(detalleUnidadesConvertidas);
        }
    }

    private Double convertirUnidades(Double unidades, convertible medidaFuente, convertible medidaDestino){
        medidaFuente.cambiarUnidades(unidades);
        Double unidadesConvertidas = medidaFuente.convertirUnidadesA(medidaDestino);
        return unidadesConvertidas;
    }

}