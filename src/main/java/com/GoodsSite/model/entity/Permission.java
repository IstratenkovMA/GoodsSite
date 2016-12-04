package com.GoodsSite.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "permission_name",unique = true, nullable = false)
    private String permissionName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "webUserPermission")
    private List<WebUser> users;

    public Permission() {
    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<WebUser> getUsers() {
        return users;
    }

    public void setUsers(List<WebUser> users) {
        this.users = users;
    }
}
