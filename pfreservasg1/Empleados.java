/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;

class Empleados {
        // Arreglo para almacenar los ID de los empleados ingresados por el usuario
    private int[] id;

    // Arreglo para almacenar los nombres de los empleados ingresados por el usuario
    private String[] nombre;

    // Arreglo para almacenar los departamentos de los empleados ingresados por el usuario
    private String[] departamento;

    // Contador que indica cuántos empleados se han registrado
    private int contador;

    // Arreglos estáticos que contienen empleados pre-cargados desde el inicio del sistema
    private static int[] staticId = {1414, 1212, 1313, 1515};
    private static String[] staticNombre = {"Josué", "Fabian", "Allison", "Joel"};
    private static String[] staticDepartamento = {"Desarrollo Software", "Soporte Tecnico", "Administración Bases", "Seguridad"};

    // Constructor: Inicializa los arreglos vacíos y el contador en cero
    public Empleados() {
        id = new int[0];
        nombre = new String[0];
        departamento = new String[0];
        contador = 0;
    }

    // Método para definir cuántos empleados desea registrar el usuario
    public void definirCantidadEmpleados() {
        int cantidadEmpleados = 0;
        while (cantidadEmpleados <= 0) {
            try {
             String input = JOptionPane.showInputDialog("¿Cuántos empleados desea registrar?");
             if (input == null || input.trim().equals("")) {
               JOptionPane.showMessageDialog(null, "Operación cancelada.");
               return;
            }
            cantidadEmpleados = Integer.parseInt(input);
 
            } catch (NumberFormatException e) {
                // Si el usuario digita texto o caracteres inválidos, se muestra este mensaje de error
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }

        // Se inicializan los arreglos con el tamaño que el usuario indicó
        id = new int[cantidadEmpleados];
        nombre = new String[cantidadEmpleados];
        departamento = new String[cantidadEmpleados];
        contador = 0; // Reinicia el contador por si ya había registros anteriores
    }

    // Método que permite registrar los datos de cada empleado
    public void registroEmpleados() {
        while (contador < id.length) {
            // Solicita el ID del empleado y valida que sea numérico
            String idInput = JOptionPane.showInputDialog("Ingrese ID del empleado(a) " + (contador + 1) + ":");
            if (idInput == null || idInput.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
            continue;
            }
            if (idInput.matches("[0-9]+")) {
                int nuevoId = Integer.parseInt(idInput);

                // Verifica que el ID no se repita
                boolean idExiste = false;
                for (int i = 0; i < staticId.length; i++) {
                    if (staticId[i] == nuevoId) {
                        idExiste = true;
                        break;
                    }
                }

                if (idExiste) {
                    JOptionPane.showMessageDialog(null, "Error: El ID ya está registrado.");
                    continue; // Repite el ciclo si el ID ya existe
                }

                id[contador] = nuevoId;

                // Solicita el nombre del empleado y valida que no esté vacío
                String nombreInput = "";
                while (nombreInput == null || nombreInput.trim().equals("")) {
                    nombreInput = JOptionPane.showInputDialog("Ingrese el Nombre del empleado(a) " + (contador + 1) + ":");
                    if (nombreInput == null || nombreInput.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                    }
                }
                nombre[contador] = nombreInput;

                // Solicita el departamento del empleado y valida que no esté vacío
                String departamentoInput = "";
                while (departamentoInput == null || departamentoInput.trim().equals("")) {
                    departamentoInput = JOptionPane.showInputDialog("Ingrese Departamento en que trabaja el empleado(a) " + (contador + 1) + ":");
                    if (departamentoInput == null || departamentoInput.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "El departamento no puede estar vacío.");
                    }
                }
                departamento[contador] = departamentoInput;

                contador++; // Aumenta el contador tras un registro exitoso
            } else {
                JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número válido.");
            }
        }
    }

    // Método para mostrar los empleados que el usuario ha registrado recientemente
    public void mostrarEmpleados() {
        StringBuilder resultado = new StringBuilder ("Lista de todos los empleados: \n\n");
        
        for (int i = 0; i < staticId.length; i++) {
            resultado.append("ID: ").append(staticId[i])
                    .append(", Nombre: ").append(staticNombre[i])
                    .append(", Departamento: ").append(staticDepartamento[i])
                    .append("\n");
        }

        for (int i = 0; i < contador; i++) {
            resultado.append("ID: ").append(id[i])
                    .append(", Nombre: ").append(nombre[i])
                    .append(", Departamento: ").append(departamento[i])
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    // Método que elimina un empleado según su ID
    public boolean eliminarEmpleado(int idBuscar) {
        for (int i = 0; i < contador; i++) {
            if (id[i] == idBuscar) {
                // Si encuentra el ID, mueve los datos siguientes una posición atrás para eliminar al empleado
                for (int j = i; j < contador - 1; j++) {
                    id[j] = id[j + 1];
                    nombre[j] = nombre[j + 1];
                    departamento[j] = departamento[j + 1];
                }

                // Limpia el último espacio del arreglo
                id[contador - 1] = 0;
                nombre[contador - 1] = null;
                departamento[contador - 1] = null;

                contador--; // Reduce el número de empleados registrados
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
                return true; // Retorna verdadero si se eliminó exitosamente
            }
        }
        // Para eliminar tambien los empleados pre-cargados
       for (int i = 0; i < staticId.length; i++) {
        if (staticId[i] == idBuscar) {
            for (int j = i; j < staticId.length - 1; j++) {
                staticId[j] = staticId[j + 1];
                staticNombre[j] = staticNombre[j + 1];
                staticDepartamento[j] = staticDepartamento[j + 1];
            }
            staticId[staticId.length - 1] = 0;
            staticNombre[staticNombre.length - 1] = null;
            staticDepartamento[staticDepartamento.length - 1] = null;
            JOptionPane.showMessageDialog(null, "Empleado pre-cargado eliminado correctamente.");
            return true;
        }
    } 
        // Si no encuentra el ID, lo notifica al usuario
        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        return false; // No se pudo eliminar
    }
}
