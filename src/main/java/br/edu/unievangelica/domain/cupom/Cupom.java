package br.edu.unievangelica.domain.cupom;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table(name="cupom")
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cupom_id_seq")
    @SequenceGenerator(name = "cupom_id_seq", sequenceName = "cupom_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String name;

    @NotNull
    private int amount;
    private Boolean isUsed = false;
}
