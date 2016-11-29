package iswtp5.model;

import java.util.ArrayList;

public class Regla1 implements IRegla {

    private static final double porcentaje = 0.5d;

    @Override
    public double RealizarDescuento(Venta venta) {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        ArrayList<LineaVenta> lineaVenta2 = new ArrayList<>();

        for (LineaVenta Detalle : venta.Detalle()) {
            if ("Panaderia".equals(Detalle.Producto.Rubro.Descripcion)) {
                boolean existe = true;
                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.Producto.Codigo == Detalle.Producto.Codigo) {
                        existe = false;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }
                if (existe) {
                    productos.add(new ProductoDescuento(Detalle.Producto));
                }
            }
        }
        for (ProductoDescuento productoDescuento : productos) {
            if (productoDescuento.Cantidad == 2) {
                descuento += productoDescuento.Producto.Precio * porcentaje;
            } else if (productoDescuento.Cantidad >= 3) {
                descuento += productoDescuento.Producto.Precio * porcentaje * 2;
            }
        }
        return descuento;
    }
}
