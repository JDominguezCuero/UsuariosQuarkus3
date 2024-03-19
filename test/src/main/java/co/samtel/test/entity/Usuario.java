package co.samtel.test.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idtbl_user")
    private Long id;
    @Column (name = "tbl_name")
    private String name;
    @Column (name = "tbl_lastname")
    private String lastname;
    @Column (name = "tbl_createat")
    private LocalDate createat;

}
