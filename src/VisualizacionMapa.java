
import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;

/**
 * Clase para crear las instancias del mapa para visualizar el grafo.
 * @author Geovanny Gonzalez
 */

public class VisualizacionMapa extends MapView
{
	// ===========================
	// Atributos
	// ===========================

	//Ventana del Mapa.	
	private JFrame ventanaMapa;

	//Objeto Mapa de la libreria.
	private Map mapaChicago;

	private static int numeroVentana = 1;

	//Un arreglo con codigos de colores para dar estetica
	public final static String[] COLORES = {"#338AFF", "#0A4492", "#618BC5", "#6F0694", "#A649C7", "#CD43FE",
			"#DF43FE", "#FF3200", "FD562E","#AA73B5", "#9003AD", "#FFFF35", "#F0F01A", "#FFFF63", "#50940B", "#75C425", "#80FF00"};

	// ===========================
	// Constructor
	// ===========================	

	/**
	 * Permite construir el mapa para agregar los marcadores y visualizarlo en pantalla.	 
	 */

	public VisualizacionMapa() 
	{
		/**
		 * Creación y configuración del mapa.
		 */

		setOnMapReadyHandler(new MapReadyHandler()
		{			
			/**
			 * Configuración de las caracteristicas del mapa.
			 */

			public void onMapReady(MapStatus estadoMapa)
			{
				// Si la creación del mapa ha sido correcta.
				if (estadoMapa == MapStatus.MAP_STATUS_OK)
				{
					//Obtiene el mapa para crear sus caracteristicas.
					int indiceColor = 0;
					mapaChicago = getMap();
					MapOptions opcionesMapa = new MapOptions();
					opcionesMapa.setMapTypeControlOptions(new MapTypeControlOptions());
					mapaChicago.setOptions(opcionesMapa); 

					// Se centra el mapa en la zona de chicago (zona de interes).
					mapaChicago.setCenter(new LatLng(41.938708, -87.721620));					
					//Poner zoom de vista
					mapaChicago.setZoom(13.0);					

					//Agregar vertices.					

					//Vertice #1
					Marker nuevoMarcador = new Marker(mapaChicago);	//Pone el marcador en el mapa						
					LatLng coordenadas = new LatLng(41.938708, -87.721620); //Coordenadas Latitud-longitud
					nuevoMarcador.setPosition(coordenadas); //Configura y guarda la posicion											
					
					//Vertice #2
					Marker nuevoMarcador2 = new Marker(mapaChicago);	//Pone el marcador en el mapa						
					LatLng coordenadas2 = new LatLng(41.933545, -87.663890); //Coordenadas Latitud-longitud
					nuevoMarcador2.setPosition(coordenadas2); //Configura y guarda la posicion
					
					//Configuracion de la linea
					indiceColor=0;						
					PolylineOptions detallesArco = new PolylineOptions(); //Configura el grosor de la linea
					detallesArco.setStrokeOpacity(1.75);
					detallesArco.setStrokeWeight(1.5);

					//Coordenadas de la nueva linea (arco)
					LatLng[] coordenadas3 = {new LatLng(41.938708, -87.721620), new LatLng(41.933545, -87.663890)}; //Coordenadas de los vertices inicio y fin.		

					Polyline nuevoArco = new Polyline(mapaChicago); //Configura la linea en el mapa														
					nuevoArco.setPath(coordenadas3);	//Configura las coordenadas						
					detallesArco.setStrokeColor(COLORES[indiceColor]);	//Da algo de color						
					nuevoArco.setOptions(detallesArco); //Configura la caracteristicas de la instancia de la linea
					indiceColor = (indiceColor + 1) % COLORES.length; //Incremento (arreglo de colores).					
					
					//Agregar circulos para agrupar puntos
					Circle circle = new Circle(mapaChicago);
					circle.setCenter(new LatLng(41.948087, -87.734575)); //Pone la ubicación del circulo, su centro.
					circle.setRadius(250); //Radio del circulo
					CircleOptions co= new CircleOptions(); //Caracteristicas del borde del circulo
					co.setFillColor(COLORES[indiceColor]);
					co.setFillOpacity(0.5);
					indiceColor = (indiceColor + 1) % COLORES.length; 
					circle.setOptions(co);
					
					Polyline nuevoArco2 = new Polyline(mapaChicago); //Configura la linea en el mapa														
					nuevoArco2.setPath(new LatLng[]{new LatLng(41.938708, -87.721620), new LatLng(41.948087, -87.734575)});	//Configura las coordenadas						
					detallesArco.setStrokeColor(COLORES[indiceColor]);	//Da algo de color						
					nuevoArco2.setOptions(detallesArco); //Configura la caracteristicas de la instancia de la linea
					indiceColor = (indiceColor + 1) % COLORES.length; //Incremento (arreglo de colores).
					
					Circle circle2 = new Circle(mapaChicago);
					circle2.setCenter(new LatLng(41.910899, -87.646585));
					circle2.setRadius(250);					
					co.setFillColor(COLORES[indiceColor]);
					co.setFillOpacity(0.5);
					indiceColor = (indiceColor + 1) % COLORES.length; 
					circle2.setOptions(co);
					
					Polyline nuevoArco3 = new Polyline(mapaChicago); //Configura la linea en el mapa														
					nuevoArco3.setPath(new LatLng[]{new LatLng(41.933545, -87.663890), new LatLng(41.910899, -87.646585)});	//Configura las coordenadas						
					detallesArco.setStrokeColor(COLORES[indiceColor]);	//Da algo de color						
					nuevoArco3.setOptions(detallesArco); //Configura la caracteristicas de la instancia de la linea
					indiceColor = (indiceColor + 1) % COLORES.length; //Incremento (arreglo de colores).
				}				
			}
		});
	}	

	/**
	 * Permite visualizar el mapa en la pantalla.
	 * <b>post:</b> Se visualiza el mapa desde el proyecto.
	 */	

	public void visualizarMapa()
	{
		//Instancia de una ventana JFrame
		ventanaMapa = new JFrame("Mapa de Chicago - Ventana # " + numeroVentana);
		numeroVentana++; //Incrementar el numero de ventanas.
		ventanaMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMapa.setResizable(true);
		ventanaMapa.setSize(860, 432);
		ventanaMapa.add(this,BorderLayout.CENTER);
		ventanaMapa.setVisible(true);
	}
	
	public static void main(String[] args) {
		VisualizacionMapa a = new VisualizacionMapa();
		a.visualizarMapa();
	}
}
