package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T14:29:01.994-0300")
@StaticMetamodel(Puntaje.class)
public class Puntaje_ {
	public static volatile SingularAttribute<Puntaje, Integer> id;
	public static volatile SingularAttribute<Puntaje, Integer> puntos;
	public static volatile SingularAttribute<Puntaje, String> fecha;
	public static volatile SingularAttribute<Puntaje, Ruta> Ruta;
}
