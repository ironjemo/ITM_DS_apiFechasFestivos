package apifestivefecha.apifestvefecha.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;




@Repository
public interface IFestivosRepositorio extends JpaRepository<Festivos,Integer> {
    
}
