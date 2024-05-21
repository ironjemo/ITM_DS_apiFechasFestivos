package apifestivefecha.apifestvefecha.core.dominio;

import java.time.LocalDate;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "secuencia_festivos")
    @GenericGenerator(name="secuencia_festivos",strategy = "increment")

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


    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo idtipo;

    public Festivos() {
    }

    public Festivos(int id, int dia, int mes, String nombre, int pascua,Tipo idtipo) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.pascua = pascua;
        this.idtipo=idtipo;
    }

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

    //public static boolean isEmpty() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
}

  

    


