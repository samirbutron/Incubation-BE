package com.mx.Incubation.service;

import com.mx.Incubation.dto.FarmaciaDto;
import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.repository.FarmaciaDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpFarmacia implements FarmaciaMethods {

  @Autowired
  FarmaciaDao farmaciaDao;

  @Override
  public Respuesta save(Farmacia farmacia) {
    Farmacia farmaciaBuscada = farmaciaDao.findById(farmacia.getId()).orElse(null);
    if (farmaciaBuscada != null) {
      return new Respuesta("ERROR", "Este ID ya esta registrado", farmaciaBuscada,
          false);
    } else if (farmaciaExistente(farmacia)) {
      farmaciaBuscada = farmaciaDao.findByCiudadAndColoniaAndCalleAndNumero(
          farmacia.getCiudad(), farmacia.getColonia(),
          farmacia.getCalle(),
          farmacia.getNumero());
      return new Respuesta("ERROR",
          "Esta farmacia ya esta registrado con otro ID", farmaciaBuscada, false);
    }
    farmaciaDao.save(farmacia);
    return new Respuesta("EXITO", "La farmacia se registró exitosamente", farmacia, true);
  }

  @Override
  public Respuesta update(Farmacia farmacia) {
    Farmacia farmaciaBuscada = farmaciaDao.findById(farmacia.getId()).orElse(null);
    if (farmaciaBuscada == null) {
      return new Respuesta("ERROR", "No se encontró la farmacia con este ID", null,
          false);
    }
    if (farmaciaBuscada.getId() != farmacia.getId()) {
      return new Respuesta("ERROR", "El ID no se puede cambiar", farmaciaBuscada,
          false);
    }
    if (farmaciaExistente(farmacia)) {
      return new Respuesta("EXITO", "Este farmacia se guardo sin cambios",
          farmaciaBuscada, true);
    }
    farmaciaDao.save(farmacia);
    return new Respuesta("EXITO", "La farmacia se actualizó exitosamente", farmacia, true);
  }

  @Override
  public Respuesta delete(Farmacia farmacia) {
    Farmacia farmaciaBuscada = farmaciaDao.findById(farmacia.getId()).orElse(null);
    if (farmaciaBuscada == null) {
      return new Respuesta("ERROR", "No se encontró la farmacia con este ID", null,
          false);
    } else if (!farmaciaBuscada.getFarmacos().isEmpty()) {
      //No se puede eliminar completamente una
      return new Respuesta("ERROR", "No se puede eliminar una farmacia con farmacos",
          farmaciaBuscada,
          false);
    }
    farmaciaDao.delete(farmacia);
    return new Respuesta("EXITO", "La farmacia se eliminó exitosamente", farmacia, true);
  }

  @Override
  public Respuesta search(Farmacia farmacia) {
    Farmacia farmaciaBuscada = farmaciaDao.findById(farmacia.getId()).orElse(null);
    if (farmaciaBuscada == null) {
      return new Respuesta("ERROR", "No se encontró la farmacia con este ID", null,
          false);
    }
    FarmaciaDto farmaciaDto = new FarmaciaDto(farmaciaBuscada);
    return new Respuesta("EXITO", "La farmacia se encontró exitosamente", farmaciaDto, true);
  }

  @Override
  public Respuesta show() {
    List<Farmacia> farmacias = farmaciaDao.findAll();
    if (farmacias.isEmpty()) {
      return new Respuesta("EXITO", "No existen farmacias en el registro", null, true);
    }
    List<FarmaciaDto> farmaciaDtoList = new ArrayList<>();
    for (Farmacia farmacia : farmacias) {
      farmaciaDtoList.add(new FarmaciaDto(farmacia));
    }
    return new Respuesta("EXITO", "Se encontraron las siguientes farmacias", farmaciaDtoList, true);
  }

  private boolean farmaciaExistente(Farmacia farmacia) {
    Farmacia searchedFarmacia = farmaciaDao.findByCiudadAndColoniaAndCalleAndNumero(
        farmacia.getCiudad(),
        farmacia.getColonia(), farmacia.getCalle(),
        farmacia.getNumero());
    return searchedFarmacia != null;
  }
}
