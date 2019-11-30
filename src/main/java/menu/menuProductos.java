package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.controllers.ProductController;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;

public class menuProductos {

	private boolean salir;
	private int opcion;


	ProductController ctrl = ProductController.getInstance();
	public Scanner keyboard = new Scanner(System.in);
	List<com.mitienda.spring.models.Producto> productosLista = new ArrayList<>();
	List<com.mitienda.spring.models.Categoria> categoriasLista = new ArrayList<>();

	public menuProductos() {

	}

	public void display() {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�_PRODUCTOS~~~~~~~~~\n");
			System.out.println("1.-A�adir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("A�adir\n");
				crearPrd();
				// a�adirProductos();
				break;
			case 2:
				System.out.println("Leer\n");
				// leerProductos();
				readPrd();
				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarProductos();
				actualizaPrdo();
				break;
			case 4:
				System.out.println("Eliminar\n");// elminiarProductos();
				deleteProductos();
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

	public void crearPrd() {
		com.mitienda.spring.models.Producto pro = new com.mitienda.spring.models.Producto();
		System.out.println("Teclee el nombre del nuevo producto :");
		String productoNuevo = keyboard.nextLine();
		pro.setNombre(productoNuevo);

		com.mitienda.spring.models.Categoria cat = new com.mitienda.spring.models.Categoria();
		categoriasLista = ctrl.list();
		for (int i = 0; i < categoriasLista.size(); i++) {
			System.out.println(categoriasLista.get(i).getId() + " " + categoriasLista.get(i));
		}

		System.out.println("teclee el id de la cateogira del producto");
		int idCat = Integer.parseInt(keyboard.nextLine()); 
		pro.setId_categoria(idCat);
		
		System.out.println("teclee el precio del produicto");
		String precio = keyboard.nextLine();
		pro.setPrecio(Integer.parseInt(precio));
		System.out.println("introduce el stock de productos");
		String stcokproducto = keyboard.nextLine();
		pro.setStock(Integer.parseInt(stcokproducto));

ctrl.save(pro);
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readPrd() {
		com.mitienda.spring.models.Producto prd = new com.mitienda.spring.models.Producto();
		productosLista = ctrl.list();

		if (productosLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que mostrar espabila");
		} else {
			productosLista = ctrl.list();
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			}
		}

	}

	public void actualizaPrdo() {
		
		
		com.mitienda.spring.models.Producto prd = new com.mitienda.spring.models.Producto();
		productosLista = ctrl.list();
		prd = null;
		if (productosLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que actualizar espabila");
		} else {

			
			String updateNombre;
			String nombre;
			System.out.println("que quieres actualizar capullo \n");
		 
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			} 

			updateNombre = keyboard.nextLine();
			//(Producto) productosLista.get(Integer.parseInt(updateNombre));
			
			for (com.mitienda.spring.models.Producto dbObject : productosLista) {
				com.mitienda.spring.models.Producto p = (com.mitienda.spring.models.Producto) dbObject;
				if (p.getId().equals(Integer.parseInt(updateNombre))) {
					prd = p;
					break;
				}
			}
			if(prd == null) {
				actualizaPrdo();
				return;
			}

			// prd = (Producto) productosLista.get(Integer.parseInt(updateNombre));
			System.out.println("introduce el nuevo nombre");
			nombre = keyboard.nextLine();
			prd.setNombre(nombre);
			
			com.mitienda.spring.models.Categoria cat = new com.mitienda.spring.models.Categoria();
			categoriasLista = ctrl.list();
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println(categoriasLista.get(i).getId() + " " + categoriasLista.get(i));
			}

			System.out.println("teclee el id de la cateogira del producto");
			int idCat = Integer.parseInt(keyboard.nextLine());
			prd.setId_categoria(idCat);

			System.out.println("teclee el precio del produicto");
			String precio = keyboard.nextLine();
			prd.setPrecio(Integer.parseInt(precio));
			System.out.println("introduce el stock de productos");
			String stcokproducto = keyboard.nextLine();
			prd.setStock(Integer.parseInt(stcokproducto));

			// int cambiaNombre = Integer.parseInt(opcion);
			prd.setNombre(nombre);
			ctrl.save(prd);
			// DbController.getInstance().doUpdate(prd);

			// cat.setNombre(opcion);
			// cat.save();;

		}
	}

	public void deleteProductos() {

		if (productosLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {

			com.mitienda.spring.models.Producto prd = new com.mitienda.spring.models.Producto();
			String deleteando;
			System.out.println("que quieres borrar ");
			productosLista = ctrl.list();
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);

			ctrl.delete(productosLista.get(delete));

		}
	}
}
