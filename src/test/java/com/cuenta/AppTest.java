package com.cuenta;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    @Test
    public void cuentaTieneSaldoCero(){
        Cuenta cuenta = new Cuenta();
       
        assertTrue(cuenta.getSaldo() == 0.0);
    }

    /*
     * Sumen la quantitat ingressada al saldo.
    No hi ha comissions ni res per l'estil
     */

    @Test
    public void alIngresarSeSuma(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.0);
        assertTrue(cuenta.getSaldo() == 100.0);
    }

    @Test
    public void alIngresar3000ElSaldoEs3000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(3000.0);
        assertTrue(cuenta.getSaldo() == 3000.0);
    }

    @Test
    public void alIngresar3000EnUnaCuentaCon100ElSaldoEs3100(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.0);
        cuenta.ingresar(3000.0);
        assertTrue(cuenta.getSaldo() == 3100.0);
    }  

    /*
     * No es poden fer ingressos negatius
        Quan ingressem -100 en un compte buit, es saldo segueix sent 0
     */
    @Test
    public void noSePuedenHacerIngresosNegativos(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(-100.0);
        assertTrue(cuenta.getSaldo() == 0);
    }

//     Els ingressos admeten un màxim de 2 decimals de precisió
// Quan ingressem 100.45 en un compte buit, el saldo és de 100.45
    @Test
    public void esPodenIngresarAmbDecimals(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.23);
        assertTrue(cuenta.getSaldo() == 100.23);
    }

// Si ingressem 100.457 en un compte buit, el saldo és zero
    @Test
    public void siIngresemAmb3DecimalsElSaldoEsZero(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(100.233);
        assertTrue(cuenta.getSaldo() == 0);
    }


    /*
     * Si enviamos un numero con 3 decimales nos dira que tiene 3 decimales
     */
    @Test
    public void averiguarDecimales(){
        Cuenta cuenta = new Cuenta();
        assertTrue(cuenta.averiguarDecimales("100.333") == 3);
    }

    /*
     * La quantitat màxima que es pot ingressar és de 6000
        Si ingressem 6000.00 en un compte buit, el saldo és de 6000.00
        Si ingressem 6000.01 en un compte buit, el saldo és de 0
     */
    @Test
    public void laQuantitatMaximaQueEsPotIngresarEs6000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000.0);
        assertTrue(cuenta.getSaldo() == 6000.0);
    }

    @Test
    public void noPodemIngresarMesDe6000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000.01);
        assertTrue(cuenta.getSaldo() == 0.0);
    }

    /*
     * Retirades.
        Resten la quantitat que es passa com a paràmetre del saldo.
        No hi ha comissions ni res per l'estil.
        Quan retirem 100 en un compte amb 500, el saldo és 400
     */
    @Test
    public void quanRetirem100EnUnCompteAmb500ElSaldoEs400(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta.retirar(100.0);
        assertTrue(cuenta.getSaldo() == 400.0);
    }

    /*
     * No es pot retirar una quantitat major a la del saldo disponible.
      Si retirem 500 en un compte amb 200, no ocorre res i el saldo continua sent 200
     */
    @Test
    public void noEsPotRetiraUnaQuantMajorAlsaldo(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(200.0);
        cuenta.retirar(500.0);
        assertTrue(cuenta.getSaldo() == 200.0);
    }

    /*
     * No es poden retirar quantitats negatives
        Si retirem -100 en un compte amb 500, no ocorre res i el saldo continua sent 500
     */
    @Test
    public void noEsPotRetirarQuantitatsNegatives(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta.retirar(-100.0);
        assertTrue(cuenta.getSaldo() == 500.0);
    }

    /*
     * Les quantitats admeten un màxim de dos decimals de precisió
        Si retirem100.45 en un compte amb 500, el saldo és 399.55
     */
    @Test
    public void lesQuantitatsAdmentesUnMaximDeDosDeciamlsDePrecisio(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta.retirar(100.45);
        assertTrue(cuenta.getSaldo() == 399.55);
    }
    /*
     * Si retirem 100.457 en un compte amb 500, no ocorre res i el saldo continua sent 500
     */
    @Test
    public void siRetiremAmb3DecimalsNoOcorreRes(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta.retirar(100.457);
        assertTrue(cuenta.getSaldo() == 500.0);
    }

    /*
     * La quantitat màxima que es pot retirar és de 6000
        Si retirem 6000.00 d'un compte amb 7000, el saldo és de 1000
     */
    @Test
    public void laQuantMaximaQueEsPotRetirarEsDe6000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000.0);
        cuenta.ingresar(1000.0);
        cuenta.retirar(6000.0);
        assertTrue(cuenta.getSaldo() == 1000.0);
    }

    /*
     * Si retirem 6000.01 en un compte amb 7000, no ocurre nada i el saldo continua sent 7000
     */
    @Test
    public void siRetirem6000_01enUnCompteAmb7000NoOcurreNadaiElSaldoContinuaSent7000(){
        Cuenta cuenta = new Cuenta();
        cuenta.ingresar(6000.0);
        cuenta.ingresar(1000.0);
        cuenta.retirar(6000.01);
        assertTrue(cuenta.getSaldo() == 7000.0);
    }

    /*
     * Si fem una transferència de 100 des d'un compte amb 500 a un amb 50, en el primer compte el saldo serà de 400 i en la segona serà de 150
     */
    @Test
    public void siFemTransferenciaEsFaBe(){
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta2.ingresar(50.0);
        cuenta.transferir(cuenta2, 100.0);
        assertTrue(cuenta.getSaldo() == 400 && cuenta2.getSaldo() == 150.0);
    }

    /*
     * No es poden transferir quantitats negatives
Si fem una transferència de -100 des d'un compte amb 500 a un amb 50, els saldos es queden amb 500 i 50 respectivament
     */
    @Test
    public void noEsPodenTransferirQNegatives(){
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        cuenta.ingresar(500.0);
        cuenta2.ingresar(50.0);
        cuenta.transferir(cuenta2, -100.0);
        assertTrue(cuenta.getSaldo() == 500 && cuenta2.getSaldo() == 50.0);
    }

    /*
     * El límit de transferències en un mateix dia des d'un mateix compte és de 3000:
    queda Si fem una transferència de 3000 des d'un compte amb 3500 a un compte amb 50, en el primer compte el saldo rà en 500 i en el segon en 3050
     */
    @Test
    public void elLimitDeTransferenciesEnUnMateixDiaEsDe300(){
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        cuenta.ingresar(3500.0);
        cuenta2.ingresar(50.0);
        cuenta.transferir(cuenta2, 3000.0);
        assertTrue(cuenta.getSaldo() == 500 && cuenta2.getSaldo() == 3050.0);
    }

    /*
     * Si fem una transferència de 3000.01 des d'un compte amb 3500 a un compte amb 50, en el primer compte es quedaran 3500 i en el segon 50
     */
    @Test
    public void transferenciaMaxima3000(){
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        cuenta.ingresar(3500.0);
        cuenta2.ingresar(50.0);
        cuenta.transferir(cuenta2, 3000.01);
        assertTrue(cuenta.getSaldo() == 3500.0 && cuenta2.getSaldo() == 50.0);
    }

    /*
     * Si fem una transferència de 2000 des d'un compte amb 3500 a un compte amb 50 i just després una altra de 1200, en el primer compte el saldo quedarà en 1500 i en la segona en 2050
     */
    @Test
    public void maxim3000MateixDia(){
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        cuenta.ingresar(3500.0);
        cuenta2.ingresar(50.0);
        cuenta.transferir(cuenta2, 2000.0);
        cuenta.transferir(cuenta2, 1200.0);
        assertTrue(cuenta.getSaldo() == 1500.0 && cuenta2.getSaldo() == 2050.0);
    }

}

