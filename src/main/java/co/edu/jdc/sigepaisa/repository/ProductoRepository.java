package co.edu.jdc.sigepaisa.repository;

import co.edu.jdc.sigepaisa.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByEstadoProductoTrue(); //trae los prudctos activos

    List<Producto> findByNombreContainingIgnoreCase(String nombre); //Busca por nombres sin importar mayusculas
}
