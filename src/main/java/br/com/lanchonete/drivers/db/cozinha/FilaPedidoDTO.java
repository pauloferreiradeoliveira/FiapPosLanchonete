package br.com.lanchonete.drivers.db.cozinha;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import br.com.lanchonete.drivers.db.pedido.PedidoDTO;

@Entity(name = "fila")
public class FilaPedidoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "fila")
    private List<PedidoDTO> listaPedidos;

    private LocalDate dia;

    public List<PedidoDTO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoDTO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
}
