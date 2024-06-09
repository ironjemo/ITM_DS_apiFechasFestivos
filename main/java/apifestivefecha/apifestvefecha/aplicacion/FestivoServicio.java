package apifestivefecha.apifestvefecha.aplicacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;
import apifestivefecha.apifestvefecha.core.interfaces.repositorios.IFestivosRepositorio;
import apifestivefecha.apifestvefecha.core.interfaces.servicios.IFestivoServicio;

@Service
public class FestivoServicio implements IFestivoServicio{

    private IFestivosRepositorio repositorio;

        public FestivoServicio(IFestivosRepositorio repositorio) {
        this.repositorio = repositorio;
        }

        @Override
        public List<Festivos> listar() {
         return repositorio.findAll();
        }


        @Override
        public Festivos buscar(int dia,int mes) {
        return repositorio.findByDiaAndMes( dia, mes);
        }

         public Date createDate(int dia, int mes,int anio) {
            //Crear una instancia de Calendar para obtener el año actual
            Calendar calendario = Calendar.getInstance();

          //  Establecer la fecha según los parámetros
            calendario.set(Calendar.YEAR, anio);
            calendario.set(Calendar.MONTH, mes - 1); // Restar 1 porque los meses son base 0 en Calendar
            calendario.set(Calendar.DAY_OF_MONTH, dia);
        
            // Obtener un objeto Date a partir del Calendar
        return calendario.getTime();
        }
   
       /*  @Override
        public boolean aprobarFestivo(int dia, int mes,int anio) {
        Festivos festivo = repositorio.findByDiaAndMes(dia, mes);

         if (festivo != null && festivo.getIdtipo().getId() == 1) {
            return true; // Es un festivo fijo
            } else {
               List<Festivos> todosLosFestivos = repositorio.findAll();
               for (Festivos f : todosLosFestivos) {
                 if (f.getIdtipo().getId() == 2) {
                    Date fechaFestivo = ServicioFechas.createDate(f.getDia(), f.getMes(),anio);
                    Date siguienteLunes = ServicioFechas.siguienteLunes(fechaFestivo);

                    Calendar calendario = Calendar.getInstance();
                    calendario.setTime(siguienteLunes);
                    int diaLunes = calendario.get(Calendar.DAY_OF_MONTH);
                    int mesLunes = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                        if (diaLunes == dia && mesLunes == mes) {
                        return true;
                        } 
                        }
                        else if (f.getIdtipo().getId() == 3) {
                             Calendar calendario = Calendar.getInstance();
                             //anio= calendario.get(Calendar.YEAR);
                             Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getDomingoRamos(anio), 7);
                            Date fechaFestivo = ServicioFechas.agregarDias(domingoPascua, f.getPascua());
    
                            calendario.setTime(fechaFestivo);
                            int diaFestivo = calendario.get(Calendar.DAY_OF_MONTH);
                            int mesFestivo = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                            if (diaFestivo == dia && mesFestivo == mes) {
                            return true;
                            }
                        } else if (f.getIdtipo().getId() == 4)  {
                                Calendar calendario = Calendar.getInstance();
                                //anio = calendario.get(Calendar.YEAR);
                                Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getDomingoRamos(anio), 7);
                                Date fechaFestivo = ServicioFechas.siguienteLunes(ServicioFechas.agregarDias(domingoPascua, f.getPascua()));
        
                                calendario.setTime(fechaFestivo);
                                 int diaFestivo = calendario.get(Calendar.DAY_OF_MONTH);
                                int mesFestivo = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                                if (diaFestivo == dia && mesFestivo == mes) {
                                return true;
                                }
                            }
                }
                
            }
            return false;
        }*/
       
@Override
public boolean aprobarFestivo(int dia, int mes, int anio) {
    if (!ServicioFechas.esFechaValida(dia, mes, anio)) {
        return false; // La fecha no es válida
    }

    Festivos festivo = repositorio.findByDiaAndMes(dia, mes);

    if (festivo != null && festivo.getIdtipo().getId() == 1) {
        return true; // Es un festivo fijo
    } else {
        List<Festivos> todosLosFestivos = repositorio.findAll();
        for (Festivos f : todosLosFestivos) {
            if (f.getIdtipo().getId() == 2) {
                Date fechaFestivo = ServicioFechas.createDate(f.getDia(), f.getMes(), anio);
                Date siguienteLunes = ServicioFechas.siguienteLunes(fechaFestivo);

                Calendar calendario = Calendar.getInstance();
                calendario.setTime(siguienteLunes);
                int diaLunes = calendario.get(Calendar.DAY_OF_MONTH);
                int mesLunes = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                if (diaLunes == dia && mesLunes == mes) {
                    return true;
                }
            } else if (f.getIdtipo().getId() == 3) {
           
                Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getDomingoRamos(anio),7);
                Date fechaFestivo = ServicioFechas.agregarDias(domingoPascua, f.getPascua());
                
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(fechaFestivo);
                int diaFestivo = calendario.get(Calendar.DAY_OF_MONTH);
                int mesFestivo = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                if (diaFestivo == dia && mesFestivo == mes) {
                    return true;
                }
            } else if (f.getIdtipo().getId() == 4) {
            
                Date domingoPascua = ServicioFechas.agregarDias(ServicioFechas.getDomingoRamos(anio), 7);
                Date fechaFestivo = ServicioFechas.siguienteLunes(ServicioFechas.agregarDias(domingoPascua, f.getPascua()));

                Calendar calendario = Calendar.getInstance();
                calendario.setTime(fechaFestivo);
                int diaFestivo = calendario.get(Calendar.DAY_OF_MONTH);
                int mesFestivo = calendario.get(Calendar.MONTH) + 1; // Mes en Calendar es 0-indexed
                if (diaFestivo == dia && mesFestivo == mes) {
                    return true;
                }
            }
        }
    }
    return false;
} 
    
    
}
