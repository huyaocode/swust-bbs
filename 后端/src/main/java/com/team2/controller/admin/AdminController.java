package com.team2.controller.admin;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.CountInfo;
import com.team2.pojo.cmt.Category;
import com.team2.pojo.cmt.Information;
import com.team2.pojo.cmt.Report;
import com.team2.pojo.sys.User;
import com.team2.service.cmt.CategoryService;
import com.team2.service.cmt.InformationService;
import com.team2.service.cmt.ReportService;
import com.team2.service.sys.UserService;
import com.team2.utils.UserUtil;
import com.team2.vo.cmt.CategoryQuery;
import com.team2.vo.cmt.InformationQuery;
import com.team2.vo.cmt.ReportQuery;
import com.team2.vo.sys.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    public UserService userService;
    @Autowired
    public InformationService informationService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ReportService reportService;

    @RequestMapping("/login")
    public String login() {
        return "/admin/login";
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/welcome")
    public String welcome(Model model) {
        User user = UserUtil.getLoginUser();
        CountInfo countInfo = informationService.getCountInfo();
        model.addAttribute("userInfo",user);
        model.addAttribute("countInfo",countInfo);
        return "/admin/welcome";
    }


  //  @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/index")
    public String index(Model model) {
        User user = UserUtil.getLoginUser();
        model.addAttribute("user",user);
        return "/admin/index";
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value="/cateEdit")
    public String cateEdit(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "type", required = true) String type,
                           Model model) {
        //类型0：需求1：资源(字符长度为1-1)
        if(page == null) page = 1;
        CategoryQuery categoryQuery = new CategoryQuery();
        categoryQuery.setType(type);
        PageInfo<Category> cateList = categoryService.list(page,10,categoryQuery);
        model.addAttribute("cateList",cateList);
        model.addAttribute("type",Integer.valueOf(type));
        return "/admin/cateEdit";
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value="/infoDetial")
    public String cateEdit(@RequestParam(value = "id", required = false) Long id,
                           Model model) {
        Information information = informationService.getById(id);
        model.addAttribute("info",information);
        return "/admin/infoDetial";
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value="/userList")
    public String userList(@RequestParam(value = "page", required = false) Integer page,
            Model model) {
        if(page == null) page = 1;
        PageInfo<User> userList = userService.list(page,10,new UserQuery());
        model.addAttribute("userList",userList);
        return "/admin/userList";
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value="/infoList")
    public String infoList(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "type", required = true) String type,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "cateId", required = false) Long cateId,
                           Model model) {
        if(page == null) page = 1;
        InformationQuery informationQuery = new InformationQuery();
        informationQuery.setType(type);
        if(title != null){
            informationQuery.setTitle(title);
        }
        if(cateId != null && cateId >= 0){
            informationQuery.setCategoryId(cateId);
        }
        PageInfo<Information> infoList = informationService.listDetail(page,10,informationQuery);
        List<String> endTimeList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(Information info : infoList.getList()){
            if(info.getEndTime() == null){
                endTimeList.add("未设置");
            }else {
                endTimeList.add(df.format(info.getEndTime()));
            }
            if(info.getPicture() == null){
                info.setPicture("");
            }
        }
        CategoryQuery categoryQuery = new CategoryQuery();
        categoryQuery.setType(type);
        List<Category> categoryList = categoryService.listAll(categoryQuery);
        Category everyCate = new Category();
        everyCate.setName("所有分类");
        everyCate.setId(Long.valueOf(-1));
        categoryList.add(0,everyCate);
        model.addAttribute("infoList",infoList);
        model.addAttribute("endTimeList",endTimeList);
        model.addAttribute("type",Integer.valueOf(type));
        model.addAttribute("cateList",categoryList);
        return "/admin/infoList";
    }

  //  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value="/report")
    public String report(@RequestParam(value = "page", required = false) Integer page,
                           Model model) {
        if(page == null) page = 1;
        PageInfo<Report> reportList = reportService.list(page,10,new ReportQuery());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Information> infoList = new ArrayList<>();
        for(Report report : reportList.getList()){
            report.setMemo(df.format(report.getCreateTime()));
            infoList.add(informationService.getById(report.getInformationId()));
        }
        model.addAttribute("reportList",reportList);
        model.addAttribute("infoList",infoList);
        return "/admin/report";
    }
}
