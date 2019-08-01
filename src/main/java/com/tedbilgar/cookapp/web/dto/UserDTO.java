package com.tedbilgar.cookapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String login;
    private String firstName;
    private String secondName;
    private String occupation;

}
