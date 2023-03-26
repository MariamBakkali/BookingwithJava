package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class TestSesionServlet
 * 
 * 
 */
public class TestSesionServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	    public void TestSessionServlet() {
	      }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	         
	        HttpSession session = request.getSession();
	         
	        PrintWriter writer = response.getWriter();
	        writer.println(" ID Única de la sesión: " + session.getId());
	        writer.println("Creation Time: " + new Date(session.getCreationTime()));
	        writer. println("Última conexión: " + new Date(session.getLastAccessedTime()));
	    
	    
	    }
	    
	    
	    
	   /* public static void contra() {
	        //Registro de usuarios
	        int numUsers;
	        int i;
	        int passw[]= {000,000,000,000,000,};
	        String users[]= {"Sin datos","Sin datos","Sin datos","Sin datos","Sin datos"};
	        int tempP;//Contraseña temporal para evaluar con el array
	        String tempU;//Usuario temporal para evaluar con el array
	        int tries=1;//Contador de intentos

	        System.out.println("Cuántos usuarios deseas registrar?");
	        numUsers=s.nextInt();
	        for(i=1;i<=numUsers;i++) {
	            System.out.println("Ingresa el nombre del usuario "+i);
	            users[i]=s.next();
	            System.out.println("Ingresa la contraseña del usuario "+users[i]);
	            passw[i]=s.nextInt();
	            System.out.println("Usuario registrado con éxito!");
	        }
	        //Autenticación de los usuarios
	        do {
	            for(i=1;i<=numUsers;i++){
	                System.out.println("Ingresa el nombre del usuario");
	                tempU=s.next();
	                if(tempU.equals(users[i])) {
	                    System.out.println("Ingresa la contraseña del usuario "+tempU);
	                    tempP=s.nextInt();
	                    if(tempP==passw[i]) { 
	                        System.out.println("Acceso concedido!");
	                        /*while(dec!=1||dec!=2) {
	                            System.out.println("Cómo deseas ingresar los datos?\n 1)TECLADO\n 2)ARGUMENTOS");
	                            dec=s.nextInt();
	                            switch(dec) {
	                            case 1:
	                                KeyIn.main(null);
	                                menu();
	                                break;
	                            case 2:
	                                ArgIn.main(null);
	                                menu();
	                                break;
	                                default:
	                                    System.out.println("Se esperaba una opción válida");
	                                    continue;

	                            }
	                            break;
	                        }*//*
	                    }
	                    else {
	                        System.out.println("Contraseña incorrecta");
	                        tries++;
	                        continue;
	                    }
	                }
	                else {
	                    System.out.println("Usuario incorrecto");
	                    tries++;
	                    continue;
	                }
	        continue;
	        }
	    break;
	    }while(tries<=5);//Después de 5 intentos el programa se detiene

	    }*/
	}