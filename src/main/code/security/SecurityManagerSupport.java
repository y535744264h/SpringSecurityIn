package security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SecurityManagerSupport implements UserDetailsService {
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //因为太麻烦 所以不打算连数据库
        List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        //模拟从数据库中取出对必须是ROLE_开头的，不然spring security不认账的
        SimpleGrantedAuthority auth1=new SimpleGrantedAuthority("ROLE_ADMIN");
        SimpleGrantedAuthority auth2=new SimpleGrantedAuthority("ROLE_USER");
        System.out.println("===userName"+username+"===");
        if(username.equals("admin")){
            auths=new ArrayList<GrantedAuthority>();
            auths.add(auth1);
        }else if(username.equals("user")){
            auths=new ArrayList<GrantedAuthority>();
            auths.add(auth2);
        }
        //                  账号      密码
        User user=new User(username,"yanhao",true,true,true,true,auths);
        return user;
    }
}
