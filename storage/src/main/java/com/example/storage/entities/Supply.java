package com.example.storage.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="supplies")
@EqualsAndHashCode
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    @Setter

    private String name;
    @Column(name="username")
    @Setter
    private String username;

}
