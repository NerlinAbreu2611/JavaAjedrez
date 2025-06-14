package Modelo;

import java.util.Objects;

public class FichaModelo {
    private String nombre;
    private String equipo;
    private int x;
    private int y;

    @Override
    public String toString() {
        return "FichaModelo{" +
                "nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public FichaModelo(String nombre, String equipo, int x, int y) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaModelo that = (FichaModelo) o;
        return x == that.x && y == that.y && Objects.equals(nombre, that.nombre) && Objects.equals(equipo, that.equipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, equipo, x, y);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
