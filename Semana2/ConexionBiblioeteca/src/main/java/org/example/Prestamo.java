package org.example;

import java.sql.Date;

public class Prestamo {
    private int id;
    private int idCliente;
    private Date fecha;

    public Prestamo(int id, int idCliente, Date fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Préstamo #" + id + " al cliente " + idCliente + " el " + fecha;
    }
}

