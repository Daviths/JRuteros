package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-07-13T13:51:09.441-0300")
@StaticMetamodel(Ruta.class)
public class Ruta_ {
	public static volatile SingularAttribute<Ruta, Integer> id;
	public static volatile SingularAttribute<Ruta, String> nombre;
	public static volatile SingularAttribute<Ruta, String> descripcion;
	public static volatile SingularAttribute<Ruta, String> fecha_de_realizacion;
	public static volatile SingularAttribute<Ruta, String> dificultad;
	public static volatile SingularAttribute<Ruta, Actividad> actividad;
	public static volatile SingularAttribute<Ruta, Usuario> usuario;
	public static volatile SingularAttribute<Ruta, Boolean> es_publica;
	public static volatile SingularAttribute<Ruta, Boolean> es_circular;
	public static volatile SingularAttribute<Ruta, Double> distancia;
	public static volatile SingularAttribute<Ruta, Double> tiempo_estimado;
	public static volatile ListAttribute<Ruta, Foto> fotos;
	public static volatile ListAttribute<Ruta, Coordenada> coordenadas;
}
