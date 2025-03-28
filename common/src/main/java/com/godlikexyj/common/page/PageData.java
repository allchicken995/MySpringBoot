package com.godlikexyj.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author xyj godlikexyj@gmail.com
 */
@Data
@Schema(description = "分页数据")
public class PageData<T> implements Serializable {
    @Schema(description = "总记录数")
    private int total;

    @Schema(description = "总页数")
    private int pages;

    @Schema(description = "列表数据")
    private List<T> list;

    /**
     * 分页
     *
     * @param list  列表数据
     */
    public PageData(IPage page, List<T> list) {
        this.list = list;
        this.total = (int) page.getTotal();
        this.pages = (int) page.getPages();
    }
}