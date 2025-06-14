package Modelo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class Partida {
    private int id;
    private Timestamp fecha;

    public boolean isTurnoBlanco() {
        return turnoBlanco;
    }

    public void setTurnoBlanco(boolean turnoBlanco) {
        this.turnoBlanco = turnoBlanco;
    }

    private boolean turnoBlanco;

    public Partida(int id, Timestamp fecha, boolean turnoBlanco) {
        this.id = id;
        this.fecha = fecha;
        this.turnoBlanco = turnoBlanco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return id == partida.id && turnoBlanco == partida.turnoBlanco && Objects.equals(fecha, partida.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, turnoBlanco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
