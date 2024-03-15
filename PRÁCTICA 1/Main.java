import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String, Automovil> bst = new BinarySearchTree<String, Automovil>(new StringComparator<String>());
        String marca, linea, placa;
        int modelo;
        double precio;

        marca = "Toyota";
        modelo = 2020;
        linea = "Corolla";
        precio = 25000.0;
        placa = "PQR123";
        Automovil auto1 = new Automovil(marca, modelo, linea, precio);
        bst.insert(placa, auto1);

        marca = "Chevrolet";
        modelo = 2019;
        linea = "Spark";
        precio = 15000.0;
        placa = "ABC123";
        Automovil auto2 = new Automovil(marca, modelo, linea, precio);
        bst.insert(placa, auto2);

        marca = "Mazda";
        modelo = 2018;
        linea = "3";
        precio = 18000.0;
        placa = "XYZ123";
        Automovil auto3 = new Automovil(marca, modelo, linea, precio);
        bst.insert(placa, auto3);

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la información de los automóviles");
        System.out.println("Ingrese SALIR para terminar");

        while (true) {
            System.out.println("Ingrese la marca del automóvil");
            marca = sc.nextLine();
            if (marca.toUpperCase().equals("SALIR")) {
                break;
            }
            System.out.println("Ingrese el modelo del automóvil");
            modelo = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese la línea del automóvil");
            linea = sc.nextLine();
            System.out.println("Ingrese el precio del automóvil");
            precio = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese la placa del automóvil");
            placa = sc.nextLine();
            Automovil auto = new Automovil(marca, modelo, linea, precio);
            bst.insert(placa.toUpperCase(), auto);
        }

        System.out.println("\nIngrese la placa del automóvil a buscar");
        placa = sc.nextLine();
        Automovil auto = bst.find(placa.toUpperCase());
        if (auto != null) {
            System.out.println("\nDatos del automóvil");
            System.out.println("Marca: " + auto.getMarca());
            System.out.println("Modelo: " + auto.getModelo());
            System.out.println("Línea: " + auto.getLinea());
            System.out.println("Precio: " + auto.getPrecio());
            System.out.println("Placa: " + placa + "\n");
        } else {
            System.out.println("El automóvil no existe");
        }

        sc.close();
    }      
}