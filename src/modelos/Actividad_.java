package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-07-13T17:25:28.058-0300")
@StaticMetamodel(Actividad.class)
public class Actividad_ {
	public static volatile SingularAttribute<Actividad, Integer> id;
	public static volatile SingularAttribute<Actividad, String> nombre;
	public static volatile SingularAttribute<Actividad, String> descripcion;
	public static volatile SingularAttribute<Actividad, Boolean> esta_habilitada;
}
