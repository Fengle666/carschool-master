package com.singulee.carschool.pojo;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    /**
     * 添加车量
     * @param cart
     * @return
     */
    int insert(Cart cart);

    /**
     * 修改车辆信息
     * @param cart
     * @return
     */
    int update(Cart cart);
    Cart selectByNumber(Cart cart);

    /**
     * 多条件查询
     * @param cart
     * @return
     */

    List<Map<String,Object>> selectByCondiction(Cart cart);

    /**
     * 通过ID查找
     * @param carId
     * @return
     */
    Cart selectById(String carId);

    /**
     * 修改状态
     * @param cart
     * @return
     */
    int updateStute(Cart cart);
}