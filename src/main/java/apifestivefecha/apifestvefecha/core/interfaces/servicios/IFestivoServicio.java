package apifestivefecha.apifestvefecha.core.interfaces.servicios;

import java.util.List;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;

public interface IFestivoServicio {
// estos metodos estaran sujetos a modificacion estan por defecto

    public List<Festivos> listar();
 
    public Festivos obtener(int id);
 
    public List<Festivos> buscar(String nombre);
 
    public Festivos agregar(Festivos Festivos);
 
    public Festivos modificar(Festivos Festivos);
 
    public boolean eliminar(int id);
}
