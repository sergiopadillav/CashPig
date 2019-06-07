package sergio.villasenor.padilla.cashpig.entidades;

public class Gastos {

    private Integer idGastos;
    private Integer idUsuario;
    private Float Cantidad;
    private String categoria;
    private Boolean tipo;
    private String fecha;

    public Gastos(Integer idGastos, Integer idUsuario, Float cantidad, String categoria, Boolean tipo, String fecha) {
        this.idGastos = idGastos;
        this.idUsuario = idUsuario;
        Cantidad = cantidad;
        this.categoria = categoria;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Integer getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(Integer idGastos) {
        this.idGastos = idGastos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Float cantidad) {
        Cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
