package com.aliang.controller;

import com.aliang.pojo.Bill;
import com.aliang.pojo.BillType;
import com.aliang.service.BillService;
import com.aliang.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("bill")
public class BillController {

    @Autowired
    private BillService billService;
    @Autowired
    private TypeService typeService;

    @GetMapping("test")
    public String test(){
        return "Hello SpringBoot...";
    }

    /**
     * 分页+条件查
     * @param pageNum
     * @param pageSize
     * @param bill
     * @param model
     * @return
     */
    @GetMapping("page")
    public String getPage(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "2") int pageSize,
                           Bill bill,
                           Model model){
        List<BillType> typeList = typeService.list();
        model.addAttribute("types",typeList);

        PageInfo<Bill> pageInfo = billService.getPage(bill, pageNum, pageSize);

        model.addAttribute("page",pageInfo);
        model.addAttribute("bill",bill);
        return "/bill/list-page";
    }

    /**
     * 添加账单信息
     * @param bill
     * @return
     */
    @PostMapping("add")
    public String add(Bill bill){
        int add = billService.add(bill);
        return "redirect:/bill/page";
    }
    /**
     * 添加页面获取
     * @param model
     * @return
     */
    @GetMapping("addPage")
    public String addPage(Model model){
        //查询账单的全部类型
        List<BillType> typeList = typeService.list();
        model.addAttribute("types",typeList);
        return "/bill/add";
    }


    /**
     * 修改页面获取
     * @param id
     * @param model
     * @return
     */
    @GetMapping("updatePage/{id}")
    public String updatePage(@PathVariable("id") Long id,Model model){
        //查询账单的全部类型
        List<BillType> typeList = typeService.list();
        model.addAttribute("types",typeList);

        //根据id查询对应的数据
        Bill bill = billService.selectById(id);
        model.addAttribute("bill",bill);
        return "/bill/update";
    }

    /**
     * 提交修改信息
     * @param bill
     * @return
     */
    @PostMapping("update")
    public String update(Bill bill){
        System.out.println(bill);
        int update = billService.update(bill);
        return "redirect:/bill/page";
    }

    /**
     * 根据id删除账单信息
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        int delete = billService.delete(id);
        return "redirect:/bill/page";
    }
}
