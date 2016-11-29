/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;
import iswtp5.model.DiaSemana;
import iswtp5.model.Negocio;
import iswtp5.model.Regla1;
import iswtp5.model.Regla2;
import iswtp5.model.Regla3;
import iswtp5.model.Regla4;
import iswtp5.model.Venta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Planos
 */
public class ISWTest {
    
    public ISWTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Negocio.Iniciar();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void comprobarRegla2ValoresEntre500Y1000Descuento3PorCiento(){
      //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 10);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(17.1, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla2ValoresEntre1000Y2500Descuento3PorCiento(){
      //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 40);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(103.5, descuento, 0.01);
    }
  
    @Test
    public void comprobarRegla2ValoresMayores2500Descuento6yMedioPorCiento(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 80);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(264.55, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla1DosProductosIgualesDePanderia(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 1);
      venta.AgregarDetalle(Negocio.Productos()[0], 1);
      Regla1 regla1 = new Regla1();
      double descuento =0;
      
      //Ejecución
      descuento = regla1.RealizarDescuento(venta);
      
      //Validación
        assertEquals(25, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla1TresProductosIgualesDePanderia(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 1);
      venta.AgregarDetalle(Negocio.Productos()[0], 2);
      Regla1 regla1 = new Regla1();
      double descuento =0;
      
      //Ejecución
      descuento = regla1.RealizarDescuento(venta);
      
      //Validación
        assertEquals(50, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla1VariosProductosIgualesDePanderia(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 1);
      venta.AgregarDetalle(Negocio.Productos()[0], 10);
      Regla1 regla1 = new Regla1();
      double descuento =0;
      
      //Ejecución
      descuento = regla1.RealizarDescuento(venta);
      
      //Validación
        assertEquals(50, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla3Entre2y5UnidadesDeUnProductoDeVoL(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[1], 3);
      Regla3 regla3 = new Regla3();
      double descuento =0;
      
      //Ejecución
      descuento = regla3.RealizarDescuento(venta);
      
      //Validación
        assertEquals(27, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla3Entre2y5UnidadesDeMasDeUNProductoDeVoL(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[1], 3);
      venta.AgregarDetalle(Negocio.Productos()[3], 1);
      venta.AgregarDetalle(Negocio.Productos()[3], 3);
      Regla3 regla3 = new Regla3();
      double descuento =0;
      
      //Ejecución
      descuento = regla3.RealizarDescuento(venta);
      
      //Validación
        assertEquals(81, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla3MasDe5UnidadesDeUnProductoDeVoL(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[1], 10);
      Regla3 regla3 = new Regla3();
      double descuento =0;
      
      //Ejecución
      descuento = regla3.RealizarDescuento(venta);
      
      //Validación
        assertEquals(36, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla4ComprasMenoresA1000(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 15);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla4 regla4 = new Regla4();
      double descuento =0;
      
      //Ejecución
      descuento = regla4.RealizarDescuento(venta);
      
      //Validación
        assertEquals(0, descuento, 0);
    }
    
    @Test
    public void comprobarRegla4ComprasSuperioresA1000ConProductosMenoresA3Unidades(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0],2);
      venta.AgregarDetalle(Negocio.Productos()[1],2);
      venta.AgregarDetalle(Negocio.Productos()[2],2);
      venta.AgregarDetalle(Negocio.Productos()[3],2);
      venta.AgregarDetalle(Negocio.Productos()[4],2);
      venta.AgregarDetalle(Negocio.Productos()[5],2);
      venta.AgregarDetalle(Negocio.Productos()[6],2);
      Regla4 regla4 = new Regla4();
      double descuento =0;
      
      //Ejecución
      descuento = regla4.RealizarDescuento(venta);
      
      //Validación
        assertEquals(0, descuento, 0.1);
    }
    
    @Test
    public void comprobarRegla4ComprasSuperioresA1000ConProductosMayoresA3Unidades(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 1);
      venta.AgregarDetalle(Negocio.Productos()[4], 1);
      venta.AgregarDetalle(Negocio.Productos()[4],20);
      Regla4 regla4 = new Regla4();
      double descuento =0;
      
      //Ejecución
      descuento = regla4.RealizarDescuento(venta);
      
      //Validación
        assertEquals(168, descuento, 0.1);
    }
}
