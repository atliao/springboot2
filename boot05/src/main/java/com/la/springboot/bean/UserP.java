package com.la.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LA
 * @date 2022-10-14-17:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
public class UserP {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
