package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.controllers.FacturaLineaController;
import com.mitienda.spring.models.Factura;
import com.mitienda.spring.models.FacturaLinea;
/*
import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;
*/
public class menuFacturas {

	private boolean salir;
	private int opcion;

	public Scanner keyboard = new Scanner(System.in);
	List<Factura> facturasLista = new ArrayList<>();
	FacturaController ctrl = FacturaController.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	List<com.mitienda.spring.models.Clientes> clientesLista = new ArrayList<>();

	public menuFacturas() {

	}

	public void iniciando() throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�_FACTURAS~~~~~~~~~\n");
			System.out.println("1.-A�adir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("A�adir\n");
				// a�adirFacturas();
				crearFac();
				break;
			case 2:
				System.out.println("Leer\n");// leerFacturas();
				readFac();
				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarFacturas();
				actualizaFac();
				break;
			case 4:
				System.out.println("VUELTA AL MENU MAIN\n");// eliminarFacturas();
				deleteFacturas();
				break;
			case 5:
				System.out.println("ATR�S\n");// salirApp();

				salir = true;
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}

	public void crearFac() throws ParseException {
		com.mitienda.spring.models.Factura fc = new com.mitienda.spring.models.Factura();
		System.out.println("Teclee la fecha de la neuva factura dd/MM/yyyy :");
		String fecha = keyboard.nextLine();
		//fc.setFecha(sdf.parse(fecha));
		fc.setFecha(null);
		com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();

		facturasLista = ctrl.list();
		for (int i = 0; i < clientesLista.size(); i++) {
			System.out.println(clientesLista.get(i) + " " + clientesLista.get(i));
		}
		
		System.out.println("Teclee el id del cliente de la factura :");
		int idCl = Integer.parseInt(keyboard.nextLine()); 
		fc.setId_cliente((idCl));
		
		
		
		System.out.println("Teclee la serie de la factura :");
		String serie = keyboard.nextLine();
		fc.setSerie(Integer.parseInt(serie));

		ctrl.save(fc);
		System.out.println("Listo, el apso de introducir una factura realizado");

	}

	public void readFac() {
		com.mitienda.spring.models.Factura fl = new com.mitienda.spring.models.Factura();
		facturasLista = ctrl.list();
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que leer espabila");
		} else {

			facturasLista = ctrl.list();
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}
		}

	}

	public void actualizaFac() throws ParseException {
		com.mitienda.spring.models.Factura fc= new com.mitienda.spring.models.Factura();
		facturasLista = ctrl.list();
		fc = null;
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que actualizar espabila");
		} else {
			
			String updateNombre;
			String opcion;
			System.out.println("que quieres actualizar capullo");
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}

			updateNombre = keyboard.nextLine();
			// fc = (Factura)fc.getByid(Integer.parseInt(updateNombre));

			for (com.mitienda.spring.models.Factura dbObject : facturasLista) {
				com.mitienda.spring.models.Factura f = (com.mitienda.spring.models.Factura) dbObject;
				if (f.getId().equals(Integer.parseInt(updateNombre))) {
					fc = f;
					break;
				}
			}
			if(fc == null) {
				actualizaFac();
				return;
			}
			
			//fc = (Factura) facturasLista.get(Integer.parseInt(updateNombre));
			System.out.println("Teclee la fecha de la neuva factura dd/MM/yyyy :");
			String fecha = keyboard.nextLine();
			//fc.setFecha(sdf.parse(fecha));
			fc.setFecha(null);
			
			
			com.mitienda.spring.models.Clientes cl = new com.mitienda.spring.models.Clientes();

			facturasLista = ctrl.list();
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i) + " " + facturasLista.get(i));
			}
			
			System.out.println("Teclee el id del cliente de la factura :");
			int idCl = Integer.parseInt(keyboard.nextLine()); 
			fc.setId_cliente((idCl));
			System.out.println("Teclee la serie de la factura :");
			String serie = keyboard.nextLine();
			fc.setSerie(Integer.parseInt(serie));
			// System.out.println("introduce el nuevo nombre");
			// opcion = keyboard.nextLine();
			// int cambiaNombre = Integer.parseInt(opcion);
			// fc.setNombre(opcion);
			ctrl.save(fc);
			// DbController.getInstance().doUpdate(fc);

			// cat.setNombre(opcion);
			// cat.save();;

		}
	}

	public void deleteFacturas() {
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {
			com.mitienda.spring.models.Factura fc = new com.mitienda.spring.models.Factura();
			String deleteando;
			System.out.println("que quieres borrar ");
			facturasLista = ctrl.list();
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);

			ctrl.delete(facturasLista.get(delete));
		}
	}

}
