package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data // con esto se hacen los getter y los setter
@Getter
@AllArgsConstructor
public class Student {
	// @Id
    // @Column(nullable = false, updatable = false)
    // @GeneratedValue(
    //         strategy = GenerationType.SEQUENCE,
    //         generator = "primary_sequence"
    // )
	private Integer id;
	private String nombre;
	private String apellido;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Student() {
		super();
	}
}
