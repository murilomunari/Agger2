package com.agger.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "apolice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String number;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "Client cannot be null")
    private Client client;
}
