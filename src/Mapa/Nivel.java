package Mapa;

/**
 * Clase Nivel extiende Mapa .
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class Nivel extends Mapa{
	
	//Atributos de clase
		private static int N_Inicial = 1;
		private static int N_Final = 3;
		
		//Atributos de instancia
		private int N_Actual;
		
		//Constructor
		public Nivel() {
			N_Actual = N_Inicial;
		}	
		
		//Metodos
		
		/**
		 * Devuelve el nivel actual del juego
		 * @return nivel actual del juego.
		 */
		public int obtenerNivelActual(){
			return N_Actual;
		}
		
		/**
		 * Devuelve el nivel maximo del juego
		 * @return nivel maximo.
		 */
		public int obtenerNivelMax() {
			return N_Final;
		}
		
		/**
		 * Devuelve verdadero si se pudo establecer el siguiente nivel, caso contrario falso, indicando que no hay mas niveles.
		 * @return verdadero si hay avanzo de nivel, caso contrario falso.
		 */
		public boolean siguienteNivel(){
			boolean haySig = false;
			if (N_Actual < N_Final) {
				N_Actual++;
				haySig = true;
			}
			return haySig;
		}
		
		/**
		 * Carga las entidades correspondientes al juego de acuerdo al nivel actual, requiere que se establezca el siguiente nivel.
		 */
		public void cargarEntidadesAlJuego() {
			cargarEnemigos();
			cargarObstaculos();
		}
		
		//Metodos privados
		
		/**
		 * Carga los enemigos al juego.
		 */
		private void cargarEnemigos(){
		}
		
		/**
		 * Carga los obstaculos al juego.
		 */
		private void cargarObstaculos(){
		}
		
		/**
		 * Asigna los power ups a los enemigos(o al mapa hay q decidirlo);
		 *
		private void asignarPowerUps() {
			
			}*/


}
