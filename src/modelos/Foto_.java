package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T14:29:01.993-0300")
@StaticMetamodel(Foto.class)
public class Foto_ {
	public static volatile SingularAttribute<Foto, Integer> id;
	public static volatile SingularAttribute<Foto, String> nombre;
	public static volatile SingularAttribute<Foto, String> tipo;
	public static volatile SingularAttribute<Foto, String> contenido;
	public static volatile SingularAttribute<Foto, Ruta> Ruta;
}
