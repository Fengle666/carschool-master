package com.singulee.carschool.controller;

import com.singulee.carschool.pojo.Cart;
import com.singulee.carschool.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lishuai
 * Date: 2019/03/19
 * Description:
 * Version: V1.0
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * 添加车辆
     * @param cart
     * @return
     */
    @RequestMapping(value = "/addCart")
    @ResponseBody
    public Map<String,Object> addcart(@RequestBody Cart cart){
        return  cartService.addCart(cart);

    }

    /**
     * 多条件查询车辆
     * @param cart
     * @return
     */
    @RequestMapping(value = "/getCartList")
    @ResponseBody
    public Map<String,Object> getCartList(@RequestBody(required = false) Cart cart){
        return  cartService.selectbyCondiction(cart);
    }

    /**
     * 通过id查看
     * @param map
     * @return
     */
    @RequestMapping(value = "/getCartDetail")
    @ResponseBody
    public Map<String,Object> getCarDetail(@RequestBody(required = false) Map map){
        return cartService.selectbyId(map.get("carId").toString());
    }
    /**
     * 修改车辆信息
     * @param cart
     * @return
     */
    @RequestMapping(value = "/updateCart")
    @ResponseBody
    public Map<String,Object> updateCar(@RequestBody(required = false) Cart cart){
        return cartService.updateCar(cart);
    }

    /**
     *
     * @param cart
     * @return
     */
    @RequestMapping(value = "/removeCar")
    @ResponseBody
    public Map<String,Object> removeCar(@RequestBody(required = false) Cart cart){
        return cartService.removeCart(cart);
    }








}
