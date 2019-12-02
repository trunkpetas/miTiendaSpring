package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.models.Categoria;

public class menuCategoria {

	private boolean salir;
	private int opcion;
	CategoryController ctrl = CategoryController.getInstance();
	
	public Scanner keyboard = new Scanner(System.in);
	List<Categoria> categoriasLista = new ArrayList<Categoria>();

	public menuCategoria() {

	}

	public void iniciando() {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�_CATEGORIAS~~~~~~~~~\n");
			System.out.println("1.-A�adir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("A�adir\n");// a�adirCategoria();
				crearCat();
				break;
			case 2:
				System.out.println("Leer\n");// leerCategoria();
				readCat();
				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarCategoria();
				actualizaCategorias();
				break;
			case 4:
				System.out.println("Eliminar\n");// eliminarCategoria();
				deleteCategorias();
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

	public void crearCat() {

		System.out.println("Teclee el nombre de la neuva categoria :");
		String categoriaNew = keyboard.nextLine();
		Categoria cat = new Categoria();
		cat.setNombre(categoriaNew);
		ctrl.save(cat);
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readCat() {
		Categoria cat = new Categoria();
		categoriasLista = ctrl.list();

		if (categoriasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que leer espabila");
		} else {

			categoriasLista = ctrl.list();
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println(categoriasLista.get(i).getId() + "." + categoriasLista.get(i));

			}
		}

	}

	public void actualizaCategorias() {
		if (categoriasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {

			Categoria cat = new Categoria();
			String updateNombre;
			String opcion;
			System.out.println("que quieres actualizar capullo");
			categoriasLista = ctrl.list();
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println(categoriasLista.get(i).getId() + "." + categoriasLista.get(i));

			}

			updateNombre = keyboard.nextLine();
			// cat = (Categoria) cat.getByid(Integer.parseInt(updateNombre));

			cat = (Categoria) categoriasLista.get(Integer.parseInt(updateNombre));
			System.out.println("introduce el nuevo nombre");
			opcion = keyboard.nextLine();
			// int cambiaNombre = Integer.parseInt(opcion);
			cat.setNombre(opcion);
			ctrl.save(cat);
			// DbController.getInstance().doUpdate(cat);

			// cat.setNombre(opcion);
			// cat.save();;
		}
	}

	public void deleteCategorias() {

		if (categoriasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {

			Categoria cat = new Categoria();
			String deleteando;
			System.out.println("que quieres borrar ");
			categoriasLista = ctrl.list();
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println(categoriasLista.get(i).getId() + "." + categoriasLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);
	
			
			ctrl.delete(categoriasLista.get(delete));

		}
	}

}
