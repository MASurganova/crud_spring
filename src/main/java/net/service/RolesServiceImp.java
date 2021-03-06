package net.service;

import net.model.Role;
import net.model.RolesTypes;
import net.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class RolesServiceImp implements RolesService{

    public Map<String, Boolean> getAllRoles(){
        Map<String, Boolean> map = new HashMap<>();
        for(RolesTypes rolesType : RolesTypes.values()){
            map.put(rolesType.name(), false);
        }

        return map;
    }

    public Map<String, Boolean> getAllRoles(User user){
        Map<String, Boolean> map = getAllRoles();

        for(Role role: user.getRoles()){
            map.put(role.getType().name(), true);
        }

        return map;
    }

    public void setUserRoles(User user, String[] userRoles){
        Set<Role> roleSet = new HashSet<>();
        for(String userRole: userRoles){
            Role role = new Role();
            role.setType(RolesTypes.valueOf(userRole));
            roleSet.add(role);
        }
        user.setRoles(roleSet);
    }
}
