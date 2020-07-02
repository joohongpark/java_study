package dto;

import java.io.Serializable;

/**
 * Member DTO : Object Definition for Cafe Members
 *
 */
/*
Table Create Query :
CREATE TABLE CAFE_MEMBER (
    MEMBER_ID VARCHAR2(30) NOT NULL PRIMARY KEY,
    MEMBER_PWD VARCHAR2(30) NOT NULL,
    MEMBER_NAME VARCHAR2(30) NOT NULL,
    MEMBER_AGE NUMBER(3) NOT NULL
)
*/

public class MemberDto implements Serializable {
    private String id;
    private String pwd;
    private String name;
    private int age;

    public MemberDto(String id, String pwd, String name, int age) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
