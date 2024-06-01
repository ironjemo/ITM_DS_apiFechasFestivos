package apifestivefecha.apifestvefecha.core.dominio;

//import java.time.LocalDate;
//import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivos {

    @Id  // Indica el campo que actua como la clave primaria en la entidad   

    @GeneratedValue(strategy = GenerationType.AUTO,generator = "secuencia_festivos")// Define como se genera el valor del identificador

    @GenericGenerator(name="secuencia_festivos",strategy = "increment")//

    //mapear los campos de la clase a una columna en la base de datos
    @Column(name = "id") 
    private int id;

    @Column(name = "nombre", length = 100, unique = true)
    private String nombre;


    @Column(name = "dia")
    private int dia;

    @Column(name = "mes")
    private int mes;

    @Column(name = "diaspascua")
    private int pascua;

    



    @ManyToOne // Se define la relacion entre entidades
    @JoinColumn(name = "idtipo", referencedColumnName = "id")// Especifica la columna de la clave foránea y la relación en la base de datos.

    private Tipo idtipo;

    public Festivos() {  //Constructor vacio
    }

    public Festivos(int id, int dia, int mes, String nombre, int pascua,Tipo idtipo) {// Constructor parametrizado
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.pascua = pascua;
        
        this.idtipo=idtipo;
    }

    // Metodos geters and seters

    public Tipo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipo idtipo) {
        this.idtipo = idtipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPascua() {
        return pascua;
    }

    public void setPascua(int pascua) {
        this.pascua = pascua;
    }

    
    

    
}

  

    


