package com.tedbilgar.cookapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "NOTICE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    @ManyToMany(mappedBy = "noticeEntitySet")
    private Set<UserEntity> users = new HashSet<>();

}
