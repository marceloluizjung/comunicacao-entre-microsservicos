package br.com.cursoudemy.productapi.modules.supplier.model;

import br.com.cursoudemy.productapi.modules.supplier.dto.SupplierRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public static Supplier of(SupplierRequest request) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(request, supplier);
        return supplier;
    }
}
