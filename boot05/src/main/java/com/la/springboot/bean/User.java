package com.la.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LA
 * @date 2022-09-20-10:58
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String username;
    private String password;

}
