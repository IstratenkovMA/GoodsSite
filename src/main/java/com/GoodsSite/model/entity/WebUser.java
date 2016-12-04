package com.GoodsSite.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "web_user")
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "web_user_id")
    private Long userId;

    @Column(name = "web_user_login")
    private String webUserLogin;

    @Column(name = "web_user_password")
    private String webUserPassword;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission webUserPermission;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWebUserLogin() {
        return webUserLogin;
    }

    public void setWebUserLogin(String webUserLogin) {
        this.webUserLogin = webUserLogin;
    }

    public String getWebUserPassword() {
        return webUserPassword;
    }

    public void setWebUserPassword(String webUserPassword) {
        this.webUserPassword = webUserPassword;
    }

    public Permission getWebUserPermission() {
        return webUserPermission;
    }

    public void setWebUserPermission(Permission webUserPermission) {
        this.webUserPermission = webUserPermission;
    }
}
