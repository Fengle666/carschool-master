package com.singulee.carschool.service;


import com.singulee.carschool.pojo.Cart;
import com.singulee.carschool.pojo.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lishuai
 * Date: 2019/03/19
 * Description:
 * Version: V1.0
 */
@Service
public class CartService {
    final private CartMapper cartMapper;

    @Autowired
    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    /**
     * 添加车辆信息
     *
     * @param cart
     * @return
     */
    public Map<String, Object> addCart(Cart cart) {
        Map<String, Object> map = new HashMap<>();
        //车牌检查
        if (cartMapper.selectByNumber(cart) == null) {
            if (cartMapper.insert(cart) > 0) {
                map.put("code", 200);
            }
        } else {
            map.put("code", 201);
            map.put("msg", "车牌已存在");
        }

        return map;
    }

    /**
     * 多条件查找
     *
     * @param cart
     * @return
     */
    public Map<String, Object> selectbyCondiction(Cart cart) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> cartmap = cartMapper.selectByCondiction(cart);
        if (cartmap.size() > 0) {
            map.put("code", 200);
            map.put("data", cartmap);
        } else {
            map.put("code", 201);
        }

        return map;
    }

    /**
     * 通过id查询
     *
     * @param carId
     * @return
     */
    public Map<String, Object> selectbyId(String carId) {
        Map<String, Object> map = new HashMap<>();
        Cart cart = cartMapper.selectById(carId);
        map.put("code", 200);
        map.put("data", cart);
        return map;
    }

    /**
     * 修改车辆信息
     *
     * @param cart
     * @return
     */
    public Map<String, Object> updateCar(Cart cart) {
        Map<String, Object> map = new HashMap<>();
        if (cartMapper.update(cart) > 0) {
            map.put("code", 200);
            map.put("msg", "修改成功");
        }

        return map;
    }

    /**
     * 修改车辆信息
     *
     * @param cart
     * @return
     */
    public Map<String, Object> removeCart(Cart cart) {
        Map<String, Object> map = new HashMap<>();
        Cart carttmp =cartMapper.selectById(cart.getCarid().toString());
        if(!carttmp.getStaute().equals("备用")){
            map.put("code", 201);
            map.put("msg", "车辆在使用或维修不能报废哦!");
            return map;
        }
        carttmp.setCarenddate(new Date(System.currentTimeMillis()));
        carttmp.setStaute("报废");
        if (cartMapper.update(carttmp) > 0) {
            map.put("code", 200);
            map.put("msg", "车辆已报废");
        }

        return map;
    }


}
