package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(name="trabajador")
public class Trabajador {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;			
		
		@Column(name = "nombre")
		private String nombre;		
		
		public enum trabajo {
			programador, quimico, biologo, geologo
		}
		
		@Enumerated(EnumType.STRING)
		@Column(name = "trabajo")
		private trabajo trabajo;		 
		
		public Trabajador() {
						
		}
		
		public Trabajador(long id, String nombre, trabajo trabajo) {
			
			this.id = id;
			this.nombre = nombre;
			this.trabajo = trabajo;			
		}

		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}	

		public trabajo getTrabajo() {
			return trabajo;
		}

		public void setTrabajo(trabajo trabajo) {
			this.trabajo = trabajo;
		}

		@Override
		public String toString() {
			return "Trabajador [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + "]";
		}
		
		
		
		
}
