package apifestivefecha.apifestvefecha.core.interfaces.repositorios;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;

@Repository
public interface IFestivosRepositorio extends JpaRepository<Festivos, Integer> {

   @Query("SELECT s FROM Festivos s WHERE s.dia = :dia AND s.mes = :mes")
   Festivos findByDiaAndMes(int dia, int mes);
   
}