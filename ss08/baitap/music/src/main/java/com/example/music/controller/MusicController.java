package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.dto.MusicDto;
import com.example.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping("")
    public String findAll(Model model){
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList",musicList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute MusicDto musicDto,
                         RedirectAttributes redirectAttributes,
                         BindingResult bindingResult){
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            musicService.create(music);
            redirectAttributes.addFlashAttribute("mess", "Thêm bài hát thành công");
            return "redirect:/create";
        }
    }
    @GetMapping("/update")
    public String update(@RequestParam int id, Model model){
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "update";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute MusicDto musicDto,
                         RedirectAttributes redirectAttributes,
                         BindingResult bindingResult) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/update";
        } else {

            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.update(music);
            redirectAttributes.addFlashAttribute("mess", "sửa thành công");
            return "redirect:/";
        }
    }
}
