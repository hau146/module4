package com.example.thi_module_4.controller;

import com.example.thi_module_4.dto.DanhMucDto;
import com.example.thi_module_4.dto.TinTucDto;
import com.example.thi_module_4.model.DanhMuc;
import com.example.thi_module_4.model.TinTuc;
import com.example.thi_module_4.service.IDanhMucService;
import com.example.thi_module_4.service.ITinTucService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TinTucController {
    @Autowired
    private IDanhMucService danhMucService;

    @Autowired
    private ITinTucService tinTucService;

    @GetMapping("")
    public String showAll(@RequestParam(defaultValue = "0", required = false) int page,
                          @RequestParam(defaultValue = "", required = false) String tieuDe,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        Pageable pageable = PageRequest.of(page, 1);
        Page<TinTuc> tinTucPage = tinTucService.findAll(pageable, tieuDe);
        List<DanhMuc> danhMucList = danhMucService.findAll();
        model.addAttribute("tinTucPage", tinTucPage);
        model.addAttribute("danhMucList", danhMucList);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        TinTucDto tinTucDto = new TinTucDto();
        DanhMucDto danhMucDto = new DanhMucDto();
        model.addAttribute("tinTucDto", tinTucDto);
        List<DanhMuc> danhMucList = danhMucService.findAll();
        model.addAttribute("danhMucList", danhMucList);
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute TinTucDto tinTucDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (tinTucDto.getNgayDang().equals("")) {
            tinTucDto.setNgayDang(null);
        }
        new TinTucDto().validate(tinTucDto, bindingResult);
        List<DanhMuc> danhMucList = danhMucService.findAll();
        model.addAttribute("danhMucList", danhMucList);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            TinTuc tinTuc = new TinTuc();
            BeanUtils.copyProperties(tinTucDto, tinTuc);
            tinTucService.save(tinTuc);
            redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
            return "redirect:/";
        }
    }

    @GetMapping("/detail")
    public String showFormDetail(@RequestParam int id,
                                 Model model) {
        TinTuc tinTuc = tinTucService.findById(id);
        TinTucDto tinTucDto = new TinTucDto();
        BeanUtils.copyProperties(tinTuc, tinTucDto);
        model.addAttribute("tinTucDto", tinTucDto);
        return "/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        TinTuc tinTuc = tinTucService.findById(id);
        tinTucService.delete(tinTuc);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/";
    }

}
