package com.zfans.bmsdemo.controller;

import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.group.Create;
import com.zfans.bmsdemo.group.Update;
import com.zfans.bmsdemo.ret.R;
import com.zfans.bmsdemo.service.CategoryService;
import com.zfans.bmsdemo.util.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 10:41
 */
@Api(tags = "图书类型")
@RestController
@RequestMapping("/category")
public class CategoryContrlller {

    @Autowired
    CategoryService categoryService;

    @ApiOperation("新增图书类型")
    @PostMapping("insert")
    public R insert(@ApiParam(value = "图书类型对象", required = true)
                    @RequestBody @Validated(Create.class) Category category) {
        return categoryService.insert(category) ?
                R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation("删除图书类型")
    @DeleteMapping("delete/{id}")
    public R deleteById(@ApiParam(value = "图书类型id", required = true)
                        @PathVariable Long id) {
        return categoryService.deleteById(id) ?
                R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @ApiOperation("修改图书类型")
    @PutMapping("update")
    public R update(@ApiParam(value = "图书类型对象", required = true)
                    @RequestBody @Validated(Update.class) Category category) {
        return categoryService.update(category) ?
                R.ok().message("更新成功") : R.error().message("更新失败");
    }

    @ApiOperation("获取图书类型列表")
    @GetMapping("list")
    public R list() {
        return R.ok().data("categoryList", categoryService.selectAll());
    }

    @ApiOperation("获取图书类型分页列表")
    @GetMapping("list/{pageNum}/{pageSize}")
    public R page(@ApiParam(value = "第几页", required = true) @PathVariable int pageNum,
                  @ApiParam(value = "每页记录数", required = true) @PathVariable int pageSize) {
        PageResult pageResult = categoryService.selectOfPage(pageNum, pageSize);
        return pageResult != null ?
                R.ok().data("data", pageResult) : R.error().message("查询失败");
    }
}
