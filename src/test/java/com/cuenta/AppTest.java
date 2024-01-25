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
}

