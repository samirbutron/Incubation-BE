package com.mx.Incubation.service;

import com.mx.Incubation.dto.ClienteDto;
import com.mx.Incubation.dto.HotelDto;
import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.entity.Hotel;
import com.mx.Incubation.petition.Petition;
import com.mx.Incubation.repository.HotelDao;
import com.mx.Incubation.response.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpHotel implements HotelMethods {

  @Autowired
  HotelDao hotelDao;

  @Autowired
  ImpCliente impCliente;

  @Override
  public Respuesta save(Hotel hotel) {
    Hotel hotelBuscado = hotelDao.findById(hotel.getNumeroSucursal()).orElse(null);
    if (hotelBuscado != null) {
      return new Respuesta("ERROR", "Este numero de sucursal de hotel ya esta registrado",
          hotelBuscado,
          false);
    } else if (clientExists(hotel)) {
      hotelBuscado = hotelDao.findByCiudadAndEstadoAndColoniaAndCalleAndNumeroAndCodigoPostal(
          hotel.getCiudad(), hotel.getEstado(), hotel.getColonia(),
          hotel.getCalle(), hotel.getNumero(), hotel.getCodigoPostal());
      return new Respuesta("ERROR",
          "Este hotel ya esta registrado con otro numero de sucursal", hotelBuscado, false);
    }
    hotelDao.save(hotel);
    return new Respuesta("EXITO", "El hotel se registró exitosamente", hotel, true);
  }

  @Override
  public Respuesta update(Hotel hotel) {
    Hotel hotelBuscado = hotelDao.findById(hotel.getNumeroSucursal()).orElse(null);
    if (hotelBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el hotel con este numero de sucursal", null,
          false);
    }
    if (hotelBuscado.getNumeroSucursal() != hotel.getNumeroSucursal()) {
      return new Respuesta("ERROR", "El numero de sucursal del hotel no se puede cambiar",
          hotelBuscado,
          false);
    }
    System.out.println(hotel);
    hotelDao.save(hotel);
    return new Respuesta("EXITO", "El hotel se actualizó exitosamente", hotel, true);
  }


  @Override
  public Respuesta delete(Hotel hotel) {
    Hotel hotelBuscado = hotelDao.findById(hotel.getNumeroSucursal()).orElse(null);
    if (hotelBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el hotel con este número de numero de sucursal",
          null,
          false);
    }
    hotelDao.delete(hotel);
    return new Respuesta("EXITO", "El hotel se eliminó exitosamente", hotel, true);
  }

  @Override
  public Respuesta search(Hotel client) {
    Hotel hotelBuscado = hotelDao.findById(client.getNumeroSucursal()).orElse(null);
    if (hotelBuscado == null) {
      return new Respuesta("ERROR", "No se encontró el hotel con este numero de sucursal", null,
          false);
    }
    HotelDto hotelDto = new HotelDto(hotelBuscado);
    return new Respuesta("EXITO", "El hotel se encontró exitosamente", hotelDto, true);
  }

  @Override
  public Respuesta show() {
    List<Hotel> hoteles = hotelDao.findAll();
    if (hoteles.isEmpty()) {
      return new Respuesta("EXITO", "No existen hoteles en el registro", null, true);
    }
    List<HotelDto> hotelDtoList = new ArrayList<>();
    for (Hotel hotel : hoteles) {
      hotelDtoList.add(new HotelDto(hotel));
    }
    return new Respuesta("EXITO", "Se encontraron los siguientes hoteles", hotelDtoList, true);
  }

  public Respuesta createRelationship(Petition peticion) {
    Hotel searchedHotel = hotelDao.findById(peticion.getHotel_numero()).orElse(null);
    ClienteDto searchedClienteDto = (ClienteDto) impCliente.search(
        new Cliente(peticion.getCliente_email())).getObj();
    if (searchedHotel != null && searchedClienteDto != null) {
      searchedHotel.getClientes().add(
          new Cliente(searchedClienteDto.getEmail(), searchedClienteDto.getNombre(),
              searchedClienteDto.getApellidoP(),
              searchedClienteDto.getApellidoM(), searchedClienteDto.getDob(),
              searchedClienteDto.getNacionalidad()));
      hotelDao.save(searchedHotel);
      return new Respuesta("EXITO", "El cliente fue asociado al hotel", searchedClienteDto,
          true);
    }
    if (searchedHotel == null) {
      return new Respuesta("ERROR", "El hotel no existe", null, false);
    } else {
      return new Respuesta("ERROR", "El cliente no existe", null, false);
    }
  }

  private boolean clientExists(Hotel hotel) {
    Hotel searchedHotel = hotelDao.findByCiudadAndEstadoAndColoniaAndCalleAndNumeroAndCodigoPostal(
        hotel.getCiudad(), hotel.getEstado(), hotel.getColonia(),
        hotel.getCalle(), hotel.getNumero(), hotel.getCodigoPostal());
    return searchedHotel != null;
  }
}
