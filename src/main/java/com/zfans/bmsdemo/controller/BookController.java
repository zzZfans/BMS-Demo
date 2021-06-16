package com.zfans.bmsdemo.controller;

import com.zfans.bmsdemo.entity.vo.BookVo;
import com.zfans.bmsdemo.group.Create;
import com.zfans.bmsdemo.group.Update;
import com.zfans.bmsdemo.ret.R;
import com.zfans.bmsdemo.service.BookService;
import com.zfans.bmsdemo.util.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Zfans
 * @DateTime 2021/6/16 12:31
 */
@Api(tags = "图书")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @ApiOperation("新增图书")
    @PostMapping("insert")
    public R insert(@ApiParam(value = "图书Vo对象", required = true)
                    @RequestBody @Validated(Create.class) BookVo bookVo) {
        return bookService.insert(bookVo) ?
                R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation("删除图书")
    @DeleteMapping("delete/{id}")
    public R deleteById(@ApiParam(value = "图书id", required = true)
                        @PathVariable Long id) {
        return bookService.deleteById(id) ?
                R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @ApiOperation("修改图书")
    @PutMapping("update")
    public R update(@ApiParam(value = "图书Vo对象", required = true)
                    @RequestBody @Validated(Update.class) BookVo bookVo) {
        return bookService.update(bookVo) ?
                R.ok().message("更新成功") : R.error().message("更新失败");
    }

    @ApiOperation("获取图书列表")
    @GetMapping("list")
    public R list() {
        return R.ok().data("bookList", bookService.selectAll());
    }

    @ApiOperation("获取图书分页列表")
    @GetMapping("list/{pageNum}/{pageSize}")
    public R page(@ApiParam(value = "第几页", required = true) @PathVariable int pageNum,
                  @ApiParam(value = "每页记录数", required = true) @PathVariable int pageSize) {
        PageResult pageResult = bookService.selectOfPage(pageNum, pageSize);
        return pageResult != null ?
                R.ok().data("data", pageResult) : R.error().message("查询失败");
    }

}
