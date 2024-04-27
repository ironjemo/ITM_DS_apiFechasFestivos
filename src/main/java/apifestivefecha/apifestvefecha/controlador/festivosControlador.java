package apifestivefecha.apifestvefecha.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivefecha.apifestvefecha.core.dominio.Festivos;
import apifestivefecha.apifestvefecha.core.interfaces.servicios.IFestivoServicio;

@RestController
@RequestMapping("api/diasfestivos")
public class festivosControlador {

    private IFestivoServicio servicio;

    public festivosControlador(IFestivoServicio servicio) {
     this.servicio = servicio;

    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivos> listar() {
        return servicio.listar();

    }

}
