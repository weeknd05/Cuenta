package com.cuenta;

import java.util.Date;

public class Cuenta {
    private Double saldo = 0.0;
    private Double totalTransferidoHoy = 0.0;
    private Date fechaUltimaTransferencia = null;
   

    /**
     * Función para ingresar
     * @param cantidad
     */
    public void ingresar (Double cantidad){
        if(cantidad > 0 && cantidad < Integer.MAX_VALUE){
            if(averiguarDecimales(cantidad.toString()) < 3){
                if(cantidad <= 6000){
                    this.saldo += cantidad;

                }else{
                    System.out.println("No se puede ingresar mas de 6000!");
                }

            }else {
                System.out.println("Cantidad no valida");
            }
        }else{
            System.out.println("Cantidad no valida");
        }
    }

    public void retirar(Double cantidad){
        if(this.saldo > 0.0 && saldo >= cantidad && cantidad > 0 && averiguarDecimales(cantidad.toString()) <3 &&cantidad <= 6000.0){
            this.saldo -= cantidad;
        }
    }

    public void transferir(Cuenta cuenta, Double cantidad){
        Date hoy = new Date();
        
        // Verificar si la última transferencia fue hoy o no
        if (fechaUltimaTransferencia == null || !isMismoDia(fechaUltimaTransferencia, hoy)) {
            totalTransferidoHoy = 0.0; // Resetear el contador si estamos en un nuevo día
            fechaUltimaTransferencia = hoy;
        }

        // Realizar la transferencia si no se excede el límite diario
        if (cantidad > 0.0 && (totalTransferidoHoy + cantidad) <= 3000.0) {
            this.saldo -= cantidad;
            cuenta.ingresar(cantidad);
            totalTransferidoHoy += cantidad;
        } else {
            System.out.println("Límite diario de transferencia excedido o cantidad inválida.");
        }
    }

    private boolean isMismoDia(Date fecha1, Date fecha2) {
        // Simplificada para propósitos de ejemplo, considerar usar Calendar para una comparación más precisa
        return fecha1.getYear() == fecha2.getYear() &&
               fecha1.getMonth() == fecha2.getMonth() &&
               fecha1.getDate() == fecha2.getDate();
    }









    public int averiguarDecimales(String numero) {
        if (numero.contains(".")) {
            String[] partes = numero.split("\\.");
            return partes[1].length();
        }
        return 0;
    }

    public Double getSaldo() {
        return this.saldo;
    }

  

    


}
