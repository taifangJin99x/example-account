package com.example.account.domian;

/**
 * @className: com.example.gateway.domian-> Role
 * @description:
 * @author: tfJin
 * @createDate: 2020-12-09 11:14
 * @version: 1.0
 * @todo:
 */
public class Role {
    private Integer id;
    private String username;
    private String name;

    public Role(Integer id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public Role() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
