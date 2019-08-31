package com.leyou.item.controller;

import com.leyou.common.vo.PageResult;
import com.leyou.item.entity.TbBrand;
import com.leyou.item.pojo.DTO.BrandDTO;
import com.leyou.item.service.TbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private TbBrandService brandService;

    /**
     * 品牌分页查询
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<BrandDTO>> findBypage(@RequestParam(name = "key",required = false) String key,
                                                           @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                           @RequestParam(name = "rows",defaultValue = "10") Integer rows,
                                                           @RequestParam(name = "sortBy",required = false) String sortBy,
                                                           @RequestParam(name = "desc",defaultValue = "false") Boolean desc){
        return ResponseEntity.ok(brandService.findBypage(key,page,rows,sortBy,desc));
    }

    /**
     * 保存品牌信息
     * @param brand
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> save(TbBrand brand,@RequestParam(name = "cids") List<Long> cids){
            brandService.saveBrand(brand,cids);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
