package Tienda;

import java.util.LinkedList;

import Entidad.Entidad;
import GUI.GUI;

public interface AbstractFactoryBoton   {
	
	/**
	 * Devuelve la fabrica
	 * @return AbstractFactoryBoton
	 */
	public abstract AbstractFactoryBoton getFabricaBoton();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonT1
	 */
	public abstract BotonT1 getBoton1();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonT2
	 */
	public abstract BotonT2 getBoton2();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonT3
	 */
	public abstract BotonT3 getBoton3();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonT4
	 */
	public abstract BotonT4 getBoton4();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonT5
	 */
	public abstract BotonT5 getBoton5();
	
	/**
	 * Devuelve el boton correspondiente
	 * @return BotonComprar
	 */
	public abstract BotonComprar getBotonComprar(String s);
	
	/**
	 * Realiza la acciona correspondiete del boton
	 */
	public abstract void AccionarBoton(GUI gui,LinkedList<FabricaBoton> botones);
	
	/**
	 * Realiza la accion general a todos los botones
	 */
	public abstract void Accionar(Entidad entidad,LinkedList<FabricaBoton> botones,GUI gui);
	
	
		
	
	

}
