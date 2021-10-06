package lyd.learn.springboot.controller;


import lyd.learn.springboot.entity.ServerSettings;
import lyd.learn.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
public class GetController {
    private Map<String, Object> params = new HashMap<>();
    /**
     * 功能描述：测试restful(自己看)协议  从路径中获得字段
     * @param cityId
     * @param userId
     * @return
     */
/*@RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id")String cityId,
                           @PathVariable("user_id")String userId){
    params.clear();
    params.put("cityID",cityId);
    params.put("userID",userId);

    return params;
}*/

    /**
     * 功能： 测试GetMapping
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载");
        System.out.println("热加载2");
        System.out.println("热加载3");
        return params;
    }

    /**
     * 功能描述： 默认值 是否必须的参数
     *
     * @param from
     * @param size
     * @return
     */

    @GetMapping(value = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;
    }

    /**
     * 功能描述： bean对象传参
     * 注意 1.注意需指定http头为 content-type 为application/json
     * 2.使用body传输数据
     *
     * @param user
     * @return 这里测试有问题 之前的一个类重开项目以后没写上好像  往前翻也没翻到。domain里的User
     */

    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 功能：测试获取Http头信息
     *
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);

        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request) {
        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);

        return params;

    }


    @Autowired
    private ServerSettings serverSettings;


    @GetMapping("/v1/test_properties")
    public Object testProperties() {

        return serverSettings; // 这里有问题。 注解不对劲

    }
}
