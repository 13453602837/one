package com.leyou.item.mapper;

import com.leyou.item.entity.TbBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 品牌表，一个品牌下有多个商品（spu），一对多关系 Mapper 接口
 * </p>
 *
 * @author HM
 * @since 2019-08-27
 */
public interface TbBrandMapper extends BaseMapper<TbBrand> {

}
