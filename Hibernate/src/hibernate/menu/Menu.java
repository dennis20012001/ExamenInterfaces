package hibernate.menu;

import java.util.List;
import java.util.Scanner;

import hibernate.gestor.GestorDepartamento;
import hibernate.gestor.GestorEmpleados;
import primero.Departamentos;
import primero.Empleados;

public class Menu {
	public Menu() {
		teclado = new Scanner(System.in);
	}

	private Scanner teclado = null;

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > 5));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Mostrar el contemido de la tabla departamentos");
		System.out.println("---- 2 - Mostrar los campos de los empleados del departamentos 10");
		System.out.println("---- 3 - Buscar Cuenta");
		System.out.println("---- 4 - Insertar Cuenta");
		System.out.println("---- 5 - Borrar Cuenta ");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			mostrarTodosLosEmpleadosConElDeptno10();
			break;
		case 2:
			mostrarEmpleadoConElMaximoSalario();
			break;
		case 3:
			mostrarDepartConeElNombreContabilibidadOInvestigacion();
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}

	}

	public static void verTodosLosDepartamentos(List<Empleados> list) {
		try {
			if (list != null) {
				for (Empleados empleados : list) {
					System.out.println("-------------------------------------");
					System.out.println("Apellido - " + empleados.getApellido());
					System.out.println("Oficio - " + empleados.getOficio());
					System.out.println("Salario - " + empleados.getSalario());
					System.out.println("-------------------------------------");
				}
			} else {
				System.out.println("No hay ningun empleados en BBDD.");
			}
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());

		}

	}

	private void mostrarTodosLosEmpleadosConElDeptno10() {
		verTodosLosDepartamentos(devolverTodosLosDepartamentos());
	}

	private List<Empleados> devolverTodosLosDepartamentos() {
		GestorEmpleados gestorEmpleado= new GestorEmpleados();
		return gestorEmpleado.getAll();
	}
	//------------------------------------------------------------------------
	public static void verEmpleadoConElMaximoSalario(List<Empleados> list) {
		try {
			if (list != null) {
				for (Empleados empleados : list) {
					System.out.println("-------------------------------------");
					System.out.println("Apellido - " + empleados.getApellido());
					System.out.println("Salario - " + empleados.getSalario());
					System.out.println("Departamento nº - " + empleados.getDepartamentos());
					System.out.println("-------------------------------------");
				}
			} else {
				System.out.println("No hay ningun empleados en BBDD.");
			}
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());

		}

	}

	private void mostrarEmpleadoConElMaximoSalario() {
		verEmpleadoConElMaximoSalario(devolverEmpleadoConMaximoSalario());
	}

	private List<Empleados> devolverEmpleadoConMaximoSalario() {
		GestorEmpleados gestorEmpleado= new GestorEmpleados();
		return gestorEmpleado.getEmpleadoWithMaxSalary();
	}
	//------------------------------------------------------------------------
		public static void verDepartamentoConContabilidadYInvestigacion(List<Departamentos> list) {
			try {
				if (list != null) {
					for (Departamentos departamentos : list) {
						System.out.println("-------------------------------------");
						System.out.println("Numeor de Departamento - " + departamentos.getDeptNo());
						System.out.println("Nombre - " + departamentos.getDnombre());
						System.out.println("Localizacion - " + departamentos.getLoc());
						System.out.println("-------------------------------------");
					}
				} else {
					System.out.println("No hay ningun empleados en BBDD.");
				}
			} catch (Exception e) {
				System.out.println("Error generico - " + e.getMessage());

			}

		}

		private void mostrarDepartConeElNombreContabilibidadOInvestigacion() {
			verDepartamentoConContabilidadYInvestigacion(devolverDepartConeElNombreContabilibidadOInvestigacion());
		}

		private List<Departamentos> devolverDepartConeElNombreContabilibidadOInvestigacion() {
			GestorDepartamento gestorDepartamento= new GestorDepartamento();
			return gestorDepartamento.getDepartContabilidadOrInvestigacion();
		}
}
