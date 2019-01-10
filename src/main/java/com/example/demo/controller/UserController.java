package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：ZYP
 * @ Date       ：Created in 17:19 2019/1/5
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */

@Api(value = "用户增删改查",description = "详细描述")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加User",notes = "添加username,password,phone",httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200,message = "ok")})
    @RequestMapping(value = "/add",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public int addUser(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true)User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "获取所有",notes = "获取所有user",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path", name = "pageNum", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="path", name = "pageSize", value = "每页数据个数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public Object findAllUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

}
