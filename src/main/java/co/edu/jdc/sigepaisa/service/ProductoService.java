package co.edu.jdc.sigepaisa.service;

import co.edu.jdc.sigepaisa.entity.Producto;
import co.edu.jdc.sigepaisa.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listarActivos() {
        return productoRepository.findByEstadoProductoTrue();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el producto con id " + id));
    }

    @Transactional
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    public void desactivar(Integer id) {
        Producto producto = buscarPorId(id);
        producto.setEstadoProducto(false);
        productoRepository.save(producto);
    }
}
