import java.util.Scanner;

public class AIEP_tarea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar datos al usuario
        System.out.println("Tarea AIEP Java Calculo despacho (Cecilia Caro)");
        System.out.println("----------------------------------------");
        int montoCompra = 0;
		int distancia = 0;
		while (montoCompra <= 0) {
			System.out.print("Ingrese el monto de la compra (en pesos): ");
			montoCompra = scanner.nextInt();
		}
		while (distancia <= 0) {
			System.out.print("Ingrese la distancia de entrega (en kilómetros): ");
			distancia = scanner.nextInt();
		}

        
        // Mostrar resultados
        System.out.println("\nResumen del despacho:");
        System.out.println("Monto de compra: $" + montoCompra);
        System.out.println("Distancia de entrega: " + distancia + " km");
		// Calcular costo de entrega
        int costoEntrega = calcularCostoEntrega(montoCompra, distancia);
        
        if (costoEntrega == 0 && montoCompra>0) {
            System.out.println("Costo de entrega: GRATIS");
        } else {
            System.out.println("Costo de entrega: $" + costoEntrega);
        }
        
        System.out.println("Total a pagar: $" + (montoCompra + costoEntrega));
        
        scanner.close();
    }
    
    public static int calcularCostoEntrega(int montoCompra, int distancia) {
        int costoEntrega = 0;
        
        // Caso 1: Compra igual o mayor a $50,000 y distancia menor o igual a 20 km
        if (montoCompra >= 50000 && distancia <= 20) {
            costoEntrega = 0; // Entrega gratuita
        }
        // Caso 2: Compra igual o mayor a $50,000 pero distancia mayor a 20 km
        else if (montoCompra >= 50000 && distancia > 20) {
            // Se cobra $75 por cada km adicional después de los 20 km
            costoEntrega = 75 * (distancia - 20);
			System.out.println("Valor por cada Km adicional " + (distancia - 20) + " : $ 75");
        }
        // Caso 3: Compra entre $25,000 y $49,999
        else if (montoCompra >= 25000 && montoCompra < 50000) {
            costoEntrega = 150 * distancia;
			System.out.println("Valor por cada Km : $ 150");

        }
        // Caso 4: Compra mayor a 0 y <= $24,999
        else if (montoCompra>=1 && montoCompra <= 24999) {
            costoEntrega = 300 * distancia;
			System.out.println("Valor por cada Km : $ 150");
        } else {
			costoEntrega=0;
		}
        
        return costoEntrega;
    }
}