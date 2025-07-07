package dominio;

import java.util.Objects;

public class Persona {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    private String nombre;
    private int edad;
    private int numero;
    private String ci;

private static int CANT_NUMERO=1;
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.ci = "";
    }

    public Persona(String nombre, int edad, String ci) {
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
        this.numero=CANT_NUMERO++; //asigna primero a variable y luego incremeta
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", numero=" + numero +
                ", ci='" + ci + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //Característica deseable es que sea nullsafe
        //Si al equals le llega un null me tiene que dar falso para que no se caiga

        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        //return Objects.equals(ci, persona.ci);
        return ci.equals(persona.ci);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
