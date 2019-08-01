package com.tedbilgar.cookapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "occupation")
    private String occupation;

    /**
     * Связь Многие-Ко-Многим с таблицей Notice
     * USER <-> NOTICE
     * Обязательно делаем Lazy, если объем данных в таблице будет действительно большой >1000 записей
     * */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USERS_NOTICE_RELATION",
                joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id")},
                inverseJoinColumns = { @JoinColumn(name = "notice_id", referencedColumnName = "id") })
    private Set<NoticeEntity> noticeEntitySet;

}
