package pe.edu.cibertec.appwebventas.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.cibertec.appwebventas.model.bd.pk.OrderDetailId;

@Data @NoArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderdetailsid;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "discount")
    private Double discount;

}
