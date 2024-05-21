package apifestivefecha.apifestvefecha.aplicacion;
import java.util.Calendar;
import java.util.Date;

//import apifestivefecha.apifestvefecha.core.dominio.Festivos;


public class ServicioFechas {

   @SuppressWarnings("unused")
 public static Date getDomingoRamos(int año){
   
    int a = año % 19;
    int b = año % 4 ;
    int c = año % 7 ;
    int d = (19*a+24) % 30; 
    
    int dias = d + (2*b+4*c+6*d+5) % 7; 

    int dia = 15 + dias;
    int mes = 3;
    if(dia>31){

        dia=(dias-31);
        mes=4;
    }
    //return new Date(año-1900,mes-1,dia);
    //return null;
    return null;
   }

 public static Date agregarDias(Date fecha, int dias){
    Calendar calendario= Calendar.getInstance();
    calendario.setTime(fecha); // le asignamos una fecha a la clase calendario con setTime
    calendario.add(Calendar.DATE, dias);

    return calendario.getTime();
 }

 public static Date siguienteLunes(Date fecha){
    Calendar calendario = Calendar.getInstance();
    calendario.setTime(fecha);
    
    if(calendario.get(Calendar.DAY_OF_WEEK)> Calendar.MONDAY){
        fecha=agregarDias(fecha, 9-calendario.get(Calendar.DAY_OF_WEEK));

    }else{

        fecha=agregarDias(fecha, 1);
    }

    return fecha;

 }
 public static Date createDate(int dia, int mes) {
    Calendar calendario = Calendar.getInstance();
    calendario.set(Calendar.MONTH, mes - 1);
    calendario.set(Calendar.DAY_OF_MONTH, dia);
    return calendario.getTime();
}  

  
}
