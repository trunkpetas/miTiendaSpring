package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.controllers.ClientesController;
/*
import src.models.Categoria;
import src.models.Clientes;
import src.models.comun.DbController;
import src.models.comun.DbObject;
*/

public class menuClientes {

	private boolean salir;
	private int opcion;
	ClientesController ctrl = ClientesController.getInstance();

	List<com.mitienda.spring.models.Clientes> clientesLista = new ArrayList<>();

	public Scanner keyboard = new Scanner(System.in);
	
	public menuClientes() {

	}

	public void display() {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�_CLIENTES~~~~~~~~~\n");
			System.out.println("1.-A�adir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("A�adir\n");// a�adirClientes();
				crearClioente();

				break;
			case 2:
				System.out.println("Leer\n");// leerClientes();
				readcl();

				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarClientes();
				actualizacl();
				break;
			case 4:
				System.out.println("Eliminar\n");// eliminarClientes();
				deletecl();
				break;
			case 5:
				System.out.println("VUELTA AL MENU MAIN\n");// salirApp();

				salir = true;
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}

	public void crearClioente() {
		com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();
		System.out.println("Teclee el nombre del nuevo cliente :");
		String nombreCliente = keyboard.nextLine();
		cl.setNombre(nombreCliente);
		System.out.println("Teclee la direccion del neuvo cliente :");
		String direccionClietne = keyboard.nextLine();
		cl.setDireccion(direccionClietne);
		System.out.println("Teclee el dni del nuevo clkiente :");
		String dni = keyboard.nextLine();
		cl.setDni(dni);
		System.out.println("Teclee el email del clente");
		String email = keyboard.nextLine();
		cl.setEmail(email);
		System.out.println("teclee el telefono del cliente");
		String telefono = keyboard.nextLine();
		cl.setTelefono(telefono);
		// System.out.println("teclee el id del cliente");
		// String id = keyboard.nextLine();
		// cl.set

		ctrl.save(cl);
		System.out.println("Listo, el apso de introducir un cliente realizado");

	}

	public void readcl() {

		com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();
		clientesLista = ctrl.list();
		if (clientesLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que leer espabila");
		} else {

			clientesLista = ctrl.list();
			for (int i = 0; i < clientesLista.size(); i++) {
				System.out.println(clientesLista.get(i) + "." + clientesLista.get(i));

			}
		}

	}

	public void actualizacl() {
		if (clientesLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que actualizar espabila");
		} else {
			com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();
			String updateNombre;

			System.out.println("que quieres actualizar capullo");
			clientesLista = ctrl.list();
			for (int i = 0; i < clientesLista.size(); i++) {
				System.out.println(clientesLista.get(i) + "." + clientesLista.get(i));

			}
			//clientesLista = cl.list();

			updateNombre = keyboard.nextLine();
			// cl = (Clientes)cl.getByid(Integer.parseInt(updateNombre));

			cl = (com.mitienda.spring.models.Clientes) clientesLista.get(Integer.parseInt(updateNombre));
			String nombre;
			System.out.println("introduce el nuevo nombre");
			nombre = keyboard.nextLine();
			// int cambiaNombre = Integer.parseInt(opcion);
			cl.setNombre(nombre);
			System.out.println("Teclee la nueva direccion del neuvo cliente :");
			String direccionClietne = keyboard.nextLine();
			cl.setDireccion(direccionClietne);
			System.out.println("Teclee el nuevo dni del nuevo clkiente :");
			String dni = keyboard.nextLine();
			cl.setDni(dni);
			System.out.println("Teclee el nuevo email del clente");
			String email = keyboard.nextLine();
			cl.setEmail(email);
			System.out.println("teclee el nuevo telefono del cliente");
			String telefono = keyboard.nextLine();
			cl.setTelefono(telefono);

			ctrl.save(cl);

			// DbController.getInstance().doUpdate(cl);

			// cat.setNombre(opcion);
			// cat.save();;
		}
	}

	public void deletecl() {

		if (clientesLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {

			com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();
			String deleteando;
			System.out.println("que quieres borrar ");
			clientesLista = ctrl.list();
			for (int i = 0; i < clientesLista.size(); i++) {
				System.out.println(clientesLista.get(i) + "." + clientesLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);
			ctrl.delete(clientesLista.get(delete));
		}
	}

}
