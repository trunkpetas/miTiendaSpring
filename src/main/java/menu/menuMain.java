package menu;

import java.text.ParseException;
import java.util.Scanner;

public class menuMain {

	

	public menuMain() {

	}

	public static void  iniciando() throws ParseException{
		 boolean salir;
		int opcion;
		Scanner keyboard = new Scanner(System.in);
		
		//if(opcion ==)
		
		do {
			System.out.println("~~~~~~~~~~MEN�~~~~~~~~~\n");
			System.out.println("1.-Productos\n2.-Clientes\n3.-Categorias\n4.-Facturas\n5.-FacturasLinea\n6.-Salir\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			
			opcion = Integer.parseInt(keyboard.nextLine());

			menuCategoria mC = new menuCategoria();
			menuClientes mCl = new menuClientes();
			menuFacturas mF = new menuFacturas();
			menuProductos mP = new menuProductos();
			menuFactura_lineas mfl = new menuFactura_lineas();
			switch (opcion) {
			
			case 1:
				System.out.println("Productos\n");// productos();
				mP.iniciando();
				break;
			case 2:
				System.out.println("Clientes\n");// clientes();
				mCl.iniciando();
				break;
			case 3:
				System.out.println("Categorias\n");// categorias();
				mC.iniciando();
				break;
			case 4:
				System.out.println("Facturas\n");// facturas();
				mF.iniciando();
				break;
			case 5:
				System.out.println("Factura_Linea\n");// facturas();
				mfl.iniciando();
				break;
				
			case 6:
				System.out.println("FUERA\n");// salirApp();
				System.exit(0);

				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (true);
	}
}
