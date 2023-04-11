package com.programa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "campo.obrigatorio")
    private String name;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "campo.obrigatorio")
    @Email(message = "E-mail inválido!")
    private String email;

    @Column(nullable = false, length = 11)
    @NotEmpty(message = "campo.obrigatorio")
    private String telephone;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "campo.obrigatorio")
    private LocalDate birth_date;
}
