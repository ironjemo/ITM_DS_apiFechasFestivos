package apifestivefecha.apifestvefecha.core.interfaces.servicios;

import java.util.List;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;

public interface IFestivoServicio {
// estos metodos estaran sujetos a modificacion estan por defecto

    public List<Festivos> listar();

    public Festivos buscar(int dia,int mes);
 
    public boolean aprobarFestivo(int dia,int mes);
    
   // Festivos buscarPorAnio(int anio);
}
