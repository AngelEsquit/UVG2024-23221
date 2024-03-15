public class Automovil {
    private String marca;
    private int modelo;
    private String linea;
    private double precio;

    public Automovil(String marca, int modelo, String linea, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.precio = precio;
    }

    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nLinea: " + linea + "\nPrecio: " + precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
