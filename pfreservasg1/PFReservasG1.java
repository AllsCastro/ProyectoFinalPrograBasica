/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;
//Esta interfaz permite que el usuario interactúe con el programa fácilmente sin necesidad de consola

public class PFReservasG1 {

    public static void main(String[] args) {
       // Mostrar la interfaz gráfica con botones
        javax.swing.SwingUtilities.invokeLater(() -> {
            InterfazSwingPrae interfaz = new InterfazSwingPrae();
            interfaz.setVisible(true);
            interfaz.setLocationRelativeTo(null); // Centrar ventana
        });
    }
} 