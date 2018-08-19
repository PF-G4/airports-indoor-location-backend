package afinal.proyecto.cuatro.grupo.entities;

public enum StateFlightEnum {
	EN_HORARIO(1, "EN HORARIO"),
	DEMORADO(2, "DEMORADO"),
	CANCELADO(3, "CANCELADO");
	
	private StateFlightEnum(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	private Integer id;
	private String descripcion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}