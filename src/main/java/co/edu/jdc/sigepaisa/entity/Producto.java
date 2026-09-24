package co.edu.jdc.sigepaisa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "unidadmedida", nullable = false, length = 20)
    private String unidadMedida = "UNIDAD";

    @Column(name = "precioventa", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioVenta = BigDecimal.ZERO;

    @Column(name = "stockminimo", nullable = false, precision = 12, scale = 3)
    private BigDecimal stockMinimo = BigDecimal.ZERO;

    @Column(name = "requierefrio", nullable = false)
    private Boolean requiereFrio = false;

    @Column(name = "estadoproducto", nullable = false)
    private Boolean estadoProducto = true;

    public Producto() {
    }
    // getters y setters (Alt+Insert)

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigDecimal stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Boolean getRequiereFrio() {
        return requiereFrio;
    }

    public void setRequiereFrio(Boolean requiereFrio) {
        this.requiereFrio = requiereFrio;
    }

    public Boolean getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(Boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
}