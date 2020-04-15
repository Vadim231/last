package kz.itstep.DTO;

import kz.itstep.entity.Role;
import kz.itstep.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDTO {
    private int id;
    private String login;
    private String fio;
    private String roleTitle;

    public UserDTO(User user, String roleTitle) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.fio = user.getSurname()+" "+user.getName();
        this.roleTitle = roleTitle;
    }

    public int getId() { return id;}

    public void setId(int id) {this.id = id;}

    public String getLogin() { return login; }

    public void setLogin(String login) {this.login = login; }

    public String getFio() {return fio; }

    public void setFio(String fio) {this.fio = fio; }

    public String getRoleTitle() {return roleTitle;}

    public void setRoleTitle(String roleTitle) {this.roleTitle = roleTitle;}

    public static List<UserDTO> map(List<User> users, List<Role> roles) {
        List<UserDTO> userDTOList = new ArrayList<>();
        Map<Integer, String> roleMap = new HashMap<>();
        for (Role role1 : roles) {
            roleMap.put(role1.getId(), role1.getName());
        }
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user, roleMap.get(user.getRoleId()));
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
