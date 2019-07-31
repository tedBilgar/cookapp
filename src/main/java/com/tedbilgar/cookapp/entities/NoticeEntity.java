package com.tedbilgar.cookapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "NOTICE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
