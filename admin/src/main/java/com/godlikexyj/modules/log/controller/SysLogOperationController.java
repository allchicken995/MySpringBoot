package com.godlikexyj.modules.log.controller;

import com.godlikexyj.common.annotation.LogOperation;
import com.godlikexyj.common.constant.Constant;
import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.utils.ExcelUtils;
import com.godlikexyj.common.utils.Result;
import com.godlikexyj.modules.log.dto.SysLogOperationDto;
import com.godlikexyj.modules.log.excel.SysLogOperationExcel;
import com.godlikexyj.modules.log.service.SysLogOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 操作日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("sys/log/operation")
@Tag(name = "操作日志")
public class SysLogOperationController {
    private final SysLogOperationService sysLogOperationServiceImpl;

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
            @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", required = true),
            @Parameter(name = Constant.LIMIT, description = "每页显示记录数", required = true),
            @Parameter(name = Constant.ORDER_FIELD, description = "排序字段"),
            @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)"),
            @Parameter(name = "status", description = "状态  0：失败    1：成功")
    })
    @RequiresPermissions("sys:log:operation")
    public Result<PageData<SysLogOperationDto>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
        PageData<SysLogOperationDto> page = sysLogOperationServiceImpl.page(params);
        return new Result<PageData<SysLogOperationDto>>().ok(page);
    }

    @GetMapping("export")
    @Operation(summary = "导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:log:operation")
    public void export(@Parameter(hidden = true) @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysLogOperationDto> list = sysLogOperationServiceImpl.list(params);
        ExcelUtils.exportExcelToTarget(response, null, "操作日志", list, SysLogOperationExcel.class);
    }

}