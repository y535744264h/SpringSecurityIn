package security;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
    Log log = LogFactory.getLog(this.getClass());
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public MyInvocationSecurityMetadataSource() {
        loadResourceDefine();
    }
    private PathMatcher matcher;

    private void loadResourceDefine() {
        matcher= new AntPathMatcher();
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
        atts.add(ca);
        resourceMap.put("/admin/sayHi", atts);
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_USER");
        attsno.add(cano);
        resourceMap.put("/user/sayHi", attsno);
    }



    //参数是要访问的url，返回这个url对于的所有权限（或角色）
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 将参数转为url
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            System.out.println("===URL="+url+"RESURL="+resURL+"===");
            if (matcher.match(url, resURL)) {
                System.out.println("Yes Yes Yes");
                return resourceMap.get(resURL);
            }
        }
        System.out.println("No No No");
        return null;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
