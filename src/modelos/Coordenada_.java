package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T14:29:01.991-0300")
@StaticMetamodel(Coordenada.class)
public class Coordenada_ {
	public static volatile SingularAttribute<Coordenada, Integer> id;
	public static volatile SingularAttribute<Coordenada, Float> x;
	public static volatile SingularAttribute<Coordenada, Float> y;
	public static volatile SingularAttribute<Coordenada, Ruta> Ruta;
}
