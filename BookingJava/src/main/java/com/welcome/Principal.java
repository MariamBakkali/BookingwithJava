package com.welcome;

import java.util.ArrayList;

/**
 * 
 * El main para hacer pruebas de los DAO. Ejecutar como Java application, no en Server.
 *
 */

public class Principal {

	public static void main(String[] args) {


		//PRUEBAS PARA CIUDADES
		
		Ciudad ciudad = new Ciudad();
		CiudadDAO ciudadDAO = new CiudadDAO();
		
		/*
		// prueba de findOne
		ciudad = ciudadDAO.findOne("ValenCIA");
		if(ciudad == null){
			
			System.out.println("Ciudad no existe");
		} else {
			System.out.println(ciudad.getIdCiudad());
			System.out.println(ciudad.getNombreCiudad());
		}
	*/
		
		
		// prueba de findAll
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		ciudades = ciudadDAO.findAll();
		
		for(Ciudad x : ciudades) {
			System.out.println(x.getIdCiudad());
			System.out.println(x.getNombreCiudad());
		}
		
		
		/*
		// prueba de delete
		//System.out.println(ciudadDAO.delete(4));
		System.out.println(ciudadDAO.delete("Andorra"));
		*/
		
		/*
		// prueba update
		System.out.println(ciudadDAO.update(4,"Andorra la vella"));
		*/
		
		
		/*
		// PRUEBAS PARA HOTELES
		Hotel hotel = new Hotel();
		HotelDAO hotelDAO = new HotelDAO();
		*/
		/*
		// prueba de add
		hotel.setNombreHotel("Mugroso");
		System.out.println(hotelDAO.add(hotel));
		*/
		
		/*
		// prueba de findOne
		hotel = hotelDAO.findOne("mugros");
		if(hotel == null){
			System.out.println("Hotel no existe");
		} else {
			System.out.println(hotel.getIdHotel());
			System.out.println(hotel.getNombreHotel());
		}
		*/
		
		/*
		// prueba de findAll
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		
		hoteles = hotelDAO.findAll();
		
		for(Hotel x : hoteles) {
			System.out.print(x.getIdHotel() + " - ");
			System.out.println(x.getNombreHotel());
		}
		*/
		
		/*
		// prueba de delete
		System.out.println(hotelDAO.delete(12));
		//System.out.println(hotelDAO.delete("pepito"));
		*/
		
		/*
		// prueba update
		System.out.println(hotelDAO.update(9,"Les Closes Hotel"));
		*/
		
		/*
		// PRUEBAS PARA DESCUENTOS
		Descuento descuento = new Descuento();
		DescuentoDAO descuentoDAO = new DescuentoDAO();
		*/
		/*
		// prueba de add
		descuento.setNombreDescuento("cliente VIP");
		descuento.setPorcentajeDescuento(50);
		System.out.println(descuentoDAO.add(descuento));
		*/
		
		/*
		// prueba de findOne
		descuento = descuentoDAO.findOne("cliente vip");
		if(descuento == null){
			System.out.println("Descuento no existe");
		} else {
			System.out.print(descuento.getIdDescuento() + " - ");
			System.out.print(descuento.getNombreDescuento() + " - ");
			System.out.println(descuento.getPorcentajeDescuento());
		}
		*/
		
		/*
		// prueba de findAll
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		
		descuentos = descuentoDAO.findAll();
		
		for(Descuento x : descuentos) {
			System.out.print(x.getIdDescuento() + " - ");
			System.out.println(x.getNombreDescuento());
		}
		*/
		
		/*
		// prueba de delete
		//System.out.println(descuentoDAO.delete(4));
		System.out.println(descuentoDAO.delete("Cliente VIP"));
		 */
		
		/*
		// prueba update
		System.out.println(descuentoDAO.update(4,"VIP",50));
		*/
		/*
		// PRUEBAS PARA RESERVAS
		Reserva reserva = new Reserva();
		ReservaDAO reservaDAO = new ReservaDAO();
		
		// prueba de add
		
		Date fecha = new Date(122,4,23);
		reserva.setFechaRes((fecha));
		reserva.setPasajerosRes(2);
		reserva.setIdUsuario(4);
		reserva.setIdViajes(6);
		System.out.println(reservaDAO.add(reserva));
		*/
		
	}

}