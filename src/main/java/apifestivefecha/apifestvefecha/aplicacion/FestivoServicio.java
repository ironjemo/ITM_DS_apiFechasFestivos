package apifestivefecha.apifestvefecha.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;
import apifestivefecha.apifestvefecha.core.interfaces.repositorios.IFestivosRepositorio;
import apifestivefecha.apifestvefecha.core.interfaces.servicios.IFestivoServicio;

@Service
public class FestivoServicio implements IFestivoServicio{

    private IFestivosRepositorio repositorio;

     @Override
     public List<Festivos> listar() {
       return repositorio.findAll();
     }

     @Override
     public Festivos obtener(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
     }

     @Override
     public List<Festivos> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
     }

     @Override
     public Festivos agregar(Festivos Festivos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public Festivos modificar(Festivos Festivos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public boolean eliminar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
}
