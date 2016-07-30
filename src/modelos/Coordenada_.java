package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-07-30T00:59:51.525-0300")
@StaticMetamodel(Coordenada.class)
public class Coordenada_ {
	public static volatile SingularAttribute<Coordenada, Integer> id;
	public static volatile SingularAttribute<Coordenada, Double> x;
	public static volatile SingularAttribute<Coordenada, Double> y;
	public static volatile SingularAttribute<Coordenada, Ruta> ruta;
}
