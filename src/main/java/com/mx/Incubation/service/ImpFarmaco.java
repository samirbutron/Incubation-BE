package com.mx.Incubation.service;

import com.mx.Incubation.dto.FarmaciaDto;
import com.mx.Incubation.dto.FarmacoDto;
import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.entity.Farmaco;
import com.mx.Incubation.petition.Petition;
import com.mx.Incubation.repository.FarmacoDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpFarmaco implements FarmacoMethods {

  @Autowired
  FarmacoDao farmacoDao;

  @Autowired
  ImpFarmacia impFarmacia;

  @Override
  public Respuesta save(Farmaco farmaco) {
    Farmaco farmacoBuscado = farmacoDao.findById(farmaco.getId()).orElse(null);
    if (farmacoBuscado != null) {
      return new Respuesta("ERROR", "Este ID de farmaco ya esta registrado", farmacoBuscado,
          false);
    } else if (farmacoExists(farmaco)) {
      farmacoBuscado = farmacoDao.findByNombreAndMarcaAndStockAndPrecioAndCaducidad(
          farmaco.getNombre(), farmaco.getMarca(), farmaco.getStock(),
          farmaco.getPrecio(), farmaco.getCaducidad());
      return new Respuesta("ERROR",
          "Este farmaco ya esta registrado con otro ID", farmacoBuscado, false);
    }
    farmacoDao.save(farmaco);
    return new Respuesta("EXITO", "El farmaco se registró exitosamente", farmaco, true);
  }

  /**
   * Ya que la clase Farmaco es la que tiene acceso a la tercera tabla Es necesario cargar los
   * elementos con los que tiene relacion manualmente (para este caso)
   */
  @Override
  public Respuesta update(Farmaco farmaco) {
    Farmaco farmacoBuscado = farmacoDao.findById(farmaco.getId()).orElse(null);
    if (farmacoBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el farmaco con este ID", null, false);
    }
    if (!(farmacoBuscado.getId() == farmaco.getId())) {
      return new Respuesta("ERROR", "El ID del farmaco no se puede cambiar", farmacoBuscado,
          false);
    }
    farmaco.setFarmacias(farmacoBuscado.getFarmacias());
    farmacoDao.save(farmaco);
    return new Respuesta("EXITO", "El farmaco se actualizó exitosamente", farmaco, true);
  }


  @Override
  public Respuesta delete(Farmaco farmaco) {
    Farmaco farmacoBuscado = farmacoDao.findById(farmaco.getId()).orElse(null);
    if (farmacoBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el farmaco con este número de ID", null,
          false);
    }
    farmacoDao.delete(farmaco);
    return new Respuesta("EXITO", "El farmaco se eliminó exitosamente", farmacoBuscado, true);
  }

  @Override
  public Respuesta search(Farmaco farmaco) {
    Farmaco farmacoBuscado = farmacoDao.findById(farmaco.getId()).orElse(null);
    if (farmacoBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el farmaco con este ID", null, false);
    }
    FarmacoDto farmacoDto = new FarmacoDto(farmacoBuscado);
    return new Respuesta("EXITO", "El farmaco se encontró exitosamente", farmacoDto, true);
  }

  public Respuesta searchByMarca(Farmaco farmaco) {
    Farmaco farmacoBuscado = farmacoDao.findById(farmaco.getId()).orElse(null);
    if (farmacoBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el farmaco con este ID", null, false);
    }
    FarmacoDto farmacoDto = new FarmacoDto(farmacoBuscado);
    return new Respuesta("EXITO", "El farmaco se encontró exitosamente", farmacoDto, true);
  }

  @Override
  public Respuesta show() {
    List<Farmaco> farmacos = farmacoDao.findAll();
    if (farmacos.isEmpty()) {
      return new Respuesta("EXITO", "No existen farmacos en el registro", null, true);
    }
    List<FarmacoDto> farmacoDtoList = new ArrayList<>();
    for (Farmaco farmaco : farmacos) {
      farmacoDtoList.add(new FarmacoDto(farmaco));
    }
    return new Respuesta("EXITO", "Se encontraron los siguientes farmacos", farmacoDtoList, true);
  }

  private boolean farmacoExists(Farmaco farmaco) {
    Farmaco searchedFarmaco = farmacoDao.findByNombreAndMarcaAndStockAndPrecioAndCaducidad(
        farmaco.getNombre(), farmaco.getMarca(), farmaco.getStock(),
        farmaco.getPrecio(), farmaco.getCaducidad());
    return searchedFarmaco != null;
  }

  public Respuesta createRelationship(Petition peticion) {
    Farmaco searchedFarmaco = farmacoDao.findById(peticion.getFarmaco_id()).orElse(null);
    if (searchedFarmaco == null) {
      return new Respuesta("ERROR", "El farmaco no existe", null, false);
    }

    // Verificar si la farmacia ya está asociada al farmaco
    boolean alreadyAssociated = searchedFarmaco.getFarmacias().stream()
        .anyMatch(f -> f.getId() == peticion.getFarmacia_id());

    if (alreadyAssociated) {
      return new Respuesta("ERROR", "El farmaco ya está asociado a esta farmacia", null, false);
    }

    FarmaciaDto searchedFarmacia = (FarmaciaDto) impFarmacia.search(
        new Farmacia(peticion.getFarmacia_id())).getObj();

    if (searchedFarmacia != null) {
      // Se encontró la farmacia, la agregamos a la lista de farmacias asociadas al farmaco
      searchedFarmaco.getFarmacias().add(
          new Farmacia(searchedFarmacia.getId(), searchedFarmacia.getCiudad(),
              searchedFarmacia.getColonia(),
              searchedFarmacia.getCalle(), searchedFarmacia.getNumero()));

      farmacoDao.save(searchedFarmaco);
      return new Respuesta("EXITO", "El farmaco y farmacia se asociaron en tabla", searchedFarmacia,
          true);
    } else {
      // No se encontró la farmacia
      return new Respuesta("ERROR", "La farmacia no existe", null, false);
    }
  }

  public Respuesta deleteRelationship(Petition peticion) {
    Farmaco foundFarmaco = farmacoDao.findById(peticion.getFarmaco_id()).orElse(null);
    if (foundFarmaco == null) {
      return new Respuesta("ERROR", "El farmaco no existe", null, false);
    }

    Farmacia foundFarmacia = foundFarmaco.getFarmacias().stream()
        .filter(f -> f.getId() == peticion.getFarmacia_id())
        .findFirst()
        .orElse(null);

    if (foundFarmacia == null) {
      return new Respuesta("ERROR", "La farmacia no está asociada a este farmaco", null, false);
    }

    foundFarmaco.getFarmacias().remove(foundFarmacia);
    farmacoDao.save(foundFarmaco);

    return new Respuesta("EXITO", "El farmaco y la farmacia se desasociaron correctamente",
        foundFarmacia, true);
  }
}
